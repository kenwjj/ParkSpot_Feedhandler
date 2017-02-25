package com.app.dao;

import com.app.helper.DBHelper;
import com.app.model.Carpark;

import java.sql.*;

/**
 * Created by Kenwjj on 25/2/2017.
 */
public class CarparkDAO {
    private Connection conn;

    public CarparkDAO() {
        conn = DBHelper.initConn();
    }

    public int insertCarpark(Carpark c){
        String query = " insert into carpark (carpark_id, lots,lastUpdated)"
                + " values (?, ?, ?)";
        PreparedStatement preparedStmt = null;
        int carpark_id = 0;
        try {
            preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt (1, c.getCarParkID());
            preparedStmt.setInt    (2, c.getLots());
            preparedStmt.setTimestamp    (3, c.getLastUpdated());


            // execute the preparedstatement
            preparedStmt.executeUpdate();

            ResultSet keyResultSet = preparedStmt.getGeneratedKeys();

            if (keyResultSet.next()) {
                carpark_id = keyResultSet.getInt(1);

            }
            return carpark_id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carpark_id;

    }


// Pre normalization
//    public int insertCarpark(Carpark c){
//        String query = " insert into carpark (carpark_id, area, development, latitude, longtitude,lots,lastUpdated)"
//                + " values (?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement preparedStmt = null;
//        int carpark_id = 0;
//        try {
//            preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            preparedStmt.setInt (1, c.getCarParkID());
//            preparedStmt.setString (2, c.getArea());
//            preparedStmt.setString   (3, c.getDevelopment());
//            preparedStmt.setFloat(4, c.getLatitude());
//            preparedStmt.setFloat (5, c.getLongitude());
//            preparedStmt.setInt    (6, c.getLots());
//            preparedStmt.setTimestamp    (7, c.getLastUpdated());
//
//
//            // execute the preparedstatement
//            preparedStmt.executeUpdate();
//
//            ResultSet keyResultSet = preparedStmt.getGeneratedKeys();
//
//            if (keyResultSet.next()) {
//                carpark_id = (int) keyResultSet.getInt(1);
//
//            }
//            return carpark_id;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return carpark_id;
//
//    }
//

    public void closeDB(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
