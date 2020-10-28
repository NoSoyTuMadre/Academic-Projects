/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static utils.ConvertToUTC.convertUTCtoLDT;

public class SelectDB {

    public static ObservableList<Country> selectAllCountries() throws SQLException {
        Country country = new Country();
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM country";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        Country.getAllResultCountries().clear();
        while (rs.next()) {
            int countryID = rs.getInt("countryId");
            String countryName = rs.getString("country");
            LocalDate date = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalDate();
            LocalTime time = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalTime();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = Timestamp.valueOf(ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            String lastUpdateBy = rs.getString("lastUpdateBy");
            LocalDateTime createDate = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate"));
            country.setCountryId(countryID);
            country.setCountry(countryName);
            country.setCreateDate(createDate);
            country.setCreatedBy(createdBy);
            country.setLastUpdate(lastUpdate);
            country.setLastUpdateBy(lastUpdateBy);
            Country.getAllResultCountries().add(country);
        }
        rs.close();
        ps.close();
        conn.close();
        return Country.getAllResultCountries();
    }

    public static ObservableList<City> selectAllCities() throws SQLException {
        City city = new City();
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM city";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<City> allResultCities = FXCollections.observableArrayList();
        while (rs.next()) {
            int cityID = rs.getInt("cityId");
            String cityName = rs.getString("city");
            int countryID = rs.getInt("countryId");
            LocalDate date = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalDate();
            LocalTime time = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalTime();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = Timestamp.valueOf(ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            String lastUpdateBy = rs.getString("lastUpdateBy");
            LocalDateTime createDate = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate"));
            city.setCityId(cityID);
            city.setCity(cityName);
            city.setCountryId(countryID);
            city.setCreateDate(createDate);
            city.setCreatedBy(createdBy);
            city.setLastUpdate(lastUpdate);
            city.setLastUpdateBy(lastUpdateBy);
            allResultCities.add(city);
        }
        rs.close();
        ps.close();
        conn.close();
        return allResultCities;
    }

    public static ObservableList<Address> selectAllAddresses() throws SQLException {
        Address address = new Address();
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM address";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<Address> allResultAddresses = FXCollections.observableArrayList();
        while (rs.next()) {
            int addressID = rs.getInt("addressId");
            String address1 = rs.getString("address");
            String address2 = rs.getString("address2");
            int cityID = rs.getInt("cityId");
            String postalCode = rs.getString("postalCode");
            String phone = rs.getString("phone");
            LocalDate date = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalDate();
            LocalTime time = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalTime();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = Timestamp.valueOf(ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            String lastUpdateBy = rs.getString("lastUpdateBy");
            LocalDateTime createDate = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate"));
            Address.setAddressId(addressID);
            Address.setAddress1(address1);
            Address.setAddress2(address2);
            address.setCityId(cityID);
            Address.setPostalCode(postalCode);
            Address.setPhone(phone);
            address.setCreateDate(createDate);
            address.setCreatedBy(createdBy);
            address.setLastUpdate(lastUpdate);
            address.setLastUpdateBy(lastUpdateBy);
            allResultAddresses.add(address);
        }
        rs.close();
        ps.close();
        conn.close();
        return allResultAddresses;
    }

    public static ObservableList<Customer> selectAllCustomers() throws SQLException {
        Customer customer = new Customer();
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM customer";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<Customer> allResultCustomers = FXCollections.observableArrayList();
        while (rs.next()) {
            int customerID = rs.getInt("customerId");
            String customerName = rs.getString("customerName");
            int addressID = rs.getInt("addressId");
            int active = rs.getInt("active");
            LocalDate date = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalDate();
            LocalTime time = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalTime();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = Timestamp.valueOf(ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            String lastUpdateBy = rs.getString("lastUpdateBy");
            LocalDateTime createDate = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("createDate"));
            boolean activeX = false;
            if (active == 0)
                activeX = false;
            if (active == 1)
                activeX = true;
            Customer.setCustomerId(customerID);
            Customer.setCustomerName(customerName);
            Customer.setAddressId(addressID);
            Customer.setActive(activeX);
            customer.setCreateDate(createDate);
            customer.setCreatedBy(createdBy);
            customer.setLastUpdate(lastUpdate);
            customer.setLastUpdateBy(lastUpdateBy);
            allResultCustomers.add(customer);
        }
        rs.close();
        ps.close();
        conn.close();
        return allResultCustomers;
    }

    public static ObservableList<CompleteCustomer> selectAllCompleteCustomers() throws SQLException {
        int customerID = 0;
        int cityID = 0;
        int countryID = 0;
        int addressID = 0;
        String customerName = null;
        String addressA = null;
        String addressB = null;
        String cityA = null;
        String countryA = null;
        String postalCodeA = null;
        String phoneA = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM customer";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<CompleteCustomer> allResultCompleteCustomers = FXCollections.observableArrayList();
        while (rs.next()) {
            customerID = rs.getInt("customerId");
            customerName = rs.getString("customerName");
            addressID = rs.getInt("addressId");

            String selectStatement2 = "SELECT * FROM address WHERE addressId=?";
            Connection conn2 = DBConnection.startConnection();
            DBQuery.setPreparedStatement(conn, selectStatement2);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, String.valueOf(addressID));
            ps2.execute();
            ResultSet rs2 = ps2.getResultSet();
            while (rs2.next()) {
                cityID = rs2.getInt("cityId");
                addressA = rs2.getString("address");
                addressB = rs2.getString("address2");
                phoneA = rs2.getString("phone");
                postalCodeA = rs2.getString("postalCode");

                String selectStatement3 = "SELECT * FROM city WHERE cityId=?";
                Connection conn3 = DBConnection.startConnection();
                DBQuery.setPreparedStatement(conn, selectStatement3);
                PreparedStatement ps3 = DBQuery.getPreparedStatement();
                ps3.setString(1, String.valueOf(cityID));
                ps3.execute();
                ResultSet rs3 = ps3.getResultSet();
                while (rs3.next()) {
                    countryID = rs3.getInt("countryId");
                    cityA = rs3.getString("city");

                    String selectStatement4 = "SELECT * FROM country WHERE countryId=?";
                    Connection conn4 = DBConnection.startConnection();
                    DBQuery.setPreparedStatement(conn, selectStatement4);
                    PreparedStatement ps4 = DBQuery.getPreparedStatement();
                    ps4.setString(1, String.valueOf(countryID));
                    ps4.execute();
                    ResultSet rs4 = ps4.getResultSet();
                    while (rs4.next()) {
                        countryA = rs4.getString("country");
                        CompleteCustomer cCustomer = new CompleteCustomer(String.valueOf(customerID), customerName, addressA, addressB, cityA, postalCodeA, countryA, phoneA);
                        allResultCompleteCustomers.add(cCustomer);
                    }
                    rs4.close();
                    ps4.close();
                    conn4.close();
                }
                rs3.close();
                ps3.close();
                conn3.close();
            }
            rs2.close();
            ps2.close();
            conn2.close();
        }

        rs.close();
        ps.close();
        conn.close();
        return allResultCompleteCustomers;
    }

    public static ObservableList<CompleteAppointment> selectAllCompleteAppointments() throws SQLException {
        int customerID = 0;
        int userID = 0;
        int appointmentID = 0;
        String contactA = null;
        String userNameA = null;
        String titleA = null;
        String descriptionA = null;
        String locationA = null;
        String typeA = null;
        String urlA = null;
        LocalDateTime startA = null;
        LocalDateTime endA = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment WHERE userId=? ORDER BY start ASC";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setInt(1, User.getUserId());
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<CompleteAppointment> allResultCompleteAppointments = FXCollections.observableArrayList();
        while (rs.next()) {
            appointmentID = rs.getInt("appointmentId");
            customerID = rs.getInt("customerId");
            userID = rs.getInt("userId");
            titleA = rs.getString("title");
            descriptionA = rs.getString("description");
            locationA = rs.getString("location");
            contactA = rs.getString("contact");
            typeA = rs.getString("type");
            urlA = rs.getString("url");
            startA = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("start")); //not sure if it will work
            endA = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("end"));  //not sure if it will work
            //allResultCustomers.add(customer);
            String start = (startA.toLocalDate() + " " + startA.toLocalTime());
            String end = (endA.toLocalDate() + " " + endA.toLocalTime());

            Connection conn2 = DBConnection.startConnection();
            String selectStatement2 = "SELECT userName FROM user WHERE userId=?";
            DBQuery.setPreparedStatement(conn, selectStatement2);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, String.valueOf(userID));
            ps2.execute();
            ResultSet rs2 = ps2.getResultSet();
            while (rs2.next()) {
                userNameA = rs2.getString("userName");
                CompleteAppointment cAppointment = new CompleteAppointment(appointmentID, contactA, userNameA, titleA, descriptionA, locationA, typeA, urlA, startA, endA);
                allResultCompleteAppointments.add(cAppointment);
            }
            ps2.close();
            conn2.close();
        }

