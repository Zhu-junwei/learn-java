package com.zjw.file;

import java.io.*;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileUtils {

    /**
     * 使用BufferedReader逐行读取文本文件
     *
     * @param filePath 文件路径
     * @param charset  文件编码格式
     * @return 文件内容
     * @throws IOException
     */
    public static String readByBufferedReader(String filePath, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    /**
     * 使用Files.readAllLines读取文本文件
     *
     * @param filePath 文件路径
     * @param charset  文件编码格式
     * @return 文件内容
     * @throws IOException
     */
    public static String readByFiles(String filePath, Charset charset) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath), charset);
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * 保存字符串到指定文件
     *
     * @param str      字符串内容
     * @param fileName 文件名
     * @return 保存成功
     */
    public static boolean saveStringToFile(String str, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(str);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 计算文件大小，带单位如：4.13M
     *
     * @param filename 文件名
     * @return 文件大小
     */
    public static String getFileSize(String filename) {
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            long size = file.length();
            BigDecimal bigDecimal = new BigDecimal(size);
            DecimalFormat df = new DecimalFormat("#.00");
            String fileSizeString = "";
            if (size < 1024) {
                fileSizeString = df.format((double) size) + "B";
            } else if (size < 1048576) {
                fileSizeString = df.format(bigDecimal.divide(new BigDecimal(1024))) + "KB";
            } else if (size < 1073741824) {
                fileSizeString = df.format(bigDecimal.divide(new BigDecimal(1048576))) + "MB";
            } else if (size < 1099511627776L) {
                fileSizeString = df.format(bigDecimal.divide(new BigDecimal(1073741824))) + "GB";
            } else if (size < 1125899906842624L) {
                fileSizeString = df.format(bigDecimal.divide(new BigDecimal(1099511627776L))) + "TB";
            } else {
                fileSizeString = df.format(bigDecimal.divide(new BigDecimal(1125899906842624L))) + "PB";
            }
            return fileSizeString;
        } else {
            return null;
        }
    }

    /**
     * 获取一个文件的信息
     *
     * @param fileName 文件名
     * @return 文件信息
     */
    public static String getFileInformation(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        if (file.exists()) {
            if (file.isDirectory()) {
                sb.append("文件类型：目录" + "\n");
            } else {
                sb.append("文件类型：文件" + "\n");
            }
            sb.append("文件名：" + file.getName() + "\n");
            sb.append("文件路径：" + file.getAbsolutePath() + "\n");
            sb.append("文件大小：" + getFileSize(fileName) + " (" + file.length() + " 字节)" + "\n");
            sb.append("是否可读：" + file.canRead() + "\n");
            sb.append("是否可写：" + file.canWrite() + "\n");
            sb.append("是否可执行：" + file.canExecute() + "\n");
            sb.append("是否隐藏：" + file.isHidden() + "\n");
            try {
                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sb.append("是否为链接：" + attr.isSymbolicLink() + "\n");
                sb.append("创建时间：" + sdf.format(new Date(attr.creationTime().toMillis())) + "\n");
                sb.append("最后修改时间：" + sdf.format(new Date(attr.lastModifiedTime().toMillis())) + "\n");
                sb.append("上次访问时间：" + sdf.format(new Date(attr.lastAccessTime().toMillis())) + "\n");
            } catch (Exception e) {
            }
        } else {
            sb.append("文件不存在！" + "\n");
        }
        return sb.toString();
    }


    /**
     * 计算文件的MD5值
     *
     * @param fileName 文件
     * @return MD5值
     */
    public static String getFileMD5(String fileName) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 使用 BufferedInputStream 和大缓冲区来加速读取
            try (InputStream is = Files.newInputStream(Paths.get(fileName));
                 BufferedInputStream bis = new BufferedInputStream(is, 16 * 1024)) { // 16KB 缓冲区
                byte[] buffer = new byte[16 * 1024];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    md.update(buffer, 0, bytesRead); // 更新MD5
                }
            }

            byte[] digest = md.digest();
            // 使用String.format更快地转换为16进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b)); // 每个字节转换为两位16进制数
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 拷贝文件
     *
     * @param sourceFile 源文件路径
     * @param targetFile 目标文件路径
     * @throws IOException
     */
    public static void copy(String sourceFile, String targetFile) throws IOException {

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile);
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel();
        ) {
            int position = 0;
            long size = inChannel.size();
            while (size > 0) {
                long count = inChannel.transferTo(position, size, outChannel);
                if (count > 0) {
                    position += count;
                    size -= count;
                }
            }
        }
    }

}