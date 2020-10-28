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
import java.time.LocalDateTime;

public class CompleteAppointment {
    int appointmentId;
    String contact;
    String userName;
    String title;
    String description;
    String location;
    String type;
    String url;
    String startTime;
    LocalDateTime start;
    String endTime;
    LocalDateTime end;

    private static ObservableList<CompleteAppointment> completeAppointmentsFound = FXCollections.observableArrayList();
    private static ObservableList<CompleteAppointment> allCompleteAppointments = FXCollections.observableArrayList();

    public CompleteAppointment(int appointmentId, String contact, String userName, String title, String description, String location, String type, String url, LocalDateTime start, LocalDateTime end) {
        this.appointmentId = appointmentId;
        this.contact = contact;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.location = location;
        this.url = url;
        this.type = type;
        /*ZoneId localZoneId = ZoneId.of(TimeZone.getDefault().getID());
        LocalDate date = start.toLocalDate();
        LocalTime time = start.toLocalTime();
        ZonedDateTime zdt = ZonedDateTime.of(date, time, localZoneId);

         */
        this.start = start; //zdt.toLocalDateTime();
        /*LocalDate date2 = end.toLocalDate();
        LocalTime time2 = end.toLocalTime();
        ZonedDateTime zdt2 = ZonedDateTime.of(date2, time2, localZoneId);

         */
        this.end = end; //zdt2.toLocalDateTime();
    }

    public CompleteAppointment(int appointmentId, String contact, String userName, String title, String description, String location, String type, String url, String startTime, String endTime) {
        this.appointmentId = appointmentId;
        this.contact = contact;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.location = location;
        this.url = url;
        this.type = type;
        this.startTime = startTime; //zdt.toLocalDateTime();
        this.endTime = endTime; //zdt2.toLocalDateTime();
    }

    public CompleteAppointment() {}

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static void setAllCompleteAppointments(ObservableList<CompleteAppointment> allCompleteAppointments) {
        CompleteAppointment.allCompleteAppointments = allCompleteAppointments;
    }

    public static ObservableList<CompleteAppointment> getAllCompleteAppointments() throws SQLException {
        return SelectDB.selectAllCompleteAppointments();
    }

    public static ObservableList<CompleteAppointment> getCompleteAppointmentsFound() {
        return completeAppointmentsFound;
    }

    public static void setCompleteAppointmentsFound(ObservableList<CompleteAppointment> completeAppointmentsFound) {
        CompleteAppointment.completeAppointmentsFound = completeAppointmentsFound;
    }
}
