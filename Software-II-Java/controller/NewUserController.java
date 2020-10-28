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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import utils.InsertDB;
import utils.SelectDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static utils.ConvertToUTC.convertLDTtoUTC;

public class NewUserController implements Initializable {
    Stage stage;
    Parent scene;
    String empty = "Empty fields detected! Please fill up all fields!";

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private PasswordField passwordConfirmTxt;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionNewUser(ActionEvent event) throws SQLException, IOException {
        LocalDateTime createDate = LocalDateTime.now();
        // Checking for empty fields
        if (usernameTxt.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(empty);
            alert.showAndWait();
            return;
        }
        else if (usernameTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(empty);
            alert.showAndWait();
            return;
        }
        else if (passwordTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(empty);
            alert.showAndWait();
            return;
        }
        else if (passwordTxt.getLength() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(empty);
            alert.showAndWait();
            return;
        } else if (passwordConfirmTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(empty);
            alert.showAndWait();
            return;
        }
        else if (passwordConfirmTxt.getLength() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(empty);
            alert.showAndWait();
            return;
        } else if (passwordTxt.getText().equals(passwordConfirmTxt.getText())) {
            ObservableList<User> users = FXCollections.observableArrayList(SelectDB.selectAllUsers());
            for (User user : users) {
                if (user.getUserName().equals(usernameTxt.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Username already used!");
                    alert.showAndWait();
                    return;
                }
            }
                InsertDB.insertUser(usernameTxt.getText(), passwordTxt.getText(), "1", convertLDTtoUTC(createDate), usernameTxt.getText(), usernameTxt.getText());
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Password fields do not match! Please try again.");
            alert.showAndWait();
            return;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
