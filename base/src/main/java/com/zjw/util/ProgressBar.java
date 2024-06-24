package com.zjw.util;

/**
 * 打印一个进度条
 */
public class ProgressBar {
    public static void main(String[] args) throws Exception {
        Double total = 100.0; // 总进度
        Double current = 0.0; // 当前进度
        for (int i = 0; i <= 100; i++) {
            updateProgressBar(i * 1.0, total);
            Thread.sleep(100);
        }
    }

    public static void updateProgressBar(Double current, Double total) {
        System.out.print("\r"); // 回车，将光标移至行首
        String progressBar = getProgressBar(current, total);
        System.out.print(progressBar);
    }

    public static String getProgressBar(Double current, Double total) {
        StringBuilder sb = new StringBuilder();
        int percent = current.intValue() * 100 / total.intValue();
        int completed = current.intValue() * 20 / total.intValue();

        sb.append("[")
                .append("=".repeat(Math.max(0, completed)))
                .append(" ".repeat(Math.max(0, 20 - completed)))
                .append("] ")
                .append(percent).append("%");

        return sb.toString();
    }

}