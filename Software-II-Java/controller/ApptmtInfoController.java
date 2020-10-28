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
import model.CompleteAppointment;
import model.User;
import utils.SelectDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ApptmtInfoController implements Initializable {

    Stage stage;
    Parent scene;
    User user;

    @FXML
    private Label apptmtIdTxt;

    @FXML
    private Label userNameTxt;

    @FXML
    private Label titleTxt;

    @FXML
    private Label contactTxt;

    @FXML
    private Label descriptionTxt;

    @FXML
    private Label startDateTxt;

    @FXML
    private Label endDateTxt;

    @FXML
    private Label startTimeTxt;

    @FXML
    private Label endTimeTxt;

    @FXML
    private Label typeTxt;

    @FXML
    private Label urlTxt;

    @FXML
    void onActionReturn(ActionEvent event) throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void setCurrentUser(User currentUser) {
        user = currentUser;
    }

    public void selectedCustomerName(String apptmtId) throws SQLException {
        userNameTxt.setText(SelectDB.selectCustomerByApptmt(apptmtId).getCustomerName());
    }

    public void selectedApptmt(String appointmentID) throws SQLException {
        try {
            CompleteAppointment appointment = SelectDB.selectCompleteAppointment(appointmentID);
            apptmtIdTxt.setText(String.valueOf(appointment.getAppointmentId()));
            userNameTxt.setText(appointment.getUserName());
            titleTxt.setText(String.valueOf(appointment.getTitle()));
            contactTxt.setText(appointment.getContact());
            descriptionTxt.setText(appointment.getDescription());
            startDateTxt.setText(String.valueOf(appointment.getStart().toLocalDate()));
            endDateTxt.setText(String.valueOf(appointment.getEnd().toLocalDate()));
            startTimeTxt.setText(String.valueOf(appointment.getStart().toLocalTime()));
            endTimeTxt.setText(String.valueOf(appointment.getEnd().toLocalTime()));
            typeTxt.setText(appointment.getType());
            urlTxt.setText(appointment.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
