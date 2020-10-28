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
import javafx.util.Callback;
import model.CompleteAppointment;
import model.CompleteCustomer;
import model.User;
import utils.InsertDB;
import utils.SelectDB;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static utils.ConvertToUTC.convertLDTtoUTC;

public class AddApptmtController implements Initializable {

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
    private TextField titleTxt;

    @FXML
    private ChoiceBox<String> typeCB;

    @FXML
    private TextField descriptionTxt;

    @FXML
    private DatePicker dateCB;

    @FXML
    private TextField locationTxt;

    @FXML
    private ChoiceBox<String> startTimeCB;

    @FXML
    private Hyperlink contactNameHL;

    @FXML
    private ChoiceBox<String> endTimeCB;

    @FXML
    private TextField urlTxt;

    @FXML
    void onMouseClickPopulateContact(MouseEvent event) {
        if (customersTbl.getSelectionModel().isEmpty())
            return;
        else
            contactNameHL.setText(customersTbl.getSelectionModel().getSelectedItem().getCustomerName());
    }

    @FXML
    void onActionCustomerInfo(ActionEvent event) {
        try {
            CompleteCustomer cCustomer = customersTbl.getSelectionModel().getSelectedItem();
            if (cCustomer == null)
                return;
            else {
                stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/CustomerInfo.fxml"));
                Scene newScene = new Scene(loader.load());

                CustomerInfoController controller = loader.getController();
                controller.selectedCustomer(cCustomer);
                controller.setCurrentUser(user);
                Stage inputStage = new Stage();
                inputStage.initOwner(stage);
                inputStage.setScene(newScene);
                inputStage.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionAddApptmt(ActionEvent event) throws IOException, SQLException {

        if (customersTbl.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a contact for this appointment first!");
            alert.showAndWait();
            return;
        }

        if (customersTbl.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a contact for this appointment first!");
            alert.showAndWait();
            return;
        }
        CompleteCustomer customer = customersTbl.getSelectionModel().getSelectedItem();

        //null control for required values
        if (titleTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Title Is Required");
            alert.setHeaderText(null);
            alert.setContentText("Title must have a value!");
            alert.showAndWait();
            return;
        }
        if (descriptionTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Description Is Required");
            alert.setHeaderText(null);
            alert.setContentText("Description must have a value!");
            alert.showAndWait();
            return;
        }
        if (locationTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Location Is Required");
            alert.setHeaderText(null);
            alert.setContentText("Location must have a value!");
            alert.showAndWait();
            return;
        }
        if (typeCB.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Type Is Required");
            alert.setHeaderText(null);
            alert.setContentText("Type must have a value!");
            alert.showAndWait();
            return;
        }
        if (startTimeCB.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Start Time Is Required");
            alert.setHeaderText(null);
            alert.setContentText("Start time must have a value!");
            alert.showAndWait();
            return;
        }
        if (endTimeCB.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("End Time Is Required");
            alert.setHeaderText(null);
            alert.setContentText("End time must have a value!");
            alert.showAndWait();
            return;
        }

        String title = titleTxt.getText();
        String description = descriptionTxt.getText();
        String location = locationTxt.getText();
        String contact = contactNameHL.getText();
        String type = typeCB.getValue();
        String url = urlTxt.getText();

        String[] splitStr = startTimeCB.getValue().split(" ");
        String splitTime = splitStr[0];
        String splitAmPm = splitStr[1];

        String[] splitUpAgain = splitTime.split(":");
        int newHour = parseInt(splitUpAgain[0]);
        if ((splitAmPm.equals("PM")) && (newHour != 12))
            newHour = newHour + 12;
        if ((splitAmPm.equals("AM")) && (newHour == 12))
            newHour = newHour - 12;
        int newMinute = parseInt(splitUpAgain[1]);
        LocalTime timeA = LocalTime.of(newHour, newMinute);

        String[] splitStr2 = endTimeCB.getValue().split(" ");
        String splitTime2 = splitStr2[0];
        String splitAmPm2 = splitStr2[1];

        String[] splitUpAgain2 = splitTime2.split(":");
        int newHour2 = parseInt(splitUpAgain2[0]);
        if ((splitAmPm2.equals("PM")) && (newHour2 != 12))
            newHour2 = newHour2 + 12;
        if ((splitAmPm2.equals("AM")) && (newHour == 12))
            newHour = newHour - 12;
        int newMinute2 = parseInt(splitUpAgain2[1]);
        LocalTime timeB = LocalTime.of(newHour2, newMinute2);

        LocalDateTime startTime = LocalDateTime.of(dateCB.getValue(), timeA);
        LocalDateTime endTime = LocalDateTime.of(dateCB.getValue(), timeB);

        if (startTime.isAfter(endTime)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Time Error");
            alert.setContentText("Appointment cannot end before it starts!");
            alert.showAndWait();
            return;
        }

        //checking to see if appointment is within normal business hours (8 AM to 6 PM)
        LocalTime before8 = LocalTime.of(8, 0);
        LocalTime after6 = LocalTime.of(18, 0);

        if ((startTime.toLocalTime().isBefore(before8)) || (startTime.toLocalTime().isAfter(after6)) ||
                (endTime.toLocalTime().isBefore(before8)) || (endTime.toLocalTime().isAfter(after6)) ||
                (startTime.toLocalDate().getDayOfWeek().equals(SATURDAY)) || (startTime.toLocalDate().getDayOfWeek().equals(SUNDAY))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Time Error");
            alert.setContentText("Appointment must be within normal business hours (Monday through Friday from 8 AM to 6 PM)!");
            alert.showAndWait();
            return;
        }

        //checking for overlapping appointments
        Boolean doesOverlap = true;
        int count = 0;

        for (CompleteAppointment appointment : SelectDB.selectAllCompleteAppointments()) {
            if (((appointment.getStart().isAfter(startTime)) && (appointment.getStart().isBefore(endTime))) ||
                    ((appointment.getEnd().isAfter(startTime)) && (appointment.getEnd().isBefore(endTime))) ||
                    ((appointment.getStart().isBefore(startTime)) && (appointment.getEnd().isAfter(endTime))) ||
                    (appointment.getStart().equals(startTime)) || (appointment.getEnd().equals(endTime)) ||
                    (appointment.getStart().equals(endTime)) || (appointment.getEnd().equals(startTime)))
                count = count + 1;
        }
        if (count == 0)
            doesOverlap = false;

        String startE = convertLDTtoUTC(startTime);
        String endE = convertLDTtoUTC(endTime);
        String createDate = convertLDTtoUTC(LocalDateTime.now());
        String createdBy = User.getUserName();
        String lastUpdateBy = User.getUserName();
        if (!doesOverlap) {
            InsertDB.addAppointment(customer.getCustomerId(), String.valueOf(User.getUserId()), title, description, location, contact, type, url, startE, endE, createDate, createdBy, lastUpdateBy, String.valueOf(User.getUserId()), customer.getCustomerId());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Time Error");
            alert.setContentText("Appointment time cannot overlap a pre-existing appointment time!");
            alert.showAndWait();
            return;
        }

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

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if ((item.getDayOfYear() < LocalDate.now().getDayOfYear()) && (item.getYear() <= LocalDate.now().getYear())) {
                            // Don't allow past appointments.
                            setDisable(true);
                        }
                    }
                };
            }
        };
        dateCB.setDayCellFactory(dayCellFactory);

