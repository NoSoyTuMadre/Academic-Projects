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
import java.sql.SQLException;

public class UpdateDB {

    public static void updateCountry(String countryId, String countryName, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String updateStatement = "UPDATE country SET country=?, lastUpdateBy=? WHERE countryId=?";
        DBQuery.setPreparedStatement(conn, updateStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, countryName);
        ps.setString(2, lastUpdateBy);
        ps.setString(3, countryId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("Country Updated Successfully!");
        else
            System.out.println("Country Update Failed!");
    }

    public static void updateCity(String cityId, String cityName, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String updateStatement = "UPDATE city SET city=?, lastUpdateBy=? WHERE cityId=?";
        DBQuery.setPreparedStatement(conn, updateStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, cityName);
        ps.setString(2, lastUpdateBy);
        ps.setString(3, cityId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("City Updated Successfully!");
        else
            System.out.println("City Update Failed!");
        ps.close();
        conn.close();
    }

    public static void updateAddress(String addressId, String address, String address2, String postalCode, String phone, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String updateStatement = "UPDATE address SET address=?, address2=?, postalCode=?, phone=?, lastUpdateBy=? WHERE addressId=?";
        DBQuery.setPreparedStatement(conn, updateStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, address);
        ps.setString(2, address2);
        ps.setString(3, postalCode);
        ps.setString(4, phone);
        ps.setString(5, lastUpdateBy);
        ps.setString(6, addressId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("Address Updated Successfully!");
        else
            System.out.println("Address Update Failed!");
        ps.close();
        conn.close();
    }

    public static void updateCustomer(String customerId, String customerName, String active, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String updateStatement = "UPDATE customer SET customerName=?, active=?, lastUpdateBy=? WHERE customerId=?";
        DBQuery.setPreparedStatement(conn, updateStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerName);
        ps.setString(2, active);
        ps.setString(3, lastUpdateBy);
        ps.setString(4, customerId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("Customer Updated Successfully!");
        else
            System.out.println("Customer Update Failed!");
        ps.close();
        conn.close();
    }

    public static void updateAppointment(String appointmentId, String customerId, String title, String description, String location, String contact, String type, String url, String start, String end, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String updateStatement = "UPDATE appointment SET customerId=?, title=?, description=?, location=?, contact=?, type=?, url=?, start=?, end=?, lastUpdateBy=? WHERE appointmentId=?";
        DBQuery.setPreparedStatement(conn, updateStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerId);
        ps.setString(2, title);
        ps.setString(3, description);
        ps.setString(4, location);
        ps.setString(5, contact);
        ps.setString(6, type);
        ps.setString(7, url);
        ps.setString(8, start);
        ps.setString(9, end);
        ps.setString(10, lastUpdateBy);
        ps.setString(11, appointmentId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("Appointment Updated Successfully!");
        else
            System.out.println("Appointment Update Failed!");
        ps.close();
        conn.close();
    }

    public static void updateUser(String userId, String userName, String password, String active, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String updateStatement = "UPDATE user SET userName=?, password=?, active=?, lastUpdateBy=? WHERE userId=?";
        DBQuery.setPreparedStatement(conn, updateStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, active);
        ps.setString(4, lastUpdateBy);
        ps.setString(5, userId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("User Updated Successfully!");
        else
            System.out.println("User Update Failed!");
        ps.close();
        conn.close();
    }

}