        ps.close();
        conn.close();
        return allResultCompleteAppointments;
    }

    public static ObservableList<CompleteAppointment> selectAllCompleteAppointmentsTable() throws SQLException {

        int customerID = 0;
        int userID = 0;
        int appointmentID = 0;
        String contactA = null;
        String userNameA = null;
        String titleA = null;
        String descriptionA = null;
        String locationA = null;
        String typeA = null;
        String urlA = null;
        LocalDateTime startA = null;
        LocalDateTime endA = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment WHERE userId=? ORDER BY start ASC";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setInt(1, User.getUserId());
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<CompleteAppointment> allResultCompleteAppointments = FXCollections.observableArrayList();
        while (rs.next()) {
            appointmentID = rs.getInt("appointmentId");
            customerID = rs.getInt("customerId");
            userID = rs.getInt("userId");
            titleA = rs.getString("title");
            descriptionA = rs.getString("description");
            locationA = rs.getString("location");
            contactA = rs.getString("contact");
            typeA = rs.getString("type");
            urlA = rs.getString("url");
            startA = convertUTCtoLDT(rs.getTimestamp("start")); //not sure if it will work
            endA = convertUTCtoLDT(rs.getTimestamp("end"));  //not sure if it will work
            //allResultCustomers.add(customer);
            String start = (startA.toLocalDate() + " " + startA.toLocalTime());
            String end = (endA.toLocalDate() + " " + endA.toLocalTime());

            Connection conn2 = DBConnection.startConnection();
            String selectStatement2 = "SELECT userName FROM user WHERE userId=?";
            DBQuery.setPreparedStatement(conn, selectStatement2);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, String.valueOf(userID));
            ps2.execute();
            ResultSet rs2 = ps2.getResultSet();
            while (rs2.next()) {
                userNameA = rs2.getString("userName");
                CompleteAppointment cAppointment = new CompleteAppointment(appointmentID, contactA, userNameA, titleA, descriptionA, locationA, typeA, urlA, start, end);
                allResultCompleteAppointments.add(cAppointment);
            }
            ps2.close();
            conn2.close();
        }

        ps.close();
        conn.close();
        return allResultCompleteAppointments;
    }

    public static CompleteCustomer selectCustomerByApptmt(String apptmtId) throws SQLException {
        CompleteCustomer customer = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT customerId FROM appointment WHERE appointmentId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, apptmtId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            int customerID = rs.getInt("customerId");

            String selectStatement2 = "SELECT customerName, addressId FROM customer WHERE customerId=?";
            DBQuery.setPreparedStatement(conn, selectStatement2);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, String.valueOf(customerID));
            ps2.execute();
            ResultSet rs2 = ps2.getResultSet();
            while (rs2.next()) {
                String customerName = rs2.getString("customerName");
                int addressID = rs2.getInt("addressId");

                String selectStatement3 = "SELECT address, address2, postalCode, phone, cityId FROM address WHERE addressId=?";
                DBQuery.setPreparedStatement(conn, selectStatement3);
                PreparedStatement ps3 = DBQuery.getPreparedStatement();
                ps3.setString(1, String.valueOf(addressID));
                ps3.execute();
                ResultSet rs3 = ps3.getResultSet();
                while (rs3.next()) {
                    String addressA = rs3.getString("address");
                    String addressB = rs3.getString("address2");
                    String postalCodeA = rs3.getString("postalCode");
                    String phoneA = rs3.getString("phone");
                    int cityID = rs3.getInt("cityId");

                    String selectStatement4 = "SELECT city, countryId FROM city WHERE cityId=?";
                    DBQuery.setPreparedStatement(conn, selectStatement4);
                    PreparedStatement ps4 = DBQuery.getPreparedStatement();
                    ps4.setString(1, String.valueOf(cityID));
                    ps4.execute();
                    ResultSet rs4 = ps4.getResultSet();
                    while (rs4.next()) {
                        String cityA = rs4.getString("city");
                        int countryID = rs4.getInt("countryId");

                        String selectStatement5 = "SELECT country FROM country WHERE countryId=?";
                        DBQuery.setPreparedStatement(conn, selectStatement5);
                        PreparedStatement ps5 = DBQuery.getPreparedStatement();
                        ps5.setString(1, String.valueOf(countryID));
                        ps5.execute();
                        ResultSet rs5 = ps5.getResultSet();
                        while (rs5.next()) {
                            String countryA = rs5.getString("country");
                            customer = new CompleteCustomer(String.valueOf(customerID), customerName, addressA, addressB, cityA, postalCodeA, countryA, phoneA);
                        }
                        rs5.close();
                        ps5.close();
                    }
                    rs4.close();
                    ps4.close();
                }
                rs3.close();
                ps3.close();
            }
            rs2.close();
            ps2.close();
        }
        rs.close();
        ps.close();
        conn.close();
        return customer;
    }

    public static ObservableList<Appointment> selectAllAppointments() throws SQLException {
        Appointment appointment = new Appointment();
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<Appointment> allResultAppointments = FXCollections.observableArrayList();
        while (rs.next()) {
            int appointmentID = rs.getInt("appointmentId");
            int customerID = rs.getInt("customerId");
            int userID = rs.getInt("userId");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String location = rs.getString("location");
            String contact = rs.getString("contact");
            String type = rs.getString("type");
            String url = rs.getString("url");
            LocalDate startDate = convertUTCtoLDT(rs.getTimestamp("start")).toLocalDate();
            LocalTime startTime = convertUTCtoLDT(rs.getTimestamp("start")).toLocalTime();
            LocalDate endDate = convertUTCtoLDT(rs.getTimestamp("end")).toLocalDate();
            LocalTime endTime = convertUTCtoLDT(rs.getTimestamp("end")).toLocalTime();
            LocalDate date = convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalDate();
            LocalTime time = convertUTCtoLDT(rs.getTimestamp("createDate")).toLocalTime();
            LocalDateTime createDate = convertUTCtoLDT(rs.getTimestamp("createDate"));
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = Timestamp.valueOf(convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            String lastUpdateBy = rs.getString("lastUpdateBy");
            appointment.setAppointmentId(appointmentID);
            appointment.setApptmtTitle(title);
            appointment.setDescription(description);
            appointment.setApptmtLocation(location);
            appointment.setApptmtContact(contact);
            appointment.setApptmtType(type);
            appointment.setApptmtUrl(url);
            appointment.setCreateDate(createDate);
            appointment.setCreatedBy(createdBy);
            appointment.setLastUpdate(lastUpdate);
            appointment.setLastUpdateBy(lastUpdateBy);
            allResultAppointments.add(appointment);
        }
        rs.close();
        ps.close();
        conn.close();
        return allResultAppointments;
    }

    public static CompleteAppointment selectCompleteAppointment(String appointmentId) throws SQLException {
        CompleteAppointment appointment = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment WHERE appointmentId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, appointmentId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            int appointmentID = rs.getInt("appointmentId");
            int customerID = rs.getInt("customerId");
            int userID = rs.getInt("userId");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String location = rs.getString("location");
            String contact = rs.getString("contact");
            String type = rs.getString("type");
            String url = rs.getString("url");
            LocalDateTime start = convertUTCtoLDT(rs.getTimestamp("start"));
            LocalDateTime end = convertUTCtoLDT(rs.getTimestamp("end"));

            String selectStatement2 = "SELECT userName FROM user WHERE userId=?";
            DBQuery.setPreparedStatement(conn, selectStatement2);
            PreparedStatement ps2 = DBQuery.getPreparedStatement();
            ps2.setString(1, String.valueOf(userID));
            ps2.execute();
            ResultSet rs2 = ps2.getResultSet();
            while (rs2.next()) {
                String userName = rs2.getString("userName");
                appointment = new CompleteAppointment(appointmentID, contact, userName, title, description, location, type, url, start, end);
            }
            rs2.close();
            ps2.close();
        }
        rs.close();
        ps.close();
        conn.close();
        return appointment;
    }

    public static ObservableList<User> selectAllUsers() throws SQLException {
        //User user = new User();
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM user";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<User> allResultUsers = FXCollections.observableArrayList();
        while (rs.next()) {
            int userID = rs.getInt("userId");
            String userName = rs.getString("userName");
            String password = rs.getString("password");
            int active = rs.getInt("active");
            //LocalDate date = rs.getDate("createDate").toLocalDate();
            //LocalTime time = rs.getTime("createDate").toLocalTime();
            String createdBy = rs.getString("createdBy");
            Timestamp lastUpdate = Timestamp.valueOf(convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            String lastUpdateBy = rs.getString("lastUpdateBy");
            LocalDateTime createDate = convertUTCtoLDT(rs.getTimestamp("createDate"));
            boolean activeX = false;
            if (active == 1)
                activeX = true;
            User user = new User(userID, userName, password, activeX, createDate, createdBy, lastUpdate, lastUpdateBy);
            allResultUsers.add(user);
        }
        rs.close();
        ps.close();
        conn.close();
        return allResultUsers;
    }

    public static User selectUser(String userName, String password) throws SQLException {
        User user = null;
        int userID;
        String userNameA;
        String passwordA;
        int active;
        String createdBy;
        LocalDateTime createDate;
        Timestamp lastUpdate;
        String lastUpdateBy;
        boolean activeX = false;

        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM user WHERE userName=? AND password=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            userID = rs.getInt("userId");
            userNameA = rs.getString("userName");
            passwordA = rs.getString("password");
            active = rs.getInt("active");
            //LocalDate date = rs.getDate("createDate").toLocalDate();
            //LocalTime time = rs.getTime("createDate").toLocalTime();
            createdBy = rs.getString("createdBy");
            lastUpdate = Timestamp.valueOf(convertUTCtoLDT(rs.getTimestamp("lastUpdate")));
            lastUpdateBy = rs.getString("lastUpdateBy");
            createDate = convertUTCtoLDT(rs.getTimestamp("createDate"));
            //if (active == 0)
            //    activeX = false;
            activeX = active == 1;
            user = new User(userID, userNameA, passwordA, activeX, createDate, createdBy, lastUpdate, lastUpdateBy);
        }
        rs.close();
        ps.close();
        conn.close();
        return user;
    }

    public static boolean validate_login(String username, String password) {
        try {
            Connection conn = DBConnection.startConnection();
            String selectStatement = "SELECT * FROM user WHERE BINARY userName=? AND BINARY password=?";
            DBQuery.setPreparedStatement(conn, selectStatement);
            PreparedStatement ps = DBQuery.getPreparedStatement();
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rs.close();
                ps.close();
                conn.close();
                return true;
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int selectCountryId(String country) throws SQLException {
        Country newCountry = new Country();
        int countryID = 0;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT countryId FROM country WHERE country=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, country);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            countryID = rs.getInt("countryId");
        }
        rs.close();
        ps.close();
        conn.close();
        return countryID;
    }

    public static int selectCityId(String city) throws SQLException {
        City newCity = new City();
        int cityID = 0;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT cityId FROM city WHERE city=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, city);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            cityID = rs.getInt("cityId");
        }
        rs.close();
        ps.close();
        conn.close();
        return cityID;
    }

    public static int selectAddressId(String customerId) throws SQLException {
        Customer customer = new Customer();
        int addressID = 0;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT addressId FROM customer WHERE customerId=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, customerId);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            addressID = rs.getInt("addressId");
        }
        rs.close();
        ps.close();
        conn.close();
        return addressID;
    }

}
