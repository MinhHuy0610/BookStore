/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huytm.bookstore.util;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author acer
 */
public class DBUtil {

    //hàm static để ko cần new đối tượng, để chỉ dùng 1 vùng ram
    public static Connection makeConnection() {
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://SE140602;databaseName=SWT";
            String user = "sa";
            String pass = "0986855878";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            //System.out.println("Connect to DB successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws SQLException {

        System.out.println("This is to test if we can connect to SQLServer");
        Connection conn = makeConnection();
        DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
        System.out.println("Driver name: " + dm.getDriverName());
        System.out.println("Driver version: " + dm.getDriverVersion());
        closeConnection(conn);
    }
}
