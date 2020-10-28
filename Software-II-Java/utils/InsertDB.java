/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package utils;

import java.sql.*;

public class InsertDB {

    public static void addCustomer(String customerName, String address1, String address2, String city, String postalCode, String country, String active, String phone, String createDate, String createdBy, String lastUpdateBy) throws SQLException {
        int countryID = 0;
        int cityID = 0;
        int addressID = 0;
        int customerID = 0;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT countryId FROM country WHERE country=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, country);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        if (rs.next())
            countryID = rs.getInt("countryId");
        else {
            insertCountry(country, createDate, createdBy, lastUpdateBy);

            String selectStatement4 = "SELECT countryId FROM country WHERE country=?";
            DBQuery.setPreparedStatement(conn, selectStatement4);
            PreparedStatement ps4 = DBQuery.getPreparedStatement();
            ps4.setString(1, country);
            ps4.execute();
            ResultSet rs4 = ps4.getResultSet();
            while (rs4.next()) {
                countryID = rs4.getInt("countryId");
            }
            rs4.close();
            ps4.close();
            rs.close();
            ps.close();
        }

        String selectStatement2 = "SELECT cityId FROM city WHERE city=? AND countryId=?";
        DBQuery.setPreparedStatement(conn, selectStatement2);
        PreparedStatement ps2 = DBQuery.getPreparedStatement();
        ps2.setString(1, city);
        ps2.setInt(2, countryID);
        ps2.execute();
        ResultSet rs2 = ps2.getResultSet();
        if (rs2.next())
            cityID = rs2.getInt("cityId");
        else {
            insertCity(city, createDate, createdBy, lastUpdateBy, String.valueOf(countryID));

            String selectStatement0 = "SELECT cityId FROM city WHERE city=? AND countryId=?";
            DBQuery.setPreparedStatement(conn, selectStatement0);
            PreparedStatement ps0 = DBQuery.getPreparedStatement();
            ps0.setString(1, city);
            ps0.setInt(2, countryID);
            ps0.execute();
            ResultSet rs0 = ps0.getResultSet();
            while (rs0.next()) {
                cityID = rs0.getInt("cityId");
            }
            rs0.close();
            ps0.close();
            rs2.close();
            ps2.close();
        }
            String selectStatement3 = "SELECT addressId FROM address WHERE address=? AND address2=? AND postalCode=? AND cityId=?";
            DBQuery.setPreparedStatement(conn, selectStatement3);
            PreparedStatement ps3 = DBQuery.getPreparedStatement();
            ps3.setString(1, address1);
            ps3.setString(2, address2);
            ps3.setString(3, postalCode);
            ps3.setString(4, String.valueOf(cityID));
            ps3.execute();
        ResultSet rs3 = ps3.getResultSet();
        if (rs3.next())
            addressID = rs3.getInt("addressId");
        else {
            insertAddress(address1, address2, postalCode, phone, createDate, createdBy, lastUpdateBy, String.valueOf(cityID));
            String selectStatement8 = "SELECT addressId FROM address WHERE address=? AND address2=? AND postalCode=? AND cityId=?";
            DBQuery.setPreparedStatement(conn, selectStatement8);
            PreparedStatement ps8 = DBQuery.getPreparedStatement();
            ps8.setString(1, address1);
            ps8.setString(2, address2);
            ps8.setString(3, postalCode);
            ps8.setString(4, String.valueOf(cityID));
            ps8.execute();
            ResultSet rs8 = ps8.getResultSet();
            while (rs8.next()) {
                addressID = rs8.getInt("addressId");
            }
            rs8.close();
            ps8.close();
            rs3.close();
            ps3.close();
        }

