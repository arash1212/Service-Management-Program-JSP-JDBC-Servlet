package com.salehi.programming_challenge__1.model.common;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnection {
    private static BasicDataSource basicDataSource = new BasicDataSource();

    static {
        basicDataSource.setUsername("arash");
        basicDataSource.setPassword("1234");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setMaxTotal(4);
    }

    public static Connection getConnection() throws SQLException {
        return basicDataSource.getConnection();
    }
}
