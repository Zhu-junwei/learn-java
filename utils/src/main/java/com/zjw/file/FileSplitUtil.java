package com.zjw.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件拆分工具类
 *
 * @author zjw
 * @since 2023/03/21 14:55
 */
public class FileSplitUtil {

    public static void main(String[] args) {
        splitFileByLine("D:\\系统文件夹\\Desktop\\split/1.txt", 200);
    }

    public static void splitFileByLine(String filename, int lineLength){
        splitFileByLine(filename, lineLength, false);
    }

    /**
     * 将指定的文件拆分成多个文件，每个文件最多包含指定行数
     *
     * @param filename   要拆分的文件名
     * @param lineLength 每个拆分后的文件最多包含的行数
     * @param hasHeader  是否为每个文件都添加相同的开头
     */
    public static void splitFileByLine(String filename, int lineLength, boolean hasHeader) {
        // 参数有效性检查
        if (filename == null || filename.isEmpty() || lineLength <= 0) {
            System.err.println("Invalid input parameters.");
            return;
        }

        List<String> lines = new ArrayList<>();
        int fileNum = 1; // 计数器，记录当前已经拆分出了多少个文件

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String header;
            // 读取并处理表头
            if (hasHeader && (header = reader.readLine()) != null) {
                lines.add(header);
            }

            int count = 0; // 计数器，记录当前已经处理了多少行数据
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                count++;
                if (count >= lineLength) {
                    write(filename, fileNum, lines);
                    lines.clear();
                    count = 0;
                    fileNum++;
                }
            }
            if (!lines.isEmpty()) {
                write(filename, fileNum, lines);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * 将指定的行数据写入一个新的文件中，文件名格式为“原始文件名-序号.csv”。
     *
     * @param filename 原始文件名
     * @param fileNum  当前拆分出的文件序号
     * @param lines    要写入新文件的行数据列表
     * @throws IOException 如果写入文件时出现错误，将抛出 IOException 异常。
     */
    private static void write(String filename, int fileNum, List<String> lines) throws IOException {
        String newFileName = reName(filename, fileNum);
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName)); // 创建一个 BufferedWriter 以写入新文件
        for (String line : lines) {
            writer.write(line); // 写入当前行数据
            writer.newLine(); // 换行
        }
        writer.close(); // 关闭 BufferedWriter
    }

    /**
     * 重命名文件
     *
     * @param filename 原始文件名
     * @param fileNum  文件序号
     * @return 新文件名
     */
    private static String reName(String filename, int fileNum) {
        File file = new File(filename);
        String name = file.getName();
        String newFilename;
        if (name.lastIndexOf(".") > 0) {
            String fileType = name.substring(name.lastIndexOf(".")+1);
            newFilename = String.format("%s-%d.%s", name.substring(0,name.lastIndexOf(".")), fileNum, fileType); // 新文件名格式为“原始文件名-序号.csv”
        } else {
            newFilename = String.format("%s-%d", name, fileNum); // 新文件名格式为“原始文件名-序号.txt”
        }
        newFilename = file.getParent() + File.separator + newFilename;
        return newFilename;
    }

    /**
     * 将指定的文件按行读取，并转换为指定编码格式后保存到 List 中。
     *
     * @param filename    要读取的文件名
     * @param charsetName 要使用的编码格式
     * @param blockSize   每次读取的块大小（以行为单位）
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> read(String filename, String charsetName, int blockSize) throws IOException {
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
     * 读取指定文件中的指定行，以 List 形式返回。
     *
     * @param filename    要读取的文件名。
     * @param charsetName 文件的编码格式，如 "UTF-8"
     * @param startLine   要读取的起始行（从 1 开始计数）
     * @param endLine     要读取的结束行
     * @return 读取到的行的内容组成的 List
     * @throws IOException 如果文件读取出现异常，将抛出 IOException 异常
     */
    public static List<String> read(String filename, String charsetName, int startLine, int endLine) throws IOException {
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
     * 将指定的 文件按行读取，并转换为 UTF-8 编码格式后保存到 List 中。
     *
     * @param filename  要读取的文件名
     * @param blockSize 每次读取的块大小（以行为单位）
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> read(String filename, int blockSize) throws IOException {
        return read(filename, "UTF-8", blockSize); // 默认使用 UTF-8 编码格式
    }

    /**
     * 将指定的文件按行读取，并转换为 UTF-8 编码格式后保存到 List 中。
     *
     * @param filename 要读取的件名
     * @return 保存了文件内容的 List
     * @throws IOException 如果读取文件时出现错误，将抛出 IOException 异常。
     */
    public static List<String> readToList(String filename) throws IOException {
        return read(filename, "UTF-8", Integer.MAX_VALUE); // 默认使用 UTF-8 编码格式
    }

    public static List<String> readToList(String filename, String charsetName) throws IOException {
        return read(filename, charsetName, Integer.MAX_VALUE);
    }

    public static List<String> readToList(String filename, String charsetName, int blockSize) throws IOException {
        return read(filename, charsetName, blockSize);
    }

}
