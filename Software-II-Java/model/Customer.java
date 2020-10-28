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

public class Customer extends User {

    //declare fields
    private static int customerId;
    private static String customerName;
    private static int addressId;
    private static boolean active;
    public static LocalDateTime createDate;
    public static String createdBy;
    public static Timestamp lastUpdate;
    public static String lastUpdateBy;

    //declare methods
    public static ObservableList<Customer> getAllCustomers() throws SQLException {
        return SelectDB.selectAllCustomers();
    }

    public Customer() {

    }
    public Customer(int customerId, String customerName, int addressId, boolean active, LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        Customer.customerId = customerId;
        Customer.customerName = customerName;
        Customer.addressId = addressId;
        Customer.active = active;
        Customer.createDate = createDate;
        Customer.createdBy = createdBy;
        Customer.lastUpdate = lastUpdate;
        Customer.lastUpdateBy = lastUpdateBy;
    }
    public Customer(String customerName, boolean active, LocalDateTime createDate, String createdBy, String lastUpdateBy) {
        Customer.customerName = customerName;
        Customer.active = active;
        Customer.createDate = createDate;
        Customer.createdBy = createdBy;
        Customer.lastUpdateBy = lastUpdateBy;
    }

    //declare setters
    public static void setCustomerId(int customerId) {
        Customer.customerId = customerId;
    }
    public static void setCustomerName(String customerName) {
        Customer.customerName = customerName;
    }
    public static void setAddressId(int addressId) {
        Customer.addressId = addressId;
    }
    public static void setActive(boolean active) {
        Customer.active = active;
    }
    public void setCreateDate(LocalDateTime createDate) {
        Customer.createDate = createDate;
    }
    public void setCreatedBy(String createdBy) {
        Customer.createdBy = createdBy;
    }
    public void setLastUpdate(Timestamp lastUpdate) {
        Customer.lastUpdate = lastUpdate;
    }
    public void setLastUpdateBy(String lastUpdateBy) {
        Customer.lastUpdateBy = lastUpdateBy;
    }

    //declare getters
    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public int getAddressId() {
        return addressId;
    }
    @Override
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    @Override
    public String getCreatedBy() {
        return createdBy;
    }
    @Override
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    @Override
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }
    public static boolean isActive() {
        return active;
    }
}
