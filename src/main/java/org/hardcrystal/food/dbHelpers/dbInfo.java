package org.hardcrystal.food.dbHelpers;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 16.12.2015.
 */
public class dbInfo {

    private static Connection conn = null;


    public static Connection getConnection() {

        try {
            InitialContext ic = new InitialContext();
            Context initialContext = (Context) ic.lookup("java:comp/env");
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/MySQLDS");
            conn = datasource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


//    public static Connection getConnection() {
//
//        if (conn != null) return conn;
//
//        InputStream inputStream = dbInfo.class.getClassLoader().getResourceAsStream("/db.properties");
//        Properties properties = new Properties();
//
//        try {
//            properties.load(inputStream);
//            String driver = properties.getProperty("driver");
//            String hosturl = properties.getProperty("hosturl");
//            String user = properties.getProperty("user");
//            String password = properties.getProperty("password");
//
//            Class.forName(driver).newInstance();
//            conn = DriverManager.getConnection(hosturl, user, password);
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

    public static void closeConnection(Connection toBeClosed) {
        if (toBeClosed == null)
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
