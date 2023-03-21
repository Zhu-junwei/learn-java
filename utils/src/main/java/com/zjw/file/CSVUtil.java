package com.zjw.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjw
 * @date 2023/03/21 14:55
 */
public class CSVUtil {

    /**
     * 将指定的 CSV 文件拆分成多个文件，每个文件最多包含指定行数，且每个文件都保留同样的表头。
     * @param filename 要拆分的 CSV 文件名
     * @param linesPerFile 每个拆分后的文件最多包含的行数
     * @throws IOException 如果读取或写入文件时出现错误，将抛出 IOException 异常。
     */
    public static void splitCSV(String filename, int linesPerFile) throws IOException {
        // 创建一个 BufferedReader 以读取指定的 CSV 文件
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String header = reader.readLine(); // 读取 CSV 表头
        List<String> lines = new ArrayList<>(); // 用于保存当前拆分文件中的行数据
        String line;
        int count = 0; // 计数器，记录当前已经处理了多少行数据
        int fileNum = 1; // 计数器，记录当前已经拆分出了多少个文件
        while ((line = reader.readLine()) != null) {
            lines.add(line); // 将当前行数据添加到列表中
            count++;
            if (count >= linesPerFile) {
                writeCSV(filename, fileNum, header, lines); // 将当前列表中的行数据写入一个新的 CSV 文件中
                lines.clear(); // 清空列表，以便保存下一批行数据
                count = 0; // 重置计数器
                fileNum++; // 将拆分出的文件计数器加 1
            }
        }
        if (!lines.isEmpty()) {
            writeCSV(filename, fileNum, header, lines); // 将列表中剩余的行数据写入最后一个 CSV 文件中
        }
        reader.close(); // 关闭 BufferedReader
    }

    /**
     * 将指定的行数据写入一个新的 CSV 文件中，文件名格式为“原始文件名-序号.csv”。
     * @param filename 原始 CSV 文件名
     * @param fileNum 当前拆分出的文件序号
     * @param header CSV 表头
     * @param lines 要写入新文件的行数据列表
     * @throws IOException 如果写入文件时出现错误，将抛出 IOException 异常。
     */
    private static void writeCSV(String filename, int fileNum, String header, List<String> lines) throws IOException {
        String newFilename = String.format("%s-%d.csv", filename, fileNum); // 新文件名格式为“原始文件名-序号.csv”
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFilename)); // 创建一个 BufferedWriter 以写入新文件
        writer.write(header); // 写入表头
        writer.newLine(); // 换行
        for (String line : lines) {
            writer.write(line); // 写入当前行数据
            writer.newLine(); // 换行
        }
        writer.close(); // 关闭 BufferedWriter
    }

    /**
     * 将指定的 CSV 文件按行读取，并转换为指定编码格式后保存到 List 中。
     * @param filename 要读取的 CSV 文件名
     * @param charsetName 要使用的编码格式
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> readCSV(String filename, String charsetName) throws IOException {
        List<String> lines = new ArrayList<>(); // 用于保存文件内容的 List
        Charset charset = Charset.forName(charsetName); // 将指定的编码格式转换为 Charset 对象
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filename)), charset))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line); // 将读取到的行添加到 List 中
            }
        }
        return lines;
    }

    /**
     * 将指定的 CSV 文件按行读取，并转换为指定编码格式后保存到 List 中。
     * @param filename 要读取的 CSV 文件名
     * @param charsetName 要使用的编码格式
     * @param blockSize 每次读取的块大小（以行为单位）
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> readCSV(String filename, String charsetName, int blockSize) throws IOException {
        List<String> lines = new ArrayList<>(); // 用于保存文件内容的 List
        Charset charset = Charset.forName(charsetName); // 将指定的编码格式转换为 Charset 对象
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filename)), charset))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                lines.add(line); // 将读取到的行添加到 List 中
                count++;
                if (count >= blockSize) {
                    count = 0;
                    break;
                }
            }
        }
        return lines;
    }

    /**
     * 读取指定 CSV 文件中的指定行，以 List 形式返回。
     * @param filename 要读取的文件名。
     * @param charsetName 文件的编码格式，如 "UTF-8"
     * @param startLine 要读取的起始行（从 1 开始计数）
     * @param endLine 要读取的结束行
     * @return  读取到的行的内容组成的 List
     * @throws IOException 如果文件读取出现异常，将抛出 IOException 异常
     */
    public static List<String> readCSV(String filename, String charsetName, int startLine, int endLine) throws IOException {
        List<String> lines = new ArrayList<>(); // 用于保存文件内容的 List
        Charset charset = Charset.forName(charsetName); // 将指定的编码格式转换为 Charset 对象
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(filename)), charset))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (count >= startLine && count <= endLine) {
                    lines.add(line); // 将读取到的行添加到 List 中
                }
                if (count > endLine) {
                    break; // 超过需要读取的范围，停止读取
                }
            }
        }
        return lines;
    }

    /**
     * 将指定的 CSV 文件按行读取，并转换为 UTF-8 编码格式后保存到 List 中。
     * @param filename 要读取的 CSV 文件名
     * @param blockSize 每次读取的块大小（以行为单位）
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> readCSV(String filename, int blockSize) throws IOException {
        return readCSV(filename, "UTF-8", blockSize); // 默认使用 UTF-8 编码格式
    }

    /**
     * 将指定的 CSV 文件按行读取，并转换为 UTF-8 编码格式后保存到 List 中。
     * @param filename 要读取的 CSV 文件名
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> readCSV(String filename) throws IOException {
        return readCSV(filename, "UTF-8"); // 默认使用 UTF-8 编码格式
    }
}
