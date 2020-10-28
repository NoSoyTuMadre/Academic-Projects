/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C195 - Software II
 * Project: Scheduling Application
 */

package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import static utils.ConvertToUTC.convertLDTtoUTC;
import static utils.ConvertToUTC.convertUTCtoLDT;

public class Calendar {
    LocalDate startDate;
    LocalTime startTime;
    LocalTime endTime;
    int appointmentId;

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Calendar(LocalDate startDate, LocalTime startTime, LocalTime endTime, int appointmentId) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.appointmentId = appointmentId;
    }

    public static ObservableList<Calendar> calendarInfo = FXCollections.observableArrayList();

    public static ObservableList<Calendar> getCalendarInfoByDate(String userId, LocalDate date) throws SQLException {

//put some code that retrieves time from SQL server

        LocalTime lt1 = LocalTime.of(0, 0, 0);
        LocalTime lt2 = LocalTime.of(23, 59, 59);
        String newDate1 = convertLDTtoUTC(LocalDateTime.of(date, lt1));
        String newDate2 = convertLDTtoUTC(LocalDateTime.of(date, lt2));

        Connection conn = DBConnection.startConnection();
        //String selectStatement = "SELECT * FROM appointment WHERE DATE(start)=? ORDER BY start DESC";
        String selectStatement = "SELECT * FROM appointment WHERE userId=? AND start BETWEEN ? AND ? ORDER BY start ASC";

        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, userId);
        ps.setString(2, newDate1);
        ps.setString(3, newDate2);
        ps.execute();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {  //not sure how to get each time result-maybe store it in an array somehow
            //LocalDate startDateA = rs.getDate("start").toLocalDate();
            LocalTime startTimeA = convertUTCtoLDT(rs.getTimestamp("start")).toLocalTime();
            LocalTime endTimeA = convertUTCtoLDT(rs.getTimestamp("end")).toLocalTime();
            LocalDate startDateA = convertUTCtoLDT(rs.getTimestamp("start")).toLocalDate();
            int appointmentIDA = rs.getInt("appointmentId");
            if (startDateA == date) {
                //calendarInfoId = calendarInfoId + 1;
                calendarInfo.add(new Calendar(startDateA, startTimeA, endTimeA, appointmentIDA));
            }
        }
        rs.close();
        ps.close();
        conn.close();
        //System.out.println(calendarInfo.size());
        return calendarInfo;
    }

    //Zeller's Rule for finding what day is given date
    public static String dayOfWeek(int month, int day, int year) {
//        int y = year - (14 - month) / 12;
//        int x = y + y / 4 - y / 100 + y / 400;
//        int m = month + 12 * ((14 - month) / 12) - 2;
        try {
            DateFormat format = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
            Date date = format.parse(month + "-" + day + "-" + year);
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int mon = localDate.getMonthValue();
            int D = year % 100;
            int C = year / 100;
            int dayOfWeek = (day + ((13 * mon - 1) / 5) + D + (D / 4) + (C / 4) - 2 * C) % 7;
 /*           if (dayOfWeek == 0)
                return "Sunday";
            if (dayOfWeek == 1)
                return "Monday";
            if (dayOfWeek == 2)
                return "Tuesday";
            if (dayOfWeek == 3)
                return "Wednesday";
            if (dayOfWeek == 4)
                return "Thursday";
            if (dayOfWeek == 5)
                return "Friday";
            if (dayOfWeek == 6)
                return "Saturday";

  */
 return String.valueOf(dayOfWeek);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Error");
            alert.setContentText("Check your values again! (dayOfWeek Error");

            alert.showAndWait();
        }
return(null);
    }

    public static int dayOfWeekNum(int month, int day, int year) {
        try {
            if (month == 1) {
                month = 11;
                year = year - 1;
            } else if (month == 2) {
                month = 12;
                year = year - 1;
            } else {
                month = month - 2;
            }
            int D = year % 100;
            int C = year / 100;

            int dayOfWeek = day + ((13 * month - 1) / 5) + D + (D / 4) + (C / 4) - (2 * C);   //Zeller's Rule

            if (dayOfWeek < 0) {
                if (dayOfWeek > (-7)) {
                    dayOfWeek = dayOfWeek + 7;
                    return dayOfWeek;
                }
                dayOfWeek = dayOfWeek % (-7);
                if (dayOfWeek == 0) {
                    return dayOfWeek;
                } else {
                    dayOfWeek = dayOfWeek + 7;
                    return dayOfWeek;
                }
            }
            else if ((dayOfWeek == 0) || ((dayOfWeek > 0) && (dayOfWeek < 7))) {
                return dayOfWeek;
            }
 /*           if (dayOfWeek == 0)
                return "Sunday";
            if (dayOfWeek == 1)
                return "Monday";
            if (dayOfWeek == 2)
                return "Tuesday";
            if (dayOfWeek == 3)
                return "Wednesday";
            if (dayOfWeek == 4)
                return "Thursday";
            if (dayOfWeek == 5)
                return "Friday";
            if (dayOfWeek == 6)
                return "Saturday";

  */

 else {
     dayOfWeek = dayOfWeek % 7;
     return dayOfWeek;
 }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Error");
            alert.setContentText("Check your values again! (dayOfWeekNum)");

            alert.showAndWait();
        }
        return(0);
    }

    // return true if the given year is a leap year
    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

}
