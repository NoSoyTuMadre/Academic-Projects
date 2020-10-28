/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.SelectDB;
import utils.UpdateDB;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User extends Appointment {

    //declare fields
    private static int userId;
    private static String userName;
    private static String password;
    private static boolean active;
    private static LocalDateTime createDate;
    private static String createdBy;
    private static Timestamp lastUpdate;
    private static String lastUpdateBy;
    private static ObservableList<User> allUsers = FXCollections.observableArrayList();  //TODO

    public User(int userID, String userName, String password, boolean activeX, LocalDateTime createDate, String createdBy, Timestamp lastUpdate, String lastUpdateBy) {
        userId = userID;
        User.userName = userName;
        User.password = password;
        active = activeX;
        User.createDate = createDate;
        User.createdBy = createdBy;
        User.lastUpdate = lastUpdate;
        User.lastUpdateBy = lastUpdateBy;
    }

    //declare methods
    public static ObservableList<User> getAllUsers() throws SQLException {
        return SelectDB.selectAllUsers();
    }

    public User() {}

    public void updateUser(String userID, String password, boolean active) throws SQLException {
        userName = userName;
        User.password = password;
        User.active = active;
        String userId = String.valueOf(getUserId());
        String activeInt = null;
        if (active == false)
            activeInt = "0";
        if (active == true)
            activeInt = "1";
        lastUpdateBy = getUserName();
        UpdateDB.updateUser(userId, userName, password, activeInt, lastUpdateBy);
    }

    //setters
    public static void setUserId(int userId) {
        User.userId = userId;
    }
    public static void setUserName(String userName) {
        User.userName = userName;
    }
    public static void setPassword(String password) {
        User.password = password;
    }
    public static void setActive(boolean active) {
        User.active = active;
    }
    public void setCreateDate(LocalDateTime createDate) {
        User.createDate = createDate;
    }
    public void setCreatedBy(String createdBy) {
        User.createdBy = createdBy;
    }
    public void setLastUpdate(Timestamp lastUpdate) {
        User.lastUpdate = lastUpdate;
    }
    public void setLastUpdateBy(String lastUpdateBy) {
        User.lastUpdateBy = lastUpdateBy;
    }

    //getters
    public static int getUserId() {
        return userId;
    }
    public static String getUserName() {
        return userName;
    }
    public static String getPassword() {
        return password;
    }
    public static boolean isActive() {
        return active;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

}
