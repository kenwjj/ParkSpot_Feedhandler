package com.app.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kenwjj on 25/2/2017.
 */
public class DBHelper {

    private static String password = "XMQSUTKGYEZWXAAH";

    public static Connection initConn(){
        String myDriver = "com.mysql.cj.jdbc.Driver";
        String myUrl = "jdbc:mysql://sl-aus-syd-1-portal.2.dblayer.com:15526/parkspot?autoReconnect=true&useSSL=false";
        Connection conn = null;
        try {
            Class.forName(myDriver);
            conn = DriverManager.getConnection(myUrl, "admin", password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return conn;
    }

    public void closeConn(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
