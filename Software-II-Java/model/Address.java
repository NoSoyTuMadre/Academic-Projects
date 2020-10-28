/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package model;

import javafx.collections.ObservableList;
import utils.SelectDB;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Address extends Customer {

    //declare fields
    public static int addressId;
    private static String address1;
    private static String address2;
    private static int cityId;
    private static String postalCode;
    private static String phone;
    public static LocalDateTime createDate;
    public static String createdBy;
    public static Timestamp lastUpdate;
    public static String lastUpdateBy;

    //setters
    public static void setAddressId(int addressId) {
        Address.addressId = addressId;
    }
    public static void setAddress1(String address1) {
        Address.address1 = address1;
    }
    public static void setAddress2(String address2) {
        Address.address2 = address2;
    }
    public void setCityId(int cityId) {
        Address.cityId = cityId;
    }
    public static void setPostalCode(String postalCode) {
        Address.postalCode = postalCode;
    }
    public static void setPhone(String phone) {
        Address.phone = phone;
    }
    public void setCreateDate(LocalDateTime createDate) {
        Address.createDate = createDate;
    }
    public void setCreatedBy(String createdBy) {
        Address.createdBy = createdBy;
    }
    public void setLastUpdate(Timestamp lastUpdate) {
        Address.lastUpdate = lastUpdate;
    }
    public void setLastUpdateBy(String lastUpdateBy) {
        Address.lastUpdateBy = lastUpdateBy;
    }

    //getters
    public int getAddressId() {
        return addressId;
    }
    public String getAddress1() {
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
    public int getCityId() {
        return cityId;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getPhone() {
        return phone;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public static ObservableList<Address> getAllAddresses() throws SQLException {
        ObservableList<Address> allAddresses = SelectDB.selectAllAddresses();
        return allAddresses;
    }

    public Address() {
    }

    public Address(String customerName, boolean active, LocalDateTime createDate, String createdBy, String lastUpdateBy) throws SQLException {
        super(customerName, active, createDate, createdBy, lastUpdateBy);
    }
}
