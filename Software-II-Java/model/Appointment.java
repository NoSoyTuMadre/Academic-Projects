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

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointment {

    //declare fields
    private int customerId;
    private int appointmentId;
    private String apptmtTitle;
    private String description;
    private String apptmtLocation;
    private String apptmtContact;
    private String apptmtType;
    private String apptmtUrl;
    private LocalDateTime apptmtStart;
    private LocalDateTime apptmtEnd;
    private LocalDateTime createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdateBy;
    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();  //TODO

    //declare methods
    public static ObservableList<Appointment> getAllAppointments() throws SQLException {
        return SelectDB.selectAllAppointments();
    }
    private static ObservableList<Appointment> appointmentsFound = FXCollections.observableArrayList();

    public Appointment() {
        this.appointmentId = -1;
        this.apptmtTitle = null;
        this.description = null;
        this.apptmtLocation = null;
        this.apptmtContact = null;
        this.apptmtType = null;
        this.apptmtUrl = null;
        this.createDate = null;
        this.createdBy = null;
        this.lastUpdate = null;
        this.lastUpdateBy = null;
    }

    public Appointment(int apptmtId, String apptmtTitle, String description, String apptmtLocation, String apptmtContact,
                            String apptmtType, String apptmtUrl, LocalDateTime createDate, String createdBy,
                            Timestamp lastUpdate, String lastUpdateBy) {
        this.appointmentId = apptmtId;
        this.apptmtTitle = apptmtTitle;
        this.description = description;
        this.apptmtLocation = apptmtLocation;
        this.apptmtContact = apptmtContact;
        this.apptmtType = apptmtType;
        this.apptmtUrl = apptmtUrl;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    //declare setters
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public void setApptmtTitle(String apptmtTitle) {
        this.apptmtTitle = apptmtTitle;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setApptmtLocation(String apptmtLocation) {
        this.apptmtLocation = apptmtLocation;
    }
    public void setApptmtContact(String apptmtContact) {
        this.apptmtContact = apptmtContact;
    }
    public void setApptmtType(String apptmtType) {
        this.apptmtType = apptmtType;
    }
    public void setApptmtUrl(String apptmtUrl) {
        this.apptmtUrl = apptmtUrl;
    }
    public void setApptmtStart(LocalDateTime apptmtStart) {
        this.apptmtStart = apptmtStart;
    }
    public void setApptmtEnd(LocalDateTime apptmtEnd) {
        this.apptmtEnd = apptmtEnd;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public static void setAllAppointments(ObservableList<Appointment> allAppointments) {
        Appointment.allAppointments = allAppointments;
    }
    public static void setAppointmentsFound(ObservableList<Appointment> appointmentsFound) {
        Appointment.appointmentsFound = appointmentsFound;
    }


    //declare getters
    public int getAppointmentId() {
        return appointmentId;
    }
    public String getApptmtTitle() {
        return apptmtTitle;
    }
    public String getDescription() {
        return description;
    }
    public String getApptmtLocation() {
        return apptmtLocation;
    }
    public String getApptmtContact() {
        return apptmtContact;
    }
    public String getApptmtType() {
        return apptmtType;
    }
    public String getApptmtUrl() {
        return apptmtUrl;
    }
    public LocalDateTime getApptmtStart() {
        return apptmtStart;
    }
    public LocalDateTime getApptmtEnd() {
        return apptmtEnd;
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
    public int getCustomerId() {
        return customerId;
    }
    public static ObservableList<Appointment> getAppointmentsFound() {
        return appointmentsFound;
    }
}
