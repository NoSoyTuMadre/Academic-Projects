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
import utils.SelectDB;
import utils.UpdateDB;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static utils.ConvertToUTC.convertLDTtoUTC;

public class UpdateApptmtController implements Initializable {

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
    private TableView<CompleteCustomer> customersTbl;

    @FXML
    private TableColumn<CompleteCustomer, String> customerIDCol;

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
    private TextField urlBoxTxt;

    @FXML
    void onMouseClickPopulateAppointment(MouseEvent event) throws SQLException {

        if (!(apptmtsTbl.getSelectionModel().isEmpty())) {
            int newId = apptmtsTbl.getSelectionModel().getSelectedItem().getAppointmentId();
            CompleteAppointment appointment = SelectDB.selectCompleteAppointment(String.valueOf(newId));
            if (appointment.getStart().isBefore(LocalDateTime.now())) {
                JOptionPane.showMessageDialog(null, "Error: You can't change a past appointment!");
                return;
            }
            else {
                LocalDate startD = appointment.getStart().toLocalDate();
                LocalTime startT = appointment.getStart().toLocalTime();
                LocalTime endT = appointment.getEnd().toLocalTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
                //DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                titleTxt.setText(appointment.getTitle());
                descriptionTxt.setText(appointment.getDescription());
                startTimeCB.getSelectionModel().select(startT.format(formatter));
                //startTimeCB.setValue(startT.format(formatter));
                endTimeCB.getSelectionModel().select(endT.format(formatter));
                //endTimeCB.setValue(formatter.format(endT));
                dateCB.setValue(startD);   //Calendar.stringToLocalDate(startD.toString()));
                contactNameHL.setText(appointment.getContact());
                typeCB.getSelectionModel().select(appointment.getType());
                //typeCB.setValue(appointment.getType());
                locationTxt.setText(appointment.getLocation());
                urlBoxTxt.setText(appointment.getUrl());
                customersTbl.getSelectionModel().select(SelectDB.selectCustomerByApptmt(String.valueOf(appointment.getAppointmentId())));
            }
        }
    }

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
            CompleteCustomer cCustomer = SelectDB.selectCustomerByApptmt(String.valueOf(apptmtsTbl.getSelectionModel().getSelectedItem().getAppointmentId()));
            if (cCustomer == null)
                return;
            else {
                stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/CustomerInfo.fxml"));
                //scene = loader.load();
                Scene newScene = new Scene(loader.load());
                /*try {
                    //scene = new Scene(loader.load());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return;
                }

                 */

                CustomerInfoController controller = loader.getController();
                controller.selectedCustomer(cCustomer);
                controller.setCurrentUser(user);
                Stage inputStage = new Stage();
                inputStage.initOwner(stage);
                inputStage.setScene(newScene);
                inputStage.showAndWait();

                /*stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/CustomerInfo.fxml"));
                scene = loader.load();
                //stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
                //scene = FXMLLoader.load(getClass().getResource("/view/ApptmtInfo.fxml"));
                stage.setScene(new Scene(scene));
                CustomerInfoController controller = loader.getController();
                controller.selectedCustomer(cCustomer);
                controller.setCurrentUser(user);
                stage.show();

                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    void onActionUpdateApptmt(ActionEvent event) throws SQLException, IOException {
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
            alert.setTitle("Title Is Required");
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

        String appointmentID = String.valueOf(apptmtsTbl.getSelectionModel().getSelectedItem().getAppointmentId());
        String title = titleTxt.getText();
        String description = descriptionTxt.getText();
        String location = locationTxt.getText();
        String contact = customer.getCustomerName();
        String type = typeCB.getValue();
        String url = urlBoxTxt.getText();
        String[] strings = (startTimeCB.getSelectionModel().getSelectedItem()).split(" ");
        String times = strings[0];
        String[] numbers = times.split(":");
        int hour = parseInt(numbers[0]);
        int minutes = parseInt(numbers[1]);
        if ((strings[1].equals("PM")) && (hour != 12))
            hour = hour + 12;
        if ((strings[1].equals("AM")) && (hour == 12))
            hour = hour - 12;
        LocalTime parsedTime = LocalTime.of(hour, minutes);
        LocalDateTime startTime = LocalDateTime.of(dateCB.getValue(), parsedTime);
        String start = convertLDTtoUTC(startTime);

        String[] strings2 = (endTimeCB.getSelectionModel().getSelectedItem()).split(" ");
        String times2 = strings2[0];
        String[] numbers2 = times2.split(":");
        int hour2 = parseInt(numbers2[0]);
        int minutes2 = parseInt(numbers2[1]);
        if ((strings2[1].equals("PM")) && (hour2 != 12)) {
            hour2 = hour2 + 12;
        }
        if ((strings2[1].equals("AM")) && (hour == 12))
            hour2 = hour2 - 12;
        LocalTime parsedTime2 = LocalTime.of(hour2, minutes2);
        LocalDateTime endTime = LocalDateTime.of(dateCB.getValue(), parsedTime2);
        String end = convertLDTtoUTC(endTime);

        if (startTime.isAfter(endTime)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Time Error");
            alert.setContentText("Appointment cannot end before it starts!");
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
                count += 1;
        }
        if (count == 0)
            doesOverlap = false;

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

        String createDate = convertLDTtoUTC(LocalDateTime.now());
        String createdBy = User.getUserName();
        String lastUpdateBy = User.getUserName();
        if (!doesOverlap) {
            UpdateDB.updateAppointment(appointmentID, customer.getCustomerId(), title, description, location, contact, type, url, start, end, lastUpdateBy);
            //UpdateDB.updateAppointmentWithCustomer(appointmentID, String.valueOf(customer.getCustomerId()));
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

        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.add("New Consult");
        typeList.add("Follow-Up Consult");
        typeList.add("Triggered Consult");
        typeList.add("Routine Consult");
        typeCB.setItems(typeList);

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

        try {
            customersTbl.setItems(CompleteCustomer.getAllCompleteCustomers());
            //customersTbl.setItems(SelectDB.selectAllCustomers());
            customerIDCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            colName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colZip.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
