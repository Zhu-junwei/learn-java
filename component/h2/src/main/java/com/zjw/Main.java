package com.zjw;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author 朱俊伟
 * @since 2024/03/23 13:26
 */
public class Main {

    public static void main(String[] args) {
        // db文件会保存在用户的家目录下
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/h2db/test", "sa", "")) {
            // 获取数据库版本
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("Database Version: " + meta.getDatabaseProductVersion());

            // 获取表结构
            ResultSet rs = meta.getColumns(null, null, "YOUR_TABLE_NAME", null);
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("TYPE_NAME");
                int columnSize = rs.getInt("COLUMN_SIZE");
                // 输出表结构信息
                System.out.println("Column Name: " + columnName + ", Type: " + columnType + ", Size: " + columnSize);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}