/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import utils.SelectDB;

import java.sql.SQLException;

public class CompleteCustomer {
    String customerId;
    String customerName;
    String address;
    String address2;
    String city;
    String postalCode;
    String country;
    String phone;

    private static ObservableList<CompleteCustomer> completeCustomersFound = FXCollections.observableArrayList();
    private static ObservableList<CompleteCustomer> allCompleteCustomers = FXCollections.observableArrayList();

    public CompleteCustomer(String customerId, String customerName, String address, String address2, String city, String postalCode, String country, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static ObservableList<CompleteCustomer> getAllCompleteCustomers() throws SQLException {
        return SelectDB.selectAllCompleteCustomers();
    }

    public static ObservableList<CompleteCustomer> getCompleteCustomersFound() {
        return completeCustomersFound;
    }

    public ObservableList<CompleteCustomer> filterCompleteCustomers(String str) throws SQLException {
        if (!(getCompleteCustomersFound().isEmpty()))
            getCompleteCustomersFound().clear();
        for (CompleteCustomer completeCustomer : getAllCompleteCustomers()) {
            if (completeCustomer.getCustomerName().toLowerCase().contains(str.toLowerCase()))
                getCompleteCustomersFound().add(completeCustomer);
        }
        if (getCompleteCustomersFound().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your Search Yielded No Results");
            alert.setContentText("Please try your search again!");

            alert.showAndWait();

            return getAllCompleteCustomers();
        }
        else
            return getCompleteCustomersFound();
    }
}