        try {
            ObservableList<String> typeList = FXCollections.observableArrayList();
            typeList.add("New Consult");
            typeList.add("Follow-Up Consult");
            typeList.add("Triggered Consult");
            typeList.add("Routine Consult");
            typeCB.setItems(typeList);
            typeCB.getSelectionModel().select(0);

            ObservableList<String> startList = FXCollections.observableArrayList();
            startList.add("12:00 AM");
            startList.add("12:30 AM");
            startList.add("1:00 AM");
            startList.add("1:30 AM");
            startList.add("2:00 AM");
            startList.add("2:30 AM");
            startList.add("3:00 AM");
            startList.add("3:30 AM");
            startList.add("4:00 AM");
            startList.add("4:30 AM");
            startList.add("5:00 AM");
            startList.add("5:30 AM");
            startList.add("6:00 AM");
            startList.add("6:30 AM");
            startList.add("7:00 AM");
            startList.add("7:30 AM");
            startList.add("8:00 AM");
            startList.add("8:30 AM");
            startList.add("9:00 AM");
            startList.add("9:30 AM");
            startList.add("10:00 AM");
            startList.add("10:30 AM");
            startList.add("11:00 AM");
            startList.add("11:30 AM");
            startList.add("12:00 PM");
            startList.add("12:30 PM");
            startList.add("1:00 PM");
            startList.add("1:30 PM");
            startList.add("2:00 PM");
            startList.add("2:30 PM");
            startList.add("3:00 PM");
            startList.add("3:30 PM");
            startList.add("4:00 PM");
            startList.add("4:30 PM");
            startList.add("5:00 PM");
            startList.add("5:30 PM");
            startList.add("6:00 PM");
            startList.add("6:30 PM");
            startList.add("7:00 PM");
            startList.add("7:30 PM");
            startList.add("8:00 PM");
            startList.add("8:30 PM");
            startList.add("9:00 PM");
            startList.add("9:30 PM");
            startList.add("10:00 PM");
            startList.add("10:30 PM");
            startList.add("11:00 PM");
            startList.add("11:30 PM");
            startTimeCB.setItems(startList);

            ObservableList<String> endList = FXCollections.observableArrayList();
            endList.add("12:29 AM");
            endList.add("12:59 AM");
            endList.add("1:29 AM");
            endList.add("1:59 AM");
            endList.add("2:29 AM");
            endList.add("2:59 AM");
            endList.add("3:29 AM");
            endList.add("3:59 AM");
            endList.add("4:29 AM");
            endList.add("4:59 AM");
            endList.add("5:29 AM");
            endList.add("5:59 AM");
            endList.add("6:29 AM");
            endList.add("6:59 AM");
            endList.add("7:29 AM");
            endList.add("7:59 AM");
            endList.add("8:29 AM");
            endList.add("8:59 AM");
            endList.add("9:29 AM");
            endList.add("9:59 AM");
            endList.add("10:29 AM");
            endList.add("10:59 AM");
            endList.add("11:29 AM");
            endList.add("11:59 PM");
            endList.add("12:29 PM");
            endList.add("12:59 PM");
            endList.add("1:29 PM");
            endList.add("1:59 PM");
            endList.add("2:29 PM");
            endList.add("2:59 PM");
            endList.add("3:29 PM");
            endList.add("3:59 PM");
            endList.add("4:29 PM");
            endList.add("4:59 PM");
            endList.add("5:29 PM");
            endList.add("5:59 PM");
            endList.add("6:29 PM");
            endList.add("6:59 PM");
            endList.add("7:29 PM");
            endList.add("7:59 PM");
            endList.add("8:29 PM");
            endList.add("8:59 PM");
            endList.add("9:29 PM");
            endList.add("9:59 PM");
            endList.add("10:29 PM");
            endList.add("10:59 PM");
            endList.add("11:29 PM");
            endList.add("11:59 PM");
            endTimeCB.setItems(endList);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            customersTbl.setItems(CompleteCustomer.getAllCompleteCustomers());
            //customersTbl.setItems(SelectDB.selectAllCustomers());
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
