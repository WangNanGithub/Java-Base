package com.devil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

/**
 * 批量处理
 * 
 * @author Devil
 *
 */
public class BatchTest {
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
    public void testStatement() throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            conn.setAutoCommit(false);
            
            String SQL1 = "INSERT INTO usersa(user_id,user_name) VALUES('test1', 'my')";
            stmt.addBatch(SQL1);

            String SQL2 = "INSERT INTO usersa(user_id,user_name) VALUES('test2', 'you')";
            stmt.addBatch(SQL2);

            String SQL3 = "UPDATE usersa SET user_name = 'sb' WHERE user_id = 'test2'";
            stmt.addBatch(SQL3);

            int[] count = stmt.executeBatch();
            for (int i : count) {
                System.out.println(i);
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            stmt.close();
            conn.close();
            System.out.println("Goodbye!");
        }
    }
    
    @Test
    public void testPrepareStatement() throws SQLException {
        // 同上
    }
}
