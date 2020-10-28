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
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.CompleteAppointment;
import model.User;
import utils.SelectDB;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

        Stage stage;
        Parent scene;
        User user;
        String incorrect = "Incorrect Login Credentials";
        String empty = "Empty fields detected! Please fill up all fields!";

    @FXML
        private Label newLbl;

        @FXML
        private Hyperlink requestLbl;

        @FXML
        private Label usernameLbl;

        @FXML
        private TextField usernameTxt;

        @FXML
        private Label passwordLbl;

        @FXML
        private PasswordField passwordTxt;

        @FXML
        private Button loginLbl;

        @FXML
        private Label problemsLbl;

        @FXML
        private Label phoneLbl;

        @FXML
        void onActionNewUser(ActionEvent event) throws IOException {
                stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/NewUser.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
        }

        @FXML
        void onActionLogin(ActionEvent event) throws IOException, SQLException {
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
                } else {
                        String username = usernameTxt.getText();   // Collecting the input
                        String password = passwordTxt.getText(); // Collecting the input
                        if (SelectDB.validate_login(username, password)) {
                                user = SelectDB.selectUser(username, password);
                                try {
                                        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src/files/LoginTimes.txt"), true));
                                        pw.append("Username: ").append(usernameTxt.getText()).append("\t Login Time: ").append(LocalDateTime.now().toLocalDate().toString()).append(" ").append(LocalDateTime.now().toLocalTime().toString()).append("\n");
                                        pw.close();
                                } catch (FileNotFoundException e) {
                                        e.getStackTrace();
                                }

                                checkForNearApptmt();

                                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/view/Dashboard.fxml"));
                                scene = loader.load();
                                stage.setScene(new Scene(scene));
                                DashboardController controller = loader.getController();
                                controller.setCurrentUser(user);
                                stage.show();
                                return;
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle(null);
                            alert.setHeaderText(null);
                            alert.setContentText(incorrect);
                            alert.showAndWait();
                            return;
                        }
                }

        }
/*
    Boolean isRepeated = false;
    public void checkForNearApptmt() throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        ObservableList<CompleteAppointment> allApptmts = FXCollections.observableArrayList(SelectDB.selectAllCompleteAppointments());

        if (!isRepeated) {
            try {
                //allMonthlyApptmts.forEach(x -> ((ChronoUnit.MINUTES.between(x.getStart(), now)<= 15) && (ChronoUnit.MINUTES.between(x.getStart(), now)>= 0));
                for (CompleteAppointment appointments : allApptmts) {
                    for (int i = 0; i < allApptmts.size(); i++) {
                        if (appointments.getStart() == allApptmts.get(i).getStart()) {
                            if (appointments.getStart().isBefore(now.plusMinutes(15)) && appointments.getStart().isAfter(now.minusMinutes(1))) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Appointment Alert");
                                alert.setHeaderText("");
                                alert.setContentText("You have an appointment soon! Please check your calendar!");
                                alert.showAndWait();
                                isRepeated = true;
                                return;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }

 */

ObservableList<CompleteAppointment> availApptmts = FXCollections.observableArrayList();

public void checkForNearApptmt() throws SQLException {
    availApptmts = SelectDB.selectAllCompleteAppointments();

    LocalDateTime now = LocalDateTime.now().minusMinutes(1);
    LocalDateTime interval = now.plusMinutes(15);

    FilteredList<CompleteAppointment> filteredApptmts = new FilteredList<>(availApptmts);

    filteredApptmts.setPredicate(apptmt -> {      //using lambda expression to shorten previous code written that is used to detect an upcoming appointment within the next 15 minutes
                return apptmt.getStart().isAfter(now) && apptmt.getStart().isBefore(interval);
            }
    );
    if (!filteredApptmts.isEmpty()) {
        String contact =  filteredApptmts.get(0).getContact();
        String startTime = filteredApptmts.get(0).getStart().toLocalTime().toString();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Appointment Alert");
        alert.setHeaderText("");
        alert.setContentText("You have an appointment soon with " + contact + " at " + startTime + "! Please check your calendar for more information.");
        alert.showAndWait();
    }

}
        @Override
        public void initialize(URL location, ResourceBundle resources) {

            ResourceBundle rb = ResourceBundle.getBundle("files/login", Locale.getDefault());
                if((Locale.getDefault().getLanguage().equals("es")) || (Locale.getDefault().getLanguage().equals("en"))) {
                    usernameLbl.setText(rb.getString("username"));
                    passwordLbl.setText(rb.getString("password"));
                    problemsLbl.setText(rb.getString("problems"));
                    phoneLbl.setText(rb.getString("phone"));
                    loginLbl.setText(rb.getString("log"));
                    newLbl.setText(rb.getString("new"));
                    requestLbl.setText(rb.getString("request"));
                    incorrect = rb.getString("incorrect");
                    empty = rb.getString("empty");
                }
        }
}