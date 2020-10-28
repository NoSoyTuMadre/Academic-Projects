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
import model.CompleteCustomer;
import model.Customer;
import model.User;
import utils.DeleteDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class DeleteCustomerController implements Initializable {

    Stage stage;
    Parent scene;
    User user;

    public ObservableList<CompleteCustomer> filterCompleteCustomers(String str) throws SQLException {
        if (!(CompleteCustomer.getCompleteCustomersFound().isEmpty()))
            CompleteCustomer.getCompleteCustomersFound().clear();
        for (CompleteCustomer completeCustomer : CompleteCustomer.getAllCompleteCustomers()) {
            if ((completeCustomer.getCustomerName().toLowerCase().contains(searchTxt.getText().toLowerCase())) ||
                    (completeCustomer.getCustomerId().toLowerCase().contains(searchTxt.getText().toLowerCase())) ||
                    (completeCustomer.getAddress().toLowerCase().contains(searchTxt.getText().toLowerCase())) ||
                    (completeCustomer.getAddress2().toLowerCase()).contains(searchTxt.getText().toLowerCase()) ||
                    (completeCustomer.getCity().toLowerCase().contains(searchTxt.getText().toLowerCase())) ||
                    (completeCustomer.getPostalCode().toLowerCase().contains(searchTxt.getText().toLowerCase())) ||
                    (completeCustomer.getCountry().toLowerCase().contains(searchTxt.getText().toLowerCase())) ||
                    (completeCustomer.getPhone().toLowerCase().contains(searchTxt.getText().toLowerCase()))) {
                CompleteCustomer.getCompleteCustomersFound().add(completeCustomer);
            }
        }
        if (CompleteCustomer.getCompleteCustomersFound().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your Search Yielded No Results");
            alert.setContentText("Please try your search again!");

            alert.showAndWait();

            return CompleteCustomer.getAllCompleteCustomers();
        }
        else
            return CompleteCustomer.getCompleteCustomersFound();
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
    void onActionDelCust(ActionEvent event) throws SQLException, IOException {
        CompleteCustomer cCustomer = customersTbl.getSelectionModel().getSelectedItem();
        if (cCustomer == null)
            return;
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("You are requesting to delete a Customer from this list.");
            alert.setContentText("Do you wish to continue?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                DeleteDB.deleteCustomer((cCustomer.getCustomerId()));
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
    }

    @FXML
    void onActionSearch(ActionEvent event) throws SQLException {
        String string = searchTxt.getText();

        if (string == null) {
            return;
        }
        else customersTbl.setItems(filterCompleteCustomers(string));
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

    }
}
