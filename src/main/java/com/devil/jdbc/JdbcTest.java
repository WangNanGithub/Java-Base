package com.devil.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * CREATE TABLE `usersa` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `user_id` varchar(50) NOT NULL,
      `user_name` varchar(200) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
 *
 */
public class JdbcTest {
    // JDBC driver name and database URL
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Database credentials
    String USER = "root";
    String PASS = "root";

    // connection
    Connection conn = null;

    @Before
    public void before() throws Exception {
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // pen a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    @Test
    public void testStatement() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM usersa";
            rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", userid: " + rs.getString("user_id"));
                System.out.println(", username: " + rs.getString("user_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Goodbye!");
        }
    }

    @Test
    public void testPreparedStatement() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM usersa WHERE user_id=? AND id<?";
            stmt = conn.prepareStatement(sql);

            // Bind values into the parameters.
            stmt.setString(1, "test");
            stmt.setInt(2, 7);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", userid: " + rs.getString("user_id"));
                System.out.println(", username: " + rs.getString("user_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Goodbye!");
        }
    }
    
    /**
     *  创建存储过程
     *  
     *  DELIMITER $$

        DROP PROCEDURE IF EXISTS `usersa`.`getName` $$
        CREATE PROCEDURE `test`.`getName` 
           (IN T_ID INT, OUT R_NAME VARCHAR(255), OUT R_ID VARCHAR(255))
        BEGIN
           SELECT user_name INTO R_NAME
           FROM usersa
           WHERE ID = T_ID;
        
             SELECT user_id INTO R_ID
           FROM usersa
           WHERE ID = T_ID;
        
             SELECT * FROM usersa;
             SELECT * FROM usersa WHERE id < 5;
        END $$
        
        DELIMITER ;
     */
    @Test
    public void testCallableStatement() throws SQLException{
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            // Execute a query
            System.out.println("Creating statement...");
            String sql = "{call getName (?, ?, ?)}";
            stmt = conn.prepareCall(sql);
            
            //Bind IN parameter first, then bind OUT parameter
            stmt.setInt(1, 5); // This would set ID as 102
            // Because second parameter is OUT so register it
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, Types.VARCHAR);
            
            //Use execute method to run stored procedure.
            System.out.println("Executing stored procedure..." );
            stmt.execute();
            System.out.println("name:" + stmt.getString(2) + " id:" + stmt.getString(3));

            boolean more = true;
            int i = 0;
            while(more) {
                System.out.println("result No:----"+(++i)); 
                rs = stmt.getResultSet();
                while (rs.next()) {
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", userid: " + rs.getString("user_id"));
                    System.out.println(", username: " + rs.getString("user_name"));
                }
                more = stmt.getMoreResults(); // 检查是否有多个结果集
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Goodbye!");
        }
    }
    
    
}
