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
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.CompleteAppointment;
import model.User;
import utils.*;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class DashboardController implements Initializable {

    Stage stage;
    Parent scene;
    User user;

    ObservableList<CompleteAppointment> allMonthlyApptmts = FXCollections.observableArrayList();
    ArrayList<CompleteAppointment> allDailyApptmts = new ArrayList();
    LocalTime start = null;
    LocalTime end = null;
    int apptmtID = 0;

    @FXML
    private Label monthLbl;

    @FXML
    private Label yearLbl2;

    @FXML
    private Label yearLbl1;

    @FXML
    private Label Lbl1;

    @FXML
    private Label Lbl2;

    @FXML
    private Label Lbl3;

    @FXML
    private Label Lbl4;

    @FXML
    private Label Lbl5;

    @FXML
    private Label Lbl6;

    @FXML
    private Label Lbl7;

    @FXML
    private Label Lbl8;

    @FXML
    private Label Lbl9;

    @FXML
    private Label Lbl10;

    @FXML
    private Label Lbl11;

    @FXML
    private Label Lbl12;

    @FXML
    private Label Lbl13;

    @FXML
    private Label Lbl14;

    @FXML
    private Label Lbl15;

    @FXML
    private Label Lbl16;

    @FXML
    private Label Lbl17;

    @FXML
    private Label Lbl18;

    @FXML
    private Label Lbl19;

    @FXML
    private Label Lbl20;

    @FXML
    private Label Lbl21;

    @FXML
    private Label Lbl22;

    @FXML
    private Label Lbl23;

    @FXML
    private Label Lbl24;

    @FXML
    private Label Lbl25;

    @FXML
    private Label Lbl26;

    @FXML
    private Label Lbl27;

    @FXML
    private Label Lbl28;

    @FXML
    private Label Lbl29;

    @FXML
    private Label Lbl30;

    @FXML
    private Label Lbl31;

    @FXML
    private Label Lbl32;

    @FXML
    private Label Lbl33;

    @FXML
    private Label Lbl34;

    @FXML
    private Label Lbl35;

    @FXML
    private Label Lbl36;

    @FXML
    private Label Lbl37;

    @FXML
    private Label Lbl38;

    @FXML
    private Label Lbl39;

    @FXML
    private Label Lbl40;

    @FXML
    private Label Lbl41;

    @FXML
    private Label Lbl42;

    @FXML
    private Hyperlink apptmtID1of1;

    @FXML
    private Hyperlink apptmtID2of1;

    @FXML
    private Hyperlink apptmtID3of1;

    @FXML
    private Hyperlink apptmtID4of1;

    @FXML
    private Hyperlink apptmtID5of1;

    @FXML
    private Hyperlink apptmtID6of1;

    @FXML
    private Label time1of1;

    @FXML
    private Label time2of1;

    @FXML
    private Label time3of1;

    @FXML
    private Label time4of1;

    @FXML
    private Label time5of1;

    @FXML
    private Label time6of1;

    @FXML
    private Hyperlink apptmtID1of2;

    @FXML
    private Hyperlink apptmtID2of2;

    @FXML
    private Hyperlink apptmtID3of2;

    @FXML
    private Hyperlink apptmtID4of2;

    @FXML
    private Hyperlink apptmtID5of2;

    @FXML
    private Hyperlink apptmtID6of2;

    @FXML
    private Label time1of2;

    @FXML
    private Label time2of2;

    @FXML
    private Label time3of2;

    @FXML
    private Label time4of2;

    @FXML
    private Label time5of2;

    @FXML
    private Label time6of2;

    @FXML
    private Hyperlink apptmtID1of3;

    @FXML
    private Hyperlink apptmtID2of3;

    @FXML
    private Hyperlink apptmtID3of3;

    @FXML
    private Hyperlink apptmtID4of3;

    @FXML
    private Hyperlink apptmtID5of3;

    @FXML
    private Hyperlink apptmtID6of3;

    @FXML
    private Label time1of3;

    @FXML
    private Label time2of3;

    @FXML
    private Label time3of3;

    @FXML
    private Label time4of3;

    @FXML
    private Label time5of3;

    @FXML
    private Label time6of3;

    @FXML
    private Hyperlink apptmtID1of4;

    @FXML
    private Hyperlink apptmtID2of4;

    @FXML
    private Hyperlink apptmtID3of4;

    @FXML
    private Hyperlink apptmtID4of4;

    @FXML
    private Hyperlink apptmtID5of4;

    @FXML
    private Hyperlink apptmtID6of4;

    @FXML
    private Label time1of4;

    @FXML
    private Label time2of4;

    @FXML
    private Label time3of4;

    @FXML
    private Label time4of4;

    @FXML
    private Label time5of4;

    @FXML
    private Label time6of4;

    @FXML
    private Hyperlink apptmtID1of5;

    @FXML
    private Hyperlink apptmtID2of5;

    @FXML
    private Hyperlink apptmtID3of5;

    @FXML
    private Hyperlink apptmtID4of5;

    @FXML
    private Hyperlink apptmtID5of5;

    @FXML
    private Hyperlink apptmtID6of5;

    @FXML
    private Label time1of5;

    @FXML
    private Label time2of5;

    @FXML
    private Label time3of5;

    @FXML
    private Label time4of5;

    @FXML
    private Label time5of5;

    @FXML
    private Label time6of5;

    @FXML
    private Hyperlink apptmtID1of6;

    @FXML
    private Hyperlink apptmtID2of6;

    @FXML
    private Hyperlink apptmtID3of6;

    @FXML
    private Hyperlink apptmtID4of6;

    @FXML
    private Hyperlink apptmtID5of6;

    @FXML
    private Hyperlink apptmtID6of6;

    @FXML
    private Label time1of6;

    @FXML
    private Label time2of6;

    @FXML
    private Label time3of6;

    @FXML
    private Label time4of6;

    @FXML
    private Label time5of6;

    @FXML
    private Label time6of6;

    @FXML
    private Hyperlink apptmtID1of7;

    @FXML
    private Hyperlink apptmtID2of7;

    @FXML
    private Hyperlink apptmtID3of7;

    @FXML
    private Hyperlink apptmtID4of7;

    @FXML
    private Hyperlink apptmtID5of7;

    @FXML
    private Hyperlink apptmtID6of7;

    @FXML
    private Label time1of7;

    @FXML
    private Label time2of7;

    @FXML
    private Label time3of7;

    @FXML
    private Label time4of7;

    @FXML
    private Label time5of7;

    @FXML
    private Label time6of7;

    @FXML
    private Hyperlink apptmtID1of8;

    @FXML
    private Hyperlink apptmtID2of8;

    @FXML
    private Hyperlink apptmtID3of8;

    @FXML
    private Hyperlink apptmtID4of8;

    @FXML
    private Hyperlink apptmtID5of8;

    @FXML
    private Hyperlink apptmtID6of8;

    @FXML
    private Label time1of8;

    @FXML
    private Label time2of8;

    @FXML
    private Label time3of8;

    @FXML
    private Label time4of8;

    @FXML
    private Label time5of8;

    @FXML
    private Label time6of8;

    @FXML
    private Hyperlink apptmtID1of9;

    @FXML
    private Hyperlink apptmtID2of9;

    @FXML
    private Hyperlink apptmtID3of9;

    @FXML
    private Hyperlink apptmtID4of9;

    @FXML
    private Hyperlink apptmtID5of9;

    @FXML
    private Hyperlink apptmtID6of9;

    @FXML
    private Label time1of9;

    @FXML
    private Label time2of9;

    @FXML
    private Label time3of9;

    @FXML
    private Label time4of9;

    @FXML
    private Label time5of9;

    @FXML
    private Label time6of9;

    @FXML
    private Hyperlink apptmtID1of10;

    @FXML
    private Hyperlink apptmtID2of10;

    @FXML
    private Hyperlink apptmtID3of10;

    @FXML
    private Hyperlink apptmtID4of10;

    @FXML
    private Hyperlink apptmtID5of10;

    @FXML
    private Hyperlink apptmtID6of10;

    @FXML
    private Label time1of10;

    @FXML
    private Label time2of10;

    @FXML
    private Label time3of10;

    @FXML
    private Label time4of10;

    @FXML
    private Label time5of10;

    @FXML
    private Label time6of10;

    @FXML
    private Hyperlink apptmtID1of11;

    @FXML
    private Hyperlink apptmtID2of11;

    @FXML
    private Hyperlink apptmtID3of11;

    @FXML
    private Hyperlink apptmtID4of11;

    @FXML
    private Hyperlink apptmtID5of11;

    @FXML
    private Hyperlink apptmtID6of11;

    @FXML
    private Label time1of11;

    @FXML
    private Label time2of11;

    @FXML
    private Label time3of11;

    @FXML
    private Label time4of11;

    @FXML
    private Label time5of11;

    @FXML
    private Label time6of11;

    @FXML
    private Hyperlink apptmtID1of12;

    @FXML
    private Hyperlink apptmtID2of12;

    @FXML
    private Hyperlink apptmtID3of12;

    @FXML
    private Hyperlink apptmtID4of12;

    @FXML
    private Hyperlink apptmtID5of12;

    @FXML
    private Hyperlink apptmtID6of12;

    @FXML
    private Label time1of12;

    @FXML
    private Label time2of12;

    @FXML
    private Label time3of12;

    @FXML
    private Label time4of12;

    @FXML
    private Label time5of12;

    @FXML
    private Label time6of12;

    @FXML
    private Hyperlink apptmtID1of13;

    @FXML
    private Hyperlink apptmtID2of13;

    @FXML
    private Hyperlink apptmtID3of13;

    @FXML
    private Hyperlink apptmtID4of13;

    @FXML
    private Hyperlink apptmtID5of13;

    @FXML
    private Hyperlink apptmtID6of13;

    @FXML
    private Label time1of13;

    @FXML
    private Label time2of13;

    @FXML
    private Label time3of13;

    @FXML
    private Label time4of13;

    @FXML
    private Label time5of13;

    @FXML
    private Label time6of13;

    @FXML
    private Hyperlink apptmtID1of14;

    @FXML
    private Hyperlink apptmtID2of14;

    @FXML
    private Hyperlink apptmtID3of14;

    @FXML
    private Hyperlink apptmtID4of14;

    @FXML
    private Hyperlink apptmtID5of14;

    @FXML
    private Hyperlink apptmtID6of14;

    @FXML
    private Label time1of14;

    @FXML
    private Label time2of14;

    @FXML
    private Label time3of14;

    @FXML
    private Label time4of14;

    @FXML
    private Label time5of14;

    @FXML
    private Label time6of14;

    @FXML
    private Hyperlink apptmtID1of15;

    @FXML
    private Hyperlink apptmtID2of15;

    @FXML
    private Hyperlink apptmtID3of15;

    @FXML
    private Hyperlink apptmtID4of15;

    @FXML
    private Hyperlink apptmtID5of15;

    @FXML
    private Hyperlink apptmtID6of15;

    @FXML
    private Label time1of15;

    @FXML
    private Label time2of15;

    @FXML
    private Label time3of15;

    @FXML
    private Label time4of15;

    @FXML
    private Label time5of15;

    @FXML
    private Label time6of15;

    @FXML
    private Hyperlink apptmtID1of16;

    @FXML
    private Hyperlink apptmtID2of16;

    @FXML
    private Hyperlink apptmtID3of16;

    @FXML
    private Hyperlink apptmtID4of16;

    @FXML
    private Hyperlink apptmtID5of16;

    @FXML
    private Hyperlink apptmtID6of16;

    @FXML
    private Label time1of16;

    @FXML
    private Label time2of16;

    @FXML
    private Label time3of16;

    @FXML
    private Label time4of16;

    @FXML
    private Label time5of16;

    @FXML
    private Label time6of16;

    @FXML
    private Hyperlink apptmtID1of17;

    @FXML
    private Hyperlink apptmtID2of17;

    @FXML
    private Hyperlink apptmtID3of17;

    @FXML
    private Hyperlink apptmtID4of17;

    @FXML
    private Hyperlink apptmtID5of17;

    @FXML
    private Hyperlink apptmtID6of17;

    @FXML
    private Label time1of17;

    @FXML
    private Label time2of17;

    @FXML
    private Label time3of17;

    @FXML
    private Label time4of17;

    @FXML
    private Label time5of17;

    @FXML
    private Label time6of17;

    @FXML
    private Hyperlink apptmtID1of18;

    @FXML
    private Hyperlink apptmtID2of18;

    @FXML
    private Hyperlink apptmtID3of18;

    @FXML
    private Hyperlink apptmtID4of18;

    @FXML
    private Hyperlink apptmtID5of18;

    @FXML
    private Hyperlink apptmtID6of18;

    @FXML
    private Label time1of18;

    @FXML
    private Label time2of18;

    @FXML
    private Label time3of18;

    @FXML
    private Label time4of18;

    @FXML
    private Label time5of18;

    @FXML
    private Label time6of18;

    @FXML
    private Hyperlink apptmtID1of19;

    @FXML
    private Hyperlink apptmtID2of19;

    @FXML
    private Hyperlink apptmtID3of19;

    @FXML
    private Hyperlink apptmtID4of19;

    @FXML
    private Hyperlink apptmtID5of19;

    @FXML
    private Hyperlink apptmtID6of19;

    @FXML
    private Label time1of19;

    @FXML
    private Label time2of19;

    @FXML
    private Label time3of19;

    @FXML
    private Label time4of19;

    @FXML
    private Label time5of19;

    @FXML
    private Label time6of19;

    @FXML
    private Hyperlink apptmtID1of20;

    @FXML
    private Hyperlink apptmtID2of20;

    @FXML
    private Hyperlink apptmtID3of20;

    @FXML
    private Hyperlink apptmtID4of20;

    @FXML
    private Hyperlink apptmtID5of20;

    @FXML
    private Hyperlink apptmtID6of20;

    @FXML
    private Label time1of20;

    @FXML
    private Label time2of20;

    @FXML
    private Label time3of20;

    @FXML
    private Label time4of20;

    @FXML
    private Label time5of20;

    @FXML
    private Label time6of20;

    @FXML
    private Hyperlink apptmtID1of21;

    @FXML
    private Hyperlink apptmtID2of21;

    @FXML
    private Hyperlink apptmtID3of21;

    @FXML
    private Hyperlink apptmtID4of21;

    @FXML
    private Hyperlink apptmtID5of21;

    @FXML
    private Hyperlink apptmtID6of21;

    @FXML
    private Label time1of21;

    @FXML
    private Label time2of21;

    @FXML
    private Label time3of21;

    @FXML
    private Label time4of21;

    @FXML
    private Label time5of21;

    @FXML
    private Label time6of21;

    @FXML
    private Hyperlink apptmtID1of22;

    @FXML
    private Hyperlink apptmtID2of22;

    @FXML
    private Hyperlink apptmtID3of22;

    @FXML
    private Hyperlink apptmtID4of22;

    @FXML
    private Hyperlink apptmtID5of22;

    @FXML
    private Hyperlink apptmtID6of22;

    @FXML
    private Label time1of22;

    @FXML
    private Label time2of22;

    @FXML
    private Label time3of22;

    @FXML
    private Label time4of22;

    @FXML
    private Label time5of22;

    @FXML
    private Label time6of22;

    @FXML
    private Hyperlink apptmtID1of23;

    @FXML
    private Hyperlink apptmtID2of23;

    @FXML
    private Hyperlink apptmtID3of23;

    @FXML
    private Hyperlink apptmtID4of23;

    @FXML
    private Hyperlink apptmtID5of23;

    @FXML
    private Hyperlink apptmtID6of23;

    @FXML
    private Label time1of23;

    @FXML
    private Label time2of23;

    @FXML
    private Label time3of23;

    @FXML
    private Label time4of23;

    @FXML
    private Label time5of23;

    @FXML
    private Label time6of23;

    @FXML
    private Hyperlink apptmtID1of24;

    @FXML
    private Hyperlink apptmtID2of24;

    @FXML
    private Hyperlink apptmtID3of24;

    @FXML
    private Hyperlink apptmtID4of24;

    @FXML
    private Hyperlink apptmtID5of24;

    @FXML
    private Hyperlink apptmtID6of24;

    @FXML
    private Label time1of24;

    @FXML
    private Label time2of24;

    @FXML
    private Label time3of24;

    @FXML
    private Label time4of24;

    @FXML
    private Label time5of24;

    @FXML
    private Label time6of24;

    @FXML
    private Hyperlink apptmtID1of25;

    @FXML
    private Hyperlink apptmtID2of25;

    @FXML
    private Hyperlink apptmtID3of25;

    @FXML
    private Hyperlink apptmtID4of25;

    @FXML
    private Hyperlink apptmtID5of25;

    @FXML
    private Hyperlink apptmtID6of25;

    @FXML
    private Label time1of25;

    @FXML
    private Label time2of25;

    @FXML
    private Label time3of25;

    @FXML
    private Label time4of25;

    @FXML
    private Label time5of25;

    @FXML
    private Label time6of25;

    @FXML
    private Hyperlink apptmtID1of26;

    @FXML
    private Hyperlink apptmtID2of26;

    @FXML
    private Hyperlink apptmtID3of26;

    @FXML
    private Hyperlink apptmtID4of26;

    @FXML
    private Hyperlink apptmtID5of26;

    @FXML
    private Hyperlink apptmtID6of26;

    @FXML
    private Label time1of26;

    @FXML
    private Label time2of26;

    @FXML
    private Label time3of26;

    @FXML
    private Label time4of26;

    @FXML
    private Label time5of26;

    @FXML
    private Label time6of26;

    @FXML
    private Hyperlink apptmtID1of27;

    @FXML
    private Hyperlink apptmtID2of27;

    @FXML
    private Hyperlink apptmtID3of27;

    @FXML
    private Hyperlink apptmtID4of27;

    @FXML
    private Hyperlink apptmtID5of27;

    @FXML
    private Hyperlink apptmtID6of27;

    @FXML
    private Label time1of27;

    @FXML
    private Label time2of27;

    @FXML
    private Label time3of27;

    @FXML
    private Label time4of27;

    @FXML
    private Label time5of27;

    @FXML
    private Label time6of27;

    @FXML
    private Hyperlink apptmtID1of28;

    @FXML
    private Hyperlink apptmtID2of28;

    @FXML
    private Hyperlink apptmtID3of28;

    @FXML
    private Hyperlink apptmtID4of28;

    @FXML
    private Hyperlink apptmtID5of28;

    @FXML
    private Hyperlink apptmtID6of28;

    @FXML
    private Label time1of28;

    @FXML
    private Label time2of28;

    @FXML
    private Label time3of28;

    @FXML
    private Label time4of28;

    @FXML
    private Label time5of28;

    @FXML
    private Label time6of28;

    @FXML
    private Hyperlink apptmtID1of29;

    @FXML
    private Hyperlink apptmtID2of29;

    @FXML
    private Hyperlink apptmtID3of29;

    @FXML
    private Hyperlink apptmtID4of29;

    @FXML
    private Hyperlink apptmtID5of29;

    @FXML
    private Hyperlink apptmtID6of29;

    @FXML
    private Label time1of29;

    @FXML
    private Label time2of29;

    @FXML
    private Label time3of29;

    @FXML
    private Label time4of29;

    @FXML
    private Label time5of29;

    @FXML
    private Label time6of29;

    @FXML
    private Hyperlink apptmtID1of30;

    @FXML
    private Hyperlink apptmtID2of30;

    @FXML
    private Hyperlink apptmtID3of30;

    @FXML
    private Hyperlink apptmtID4of30;

    @FXML
    private Hyperlink apptmtID5of30;

    @FXML
    private Hyperlink apptmtID6of30;

    @FXML
    private Label time1of30;

    @FXML
    private Label time2of30;

    @FXML
    private Label time3of30;

    @FXML
    private Label time4of30;

    @FXML
    private Label time5of30;

    @FXML
    private Label time6of30;

    @FXML
    private Hyperlink apptmtID1of31;

    @FXML
    private Hyperlink apptmtID2of31;

    @FXML
    private Hyperlink apptmtID3of31;

    @FXML
    private Hyperlink apptmtID4of31;

    @FXML
    private Hyperlink apptmtID5of31;

    @FXML
    private Hyperlink apptmtID6of31;

    @FXML
    private Label time1of31;

    @FXML
    private Label time2of31;

    @FXML
    private Label time3of31;

    @FXML
    private Label time4of31;

    @FXML
    private Label time5of31;

    @FXML
    private Label time6of31;

    @FXML
    private Hyperlink apptmtID1of32;

    @FXML
    private Hyperlink apptmtID2of32;

    @FXML
    private Hyperlink apptmtID3of32;

    @FXML
    private Hyperlink apptmtID4of32;

    @FXML
    private Hyperlink apptmtID5of32;

    @FXML
    private Hyperlink apptmtID6of32;

    @FXML
    private Label time1of32;

    @FXML
    private Label time2of32;

    @FXML
    private Label time3of32;

    @FXML
    private Label time4of32;

    @FXML
    private Label time5of32;

    @FXML
    private Label time6of32;

    @FXML
    private Hyperlink apptmtID1of33;

    @FXML
    private Hyperlink apptmtID2of33;

    @FXML
    private Hyperlink apptmtID3of33;

    @FXML
    private Hyperlink apptmtID4of33;

    @FXML
    private Hyperlink apptmtID5of33;

    @FXML
    private Hyperlink apptmtID6of33;

    @FXML
    private Label time1of33;

    @FXML
    private Label time2of33;

    @FXML
    private Label time3of33;

    @FXML
    private Label time4of33;

    @FXML
    private Label time5of33;

    @FXML
    private Label time6of33;

    @FXML
    private Hyperlink apptmtID1of34;

    @FXML
    private Hyperlink apptmtID2of34;

    @FXML
    private Hyperlink apptmtID3of34;

    @FXML
    private Hyperlink apptmtID4of34;

    @FXML
    private Hyperlink apptmtID5of34;

    @FXML
    private Hyperlink apptmtID6of34;

    @FXML
    private Label time1of34;

    @FXML
    private Label time2of34;

    @FXML
    private Label time3of34;

    @FXML
    private Label time4of34;

    @FXML
    private Label time5of34;

    @FXML
    private Label time6of34;

    @FXML
    private Hyperlink apptmtID1of35;

    @FXML
    private Hyperlink apptmtID2of35;

    @FXML
    private Hyperlink apptmtID3of35;

    @FXML
    private Hyperlink apptmtID4of35;

    @FXML
    private Hyperlink apptmtID5of35;

    @FXML
    private Hyperlink apptmtID6of35;

    @FXML
    private Label time1of35;

    @FXML
    private Label time2of35;

    @FXML
    private Label time3of35;

    @FXML
    private Label time4of35;

    @FXML
    private Label time5of35;

    @FXML
    private Label time6of35;

    @FXML
    private Hyperlink apptmtID1of36;

    @FXML
    private Hyperlink apptmtID2of36;

    @FXML
    private Hyperlink apptmtID3of36;

    @FXML
    private Hyperlink apptmtID4of36;

    @FXML
    private Hyperlink apptmtID5of36;

    @FXML
    private Hyperlink apptmtID6of36;

    @FXML
    private Label time1of36;

    @FXML
    private Label time2of36;

    @FXML
    private Label time3of36;

    @FXML
    private Label time4of36;

    @FXML
    private Label time5of36;

    @FXML
    private Label time6of36;

    @FXML
    private Hyperlink apptmtID1of37;

    @FXML
    private Hyperlink apptmtID2of37;

    @FXML
    private Hyperlink apptmtID3of37;

    @FXML
    private Hyperlink apptmtID4of37;

    @FXML
    private Hyperlink apptmtID5of37;

    @FXML
    private Hyperlink apptmtID6of37;

    @FXML
    private Label time1of37;

    @FXML
    private Label time2of37;

    @FXML
    private Label time3of37;

    @FXML
    private Label time4of37;

    @FXML
    private Label time5of37;

    @FXML
    private Label time6of37;

    @FXML
    private Hyperlink apptmtID1of38;

    @FXML
    private Hyperlink apptmtID2of38;

    @FXML
    private Hyperlink apptmtID3of38;

    @FXML
    private Hyperlink apptmtID4of38;

    @FXML
    private Hyperlink apptmtID5of38;

    @FXML
    private Hyperlink apptmtID6of38;

    @FXML
    private Label time1of38;

    @FXML
    private Label time2of38;

    @FXML
    private Label time3of38;

    @FXML
    private Label time4of38;

    @FXML
    private Label time5of38;

    @FXML
    private Label time6of38;

    @FXML
    private Hyperlink apptmtID1of39;

    @FXML
    private Hyperlink apptmtID2of39;

    @FXML
    private Hyperlink apptmtID3of39;

    @FXML
    private Hyperlink apptmtID4of39;

    @FXML
    private Hyperlink apptmtID5of39;

    @FXML
    private Hyperlink apptmtID6of39;

    @FXML
    private Label time1of39;

    @FXML
    private Label time2of39;

    @FXML
    private Label time3of39;

    @FXML
    private Label time4of39;

    @FXML
    private Label time5of39;

    @FXML
    private Label time6of39;

    @FXML
    private Hyperlink apptmtID1of40;

    @FXML
    private Hyperlink apptmtID2of40;

    @FXML
    private Hyperlink apptmtID3of40;

    @FXML
    private Hyperlink apptmtID4of40;

    @FXML
    private Hyperlink apptmtID5of40;

    @FXML
    private Hyperlink apptmtID6of40;

    @FXML
    private Label time1of40;

    @FXML
    private Label time2of40;

    @FXML
    private Label time3of40;

    @FXML
    private Label time4of40;

    @FXML
    private Label time5of40;

    @FXML
    private Label time6of40;

    @FXML
    private Hyperlink apptmtID1of41;

    @FXML
    private Hyperlink apptmtID2of41;

    @FXML
    private Hyperlink apptmtID3of41;

    @FXML
    private Hyperlink apptmtID4of41;

    @FXML
    private Hyperlink apptmtID5of41;

    @FXML
    private Hyperlink apptmtID6of41;

    @FXML
    private Label time1of41;

    @FXML
    private Label time2of41;

    @FXML
    private Label time3of41;

    @FXML
    private Label time4of41;

    @FXML
    private Label time5of41;

    @FXML
    private Label time6of41;

    @FXML
    private Hyperlink apptmtID1of42;

    @FXML
    private Hyperlink apptmtID2of42;

    @FXML
    private Hyperlink apptmtID3of42;

    @FXML
    private Hyperlink apptmtID4of42;

    @FXML
    private Hyperlink apptmtID5of42;

    @FXML
    private Hyperlink apptmtID6of42;

    @FXML
    private Label time1of42;

    @FXML
    private Label time2of42;

    @FXML
    private Label time3of42;

    @FXML
    private Label time4of42;

    @FXML
    private Label time5of42;

    @FXML
    private Label time6of42;

    @FXML
    private ToggleGroup weekMonthTG;

    @FXML
    void onActionApptmtTypeLog(ActionEvent event) throws SQLException {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        int count11 = 0;
        int count12 = 0;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT start FROM appointment WHERE type=?";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.setString(1, "New Consult");
        ps.execute();
        ResultSet rs = ps.getResultSet();
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/files/AppointmentTypesByMonth.txt"))) {
            while (rs.next()) {
                LocalDateTime date = rs.getTimestamp("start").toLocalDateTime();
                String month = date.getMonth().toString();
                int year = date.getYear();
                if ((month.equals("JANUARY")) && (year == 2020))
                    count1 += 1;
                if ((month.equals("FEBRUARY")) && (year == 2020))
                    count2 += 1;
                if ((month.equals("MARCH")) && (year == 2020))
                    count3 += 1;
                if ((month.equals("APRIL")) && (year == 2020))
                    count4 += 1;
                if ((month.equals("MAY")) && (year == 2020))
                    count5 += 1;
                if ((month.equals("JUNE")) && (year == 2020))
                    count6 += 1;
                if ((month.equals("JULY")) && (year == 2020))
                    count7 += 1;
                if ((month.equals("AUGUST")) && (year == 2020))
                    count8 += 1;
                if ((month.equals("SEPTEMBER")) && (year == 2020))
                    count9 += 1;
                if ((month.equals("OCTOBER")) && (year == 2020))
                    count10 += 1;
                if ((month.equals("NOVEMBER")) && (year == 2020))
                    count11 += 1;
                if ((month.equals("DECEMBER")) && (year == 2020))
                    count12 += 1;
            }
            out.write("*************NEW CONSULT*************");
            out.newLine();
            out.write("JANUARY 2020: " + count1);
            out.newLine();
            out.write("FEBRUARY 2020: " + count2);
            out.newLine();
            out.write("MARCH 2020: " + count3);
            out.newLine();
            out.write("APRIL 2020: " + count4);
            out.newLine();
            out.write("MAY 2020: " + count5);
            out.newLine();
            out.write("JUNE 2020: " + count6);
            out.newLine();
            out.write("JULY 2020: " + count7);
            out.newLine();
            out.write("AUGUST 2020: " + count8);
            out.newLine();
            out.write("SEPTEMBER 2020: " + count9);
            out.newLine();
            out.write("OCTOBER 2020: " + count10);
            out.newLine();
            out.write("NOVEMBER 2020: " + count11);
            out.newLine();
            out.write("DECEMBER 2020: " + count12);
            out.newLine();
            out.write("*************************************");
            out.newLine();

            count1 = 0;
            count2 = 0;
            count3 = 0;
            count4 = 0;
            count5 = 0;
            count6 = 0;
            count7 = 0;
            count8 = 0;
            count9 = 0;
            count10 = 0;
            count11 = 0;
            count12 = 0;
            selectStatement = "SELECT start FROM appointment WHERE type=?";
            DBQuery.setPreparedStatement(conn, selectStatement);
            ps = DBQuery.getPreparedStatement();
            ps.setString(1, "Follow-Up Consult");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                LocalDateTime date = rs.getTimestamp("start").toLocalDateTime();
                String month = date.getMonth().toString();
                int year = date.getYear();
                if ((month.equals("JANUARY")) && (year == 2020))
                    count1 += 1;
                if ((month.equals("FEBRUARY")) && (year == 2020))
                    count2 += 1;
                if ((month.equals("MARCH")) && (year == 2020))
                    count3 += 1;
                if ((month.equals("APRIL")) && (year == 2020))
                    count4 += 1;
                if ((month.equals("MAY")) && (year == 2020))
                    count5 += 1;
                if ((month.equals("JUNE")) && (year == 2020))
                    count6 += 1;
                if ((month.equals("JULY")) && (year == 2020))
                    count7 += 1;
                if ((month.equals("AUGUST")) && (year == 2020))
                    count8 += 1;
                if ((month.equals("SEPTEMBER")) && (year == 2020))
                    count9 += 1;
                if ((month.equals("OCTOBER")) && (year == 2020))
                    count10 += 1;
                if ((month.equals("NOVEMBER")) && (year == 2020))
                    count11 += 1;
                if ((month.equals("DECEMBER")) && (year == 2020))
                    count12 += 1;
            }
            out.newLine();
            out.write("**********FOLLOW-UP CONSULT**********");
            out.newLine();
            out.write("JANUARY 2020: " + count1);
            out.newLine();
            out.write("FEBRUARY 2020: " + count2);
            out.newLine();
            out.write("MARCH 2020: " + count3);
            out.newLine();
            out.write("APRIL 2020: " + count4);
            out.newLine();
            out.write("MAY 2020: " + count5);
            out.newLine();
            out.write("JUNE 2020: " + count6);
            out.newLine();
            out.write("JULY 2020: " + count7);
            out.newLine();
            out.write("AUGUST 2020: " + count8);
            out.newLine();
            out.write("SEPTEMBER 2020: " + count9);
            out.newLine();
            out.write("OCTOBER 2020: " + count10);
            out.newLine();
            out.write("NOVEMBER 2020: " + count11);
            out.newLine();
            out.write("DECEMBER 2020: " + count12);
            out.newLine();
            out.write("*************************************");
            out.newLine();

            count1 = 0;
            count2 = 0;
            count3 = 0;
            count4 = 0;
            count5 = 0;
            count6 = 0;
            count7 = 0;
            count8 = 0;
            count9 = 0;
            count10 = 0;
            count11 = 0;
            count12 = 0;
            selectStatement = "SELECT start FROM appointment WHERE type=?";
            DBQuery.setPreparedStatement(conn, selectStatement);
            ps = DBQuery.getPreparedStatement();
            ps.setString(1, "Triggered Consult");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                LocalDateTime date = rs.getTimestamp("start").toLocalDateTime();
                String month = date.getMonth().toString();
                int year = date.getYear();
                if ((month.equals("JANUARY")) && (year == 2020))
                    count1 += 1;
                if ((month.equals("FEBRUARY")) && (year == 2020))
                    count2 += 1;
                if ((month.equals("MARCH")) && (year == 2020))
                    count3 += 1;
                if ((month.equals("APRIL")) && (year == 2020))
                    count4 += 1;
                if ((month.equals("MAY")) && (year == 2020))
                    count5 += 1;
                if ((month.equals("JUNE")) && (year == 2020))
                    count6 += 1;
                if ((month.equals("JULY")) && (year == 2020))
                    count7 += 1;
                if ((month.equals("AUGUST")) && (year == 2020))
                    count8 += 1;
                if ((month.equals("SEPTEMBER")) && (year == 2020))
                    count9 += 1;
                if ((month.equals("OCTOBER")) && (year == 2020))
                    count10 += 1;
                if ((month.equals("NOVEMBER")) && (year == 2020))
                    count11 += 1;
                if ((month.equals("DECEMBER")) && (year == 2020))
                    count12 += 1;
            }
            out.newLine();
            out.write("**********TRIGGERED CONSULT**********");
            out.newLine();
            out.write("JANUARY 2020: " + count1);
            out.newLine();
            out.write("FEBRUARY 2020: " + count2);
            out.newLine();
            out.write("MARCH 2020: " + count3);
            out.newLine();
            out.write("APRIL 2020: " + count4);
            out.newLine();
            out.write("MAY 2020: " + count5);
            out.newLine();
            out.write("JUNE 2020: " + count6);
            out.newLine();
            out.write("JULY 2020: " + count7);
            out.newLine();
            out.write("AUGUST 2020: " + count8);
            out.newLine();
            out.write("SEPTEMBER 2020: " + count9);
            out.newLine();
            out.write("OCTOBER 2020: " + count10);
            out.newLine();
            out.write("NOVEMBER 2020: " + count11);
            out.newLine();
            out.write("DECEMBER 2020: " + count12);
            out.newLine();
            out.write("*************************************");
            out.newLine();

            count1 = 0;
            count2 = 0;
            count3 = 0;
            count4 = 0;
            count5 = 0;
            count6 = 0;
            count7 = 0;
            count8 = 0;
            count9 = 0;
            count10 = 0;
            count11 = 0;
            count12 = 0;
            selectStatement = "SELECT start FROM appointment WHERE type=?";
            DBQuery.setPreparedStatement(conn, selectStatement);
            ps = DBQuery.getPreparedStatement();
            ps.setString(1, "Routine Consult");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                LocalDateTime date = rs.getTimestamp("start").toLocalDateTime();
                String month = date.getMonth().toString();
                int year = date.getYear();
                if ((month.equals("JANUARY")) && (year == 2020))
                    count1 += 1;
                if ((month.equals("FEBRUARY")) && (year == 2020))
                    count2 += 1;
                if ((month.equals("MARCH")) && (year == 2020))
                    count3 += 1;
                if ((month.equals("APRIL")) && (year == 2020))
                    count4 += 1;
                if ((month.equals("MAY")) && (year == 2020))
                    count5 += 1;
                if ((month.equals("JUNE")) && (year == 2020))
                    count6 += 1;
                if ((month.equals("JULY")) && (year == 2020))
                    count7 += 1;
                if ((month.equals("AUGUST")) && (year == 2020))
                    count8 += 1;
                if ((month.equals("SEPTEMBER")) && (year == 2020))
                    count9 += 1;
                if ((month.equals("OCTOBER")) && (year == 2020))
                    count10 += 1;
                if ((month.equals("NOVEMBER")) && (year == 2020))
                    count11 += 1;
                if ((month.equals("DECEMBER")) && (year == 2020))
                    count12 += 1;
            }
            out.newLine();
            out.write("***********ROUTINE CONSULT***********");
            out.newLine();
            out.write("JANUARY 2020: " + count1);
            out.newLine();
            out.write("FEBRUARY 2020: " + count2);
            out.newLine();
            out.write("MARCH 2020: " + count3);
            out.newLine();
            out.write("APRIL 2020: " + count4);
            out.newLine();
            out.write("MAY 2020: " + count5);
            out.newLine();
            out.write("JUNE 2020: " + count6);
            out.newLine();
            out.write("JULY 2020: " + count7);
            out.newLine();
            out.write("AUGUST 2020: " + count8);
            out.newLine();
            out.write("SEPTEMBER 2020: " + count9);
            out.newLine();
            out.write("OCTOBER 2020: " + count10);
            out.newLine();
            out.write("NOVEMBER 2020: " + count11);
            out.newLine();
            out.write("DECEMBER 2020: " + count12);
            out.newLine();
            out.write("*************************************");
            out.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(!Desktop.isDesktopSupported()){
                System.out.println("The desktop is not supported");
                return;
            }

            Desktop desktop = Desktop.getDesktop();

            File file = new File("src/files/AppointmentTypesByMonth.txt");
            desktop.open(file);

        } catch (IllegalArgumentException e) {
            System.out.println("The file does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionConsultSchedLog(ActionEvent event) throws SQLException {
        int customerID = 0;
        int userID = 0;
        int appointmentID = 0;
        String contactA = null;
        String userNameA = null;
        String titleA = null;
        String descriptionA = null;
        String locationA = null;
        String typeA = null;
        String urlA = null;
        LocalDateTime startA = null;
        LocalDateTime endA = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<CompleteAppointment> allResultCompleteAppointments = FXCollections.observableArrayList();
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/files/ConsultantSchedules.txt"))) {
            while (rs.next()) {
                appointmentID = rs.getInt("appointmentId");
                customerID = rs.getInt("customerId");
                userID = rs.getInt("userId");
                titleA = rs.getString("title");
                descriptionA = rs.getString("description");
                locationA = rs.getString("location");
                contactA = rs.getString("contact");
                typeA = rs.getString("type");
                urlA = rs.getString("url");
                //startD = rs.getDate("start").toLocalDate();
                //startT = rs.getTime("start").toLocalTime();
                //LocalDate endD = rs.getDate("end").toLocalDate();
                //endT = rs.getTime("end").toLocalTime();
                //String lastUpdateBy = rs.getString("lastUpdateBy");
                startA = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("start")); //not sure if it will work
                endA = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("end"));  //not sure if it will work
                //allResultCustomers.add(customer);
                String start = (startA.toLocalDate() + " " + startA.toLocalTime());
                String end = (endA.toLocalDate() + " " + endA.toLocalTime());

                Connection conn2 = DBConnection.startConnection();
                String selectStatement2 = "SELECT userName FROM user WHERE userId=?";
                DBQuery.setPreparedStatement(conn, selectStatement2);
                PreparedStatement ps2 = DBQuery.getPreparedStatement();
                ps2.setString(1, String.valueOf(userID));
                ps2.execute();
                ResultSet rs2 = ps2.getResultSet();
                while (rs2.next()) {
                    userNameA = rs2.getString("userName");
                    CompleteAppointment cAppointment = new CompleteAppointment(appointmentID, contactA, userNameA, titleA, descriptionA, locationA, typeA, urlA, startA, endA);
                    allResultCompleteAppointments.add(cAppointment);
                }
                ps2.close();
                conn2.close();
            }
        ps.close();
        conn.close();
        boolean isPrint = false;
        String previousUserName = null;
        //for (CompleteAppointment appointment : allResultCompleteAppointments) {
            for (int index = 0; index < allResultCompleteAppointments.size(); index++) {
                if (index > 0)
                    previousUserName = allResultCompleteAppointments.get(index-1).getUserName();
                if (!allResultCompleteAppointments.get(index).getUserName().equals(previousUserName)) {
                    isPrint = false;
                }
                if (!isPrint) {
                    out.write("********* Consultant: " + /*appointment*/allResultCompleteAppointments.get(index).getUserName() + " *********");
                    isPrint = true;
                }
                out.newLine();
                out.write("Appointment ID: " + allResultCompleteAppointments.get(index).getAppointmentId());
                out.newLine();
                out.write("Date: " + allResultCompleteAppointments.get(index).getStart().toLocalDate());
                out.newLine();
                out.write("Start Time: " + allResultCompleteAppointments.get(index).getStart().toLocalTime());
                out.newLine();
                out.write("End Time: " + allResultCompleteAppointments.get(index).getEnd().toLocalTime());
                out.newLine();
                out.write("Contact: " + allResultCompleteAppointments.get(index).getContact());
                out.newLine();
                out.write("Title: " + allResultCompleteAppointments.get(index).getTitle());
                out.newLine();
                out.write("Description: " + allResultCompleteAppointments.get(index).getDescription());
                out.newLine();
                out.write("Location: " + allResultCompleteAppointments.get(index).getLocation());
                out.newLine();
                out.write("Type: " + allResultCompleteAppointments.get(index).getType());
                out.newLine();
                out.write("URL: " + allResultCompleteAppointments.get(index).getUrl());
                out.newLine();
                out.write("-------------------------------------------");
                out.newLine();
            }
        //}
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if(!Desktop.isDesktopSupported()){
                    System.out.println("The desktop is not supported");
                    return;
                }

                Desktop desktop = Desktop.getDesktop();

                File file = new File("src/files/ConsultantSchedules.txt");
                desktop.open(file);

            } catch (IllegalArgumentException e) {
                System.out.println("The file does not exist");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @FXML
    void onActionDailyApptmtLog(ActionEvent event) throws SQLException {
        int customerID = 0;
        int userID = 0;
        int appointmentID = 0;
        String contactA = null;
        String userNameA = null;
        String titleA = null;
        String descriptionA = null;
        String locationA = null;
        String typeA = null;
        String urlA = null;
        LocalDateTime startA = null;
        LocalDateTime endA = null;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointment";
        DBQuery.setPreparedStatement(conn, selectStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ObservableList<CompleteAppointment> allResultCompleteAppointments = FXCollections.observableArrayList();
        try (BufferedWriter out = new BufferedWriter(new FileWriter("src/files/TodaysAppointments.txt"))) {
            while (rs.next()) {
                appointmentID = rs.getInt("appointmentId");
                customerID = rs.getInt("customerId");
                userID = rs.getInt("userId");
                titleA = rs.getString("title");
                descriptionA = rs.getString("description");
                locationA = rs.getString("location");
                contactA = rs.getString("contact");
                typeA = rs.getString("type");
                urlA = rs.getString("url");
                //startD = rs.getDate("start").toLocalDate();
                //startT = rs.getTime("start").toLocalTime();
                //LocalDate endD = rs.getDate("end").toLocalDate();
                //endT = rs.getTime("end").toLocalTime();
                //String lastUpdateBy = rs.getString("lastUpdateBy");
                startA = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("start")); //not sure if it will work
                endA = ConvertToUTC.convertUTCtoLDT(rs.getTimestamp("end"));  //not sure if it will work
                //allResultCustomers.add(customer);
                String start = (startA.toLocalDate() + " " + startA.toLocalTime());
                String end = (endA.toLocalDate() + " " + endA.toLocalTime());

                Connection conn2 = DBConnection.startConnection();
                String selectStatement2 = "SELECT userName FROM user WHERE userId=?";
                DBQuery.setPreparedStatement(conn, selectStatement2);
                PreparedStatement ps2 = DBQuery.getPreparedStatement();
                ps2.setString(1, String.valueOf(userID));
                ps2.execute();
                ResultSet rs2 = ps2.getResultSet();
                while (rs2.next()) {
                    userNameA = rs2.getString("userName");
                    CompleteAppointment cAppointment = new CompleteAppointment(appointmentID, contactA, userNameA, titleA, descriptionA, locationA, typeA, urlA, startA, endA);
                    allResultCompleteAppointments.add(cAppointment);
                }
                ps2.close();
                conn2.close();
            }
            ps.close();
            conn.close();
            boolean isPrint = false;
            //for (CompleteAppointment appointment : allResultCompleteAppointments) {
            for (int index = 0; index < allResultCompleteAppointments.size(); index++) {
                if ((allResultCompleteAppointments.get(index).getStart().toLocalDate().equals(LocalDate.now()) && (!isPrint))) {
                    out.write("********* " + LocalDate.now(ZoneId.systemDefault()).getMonth() + " " + LocalDate.now(ZoneId.systemDefault()).getDayOfMonth() + ", " + LocalDate.now(ZoneId.systemDefault()).getYear() + " *********");
                    isPrint = true;
                }
                if ((allResultCompleteAppointments.get(index).getStart().toLocalDate().equals(LocalDate.now()) && (isPrint))) {
                    out.newLine();
                    out.write("Appointment ID: " + allResultCompleteAppointments.get(index).getAppointmentId());
                    out.newLine();
                    out.write("Date: " + allResultCompleteAppointments.get(index).getStart().toLocalDate());
                    out.newLine();
                    out.write("Start Time: " + allResultCompleteAppointments.get(index).getStart().toLocalTime());
                    out.newLine();
                    out.write("End Time: " + allResultCompleteAppointments.get(index).getEnd().toLocalTime());
                    out.newLine();
                    out.write("Contact: " + allResultCompleteAppointments.get(index).getContact());
                    out.newLine();
                    out.write("Title: " + allResultCompleteAppointments.get(index).getTitle());
                    out.newLine();
                    out.write("Description: " + allResultCompleteAppointments.get(index).getDescription());
                    out.newLine();
                    out.write("Location: " + allResultCompleteAppointments.get(index).getLocation());
                    out.newLine();
                    out.write("Type: " + allResultCompleteAppointments.get(index).getType());
                    out.newLine();
                    out.write("URL: " + allResultCompleteAppointments.get(index).getUrl());
                    out.newLine();
                    out.write("-------------------------------------------");
                    out.newLine();
                }
            }
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(!Desktop.isDesktopSupported()){
                System.out.println("The desktop is not supported");
                return;
            }

            Desktop desktop = Desktop.getDesktop();

            File file = new File("src/files/TodaysAppointments.txt");
            desktop.open(file);

        } catch (IllegalArgumentException e) {
            System.out.println("The file does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setInitialVisibility() {

        time1of1.setVisible(false);
        apptmtID1of1.setVisible(false);
        time2of1.setVisible(false);
        apptmtID2of1.setVisible(false);
        time3of1.setVisible(false);
        apptmtID3of1.setVisible(false);
        time4of1.setVisible(false);
        apptmtID4of1.setVisible(false);
        time5of1.setVisible(false);
        apptmtID5of1.setVisible(false);
        time6of1.setVisible(false);
        apptmtID6of1.setVisible(false);

        time1of2.setVisible(false);
        apptmtID1of2.setVisible(false);
        time2of2.setVisible(false);
        apptmtID2of2.setVisible(false);
        time3of2.setVisible(false);
        apptmtID3of2.setVisible(false);
        time4of2.setVisible(false);
        apptmtID4of2.setVisible(false);
        time5of2.setVisible(false);
        apptmtID5of2.setVisible(false);
        time6of2.setVisible(false);
        apptmtID6of2.setVisible(false);

        time1of3.setVisible(false);
        apptmtID1of3.setVisible(false);
        time2of3.setVisible(false);
        apptmtID2of3.setVisible(false);
        time3of3.setVisible(false);
        apptmtID3of3.setVisible(false);
        time4of3.setVisible(false);
        apptmtID4of3.setVisible(false);
        time5of3.setVisible(false);
        apptmtID5of3.setVisible(false);
        time6of3.setVisible(false);
        apptmtID6of3.setVisible(false);

        time1of4.setVisible(false);
        apptmtID1of4.setVisible(false);
        time2of4.setVisible(false);
        apptmtID2of4.setVisible(false);
        time3of4.setVisible(false);
        apptmtID3of4.setVisible(false);
        time4of4.setVisible(false);
        apptmtID4of4.setVisible(false);
        time5of4.setVisible(false);
        apptmtID5of4.setVisible(false);
        time6of4.setVisible(false);
        apptmtID6of4.setVisible(false);

        time1of5.setVisible(false);
        apptmtID1of5.setVisible(false);
        time2of5.setVisible(false);
        apptmtID2of5.setVisible(false);
        time3of5.setVisible(false);
        apptmtID3of5.setVisible(false);
        time4of5.setVisible(false);
        apptmtID4of5.setVisible(false);
        time5of5.setVisible(false);
        apptmtID5of5.setVisible(false);
        time6of5.setVisible(false);
        apptmtID6of5.setVisible(false);

        time1of6.setVisible(false);
        apptmtID1of6.setVisible(false);
        time2of6.setVisible(false);
        apptmtID2of6.setVisible(false);
        time3of6.setVisible(false);
        apptmtID3of6.setVisible(false);
        time4of6.setVisible(false);
        apptmtID4of6.setVisible(false);
        time5of6.setVisible(false);
        apptmtID5of6.setVisible(false);
        time6of6.setVisible(false);
        apptmtID6of6.setVisible(false);

        time1of7.setVisible(false);
        apptmtID1of7.setVisible(false);
        time2of7.setVisible(false);
        apptmtID2of7.setVisible(false);
        time3of7.setVisible(false);
        apptmtID3of7.setVisible(false);
        time4of7.setVisible(false);
        apptmtID4of7.setVisible(false);
        time5of7.setVisible(false);
        apptmtID5of7.setVisible(false);
        time6of7.setVisible(false);
        apptmtID6of7.setVisible(false);

        time1of8.setVisible(false);
        apptmtID1of8.setVisible(false);
        time2of8.setVisible(false);
        apptmtID2of8.setVisible(false);
        time3of8.setVisible(false);
        apptmtID3of8.setVisible(false);
        time4of8.setVisible(false);
        apptmtID4of8.setVisible(false);
        time5of8.setVisible(false);
        apptmtID5of8.setVisible(false);
        time6of8.setVisible(false);
        apptmtID6of8.setVisible(false);

        time1of9.setVisible(false);
        apptmtID1of9.setVisible(false);
        time2of9.setVisible(false);
        apptmtID2of9.setVisible(false);
        time3of9.setVisible(false);
        apptmtID3of9.setVisible(false);
        time4of9.setVisible(false);
        apptmtID4of9.setVisible(false);
        time5of9.setVisible(false);
        apptmtID5of9.setVisible(false);
        time6of9.setVisible(false);
        apptmtID6of9.setVisible(false);

        time1of10.setVisible(false);
        apptmtID1of10.setVisible(false);
        time2of10.setVisible(false);
        apptmtID2of10.setVisible(false);
        time3of10.setVisible(false);
        apptmtID3of10.setVisible(false);
        time4of10.setVisible(false);
        apptmtID4of10.setVisible(false);
        time5of10.setVisible(false);
        apptmtID5of10.setVisible(false);
        time6of10.setVisible(false);
        apptmtID6of10.setVisible(false);

        time1of11.setVisible(false);
        apptmtID1of11.setVisible(false);
        time2of11.setVisible(false);
        apptmtID2of11.setVisible(false);
        time3of11.setVisible(false);
        apptmtID3of11.setVisible(false);
        time4of11.setVisible(false);
        apptmtID4of11.setVisible(false);
        time5of11.setVisible(false);
        apptmtID5of11.setVisible(false);
        time6of11.setVisible(false);
        apptmtID6of11.setVisible(false);

        time1of12.setVisible(false);
        apptmtID1of12.setVisible(false);
        time2of12.setVisible(false);
        apptmtID2of12.setVisible(false);
        time3of12.setVisible(false);
        apptmtID3of12.setVisible(false);
        time4of12.setVisible(false);
        apptmtID4of12.setVisible(false);
        time5of12.setVisible(false);
        apptmtID5of12.setVisible(false);
        time6of12.setVisible(false);
        apptmtID6of12.setVisible(false);

        time1of13.setVisible(false);
        apptmtID1of13.setVisible(false);
        time2of13.setVisible(false);
        apptmtID2of13.setVisible(false);
        time3of13.setVisible(false);
        apptmtID3of13.setVisible(false);
        time4of13.setVisible(false);
        apptmtID4of13.setVisible(false);
        time5of13.setVisible(false);
        apptmtID5of13.setVisible(false);
        time6of13.setVisible(false);
        apptmtID6of13.setVisible(false);

        time1of14.setVisible(false);
        apptmtID1of14.setVisible(false);
        time2of14.setVisible(false);
        apptmtID2of14.setVisible(false);
        time3of14.setVisible(false);
        apptmtID3of14.setVisible(false);
        time4of14.setVisible(false);
        apptmtID4of14.setVisible(false);
        time5of14.setVisible(false);
        apptmtID5of14.setVisible(false);
        time6of14.setVisible(false);
        apptmtID6of14.setVisible(false);

        time1of15.setVisible(false);
        apptmtID1of15.setVisible(false);
        time2of15.setVisible(false);
        apptmtID2of15.setVisible(false);
        time3of15.setVisible(false);
        apptmtID3of15.setVisible(false);
        time4of15.setVisible(false);
        apptmtID4of15.setVisible(false);
        time5of15.setVisible(false);
        apptmtID5of15.setVisible(false);
        time6of15.setVisible(false);
        apptmtID6of15.setVisible(false);

        time1of16.setVisible(false);
        apptmtID1of16.setVisible(false);
        time2of16.setVisible(false);
        apptmtID2of16.setVisible(false);
        time3of16.setVisible(false);
        apptmtID3of16.setVisible(false);
        time4of16.setVisible(false);
        apptmtID4of16.setVisible(false);
        time5of16.setVisible(false);
        apptmtID5of16.setVisible(false);
        time6of16.setVisible(false);
        apptmtID6of16.setVisible(false);

        time1of17.setVisible(false);
        apptmtID1of17.setVisible(false);
        time2of17.setVisible(false);
        apptmtID2of17.setVisible(false);
        time3of17.setVisible(false);
        apptmtID3of17.setVisible(false);
        time4of17.setVisible(false);
        apptmtID4of17.setVisible(false);
        time5of17.setVisible(false);
        apptmtID5of17.setVisible(false);
        time6of17.setVisible(false);
        apptmtID6of17.setVisible(false);

        time1of18.setVisible(false);
        apptmtID1of18.setVisible(false);
        time2of18.setVisible(false);
        apptmtID2of18.setVisible(false);
        time3of18.setVisible(false);
        apptmtID3of18.setVisible(false);
        time4of18.setVisible(false);
        apptmtID4of18.setVisible(false);
        time5of18.setVisible(false);
        apptmtID5of18.setVisible(false);
        time6of18.setVisible(false);
        apptmtID6of18.setVisible(false);

        time1of19.setVisible(false);
        apptmtID1of19.setVisible(false);
        time2of19.setVisible(false);
        apptmtID2of19.setVisible(false);
        time3of19.setVisible(false);
        apptmtID3of19.setVisible(false);
        time4of19.setVisible(false);
        apptmtID4of19.setVisible(false);
        time5of19.setVisible(false);
        apptmtID5of19.setVisible(false);
        time6of19.setVisible(false);
        apptmtID6of19.setVisible(false);

        time1of20.setVisible(false);
        apptmtID1of20.setVisible(false);
        time2of20.setVisible(false);
        apptmtID2of20.setVisible(false);
        time3of20.setVisible(false);
        apptmtID3of20.setVisible(false);
        time4of20.setVisible(false);
        apptmtID4of20.setVisible(false);
        time5of20.setVisible(false);
        apptmtID5of20.setVisible(false);
        time6of20.setVisible(false);
        apptmtID6of20.setVisible(false);

        time1of21.setVisible(false);
        apptmtID1of21.setVisible(false);
        time2of21.setVisible(false);
        apptmtID2of21.setVisible(false);
        time3of21.setVisible(false);
        apptmtID3of21.setVisible(false);
        time4of21.setVisible(false);
        apptmtID4of21.setVisible(false);
        time5of21.setVisible(false);
        apptmtID5of21.setVisible(false);
        time6of21.setVisible(false);
        apptmtID6of21.setVisible(false);

        time1of22.setVisible(false);
        apptmtID1of22.setVisible(false);
        time2of22.setVisible(false);
        apptmtID2of22.setVisible(false);
        time3of22.setVisible(false);
        apptmtID3of22.setVisible(false);
        time4of22.setVisible(false);
        apptmtID4of22.setVisible(false);
        time5of22.setVisible(false);
        apptmtID5of22.setVisible(false);
        time6of22.setVisible(false);
        apptmtID6of22.setVisible(false);

        time1of23.setVisible(false);
        apptmtID1of23.setVisible(false);
        time2of23.setVisible(false);
        apptmtID2of23.setVisible(false);
        time3of23.setVisible(false);
        apptmtID3of23.setVisible(false);
        time4of23.setVisible(false);
        apptmtID4of23.setVisible(false);
        time5of23.setVisible(false);
        apptmtID5of23.setVisible(false);
        time6of23.setVisible(false);
        apptmtID6of23.setVisible(false);

        time1of24.setVisible(false);
        apptmtID1of24.setVisible(false);
        time2of24.setVisible(false);
        apptmtID2of24.setVisible(false);
        time3of24.setVisible(false);
        apptmtID3of24.setVisible(false);
        time4of24.setVisible(false);
        apptmtID4of24.setVisible(false);
        time5of24.setVisible(false);
        apptmtID5of24.setVisible(false);
        time6of24.setVisible(false);
        apptmtID6of24.setVisible(false);

        time1of25.setVisible(false);
        apptmtID1of25.setVisible(false);
        time2of25.setVisible(false);
        apptmtID2of25.setVisible(false);
        time3of25.setVisible(false);
        apptmtID3of25.setVisible(false);
        time4of25.setVisible(false);
        apptmtID4of25.setVisible(false);
        time5of25.setVisible(false);
        apptmtID5of25.setVisible(false);
        time6of25.setVisible(false);
        apptmtID6of25.setVisible(false);

        time1of26.setVisible(false);
        apptmtID1of26.setVisible(false);
        time2of26.setVisible(false);
        apptmtID2of26.setVisible(false);
        time3of26.setVisible(false);
        apptmtID3of26.setVisible(false);
        time4of26.setVisible(false);
        apptmtID4of26.setVisible(false);
        time5of26.setVisible(false);
        apptmtID5of26.setVisible(false);
        time6of26.setVisible(false);
        apptmtID6of26.setVisible(false);

        time1of27.setVisible(false);
        apptmtID1of27.setVisible(false);
        time2of27.setVisible(false);
        apptmtID2of27.setVisible(false);
        time3of27.setVisible(false);
        apptmtID3of27.setVisible(false);
        time4of27.setVisible(false);
        apptmtID4of27.setVisible(false);
        time5of27.setVisible(false);
        apptmtID5of27.setVisible(false);
        time6of27.setVisible(false);
        apptmtID6of27.setVisible(false);

        time1of28.setVisible(false);
        apptmtID1of28.setVisible(false);
        time2of28.setVisible(false);
        apptmtID2of28.setVisible(false);
        time3of28.setVisible(false);
        apptmtID3of28.setVisible(false);
        time4of28.setVisible(false);
        apptmtID4of28.setVisible(false);
        time5of28.setVisible(false);
        apptmtID5of28.setVisible(false);
        time6of28.setVisible(false);
        apptmtID6of28.setVisible(false);

        time1of29.setVisible(false);
        apptmtID1of29.setVisible(false);
        time2of29.setVisible(false);
        apptmtID2of29.setVisible(false);
        time3of29.setVisible(false);
        apptmtID3of29.setVisible(false);
        time4of29.setVisible(false);
        apptmtID4of29.setVisible(false);
        time5of29.setVisible(false);
        apptmtID5of29.setVisible(false);
        time6of29.setVisible(false);
        apptmtID6of29.setVisible(false);

        time1of30.setVisible(false);
        apptmtID1of30.setVisible(false);
        time2of30.setVisible(false);
        apptmtID2of30.setVisible(false);
        time3of30.setVisible(false);
        apptmtID3of30.setVisible(false);
        time4of30.setVisible(false);
        apptmtID4of30.setVisible(false);
        time5of30.setVisible(false);
        apptmtID5of30.setVisible(false);
        time6of30.setVisible(false);
        apptmtID6of30.setVisible(false);

        time1of31.setVisible(false);
        apptmtID1of31.setVisible(false);
        time2of31.setVisible(false);
        apptmtID2of31.setVisible(false);
        time3of31.setVisible(false);
        apptmtID3of31.setVisible(false);
        time4of31.setVisible(false);
        apptmtID4of31.setVisible(false);
        time5of31.setVisible(false);
        apptmtID5of31.setVisible(false);
        time6of31.setVisible(false);
        apptmtID6of31.setVisible(false);

        time1of32.setVisible(false);
        apptmtID1of32.setVisible(false);
        time2of32.setVisible(false);
        apptmtID2of32.setVisible(false);
        time3of32.setVisible(false);
        apptmtID3of32.setVisible(false);
        time4of32.setVisible(false);
        apptmtID4of32.setVisible(false);
        time5of32.setVisible(false);
        apptmtID5of32.setVisible(false);
        time6of32.setVisible(false);
        apptmtID6of32.setVisible(false);

        time1of33.setVisible(false);
        apptmtID1of33.setVisible(false);
        time2of33.setVisible(false);
        apptmtID2of33.setVisible(false);
        time3of33.setVisible(false);
        apptmtID3of33.setVisible(false);
        time4of33.setVisible(false);
        apptmtID4of33.setVisible(false);
        time5of33.setVisible(false);
        apptmtID5of33.setVisible(false);
        time6of33.setVisible(false);
        apptmtID6of33.setVisible(false);

        time1of34.setVisible(false);
        apptmtID1of34.setVisible(false);
        time2of34.setVisible(false);
        apptmtID2of34.setVisible(false);
        time3of34.setVisible(false);
        apptmtID3of34.setVisible(false);
        time4of34.setVisible(false);
        apptmtID4of34.setVisible(false);
        time5of34.setVisible(false);
        apptmtID5of34.setVisible(false);
        time6of34.setVisible(false);
        apptmtID6of34.setVisible(false);

        time1of35.setVisible(false);
        apptmtID1of35.setVisible(false);
        time2of35.setVisible(false);
        apptmtID2of35.setVisible(false);
        time3of35.setVisible(false);
        apptmtID3of35.setVisible(false);
        time4of35.setVisible(false);
        apptmtID4of35.setVisible(false);
        time5of35.setVisible(false);
        apptmtID5of35.setVisible(false);
        time6of35.setVisible(false);
        apptmtID6of35.setVisible(false);

        time1of36.setVisible(false);
        apptmtID1of36.setVisible(false);
        time2of36.setVisible(false);
        apptmtID2of36.setVisible(false);
        time3of36.setVisible(false);
        apptmtID3of36.setVisible(false);
        time4of36.setVisible(false);
        apptmtID4of36.setVisible(false);
        time5of36.setVisible(false);
        apptmtID5of36.setVisible(false);
        time6of36.setVisible(false);
        apptmtID6of36.setVisible(false);

        time1of37.setVisible(false);
        apptmtID1of37.setVisible(false);
        time2of37.setVisible(false);
        apptmtID2of37.setVisible(false);
        time3of37.setVisible(false);
        apptmtID3of37.setVisible(false);
        time4of37.setVisible(false);
        apptmtID4of37.setVisible(false);
        time5of37.setVisible(false);
        apptmtID5of37.setVisible(false);
        time6of37.setVisible(false);
        apptmtID6of37.setVisible(false);

        time1of38.setVisible(false);
        apptmtID1of38.setVisible(false);
        time2of38.setVisible(false);
        apptmtID2of38.setVisible(false);
        time3of38.setVisible(false);
        apptmtID3of38.setVisible(false);
        time4of38.setVisible(false);
        apptmtID4of38.setVisible(false);
        time5of38.setVisible(false);
        apptmtID5of38.setVisible(false);
        time6of38.setVisible(false);
        apptmtID6of38.setVisible(false);

        time1of39.setVisible(false);
        apptmtID1of39.setVisible(false);
        time2of39.setVisible(false);
        apptmtID2of39.setVisible(false);
        time3of39.setVisible(false);
        apptmtID3of39.setVisible(false);
        time4of39.setVisible(false);
        apptmtID4of39.setVisible(false);
        time5of39.setVisible(false);
        apptmtID5of39.setVisible(false);
        time6of39.setVisible(false);
        apptmtID6of39.setVisible(false);

        time1of40.setVisible(false);
        apptmtID1of40.setVisible(false);
        time2of40.setVisible(false);
        apptmtID2of40.setVisible(false);
        time3of40.setVisible(false);
        apptmtID3of40.setVisible(false);
        time4of40.setVisible(false);
        apptmtID4of40.setVisible(false);
        time5of40.setVisible(false);
        apptmtID5of40.setVisible(false);
        time6of40.setVisible(false);
        apptmtID6of40.setVisible(false);

        time1of41.setVisible(false);
        apptmtID1of41.setVisible(false);
        time2of41.setVisible(false);
        apptmtID2of41.setVisible(false);
        time3of41.setVisible(false);
        apptmtID3of41.setVisible(false);
        time4of41.setVisible(false);
        apptmtID4of41.setVisible(false);
        time5of41.setVisible(false);
        apptmtID5of41.setVisible(false);
        time6of41.setVisible(false);
        apptmtID6of41.setVisible(false);

        time1of42.setVisible(false);
        apptmtID1of42.setVisible(false);
        time2of42.setVisible(false);
        apptmtID2of42.setVisible(false);
        time3of42.setVisible(false);
        apptmtID3of42.setVisible(false);
        time4of42.setVisible(false);
        apptmtID4of42.setVisible(false);
        time5of42.setVisible(false);
        apptmtID5of42.setVisible(false);
        time6of42.setVisible(false);
        apptmtID6of42.setVisible(false);
    }

    @FXML
    void onActionLeftBtn(ActionEvent event) throws SQLException {
        setInitialVisibility();
        LocalDate localDate1 = LocalDate.of(parseInt(yearLbl1.getText()), monthToInt(monthLbl.getText()), 1);
        int year = localDate1.getYear();
        int month = localDate1.getMonthValue();
        month = month - 1;
        if (month == 0)
            month = 12;
        if (month == 1) {
            monthLbl.setText("JANUARY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 2) {
            monthLbl.setText("FEBRUARY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 3) {
            monthLbl.setText("MARCH");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 4) {
            monthLbl.setText("APRIL");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 5) {
            monthLbl.setText("MAY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 6) {
            monthLbl.setText("JUNE");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 7) {
            monthLbl.setText("JULY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 8) {
            monthLbl.setText("AUGUST");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 9) {
            monthLbl.setText("SEPTEMBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 10) {
            monthLbl.setText("OCTOBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 11) {
            monthLbl.setText("NOVEMBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 12) {
            monthLbl.setText("DECEMBER");
            year = year - 1;
            yearLbl1.setText(String.valueOf(year));
            yearLbl2.setText(String.valueOf(year));
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onActionRightBtn(ActionEvent event) throws SQLException {
        setInitialVisibility();
        LocalDate localDate1 = LocalDate.of(parseInt(yearLbl1.getText()), monthToInt(monthLbl.getText()), 1);
        int year = localDate1.getYear();
        int month = localDate1.getMonthValue();
        month = month + 1;
        if (month == 13)
            month = 1;
        if (month == 1) {
            monthLbl.setText("JANUARY");
            year = year + 1;
            yearLbl1.setText(String.valueOf(year));
            yearLbl2.setText(String.valueOf(year));
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 2) {
            monthLbl.setText("FEBRUARY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 3) {
            monthLbl.setText("MARCH");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 4) {
            monthLbl.setText("APRIL");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 5) {
            monthLbl.setText("MAY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 6) {
            monthLbl.setText("JUNE");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 7) {
            monthLbl.setText("JULY");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 8) {
            monthLbl.setText("AUGUST");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 9) {
            monthLbl.setText("SEPTEMBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 10) {
            monthLbl.setText("OCTOBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 11) {
            monthLbl.setText("NOVEMBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
        if (month == 12) {
            monthLbl.setText("DECEMBER");
            if ((Calendar.dayOfWeekNum(month, 1, year)) == 0) {
                sundayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 1) {
                mondayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 4) {
                thursdayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 5) {
                fridayStartMonth(month, year);
            }
            else if ((Calendar.dayOfWeekNum(month, 1, year)) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please make sure your date settings are correct!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onActionapptmtID1of1(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of1.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of10(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of10.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionapptmtID1of11(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of11.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of12(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of12.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of13(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of13.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of14(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of14.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of15(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of15.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of16(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of16.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of17(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of17.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of18(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of18.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of19(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of19.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of2(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of2.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of20(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of20.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of21(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of21.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of22(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of22.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of23(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of23.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of24(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of24.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of25(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of25.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of26(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of26.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of27(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of27.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of28(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of28.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of29(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of29.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of3(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of3.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of30(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of30.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of31(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of31.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of32(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of32.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of33(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of33.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of34(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of34.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of35(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of35.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of36(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of36.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of37(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of37.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of38(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of38.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of39(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of39.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of4(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of4.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of40(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of40.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of41(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of41.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of42(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of42.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of5(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of5.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of6(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of7(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of7.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of8(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of8.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID1of9(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();   //getClass().getResource("input.fxml")
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID1of9.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of1(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of1.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of10(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of10.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of11(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of11.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of12(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of12.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of13(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of13.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of14(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of14.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of15(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of15.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of16(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of16.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of17(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of17.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of18(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of18.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of19(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of19.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of2(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of2.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of20(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of20.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of21(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of21.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of22(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of22.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of23(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of23.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of24(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of24.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of25(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of25.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of26(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of26.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of27(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of27.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of28(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of28.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of29(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of29.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of3(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of3.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of30(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of30.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of31(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of31.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of32(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of32.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of33(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of33.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of34(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of34.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of35(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of35.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of36(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of36.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of37(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of37.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of38(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of38.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of39(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of39.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of4(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of4.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of40(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of40.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of41(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of41.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of42(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of42.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of5(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of6(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of7(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of7.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of8(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of8.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID2of9(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID2of9.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of1(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of1.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of10(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of10.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of11(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of11.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of12(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of12.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of13(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of13.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of14(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of14.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of15(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of15.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of16(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of16.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of17(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of17.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of18(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of18.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of19(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of19.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of2(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of2.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of20(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of20.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of21(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of21.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of22(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of22.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of23(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of23.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of24(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of24.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of25(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of25.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of26(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of26.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of27(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of27.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of28(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of28.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of29(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of29.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of3(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of3.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of30(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of30.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of31(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of31.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of32(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of32.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of33(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of33.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of34(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of34.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of35(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of35.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of36(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of36.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of37(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of37.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of38(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of38.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of39(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of39.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of4(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of4.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of40(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of40.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of41(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of41.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of42(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of42.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of5(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of5.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of6(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of7(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of7.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of8(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of8.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID3of9(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID3of9.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of1(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of1.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of10(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of10.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of11(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of11.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of12(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of12.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of13(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of13.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of14(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of14.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of15(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of15.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of16(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of16.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of17(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of17.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of18(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of18.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of19(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of19.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of2(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of2.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of20(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of20.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of21(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of21.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of22(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of22.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of23(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of23.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of24(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of24.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of25(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of25.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of26(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of26.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of27(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of27.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of28(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of28.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of29(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of29.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of3(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of3.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of30(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of30.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of31(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of31.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of32(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of32.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of33(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of33.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of34(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of34.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of35(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of35.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of36(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of36.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of37(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of37.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of38(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of38.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of39(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of39.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of4(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of4.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of40(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of40.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of41(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of41.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of42(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of42.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of5(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of5.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of6(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of7(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of7.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of8(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of8.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID4of9(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID4of9.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of1(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of1.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of10(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of10.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of11(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of11.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of12(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of12.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of13(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of13.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of14(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of14.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of15(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of15.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of16(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of16.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of17(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of17.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of18(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of18.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of19(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of19.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of2(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of2.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of20(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of20.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of21(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of21.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of22(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of22.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of23(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of23.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of24(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of24.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of25(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of25.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of26(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of26.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of27(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of27.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of28(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of28.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of29(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of29.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of3(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of3.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of30(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of30.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of31(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of31.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of32(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of32.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of33(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of33.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of34(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of34.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of35(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of35.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of36(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of36.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of37(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of37.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of38(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of38.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of39(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of39.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of4(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of4.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of40(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of40.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of41(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of41.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of42(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of42.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of5(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of5.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of6(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of7(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of7.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of8(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of8.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID5of9(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID5of9.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of1(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of1.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of10(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of10.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of11(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of11.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of12(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of12.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of13(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of13.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of14(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of14.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of15(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of15.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of16(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of16.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of17(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of17.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of18(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of18.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of19(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of19.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of2(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of2.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of20(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of20.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of21(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of21.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of22(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of22.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of23(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of23.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of24(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of24.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of25(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of25.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of26(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of26.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of27(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of27.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of28(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of28.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of29(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of29.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of3(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of3.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of30(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of30.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of31(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of31.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of32(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of32.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of33(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of33.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of34(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of34.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of35(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of35.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of36(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of36.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of37(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of37.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of38(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of38.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of39(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of39.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of4(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of4.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of40(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of40.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of41(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of41.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of42(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of42.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of5(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of5.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of6(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of6.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of7(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of7.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of8(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of8.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionapptmtID6of9(ActionEvent event) {
        try {
            stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/ApptmtInfo.fxml"));
            Scene newScene = new Scene(loader.load());

            ApptmtInfoController controller = loader.getController();
            controller.selectedApptmt(apptmtID6of9.getText());
            controller.setCurrentUser(user);
            Stage inputStage = new Stage();
            inputStage.initOwner(stage);
            inputStage.setScene(newScene);
            inputStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionAddApptmt(ActionEvent event) {
        try {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/AddApptmt.fxml"));
            scene = loader.load();
            stage.setScene(new Scene(scene));
            AddApptmtController controller = loader.getController();
            controller.setCurrentUser(user);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionAddCustomer(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/AddCustomer.fxml"));
        scene = loader.load();
        stage.setScene(new Scene(scene));
        AddCustomerController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    @FXML
    void onActionDelApptmt(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/DeleteApptmt.fxml"));
        scene = loader.load();
        stage.setScene(new Scene(scene));
        DeleteApptmtController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    @FXML
    void onActionDelCustomer(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/DeleteCustomer.fxml"));
        scene = loader.load();
        stage.setScene(new Scene(scene));
        DeleteCustomerController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    @FXML
    void onActionLogFiles(ActionEvent event) {
        try {
            if(!Desktop.isDesktopSupported()){
                System.out.println("The desktop is not supported");
                return;
            }

            Desktop desktop = Desktop.getDesktop();

            File file = new File("src/files/LoginTimes.txt");
            desktop.open(file);

        } catch (IllegalArgumentException e) {
            System.out.println("The file does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionLogout(ActionEvent event) {
        DBConnection.closeConnection();
        System.exit(0);
    }

    @FXML
    void onActionMonth(ActionEvent event) {
    }

    @FXML
    void onActionUpdateApptmt(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/UpdateApptmt.fxml"));
        scene = loader.load();
        stage.setScene(new Scene(scene));
        UpdateApptmtController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    @FXML
    void onActionUpdateCustomer(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/UpdateCustomer.fxml"));
        scene = loader.load();
        stage.setScene(new Scene(scene));
        UpdateCustomerController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    @FXML
    void onActionWeek(ActionEvent event) throws IOException {
        stage = (Stage) ((ToggleButton) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Dashboard_week.fxml"));
        scene = loader.load();
        stage.setScene(new Scene(scene));
        Dashboard_weekController controller = loader.getController();
        controller.setCurrentUser(user);
        stage.show();
    }

    public void sundayStartMonth(int month, int year) throws SQLException {
        setInitialVisibility();
        Lbl1.setText("1");
        Lbl2.setText("2");
        Lbl3.setText("3");
        Lbl4.setText("4");
        Lbl5.setText("5");
        Lbl6.setText("6");
        Lbl7.setText("7");
        Lbl8.setText("8");
        Lbl9.setText("9");
        Lbl10.setText("10");
        Lbl11.setText("11");
        Lbl12.setText("12");
        Lbl13.setText("13");
        Lbl14.setText("14");
        Lbl15.setText("15");
        Lbl16.setText("16");
        Lbl17.setText("17");
        Lbl18.setText("18");
        Lbl19.setText("19");
        Lbl20.setText("20");
        Lbl21.setText("21");
        Lbl22.setText("22");
        Lbl23.setText("23");
        Lbl24.setText("24");
        Lbl25.setText("25");
        Lbl26.setText("26");
        Lbl27.setText("27");
        Lbl28.setText("28");
        Lbl29.setText("");
        Lbl30.setText("");
        Lbl31.setText("");
        Lbl32.setText("");
        Lbl33.setText("");
        Lbl34.setText("");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl1.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of1.setVisible(true);
                time1of1.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of1.setVisible(true);
                apptmtID1of1.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of1.setVisible(true);
                time2of1.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of1.setVisible(true);
                apptmtID2of1.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of1.setVisible(true);
                time3of1.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID3of1.setVisible(true);
                apptmtID3of1.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of1.setVisible(true);
                time4of1.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID4of1.setVisible(true);
                apptmtID4of1.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of1.setVisible(true);
                time5of1.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID5of1.setVisible(true);
                apptmtID5of1.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of1.setVisible(true);
                time6of1.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID6of1.setVisible(true);
                apptmtID6of1.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl2.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of2.setVisible(true);
                time1of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of2.setVisible(true);
                apptmtID1of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of2.setVisible(true);
                time2of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of2.setVisible(true);
                apptmtID2of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of2.setVisible(true);
                time3of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of2.setVisible(true);
                apptmtID3of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of2.setVisible(true);
                time4of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of2.setVisible(true);
                apptmtID4of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of2.setVisible(true);
                time5of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of2.setVisible(true);
                apptmtID5of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of2.setVisible(true);
                time6of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of2.setVisible(true);
                apptmtID6of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl3.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of3.setVisible(true);
                time1of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of3.setVisible(true);
                apptmtID1of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of3.setVisible(true);
                time2of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of3.setVisible(true);
                apptmtID2of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of3.setVisible(true);
                time3of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of3.setVisible(true);
                apptmtID3of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of3.setVisible(true);
                time4of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of3.setVisible(true);
                apptmtID4of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of3.setVisible(true);
                time5of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of3.setVisible(true);
                apptmtID5of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of3.setVisible(true);
                time6of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of3.setVisible(true);
                apptmtID6of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day4 = parseInt(Lbl4.getText());
        date = LocalDate.of(year, month, day4);
        times = LocalTime.of(0, 0);
        LocalDateTime dt4 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt4)) {
            setDailyApptmts(dt4);
            if (numOfApptmts(dt4) >= 1) {
                int index = 0;
                time1of4.setVisible(true);
                time1of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of4.setVisible(true);
                apptmtID1of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 2) {
                int index = 1;
                time2of4.setVisible(true);
                time2of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of4.setVisible(true);
                apptmtID2of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 3) {
                int index = 2;
                time3of4.setVisible(true);
                time3of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of4.setVisible(true);
                apptmtID3of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 4) {
                int index = 3;
                time4of4.setVisible(true);
                time4of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of4.setVisible(true);
                apptmtID5of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 5) {
                int index = 4;
                time5of4.setVisible(true);
                time5of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of4.setVisible(true);
                apptmtID5of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 6) {
                int index = 5;
                time6of4.setVisible(true);
                time6of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of4.setVisible(true);
                apptmtID6of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day5 = parseInt(Lbl5.getText());
        date = LocalDate.of(year, month, day5);
        times = LocalTime.of(0, 0);
        LocalDateTime dt5 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt5)) {
            setDailyApptmts(dt5);
            if (numOfApptmts(dt5) >= 1) {
                int index = 0;
                time1of5.setVisible(true);
                time1of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of5.setVisible(true);
                apptmtID1of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 2) {
                int index = 1;
                time2of5.setVisible(true);
                time2of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of5.setVisible(true);
                apptmtID2of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 3) {
                int index = 2;
                time3of5.setVisible(true);
                time3of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of5.setVisible(true);
                apptmtID3of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 4) {
                int index = 3;
                time4of5.setVisible(true);
                time4of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 5) {
                int index = 4;
                time5of5.setVisible(true);
                time5of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 6) {
                int index = 5;
                time6of5.setVisible(true);
                time6of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of5.setVisible(true);
                apptmtID6of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day6 = parseInt(Lbl6.getText());
        date = LocalDate.of(year, month, day6);
        times = LocalTime.of(0, 0);
        LocalDateTime dt6 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt6)) {
            setDailyApptmts(dt6);
            if (numOfApptmts(dt6) >= 1) {
                int index = 0;
                time1of6.setVisible(true);
                time1of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of6.setVisible(true);
                apptmtID1of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 2) {
                int index = 1;
                time2of6.setVisible(true);
                time2of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of6.setVisible(true);
                apptmtID2of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 3) {
                int index = 2;
                time3of6.setVisible(true);
                time3of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of6.setVisible(true);
                apptmtID3of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 4) {
                int index = 3;
                time4of6.setVisible(true);
                time4of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of6.setVisible(true);
                apptmtID4of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 5) {
                int index = 4;
                time5of6.setVisible(true);
                time5of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 6) {
                int index = 5;
                time6of6.setVisible(true);
                time6of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of6.setVisible(true);
                apptmtID6of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day7 = parseInt(Lbl7.getText());
        date = LocalDate.of(year, month, day7);
        times = LocalTime.of(0, 0);
        LocalDateTime dt7 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt7)) {
            setDailyApptmts(dt7);
            if (numOfApptmts(dt7) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID4of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day8 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day8);
        times = LocalTime.of(0, 0);
        LocalDateTime dt8 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt8)) {
            setDailyApptmts(dt8);
            if (numOfApptmts(dt8) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day9 = parseInt(Lbl9.getText());
        date = LocalDate.of(year, month, day9);
        times = LocalTime.of(0, 0);
        LocalDateTime dt9 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt9)) {
            setDailyApptmts(dt9);
            if (numOfApptmts(dt9) >= 1) {
                int index = 0;
                time1of9.setVisible(true);
                time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of9.setVisible(true);
                apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 2) {
                int index = 1;
                time2of9.setVisible(true);
                time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of9.setVisible(true);
                apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 3) {
                int index = 2;
                time3of9.setVisible(true);
                time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of9.setVisible(true);
                apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 4) {
                int index = 3;
                time4of9.setVisible(true);
                time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 5) {
                int index = 4;
                time5of9.setVisible(true);
                time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 6) {
                int index = 5;
                time6of9.setVisible(true);
                time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of9.setVisible(true);
                apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day10 = parseInt(Lbl10.getText());
        date = LocalDate.of(year, month, day10);
        times = LocalTime.of(0, 0);
        LocalDateTime dt10 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt10)) {
            setDailyApptmts(dt10);
            if (numOfApptmts(dt10) >= 1) {
                int index = 0;
                time1of10.setVisible(true);
                time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of10.setVisible(true);
                apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of10.setVisible(true);
                apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 3) {
                int index = 2;
                time3of10.setVisible(true);
                time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of10.setVisible(true);
                apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 4) {
                int index = 3;
                time4of10.setVisible(true);
                time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of10.setVisible(true);
                apptmtID4of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 5) {
                int index = 4;
                time5of10.setVisible(true);
                time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 6) {
                int index = 5;
                time6of10.setVisible(true);
                time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of10.setVisible(true);
                apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day11 = parseInt(Lbl11.getText());
        date = LocalDate.of(year, month, day11);
        times = LocalTime.of(0, 0);
        LocalDateTime dt11 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt11)) {
            setDailyApptmts(dt11);
            if (numOfApptmts(dt11) >= 1) {
                int index = 0;
                time1of11.setVisible(true);
                time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of11.setVisible(true);
                apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 2) {
                int index = 1;
                time2of11.setVisible(true);
                time2of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of11.setVisible(true);
                apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 3) {
                int index = 2;
                time3of11.setVisible(true);
                time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of11.setVisible(true);
                apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 4) {
                int index = 3;
                time4of11.setVisible(true);
                time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of11.setVisible(true);
                apptmtID4of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 5) {
                int index = 4;
                time5of11.setVisible(true);
                time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 6) {
                int index = 5;
                time6of11.setVisible(true);
                time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of11.setVisible(true);
                apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day12 = parseInt(Lbl12.getText());
        date = LocalDate.of(year, month, day12);
        times = LocalTime.of(0, 0);
        LocalDateTime dt12 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt12)) {
            setDailyApptmts(dt12);
            if (numOfApptmts(dt12) >= 1) {
                int index = 0;
                time1of12.setVisible(true);
                time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of12.setVisible(true);
                apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 2) {
                int index = 1;
                time2of12.setVisible(true);
                time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of12.setVisible(true);
                apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 3) {
                int index = 2;
                time3of12.setVisible(true);
                time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of12.setVisible(true);
                apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 4) {
                int index = 3;
                time4of12.setVisible(true);
                time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of12.setVisible(true);
                apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 5) {
                int index = 4;
                time5of12.setVisible(true);
                time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of12.setVisible(true);
                apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 6) {
                int index = 5;
                time6of12.setVisible(true);
                time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of12.setVisible(true);
                apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day13 = parseInt(Lbl13.getText());
        date = LocalDate.of(year, month, day13);
        times = LocalTime.of(0, 0);
        LocalDateTime dt13 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt13)) {
            setDailyApptmts(dt13);
            if (numOfApptmts(dt13) >= 1) {
                int index = 0;
                time1of13.setVisible(true);
                time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of13.setVisible(true);
                apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 2) {
                int index = 1;
                time2of13.setVisible(true);
                time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of13.setVisible(true);
                apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 3) {
                int index = 2;
                time3of13.setVisible(true);
                time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of13.setVisible(true);
                apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 4) {
                int index = 3;
                time4of13.setVisible(true);
                time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of13.setVisible(true);
                apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 5) {
                int index = 4;
                time5of13.setVisible(true);
                time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of13.setVisible(true);
                apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 6) {
                int index = 5;
                time6of13.setVisible(true);
                time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of13.setVisible(true);
                apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day14 = parseInt(Lbl14.getText());
        date = LocalDate.of(year, month, day14);
        times = LocalTime.of(0, 0);
        LocalDateTime dt14 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt14)) {
            setDailyApptmts(dt14);
            if (numOfApptmts(dt14) >= 1) {
                int index = 0;
                time1of14.setVisible(true);
                time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of14.setVisible(true);
                apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 2) {
                int index = 1;
                time2of14.setVisible(true);
                time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of14.setVisible(true);
                apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 3) {
                int index = 2;
                time3of14.setVisible(true);
                time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of14.setVisible(true);
                apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 4) {
                int index = 3;
                time4of14.setVisible(true);
                time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of14.setVisible(true);
                apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 5) {
                int index = 4;
                time5of14.setVisible(true);
                time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of14.setVisible(true);
                apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 6) {
                int index = 5;
                time6of14.setVisible(true);
                time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of14.setVisible(true);
                apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day15 = parseInt(Lbl15.getText());
        date = LocalDate.of(year, month, day15);
        times = LocalTime.of(0, 0);
        LocalDateTime dt15 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt15)) {
            setDailyApptmts(dt15);
            if (numOfApptmts(dt15) >= 1) {
                int index = 0;
                time1of15.setVisible(true);
                time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of15.setVisible(true);
                apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 2) {
                int index = 1;
                time2of15.setVisible(true);
                time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of15.setVisible(true);
                apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 3) {
                int index = 2;
                time3of15.setVisible(true);
                time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of15.setVisible(true);
                apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 4) {
                int index = 3;
                time4of15.setVisible(true);
                time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of15.setVisible(true);
                apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 5) {
                int index = 4;
                time5of15.setVisible(true);
                time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of15.setVisible(true);
                apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 6) {
                int index = 5;
                time6of15.setVisible(true);
                time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of15.setVisible(true);
                apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day16 = parseInt(Lbl16.getText());
        date = LocalDate.of(year, month, day16);
        times = LocalTime.of(0, 0);
        LocalDateTime dt16 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt16)) {
            setDailyApptmts(dt16);
            if (numOfApptmts(dt16) >= 1) {
                int index = 0;
                time1of16.setVisible(true);
                time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of16.setVisible(true);
                apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 2) {
                int index = 1;
                time2of16.setVisible(true);
                time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of16.setVisible(true);
                apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 3) {
                int index = 2;
                time3of16.setVisible(true);
                time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of16.setVisible(true);
                apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 4) {
                int index = 3;
                time4of16.setVisible(true);
                time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of16.setVisible(true);
                apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 5) {
                int index = 4;
                time5of16.setVisible(true);
                time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of16.setVisible(true);
                apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 6) {
                int index = 5;
                time6of16.setVisible(true);
                time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of16.setVisible(true);
                apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day17 = parseInt(Lbl17.getText());
        date = LocalDate.of(year, month, day17);
        times = LocalTime.of(0, 0);
        LocalDateTime dt17 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt17)) {
            setDailyApptmts(dt17);
            if (numOfApptmts(dt17) >= 1) {
                int index = 0;
                time1of17.setVisible(true);
                time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of17.setVisible(true);
                apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 2) {
                int index = 1;
                time2of17.setVisible(true);
                time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of17.setVisible(true);
                apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 3) {
                int index = 2;
                time3of17.setVisible(true);
                time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of17.setVisible(true);
                apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 4) {
                int index = 3;
                time4of17.setVisible(true);
                time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of17.setVisible(true);
                apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 5) {
                int index = 4;
                time5of17.setVisible(true);
                time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of17.setVisible(true);
                apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 6) {
                int index = 5;
                time6of17.setVisible(true);
                time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of17.setVisible(true);
                apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day18 = parseInt(Lbl18.getText());
        date = LocalDate.of(year, month, day18);
        times = LocalTime.of(0, 0);
        LocalDateTime dt18 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt18)) {
            setDailyApptmts(dt18);
            if (numOfApptmts(dt18) >= 1) {
                int index = 0;
                time1of18.setVisible(true);
                time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of18.setVisible(true);
                apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 2) {
                int index = 1;
                time2of18.setVisible(true);
                time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of18.setVisible(true);
                apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 3) {
                int index = 2;
                time3of18.setVisible(true);
                time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of18.setVisible(true);
                apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 4) {
                int index = 3;
                time4of18.setVisible(true);
                time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of18.setVisible(true);
                apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 5) {
                int index = 4;
                time5of18.setVisible(true);
                time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of18.setVisible(true);
                apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 6) {
                int index = 5;
                time6of18.setVisible(true);
                time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of18.setVisible(true);
                apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day19 = parseInt(Lbl19.getText());
        date = LocalDate.of(year, month, day19);
        times = LocalTime.of(0, 0);
        LocalDateTime dt19 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt19)) {
            setDailyApptmts(dt19);
            if (numOfApptmts(dt19) >= 1) {
                int index = 0;
                time1of19.setVisible(true);
                time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of19.setVisible(true);
                apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 2) {
                int index = 1;
                time2of19.setVisible(true);
                time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of19.setVisible(true);
                apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 3) {
                int index = 2;
                time3of19.setVisible(true);
                time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of19.setVisible(true);
                apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 4) {
                int index = 3;
                time4of19.setVisible(true);
                time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of19.setVisible(true);
                apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 5) {
                int index = 4;
                time5of19.setVisible(true);
                time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of19.setVisible(true);
                apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 6) {
                int index = 5;
                time6of19.setVisible(true);
                time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of19.setVisible(true);
                apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day20 = parseInt(Lbl20.getText());
        date = LocalDate.of(year, month, day20);
        times = LocalTime.of(0, 0);
        LocalDateTime dt20 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt20)) {
            setDailyApptmts(dt20);
            if (numOfApptmts(dt20) >= 1) {
                int index = 0;
                time1of20.setVisible(true);
                time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of20.setVisible(true);
                apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 2) {
                int index = 1;
                time2of20.setVisible(true);
                time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of20.setVisible(true);
                apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 3) {
                int index = 2;
                time3of20.setVisible(true);
                time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of20.setVisible(true);
                apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 4) {
                int index = 3;
                time4of20.setVisible(true);
                time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of20.setVisible(true);
                apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 5) {
                int index = 4;
                time5of20.setVisible(true);
                time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of20.setVisible(true);
                apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 6) {
                int index = 5;
                time6of20.setVisible(true);
                time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of20.setVisible(true);
                apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day21 = parseInt(Lbl21.getText());
        date = LocalDate.of(year, month, day21);
        times = LocalTime.of(0, 0);
        LocalDateTime dt21 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt21)) {
            setDailyApptmts(dt21);
            if (numOfApptmts(dt21) >= 1) {
                int index = 0;
                time1of21.setVisible(true);
                time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of21.setVisible(true);
                apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 2) {
                int index = 1;
                time2of21.setVisible(true);
                time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of21.setVisible(true);
                apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 3) {
                int index = 2;
                time3of21.setVisible(true);
                time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of21.setVisible(true);
                apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 4) {
                int index = 3;
                time4of21.setVisible(true);
                time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of21.setVisible(true);
                apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 5) {
                int index = 4;
                time5of21.setVisible(true);
                time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of21.setVisible(true);
                apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 6) {
                int index = 5;
                time6of21.setVisible(true);
                time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of21.setVisible(true);
                apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day22 = parseInt(Lbl22.getText());
        date = LocalDate.of(year, month, day22);
        times = LocalTime.of(0, 0);
        LocalDateTime dt22 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt22)) {
            setDailyApptmts(dt22);
            if (numOfApptmts(dt22) >= 1) {
                int index = 0;
                time1of22.setVisible(true);
                time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of22.setVisible(true);
                apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 2) {
                int index = 1;
                time2of22.setVisible(true);
                time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of22.setVisible(true);
                apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 3) {
                int index = 2;
                time3of22.setVisible(true);
                time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of22.setVisible(true);
                apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 4) {
                int index = 3;
                time4of22.setVisible(true);
                time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of22.setVisible(true);
                apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 5) {
                int index = 4;
                time5of22.setVisible(true);
                time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of22.setVisible(true);
                apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 6) {
                int index = 5;
                time6of22.setVisible(true);
                time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of22.setVisible(true);
                apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day23 = parseInt(Lbl23.getText());
        date = LocalDate.of(year, month, day23);
        times = LocalTime.of(0, 0);
        LocalDateTime dt23 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt23)) {
            setDailyApptmts(dt23);
            if (numOfApptmts(dt23) >= 1) {
                int index = 0;
                time1of23.setVisible(true);
                time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of23.setVisible(true);
                apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 2) {
                int index = 1;
                time2of23.setVisible(true);
                time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of23.setVisible(true);
                apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 3) {
                int index = 2;
                time3of23.setVisible(true);
                time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of23.setVisible(true);
                apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 4) {
                int index = 3;
                time4of23.setVisible(true);
                time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of23.setVisible(true);
                apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 5) {
                int index = 4;
                time5of23.setVisible(true);
                time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of23.setVisible(true);
                apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 6) {
                int index = 5;
                time6of23.setVisible(true);
                time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of23.setVisible(true);
                apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day24 = parseInt(Lbl24.getText());
        date = LocalDate.of(year, month, day24);
        times = LocalTime.of(0, 0);
        LocalDateTime dt24 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt24)) {
            setDailyApptmts(dt24);
            if (numOfApptmts(dt24) >= 1) {
                int index = 0;
                time1of24.setVisible(true);
                time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of24.setVisible(true);
                apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 2) {
                int index = 1;
                time2of24.setVisible(true);
                time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of24.setVisible(true);
                apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 3) {
                int index = 2;
                time3of24.setVisible(true);
                time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of24.setVisible(true);
                apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 4) {
                int index = 3;
                time4of24.setVisible(true);
                time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of24.setVisible(true);
                apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 5) {
                int index = 4;
                time5of24.setVisible(true);
                time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of24.setVisible(true);
                apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 6) {
                int index = 5;
                time6of24.setVisible(true);
                time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of24.setVisible(true);
                apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day25 = parseInt(Lbl25.getText());
        date = LocalDate.of(year, month, day25);
        times = LocalTime.of(0, 0);
        LocalDateTime dt25 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt25)) {
            setDailyApptmts(dt25);
            if (numOfApptmts(dt25) >= 1) {
                int index = 0;
                time1of25.setVisible(true);
                time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of25.setVisible(true);
                apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 2) {
                int index = 1;
                time2of25.setVisible(true);
                time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of25.setVisible(true);
                apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 3) {
                int index = 2;
                time3of25.setVisible(true);
                time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of25.setVisible(true);
                apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 4) {
                int index = 3;
                time4of25.setVisible(true);
                time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of25.setVisible(true);
                apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 5) {
                int index = 4;
                time5of25.setVisible(true);
                time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of25.setVisible(true);
                apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 6) {
                int index = 5;
                time6of25.setVisible(true);
                time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of25.setVisible(true);
                apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day26 = parseInt(Lbl26.getText());
        date = LocalDate.of(year, month, day26);
        times = LocalTime.of(0, 0);
        LocalDateTime dt26 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt26)) {
            setDailyApptmts(dt26);
            if (numOfApptmts(dt26) >= 1) {
                int index = 0;
                time1of26.setVisible(true);
                time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of26.setVisible(true);
                apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 2) {
                int index = 1;
                time2of26.setVisible(true);
                time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of26.setVisible(true);
                apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 3) {
                int index = 2;
                time3of26.setVisible(true);
                time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of26.setVisible(true);
                apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 4) {
                int index = 3;
                time4of26.setVisible(true);
                time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of26.setVisible(true);
                apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 5) {
                int index = 4;
                time5of26.setVisible(true);
                time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of26.setVisible(true);
                apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 6) {
                int index = 5;
                time6of26.setVisible(true);
                time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of26.setVisible(true);
                apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day27 = parseInt(Lbl27.getText());
        date = LocalDate.of(year, month, day27);
        times = LocalTime.of(0, 0);
        LocalDateTime dt27 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt27)) {
            setDailyApptmts(dt27);
            if (numOfApptmts(dt27) >= 1) {
                int index = 0;
                time1of27.setVisible(true);
                time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of27.setVisible(true);
                apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 2) {
                int index = 1;
                time2of27.setVisible(true);
                time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of27.setVisible(true);
                apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 3) {
                int index = 2;
                time3of27.setVisible(true);
                time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of27.setVisible(true);
                apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 4) {
                int index = 3;
                time4of27.setVisible(true);
                time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of27.setVisible(true);
                apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 5) {
                int index = 4;
                time5of27.setVisible(true);
                time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of27.setVisible(true);
                apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 6) {
                int index = 5;
                time6of27.setVisible(true);
                time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of27.setVisible(true);
                apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day28 = parseInt(Lbl28.getText());
        date = LocalDate.of(year, month, day28);
        times = LocalTime.of(0, 0);
        LocalDateTime dt28 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt28)) {
            setDailyApptmts(dt28);
            if (numOfApptmts(dt28) >= 1) {
                int index = 0;
                time1of28.setVisible(true);
                time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of28.setVisible(true);
                apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 2) {
                int index = 1;
                time2of28.setVisible(true);
                time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of28.setVisible(true);
                apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 3) {
                int index = 2;
                time3of28.setVisible(true);
                time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of28.setVisible(true);
                apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 4) {
                int index = 3;
                time4of28.setVisible(true);
                time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of28.setVisible(true);
                apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 5) {
                int index = 4;
                time5of28.setVisible(true);
                time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of28.setVisible(true);
                apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 6) {
                int index = 5;
                time6of28.setVisible(true);
                time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of28.setVisible(true);
                apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
            Lbl29.setText("29");
            int day29 = parseInt(Lbl29.getText());
            date = LocalDate.of(year, month, day29);
            times = LocalTime.of(0, 0);
            LocalDateTime dt29 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt29)) {
                setDailyApptmts(dt29);
                if (numOfApptmts(dt29) >= 1) {
                    int index = 0;
                    time1of29.setVisible(true);
                    time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of29.setVisible(true);
                    apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 2) {
                    int index = 1;
                    time2of29.setVisible(true);
                    time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of29.setVisible(true);
                    apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 3) {
                    int index = 2;
                    time3of29.setVisible(true);
                    time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of29.setVisible(true);
                    apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 4) {
                    int index = 3;
                    time4of29.setVisible(true);
                    time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of29.setVisible(true);
                    apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 5) {
                    int index = 4;
                    time5of29.setVisible(true);
                    time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of29.setVisible(true);
                    apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 6) {
                    int index = 5;
                    time6of29.setVisible(true);
                    time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of29.setVisible(true);
                    apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }


        if (month != 2) {
            Lbl30.setText("30");
            int day30 = parseInt(Lbl30.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of30.setVisible(true);
                    time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of30.setVisible(true);
                    apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of30.setVisible(true);
                    time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of30.setVisible(true);
                    apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of30.setVisible(true);
                    time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of30.setVisible(true);
                    apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of30.setVisible(true);
                    time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of30.setVisible(true);
                    apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of30.setVisible(true);
                    time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of30.setVisible(true);
                    apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of30.setVisible(true);
                    time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of30.setVisible(true);
                    apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl31.setText("31");
            int day31 = parseInt(Lbl31.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of31.setVisible(true);
                    time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of31.setVisible(true);
                    apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of31.setVisible(true);
                    time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of31.setVisible(true);
                    apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of31.setVisible(true);
                    time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of31.setVisible(true);
                    apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of31.setVisible(true);
                    time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of31.setVisible(true);
                    apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of31.setVisible(true);
                    time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of31.setVisible(true);
                    apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of31.setVisible(true);
                    time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of31.setVisible(true);
                    apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public void mondayStartMonth(int month, int year) throws SQLException {
        setInitialVisibility();
        Lbl1.setText("");
        Lbl2.setText("1");
        Lbl3.setText("2");
        Lbl4.setText("3");
        Lbl5.setText("4");
        Lbl6.setText("5");
        Lbl7.setText("6");
        Lbl8.setText("7");
        Lbl9.setText("8");
        Lbl10.setText("9");
        Lbl11.setText("10");
        Lbl12.setText("11");
        Lbl13.setText("12");
        Lbl14.setText("13");
        Lbl15.setText("14");
        Lbl16.setText("15");
        Lbl17.setText("16");
        Lbl18.setText("17");
        Lbl19.setText("18");
        Lbl20.setText("19");
        Lbl21.setText("20");
        Lbl22.setText("21");
        Lbl23.setText("22");
        Lbl24.setText("23");
        Lbl25.setText("24");
        Lbl26.setText("25");
        Lbl27.setText("26");
        Lbl28.setText("27");
        Lbl29.setText("28");
        Lbl30.setText("");
        Lbl31.setText("");
        Lbl32.setText("");
        Lbl33.setText("");
        Lbl34.setText("");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl2.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of2.setVisible(true);
                time1of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of2.setVisible(true);
                apptmtID1of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of2.setVisible(true);
                time2of2.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of2.setVisible(true);
                apptmtID2of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of2.setVisible(true);
                time3of2.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID3of2.setVisible(true);
                apptmtID3of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of2.setVisible(true);
                time4of2.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID4of2.setVisible(true);
                apptmtID4of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of2.setVisible(true);
                time5of2.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID5of2.setVisible(true);
                apptmtID5of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of2.setVisible(true);
                time6of2.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID6of2.setVisible(true);
                apptmtID6of2.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl3.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of3.setVisible(true);
                time1of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of3.setVisible(true);
                apptmtID1of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of3.setVisible(true);
                time2of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of3.setVisible(true);
                apptmtID2of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of3.setVisible(true);
                time3of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of3.setVisible(true);
                apptmtID3of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of3.setVisible(true);
                time4of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of3.setVisible(true);
                apptmtID4of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of3.setVisible(true);
                time5of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of3.setVisible(true);
                apptmtID5of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of3.setVisible(true);
                time6of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of3.setVisible(true);
                apptmtID6of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl4.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of4.setVisible(true);
                time1of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of4.setVisible(true);
                apptmtID1of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of4.setVisible(true);
                time2of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of4.setVisible(true);
                apptmtID2of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of4.setVisible(true);
                time3of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of4.setVisible(true);
                apptmtID3of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of4.setVisible(true);
                time4of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of4.setVisible(true);
                apptmtID4of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of4.setVisible(true);
                time5of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of4.setVisible(true);
                apptmtID5of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of4.setVisible(true);
                time6of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of4.setVisible(true);
                apptmtID6of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day4 = parseInt(Lbl5.getText());
        date = LocalDate.of(year, month, day4);
        times = LocalTime.of(0, 0);
        LocalDateTime dt4 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt4)) {
            setDailyApptmts(dt4);
            if (numOfApptmts(dt4) >= 1) {
                int index = 0;
                time1of5.setVisible(true);
                time1of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of5.setVisible(true);
                apptmtID1of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 2) {
                int index = 1;
                time2of5.setVisible(true);
                time2of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of5.setVisible(true);
                apptmtID2of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 3) {
                int index = 2;
                time3of5.setVisible(true);
                time3of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of5.setVisible(true);
                apptmtID3of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 4) {
                int index = 3;
                time4of5.setVisible(true);
                time4of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 5) {
                int index = 4;
                time5of5.setVisible(true);
                time5of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 6) {
                int index = 5;
                time6of5.setVisible(true);
                time6of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of5.setVisible(true);
                apptmtID6of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day5 = parseInt(Lbl6.getText());
        date = LocalDate.of(year, month, day5);
        times = LocalTime.of(0, 0);
        LocalDateTime dt5 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt5)) {
            setDailyApptmts(dt5);
            if (numOfApptmts(dt5) >= 1) {
                int index = 0;
                time1of6.setVisible(true);
                time1of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of6.setVisible(true);
                apptmtID1of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 2) {
                int index = 1;
                time2of6.setVisible(true);
                time2of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of6.setVisible(true);
                apptmtID2of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 3) {
                int index = 2;
                time3of6.setVisible(true);
                time3of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of6.setVisible(true);
                apptmtID3of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 4) {
                int index = 3;
                time4of6.setVisible(true);
                time4of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 5) {
                int index = 4;
                time5of6.setVisible(true);
                time5of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 6) {
                int index = 5;
                time6of6.setVisible(true);
                time6of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of6.setVisible(true);
                apptmtID6of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day6 = parseInt(Lbl7.getText());
        date = LocalDate.of(year, month, day6);
        times = LocalTime.of(0, 0);
        LocalDateTime dt6 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt6)) {
            setDailyApptmts(dt6);
            if (numOfApptmts(dt6) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID4of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day7 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day7);
        times = LocalTime.of(0, 0);
        LocalDateTime dt7 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt7)) {
            setDailyApptmts(dt7);
            if (numOfApptmts(dt7) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID4of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day8 = parseInt(Lbl9.getText());
        date = LocalDate.of(year, month, day8);
        times = LocalTime.of(0, 0);
        LocalDateTime dt8 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt8)) {
            setDailyApptmts(dt8);
            if (numOfApptmts(dt8) >= 1) {
                int index = 0;
                time1of9.setVisible(true);
                time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of9.setVisible(true);
                apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 2) {
                int index = 1;
                time2of9.setVisible(true);
                time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of9.setVisible(true);
                apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 3) {
                int index = 2;
                time3of9.setVisible(true);
                time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of9.setVisible(true);
                apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 4) {
                int index = 3;
                time4of9.setVisible(true);
                time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 5) {
                int index = 4;
                time5of9.setVisible(true);
                time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 6) {
                int index = 5;
                time6of9.setVisible(true);
                time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of9.setVisible(true);
                apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day9 = parseInt(Lbl10.getText());
        date = LocalDate.of(year, month, day9);
        times = LocalTime.of(0, 0);
        LocalDateTime dt9 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt9)) {
            setDailyApptmts(dt9);
            if (numOfApptmts(dt9) >= 1) {
                int index = 0;
                time1of10.setVisible(true);
                time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of10.setVisible(true);
                apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of10.setVisible(true);
                apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 3) {
                int index = 2;
                time3of10.setVisible(true);
                time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of10.setVisible(true);
                apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 4) {
                int index = 3;
                time4of10.setVisible(true);
                time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 5) {
                int index = 4;
                time5of10.setVisible(true);
                time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 6) {
                int index = 5;
                time6of10.setVisible(true);
                time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of10.setVisible(true);
                apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day10 = parseInt(Lbl11.getText());
        date = LocalDate.of(year, month, day10);
        times = LocalTime.of(0, 0);
        LocalDateTime dt10 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt10)) {
            setDailyApptmts(dt10);
            if (numOfApptmts(dt10) >= 1) {
                int index = 0;
                time1of11.setVisible(true);
                time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of11.setVisible(true);
                apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 2) {
                int index = 1;
                time2of11.setVisible(true);
                time2of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of11.setVisible(true);
                apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 3) {
                int index = 2;
                time3of11.setVisible(true);
                time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of11.setVisible(true);
                apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 4) {
                int index = 3;
                time4of11.setVisible(true);
                time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of11.setVisible(true);
                apptmtID4of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 5) {
                int index = 4;
                time5of11.setVisible(true);
                time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 6) {
                int index = 5;
                time6of11.setVisible(true);
                time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of11.setVisible(true);
                apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day11 = parseInt(Lbl12.getText());
        date = LocalDate.of(year, month, day11);
        times = LocalTime.of(0, 0);
        LocalDateTime dt11 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt11)) {
            setDailyApptmts(dt11);
            if (numOfApptmts(dt11) >= 1) {
                int index = 0;
                time1of12.setVisible(true);
                time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of12.setVisible(true);
                apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 2) {
                int index = 1;
                time2of12.setVisible(true);
                time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of12.setVisible(true);
                apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 3) {
                int index = 2;
                time3of12.setVisible(true);
                time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of12.setVisible(true);
                apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 4) {
                int index = 3;
                time4of12.setVisible(true);
                time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of12.setVisible(true);
                apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 5) {
                int index = 4;
                time5of12.setVisible(true);
                time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of12.setVisible(true);
                apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 6) {
                int index = 5;
                time6of12.setVisible(true);
                time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of12.setVisible(true);
                apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day12 = parseInt(Lbl13.getText());
        date = LocalDate.of(year, month, day12);
        times = LocalTime.of(0, 0);
        LocalDateTime dt12 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt12)) {
            setDailyApptmts(dt12);
            if (numOfApptmts(dt12) >= 1) {
                int index = 0;
                time1of13.setVisible(true);
                time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of13.setVisible(true);
                apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 2) {
                int index = 1;
                time2of13.setVisible(true);
                time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of13.setVisible(true);
                apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 3) {
                int index = 2;
                time3of13.setVisible(true);
                time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of13.setVisible(true);
                apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 4) {
                int index = 3;
                time4of13.setVisible(true);
                time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of13.setVisible(true);
                apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 5) {
                int index = 4;
                time5of13.setVisible(true);
                time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of13.setVisible(true);
                apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 6) {
                int index = 5;
                time6of13.setVisible(true);
                time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of13.setVisible(true);
                apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day13 = parseInt(Lbl14.getText());
        date = LocalDate.of(year, month, day13);
        times = LocalTime.of(0, 0);
        LocalDateTime dt13 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt13)) {
            setDailyApptmts(dt13);
            if (numOfApptmts(dt13) >= 1) {
                int index = 0;
                time1of14.setVisible(true);
                time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of14.setVisible(true);
                apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 2) {
                int index = 1;
                time2of14.setVisible(true);
                time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of14.setVisible(true);
                apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 3) {
                int index = 2;
                time3of14.setVisible(true);
                time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of14.setVisible(true);
                apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 4) {
                int index = 3;
                time4of14.setVisible(true);
                time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of14.setVisible(true);
                apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 5) {
                int index = 4;
                time5of14.setVisible(true);
                time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of14.setVisible(true);
                apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 6) {
                int index = 5;
                time6of14.setVisible(true);
                time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of14.setVisible(true);
                apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day14 = parseInt(Lbl15.getText());
        date = LocalDate.of(year, month, day14);
        times = LocalTime.of(0, 0);
        LocalDateTime dt14 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt14)) {
            setDailyApptmts(dt14);
            if (numOfApptmts(dt14) >= 1) {
                int index = 0;
                time1of15.setVisible(true);
                time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of15.setVisible(true);
                apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 2) {
                int index = 1;
                time2of15.setVisible(true);
                time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of15.setVisible(true);
                apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 3) {
                int index = 2;
                time3of15.setVisible(true);
                time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of15.setVisible(true);
                apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 4) {
                int index = 3;
                time4of15.setVisible(true);
                time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of15.setVisible(true);
                apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 5) {
                int index = 4;
                time5of15.setVisible(true);
                time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of15.setVisible(true);
                apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 6) {
                int index = 5;
                time6of15.setVisible(true);
                time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of15.setVisible(true);
                apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day15 = parseInt(Lbl16.getText());
        date = LocalDate.of(year, month, day15);
        times = LocalTime.of(0, 0);
        LocalDateTime dt15 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt15)) {
            setDailyApptmts(dt15);
            if (numOfApptmts(dt15) >= 1) {
                int index = 0;
                time1of16.setVisible(true);
                time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of16.setVisible(true);
                apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 2) {
                int index = 1;
                time2of16.setVisible(true);
                time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of16.setVisible(true);
                apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 3) {
                int index = 2;
                time3of16.setVisible(true);
                time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of16.setVisible(true);
                apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 4) {
                int index = 3;
                time4of16.setVisible(true);
                time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of16.setVisible(true);
                apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 5) {
                int index = 4;
                time5of16.setVisible(true);
                time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of16.setVisible(true);
                apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 6) {
                int index = 5;
                time6of16.setVisible(true);
                time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of16.setVisible(true);
                apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day16 = parseInt(Lbl17.getText());
        date = LocalDate.of(year, month, day16);
        times = LocalTime.of(0, 0);
        LocalDateTime dt16 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt16)) {
            setDailyApptmts(dt16);
            if (numOfApptmts(dt16) >= 1) {
                int index = 0;
                time1of17.setVisible(true);
                time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of17.setVisible(true);
                apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 2) {
                int index = 1;
                time2of17.setVisible(true);
                time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of17.setVisible(true);
                apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 3) {
                int index = 2;
                time3of17.setVisible(true);
                time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of17.setVisible(true);
                apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 4) {
                int index = 3;
                time4of17.setVisible(true);
                time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of17.setVisible(true);
                apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 5) {
                int index = 4;
                time5of17.setVisible(true);
                time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of17.setVisible(true);
                apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 6) {
                int index = 5;
                time6of17.setVisible(true);
                time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of17.setVisible(true);
                apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day17 = parseInt(Lbl18.getText());
        date = LocalDate.of(year, month, day17);
        times = LocalTime.of(0, 0);
        LocalDateTime dt17 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt17)) {
            setDailyApptmts(dt17);
            if (numOfApptmts(dt17) >= 1) {
                int index = 0;
                time1of18.setVisible(true);
                time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of18.setVisible(true);
                apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 2) {
                int index = 1;
                time2of18.setVisible(true);
                time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of18.setVisible(true);
                apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 3) {
                int index = 2;
                time3of18.setVisible(true);
                time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of18.setVisible(true);
                apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 4) {
                int index = 3;
                time4of18.setVisible(true);
                time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of18.setVisible(true);
                apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 5) {
                int index = 4;
                time5of18.setVisible(true);
                time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of18.setVisible(true);
                apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 6) {
                int index = 5;
                time6of18.setVisible(true);
                time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of18.setVisible(true);
                apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day18 = parseInt(Lbl19.getText());
        date = LocalDate.of(year, month, day18);
        times = LocalTime.of(0, 0);
        LocalDateTime dt18 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt18)) {
            setDailyApptmts(dt18);
            if (numOfApptmts(dt18) >= 1) {
                int index = 0;
                time1of19.setVisible(true);
                time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of19.setVisible(true);
                apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 2) {
                int index = 1;
                time2of19.setVisible(true);
                time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of19.setVisible(true);
                apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 3) {
                int index = 2;
                time3of19.setVisible(true);
                time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of19.setVisible(true);
                apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 4) {
                int index = 3;
                time4of19.setVisible(true);
                time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of19.setVisible(true);
                apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 5) {
                int index = 4;
                time5of19.setVisible(true);
                time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of19.setVisible(true);
                apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 6) {
                int index = 5;
                time6of19.setVisible(true);
                time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of19.setVisible(true);
                apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day19 = parseInt(Lbl20.getText());
        date = LocalDate.of(year, month, day19);
        times = LocalTime.of(0, 0);
        LocalDateTime dt19 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt19)) {
            setDailyApptmts(dt19);
            if (numOfApptmts(dt19) >= 1) {
                int index = 0;
                time1of20.setVisible(true);
                time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of20.setVisible(true);
                apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 2) {
                int index = 1;
                time2of20.setVisible(true);
                time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of20.setVisible(true);
                apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 3) {
                int index = 2;
                time3of20.setVisible(true);
                time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of20.setVisible(true);
                apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 4) {
                int index = 3;
                time4of20.setVisible(true);
                time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of20.setVisible(true);
                apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 5) {
                int index = 4;
                time5of20.setVisible(true);
                time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of20.setVisible(true);
                apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 6) {
                int index = 5;
                time6of20.setVisible(true);
                time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of20.setVisible(true);
                apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day20 = parseInt(Lbl21.getText());
        date = LocalDate.of(year, month, day20);
        times = LocalTime.of(0, 0);
        LocalDateTime dt20 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt20)) {
            setDailyApptmts(dt20);
            if (numOfApptmts(dt20) >= 1) {
                int index = 0;
                time1of21.setVisible(true);
                time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of21.setVisible(true);
                apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 2) {
                int index = 1;
                time2of21.setVisible(true);
                time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of21.setVisible(true);
                apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 3) {
                int index = 2;
                time3of21.setVisible(true);
                time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of21.setVisible(true);
                apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 4) {
                int index = 3;
                time4of21.setVisible(true);
                time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of21.setVisible(true);
                apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 5) {
                int index = 4;
                time5of21.setVisible(true);
                time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of21.setVisible(true);
                apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 6) {
                int index = 5;
                time6of21.setVisible(true);
                time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of21.setVisible(true);
                apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day21 = parseInt(Lbl22.getText());
        date = LocalDate.of(year, month, day21);
        times = LocalTime.of(0, 0);
        LocalDateTime dt21 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt21)) {
            setDailyApptmts(dt21);
            if (numOfApptmts(dt21) >= 1) {
                int index = 0;
                time1of22.setVisible(true);
                time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of22.setVisible(true);
                apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 2) {
                int index = 1;
                time2of22.setVisible(true);
                time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of22.setVisible(true);
                apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 3) {
                int index = 2;
                time3of22.setVisible(true);
                time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of22.setVisible(true);
                apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 4) {
                int index = 3;
                time4of22.setVisible(true);
                time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of22.setVisible(true);
                apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 5) {
                int index = 4;
                time5of22.setVisible(true);
                time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of22.setVisible(true);
                apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 6) {
                int index = 5;
                time6of22.setVisible(true);
                time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of22.setVisible(true);
                apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day22 = parseInt(Lbl23.getText());
        date = LocalDate.of(year, month, day22);
        times = LocalTime.of(0, 0);
        LocalDateTime dt22 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt22)) {
            setDailyApptmts(dt22);
            if (numOfApptmts(dt22) >= 1) {
                int index = 0;
                time1of23.setVisible(true);
                time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of23.setVisible(true);
                apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 2) {
                int index = 1;
                time2of23.setVisible(true);
                time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of23.setVisible(true);
                apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 3) {
                int index = 2;
                time3of23.setVisible(true);
                time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of23.setVisible(true);
                apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 4) {
                int index = 3;
                time4of23.setVisible(true);
                time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of23.setVisible(true);
                apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 5) {
                int index = 4;
                time5of23.setVisible(true);
                time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of23.setVisible(true);
                apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 6) {
                int index = 5;
                time6of23.setVisible(true);
                time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of23.setVisible(true);
                apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day23 = parseInt(Lbl24.getText());
        date = LocalDate.of(year, month, day23);
        times = LocalTime.of(0, 0);
        LocalDateTime dt23 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt23)) {
            setDailyApptmts(dt23);
            if (numOfApptmts(dt23) >= 1) {
                int index = 0;
                time1of24.setVisible(true);
                time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of24.setVisible(true);
                apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 2) {
                int index = 1;
                time2of24.setVisible(true);
                time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of24.setVisible(true);
                apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 3) {
                int index = 2;
                time3of24.setVisible(true);
                time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of24.setVisible(true);
                apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 4) {
                int index = 3;
                time4of24.setVisible(true);
                time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of24.setVisible(true);
                apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 5) {
                int index = 4;
                time5of24.setVisible(true);
                time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of24.setVisible(true);
                apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 6) {
                int index = 5;
                time6of24.setVisible(true);
                time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of24.setVisible(true);
                apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day24 = parseInt(Lbl25.getText());
        date = LocalDate.of(year, month, day24);
        times = LocalTime.of(0, 0);
        LocalDateTime dt24 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt24)) {
            setDailyApptmts(dt24);
            if (numOfApptmts(dt24) >= 1) {
                int index = 0;
                time1of25.setVisible(true);
                time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of25.setVisible(true);
                apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 2) {
                int index = 1;
                time2of25.setVisible(true);
                time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of25.setVisible(true);
                apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 3) {
                int index = 2;
                time3of25.setVisible(true);
                time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of25.setVisible(true);
                apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 4) {
                int index = 3;
                time4of25.setVisible(true);
                time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of25.setVisible(true);
                apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 5) {
                int index = 4;
                time5of25.setVisible(true);
                time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of25.setVisible(true);
                apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 6) {
                int index = 5;
                time6of25.setVisible(true);
                time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of25.setVisible(true);
                apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day25 = parseInt(Lbl26.getText());
        date = LocalDate.of(year, month, day25);
        times = LocalTime.of(0, 0);
        LocalDateTime dt25 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt25)) {
            setDailyApptmts(dt25);
            if (numOfApptmts(dt25) >= 1) {
                int index = 0;
                time1of26.setVisible(true);
                time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of26.setVisible(true);
                apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 2) {
                int index = 1;
                time2of26.setVisible(true);
                time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of26.setVisible(true);
                apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 3) {
                int index = 2;
                time3of26.setVisible(true);
                time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of26.setVisible(true);
                apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 4) {
                int index = 3;
                time4of26.setVisible(true);
                time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of26.setVisible(true);
                apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 5) {
                int index = 4;
                time5of26.setVisible(true);
                time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of26.setVisible(true);
                apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 6) {
                int index = 5;
                time6of26.setVisible(true);
                time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of26.setVisible(true);
                apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day26 = parseInt(Lbl27.getText());
        date = LocalDate.of(year, month, day26);
        times = LocalTime.of(0, 0);
        LocalDateTime dt26 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt26)) {
            setDailyApptmts(dt26);
            if (numOfApptmts(dt26) >= 1) {
                int index = 0;
                time1of27.setVisible(true);
                time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of27.setVisible(true);
                apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 2) {
                int index = 1;
                time2of27.setVisible(true);
                time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of27.setVisible(true);
                apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 3) {
                int index = 2;
                time3of27.setVisible(true);
                time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of27.setVisible(true);
                apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 4) {
                int index = 3;
                time4of27.setVisible(true);
                time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of27.setVisible(true);
                apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 5) {
                int index = 4;
                time5of27.setVisible(true);
                time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of27.setVisible(true);
                apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 6) {
                int index = 5;
                time6of27.setVisible(true);
                time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of27.setVisible(true);
                apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day27 = parseInt(Lbl28.getText());
        date = LocalDate.of(year, month, day27);
        times = LocalTime.of(0, 0);
        LocalDateTime dt27 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt27)) {
            setDailyApptmts(dt27);
            if (numOfApptmts(dt27) >= 1) {
                int index = 0;
                time1of28.setVisible(true);
                time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of28.setVisible(true);
                apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 2) {
                int index = 1;
                time2of28.setVisible(true);
                time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of28.setVisible(true);
                apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 3) {
                int index = 2;
                time3of28.setVisible(true);
                time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of28.setVisible(true);
                apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 4) {
                int index = 3;
                time4of28.setVisible(true);
                time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of28.setVisible(true);
                apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 5) {
                int index = 4;
                time5of28.setVisible(true);
                time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of28.setVisible(true);
                apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 6) {
                int index = 5;
                time6of28.setVisible(true);
                time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of28.setVisible(true);
                apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day28 = parseInt(Lbl29.getText());
        date = LocalDate.of(year, month, day28);
        times = LocalTime.of(0, 0);
        LocalDateTime dt28 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt28)) {
            setDailyApptmts(dt28);
            if (numOfApptmts(dt28) >= 1) {
                int index = 0;
                time1of29.setVisible(true);
                time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of29.setVisible(true);
                apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 2) {
                int index = 1;
                time2of29.setVisible(true);
                time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of29.setVisible(true);
                apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 3) {
                int index = 2;
                time3of29.setVisible(true);
                time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of29.setVisible(true);
                apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 4) {
                int index = 3;
                time4of29.setVisible(true);
                time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of29.setVisible(true);
                apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 5) {
                int index = 4;
                time5of29.setVisible(true);
                time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of29.setVisible(true);
                apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 6) {
                int index = 5;
                time6of29.setVisible(true);
                time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of29.setVisible(true);
                apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
            Lbl30.setText("29");
            int day29 = parseInt(Lbl30.getText());
            date = LocalDate.of(year, month, day29);
            times = LocalTime.of(0, 0);
            LocalDateTime dt29 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt29)) {
                setDailyApptmts(dt29);
                if (numOfApptmts(dt29) >= 1) {
                    int index = 0;
                    time1of30.setVisible(true);
                    time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of30.setVisible(true);
                    apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 2) {
                    int index = 1;
                    time2of30.setVisible(true);
                    time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of30.setVisible(true);
                    apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 3) {
                    int index = 2;
                    time3of30.setVisible(true);
                    time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of30.setVisible(true);
                    apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 4) {
                    int index = 3;
                    time4of30.setVisible(true);
                    time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of30.setVisible(true);
                    apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 5) {
                    int index = 4;
                    time5of30.setVisible(true);
                    time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of30.setVisible(true);
                    apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 6) {
                    int index = 5;
                    time6of30.setVisible(true);
                    time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of30.setVisible(true);
                    apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if (month != 2) {
            Lbl31.setText("30");
            int day30 = parseInt(Lbl31.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of31.setVisible(true);
                    time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of31.setVisible(true);
                    apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of31.setVisible(true);
                    time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of31.setVisible(true);
                    apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of31.setVisible(true);
                    time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of31.setVisible(true);
                    apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of31.setVisible(true);
                    time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of31.setVisible(true);
                    apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of31.setVisible(true);
                    time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of31.setVisible(true);
                    apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of31.setVisible(true);
                    time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of31.setVisible(true);
                    apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl32.setText("31");
            int day31 = parseInt(Lbl32.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of32.setVisible(true);
                    time1of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of32.setVisible(true);
                    apptmtID1of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of32.setVisible(true);
                    time2of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of32.setVisible(true);
                    apptmtID2of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of32.setVisible(true);
                    time3of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of32.setVisible(true);
                    apptmtID3of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of32.setVisible(true);
                    time4of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of32.setVisible(true);
                    apptmtID4of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of32.setVisible(true);
                    time5of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of32.setVisible(true);
                    apptmtID5of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of32.setVisible(true);
                    time6of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of32.setVisible(true);
                    apptmtID6of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public void tuesdayStartMonth(int month, int year) throws SQLException {
        setInitialVisibility();
        Lbl1.setText("");
        Lbl2.setText("");
        Lbl3.setText("1");
        Lbl4.setText("2");
        Lbl5.setText("3");
        Lbl6.setText("4");
        Lbl7.setText("5");
        Lbl8.setText("6");
        Lbl9.setText("7");
        Lbl10.setText("8");
        Lbl11.setText("9");
        Lbl12.setText("10");
        Lbl13.setText("11");
        Lbl14.setText("12");
        Lbl15.setText("13");
        Lbl16.setText("14");
        Lbl17.setText("15");
        Lbl18.setText("16");
        Lbl19.setText("17");
        Lbl20.setText("18");
        Lbl21.setText("19");
        Lbl22.setText("20");
        Lbl23.setText("21");
        Lbl24.setText("22");
        Lbl25.setText("23");
        Lbl26.setText("24");
        Lbl27.setText("25");
        Lbl28.setText("26");
        Lbl29.setText("27");
        Lbl30.setText("28");
        Lbl31.setText("");
        Lbl32.setText("");
        Lbl33.setText("");
        Lbl34.setText("");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl3.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of3.setVisible(true);
                time1of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of3.setVisible(true);
                apptmtID1of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of3.setVisible(true);
                time2of3.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of3.setVisible(true);
                apptmtID2of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of3.setVisible(true);
                time3of3.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID3of3.setVisible(true);
                apptmtID3of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of3.setVisible(true);
                time4of3.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID4of3.setVisible(true);
                apptmtID4of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of3.setVisible(true);
                time5of3.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID5of3.setVisible(true);
                apptmtID5of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of3.setVisible(true);
                time6of3.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID6of3.setVisible(true);
                apptmtID6of3.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl4.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of4.setVisible(true);
                time1of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of4.setVisible(true);
                apptmtID1of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of4.setVisible(true);
                time2of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of4.setVisible(true);
                apptmtID2of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of4.setVisible(true);
                time3of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of4.setVisible(true);
                apptmtID3of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of4.setVisible(true);
                time4of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of4.setVisible(true);
                apptmtID4of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of4.setVisible(true);
                time5of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of4.setVisible(true);
                apptmtID5of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of4.setVisible(true);
                time6of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of4.setVisible(true);
                apptmtID6of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl5.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of5.setVisible(true);
                time1of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of5.setVisible(true);
                apptmtID1of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of5.setVisible(true);
                time2of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of5.setVisible(true);
                apptmtID2of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of5.setVisible(true);
                time3of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of5.setVisible(true);
                apptmtID3of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of5.setVisible(true);
                time4of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of5.setVisible(true);
                apptmtID4of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of5.setVisible(true);
                time5of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of5.setVisible(true);
                time6of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of5.setVisible(true);
                apptmtID6of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day4 = parseInt(Lbl6.getText());
        date = LocalDate.of(year, month, day4);
        times = LocalTime.of(0, 0);
        LocalDateTime dt4 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt4)) {
            setDailyApptmts(dt4);
            if (numOfApptmts(dt4) >= 1) {
                int index = 0;
                time1of6.setVisible(true);
                time1of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of6.setVisible(true);
                apptmtID1of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 2) {
                int index = 1;
                time2of6.setVisible(true);
                time2of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of6.setVisible(true);
                apptmtID2of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 3) {
                int index = 2;
                time3of6.setVisible(true);
                time3of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of6.setVisible(true);
                apptmtID3of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 4) {
                int index = 3;
                time4of6.setVisible(true);
                time4of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 5) {
                int index = 4;
                time5of6.setVisible(true);
                time5of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 6) {
                int index = 5;
                time6of6.setVisible(true);
                time6of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of6.setVisible(true);
                apptmtID6of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day5 = parseInt(Lbl7.getText());
        date = LocalDate.of(year, month, day5);
        times = LocalTime.of(0, 0);
        LocalDateTime dt5 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt5)) {
            setDailyApptmts(dt5);
            if (numOfApptmts(dt5) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day6 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day6);
        times = LocalTime.of(0, 0);
        LocalDateTime dt6 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt6)) {
            setDailyApptmts(dt6);
            if (numOfApptmts(dt6) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID4of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day7 = parseInt(Lbl9.getText());
        date = LocalDate.of(year, month, day7);
        times = LocalTime.of(0, 0);
        LocalDateTime dt7 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt7)) {
            setDailyApptmts(dt7);
            if (numOfApptmts(dt7) >= 1) {
                int index = 0;
                time1of9.setVisible(true);
                time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of9.setVisible(true);
                apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 2) {
                int index = 1;
                time2of9.setVisible(true);
                time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of9.setVisible(true);
                apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 3) {
                int index = 2;
                time3of9.setVisible(true);
                time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of9.setVisible(true);
                apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 4) {
                int index = 3;
                time4of9.setVisible(true);
                time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of9.setVisible(true);
                apptmtID4of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 5) {
                int index = 4;
                time5of9.setVisible(true);
                time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 6) {
                int index = 5;
                time6of9.setVisible(true);
                time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of9.setVisible(true);
                apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day8 = parseInt(Lbl10.getText());
        date = LocalDate.of(year, month, day8);
        times = LocalTime.of(0, 0);
        LocalDateTime dt8 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt8)) {
            setDailyApptmts(dt8);
            if (numOfApptmts(dt8) >= 1) {
                int index = 0;
                time1of10.setVisible(true);
                time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of10.setVisible(true);
                apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of10.setVisible(true);
                apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 3) {
                int index = 2;
                time3of10.setVisible(true);
                time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of10.setVisible(true);
                apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 4) {
                int index = 3;
                time4of10.setVisible(true);
                time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 5) {
                int index = 4;
                time5of10.setVisible(true);
                time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 6) {
                int index = 5;
                time6of10.setVisible(true);
                time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of10.setVisible(true);
                apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day9 = parseInt(Lbl11.getText());
        date = LocalDate.of(year, month, day9);
        times = LocalTime.of(0, 0);
        LocalDateTime dt9 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt9)) {
            setDailyApptmts(dt9);
            if (numOfApptmts(dt9) >= 1) {
                int index = 0;
                time1of11.setVisible(true);
                time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of11.setVisible(true);
                apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 2) {
                int index = 1;
                time2of11.setVisible(true);
                time2of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of11.setVisible(true);
                apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 3) {
                int index = 2;
                time3of11.setVisible(true);
                time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of11.setVisible(true);
                apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 4) {
                int index = 3;
                time4of11.setVisible(true);
                time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 5) {
                int index = 4;
                time5of11.setVisible(true);
                time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 6) {
                int index = 5;
                time6of11.setVisible(true);
                time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of11.setVisible(true);
                apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day10 = parseInt(Lbl12.getText());
        date = LocalDate.of(year, month, day10);
        times = LocalTime.of(0, 0);
        LocalDateTime dt10 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt10)) {
            setDailyApptmts(dt10);
            if (numOfApptmts(dt10) >= 1) {
                int index = 0;
                time1of12.setVisible(true);
                time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of12.setVisible(true);
                apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 2) {
                int index = 1;
                time2of12.setVisible(true);
                time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of12.setVisible(true);
                apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 3) {
                int index = 2;
                time3of12.setVisible(true);
                time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of12.setVisible(true);
                apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 4) {
                int index = 3;
                time4of12.setVisible(true);
                time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of12.setVisible(true);
                apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 5) {
                int index = 4;
                time5of12.setVisible(true);
                time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of12.setVisible(true);
                apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 6) {
                int index = 5;
                time6of12.setVisible(true);
                time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of12.setVisible(true);
                apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day11 = parseInt(Lbl13.getText());
        date = LocalDate.of(year, month, day11);
        times = LocalTime.of(0, 0);
        LocalDateTime dt11 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt11)) {
            setDailyApptmts(dt11);
            if (numOfApptmts(dt11) >= 1) {
                int index = 0;
                time1of13.setVisible(true);
                time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of13.setVisible(true);
                apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 2) {
                int index = 1;
                time2of13.setVisible(true);
                time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of13.setVisible(true);
                apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 3) {
                int index = 2;
                time3of13.setVisible(true);
                time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of13.setVisible(true);
                apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 4) {
                int index = 3;
                time4of13.setVisible(true);
                time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of13.setVisible(true);
                apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 5) {
                int index = 4;
                time5of13.setVisible(true);
                time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of13.setVisible(true);
                apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 6) {
                int index = 5;
                time6of13.setVisible(true);
                time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of13.setVisible(true);
                apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day12 = parseInt(Lbl14.getText());
        date = LocalDate.of(year, month, day12);
        times = LocalTime.of(0, 0);
        LocalDateTime dt12 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt12)) {
            setDailyApptmts(dt12);
            if (numOfApptmts(dt12) >= 1) {
                int index = 0;
                time1of14.setVisible(true);
                time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of14.setVisible(true);
                apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 2) {
                int index = 1;
                time2of14.setVisible(true);
                time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of14.setVisible(true);
                apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 3) {
                int index = 2;
                time3of14.setVisible(true);
                time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of14.setVisible(true);
                apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 4) {
                int index = 3;
                time4of14.setVisible(true);
                time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of14.setVisible(true);
                apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 5) {
                int index = 4;
                time5of14.setVisible(true);
                time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of14.setVisible(true);
                apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 6) {
                int index = 5;
                time6of14.setVisible(true);
                time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of14.setVisible(true);
                apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day13 = parseInt(Lbl15.getText());
        date = LocalDate.of(year, month, day13);
        times = LocalTime.of(0, 0);
        LocalDateTime dt13 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt13)) {
            setDailyApptmts(dt13);
            if (numOfApptmts(dt13) >= 1) {
                int index = 0;
                time1of15.setVisible(true);
                time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of15.setVisible(true);
                apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 2) {
                int index = 1;
                time2of15.setVisible(true);
                time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of15.setVisible(true);
                apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 3) {
                int index = 2;
                time3of15.setVisible(true);
                time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of15.setVisible(true);
                apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 4) {
                int index = 3;
                time4of15.setVisible(true);
                time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of15.setVisible(true);
                apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 5) {
                int index = 4;
                time5of15.setVisible(true);
                time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of15.setVisible(true);
                apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 6) {
                int index = 5;
                time6of15.setVisible(true);
                time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of15.setVisible(true);
                apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day14 = parseInt(Lbl16.getText());
        date = LocalDate.of(year, month, day14);
        times = LocalTime.of(0, 0);
        LocalDateTime dt14 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt14)) {
            setDailyApptmts(dt14);
            if (numOfApptmts(dt14) >= 1) {
                int index = 0;
                time1of16.setVisible(true);
                time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of16.setVisible(true);
                apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 2) {
                int index = 1;
                time2of16.setVisible(true);
                time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of16.setVisible(true);
                apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 3) {
                int index = 2;
                time3of16.setVisible(true);
                time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of16.setVisible(true);
                apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 4) {
                int index = 3;
                time4of16.setVisible(true);
                time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of16.setVisible(true);
                apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 5) {
                int index = 4;
                time5of16.setVisible(true);
                time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of16.setVisible(true);
                apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 6) {
                int index = 5;
                time6of16.setVisible(true);
                time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of16.setVisible(true);
                apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day15 = parseInt(Lbl17.getText());
        date = LocalDate.of(year, month, day15);
        times = LocalTime.of(0, 0);
        LocalDateTime dt15 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt15)) {
            setDailyApptmts(dt15);
            if (numOfApptmts(dt15) >= 1) {
                int index = 0;
                time1of17.setVisible(true);
                time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of17.setVisible(true);
                apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 2) {
                int index = 1;
                time2of17.setVisible(true);
                time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of17.setVisible(true);
                apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 3) {
                int index = 2;
                time3of17.setVisible(true);
                time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of17.setVisible(true);
                apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 4) {
                int index = 3;
                time4of17.setVisible(true);
                time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of17.setVisible(true);
                apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 5) {
                int index = 4;
                time5of17.setVisible(true);
                time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of17.setVisible(true);
                apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 6) {
                int index = 5;
                time6of17.setVisible(true);
                time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of17.setVisible(true);
                apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day16 = parseInt(Lbl18.getText());
        date = LocalDate.of(year, month, day16);
        times = LocalTime.of(0, 0);
        LocalDateTime dt16 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt16)) {
            setDailyApptmts(dt16);
            if (numOfApptmts(dt16) >= 1) {
                int index = 0;
                time1of18.setVisible(true);
                time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of18.setVisible(true);
                apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 2) {
                int index = 1;
                time2of18.setVisible(true);
                time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of18.setVisible(true);
                apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 3) {
                int index = 2;
                time3of18.setVisible(true);
                time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of18.setVisible(true);
                apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 4) {
                int index = 3;
                time4of18.setVisible(true);
                time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of18.setVisible(true);
                apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 5) {
                int index = 4;
                time5of18.setVisible(true);
                time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of18.setVisible(true);
                apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 6) {
                int index = 5;
                time6of18.setVisible(true);
                time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of18.setVisible(true);
                apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day17 = parseInt(Lbl19.getText());
        date = LocalDate.of(year, month, day17);
        times = LocalTime.of(0, 0);
        LocalDateTime dt17 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt17)) {
            setDailyApptmts(dt17);
            if (numOfApptmts(dt17) >= 1) {
                int index = 0;
                time1of19.setVisible(true);
                time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of19.setVisible(true);
                apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 2) {
                int index = 1;
                time2of19.setVisible(true);
                time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of19.setVisible(true);
                apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 3) {
                int index = 2;
                time3of19.setVisible(true);
                time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of19.setVisible(true);
                apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 4) {
                int index = 3;
                time4of19.setVisible(true);
                time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of19.setVisible(true);
                apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 5) {
                int index = 4;
                time5of19.setVisible(true);
                time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of19.setVisible(true);
                apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 6) {
                int index = 5;
                time6of19.setVisible(true);
                time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of19.setVisible(true);
                apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day18 = parseInt(Lbl20.getText());
        date = LocalDate.of(year, month, day18);
        times = LocalTime.of(0, 0);
        LocalDateTime dt18 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt18)) {
            setDailyApptmts(dt18);
            if (numOfApptmts(dt18) >= 1) {
                int index = 0;
                time1of20.setVisible(true);
                time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of20.setVisible(true);
                apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 2) {
                int index = 1;
                time2of20.setVisible(true);
                time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of20.setVisible(true);
                apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 3) {
                int index = 2;
                time3of20.setVisible(true);
                time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of20.setVisible(true);
                apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 4) {
                int index = 3;
                time4of20.setVisible(true);
                time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of20.setVisible(true);
                apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 5) {
                int index = 4;
                time5of20.setVisible(true);
                time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of20.setVisible(true);
                apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 6) {
                int index = 5;
                time6of20.setVisible(true);
                time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of20.setVisible(true);
                apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day19 = parseInt(Lbl21.getText());
        date = LocalDate.of(year, month, day19);
        times = LocalTime.of(0, 0);
        LocalDateTime dt19 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt19)) {
            setDailyApptmts(dt19);
            if (numOfApptmts(dt19) >= 1) {
                int index = 0;
                time1of21.setVisible(true);
                time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of21.setVisible(true);
                apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 2) {
                int index = 1;
                time2of21.setVisible(true);
                time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of21.setVisible(true);
                apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 3) {
                int index = 2;
                time3of21.setVisible(true);
                time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of21.setVisible(true);
                apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 4) {
                int index = 3;
                time4of21.setVisible(true);
                time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of21.setVisible(true);
                apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 5) {
                int index = 4;
                time5of21.setVisible(true);
                time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of21.setVisible(true);
                apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 6) {
                int index = 5;
                time6of21.setVisible(true);
                time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of21.setVisible(true);
                apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day20 = parseInt(Lbl22.getText());
        date = LocalDate.of(year, month, day20);
        times = LocalTime.of(0, 0);
        LocalDateTime dt20 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt20)) {
            setDailyApptmts(dt20);
            if (numOfApptmts(dt20) >= 1) {
                int index = 0;
                time1of22.setVisible(true);
                time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of22.setVisible(true);
                apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 2) {
                int index = 1;
                time2of22.setVisible(true);
                time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of22.setVisible(true);
                apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 3) {
                int index = 2;
                time3of22.setVisible(true);
                time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of22.setVisible(true);
                apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 4) {
                int index = 3;
                time4of22.setVisible(true);
                time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of22.setVisible(true);
                apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 5) {
                int index = 4;
                time5of22.setVisible(true);
                time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of22.setVisible(true);
                apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 6) {
                int index = 5;
                time6of22.setVisible(true);
                time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of22.setVisible(true);
                apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day21 = parseInt(Lbl23.getText());
        date = LocalDate.of(year, month, day21);
        times = LocalTime.of(0, 0);
        LocalDateTime dt21 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt21)) {
            setDailyApptmts(dt21);
            if (numOfApptmts(dt21) >= 1) {
                int index = 0;
                time1of23.setVisible(true);
                time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of23.setVisible(true);
                apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 2) {
                int index = 1;
                time2of23.setVisible(true);
                time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of23.setVisible(true);
                apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 3) {
                int index = 2;
                time3of23.setVisible(true);
                time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of23.setVisible(true);
                apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 4) {
                int index = 3;
                time4of23.setVisible(true);
                time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of23.setVisible(true);
                apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 5) {
                int index = 4;
                time5of23.setVisible(true);
                time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of23.setVisible(true);
                apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 6) {
                int index = 5;
                time6of23.setVisible(true);
                time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of23.setVisible(true);
                apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day22 = parseInt(Lbl24.getText());
        date = LocalDate.of(year, month, day22);
        times = LocalTime.of(0, 0);
        LocalDateTime dt22 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt22)) {
            setDailyApptmts(dt22);
            if (numOfApptmts(dt22) >= 1) {
                int index = 0;
                time1of24.setVisible(true);
                time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of24.setVisible(true);
                apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 2) {
                int index = 1;
                time2of24.setVisible(true);
                time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of24.setVisible(true);
                apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 3) {
                int index = 2;
                time3of24.setVisible(true);
                time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of24.setVisible(true);
                apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 4) {
                int index = 3;
                time4of24.setVisible(true);
                time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of24.setVisible(true);
                apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 5) {
                int index = 4;
                time5of24.setVisible(true);
                time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of24.setVisible(true);
                apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 6) {
                int index = 5;
                time6of24.setVisible(true);
                time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of24.setVisible(true);
                apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day23 = parseInt(Lbl25.getText());
        date = LocalDate.of(year, month, day23);
        times = LocalTime.of(0, 0);
        LocalDateTime dt23 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt23)) {
            setDailyApptmts(dt23);
            if (numOfApptmts(dt23) >= 1) {
                int index = 0;
                time1of25.setVisible(true);
                time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of25.setVisible(true);
                apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 2) {
                int index = 1;
                time2of25.setVisible(true);
                time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of25.setVisible(true);
                apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 3) {
                int index = 2;
                time3of25.setVisible(true);
                time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of25.setVisible(true);
                apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 4) {
                int index = 3;
                time4of25.setVisible(true);
                time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of25.setVisible(true);
                apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 5) {
                int index = 4;
                time5of25.setVisible(true);
                time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of25.setVisible(true);
                apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 6) {
                int index = 5;
                time6of25.setVisible(true);
                time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of25.setVisible(true);
                apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day24 = parseInt(Lbl26.getText());
        date = LocalDate.of(year, month, day24);
        times = LocalTime.of(0, 0);
        LocalDateTime dt24 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt24)) {
            setDailyApptmts(dt24);
            if (numOfApptmts(dt24) >= 1) {
                int index = 0;
                time1of26.setVisible(true);
                time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of26.setVisible(true);
                apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 2) {
                int index = 1;
                time2of26.setVisible(true);
                time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of26.setVisible(true);
                apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 3) {
                int index = 2;
                time3of26.setVisible(true);
                time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of26.setVisible(true);
                apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 4) {
                int index = 3;
                time4of26.setVisible(true);
                time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of26.setVisible(true);
                apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 5) {
                int index = 4;
                time5of26.setVisible(true);
                time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of26.setVisible(true);
                apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 6) {
                int index = 5;
                time6of26.setVisible(true);
                time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of26.setVisible(true);
                apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day25 = parseInt(Lbl27.getText());
        date = LocalDate.of(year, month, day25);
        times = LocalTime.of(0, 0);
        LocalDateTime dt25 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt25)) {
            setDailyApptmts(dt25);
            if (numOfApptmts(dt25) >= 1) {
                int index = 0;
                time1of27.setVisible(true);
                time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of27.setVisible(true);
                apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 2) {
                int index = 1;
                time2of27.setVisible(true);
                time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of27.setVisible(true);
                apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 3) {
                int index = 2;
                time3of27.setVisible(true);
                time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of27.setVisible(true);
                apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 4) {
                int index = 3;
                time4of27.setVisible(true);
                time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of27.setVisible(true);
                apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 5) {
                int index = 4;
                time5of27.setVisible(true);
                time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of27.setVisible(true);
                apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 6) {
                int index = 5;
                time6of27.setVisible(true);
                time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of27.setVisible(true);
                apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day26 = parseInt(Lbl28.getText());
        date = LocalDate.of(year, month, day26);
        times = LocalTime.of(0, 0);
        LocalDateTime dt26 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt26)) {
            setDailyApptmts(dt26);
            if (numOfApptmts(dt26) >= 1) {
                int index = 0;
                time1of28.setVisible(true);
                time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of28.setVisible(true);
                apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 2) {
                int index = 1;
                time2of28.setVisible(true);
                time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of28.setVisible(true);
                apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 3) {
                int index = 2;
                time3of28.setVisible(true);
                time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of28.setVisible(true);
                apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 4) {
                int index = 3;
                time4of28.setVisible(true);
                time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of28.setVisible(true);
                apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 5) {
                int index = 4;
                time5of28.setVisible(true);
                time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of28.setVisible(true);
                apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 6) {
                int index = 5;
                time6of28.setVisible(true);
                time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of28.setVisible(true);
                apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day27 = parseInt(Lbl29.getText());
        date = LocalDate.of(year, month, day27);
        times = LocalTime.of(0, 0);
        LocalDateTime dt27 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt27)) {
            setDailyApptmts(dt27);
            if (numOfApptmts(dt27) >= 1) {
                int index = 0;
                time1of29.setVisible(true);
                time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of29.setVisible(true);
                apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 2) {
                int index = 1;
                time2of29.setVisible(true);
                time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of29.setVisible(true);
                apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 3) {
                int index = 2;
                time3of29.setVisible(true);
                time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of29.setVisible(true);
                apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 4) {
                int index = 3;
                time4of29.setVisible(true);
                time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of29.setVisible(true);
                apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 5) {
                int index = 4;
                time5of29.setVisible(true);
                time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of29.setVisible(true);
                apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 6) {
                int index = 5;
                time6of29.setVisible(true);
                time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of29.setVisible(true);
                apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day28 = parseInt(Lbl30.getText());
        date = LocalDate.of(year, month, day28);
        times = LocalTime.of(0, 0);
        LocalDateTime dt28 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt28)) {
            setDailyApptmts(dt28);
            if (numOfApptmts(dt28) >= 1) {
                int index = 0;
                time1of30.setVisible(true);
                time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of30.setVisible(true);
                apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 2) {
                int index = 1;
                time2of30.setVisible(true);
                time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of30.setVisible(true);
                apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 3) {
                int index = 2;
                time3of30.setVisible(true);
                time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of30.setVisible(true);
                apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 4) {
                int index = 3;
                time4of30.setVisible(true);
                time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of30.setVisible(true);
                apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 5) {
                int index = 4;
                time5of30.setVisible(true);
                time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of30.setVisible(true);
                apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 6) {
                int index = 5;
                time6of30.setVisible(true);
                time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of30.setVisible(true);
                apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
            Lbl31.setText("29");
            int day29 = parseInt(Lbl31.getText());
            date = LocalDate.of(year, month, day29);
            times = LocalTime.of(0, 0);
            LocalDateTime dt29 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt29)) {
                setDailyApptmts(dt29);
                if (numOfApptmts(dt29) >= 1) {
                    int index = 0;
                    time1of31.setVisible(true);
                    time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of31.setVisible(true);
                    apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 2) {
                    int index = 1;
                    time2of31.setVisible(true);
                    time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of31.setVisible(true);
                    apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 3) {
                    int index = 2;
                    time3of31.setVisible(true);
                    time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of31.setVisible(true);
                    apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 4) {
                    int index = 3;
                    time4of31.setVisible(true);
                    time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of31.setVisible(true);
                    apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 5) {
                    int index = 4;
                    time5of31.setVisible(true);
                    time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of31.setVisible(true);
                    apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 6) {
                    int index = 5;
                    time6of31.setVisible(true);
                    time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of31.setVisible(true);
                    apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if (month != 2) {
            Lbl32.setText("30");
            int day30 = parseInt(Lbl32.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of32.setVisible(true);
                    time1of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of32.setVisible(true);
                    apptmtID1of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of32.setVisible(true);
                    time2of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of32.setVisible(true);
                    apptmtID2of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of32.setVisible(true);
                    time3of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of32.setVisible(true);
                    apptmtID3of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of32.setVisible(true);
                    time4of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of32.setVisible(true);
                    apptmtID4of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of32.setVisible(true);
                    time5of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of32.setVisible(true);
                    apptmtID5of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of32.setVisible(true);
                    time6of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of32.setVisible(true);
                    apptmtID6of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl33.setText("31");
            int day31 = parseInt(Lbl33.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of33.setVisible(true);
                    time1of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of33.setVisible(true);
                    apptmtID1of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of33.setVisible(true);
                    time2of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of33.setVisible(true);
                    apptmtID2of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of33.setVisible(true);
                    time3of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of33.setVisible(true);
                    apptmtID3of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of33.setVisible(true);
                    time4of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of33.setVisible(true);
                    apptmtID4of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of33.setVisible(true);
                    time5of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of33.setVisible(true);
                    apptmtID5of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of33.setVisible(true);
                    time6of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of33.setVisible(true);
                    apptmtID6of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public void wednesdayStartMonth(int month, int year) throws SQLException {
        setInitialVisibility();
        Lbl1.setText("");
        Lbl2.setText("");
        Lbl3.setText("");
        Lbl4.setText("1");
        Lbl5.setText("2");
        Lbl6.setText("3");
        Lbl7.setText("4");
        Lbl8.setText("5");
        Lbl9.setText("6");
        Lbl10.setText("7");
        Lbl11.setText("8");
        Lbl12.setText("9");
        Lbl13.setText("10");
        Lbl14.setText("11");
        Lbl15.setText("12");
        Lbl16.setText("13");
        Lbl17.setText("14");
        Lbl18.setText("15");
        Lbl19.setText("16");
        Lbl20.setText("17");
        Lbl21.setText("18");
        Lbl22.setText("19");
        Lbl23.setText("20");
        Lbl24.setText("21");
        Lbl25.setText("22");
        Lbl26.setText("23");
        Lbl27.setText("24");
        Lbl28.setText("25");
        Lbl29.setText("26");
        Lbl30.setText("27");
        Lbl31.setText("28");
        Lbl32.setText("");
        Lbl33.setText("");
        Lbl34.setText("");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl4.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of4.setVisible(true);
                time1of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of4.setVisible(true);
                apptmtID1of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of4.setVisible(true);
                time2of4.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of4.setVisible(true);
                apptmtID2of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of4.setVisible(true);
                time3of4.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID3of4.setVisible(true);
                apptmtID3of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of4.setVisible(true);
                time4of4.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID4of4.setVisible(true);
                apptmtID4of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of4.setVisible(true);
                time5of4.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID5of4.setVisible(true);
                apptmtID5of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of4.setVisible(true);
                time6of4.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID6of4.setVisible(true);
                apptmtID6of4.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl5.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of5.setVisible(true);
                time1of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of5.setVisible(true);
                apptmtID1of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of5.setVisible(true);
                time2of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of5.setVisible(true);
                apptmtID2of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of5.setVisible(true);
                time3of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of5.setVisible(true);
                apptmtID3of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of5.setVisible(true);
                time4of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of5.setVisible(true);
                apptmtID4of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of5.setVisible(true);
                time5of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of5.setVisible(true);
                time6of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of5.setVisible(true);
                apptmtID6of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl6.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of6.setVisible(true);
                time1of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of6.setVisible(true);
                apptmtID1of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of6.setVisible(true);
                time2of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of6.setVisible(true);
                apptmtID2of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of6.setVisible(true);
                time3of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of6.setVisible(true);
                apptmtID3of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of6.setVisible(true);
                time4of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of6.setVisible(true);
                apptmtID4of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of6.setVisible(true);
                time5of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of6.setVisible(true);
                time6of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of6.setVisible(true);
                apptmtID6of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day4 = parseInt(Lbl7.getText());
        date = LocalDate.of(year, month, day4);
        times = LocalTime.of(0, 0);
        LocalDateTime dt4 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt4)) {
            setDailyApptmts(dt4);
            if (numOfApptmts(dt4) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day5 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day5);
        times = LocalTime.of(0, 0);
        LocalDateTime dt5 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt5)) {
            setDailyApptmts(dt5);
            if (numOfApptmts(dt5) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID4of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day6 = parseInt(Lbl9.getText());
        date = LocalDate.of(year, month, day6);
        times = LocalTime.of(0, 0);
        LocalDateTime dt6 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt6)) {
            setDailyApptmts(dt6);
            if (numOfApptmts(dt6) >= 1) {
                int index = 0;
                time1of9.setVisible(true);
                time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of9.setVisible(true);
                apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 2) {
                int index = 1;
                time2of9.setVisible(true);
                time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of9.setVisible(true);
                apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 3) {
                int index = 2;
                time3of9.setVisible(true);
                time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of9.setVisible(true);
                apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 4) {
                int index = 3;
                time4of9.setVisible(true);
                time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of9.setVisible(true);
                apptmtID4of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 5) {
                int index = 4;
                time5of9.setVisible(true);
                time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 6) {
                int index = 5;
                time6of9.setVisible(true);
                time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of9.setVisible(true);
                apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day7 = parseInt(Lbl10.getText());
        date = LocalDate.of(year, month, day7);
        times = LocalTime.of(0, 0);
        LocalDateTime dt7 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt7)) {
            setDailyApptmts(dt7);
            if (numOfApptmts(dt7) >= 1) {
                int index = 0;
                time1of10.setVisible(true);
                time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of10.setVisible(true);
                apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of10.setVisible(true);
                apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 3) {
                int index = 2;
                time3of10.setVisible(true);
                time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of10.setVisible(true);
                apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 4) {
                int index = 3;
                time4of10.setVisible(true);
                time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of10.setVisible(true);
                apptmtID4of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 5) {
                int index = 4;
                time5of10.setVisible(true);
                time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 6) {
                int index = 5;
                time6of10.setVisible(true);
                time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of10.setVisible(true);
                apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day8 = parseInt(Lbl11.getText());
        date = LocalDate.of(year, month, day8);
        times = LocalTime.of(0, 0);
        LocalDateTime dt8 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt8)) {
            setDailyApptmts(dt8);
            if (numOfApptmts(dt8) >= 1) {
                int index = 0;
                time1of11.setVisible(true);
                time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of11.setVisible(true);
                apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 2) {
                int index = 1;
                time2of11.setVisible(true);
                time2of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of11.setVisible(true);
                apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 3) {
                int index = 2;
                time3of11.setVisible(true);
                time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of11.setVisible(true);
                apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 4) {
                int index = 3;
                time4of11.setVisible(true);
                time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of11.setVisible(true);
                apptmtID4of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 5) {
                int index = 4;
                time5of11.setVisible(true);
                time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 6) {
                int index = 5;
                time6of11.setVisible(true);
                time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of11.setVisible(true);
                apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day9 = parseInt(Lbl12.getText());
        date = LocalDate.of(year, month, day9);
        times = LocalTime.of(0, 0);
        LocalDateTime dt9 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt9)) {
            setDailyApptmts(dt9);
            if (numOfApptmts(dt9) >= 1) {
                int index = 0;
                time1of12.setVisible(true);
                time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of12.setVisible(true);
                apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 2) {
                int index = 1;
                time2of12.setVisible(true);
                time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of12.setVisible(true);
                apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 3) {
                int index = 2;
                time3of12.setVisible(true);
                time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of12.setVisible(true);
                apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 4) {
                int index = 3;
                time4of12.setVisible(true);
                time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of12.setVisible(true);
                apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 5) {
                int index = 4;
                time5of12.setVisible(true);
                time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of12.setVisible(true);
                apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 6) {
                int index = 5;
                time6of12.setVisible(true);
                time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of12.setVisible(true);
                apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day10 = parseInt(Lbl13.getText());
        date = LocalDate.of(year, month, day10);
        times = LocalTime.of(0, 0);
        LocalDateTime dt10 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt10)) {
            setDailyApptmts(dt10);
            if (numOfApptmts(dt10) >= 1) {
                int index = 0;
                time1of13.setVisible(true);
                time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of13.setVisible(true);
                apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 2) {
                int index = 1;
                time2of13.setVisible(true);
                time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of13.setVisible(true);
                apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 3) {
                int index = 2;
                time3of13.setVisible(true);
                time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of13.setVisible(true);
                apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 4) {
                int index = 3;
                time4of13.setVisible(true);
                time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of13.setVisible(true);
                apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 5) {
                int index = 4;
                time5of13.setVisible(true);
                time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of13.setVisible(true);
                apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 6) {
                int index = 5;
                time6of13.setVisible(true);
                time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of13.setVisible(true);
                apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day11 = parseInt(Lbl14.getText());
        date = LocalDate.of(year, month, day11);
        times = LocalTime.of(0, 0);
        LocalDateTime dt11 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt11)) {
            setDailyApptmts(dt11);
            if (numOfApptmts(dt11) >= 1) {
                int index = 0;
                time1of14.setVisible(true);
                time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of14.setVisible(true);
                apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 2) {
                int index = 1;
                time2of14.setVisible(true);
                time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of14.setVisible(true);
                apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 3) {
                int index = 2;
                time3of14.setVisible(true);
                time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of14.setVisible(true);
                apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 4) {
                int index = 3;
                time4of14.setVisible(true);
                time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of14.setVisible(true);
                apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 5) {
                int index = 4;
                time5of14.setVisible(true);
                time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of14.setVisible(true);
                apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 6) {
                int index = 5;
                time6of14.setVisible(true);
                time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of14.setVisible(true);
                apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day12 = parseInt(Lbl15.getText());
        date = LocalDate.of(year, month, day12);
        times = LocalTime.of(0, 0);
        LocalDateTime dt12 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt12)) {
            setDailyApptmts(dt12);
            if (numOfApptmts(dt12) >= 1) {
                int index = 0;
                time1of15.setVisible(true);
                time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of15.setVisible(true);
                apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 2) {
                int index = 1;
                time2of15.setVisible(true);
                time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of15.setVisible(true);
                apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 3) {
                int index = 2;
                time3of15.setVisible(true);
                time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of15.setVisible(true);
                apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 4) {
                int index = 3;
                time4of15.setVisible(true);
                time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of15.setVisible(true);
                apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 5) {
                int index = 4;
                time5of15.setVisible(true);
                time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of15.setVisible(true);
                apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 6) {
                int index = 5;
                time6of15.setVisible(true);
                time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of15.setVisible(true);
                apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day13 = parseInt(Lbl16.getText());
        date = LocalDate.of(year, month, day13);
        times = LocalTime.of(0, 0);
        LocalDateTime dt13 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt13)) {
            setDailyApptmts(dt13);
            if (numOfApptmts(dt13) >= 1) {
                int index = 0;
                time1of16.setVisible(true);
                time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of16.setVisible(true);
                apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 2) {
                int index = 1;
                time2of16.setVisible(true);
                time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of16.setVisible(true);
                apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 3) {
                int index = 2;
                time3of16.setVisible(true);
                time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of16.setVisible(true);
                apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 4) {
                int index = 3;
                time4of16.setVisible(true);
                time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of16.setVisible(true);
                apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 5) {
                int index = 4;
                time5of16.setVisible(true);
                time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of16.setVisible(true);
                apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 6) {
                int index = 5;
                time6of16.setVisible(true);
                time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of16.setVisible(true);
                apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day14 = parseInt(Lbl17.getText());
        date = LocalDate.of(year, month, day14);
        times = LocalTime.of(0, 0);
        LocalDateTime dt14 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt14)) {
            setDailyApptmts(dt14);
            if (numOfApptmts(dt14) >= 1) {
                int index = 0;
                time1of17.setVisible(true);
                time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of17.setVisible(true);
                apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 2) {
                int index = 1;
                time2of17.setVisible(true);
                time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of17.setVisible(true);
                apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 3) {
                int index = 2;
                time3of17.setVisible(true);
                time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of17.setVisible(true);
                apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 4) {
                int index = 3;
                time4of17.setVisible(true);
                time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of17.setVisible(true);
                apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 5) {
                int index = 4;
                time5of17.setVisible(true);
                time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of17.setVisible(true);
                apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 6) {
                int index = 5;
                time6of17.setVisible(true);
                time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of17.setVisible(true);
                apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day15 = parseInt(Lbl18.getText());
        date = LocalDate.of(year, month, day15);
        times = LocalTime.of(0, 0);
        LocalDateTime dt15 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt15)) {
            setDailyApptmts(dt15);
            if (numOfApptmts(dt15) >= 1) {
                int index = 0;
                time1of18.setVisible(true);
                time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of18.setVisible(true);
                apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 2) {
                int index = 1;
                time2of18.setVisible(true);
                time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of18.setVisible(true);
                apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 3) {
                int index = 2;
                time3of18.setVisible(true);
                time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of18.setVisible(true);
                apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 4) {
                int index = 3;
                time4of18.setVisible(true);
                time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of18.setVisible(true);
                apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 5) {
                int index = 4;
                time5of18.setVisible(true);
                time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of18.setVisible(true);
                apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 6) {
                int index = 5;
                time6of18.setVisible(true);
                time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of18.setVisible(true);
                apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day16 = parseInt(Lbl19.getText());
        date = LocalDate.of(year, month, day16);
        times = LocalTime.of(0, 0);
        LocalDateTime dt16 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt16)) {
            setDailyApptmts(dt16);
            if (numOfApptmts(dt16) >= 1) {
                int index = 0;
                time1of19.setVisible(true);
                time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of19.setVisible(true);
                apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 2) {
                int index = 1;
                time2of19.setVisible(true);
                time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of19.setVisible(true);
                apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 3) {
                int index = 2;
                time3of19.setVisible(true);
                time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of19.setVisible(true);
                apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 4) {
                int index = 3;
                time4of19.setVisible(true);
                time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of19.setVisible(true);
                apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 5) {
                int index = 4;
                time5of19.setVisible(true);
                time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of19.setVisible(true);
                apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 6) {
                int index = 5;
                time6of19.setVisible(true);
                time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of19.setVisible(true);
                apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day17 = parseInt(Lbl20.getText());
        date = LocalDate.of(year, month, day17);
        times = LocalTime.of(0, 0);
        LocalDateTime dt17 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt17)) {
            setDailyApptmts(dt17);
            if (numOfApptmts(dt17) >= 1) {
                int index = 0;
                time1of20.setVisible(true);
                time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of20.setVisible(true);
                apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 2) {
                int index = 1;
                time2of20.setVisible(true);
                time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of20.setVisible(true);
                apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 3) {
                int index = 2;
                time3of20.setVisible(true);
                time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of20.setVisible(true);
                apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 4) {
                int index = 3;
                time4of20.setVisible(true);
                time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of20.setVisible(true);
                apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 5) {
                int index = 4;
                time5of20.setVisible(true);
                time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of20.setVisible(true);
                apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 6) {
                int index = 5;
                time6of20.setVisible(true);
                time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of20.setVisible(true);
                apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day18 = parseInt(Lbl21.getText());
        date = LocalDate.of(year, month, day18);
        times = LocalTime.of(0, 0);
        LocalDateTime dt18 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt18)) {
            setDailyApptmts(dt18);
            if (numOfApptmts(dt18) >= 1) {
                int index = 0;
                time1of21.setVisible(true);
                time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of21.setVisible(true);
                apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 2) {
                int index = 1;
                time2of21.setVisible(true);
                time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of21.setVisible(true);
                apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 3) {
                int index = 2;
                time3of21.setVisible(true);
                time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of21.setVisible(true);
                apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 4) {
                int index = 3;
                time4of21.setVisible(true);
                time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of21.setVisible(true);
                apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 5) {
                int index = 4;
                time5of21.setVisible(true);
                time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of21.setVisible(true);
                apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 6) {
                int index = 5;
                time6of21.setVisible(true);
                time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of21.setVisible(true);
                apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day19 = parseInt(Lbl22.getText());
        date = LocalDate.of(year, month, day19);
        times = LocalTime.of(0, 0);
        LocalDateTime dt19 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt19)) {
            setDailyApptmts(dt19);
            if (numOfApptmts(dt19) >= 1) {
                int index = 0;
                time1of22.setVisible(true);
                time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of22.setVisible(true);
                apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 2) {
                int index = 1;
                time2of22.setVisible(true);
                time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of22.setVisible(true);
                apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 3) {
                int index = 2;
                time3of22.setVisible(true);
                time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of22.setVisible(true);
                apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 4) {
                int index = 3;
                time4of22.setVisible(true);
                time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of22.setVisible(true);
                apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 5) {
                int index = 4;
                time5of22.setVisible(true);
                time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of22.setVisible(true);
                apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 6) {
                int index = 5;
                time6of22.setVisible(true);
                time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of22.setVisible(true);
                apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day20 = parseInt(Lbl23.getText());
        date = LocalDate.of(year, month, day20);
        times = LocalTime.of(0, 0);
        LocalDateTime dt20 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt20)) {
            setDailyApptmts(dt20);
            if (numOfApptmts(dt20) >= 1) {
                int index = 0;
                time1of23.setVisible(true);
                time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of23.setVisible(true);
                apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 2) {
                int index = 1;
                time2of23.setVisible(true);
                time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of23.setVisible(true);
                apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 3) {
                int index = 2;
                time3of23.setVisible(true);
                time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of23.setVisible(true);
                apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 4) {
                int index = 3;
                time4of23.setVisible(true);
                time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of23.setVisible(true);
                apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 5) {
                int index = 4;
                time5of23.setVisible(true);
                time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of23.setVisible(true);
                apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 6) {
                int index = 5;
                time6of23.setVisible(true);
                time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of23.setVisible(true);
                apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day21 = parseInt(Lbl24.getText());
        date = LocalDate.of(year, month, day21);
        times = LocalTime.of(0, 0);
        LocalDateTime dt21 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt21)) {
            setDailyApptmts(dt21);
            if (numOfApptmts(dt21) >= 1) {
                int index = 0;
                time1of24.setVisible(true);
                time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of24.setVisible(true);
                apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 2) {
                int index = 1;
                time2of24.setVisible(true);
                time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of24.setVisible(true);
                apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 3) {
                int index = 2;
                time3of24.setVisible(true);
                time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of24.setVisible(true);
                apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 4) {
                int index = 3;
                time4of24.setVisible(true);
                time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of24.setVisible(true);
                apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 5) {
                int index = 4;
                time5of24.setVisible(true);
                time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of24.setVisible(true);
                apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 6) {
                int index = 5;
                time6of24.setVisible(true);
                time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of24.setVisible(true);
                apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day22 = parseInt(Lbl25.getText());
        date = LocalDate.of(year, month, day22);
        times = LocalTime.of(0, 0);
        LocalDateTime dt22 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt22)) {
            setDailyApptmts(dt22);
            if (numOfApptmts(dt22) >= 1) {
                int index = 0;
                time1of25.setVisible(true);
                time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of25.setVisible(true);
                apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 2) {
                int index = 1;
                time2of25.setVisible(true);
                time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of25.setVisible(true);
                apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 3) {
                int index = 2;
                time3of25.setVisible(true);
                time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of25.setVisible(true);
                apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 4) {
                int index = 3;
                time4of25.setVisible(true);
                time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of25.setVisible(true);
                apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 5) {
                int index = 4;
                time5of25.setVisible(true);
                time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of25.setVisible(true);
                apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 6) {
                int index = 5;
                time6of25.setVisible(true);
                time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of25.setVisible(true);
                apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day23 = parseInt(Lbl26.getText());
        date = LocalDate.of(year, month, day23);
        times = LocalTime.of(0, 0);
        LocalDateTime dt23 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt23)) {
            setDailyApptmts(dt23);
            if (numOfApptmts(dt23) >= 1) {
                int index = 0;
                time1of26.setVisible(true);
                time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of26.setVisible(true);
                apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 2) {
                int index = 1;
                time2of26.setVisible(true);
                time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of26.setVisible(true);
                apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 3) {
                int index = 2;
                time3of26.setVisible(true);
                time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of26.setVisible(true);
                apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 4) {
                int index = 3;
                time4of26.setVisible(true);
                time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of26.setVisible(true);
                apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 5) {
                int index = 4;
                time5of26.setVisible(true);
                time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of26.setVisible(true);
                apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 6) {
                int index = 5;
                time6of26.setVisible(true);
                time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of26.setVisible(true);
                apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day24 = parseInt(Lbl27.getText());
        date = LocalDate.of(year, month, day24);
        times = LocalTime.of(0, 0);
        LocalDateTime dt24 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt24)) {
            setDailyApptmts(dt24);
            if (numOfApptmts(dt24) >= 1) {
                int index = 0;
                time1of27.setVisible(true);
                time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of27.setVisible(true);
                apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 2) {
                int index = 1;
                time2of27.setVisible(true);
                time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of27.setVisible(true);
                apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 3) {
                int index = 2;
                time3of27.setVisible(true);
                time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of27.setVisible(true);
                apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 4) {
                int index = 3;
                time4of27.setVisible(true);
                time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of27.setVisible(true);
                apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 5) {
                int index = 4;
                time5of27.setVisible(true);
                time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of27.setVisible(true);
                apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 6) {
                int index = 5;
                time6of27.setVisible(true);
                time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of27.setVisible(true);
                apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day25 = parseInt(Lbl28.getText());
        date = LocalDate.of(year, month, day25);
        times = LocalTime.of(0, 0);
        LocalDateTime dt25 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt25)) {
            setDailyApptmts(dt25);
            if (numOfApptmts(dt25) >= 1) {
                int index = 0;
                time1of28.setVisible(true);
                time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of28.setVisible(true);
                apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 2) {
                int index = 1;
                time2of28.setVisible(true);
                time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of28.setVisible(true);
                apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 3) {
                int index = 2;
                time3of28.setVisible(true);
                time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of28.setVisible(true);
                apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 4) {
                int index = 3;
                time4of28.setVisible(true);
                time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of28.setVisible(true);
                apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 5) {
                int index = 4;
                time5of28.setVisible(true);
                time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of28.setVisible(true);
                apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 6) {
                int index = 5;
                time6of28.setVisible(true);
                time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of28.setVisible(true);
                apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day26 = parseInt(Lbl29.getText());
        date = LocalDate.of(year, month, day26);
        times = LocalTime.of(0, 0);
        LocalDateTime dt26 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt26)) {
            setDailyApptmts(dt26);
            if (numOfApptmts(dt26) >= 1) {
                int index = 0;
                time1of29.setVisible(true);
                time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of29.setVisible(true);
                apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 2) {
                int index = 1;
                time2of29.setVisible(true);
                time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of29.setVisible(true);
                apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 3) {
                int index = 2;
                time3of29.setVisible(true);
                time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of29.setVisible(true);
                apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 4) {
                int index = 3;
                time4of29.setVisible(true);
                time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of29.setVisible(true);
                apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 5) {
                int index = 4;
                time5of29.setVisible(true);
                time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of29.setVisible(true);
                apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 6) {
                int index = 5;
                time6of29.setVisible(true);
                time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of29.setVisible(true);
                apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day27 = parseInt(Lbl30.getText());
        date = LocalDate.of(year, month, day27);
        times = LocalTime.of(0, 0);
        LocalDateTime dt27 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt27)) {
            setDailyApptmts(dt27);
            if (numOfApptmts(dt27) >= 1) {
                int index = 0;
                time1of30.setVisible(true);
                time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of30.setVisible(true);
                apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 2) {
                int index = 1;
                time2of30.setVisible(true);
                time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of30.setVisible(true);
                apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 3) {
                int index = 2;
                time3of30.setVisible(true);
                time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of30.setVisible(true);
                apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 4) {
                int index = 3;
                time4of30.setVisible(true);
                time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of30.setVisible(true);
                apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 5) {
                int index = 4;
                time5of30.setVisible(true);
                time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of30.setVisible(true);
                apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 6) {
                int index = 5;
                time6of30.setVisible(true);
                time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of30.setVisible(true);
                apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day28 = parseInt(Lbl31.getText());
        date = LocalDate.of(year, month, day28);
        times = LocalTime.of(0, 0);
        LocalDateTime dt28 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt28)) {
            setDailyApptmts(dt28);
            if (numOfApptmts(dt28) >= 1) {
                int index = 0;
                time1of31.setVisible(true);
                time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of31.setVisible(true);
                apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 2) {
                int index = 1;
                time2of31.setVisible(true);
                time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of31.setVisible(true);
                apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 3) {
                int index = 2;
                time3of31.setVisible(true);
                time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of31.setVisible(true);
                apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 4) {
                int index = 3;
                time4of31.setVisible(true);
                time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of31.setVisible(true);
                apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 5) {
                int index = 4;
                time5of31.setVisible(true);
                time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of31.setVisible(true);
                apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 6) {
                int index = 5;
                time6of31.setVisible(true);
                time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of31.setVisible(true);
                apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
            Lbl32.setText("29");
            int day29 = parseInt(Lbl32.getText());
            date = LocalDate.of(year, month, day29);
            times = LocalTime.of(0, 0);
            LocalDateTime dt29 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt29)) {
                setDailyApptmts(dt29);
                if (numOfApptmts(dt29) >= 1) {
                    int index = 0;
                    time1of32.setVisible(true);
                    time1of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of32.setVisible(true);
                    apptmtID1of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 2) {
                    int index = 1;
                    time2of32.setVisible(true);
                    time2of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of32.setVisible(true);
                    apptmtID2of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 3) {
                    int index = 2;
                    time3of32.setVisible(true);
                    time3of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of32.setVisible(true);
                    apptmtID3of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 4) {
                    int index = 3;
                    time4of32.setVisible(true);
                    time4of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of32.setVisible(true);
                    apptmtID4of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 5) {
                    int index = 4;
                    time5of32.setVisible(true);
                    time5of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of32.setVisible(true);
                    apptmtID5of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 6) {
                    int index = 5;
                    time6of32.setVisible(true);
                    time6of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of32.setVisible(true);
                    apptmtID6of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if (month != 2) {
            Lbl33.setText("30");
            int day30 = parseInt(Lbl33.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of33.setVisible(true);
                    time1of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of33.setVisible(true);
                    apptmtID1of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of33.setVisible(true);
                    time2of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of33.setVisible(true);
                    apptmtID2of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of33.setVisible(true);
                    time3of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of33.setVisible(true);
                    apptmtID3of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of33.setVisible(true);
                    time4of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of33.setVisible(true);
                    apptmtID4of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of33.setVisible(true);
                    time5of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of33.setVisible(true);
                    apptmtID5of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of33.setVisible(true);
                    time6of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of33.setVisible(true);
                    apptmtID6of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl34.setText("31");
            int day31 = parseInt(Lbl34.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of34.setVisible(true);
                    time1of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of34.setVisible(true);
                    apptmtID1of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of34.setVisible(true);
                    time2of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of34.setVisible(true);
                    apptmtID2of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of34.setVisible(true);
                    time3of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of34.setVisible(true);
                    apptmtID3of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of34.setVisible(true);
                    time4of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of34.setVisible(true);
                    apptmtID4of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of34.setVisible(true);
                    time5of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of34.setVisible(true);
                    apptmtID5of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of34.setVisible(true);
                    time6of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of34.setVisible(true);
                    apptmtID6of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public void thursdayStartMonth(int month, int year) throws SQLException {
        setInitialVisibility();
        Lbl1.setText("");
        Lbl2.setText("");
        Lbl3.setText("");
        Lbl4.setText("");
        Lbl5.setText("1");
        Lbl6.setText("2");
        Lbl7.setText("3");
        Lbl8.setText("4");
        Lbl9.setText("5");
        Lbl10.setText("6");
        Lbl11.setText("7");
        Lbl12.setText("8");
        Lbl13.setText("9");
        Lbl14.setText("10");
        Lbl15.setText("11");
        Lbl16.setText("12");
        Lbl17.setText("13");
        Lbl18.setText("14");
        Lbl19.setText("15");
        Lbl20.setText("16");
        Lbl21.setText("17");
        Lbl22.setText("18");
        Lbl23.setText("19");
        Lbl24.setText("20");
        Lbl25.setText("21");
        Lbl26.setText("22");
        Lbl27.setText("23");
        Lbl28.setText("24");
        Lbl29.setText("25");
        Lbl30.setText("26");
        Lbl31.setText("27");
        Lbl32.setText("28");
        Lbl33.setText("");
        Lbl34.setText("");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl5.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of5.setVisible(true);
                time1of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of5.setVisible(true);
                apptmtID1of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of5.setVisible(true);
                time2of5.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of5.setVisible(true);
                apptmtID2of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of5.setVisible(true);
                time3of5.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID3of5.setVisible(true);
                apptmtID3of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of5.setVisible(true);
                time4of5.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID4of5.setVisible(true);
                apptmtID4of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of5.setVisible(true);
                time5of5.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID5of5.setVisible(true);
                apptmtID5of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of5.setVisible(true);
                time6of5.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID6of5.setVisible(true);
                apptmtID6of5.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl6.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of6.setVisible(true);
                time1of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of6.setVisible(true);
                apptmtID1of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of6.setVisible(true);
                time2of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of6.setVisible(true);
                apptmtID2of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of6.setVisible(true);
                time3of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of6.setVisible(true);
                apptmtID3of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of6.setVisible(true);
                time4of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of6.setVisible(true);
                apptmtID4of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of6.setVisible(true);
                time5of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of6.setVisible(true);
                time6of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of6.setVisible(true);
                apptmtID6of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl7.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day4 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day4);
        times = LocalTime.of(0, 0);
        LocalDateTime dt4 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt4)) {
            setDailyApptmts(dt4);
            if (numOfApptmts(dt4) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day5 = parseInt(Lbl9.getText());
        date = LocalDate.of(year, month, day5);
        times = LocalTime.of(0, 0);
        LocalDateTime dt5 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt5)) {
            setDailyApptmts(dt5);
            if (numOfApptmts(dt5) >= 1) {
                int index = 0;
                time1of9.setVisible(true);
                time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of9.setVisible(true);
                apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 2) {
                int index = 1;
                time2of9.setVisible(true);
                time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of9.setVisible(true);
                apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 3) {
                int index = 2;
                time3of9.setVisible(true);
                time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of9.setVisible(true);
                apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 4) {
                int index = 3;
                time4of9.setVisible(true);
                time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of9.setVisible(true);
                apptmtID4of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 5) {
                int index = 4;
                time5of9.setVisible(true);
                time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 6) {
                int index = 5;
                time6of9.setVisible(true);
                time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of9.setVisible(true);
                apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day6 = parseInt(Lbl10.getText());
        date = LocalDate.of(year, month, day6);
        times = LocalTime.of(0, 0);
        LocalDateTime dt6 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt6)) {
            setDailyApptmts(dt6);
            if (numOfApptmts(dt6) >= 1) {
                int index = 0;
                time1of10.setVisible(true);
                time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of10.setVisible(true);
                apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of10.setVisible(true);
                apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 3) {
                int index = 2;
                time3of10.setVisible(true);
                time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of10.setVisible(true);
                apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 4) {
                int index = 3;
                time4of10.setVisible(true);
                time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 5) {
                int index = 4;
                time5of10.setVisible(true);
                time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 6) {
                int index = 5;
                time6of10.setVisible(true);
                time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of10.setVisible(true);
                apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day7 = parseInt(Lbl11.getText());
        date = LocalDate.of(year, month, day7);
        times = LocalTime.of(0, 0);
        LocalDateTime dt7 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt7)) {
            setDailyApptmts(dt7);
            if (numOfApptmts(dt7) >= 1) {
                int index = 0;
                time1of11.setVisible(true);
                time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of11.setVisible(true);
                apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 2) {
                int index = 1;
                time2of11.setVisible(true);
                time2of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of11.setVisible(true);
                apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 3) {
                int index = 2;
                time3of11.setVisible(true);
                time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of11.setVisible(true);
                apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 4) {
                int index = 3;
                time4of11.setVisible(true);
                time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 5) {
                int index = 4;
                time5of11.setVisible(true);
                time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 6) {
                int index = 5;
                time6of11.setVisible(true);
                time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of11.setVisible(true);
                apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day8 = parseInt(Lbl12.getText());
        date = LocalDate.of(year, month, day8);
        times = LocalTime.of(0, 0);
        LocalDateTime dt8 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt8)) {
            setDailyApptmts(dt8);
            if (numOfApptmts(dt8) >= 1) {
                int index = 0;
                time1of12.setVisible(true);
                time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of12.setVisible(true);
                apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 2) {
                int index = 1;
                time2of12.setVisible(true);
                time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of12.setVisible(true);
                apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 3) {
                int index = 2;
                time3of12.setVisible(true);
                time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of12.setVisible(true);
                apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 4) {
                int index = 3;
                time4of12.setVisible(true);
                time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of12.setVisible(true);
                apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 5) {
                int index = 4;
                time5of12.setVisible(true);
                time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of12.setVisible(true);
                apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 6) {
                int index = 5;
                time6of12.setVisible(true);
                time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of12.setVisible(true);
                apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day9 = parseInt(Lbl13.getText());
        date = LocalDate.of(year, month, day9);
        times = LocalTime.of(0, 0);
        LocalDateTime dt9 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt9)) {
            setDailyApptmts(dt9);
            if (numOfApptmts(dt9) >= 1) {
                int index = 0;
                time1of13.setVisible(true);
                time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of13.setVisible(true);
                apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 2) {
                int index = 1;
                time2of13.setVisible(true);
                time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of13.setVisible(true);
                apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 3) {
                int index = 2;
                time3of13.setVisible(true);
                time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of13.setVisible(true);
                apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 4) {
                int index = 3;
                time4of13.setVisible(true);
                time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of13.setVisible(true);
                apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 5) {
                int index = 4;
                time5of13.setVisible(true);
                time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of13.setVisible(true);
                apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 6) {
                int index = 5;
                time6of13.setVisible(true);
                time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of13.setVisible(true);
                apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day10 = parseInt(Lbl14.getText());
        date = LocalDate.of(year, month, day10);
        times = LocalTime.of(0, 0);
        LocalDateTime dt10 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt10)) {
            setDailyApptmts(dt10);
            if (numOfApptmts(dt10) >= 1) {
                int index = 0;
                time1of14.setVisible(true);
                time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of14.setVisible(true);
                apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 2) {
                int index = 1;
                time2of14.setVisible(true);
                time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of14.setVisible(true);
                apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 3) {
                int index = 2;
                time3of14.setVisible(true);
                time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of14.setVisible(true);
                apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 4) {
                int index = 3;
                time4of14.setVisible(true);
                time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of14.setVisible(true);
                apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 5) {
                int index = 4;
                time5of14.setVisible(true);
                time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of14.setVisible(true);
                apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 6) {
                int index = 5;
                time6of14.setVisible(true);
                time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of14.setVisible(true);
                apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day11 = parseInt(Lbl15.getText());
        date = LocalDate.of(year, month, day11);
        times = LocalTime.of(0, 0);
        LocalDateTime dt11 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt11)) {
            setDailyApptmts(dt11);
            if (numOfApptmts(dt11) >= 1) {
                int index = 0;
                time1of15.setVisible(true);
                time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of15.setVisible(true);
                apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 2) {
                int index = 1;
                time2of15.setVisible(true);
                time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of15.setVisible(true);
                apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 3) {
                int index = 2;
                time3of15.setVisible(true);
                time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of15.setVisible(true);
                apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 4) {
                int index = 3;
                time4of15.setVisible(true);
                time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of15.setVisible(true);
                apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 5) {
                int index = 4;
                time5of15.setVisible(true);
                time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of15.setVisible(true);
                apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 6) {
                int index = 5;
                time6of15.setVisible(true);
                time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of15.setVisible(true);
                apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day12 = parseInt(Lbl16.getText());
        date = LocalDate.of(year, month, day12);
        times = LocalTime.of(0, 0);
        LocalDateTime dt12 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt12)) {
            setDailyApptmts(dt12);
            if (numOfApptmts(dt12) >= 1) {
                int index = 0;
                time1of16.setVisible(true);
                time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of16.setVisible(true);
                apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 2) {
                int index = 1;
                time2of16.setVisible(true);
                time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of16.setVisible(true);
                apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 3) {
                int index = 2;
                time3of16.setVisible(true);
                time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of16.setVisible(true);
                apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 4) {
                int index = 3;
                time4of16.setVisible(true);
                time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of16.setVisible(true);
                apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 5) {
                int index = 4;
                time5of16.setVisible(true);
                time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of16.setVisible(true);
                apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 6) {
                int index = 5;
                time6of16.setVisible(true);
                time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of16.setVisible(true);
                apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day13 = parseInt(Lbl17.getText());
        date = LocalDate.of(year, month, day13);
        times = LocalTime.of(0, 0);
        LocalDateTime dt13 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt13)) {
            setDailyApptmts(dt13);
            if (numOfApptmts(dt13) >= 1) {
                int index = 0;
                time1of17.setVisible(true);
                time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of17.setVisible(true);
                apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 2) {
                int index = 1;
                time2of17.setVisible(true);
                time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of17.setVisible(true);
                apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 3) {
                int index = 2;
                time3of17.setVisible(true);
                time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of17.setVisible(true);
                apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 4) {
                int index = 3;
                time4of17.setVisible(true);
                time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of17.setVisible(true);
                apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 5) {
                int index = 4;
                time5of17.setVisible(true);
                time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of17.setVisible(true);
                apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 6) {
                int index = 5;
                time6of17.setVisible(true);
                time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of17.setVisible(true);
                apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day14 = parseInt(Lbl18.getText());
        date = LocalDate.of(year, month, day14);
        times = LocalTime.of(0, 0);
        LocalDateTime dt14 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt14)) {
            setDailyApptmts(dt14);
            if (numOfApptmts(dt14) >= 1) {
                int index = 0;
                time1of18.setVisible(true);
                time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of18.setVisible(true);
                apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 2) {
                int index = 1;
                time2of18.setVisible(true);
                time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of18.setVisible(true);
                apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 3) {
                int index = 2;
                time3of18.setVisible(true);
                time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of18.setVisible(true);
                apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 4) {
                int index = 3;
                time4of18.setVisible(true);
                time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of18.setVisible(true);
                apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 5) {
                int index = 4;
                time5of18.setVisible(true);
                time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of18.setVisible(true);
                apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 6) {
                int index = 5;
                time6of18.setVisible(true);
                time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of18.setVisible(true);
                apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day15 = parseInt(Lbl19.getText());
        date = LocalDate.of(year, month, day15);
        times = LocalTime.of(0, 0);
        LocalDateTime dt15 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt15)) {
            setDailyApptmts(dt15);
            if (numOfApptmts(dt15) >= 1) {
                int index = 0;
                time1of19.setVisible(true);
                time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of19.setVisible(true);
                apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 2) {
                int index = 1;
                time2of19.setVisible(true);
                time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of19.setVisible(true);
                apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 3) {
                int index = 2;
                time3of19.setVisible(true);
                time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of19.setVisible(true);
                apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 4) {
                int index = 3;
                time4of19.setVisible(true);
                time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of19.setVisible(true);
                apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 5) {
                int index = 4;
                time5of19.setVisible(true);
                time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of19.setVisible(true);
                apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 6) {
                int index = 5;
                time6of19.setVisible(true);
                time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of19.setVisible(true);
                apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day16 = parseInt(Lbl20.getText());
        date = LocalDate.of(year, month, day16);
        times = LocalTime.of(0, 0);
        LocalDateTime dt16 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt16)) {
            setDailyApptmts(dt16);
            if (numOfApptmts(dt16) >= 1) {
                int index = 0;
                time1of20.setVisible(true);
                time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of20.setVisible(true);
                apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 2) {
                int index = 1;
                time2of20.setVisible(true);
                time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of20.setVisible(true);
                apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 3) {
                int index = 2;
                time3of20.setVisible(true);
                time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of20.setVisible(true);
                apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 4) {
                int index = 3;
                time4of20.setVisible(true);
                time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of20.setVisible(true);
                apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 5) {
                int index = 4;
                time5of20.setVisible(true);
                time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of20.setVisible(true);
                apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 6) {
                int index = 5;
                time6of20.setVisible(true);
                time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of20.setVisible(true);
                apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day17 = parseInt(Lbl21.getText());
        date = LocalDate.of(year, month, day17);
        times = LocalTime.of(0, 0);
        LocalDateTime dt17 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt17)) {
            setDailyApptmts(dt17);
            if (numOfApptmts(dt17) >= 1) {
                int index = 0;
                time1of21.setVisible(true);
                time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of21.setVisible(true);
                apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 2) {
                int index = 1;
                time2of21.setVisible(true);
                time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of21.setVisible(true);
                apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 3) {
                int index = 2;
                time3of21.setVisible(true);
                time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of21.setVisible(true);
                apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 4) {
                int index = 3;
                time4of21.setVisible(true);
                time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of21.setVisible(true);
                apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 5) {
                int index = 4;
                time5of21.setVisible(true);
                time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of21.setVisible(true);
                apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 6) {
                int index = 5;
                time6of21.setVisible(true);
                time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of21.setVisible(true);
                apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day18 = parseInt(Lbl22.getText());
        date = LocalDate.of(year, month, day18);
        times = LocalTime.of(0, 0);
        LocalDateTime dt18 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt18)) {
            setDailyApptmts(dt18);
            if (numOfApptmts(dt18) >= 1) {
                int index = 0;
                time1of22.setVisible(true);
                time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of22.setVisible(true);
                apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 2) {
                int index = 1;
                time2of22.setVisible(true);
                time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of22.setVisible(true);
                apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 3) {
                int index = 2;
                time3of22.setVisible(true);
                time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of22.setVisible(true);
                apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 4) {
                int index = 3;
                time4of22.setVisible(true);
                time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of22.setVisible(true);
                apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 5) {
                int index = 4;
                time5of22.setVisible(true);
                time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of22.setVisible(true);
                apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 6) {
                int index = 5;
                time6of22.setVisible(true);
                time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of22.setVisible(true);
                apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day19 = parseInt(Lbl23.getText());
        date = LocalDate.of(year, month, day19);
        times = LocalTime.of(0, 0);
        LocalDateTime dt19 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt19)) {
            setDailyApptmts(dt19);
            if (numOfApptmts(dt19) >= 1) {
                int index = 0;
                time1of23.setVisible(true);
                time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of23.setVisible(true);
                apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 2) {
                int index = 1;
                time2of23.setVisible(true);
                time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of23.setVisible(true);
                apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 3) {
                int index = 2;
                time3of23.setVisible(true);
                time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of23.setVisible(true);
                apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 4) {
                int index = 3;
                time4of23.setVisible(true);
                time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of23.setVisible(true);
                apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 5) {
                int index = 4;
                time5of23.setVisible(true);
                time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of23.setVisible(true);
                apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 6) {
                int index = 5;
                time6of23.setVisible(true);
                time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of23.setVisible(true);
                apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day20 = parseInt(Lbl24.getText());
        date = LocalDate.of(year, month, day20);
        times = LocalTime.of(0, 0);
        LocalDateTime dt20 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt20)) {
            setDailyApptmts(dt20);
            if (numOfApptmts(dt20) >= 1) {
                int index = 0;
                time1of24.setVisible(true);
                time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of24.setVisible(true);
                apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 2) {
                int index = 1;
                time2of24.setVisible(true);
                time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of24.setVisible(true);
                apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 3) {
                int index = 2;
                time3of24.setVisible(true);
                time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of24.setVisible(true);
                apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 4) {
                int index = 3;
                time4of24.setVisible(true);
                time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of24.setVisible(true);
                apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 5) {
                int index = 4;
                time5of24.setVisible(true);
                time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of24.setVisible(true);
                apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 6) {
                int index = 5;
                time6of24.setVisible(true);
                time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of24.setVisible(true);
                apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day21 = parseInt(Lbl25.getText());
        date = LocalDate.of(year, month, day21);
        times = LocalTime.of(0, 0);
        LocalDateTime dt21 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt21)) {
            setDailyApptmts(dt21);
            if (numOfApptmts(dt21) >= 1) {
                int index = 0;
                time1of25.setVisible(true);
                time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of25.setVisible(true);
                apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 2) {
                int index = 1;
                time2of25.setVisible(true);
                time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of25.setVisible(true);
                apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 3) {
                int index = 2;
                time3of25.setVisible(true);
                time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of25.setVisible(true);
                apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 4) {
                int index = 3;
                time4of25.setVisible(true);
                time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of25.setVisible(true);
                apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 5) {
                int index = 4;
                time5of25.setVisible(true);
                time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of25.setVisible(true);
                apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 6) {
                int index = 5;
                time6of25.setVisible(true);
                time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of25.setVisible(true);
                apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day22 = parseInt(Lbl26.getText());
        date = LocalDate.of(year, month, day22);
        times = LocalTime.of(0, 0);
        LocalDateTime dt22 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt22)) {
            setDailyApptmts(dt22);
            if (numOfApptmts(dt22) >= 1) {
                int index = 0;
                time1of26.setVisible(true);
                time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of26.setVisible(true);
                apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 2) {
                int index = 1;
                time2of26.setVisible(true);
                time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of26.setVisible(true);
                apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 3) {
                int index = 2;
                time3of26.setVisible(true);
                time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of26.setVisible(true);
                apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 4) {
                int index = 3;
                time4of26.setVisible(true);
                time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of26.setVisible(true);
                apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 5) {
                int index = 4;
                time5of26.setVisible(true);
                time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of26.setVisible(true);
                apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 6) {
                int index = 5;
                time6of26.setVisible(true);
                time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of26.setVisible(true);
                apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day23 = parseInt(Lbl27.getText());
        date = LocalDate.of(year, month, day23);
        times = LocalTime.of(0, 0);
        LocalDateTime dt23 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt23)) {
            setDailyApptmts(dt23);
            if (numOfApptmts(dt23) >= 1) {
                int index = 0;
                time1of27.setVisible(true);
                time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of27.setVisible(true);
                apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 2) {
                int index = 1;
                time2of27.setVisible(true);
                time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of27.setVisible(true);
                apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 3) {
                int index = 2;
                time3of27.setVisible(true);
                time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of27.setVisible(true);
                apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 4) {
                int index = 3;
                time4of27.setVisible(true);
                time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of27.setVisible(true);
                apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 5) {
                int index = 4;
                time5of27.setVisible(true);
                time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of27.setVisible(true);
                apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 6) {
                int index = 5;
                time6of27.setVisible(true);
                time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of27.setVisible(true);
                apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day24 = parseInt(Lbl28.getText());
        date = LocalDate.of(year, month, day24);
        times = LocalTime.of(0, 0);
        LocalDateTime dt24 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt24)) {
            setDailyApptmts(dt24);
            if (numOfApptmts(dt24) >= 1) {
                int index = 0;
                time1of28.setVisible(true);
                time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of28.setVisible(true);
                apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 2) {
                int index = 1;
                time2of28.setVisible(true);
                time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of28.setVisible(true);
                apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 3) {
                int index = 2;
                time3of28.setVisible(true);
                time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of28.setVisible(true);
                apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 4) {
                int index = 3;
                time4of28.setVisible(true);
                time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of28.setVisible(true);
                apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 5) {
                int index = 4;
                time5of28.setVisible(true);
                time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of28.setVisible(true);
                apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 6) {
                int index = 5;
                time6of28.setVisible(true);
                time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of28.setVisible(true);
                apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day25 = parseInt(Lbl29.getText());
        date = LocalDate.of(year, month, day25);
        times = LocalTime.of(0, 0);
        LocalDateTime dt25 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt25)) {
            setDailyApptmts(dt25);
            if (numOfApptmts(dt25) >= 1) {
                int index = 0;
                time1of29.setVisible(true);
                time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of29.setVisible(true);
                apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 2) {
                int index = 1;
                time2of29.setVisible(true);
                time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of29.setVisible(true);
                apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 3) {
                int index = 2;
                time3of29.setVisible(true);
                time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of29.setVisible(true);
                apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 4) {
                int index = 3;
                time4of29.setVisible(true);
                time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of29.setVisible(true);
                apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 5) {
                int index = 4;
                time5of29.setVisible(true);
                time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of29.setVisible(true);
                apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 6) {
                int index = 5;
                time6of29.setVisible(true);
                time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of29.setVisible(true);
                apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day26 = parseInt(Lbl30.getText());
        date = LocalDate.of(year, month, day26);
        times = LocalTime.of(0, 0);
        LocalDateTime dt26 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt26)) {
            setDailyApptmts(dt26);
            if (numOfApptmts(dt26) >= 1) {
                int index = 0;
                time1of30.setVisible(true);
                time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of30.setVisible(true);
                apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 2) {
                int index = 1;
                time2of30.setVisible(true);
                time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of30.setVisible(true);
                apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 3) {
                int index = 2;
                time3of30.setVisible(true);
                time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of30.setVisible(true);
                apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 4) {
                int index = 3;
                time4of30.setVisible(true);
                time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of30.setVisible(true);
                apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 5) {
                int index = 4;
                time5of30.setVisible(true);
                time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of30.setVisible(true);
                apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 6) {
                int index = 5;
                time6of30.setVisible(true);
                time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of30.setVisible(true);
                apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day27 = parseInt(Lbl31.getText());
        date = LocalDate.of(year, month, day27);
        times = LocalTime.of(0, 0);
        LocalDateTime dt27 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt27)) {
            setDailyApptmts(dt27);
            if (numOfApptmts(dt27) >= 1) {
                int index = 0;
                time1of31.setVisible(true);
                time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of31.setVisible(true);
                apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 2) {
                int index = 1;
                time2of31.setVisible(true);
                time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of31.setVisible(true);
                apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 3) {
                int index = 2;
                time3of31.setVisible(true);
                time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of31.setVisible(true);
                apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 4) {
                int index = 3;
                time4of31.setVisible(true);
                time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of31.setVisible(true);
                apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 5) {
                int index = 4;
                time5of31.setVisible(true);
                time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of31.setVisible(true);
                apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 6) {
                int index = 5;
                time6of31.setVisible(true);
                time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of31.setVisible(true);
                apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day28 = parseInt(Lbl32.getText());
        date = LocalDate.of(year, month, day28);
        times = LocalTime.of(0, 0);
        LocalDateTime dt28 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt28)) {
            setDailyApptmts(dt28);
            if (numOfApptmts(dt28) >= 1) {
                int index = 0;
                time1of32.setVisible(true);
                time1of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of32.setVisible(true);
                apptmtID1of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 2) {
                int index = 1;
                time2of32.setVisible(true);
                time2of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of32.setVisible(true);
                apptmtID2of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 3) {
                int index = 2;
                time3of32.setVisible(true);
                time3of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of32.setVisible(true);
                apptmtID3of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 4) {
                int index = 3;
                time4of32.setVisible(true);
                time4of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of32.setVisible(true);
                apptmtID4of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 5) {
                int index = 4;
                time5of32.setVisible(true);
                time5of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of32.setVisible(true);
                apptmtID5of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 6) {
                int index = 5;
                time6of32.setVisible(true);
                time6of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of32.setVisible(true);
                apptmtID6of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
            Lbl33.setText("29");
            int day29 = parseInt(Lbl33.getText());
            date = LocalDate.of(year, month, day29);
            times = LocalTime.of(0, 0);
            LocalDateTime dt29 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt29)) {
                setDailyApptmts(dt29);
                if (numOfApptmts(dt29) >= 1) {
                    int index = 0;
                    time1of33.setVisible(true);
                    time1of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of33.setVisible(true);
                    apptmtID1of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 2) {
                    int index = 1;
                    time2of33.setVisible(true);
                    time2of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of33.setVisible(true);
                    apptmtID2of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 3) {
                    int index = 2;
                    time3of33.setVisible(true);
                    time3of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of33.setVisible(true);
                    apptmtID3of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 4) {
                    int index = 3;
                    time4of33.setVisible(true);
                    time4of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of33.setVisible(true);
                    apptmtID4of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 5) {
                    int index = 4;
                    time5of33.setVisible(true);
                    time5of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of33.setVisible(true);
                    apptmtID5of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 6) {
                    int index = 5;
                    time6of33.setVisible(true);
                    time6of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of33.setVisible(true);
                    apptmtID6of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if (month != 2) {
            Lbl34.setText("30");
            int day30 = parseInt(Lbl34.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of34.setVisible(true);
                    time1of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of34.setVisible(true);
                    apptmtID1of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of34.setVisible(true);
                    time2of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of34.setVisible(true);
                    apptmtID2of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of34.setVisible(true);
                    time3of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of34.setVisible(true);
                    apptmtID3of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of34.setVisible(true);
                    time4of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of34.setVisible(true);
                    apptmtID4of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of34.setVisible(true);
                    time5of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of34.setVisible(true);
                    apptmtID5of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of34.setVisible(true);
                    time6of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of34.setVisible(true);
                    apptmtID6of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl35.setText("31");
            int day31 = parseInt(Lbl35.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of35.setVisible(true);
                    time1of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of35.setVisible(true);
                    apptmtID1of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of35.setVisible(true);
                    time2of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of35.setVisible(true);
                    apptmtID2of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of35.setVisible(true);
                    time3of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of35.setVisible(true);
                    apptmtID3of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of35.setVisible(true);
                    time4of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of35.setVisible(true);
                    apptmtID4of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of35.setVisible(true);
                    time5of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of35.setVisible(true);
                    apptmtID5of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of35.setVisible(true);
                    time6of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of35.setVisible(true);
                    apptmtID6of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public void fridayStartMonth(int month, int year) throws SQLException {
        Lbl1.setText("");
        Lbl2.setText("");
        Lbl3.setText("");
        Lbl4.setText("");
        Lbl5.setText("");
        Lbl6.setText("1");
        Lbl7.setText("2");
        Lbl8.setText("3");
        Lbl9.setText("4");
        Lbl10.setText("5");
        Lbl11.setText("6");
        Lbl12.setText("7");
        Lbl13.setText("8");
        Lbl14.setText("9");
        Lbl15.setText("10");
        Lbl16.setText("11");
        Lbl17.setText("12");
        Lbl18.setText("13");
        Lbl19.setText("14");
        Lbl20.setText("15");
        Lbl21.setText("16");
        Lbl22.setText("17");
        Lbl23.setText("18");
        Lbl24.setText("19");
        Lbl25.setText("20");
        Lbl26.setText("21");
        Lbl27.setText("22");
        Lbl28.setText("23");
        Lbl29.setText("24");
        Lbl30.setText("25");
        Lbl31.setText("26");
        Lbl32.setText("27");
        Lbl33.setText("28");
        Lbl34.setText("");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl6.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of6.setVisible(true);
                time1of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of6.setVisible(true);
                apptmtID1of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of6.setVisible(true);
                time2of6.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of6.setVisible(true);
                apptmtID2of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of6.setVisible(true);
                time3of6.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID3of6.setVisible(true);
                apptmtID3of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of6.setVisible(true);
                time4of6.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID4of6.setVisible(true);
                apptmtID4of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of6.setVisible(true);
                time5of6.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID5of6.setVisible(true);
                apptmtID5of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of6.setVisible(true);
                time6of6.setText((Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(index).getStartTime()) + " - " + (Calendar.getCalendarInfoByDate(String.valueOf(User.getUserId()), date).get(0).getEndTime()));
                apptmtID6of6.setVisible(true);
                apptmtID6of6.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl7.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID4of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID4of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

            int day4 = parseInt(Lbl9.getText());
            date = LocalDate.of(year, month, day4);
            times = LocalTime.of(0, 0);
            LocalDateTime dt4 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt4)) {
                setDailyApptmts(dt4);
                if (numOfApptmts(dt4) >= 1) {
                    int index = 0;
                    time1of9.setVisible(true);
                    time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of9.setVisible(true);
                    apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt4) >= 2) {
                    int index = 1;
                    time2of9.setVisible(true);
                    time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of9.setVisible(true);
                    apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt4) >= 3) {
                    int index = 2;
                    time3of9.setVisible(true);
                    time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of9.setVisible(true);
                    apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt4) >= 4) {
                    int index = 3;
                    time4of9.setVisible(true);
                    time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of9.setVisible(true);
                    apptmtID4of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt4) >= 5) {
                    int index = 4;
                    time5of9.setVisible(true);
                    time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of9.setVisible(true);
                    apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt4) >= 6) {
                    int index = 5;
                    time6of9.setVisible(true);
                    time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of9.setVisible(true);
                    apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day5 = parseInt(Lbl10.getText());
            date = LocalDate.of(year, month, day5);
            times = LocalTime.of(0, 0);
            LocalDateTime dt5 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt5)) {
                setDailyApptmts(dt5);
                if (numOfApptmts(dt5) >= 1) {
                    int index = 0;
                    time1of10.setVisible(true);
                    time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of10.setVisible(true);
                    apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt5) >= 2) {
                    int index = 1;
                    time2of10.setVisible(true);
                    time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of10.setVisible(true);
                    apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt5) >= 3) {
                    int index = 2;
                    time3of10.setVisible(true);
                    time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of10.setVisible(true);
                    apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt5) >= 4) {
                    int index = 3;
                    time4of10.setVisible(true);
                    time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of10.setVisible(true);
                    apptmtID4of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt5) >= 5) {
                    int index = 4;
                    time5of10.setVisible(true);
                    time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of10.setVisible(true);
                    apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt5) >= 6) {
                    int index = 5;
                    time6of10.setVisible(true);
                    time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of10.setVisible(true);
                    apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day6 = parseInt(Lbl11.getText());
            date = LocalDate.of(year, month, day6);
            times = LocalTime.of(0, 0);
            LocalDateTime dt6 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt6)) {
                setDailyApptmts(dt6);
                if (numOfApptmts(dt6) >= 1) {
                    int index = 0;
                    time1of11.setVisible(true);
                    time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of11.setVisible(true);
                    apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt6) >= 2) {
                    int index = 1;
                    time2of10.setVisible(true);
                    time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of11.setVisible(true);
                    apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt6) >= 3) {
                    int index = 2;
                    time3of11.setVisible(true);
                    time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of11.setVisible(true);
                    apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt6) >= 4) {
                    int index = 3;
                    time4of11.setVisible(true);
                    time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of11.setVisible(true);
                    apptmtID4of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt6) >= 5) {
                    int index = 4;
                    time5of11.setVisible(true);
                    time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of11.setVisible(true);
                    apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt6) >= 6) {
                    int index = 5;
                    time6of11.setVisible(true);
                    time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of11.setVisible(true);
                    apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day7 = parseInt(Lbl12.getText());
            date = LocalDate.of(year, month, day7);
            times = LocalTime.of(0, 0);
            LocalDateTime dt7 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt7)) {
                setDailyApptmts(dt7);
                if (numOfApptmts(dt7) >= 1) {
                    int index = 0;
                    time1of12.setVisible(true);
                    time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of12.setVisible(true);
                    apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt7) >= 2) {
                    int index = 1;
                    time2of12.setVisible(true);
                    time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of12.setVisible(true);
                    apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt7) >= 3) {
                    int index = 2;
                    time3of12.setVisible(true);
                    time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of12.setVisible(true);
                    apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt7) >= 4) {
                    int index = 3;
                    time4of12.setVisible(true);
                    time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of12.setVisible(true);
                    apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt7) >= 5) {
                    int index = 4;
                    time5of12.setVisible(true);
                    time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of12.setVisible(true);
                    apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt7) >= 6) {
                    int index = 5;
                    time6of12.setVisible(true);
                    time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of12.setVisible(true);
                    apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day8 = parseInt(Lbl13.getText());
            date = LocalDate.of(year, month, day8);
            times = LocalTime.of(0, 0);
            LocalDateTime dt8 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt8)) {
                setDailyApptmts(dt8);
                if (numOfApptmts(dt8) >= 1) {
                    int index = 0;
                    time1of13.setVisible(true);
                    time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of13.setVisible(true);
                    apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt8) >= 2) {
                    int index = 1;
                    time2of13.setVisible(true);
                    time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of13.setVisible(true);
                    apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt8) >= 3) {
                    int index = 2;
                    time3of13.setVisible(true);
                    time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of13.setVisible(true);
                    apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt8) >= 4) {
                    int index = 3;
                    time4of13.setVisible(true);
                    time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of13.setVisible(true);
                    apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt8) >= 5) {
                    int index = 4;
                    time5of13.setVisible(true);
                    time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of13.setVisible(true);
                    apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt8) >= 6) {
                    int index = 5;
                    time6of13.setVisible(true);
                    time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of13.setVisible(true);
                    apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day9 = parseInt(Lbl14.getText());
            date = LocalDate.of(year, month, day9);
            times = LocalTime.of(0, 0);
            LocalDateTime dt9 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt9)) {
                setDailyApptmts(dt9);
                if (numOfApptmts(dt9) >= 1) {
                    int index = 0;
                    time1of14.setVisible(true);
                    time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of14.setVisible(true);
                    apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt9) >= 2) {
                    int index = 1;
                    time2of14.setVisible(true);
                    time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of14.setVisible(true);
                    apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt9) >= 3) {
                    int index = 2;
                    time3of14.setVisible(true);
                    time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of14.setVisible(true);
                    apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt9) >= 4) {
                    int index = 3;
                    time4of14.setVisible(true);
                    time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of14.setVisible(true);
                    apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt9) >= 5) {
                    int index = 4;
                    time5of14.setVisible(true);
                    time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of14.setVisible(true);
                    apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt9) >= 6) {
                    int index = 5;
                    time6of14.setVisible(true);
                    time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of14.setVisible(true);
                    apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day10 = parseInt(Lbl15.getText());
            date = LocalDate.of(year, month, day10);
            times = LocalTime.of(0, 0);
            LocalDateTime dt10 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt10)) {
                setDailyApptmts(dt10);
                if (numOfApptmts(dt10) >= 1) {
                    int index = 0;
                    time1of15.setVisible(true);
                    time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of15.setVisible(true);
                    apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt10) >= 2) {
                    int index = 1;
                    time2of15.setVisible(true);
                    time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of15.setVisible(true);
                    apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt10) >= 3) {
                    int index = 2;
                    time3of15.setVisible(true);
                    time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of15.setVisible(true);
                    apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt10) >= 4) {
                    int index = 3;
                    time4of15.setVisible(true);
                    time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of15.setVisible(true);
                    apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt10) >= 5) {
                    int index = 4;
                    time5of15.setVisible(true);
                    time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of15.setVisible(true);
                    apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt10) >= 6) {
                    int index = 5;
                    time6of15.setVisible(true);
                    time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of15.setVisible(true);
                    apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day11 = parseInt(Lbl16.getText());
            date = LocalDate.of(year, month, day11);
            times = LocalTime.of(0, 0);
            LocalDateTime dt11 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt11)) {
                setDailyApptmts(dt11);
                if (numOfApptmts(dt11) >= 1) {
                    int index = 0;
                    time1of16.setVisible(true);
                    time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of16.setVisible(true);
                    apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt11) >= 2) {
                    int index = 1;
                    time2of16.setVisible(true);
                    time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of16.setVisible(true);
                    apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt11) >= 3) {
                    int index = 2;
                    time3of16.setVisible(true);
                    time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of16.setVisible(true);
                    apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt11) >= 4) {
                    int index = 3;
                    time4of16.setVisible(true);
                    time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of16.setVisible(true);
                    apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt11) >= 5) {
                    int index = 4;
                    time5of16.setVisible(true);
                    time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of16.setVisible(true);
                    apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt11) >= 6) {
                    int index = 5;
                    time6of16.setVisible(true);
                    time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of16.setVisible(true);
                    apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day12 = parseInt(Lbl17.getText());
            date = LocalDate.of(year, month, day12);
            times = LocalTime.of(0, 0);
            LocalDateTime dt12 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt12)) {
                setDailyApptmts(dt12);
                if (numOfApptmts(dt12) >= 1) {
                    int index = 0;
                    time1of17.setVisible(true);
                    time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of17.setVisible(true);
                    apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt12) >= 2) {
                    int index = 1;
                    time2of17.setVisible(true);
                    time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of17.setVisible(true);
                    apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt12) >= 3) {
                    int index = 2;
                    time3of17.setVisible(true);
                    time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of17.setVisible(true);
                    apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt12) >= 4) {
                    int index = 3;
                    time4of17.setVisible(true);
                    time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of17.setVisible(true);
                    apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt12) >= 5) {
                    int index = 4;
                    time5of17.setVisible(true);
                    time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of17.setVisible(true);
                    apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt12) >= 6) {
                    int index = 5;
                    time6of17.setVisible(true);
                    time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of17.setVisible(true);
                    apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day13 = parseInt(Lbl18.getText());
            date = LocalDate.of(year, month, day13);
            times = LocalTime.of(0, 0);
            LocalDateTime dt13 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt13)) {
                setDailyApptmts(dt13);
                if (numOfApptmts(dt13) >= 1) {
                    int index = 0;
                    time1of18.setVisible(true);
                    time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of18.setVisible(true);
                    apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt13) >= 2) {
                    int index = 1;
                    time2of18.setVisible(true);
                    time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of18.setVisible(true);
                    apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt13) >= 3) {
                    int index = 2;
                    time3of18.setVisible(true);
                    time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of18.setVisible(true);
                    apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt13) >= 4) {
                    int index = 3;
                    time4of18.setVisible(true);
                    time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of18.setVisible(true);
                    apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt13) >= 5) {
                    int index = 4;
                    time5of18.setVisible(true);
                    time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of18.setVisible(true);
                    apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt13) >= 6) {
                    int index = 5;
                    time6of18.setVisible(true);
                    time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of18.setVisible(true);
                    apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day14 = parseInt(Lbl19.getText());
            date = LocalDate.of(year, month, day14);
            times = LocalTime.of(0, 0);
            LocalDateTime dt14 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt14)) {
                setDailyApptmts(dt14);
                if (numOfApptmts(dt14) >= 1) {
                    int index = 0;
                    time1of19.setVisible(true);
                    time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of19.setVisible(true);
                    apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt14) >= 2) {
                    int index = 1;
                    time2of19.setVisible(true);
                    time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of19.setVisible(true);
                    apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt14) >= 3) {
                    int index = 2;
                    time3of19.setVisible(true);
                    time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of19.setVisible(true);
                    apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt14) >= 4) {
                    int index = 3;
                    time4of19.setVisible(true);
                    time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of19.setVisible(true);
                    apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt14) >= 5) {
                    int index = 4;
                    time5of19.setVisible(true);
                    time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of19.setVisible(true);
                    apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt14) >= 6) {
                    int index = 5;
                    time6of19.setVisible(true);
                    time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of19.setVisible(true);
                    apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day15 = parseInt(Lbl20.getText());
            date = LocalDate.of(year, month, day15);
            times = LocalTime.of(0, 0);
            LocalDateTime dt15 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt15)) {
                setDailyApptmts(dt15);
                if (numOfApptmts(dt15) >= 1) {
                    int index = 0;
                    time1of20.setVisible(true);
                    time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of20.setVisible(true);
                    apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt15) >= 2) {
                    int index = 1;
                    time2of20.setVisible(true);
                    time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of20.setVisible(true);
                    apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt15) >= 3) {
                    int index = 2;
                    time3of20.setVisible(true);
                    time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of20.setVisible(true);
                    apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt15) >= 4) {
                    int index = 3;
                    time4of20.setVisible(true);
                    time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of20.setVisible(true);
                    apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt15) >= 5) {
                    int index = 4;
                    time5of20.setVisible(true);
                    time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of20.setVisible(true);
                    apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt15) >= 6) {
                    int index = 5;
                    time6of20.setVisible(true);
                    time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of20.setVisible(true);
                    apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day16 = parseInt(Lbl21.getText());
            date = LocalDate.of(year, month, day16);
            times = LocalTime.of(0, 0);
            LocalDateTime dt16 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt16)) {
                setDailyApptmts(dt16);
                if (numOfApptmts(dt16) >= 1) {
                    int index = 0;
                    time1of21.setVisible(true);
                    time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of21.setVisible(true);
                    apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt16) >= 2) {
                    int index = 1;
                    time2of21.setVisible(true);
                    time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of21.setVisible(true);
                    apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt16) >= 3) {
                    int index = 2;
                    time3of21.setVisible(true);
                    time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of21.setVisible(true);
                    apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt16) >= 4) {
                    int index = 3;
                    time4of21.setVisible(true);
                    time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of21.setVisible(true);
                    apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt16) >= 5) {
                    int index = 4;
                    time5of21.setVisible(true);
                    time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of21.setVisible(true);
                    apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt16) >= 6) {
                    int index = 5;
                    time6of21.setVisible(true);
                    time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of21.setVisible(true);
                    apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day17 = parseInt(Lbl22.getText());
            date = LocalDate.of(year, month, day17);
            times = LocalTime.of(0, 0);
            LocalDateTime dt17 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt17)) {
                setDailyApptmts(dt17);
                if (numOfApptmts(dt17) >= 1) {
                    int index = 0;
                    time1of22.setVisible(true);
                    time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of22.setVisible(true);
                    apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt17) >= 2) {
                    int index = 1;
                    time2of22.setVisible(true);
                    time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of22.setVisible(true);
                    apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt17) >= 3) {
                    int index = 2;
                    time3of22.setVisible(true);
                    time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of22.setVisible(true);
                    apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt17) >= 4) {
                    int index = 3;
                    time4of22.setVisible(true);
                    time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of22.setVisible(true);
                    apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt17) >= 5) {
                    int index = 4;
                    time5of22.setVisible(true);
                    time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of22.setVisible(true);
                    apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt17) >= 6) {
                    int index = 5;
                    time6of22.setVisible(true);
                    time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of22.setVisible(true);
                    apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day18 = parseInt(Lbl23.getText());
            date = LocalDate.of(year, month, day18);
            times = LocalTime.of(0, 0);
            LocalDateTime dt18 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt18)) {
                setDailyApptmts(dt18);
                if (numOfApptmts(dt18) >= 1) {
                    int index = 0;
                    time1of23.setVisible(true);
                    time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of23.setVisible(true);
                    apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt18) >= 2) {
                    int index = 1;
                    time2of23.setVisible(true);
                    time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of23.setVisible(true);
                    apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt18) >= 3) {
                    int index = 2;
                    time3of23.setVisible(true);
                    time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of23.setVisible(true);
                    apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt18) >= 4) {
                    int index = 3;
                    time4of23.setVisible(true);
                    time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of23.setVisible(true);
                    apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt18) >= 5) {
                    int index = 4;
                    time5of23.setVisible(true);
                    time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of23.setVisible(true);
                    apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt18) >= 6) {
                    int index = 5;
                    time6of23.setVisible(true);
                    time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of23.setVisible(true);
                    apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day19 = parseInt(Lbl24.getText());
            date = LocalDate.of(year, month, day19);
            times = LocalTime.of(0, 0);
            LocalDateTime dt19 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt19)) {
                setDailyApptmts(dt19);
                if (numOfApptmts(dt19) >= 1) {
                    int index = 0;
                    time1of24.setVisible(true);
                    time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of24.setVisible(true);
                    apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt19) >= 2) {
                    int index = 1;
                    time2of24.setVisible(true);
                    time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of24.setVisible(true);
                    apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt19) >= 3) {
                    int index = 2;
                    time3of24.setVisible(true);
                    time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of24.setVisible(true);
                    apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt19) >= 4) {
                    int index = 3;
                    time4of24.setVisible(true);
                    time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of24.setVisible(true);
                    apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt19) >= 5) {
                    int index = 4;
                    time5of24.setVisible(true);
                    time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of24.setVisible(true);
                    apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt19) >= 6) {
                    int index = 5;
                    time6of24.setVisible(true);
                    time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of24.setVisible(true);
                    apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day20 = parseInt(Lbl25.getText());
            date = LocalDate.of(year, month, day20);
            times = LocalTime.of(0, 0);
            LocalDateTime dt20 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt20)) {
                setDailyApptmts(dt20);
                if (numOfApptmts(dt20) >= 1) {
                    int index = 0;
                    time1of25.setVisible(true);
                    time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of25.setVisible(true);
                    apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt20) >= 2) {
                    int index = 1;
                    time2of25.setVisible(true);
                    time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of25.setVisible(true);
                    apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt20) >= 3) {
                    int index = 2;
                    time3of25.setVisible(true);
                    time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of25.setVisible(true);
                    apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt20) >= 4) {
                    int index = 3;
                    time4of25.setVisible(true);
                    time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of25.setVisible(true);
                    apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt20) >= 5) {
                    int index = 4;
                    time5of25.setVisible(true);
                    time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of25.setVisible(true);
                    apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt20) >= 6) {
                    int index = 5;
                    time6of25.setVisible(true);
                    time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of25.setVisible(true);
                    apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day21 = parseInt(Lbl26.getText());
            date = LocalDate.of(year, month, day21);
            times = LocalTime.of(0, 0);
            LocalDateTime dt21 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt21)) {
                setDailyApptmts(dt21);
                if (numOfApptmts(dt21) >= 1) {
                    int index = 0;
                    time1of26.setVisible(true);
                    time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of26.setVisible(true);
                    apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt21) >= 2) {
                    int index = 1;
                    time2of26.setVisible(true);
                    time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of26.setVisible(true);
                    apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt21) >= 3) {
                    int index = 2;
                    time3of26.setVisible(true);
                    time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of26.setVisible(true);
                    apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt21) >= 4) {
                    int index = 3;
                    time4of26.setVisible(true);
                    time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of26.setVisible(true);
                    apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt21) >= 5) {
                    int index = 4;
                    time5of26.setVisible(true);
                    time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of26.setVisible(true);
                    apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt21) >= 6) {
                    int index = 5;
                    time6of26.setVisible(true);
                    time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of26.setVisible(true);
                    apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day22 = parseInt(Lbl27.getText());
            date = LocalDate.of(year, month, day22);
            times = LocalTime.of(0, 0);
            LocalDateTime dt22 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt22)) {
                setDailyApptmts(dt22);
                if (numOfApptmts(dt22) >= 1) {
                    int index = 0;
                    time1of27.setVisible(true);
                    time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of27.setVisible(true);
                    apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt22) >= 2) {
                    int index = 1;
                    time2of27.setVisible(true);
                    time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of27.setVisible(true);
                    apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt22) >= 3) {
                    int index = 2;
                    time3of27.setVisible(true);
                    time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of27.setVisible(true);
                    apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt22) >= 4) {
                    int index = 3;
                    time4of27.setVisible(true);
                    time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of27.setVisible(true);
                    apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt22) >= 5) {
                    int index = 4;
                    time5of27.setVisible(true);
                    time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of27.setVisible(true);
                    apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt22) >= 6) {
                    int index = 5;
                    time6of27.setVisible(true);
                    time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of27.setVisible(true);
                    apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day23 = parseInt(Lbl28.getText());
            date = LocalDate.of(year, month, day23);
            times = LocalTime.of(0, 0);
            LocalDateTime dt23 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt23)) {
                setDailyApptmts(dt23);
                if (numOfApptmts(dt23) >= 1) {
                    int index = 0;
                    time1of28.setVisible(true);
                    time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of28.setVisible(true);
                    apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt23) >= 2) {
                    int index = 1;
                    time2of28.setVisible(true);
                    time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of28.setVisible(true);
                    apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt23) >= 3) {
                    int index = 2;
                    time3of28.setVisible(true);
                    time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of28.setVisible(true);
                    apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt23) >= 4) {
                    int index = 3;
                    time4of28.setVisible(true);
                    time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of28.setVisible(true);
                    apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt23) >= 5) {
                    int index = 4;
                    time5of28.setVisible(true);
                    time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of28.setVisible(true);
                    apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt23) >= 6) {
                    int index = 5;
                    time6of28.setVisible(true);
                    time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of28.setVisible(true);
                    apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day24 = parseInt(Lbl29.getText());
            date = LocalDate.of(year, month, day24);
            times = LocalTime.of(0, 0);
            LocalDateTime dt24 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt24)) {
                setDailyApptmts(dt24);
                if (numOfApptmts(dt24) >= 1) {
                    int index = 0;
                    time1of29.setVisible(true);
                    time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of29.setVisible(true);
                    apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt24) >= 2) {
                    int index = 1;
                    time2of29.setVisible(true);
                    time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of29.setVisible(true);
                    apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt24) >= 3) {
                    int index = 2;
                    time3of29.setVisible(true);
                    time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of29.setVisible(true);
                    apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt24) >= 4) {
                    int index = 3;
                    time4of29.setVisible(true);
                    time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of29.setVisible(true);
                    apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt24) >= 5) {
                    int index = 4;
                    time5of29.setVisible(true);
                    time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of29.setVisible(true);
                    apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt24) >= 6) {
                    int index = 5;
                    time6of29.setVisible(true);
                    time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of29.setVisible(true);
                    apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day25 = parseInt(Lbl30.getText());
            date = LocalDate.of(year, month, day25);
            times = LocalTime.of(0, 0);
            LocalDateTime dt25 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt25)) {
                setDailyApptmts(dt25);
                if (numOfApptmts(dt25) >= 1) {
                    int index = 0;
                    time1of30.setVisible(true);
                    time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of30.setVisible(true);
                    apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt25) >= 2) {
                    int index = 1;
                    time2of30.setVisible(true);
                    time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of30.setVisible(true);
                    apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt25) >= 3) {
                    int index = 2;
                    time3of30.setVisible(true);
                    time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of30.setVisible(true);
                    apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt25) >= 4) {
                    int index = 3;
                    time4of30.setVisible(true);
                    time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of30.setVisible(true);
                    apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt25) >= 5) {
                    int index = 4;
                    time5of30.setVisible(true);
                    time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of30.setVisible(true);
                    apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt25) >= 6) {
                    int index = 5;
                    time6of30.setVisible(true);
                    time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of30.setVisible(true);
                    apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day26 = parseInt(Lbl31.getText());
            date = LocalDate.of(year, month, day26);
            times = LocalTime.of(0, 0);
            LocalDateTime dt26 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt26)) {
                setDailyApptmts(dt26);
                if (numOfApptmts(dt26) >= 1) {
                    int index = 0;
                    time1of31.setVisible(true);
                    time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of31.setVisible(true);
                    apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt26) >= 2) {
                    int index = 1;
                    time2of31.setVisible(true);
                    time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of31.setVisible(true);
                    apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt26) >= 3) {
                    int index = 2;
                    time3of31.setVisible(true);
                    time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of31.setVisible(true);
                    apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt26) >= 4) {
                    int index = 3;
                    time4of31.setVisible(true);
                    time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of31.setVisible(true);
                    apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt26) >= 5) {
                    int index = 4;
                    time5of31.setVisible(true);
                    time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of31.setVisible(true);
                    apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt26) >= 6) {
                    int index = 5;
                    time6of31.setVisible(true);
                    time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of31.setVisible(true);
                    apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day27 = parseInt(Lbl32.getText());
            date = LocalDate.of(year, month, day27);
            times = LocalTime.of(0, 0);
            LocalDateTime dt27 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt27)) {
                setDailyApptmts(dt27);
                if (numOfApptmts(dt27) >= 1) {
                    int index = 0;
                    time1of32.setVisible(true);
                    time1of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of32.setVisible(true);
                    apptmtID1of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt27) >= 2) {
                    int index = 1;
                    time2of32.setVisible(true);
                    time2of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of32.setVisible(true);
                    apptmtID2of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt27) >= 3) {
                    int index = 2;
                    time3of32.setVisible(true);
                    time3of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of32.setVisible(true);
                    apptmtID3of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt27) >= 4) {
                    int index = 3;
                    time4of32.setVisible(true);
                    time4of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of32.setVisible(true);
                    apptmtID4of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt27) >= 5) {
                    int index = 4;
                    time5of32.setVisible(true);
                    time5of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of32.setVisible(true);
                    apptmtID5of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt27) >= 6) {
                    int index = 5;
                    time6of32.setVisible(true);
                    time6of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of32.setVisible(true);
                    apptmtID6of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            int day28 = parseInt(Lbl33.getText());
            date = LocalDate.of(year, month, day28);
            times = LocalTime.of(0, 0);
            LocalDateTime dt28 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt28)) {
                setDailyApptmts(dt28);
                if (numOfApptmts(dt28) >= 1) {
                    int index = 0;
                    time1of33.setVisible(true);
                    time1of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of33.setVisible(true);
                    apptmtID1of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt28) >= 2) {
                    int index = 1;
                    time2of33.setVisible(true);
                    time2of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of33.setVisible(true);
                    apptmtID2of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt28) >= 3) {
                    int index = 2;
                    time3of33.setVisible(true);
                    time3of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of33.setVisible(true);
                    apptmtID3of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt28) >= 4) {
                    int index = 3;
                    time4of33.setVisible(true);
                    time4of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of33.setVisible(true);
                    apptmtID4of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt28) >= 5) {
                    int index = 4;
                    time5of33.setVisible(true);
                    time5of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of33.setVisible(true);
                    apptmtID5of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt28) >= 6) {
                    int index = 5;
                    time6of33.setVisible(true);
                    time6of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of33.setVisible(true);
                    apptmtID6of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }

            if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
                Lbl34.setText("29");
                int day29 = parseInt(Lbl34.getText());
                date = LocalDate.of(year, month, day29);
                times = LocalTime.of(0, 0);
                LocalDateTime dt29 = LocalDateTime.of(date, times);
                if (validateApptmtDay(dt29)) {
                    setDailyApptmts(dt29);
                    if (numOfApptmts(dt29) >= 1) {
                        int index = 0;
                        time1of34.setVisible(true);
                        time1of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                        apptmtID1of34.setVisible(true);
                        apptmtID1of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                    }
                    if (numOfApptmts(dt29) >= 2) {
                        int index = 1;
                        time2of34.setVisible(true);
                        time2of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                        apptmtID2of34.setVisible(true);
                        apptmtID2of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                    }
                    if (numOfApptmts(dt29) >= 3) {
                        int index = 2;
                        time3of34.setVisible(true);
                        time3of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                        apptmtID3of34.setVisible(true);
                        apptmtID3of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                    }
                    if (numOfApptmts(dt29) >= 4) {
                        int index = 3;
                        time4of34.setVisible(true);
                        time4of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                        apptmtID4of34.setVisible(true);
                        apptmtID4of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                    }
                    if (numOfApptmts(dt29) >= 5) {
                        int index = 4;
                        time5of34.setVisible(true);
                        time5of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                        apptmtID5of34.setVisible(true);
                        apptmtID5of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                    }
                    if (numOfApptmts(dt29) >= 6) {
                        int index = 5;
                        time6of34.setVisible(true);
                        time6of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                        apptmtID6of34.setVisible(true);
                        apptmtID6of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                    }
                }
            }


        if (month != 2) {
            Lbl35.setText("30");
            int day30 = parseInt(Lbl35.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of35.setVisible(true);
                    time1of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of35.setVisible(true);
                    apptmtID1of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of35.setVisible(true);
                    time2of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of35.setVisible(true);
                    apptmtID2of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of35.setVisible(true);
                    time3of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of35.setVisible(true);
                    apptmtID3of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of35.setVisible(true);
                    time4of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of35.setVisible(true);
                    apptmtID4of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of35.setVisible(true);
                    time5of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of35.setVisible(true);
                    apptmtID5of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of35.setVisible(true);
                    time6of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of35.setVisible(true);
                    apptmtID6of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl36.setText("31");
            int day31 = parseInt(Lbl36.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of36.setVisible(true);
                    time1of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of36.setVisible(true);
                    apptmtID1of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of36.setVisible(true);
                    time2of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of36.setVisible(true);
                    apptmtID2of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of36.setVisible(true);
                    time3of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of36.setVisible(true);
                    apptmtID3of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of36.setVisible(true);
                    time4of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of36.setVisible(true);
                    apptmtID4of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of36.setVisible(true);
                    time5of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of36.setVisible(true);
                    apptmtID5of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of36.setVisible(true);
                    time6of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of36.setVisible(true);
                    apptmtID6of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public void saturdayStartMonth(int month, int year) throws SQLException {
        Lbl1.setText("");
        Lbl2.setText("");
        Lbl3.setText("");
        Lbl4.setText("");
        Lbl5.setText("");
        Lbl6.setText("");
        Lbl7.setText("1");
        Lbl8.setText("2");
        Lbl9.setText("3");
        Lbl10.setText("4");
        Lbl11.setText("5");
        Lbl12.setText("6");
        Lbl13.setText("7");
        Lbl14.setText("8");
        Lbl15.setText("9");
        Lbl16.setText("10");
        Lbl17.setText("11");
        Lbl18.setText("12");
        Lbl19.setText("13");
        Lbl20.setText("14");
        Lbl21.setText("15");
        Lbl22.setText("16");
        Lbl23.setText("17");
        Lbl24.setText("18");
        Lbl25.setText("19");
        Lbl26.setText("20");
        Lbl27.setText("21");
        Lbl28.setText("22");
        Lbl29.setText("23");
        Lbl30.setText("24");
        Lbl31.setText("25");
        Lbl32.setText("26");
        Lbl33.setText("27");
        Lbl34.setText("28");
        Lbl35.setText("");
        Lbl36.setText("");
        Lbl37.setText("");
        Lbl38.setText("");
        Lbl39.setText("");
        Lbl40.setText("");
        Lbl41.setText("");
        Lbl42.setText("");

        int day = parseInt(Lbl7.getText());
        LocalDate date = LocalDate.of(year, month, day);
        LocalTime times = LocalTime.of(0, 0);
        LocalDateTime dt1 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt1)) {
            setDailyApptmts(dt1);
            if (numOfApptmts(dt1) >= 1) {
                int index = 0;
                time1of7.setVisible(true);
                time1of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of7.setVisible(true);
                apptmtID1of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 2) {
                int index = 1;
                time2of7.setVisible(true);
                time2of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of7.setVisible(true);
                apptmtID2of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 3) {
                int index = 2;
                time3of7.setVisible(true);
                time3of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of7.setVisible(true);
                apptmtID3of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 4) {
                int index = 3;
                time4of7.setVisible(true);
                time4of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of7.setVisible(true);
                apptmtID4of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 5) {
                int index = 4;
                time5of7.setVisible(true);
                time5of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of7.setVisible(true);
                apptmtID5of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt1) >= 6) {
                int index = 5;
                time6of7.setVisible(true);
                time6of7.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of7.setVisible(true);
                apptmtID6of7.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day2 = parseInt(Lbl8.getText());
        date = LocalDate.of(year, month, day2);
        times = LocalTime.of(0, 0);
        LocalDateTime dt2 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt2)) {
            setDailyApptmts(dt2);
            if (numOfApptmts(dt2) >= 1) {
                int index = 0;
                time1of8.setVisible(true);
                time1of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of8.setVisible(true);
                apptmtID1of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 2) {
                int index = 1;
                time2of8.setVisible(true);
                time2of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of8.setVisible(true);
                apptmtID2of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 3) {
                int index = 2;
                time3of8.setVisible(true);
                time3of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of8.setVisible(true);
                apptmtID3of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 4) {
                int index = 3;
                time4of8.setVisible(true);
                time4of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of8.setVisible(true);
                apptmtID4of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 5) {
                int index = 4;
                time5of8.setVisible(true);
                time5of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of8.setVisible(true);
                apptmtID5of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt2) >= 6) {
                int index = 5;
                time6of8.setVisible(true);
                time6of8.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of8.setVisible(true);
                apptmtID6of8.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day3 = parseInt(Lbl9.getText());
        date = LocalDate.of(year, month, day3);
        times = LocalTime.of(0, 0);
        LocalDateTime dt3 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt3)) {
            setDailyApptmts(dt3);
            if (numOfApptmts(dt3) >= 1) {
                int index = 0;
                time1of9.setVisible(true);
                time1of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of9.setVisible(true);
                apptmtID1of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 2) {
                int index = 1;
                time2of9.setVisible(true);
                time2of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of9.setVisible(true);
                apptmtID2of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 3) {
                int index = 2;
                time3of9.setVisible(true);
                time3of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of9.setVisible(true);
                apptmtID3of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 4) {
                int index = 3;
                time4of9.setVisible(true);
                time4of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of9.setVisible(true);
                apptmtID4of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 5) {
                int index = 4;
                time5of9.setVisible(true);
                time5of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of9.setVisible(true);
                apptmtID5of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt3) >= 6) {
                int index = 5;
                time6of9.setVisible(true);
                time6of9.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of9.setVisible(true);
                apptmtID6of9.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day4 = parseInt(Lbl10.getText());
        date = LocalDate.of(year, month, day4);
        times = LocalTime.of(0, 0);
        LocalDateTime dt4 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt4)) {
            setDailyApptmts(dt4);
            if (numOfApptmts(dt4) >= 1) {
                int index = 0;
                time1of10.setVisible(true);
                time1of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of10.setVisible(true);
                apptmtID1of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of10.setVisible(true);
                apptmtID2of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 3) {
                int index = 2;
                time3of10.setVisible(true);
                time3of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of10.setVisible(true);
                apptmtID3of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 4) {
                int index = 3;
                time4of10.setVisible(true);
                time4of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of10.setVisible(true);
                apptmtID4of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 5) {
                int index = 4;
                time5of10.setVisible(true);
                time5of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of10.setVisible(true);
                apptmtID5of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt4) >= 6) {
                int index = 5;
                time6of10.setVisible(true);
                time6of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of10.setVisible(true);
                apptmtID6of10.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day5 = parseInt(Lbl11.getText());
        date = LocalDate.of(year, month, day5);
        times = LocalTime.of(0, 0);
        LocalDateTime dt5 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt5)) {
            setDailyApptmts(dt5);
            if (numOfApptmts(dt5) >= 1) {
                int index = 0;
                time1of11.setVisible(true);
                time1of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of11.setVisible(true);
                apptmtID1of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 2) {
                int index = 1;
                time2of10.setVisible(true);
                time2of10.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of11.setVisible(true);
                apptmtID2of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 3) {
                int index = 2;
                time3of11.setVisible(true);
                time3of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of11.setVisible(true);
                apptmtID3of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 4) {
                int index = 3;
                time4of11.setVisible(true);
                time4of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of11.setVisible(true);
                apptmtID4of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 5) {
                int index = 4;
                time5of11.setVisible(true);
                time5of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of11.setVisible(true);
                apptmtID5of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt5) >= 6) {
                int index = 5;
                time6of11.setVisible(true);
                time6of11.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of11.setVisible(true);
                apptmtID6of11.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day6 = parseInt(Lbl12.getText());
        date = LocalDate.of(year, month, day6);
        times = LocalTime.of(0, 0);
        LocalDateTime dt6 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt6)) {
            setDailyApptmts(dt6);
            if (numOfApptmts(dt6) >= 1) {
                int index = 0;
                time1of12.setVisible(true);
                time1of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of12.setVisible(true);
                apptmtID1of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 2) {
                int index = 1;
                time2of12.setVisible(true);
                time2of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of12.setVisible(true);
                apptmtID2of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 3) {
                int index = 2;
                time3of12.setVisible(true);
                time3of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of12.setVisible(true);
                apptmtID3of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 4) {
                int index = 3;
                time4of12.setVisible(true);
                time4of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of12.setVisible(true);
                apptmtID4of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 5) {
                int index = 4;
                time5of12.setVisible(true);
                time5of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of12.setVisible(true);
                apptmtID5of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt6) >= 6) {
                int index = 5;
                time6of12.setVisible(true);
                time6of12.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of12.setVisible(true);
                apptmtID6of12.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day7 = parseInt(Lbl13.getText());
        date = LocalDate.of(year, month, day7);
        times = LocalTime.of(0, 0);
        LocalDateTime dt7 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt7)) {
            setDailyApptmts(dt7);
            if (numOfApptmts(dt7) >= 1) {
                int index = 0;
                time1of13.setVisible(true);
                time1of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of13.setVisible(true);
                apptmtID1of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 2) {
                int index = 1;
                time2of13.setVisible(true);
                time2of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of13.setVisible(true);
                apptmtID2of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 3) {
                int index = 2;
                time3of13.setVisible(true);
                time3of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of13.setVisible(true);
                apptmtID3of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 4) {
                int index = 3;
                time4of13.setVisible(true);
                time4of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of13.setVisible(true);
                apptmtID4of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 5) {
                int index = 4;
                time5of13.setVisible(true);
                time5of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of13.setVisible(true);
                apptmtID5of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt7) >= 6) {
                int index = 5;
                time6of13.setVisible(true);
                time6of13.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of13.setVisible(true);
                apptmtID6of13.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day8 = parseInt(Lbl14.getText());
        date = LocalDate.of(year, month, day8);
        times = LocalTime.of(0, 0);
        LocalDateTime dt8 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt8)) {
            setDailyApptmts(dt8);
            if (numOfApptmts(dt8) >= 1) {
                int index = 0;
                time1of14.setVisible(true);
                time1of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of14.setVisible(true);
                apptmtID1of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 2) {
                int index = 1;
                time2of14.setVisible(true);
                time2of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of14.setVisible(true);
                apptmtID2of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 3) {
                int index = 2;
                time3of14.setVisible(true);
                time3of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of14.setVisible(true);
                apptmtID3of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 4) {
                int index = 3;
                time4of14.setVisible(true);
                time4of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of14.setVisible(true);
                apptmtID4of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 5) {
                int index = 4;
                time5of14.setVisible(true);
                time5of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of14.setVisible(true);
                apptmtID5of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt8) >= 6) {
                int index = 5;
                time6of14.setVisible(true);
                time6of14.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of14.setVisible(true);
                apptmtID6of14.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day9 = parseInt(Lbl15.getText());
        date = LocalDate.of(year, month, day9);
        times = LocalTime.of(0, 0);
        LocalDateTime dt9 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt9)) {
            setDailyApptmts(dt9);
            if (numOfApptmts(dt9) >= 1) {
                int index = 0;
                time1of15.setVisible(true);
                time1of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of15.setVisible(true);
                apptmtID1of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 2) {
                int index = 1;
                time2of15.setVisible(true);
                time2of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of15.setVisible(true);
                apptmtID2of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 3) {
                int index = 2;
                time3of15.setVisible(true);
                time3of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of15.setVisible(true);
                apptmtID3of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 4) {
                int index = 3;
                time4of15.setVisible(true);
                time4of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of15.setVisible(true);
                apptmtID4of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 5) {
                int index = 4;
                time5of15.setVisible(true);
                time5of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of15.setVisible(true);
                apptmtID5of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt9) >= 6) {
                int index = 5;
                time6of15.setVisible(true);
                time6of15.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of15.setVisible(true);
                apptmtID6of15.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day10 = parseInt(Lbl16.getText());
        date = LocalDate.of(year, month, day10);
        times = LocalTime.of(0, 0);
        LocalDateTime dt10 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt10)) {
            setDailyApptmts(dt10);
            if (numOfApptmts(dt10) >= 1) {
                int index = 0;
                time1of16.setVisible(true);
                time1of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of16.setVisible(true);
                apptmtID1of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 2) {
                int index = 1;
                time2of16.setVisible(true);
                time2of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of16.setVisible(true);
                apptmtID2of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 3) {
                int index = 2;
                time3of16.setVisible(true);
                time3of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of16.setVisible(true);
                apptmtID3of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 4) {
                int index = 3;
                time4of16.setVisible(true);
                time4of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of16.setVisible(true);
                apptmtID4of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 5) {
                int index = 4;
                time5of16.setVisible(true);
                time5of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of16.setVisible(true);
                apptmtID5of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt10) >= 6) {
                int index = 5;
                time6of16.setVisible(true);
                time6of16.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of16.setVisible(true);
                apptmtID6of16.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day11 = parseInt(Lbl17.getText());
        date = LocalDate.of(year, month, day11);
        times = LocalTime.of(0, 0);
        LocalDateTime dt11 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt11)) {
            setDailyApptmts(dt11);
            if (numOfApptmts(dt11) >= 1) {
                int index = 0;
                time1of17.setVisible(true);
                time1of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of17.setVisible(true);
                apptmtID1of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 2) {
                int index = 1;
                time2of17.setVisible(true);
                time2of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of17.setVisible(true);
                apptmtID2of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 3) {
                int index = 2;
                time3of17.setVisible(true);
                time3of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of17.setVisible(true);
                apptmtID3of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 4) {
                int index = 3;
                time4of17.setVisible(true);
                time4of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of17.setVisible(true);
                apptmtID4of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 5) {
                int index = 4;
                time5of17.setVisible(true);
                time5of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of17.setVisible(true);
                apptmtID5of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt11) >= 6) {
                int index = 5;
                time6of17.setVisible(true);
                time6of17.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of17.setVisible(true);
                apptmtID6of17.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day12 = parseInt(Lbl18.getText());
        date = LocalDate.of(year, month, day12);
        times = LocalTime.of(0, 0);
        LocalDateTime dt12 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt12)) {
            setDailyApptmts(dt12);
            if (numOfApptmts(dt12) >= 1) {
                int index = 0;
                time1of18.setVisible(true);
                time1of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of18.setVisible(true);
                apptmtID1of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 2) {
                int index = 1;
                time2of18.setVisible(true);
                time2of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of18.setVisible(true);
                apptmtID2of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 3) {
                int index = 2;
                time3of18.setVisible(true);
                time3of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of18.setVisible(true);
                apptmtID3of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 4) {
                int index = 3;
                time4of18.setVisible(true);
                time4of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of18.setVisible(true);
                apptmtID4of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 5) {
                int index = 4;
                time5of18.setVisible(true);
                time5of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of18.setVisible(true);
                apptmtID5of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt12) >= 6) {
                int index = 5;
                time6of18.setVisible(true);
                time6of18.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of18.setVisible(true);
                apptmtID6of18.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day13 = parseInt(Lbl19.getText());
        date = LocalDate.of(year, month, day13);
        times = LocalTime.of(0, 0);
        LocalDateTime dt13 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt13)) {
            setDailyApptmts(dt13);
            if (numOfApptmts(dt13) >= 1) {
                int index = 0;
                time1of19.setVisible(true);
                time1of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of19.setVisible(true);
                apptmtID1of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 2) {
                int index = 1;
                time2of19.setVisible(true);
                time2of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of19.setVisible(true);
                apptmtID2of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 3) {
                int index = 2;
                time3of19.setVisible(true);
                time3of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of19.setVisible(true);
                apptmtID3of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 4) {
                int index = 3;
                time4of19.setVisible(true);
                time4of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of19.setVisible(true);
                apptmtID4of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 5) {
                int index = 4;
                time5of19.setVisible(true);
                time5of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of19.setVisible(true);
                apptmtID5of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt13) >= 6) {
                int index = 5;
                time6of19.setVisible(true);
                time6of19.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of19.setVisible(true);
                apptmtID6of19.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day14 = parseInt(Lbl20.getText());
        date = LocalDate.of(year, month, day14);
        times = LocalTime.of(0, 0);
        LocalDateTime dt14 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt14)) {
            setDailyApptmts(dt14);
            if (numOfApptmts(dt14) >= 1) {
                int index = 0;
                time1of20.setVisible(true);
                time1of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of20.setVisible(true);
                apptmtID1of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 2) {
                int index = 1;
                time2of20.setVisible(true);
                time2of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of20.setVisible(true);
                apptmtID2of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 3) {
                int index = 2;
                time3of20.setVisible(true);
                time3of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of20.setVisible(true);
                apptmtID3of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 4) {
                int index = 3;
                time4of20.setVisible(true);
                time4of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of20.setVisible(true);
                apptmtID4of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 5) {
                int index = 4;
                time5of20.setVisible(true);
                time5of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of20.setVisible(true);
                apptmtID5of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt14) >= 6) {
                int index = 5;
                time6of20.setVisible(true);
                time6of20.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of20.setVisible(true);
                apptmtID6of20.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day15 = parseInt(Lbl21.getText());
        date = LocalDate.of(year, month, day15);
        times = LocalTime.of(0, 0);
        LocalDateTime dt15 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt15)) {
            setDailyApptmts(dt15);
            if (numOfApptmts(dt15) >= 1) {
                int index = 0;
                time1of21.setVisible(true);
                time1of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of21.setVisible(true);
                apptmtID1of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 2) {
                int index = 1;
                time2of21.setVisible(true);
                time2of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of21.setVisible(true);
                apptmtID2of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 3) {
                int index = 2;
                time3of21.setVisible(true);
                time3of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of21.setVisible(true);
                apptmtID3of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 4) {
                int index = 3;
                time4of21.setVisible(true);
                time4of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of21.setVisible(true);
                apptmtID4of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 5) {
                int index = 4;
                time5of21.setVisible(true);
                time5of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of21.setVisible(true);
                apptmtID5of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt15) >= 6) {
                int index = 5;
                time6of21.setVisible(true);
                time6of21.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of21.setVisible(true);
                apptmtID6of21.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day16 = parseInt(Lbl22.getText());
        date = LocalDate.of(year, month, day16);
        times = LocalTime.of(0, 0);
        LocalDateTime dt16 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt16)) {
            setDailyApptmts(dt16);
            if (numOfApptmts(dt16) >= 1) {
                int index = 0;
                time1of22.setVisible(true);
                time1of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of22.setVisible(true);
                apptmtID1of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 2) {
                int index = 1;
                time2of22.setVisible(true);
                time2of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of22.setVisible(true);
                apptmtID2of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 3) {
                int index = 2;
                time3of22.setVisible(true);
                time3of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of22.setVisible(true);
                apptmtID3of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 4) {
                int index = 3;
                time4of22.setVisible(true);
                time4of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of22.setVisible(true);
                apptmtID4of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 5) {
                int index = 4;
                time5of22.setVisible(true);
                time5of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of22.setVisible(true);
                apptmtID5of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt16) >= 6) {
                int index = 5;
                time6of22.setVisible(true);
                time6of22.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of22.setVisible(true);
                apptmtID6of22.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day17 = parseInt(Lbl23.getText());
        date = LocalDate.of(year, month, day17);
        times = LocalTime.of(0, 0);
        LocalDateTime dt17 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt17)) {
            setDailyApptmts(dt17);
            if (numOfApptmts(dt17) >= 1) {
                int index = 0;
                time1of23.setVisible(true);
                time1of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of23.setVisible(true);
                apptmtID1of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 2) {
                int index = 1;
                time2of23.setVisible(true);
                time2of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of23.setVisible(true);
                apptmtID2of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 3) {
                int index = 2;
                time3of23.setVisible(true);
                time3of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of23.setVisible(true);
                apptmtID3of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 4) {
                int index = 3;
                time4of23.setVisible(true);
                time4of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of23.setVisible(true);
                apptmtID4of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 5) {
                int index = 4;
                time5of23.setVisible(true);
                time5of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of23.setVisible(true);
                apptmtID5of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt17) >= 6) {
                int index = 5;
                time6of23.setVisible(true);
                time6of23.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of23.setVisible(true);
                apptmtID6of23.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day18 = parseInt(Lbl24.getText());
        date = LocalDate.of(year, month, day18);
        times = LocalTime.of(0, 0);
        LocalDateTime dt18 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt18)) {
            setDailyApptmts(dt18);
            if (numOfApptmts(dt18) >= 1) {
                int index = 0;
                time1of24.setVisible(true);
                time1of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of24.setVisible(true);
                apptmtID1of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 2) {
                int index = 1;
                time2of24.setVisible(true);
                time2of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of24.setVisible(true);
                apptmtID2of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 3) {
                int index = 2;
                time3of24.setVisible(true);
                time3of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of24.setVisible(true);
                apptmtID3of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 4) {
                int index = 3;
                time4of24.setVisible(true);
                time4of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of24.setVisible(true);
                apptmtID4of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 5) {
                int index = 4;
                time5of24.setVisible(true);
                time5of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of24.setVisible(true);
                apptmtID5of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt18) >= 6) {
                int index = 5;
                time6of24.setVisible(true);
                time6of24.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of24.setVisible(true);
                apptmtID6of24.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day19 = parseInt(Lbl25.getText());
        date = LocalDate.of(year, month, day19);
        times = LocalTime.of(0, 0);
        LocalDateTime dt19 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt19)) {
            setDailyApptmts(dt19);
            if (numOfApptmts(dt19) >= 1) {
                int index = 0;
                time1of25.setVisible(true);
                time1of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of25.setVisible(true);
                apptmtID1of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 2) {
                int index = 1;
                time2of25.setVisible(true);
                time2of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of25.setVisible(true);
                apptmtID2of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 3) {
                int index = 2;
                time3of25.setVisible(true);
                time3of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of25.setVisible(true);
                apptmtID3of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 4) {
                int index = 3;
                time4of25.setVisible(true);
                time4of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of25.setVisible(true);
                apptmtID4of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 5) {
                int index = 4;
                time5of25.setVisible(true);
                time5of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of25.setVisible(true);
                apptmtID5of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt19) >= 6) {
                int index = 5;
                time6of25.setVisible(true);
                time6of25.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of25.setVisible(true);
                apptmtID6of25.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day20 = parseInt(Lbl26.getText());
        date = LocalDate.of(year, month, day20);
        times = LocalTime.of(0, 0);
        LocalDateTime dt20 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt20)) {
            setDailyApptmts(dt20);
            if (numOfApptmts(dt20) >= 1) {
                int index = 0;
                time1of26.setVisible(true);
                time1of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of26.setVisible(true);
                apptmtID1of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 2) {
                int index = 1;
                time2of26.setVisible(true);
                time2of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of26.setVisible(true);
                apptmtID2of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 3) {
                int index = 2;
                time3of26.setVisible(true);
                time3of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of26.setVisible(true);
                apptmtID3of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 4) {
                int index = 3;
                time4of26.setVisible(true);
                time4of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of26.setVisible(true);
                apptmtID4of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 5) {
                int index = 4;
                time5of26.setVisible(true);
                time5of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of26.setVisible(true);
                apptmtID5of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt20) >= 6) {
                int index = 5;
                time6of26.setVisible(true);
                time6of26.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of26.setVisible(true);
                apptmtID6of26.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day21 = parseInt(Lbl27.getText());
        date = LocalDate.of(year, month, day21);
        times = LocalTime.of(0, 0);
        LocalDateTime dt21 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt21)) {
            setDailyApptmts(dt21);
            if (numOfApptmts(dt21) >= 1) {
                int index = 0;
                time1of27.setVisible(true);
                time1of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of27.setVisible(true);
                apptmtID1of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 2) {
                int index = 1;
                time2of27.setVisible(true);
                time2of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of27.setVisible(true);
                apptmtID2of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 3) {
                int index = 2;
                time3of27.setVisible(true);
                time3of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of27.setVisible(true);
                apptmtID3of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 4) {
                int index = 3;
                time4of27.setVisible(true);
                time4of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of27.setVisible(true);
                apptmtID4of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 5) {
                int index = 4;
                time5of27.setVisible(true);
                time5of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of27.setVisible(true);
                apptmtID5of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt21) >= 6) {
                int index = 5;
                time6of27.setVisible(true);
                time6of27.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of27.setVisible(true);
                apptmtID6of27.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day22 = parseInt(Lbl28.getText());
        date = LocalDate.of(year, month, day22);
        times = LocalTime.of(0, 0);
        LocalDateTime dt22 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt22)) {
            setDailyApptmts(dt22);
            if (numOfApptmts(dt22) >= 1) {
                int index = 0;
                time1of28.setVisible(true);
                time1of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of28.setVisible(true);
                apptmtID1of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 2) {
                int index = 1;
                time2of28.setVisible(true);
                time2of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of28.setVisible(true);
                apptmtID2of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 3) {
                int index = 2;
                time3of28.setVisible(true);
                time3of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of28.setVisible(true);
                apptmtID3of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 4) {
                int index = 3;
                time4of28.setVisible(true);
                time4of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of28.setVisible(true);
                apptmtID4of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 5) {
                int index = 4;
                time5of28.setVisible(true);
                time5of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of28.setVisible(true);
                apptmtID5of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt22) >= 6) {
                int index = 5;
                time6of28.setVisible(true);
                time6of28.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of28.setVisible(true);
                apptmtID6of28.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day23 = parseInt(Lbl29.getText());
        date = LocalDate.of(year, month, day23);
        times = LocalTime.of(0, 0);
        LocalDateTime dt23 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt23)) {
            setDailyApptmts(dt23);
            if (numOfApptmts(dt23) >= 1) {
                int index = 0;
                time1of29.setVisible(true);
                time1of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of29.setVisible(true);
                apptmtID1of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 2) {
                int index = 1;
                time2of29.setVisible(true);
                time2of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of29.setVisible(true);
                apptmtID2of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 3) {
                int index = 2;
                time3of29.setVisible(true);
                time3of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of29.setVisible(true);
                apptmtID3of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 4) {
                int index = 3;
                time4of29.setVisible(true);
                time4of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of29.setVisible(true);
                apptmtID4of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 5) {
                int index = 4;
                time5of29.setVisible(true);
                time5of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of29.setVisible(true);
                apptmtID5of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt23) >= 6) {
                int index = 5;
                time6of29.setVisible(true);
                time6of29.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of29.setVisible(true);
                apptmtID6of29.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day24 = parseInt(Lbl30.getText());
        date = LocalDate.of(year, month, day24);
        times = LocalTime.of(0, 0);
        LocalDateTime dt24 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt24)) {
            setDailyApptmts(dt24);
            if (numOfApptmts(dt24) >= 1) {
                int index = 0;
                time1of30.setVisible(true);
                time1of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of30.setVisible(true);
                apptmtID1of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 2) {
                int index = 1;
                time2of30.setVisible(true);
                time2of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of30.setVisible(true);
                apptmtID2of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 3) {
                int index = 2;
                time3of30.setVisible(true);
                time3of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of30.setVisible(true);
                apptmtID3of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 4) {
                int index = 3;
                time4of30.setVisible(true);
                time4of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of30.setVisible(true);
                apptmtID4of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 5) {
                int index = 4;
                time5of30.setVisible(true);
                time5of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of30.setVisible(true);
                apptmtID5of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt24) >= 6) {
                int index = 5;
                time6of30.setVisible(true);
                time6of30.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of30.setVisible(true);
                apptmtID6of30.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day25 = parseInt(Lbl31.getText());
        date = LocalDate.of(year, month, day25);
        times = LocalTime.of(0, 0);
        LocalDateTime dt25 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt25)) {
            setDailyApptmts(dt25);
            if (numOfApptmts(dt25) >= 1) {
                int index = 0;
                time1of31.setVisible(true);
                time1of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of31.setVisible(true);
                apptmtID1of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 2) {
                int index = 1;
                time2of31.setVisible(true);
                time2of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of31.setVisible(true);
                apptmtID2of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 3) {
                int index = 2;
                time3of31.setVisible(true);
                time3of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of31.setVisible(true);
                apptmtID3of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 4) {
                int index = 3;
                time4of31.setVisible(true);
                time4of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of31.setVisible(true);
                apptmtID4of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 5) {
                int index = 4;
                time5of31.setVisible(true);
                time5of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of31.setVisible(true);
                apptmtID5of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt25) >= 6) {
                int index = 5;
                time6of31.setVisible(true);
                time6of31.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of31.setVisible(true);
                apptmtID6of31.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day26 = parseInt(Lbl32.getText());
        date = LocalDate.of(year, month, day26);
        times = LocalTime.of(0, 0);
        LocalDateTime dt26 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt26)) {
            setDailyApptmts(dt26);
            if (numOfApptmts(dt26) >= 1) {
                int index = 0;
                time1of32.setVisible(true);
                time1of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of32.setVisible(true);
                apptmtID1of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 2) {
                int index = 1;
                time2of32.setVisible(true);
                time2of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of32.setVisible(true);
                apptmtID2of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 3) {
                int index = 2;
                time3of32.setVisible(true);
                time3of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of32.setVisible(true);
                apptmtID3of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 4) {
                int index = 3;
                time4of32.setVisible(true);
                time4of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of32.setVisible(true);
                apptmtID4of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 5) {
                int index = 4;
                time5of32.setVisible(true);
                time5of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of32.setVisible(true);
                apptmtID5of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt26) >= 6) {
                int index = 5;
                time6of32.setVisible(true);
                time6of32.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of32.setVisible(true);
                apptmtID6of32.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day27 = parseInt(Lbl33.getText());
        date = LocalDate.of(year, month, day27);
        times = LocalTime.of(0, 0);
        LocalDateTime dt27 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt27)) {
            setDailyApptmts(dt27);
            if (numOfApptmts(dt27) >= 1) {
                int index = 0;
                time1of33.setVisible(true);
                time1of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of33.setVisible(true);
                apptmtID1of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 2) {
                int index = 1;
                time2of33.setVisible(true);
                time2of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of33.setVisible(true);
                apptmtID2of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 3) {
                int index = 2;
                time3of33.setVisible(true);
                time3of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of33.setVisible(true);
                apptmtID3of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 4) {
                int index = 3;
                time4of33.setVisible(true);
                time4of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of33.setVisible(true);
                apptmtID4of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 5) {
                int index = 4;
                time5of33.setVisible(true);
                time5of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of33.setVisible(true);
                apptmtID5of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt27) >= 6) {
                int index = 5;
                time6of33.setVisible(true);
                time6of33.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of33.setVisible(true);
                apptmtID6of33.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        int day28 = parseInt(Lbl34.getText());
        date = LocalDate.of(year, month, day28);
        times = LocalTime.of(0, 0);
        LocalDateTime dt28 = LocalDateTime.of(date, times);
        if (validateApptmtDay(dt28)) {
            setDailyApptmts(dt28);
            if (numOfApptmts(dt28) >= 1) {
                int index = 0;
                time1of34.setVisible(true);
                time1of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID1of34.setVisible(true);
                apptmtID1of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 2) {
                int index = 1;
                time2of34.setVisible(true);
                time2of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID2of34.setVisible(true);
                apptmtID2of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 3) {
                int index = 2;
                time3of34.setVisible(true);
                time3of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID3of34.setVisible(true);
                apptmtID3of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 4) {
                int index = 3;
                time4of34.setVisible(true);
                time4of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID4of34.setVisible(true);
                apptmtID4of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 5) {
                int index = 4;
                time5of34.setVisible(true);
                time5of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID5of34.setVisible(true);
                apptmtID5of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
            if (numOfApptmts(dt28) >= 6) {
                int index = 5;
                time6of34.setVisible(true);
                time6of34.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                apptmtID6of34.setVisible(true);
                apptmtID6of34.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
            }
        }

        if (((month == 2) && (Calendar.isLeapYear(year))) || (month != 2)) {
            Lbl35.setText("29");
            int day29 = parseInt(Lbl35.getText());
            date = LocalDate.of(year, month, day29);
            times = LocalTime.of(0, 0);
            LocalDateTime dt29 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt29)) {
                setDailyApptmts(dt29);
                if (numOfApptmts(dt29) >= 1) {
                    int index = 0;
                    time1of35.setVisible(true);
                    time1of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of35.setVisible(true);
                    apptmtID1of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 2) {
                    int index = 1;
                    time2of35.setVisible(true);
                    time2of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of35.setVisible(true);
                    apptmtID2of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 3) {
                    int index = 2;
                    time3of35.setVisible(true);
                    time3of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of35.setVisible(true);
                    apptmtID3of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 4) {
                    int index = 3;
                    time4of35.setVisible(true);
                    time4of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of35.setVisible(true);
                    apptmtID4of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 5) {
                    int index = 4;
                    time5of35.setVisible(true);
                    time5of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of35.setVisible(true);
                    apptmtID5of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt29) >= 6) {
                    int index = 5;
                    time6of35.setVisible(true);
                    time6of35.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of35.setVisible(true);
                    apptmtID6of35.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if (month != 2) {
            Lbl36.setText("30");
            int day30 = parseInt(Lbl36.getText());
            date = LocalDate.of(year, month, day30);
            times = LocalTime.of(0, 0);
            LocalDateTime dt30 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt30)) {
                setDailyApptmts(dt30);
                if (numOfApptmts(dt30) >= 1) {
                    int index = 0;
                    time1of36.setVisible(true);
                    time1of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of36.setVisible(true);
                    apptmtID1of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 2) {
                    int index = 1;
                    time2of36.setVisible(true);
                    time2of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of36.setVisible(true);
                    apptmtID2of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 3) {
                    int index = 2;
                    time3of36.setVisible(true);
                    time3of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of36.setVisible(true);
                    apptmtID3of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 4) {
                    int index = 3;
                    time4of36.setVisible(true);
                    time4of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of36.setVisible(true);
                    apptmtID4of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 5) {
                    int index = 4;
                    time5of36.setVisible(true);
                    time5of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of36.setVisible(true);
                    apptmtID5of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt30) >= 6) {
                    int index = 5;
                    time6of36.setVisible(true);
                    time6of36.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of36.setVisible(true);
                    apptmtID6of36.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            Lbl37.setText("31");
            int day31 = parseInt(Lbl37.getText());
            date = LocalDate.of(year, month, day31);
            times = LocalTime.of(0, 0);
            LocalDateTime dt31 = LocalDateTime.of(date, times);
            if (validateApptmtDay(dt31)) {
                setDailyApptmts(dt31);
                if (numOfApptmts(dt31) >= 1) {
                    int index = 0;
                    time1of37.setVisible(true);
                    time1of37.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID1of37.setVisible(true);
                    apptmtID1of37.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 2) {
                    int index = 1;
                    time2of37.setVisible(true);
                    time2of37.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID2of37.setVisible(true);
                    apptmtID2of37.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 3) {
                    int index = 2;
                    time3of37.setVisible(true);
                    time3of37.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID3of37.setVisible(true);
                    apptmtID3of37.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 4) {
                    int index = 3;
                    time4of37.setVisible(true);
                    time4of37.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID4of37.setVisible(true);
                    apptmtID4of37.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 5) {
                    int index = 4;
                    time5of37.setVisible(true);
                    time5of37.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID5of37.setVisible(true);
                    apptmtID5of37.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
                if (numOfApptmts(dt31) >= 6) {
                    int index = 5;
                    time6of37.setVisible(true);
                    time6of37.setText(allDailyApptmts.get(index).getStart().toLocalTime() + " - " + allDailyApptmts.get(index).getEnd().toLocalTime());
                    apptmtID6of37.setVisible(true);
                    apptmtID6of37.setText(String.valueOf(allDailyApptmts.get(index).getAppointmentId()));
                }
            }
        }
    }

    public int monthToInt(String mon) {
        if (mon.toUpperCase().equals("JANUARY")) {
            int month = 1;
            return month;
        }
        else if (mon.toUpperCase().equals("FEBRUARY")) {
            int month = 2;
            return month;
        }
        else if (mon.toUpperCase().equals("MARCH")) {
            int month = 3;
            return month;
        }
        else if (mon.toUpperCase().equals("APRIL")) {
            int month = 4;
            return month;
        }
        else if (mon.toUpperCase().equals("MAY")) {
            int month = 5;
            return month;
        }
        else if (mon.toUpperCase().equals("JUNE")) {
            int month = 6;
            return month;
        }
        else if (mon.toUpperCase().equals("JULY")) {
            int month = 7;
            return month;
        }
        else if (mon.toUpperCase().equals("AUGUST")) {
            int month = 8;
            return month;
        }
        else if (mon.toUpperCase().equals("SEPTEMBER")) {
            int month = 9;
            return month;
        }
        else if (mon.toUpperCase().equals("OCTOBER")) {
            int month = 10;
            return month;
        }
        else if (mon.toUpperCase().equals("NOVEMBER")) {
            int month = 11;
            return month;
        }
        else if (mon.toUpperCase().equals("DECEMBER")) {
            int month = 12;
            return month;
        }
        else
            return(0);
    }

    public boolean validateApptmtDay(LocalDateTime date) throws SQLException {

        for (CompleteAppointment appointment : allMonthlyApptmts) {
            if (appointment.getStart().toLocalDate().equals(date.toLocalDate()))
                return true;
        }
        return false;
    }

    public int numOfApptmts(LocalDateTime date) throws SQLException {
        int count = 0;
        for (CompleteAppointment appointment : allMonthlyApptmts) {
            if (appointment.getStart().toLocalDate().equals(date.toLocalDate()))
                count += 1;
        }
        return count;
    }

    public void setCurrentUser(User currentUser) {
        user = currentUser;
    }

    public static boolean isWithinFifteenMins(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        if (time.compareTo(now) <= 15)
            return true;
        else
            return false;
    }

        //lambda.addActionListener(new ActionListener((e) -> JOptionPane.showMessageDialog(null, empty));

    
    public void setDailyApptmts(LocalDateTime time) {   //using lambda to create a list of daily appointments from the database-collected monthly appointments list
        if (time == null)
            return;
        if (!(allDailyApptmts.isEmpty()))
            allDailyApptmts.clear();
        allDailyApptmts = allMonthlyApptmts.stream()
                .filter(apptmt -> (apptmt.getStart().toLocalDate().equals(time.toLocalDate())))
                .collect(Collectors.toCollection(ArrayList::new));
/*
        if (!(allDailyApptmts.isEmpty()))
            allDailyApptmts.clear();
        for (CompleteAppointment compApptmt : allMonthlyApptmts) {
            if (compApptmt.getStart().toLocalDate().equals(time.toLocalDate()))
                allDailyApptmts.add(compApptmt);
        }

 */
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            allMonthlyApptmts = SelectDB.selectAllCompleteAppointments();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //set up for current calendar year
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();

        monthLbl.setText(localDate.getMonth().toString());
        yearLbl1.setText(String.valueOf(year));
        yearLbl2.setText(String.valueOf(year));

        try {
            if (Calendar.dayOfWeekNum(month, 1, year) == 0) {
                sundayStartMonth(month, year);
            }
            else if (Calendar.dayOfWeekNum(month, 1, year) == 1) {
                mondayStartMonth(month, year);
            }
            else if (Calendar.dayOfWeekNum(month, 1, year) == 2) {
                tuesdayStartMonth(month, year);
            }
            else if(Calendar.dayOfWeekNum(month,1, year) == 3) {
                wednesdayStartMonth(month, year);
            }
            else if(Calendar.dayOfWeekNum(month,1, year) == 4) {
                thursdayStartMonth(month, year);
            }
            else if(Calendar.dayOfWeekNum(month,1, year) == 5) {
                fridayStartMonth(month, year);
            }
            else if(Calendar.dayOfWeekNum(month,1, year) == 6) {
                saturdayStartMonth(month, year);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date Error");
                alert.setContentText("Please check the current date settings!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
