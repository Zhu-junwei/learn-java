package com.zjw;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author 朱俊伟
 * @since 2024/03/23 13:26
 */
public class Main {
    public static void main(String[] a)
            throws Exception {
        Connection conn = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");
        // add application code here
        System.out.println(conn);
        conn.close();
    }
}