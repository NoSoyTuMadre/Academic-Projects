/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.CompleteCustomer;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {
    Stage stage;
    Parent scene;
    User user;

    @FXML
    private Label addressTxt;

    @FXML
    private Label cityTxt;

    @FXML
    private Label countryTxt;

    @FXML
    private Label customerIdTxt;

    @FXML
    private Label custNameTxt;

    @FXML
    private Label postalCodeTxt;

    @FXML
    private Label phoneTxt;

    @FXML
    void onActionReturn(ActionEvent event) throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void selectedCustomer(CompleteCustomer cCustomer) throws SQLException {
        try {
            customerIdTxt.setText(String.valueOf(cCustomer.getCustomerId()));
            custNameTxt.setText(cCustomer.getCustomerName());
            if (cCustomer.getAddress2().isEmpty())
                addressTxt.setText(cCustomer.getAddress());
            if (!(cCustomer.getAddress2().isEmpty()))
                addressTxt.setText(cCustomer.getAddress() + ", " + cCustomer.getAddress2());
            cityTxt.setText(cCustomer.getCity());
            postalCodeTxt.setText(cCustomer.getPostalCode());
            countryTxt.setText(cCustomer.getCountry());
            phoneTxt.setText(cCustomer.getPhone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCurrentUser(User currentUser) {
        user = currentUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //selectedCustomer(customer);

    }
}