            String selectStatement9 = "SELECT customerId FROM customer WHERE customerName=? AND addressId=?";
            DBQuery.setPreparedStatement(conn, selectStatement9);
            PreparedStatement ps9 = DBQuery.getPreparedStatement();
            ps9.setString(1, customerName);
            ps9.setString(2, String.valueOf(addressID));
            ps9.execute();
        ResultSet rs9 = ps9.getResultSet();
        if (rs9.next())
            customerID = rs9.getInt("customerId");
        else {
            insertCustomer(customerName, active, createDate, createdBy, lastUpdateBy, String.valueOf(addressID));
            String selectStatement5 = "SELECT customerId FROM customer WHERE customerName=? AND addressId=?";
            DBQuery.setPreparedStatement(conn, selectStatement5);
            PreparedStatement ps5 = DBQuery.getPreparedStatement();
            ps5.setString(1, customerName);
            ps5.setInt(2, addressID);
            ps5.execute();
            ResultSet rs5 = ps5.getResultSet();
            while (rs5.next()) {
                customerID = rs5.getInt("customerId");
            }
            rs5.close();
            ps5.close();
            rs9.close();
            ps9.close();
        }
            conn.close();
    }

    public static void addAppointment(String custid, String userid, String title, String description, String location, String contact, String type, String url, String start, String end, String createDate, String createdBy, String lastUpdateBy, String userId, String customerId) throws SQLException {
        try {
            Connection conn = DBConnection.startConnection();
            String insertStatement = "INSERT INTO appointment(customerId, userId, title, description, location, contact, type, url, start, end, createDate, createdBy, lastUpdateBy) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            DBQuery.setPreparedStatement(conn, insertStatement);
            PreparedStatement ps = DBQuery.getPreparedStatement();
            ps.setString(1, custid);
            ps.setString(2, userid);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, location);
            ps.setString(6, contact);
            ps.setString(7, type);
            ps.setString(8, url);
            ps.setString(9, start);
            ps.setString(10, end);
            ps.setString(11, createDate);
            ps.setString(12, createdBy);
            ps.setString(13, lastUpdateBy);
            ps.execute();

            if(ps.getUpdateCount() > 0)
                System.out.println("Appointment Added Successfully!");
            else
                System.out.println("Appointment Add Failed!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertCountry(String countryName, String createDate, String createdBy, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String insertStatement = "INSERT INTO country(country, createDate, createdBy, lastUpdateBy) VALUES(?,?,?,?)";
        DBQuery.setPreparedStatement(conn, insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, countryName);
        ps.setString(2, createDate);
        ps.setString(3, createdBy);
        ps.setString(4, lastUpdateBy);
        ps.execute();
        ps.close();
        conn.close();
    }

    public static void insertCity(String cityName, String createDate, String createdBy, String lastUpdateBy, String countryId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String insertStatement = "INSERT INTO city(city, createDate, createdBy, lastUpdateBy, countryId) VALUES(?,?,?,?,?)";
        DBQuery.setPreparedStatement(conn, insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, cityName);
        ps.setString(2, createDate);
        ps.setString(3, createdBy);
        ps.setString(4, lastUpdateBy);
        ps.setString(5, countryId);
        ps.execute();
        ps.close();
        conn.close();
    }

    public static void insertAddress(String address, String address2, String postalCode, String phone, String createDate, String createdBy, String lastUpdateBy, String cityId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String insertStatement = "INSERT INTO address(address, address2, postalCode, phone, createDate, createdBy, lastUpdateBy, cityId) VALUES(?,?,?,?,?,?,?,?)";
        DBQuery.setPreparedStatement(conn, insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, address);
        ps.setString(2, address2);
        ps.setString(3, postalCode);
        ps.setString(4, phone);
        ps.setString(5, createDate);
        ps.setString(6, createdBy);
        ps.setString(7, lastUpdateBy);
        ps.setString(8, cityId);
        ps.execute();
        /*if(ps.getUpdateCount() > 0)
            System.out.println(ps.getUpdateCount() + " row(s) affected!");
        else
            System.out.println("No change!");

         */
        ps.close();
        conn.close();
    }

    public static void insertCustomer(String customerName, String active, String createDate, String createdBy, String lastUpdateBy, String addressId) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String insertStatement = "INSERT INTO customer(customerName, active, createDate, createdBy, lastUpdateBy, addressId) VALUES(?,?,?,?,?,?)";
        DBQuery.setPreparedStatement(conn, insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerName);
        ps.setString(2, active);
        ps.setString(3, createDate);
        ps.setString(4, createdBy);
        ps.setString(5, lastUpdateBy);
        ps.setString(6, addressId);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("Customer Added Successfully!");
        else
            System.out.println("Customer Add Failed!");
        ps.close();
        conn.close();
    }

    public static void insertUser(String userName, String password, String active, String createDate, String createdBy, String lastUpdateBy) throws SQLException {
        Connection conn = DBConnection.startConnection();
        String insertStatement = "INSERT INTO user(userName, password, active, createDate, createdBy, lastUpdateBy) VALUES(?,?,?,?,?,?)";
        DBQuery.setPreparedStatement(conn, insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, active);
        ps.setString(4, createDate);
        ps.setString(5, createdBy);
        ps.setString(6, lastUpdateBy);
        ps.execute();
        if(ps.getUpdateCount() > 0)
            System.out.println("User Added Successfully!");
        else
            System.out.println("User Add Failed!");
        ps.close();
        conn.close();
    }

}
