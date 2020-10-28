/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDB {
    public static void deleteCountry(String countryId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM city WHERE countryId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, countryId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            int cityID = rs.getInt("cityId");
        }
        if (ps.getUpdateCount() > 1)
            return;
        else {
            String deleteStatement = "DELETE FROM country WHERE countryId=?";
            DBQuery.setPreparedStatement(conn, deleteStatement);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, countryId);
            ps2.execute();
        }
    }

    public static void deleteCity(String cityId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM address WHERE cityId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, cityId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            int addressID = rs.getInt("addressId");
        }
        if (ps.getUpdateCount() > 1)
            return;
        else {
            String deleteStatement = "DELETE FROM city WHERE cityId=?";
            DBQuery.setPreparedStatement(conn, deleteStatement);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, cityId);
            ps2.execute();
        }
    }

    public static void deleteAddress(String addressId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM customer WHERE addressId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, addressId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            int customerID = rs.getInt("customerId");
        }
        if (ps.getUpdateCount() > 1)
            return;
        else {
            String deleteStatement = "DELETE FROM address WHERE addressId=?";
            DBQuery.setPreparedStatement(conn, deleteStatement);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, addressId);
            ps2.execute();
        }
    }

    public static void deleteCustomer(String customerId) throws SQLException {
        int appointmentID;
        int addressID = -1;
        int cityID = -1;
        int countryID;

        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment WHERE customerId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            appointmentID = rs.getInt("appointmentId");
            deleteAppointment(String.valueOf(appointmentID));
        }

        String selectStatement2 = "SELECT addressId FROM customer WHERE customerId=?";
        DBQuery.setPreparedStatement(conn, selectStatement2);
        PreparedStatement ps2 = DBQuery.getPreparedStatement();
        ps2.setString(1, customerId);
        ps2.execute();
        ResultSet rs2 = ps2.getResultSet();
        while (rs2.next()) {
            addressID = rs2.getInt("addressId");
            if (ps2.getUpdateCount() == 1)
                deleteAddress(String.valueOf(addressID));
        }

        String deleteStatement = "DELETE FROM customer WHERE customerId=?";
        DBQuery.setPreparedStatement(conn, deleteStatement);
        PreparedStatement ps5 = DBQuery.getPreparedStatement();
        ps5.setString(1, customerId);
        ps5.execute();
        if (ps5.getUpdateCount() > 0)
            System.out.println("Customer Deleted Successfully!");
        else
            System.out.println("Customer Delete Failed!");

        String selectStatement3 = "SELECT cityId FROM address WHERE addressId=?";
        DBQuery.setPreparedStatement(conn, selectStatement3);
        PreparedStatement ps3 = DBQuery.getPreparedStatement();
        ps3.setInt(1, addressID);
        ps3.execute();
        ResultSet rs3 = ps3.getResultSet();
        while (rs3.next()) {
            cityID = rs3.getInt("cityId");
            if (ps3.getUpdateCount() == 1)
                deleteCity(String.valueOf(cityID));
        }

        String selectStatement4 = "SELECT countryId FROM city WHERE cityId=?";
        DBQuery.setPreparedStatement(conn, selectStatement4);
        PreparedStatement ps4 = DBQuery.getPreparedStatement();
        ps4.setInt(1, cityID);
        ps4.execute();
        ResultSet rs4 = ps4.getResultSet();
        while (rs4.next()) {
            countryID = rs4.getInt("countryId");
            if (ps3.getUpdateCount() == 1)
                deleteCountry(String.valueOf(countryID));
        }

        rs.close();
        ps.close();
        rs2.close();
        ps2.close();
        rs3.close();
        ps3.close();
        rs4.close();
        ps4.close();
        ps5.close();
        conn.close();
    }

    public static void deleteAppointment(String appointmentId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String deleteStatement = "DELETE FROM appointment WHERE appointmentId=?";
        DBQuery.setPreparedStatement(conn, deleteStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, appointmentId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("Appointment Deleted Successfully!");
        else
            System.out.println("Appointment Delete Failed!");
    }

    public static void deleteUser(String userId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String deleteStatement = "DELETE FROM user WHERE userId=?";
        DBQuery.setPreparedStatement(conn, deleteStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, userId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("User Deleted Successfully!");
        else
            System.out.println("User Delete Failed!");
    }
}
