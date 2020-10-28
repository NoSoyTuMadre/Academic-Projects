/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CompleteAppointment;
import model.CompleteCustomer;
import model.User;
import utils.DeleteDB;
import utils.SelectDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class DeleteApptmtController implements Initializable {

    Stage stage;
    Parent scene;
    User user;

    public ObservableList<CompleteAppointment> filterCompleteAppointments(String str) throws SQLException {
        if (!(CompleteAppointment.getCompleteAppointmentsFound().isEmpty()))
            CompleteAppointment.getCompleteAppointmentsFound().clear();
        if (str != null) {
            for (CompleteAppointment completeAppointment : SelectDB.selectAllCompleteAppointmentsTable()) {
                if ((String.valueOf(completeAppointment.getAppointmentId()).contains(str.toLowerCase())) ||
                        (completeAppointment.getContact().toLowerCase().contains(str.toLowerCase())) ||
                        (completeAppointment.getUserName().toLowerCase().contains(str.toLowerCase())) ||
                        (completeAppointment.getTitle().toLowerCase()).contains(str.toLowerCase()) ||
                        (completeAppointment.getDescription().toLowerCase().contains(str.toLowerCase())) ||
                        (completeAppointment.getLocation().toLowerCase().contains(str.toLowerCase())) ||
                        (completeAppointment.getType().toLowerCase().contains(str.toLowerCase())) ||
                        (completeAppointment.getUrl().toLowerCase().contains(str.toLowerCase())) ||
                        (String.valueOf(completeAppointment.getStart()).contains(str.toLowerCase())) ||
                        (String.valueOf(completeAppointment.getEnd()).toLowerCase().contains(str.toLowerCase()))) { //||
                        //(completeAppointment.getStartTime().toLowerCase().contains(str.toLowerCase())) ||
                        //(completeAppointment.getEndTime().toLowerCase().contains(str.toLowerCase()))) {
                    CompleteAppointment.getCompleteAppointmentsFound().add(completeAppointment);
                }
            }
        }
        if (CompleteAppointment.getCompleteAppointmentsFound().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your Search Yielded No Results");
            alert.setContentText("Please try your search again!");

            alert.showAndWait();

            return CompleteAppointment.getAllCompleteAppointments();
        }
        else
            return CompleteAppointment.getCompleteAppointmentsFound();
    }


    @FXML
    private TextField searchTxt;

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
    private TableView<CompleteAppointment> apptmtsTbl;

    @FXML
    private TableColumn<CompleteAppointment, String> apptmtIDCol;

    @FXML
    private TableColumn<CompleteAppointment, String> userNameCol;

    @FXML
    private TableColumn<CompleteAppointment, String> contactCol;

    @FXML
    private TableColumn<CompleteAppointment, String> locationCol;

    @FXML
    private TableColumn<CompleteAppointment, String> typeCol;

    @FXML
    private TableColumn<CompleteAppointment, String> startCol;

    @FXML
    private TableColumn<CompleteAppointment, String> endCol;

    @FXML
    void onActionDelApptmt(ActionEvent event) throws SQLException, IOException {
        CompleteAppointment appointment = apptmtsTbl.getSelectionModel().getSelectedItem();

        if (apptmtsTbl.getSelectionModel().isEmpty()) {   //TODO
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Appointment Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select an appointment to delete first!");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are deleting this appointment.");
        alert.setContentText("Do you wish to continue?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            DeleteDB.deleteAppointment(String.valueOf(appointment.getAppointmentId()));

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

    @FXML
    void onActionSearch(ActionEvent event) throws SQLException {
        String string = searchTxt.getText();

        if (string == null) {
            return;
        }
        else apptmtsTbl.setItems(filterCompleteAppointments(string));
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

    public void setCurrentUser(User currentUser) {
        user = currentUser;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            apptmtsTbl.setItems(SelectDB.selectAllCompleteAppointmentsTable());
            //customersTbl.setItems(SelectDB.selectAllCustomers());
            apptmtIDCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
            userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
            contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
            locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
            typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
            startCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
            endCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
