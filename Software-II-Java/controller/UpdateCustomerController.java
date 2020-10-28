/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CompleteCustomer;
import model.Customer;
import model.User;
import utils.SelectDB;
import utils.UpdateDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class UpdateCustomerController implements Initializable {

    Stage stage;
    Parent scene;
    User user;

    @FXML
    private TableView<CompleteCustomer> customersTbl;

    @FXML
    private TableColumn<CompleteCustomer, String> colID;

    @FXML
    private TableColumn<CompleteCustomer, String> colName;

    @FXML
    private TableColumn<CompleteCustomer, String> colAddress;

    @FXML
    private TableColumn<CompleteCustomer, String> colCity;

    @FXML
    private TableColumn<CompleteCustomer, String> colZip;

    @FXML
    private TableColumn<CompleteCustomer, String> colCountry;

    @FXML
    private TextField firstName;

    @FXML
    private TextField midInitial;

    @FXML
    private TextField lastName;

    @FXML
    private TextField address;

    @FXML
    private TextField city;

    @FXML
    private ComboBox<String> statesCB;

    @FXML
    private TextField country;

    @FXML
    private TextField zipCode;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField address2;

    @FXML
    private CheckBox isActiveCheck;

    @FXML
    void onActionUpdateCust(ActionEvent event) throws IOException, SQLException {
        CompleteCustomer customer = customersTbl.getSelectionModel().getSelectedItem();

        //making sure that a string is only numeric
        if (!isStringOnlyNumeric(phoneTxt.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Phone Number Entry");
            alert.setHeaderText(null);
            alert.setContentText("Phone number value must contain only numbers!");
            alert.showAndWait();
            return;
        }
        if (!isStringOnlyNumeric(zipCode.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Zip Code Entry");
            alert.setHeaderText(null);
            alert.setContentText("Zip code value must contain only numbers!");
            alert.showAndWait();
            return;
        }

        //null control for necessary values
        if (customersTbl.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Customer Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a customer to update first!");
            alert.showAndWait();
            return;
        }
        if (firstName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("First Name Required");
            alert.setHeaderText(null);
            alert.setContentText("First name must have a value!");
            alert.showAndWait();
            return;
        }
        if (lastName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Last Name Required");
            alert.setHeaderText(null);
            alert.setContentText("Last name must have a value!");
            alert.showAndWait();
            return;
        }
        if (address.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Address Required");
            alert.setHeaderText(null);
            alert.setContentText("Address must have a value!");
            alert.showAndWait();
            return;
        }
        if (city.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("City Required");
            alert.setHeaderText(null);
            alert.setContentText("City must have a value!");
            alert.showAndWait();
            return;
        }
        if (statesCB.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("State Required");
            alert.setHeaderText(null);
            alert.setContentText("State must have a value!");
            alert.showAndWait();
            return;
        }
        if (zipCode.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Zip Code Required");
            alert.setHeaderText(null);
            alert.setContentText("Zip code must have a value!");
            alert.showAndWait();
            return;
        }
        if (phoneTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Phone Number Required");
            alert.setHeaderText(null);
            alert.setContentText("Phone must have a value!");
            alert.showAndWait();
            return;
        }

        String customerID = String.valueOf(customer.getCustomerId());
        String name = firstName.getText() + " " + midInitial.getText() + " " + lastName.getText();
        if (midInitial.getText().isEmpty()) {
            name = firstName.getText() + " " + lastName.getText();
        }
        String addressA = address.getText();
        String addressB = address2.getText();
        String cityA = city.getText() + ", " + statesCB.getValue();
        String countryA = country.getText();
        String postalCode = zipCode.getText();
        String phoneA = phoneTxt.getText();
        String lastUpdateBy = User.getUserName();
        String activeX = null;
        if (isActiveCheck.isSelected())
            activeX = "1";
        if (!(isActiveCheck.isSelected()))
            activeX = "0";
        UpdateDB.updateCountry(String.valueOf(SelectDB.selectCountryId(countryA)), countryA, lastUpdateBy);
        UpdateDB.updateCity(String.valueOf(SelectDB.selectCityId(customer.getCity())),cityA, lastUpdateBy);
        UpdateDB.updateAddress(String.valueOf(SelectDB.selectAddressId(customer.getCustomerId())), addressA, addressB, postalCode, phoneA, lastUpdateBy);
        UpdateDB.updateCustomer(customer.getCustomerId(), name, activeX, lastUpdateBy);

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Dashboard.fxml"));
        scene = loader.load();
        //stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
        //scene = FXMLLoader.load(getClass().getResource("/view/ApptmtInfo.fxml"));
        stage.setScene(new Scene(scene));
        DashboardController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are cancelling this operation.");
        alert.setContentText("Do you wish to continue?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/Dashboard.fxml"));
            scene = loader.load();
            //stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            //scene = FXMLLoader.load(getClass().getResource("/view/ApptmtInfo.fxml"));
            stage.setScene(new Scene(scene));
            DashboardController controller = loader.getController();
            controller.setCurrentUser(user);
            stage.show();

            /*stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

             */
        }
    }

    @FXML
    void onMouseClickPopulateFields(MouseEvent event) {
        if (customersTbl.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a customer to update first!");
            alert.showAndWait();
            return;
        }
        else {
            String[] splitStr = (customersTbl.getSelectionModel().getSelectedItem().getCustomerName()).split(" ");
            if (splitStr.length >= 1) {
                firstName.setText(splitStr[0]);
            }
            if (splitStr.length == 3) {
                midInitial.setText(splitStr[1]);
            }
            if (splitStr.length >= 2) {
                lastName.setText(splitStr[2]);
            }
            address.setText(customersTbl.getSelectionModel().getSelectedItem().getAddress());
            address2.setText(customersTbl.getSelectionModel().getSelectedItem().getAddress2());
            String[] splitStr2 = (customersTbl.getSelectionModel().getSelectedItem().getCity()).split(", ");
            city.setText(splitStr2[0]);
            statesCB.getSelectionModel().select(splitStr2[1]);
            zipCode.setText(customersTbl.getSelectionModel().getSelectedItem().getPostalCode());
            country.setText(customersTbl.getSelectionModel().getSelectedItem().getCountry());
            phoneTxt.setText(customersTbl.getSelectionModel().getSelectedItem().getPhone());
        }
    }

    public void setCurrentUser(User currentUser) {
        user = currentUser;
    }

    public static boolean isStringOnlyNumeric(String string) {
        return (string.chars().allMatch(Character::isDigit));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Customer customer = new Customer();

        try {
            customersTbl.setItems(CompleteCustomer.getAllCompleteCustomers());
            colID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            colName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colZip.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObservableList<String> statesList = FXCollections.observableArrayList();
        statesList.add("AL");
        statesList.add("AK");
        statesList.add("AZ");
        statesList.add("AR");
        statesList.add("CA");
        statesList.add("CO");
        statesList.add("CT");
        statesList.add("DE");
        statesList.add("DC");
        statesList.add("FL");
        statesList.add("GA");
        statesList.add("HI");
        statesList.add("ID");
        statesList.add("IL");
        statesList.add("IN");
        statesList.add("IA");
        statesList.add("KS");
        statesList.add("KY");
        statesList.add("LA");
        statesList.add("ME");
        statesList.add("MD");
        statesList.add("MA");
        statesList.add("MI");
        statesList.add("MN");
        statesList.add("MS");
        statesList.add("MO");
        statesList.add("MT");
        statesList.add("NE");
        statesList.add("NV");
        statesList.add("NH");
        statesList.add("NJ");
        statesList.add("NM");
        statesList.add("NY");
        statesList.add("NC");
        statesList.add("ND");
        statesList.add("OH");
        statesList.add("OK");
        statesList.add("OR");
        statesList.add("PA");
        statesList.add("RI");
        statesList.add("SC");
        statesList.add("SD");
        statesList.add("TN");
        statesList.add("TX");
        statesList.add("UT");
        statesList.add("VT");
        statesList.add("VA");
        statesList.add("WA");
        statesList.add("WV");
        statesList.add("WI");
        statesList.add("WY");
        statesCB.setItems(statesList);
        //statesCB.getSelectionModel().select(0);

    }
}
