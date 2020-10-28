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
import javafx.stage.Stage;
import model.User;
import utils.InsertDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.ResourceBundle;

import static utils.ConvertToUTC.convertLDTtoUTC;

public class AddCustomerController implements Initializable {
    Stage stage;
    Parent scene;
    User user;

    @FXML
    private CheckBox activeCB;

    @FXML
    private TextField firstNameTxt;

    @FXML
    private TextField midInitialTxt;

    @FXML
    private TextField lastNameTxt;

    @FXML
    private TextField addressTxt;

    @FXML
    private TextField address2Txt;

    @FXML
    private TextField cityTxt;

    @FXML
    private ComboBox<String> statesCB;

    @FXML
    private TextField countryTxt;

    @FXML
    private TextField zipCodeTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    void onActionAddCust(ActionEvent event) throws SQLException, IOException {
        //Customer customer = new Customer();
        //Customer.getAllCustomers().add(customer);

        //making sure that a string is only numeric using a lamdba method
        if (!isStringOnlyNumeric(phoneTxt.getText())) {  //utilizes lambda expression to check for digits within string
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Phone Number Entry");
            alert.setHeaderText(null);
            alert.setContentText("Phone number value must contain only numbers!");
            alert.showAndWait();
            return;
        }
        if (!isStringOnlyNumeric(zipCodeTxt.getText())) {  //utilizes lambda expression to check for digits within string
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Zip Code Entry");
            alert.setHeaderText(null);
            alert.setContentText("Zip code value must contain only numbers!");
            alert.showAndWait();
            return;
        }

        //null control for necessary values
        if (firstNameTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("First Name Required");
            alert.setHeaderText(null);
            alert.setContentText("First name must have a value!");
            alert.showAndWait();
            return;
        }
        if (lastNameTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Last Name Required");
            alert.setHeaderText(null);
            alert.setContentText("Last name must have a value!");
            alert.showAndWait();
            return;
        }
        if (addressTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Address Required");
            alert.setHeaderText(null);
            alert.setContentText("Address must have a value!");
            alert.showAndWait();
            return;
        }
        if (cityTxt.getText().isEmpty()) {
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
        if (zipCodeTxt.getText().isEmpty()) {
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

        String fName = firstNameTxt.getText();
        String mName = midInitialTxt.getText();
        String addressInfo = addressTxt.getText();
        String addressInfo2 = address2Txt.getText();
        String cityName = cityTxt.getText();
        String countryName = countryTxt.getText();
        String stateName = statesCB.getValue();
        String lName = lastNameTxt.getText();
        String postalCode = zipCodeTxt.getText();
        String phone = phoneTxt.getText();
        String name = fName + " " + mName + " " + lName;
        if (mName == null)
            name = fName + " " + lName;
        LocalDateTime ldt = LocalDateTime.now(ZoneId.systemDefault());
        String createDate = convertLDTtoUTC(ldt);
        String createdBy = User.getUserName();
        String lastUpdateBy = User.getUserName();
        String activeX = null;
        if (activeCB.isSelected())
            activeX = "1";
        if (!(activeCB.isSelected()))
            activeX = "0";
        String cityN = cityName + ", " + stateName;
        InsertDB.addCustomer(name, addressInfo, addressInfo2, cityN, postalCode, countryName, activeX, phone, createDate, createdBy, lastUpdateBy);

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Dashboard.fxml"));
        scene = loader.load();
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
            stage.setScene(new Scene(scene));
            DashboardController controller = loader.getController();
            controller.setCurrentUser(user);
            stage.show();

        }
    }

    public void setCurrentUser(User currentUser) {
        user = currentUser;
    }

    public static boolean isStringOnlyNumeric(String string) {
        return (string.chars().allMatch(Character::isDigit));   //using lambda expression to check for digit-only string
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        statesCB.getSelectionModel().select(0);
    }
}
