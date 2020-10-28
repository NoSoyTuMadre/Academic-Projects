/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package Toni_Fields_C195_Software_II_Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Appointment;
import model.CompleteAppointment;
import model.CompleteCustomer;
import model.User;
import utils.DBConnection;
import utils.InsertDB;
import utils.SelectDB;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Toni_Fields_C195_Software_II_Project extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        primaryStage.setTitle("Scheduler Login");
        primaryStage.setScene(new Scene(root, 440, 500));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException, IOException {
        
        DBConnection.startConnection();

        User admin = SelectDB.selectUser("admin", "admin");
        User test = SelectDB.selectUser("test", "test");

        if (admin == null)
            InsertDB.insertUser("admin", "admin", "1", LocalDateTime.now().toString(), "admin", "admin");

        if (test == null)
            InsertDB.insertUser("test", "test", "1", LocalDateTime.now().toString(), "admin", "admin");

        launch(args);
        DBConnection.closeConnection();
    }
}
