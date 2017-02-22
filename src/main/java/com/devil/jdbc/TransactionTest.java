package com.devil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

/**
 * 事务测试
 * 
 * @author Devil
 *
 */
public class TransactionTest {
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/test";
    String USER = "root";
    String PASS = "root";
    Connection conn = null;

    @Before
    public void before() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Test
    public void testAutoCommit() throws Exception {
        Statement stmt = null;
        try {
            conn.setAutoCommit(false); // 设置关闭自动提交
            stmt = conn.createStatement();

            String SQL = "INSERT INTO usersa(user_id,user_name) VALUES('test', 'my');";
            stmt.executeUpdate(SQL);

            Thread.sleep(10000);
            conn.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback(); // 遇错回滚
        } finally {
            stmt.close();
            conn.close();
            System.out.println("Goodbye!");
        }
    }

    @Test
    public void testSavePoint() throws Exception {
        Statement stmt = null;
        Savepoint savepoint = null;
        try {
            conn.setAutoCommit(false); // 设置关闭自动提交
            stmt = conn.createStatement();

            String SQL = "INSERT INTO usersa(user_id,user_name) VALUES('test', 'my');";
            stmt.executeUpdate(SQL);

            savepoint = conn.setSavepoint("Savepoint1");

            Integer n = null;
            int a = n / 2;
            String SQL2 = "INSERT INTO usersa(user_id,user_name) VALUES('test', 'my');";
            stmt.executeUpdate(SQL2);
            conn.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback(savepoint); // 遇错回滚,只插入一条记录
            conn.commit();
        } finally {
            stmt.close();
            conn.close();
            System.out.println("Goodbye!");
        }
    }
}
