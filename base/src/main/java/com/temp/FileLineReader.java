package com.temp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLineReader {

    /**
     * 读取指定范围的行数据
     * 
     * @param filePath 文件路径
     * @param startLine 开始行（从1开始）
     * @param endLine 结束行（包含）
     * @return 指定范围的行数据
     * @throws IOException
     */
    public static List<String> readLinesInRange(String filePath, int startLine, int endLine) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 0;
            while ((line = reader.readLine()) != null) {
                currentLine++;
                if (currentLine >= startLine && currentLine <= endLine) {
                    lines.add(line);
                }
                if (currentLine > endLine) {
                    break;
                }
            }
        }
        return lines;
    }

    public static void main(String[] args) {
        String filePath = "I:/rockyou2024.txt";
        int startLine = 30000;
        int endLine = 2000;
        try {
            List<String> lines = readLinesInRange(filePath, startLine, startLine + 1000);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}