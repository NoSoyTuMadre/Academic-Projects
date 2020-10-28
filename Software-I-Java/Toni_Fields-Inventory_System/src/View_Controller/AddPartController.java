package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import Model.OutsourcedPart;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C482 - Software I
 * Project: Inventory Management System
 */

public class AddPartController implements Initializable {

    Stage stage;
    Parent scene;

        @FXML
        private RadioButton inhouseRBtn;

        @FXML
        private ToggleGroup partTG;

        @FXML
        private RadioButton outsourcedRBtn;

        @FXML
        private Label partCompLbl;

        @FXML
        private TextField partIdTxt;

        @FXML
        private TextField partNameTxt;

        @FXML
        private TextField partStockTxt;

        @FXML
        private TextField partPriceTxt;

        @FXML
        private TextField partMaxTxt;

        @FXML
        private TextField partMinTxt;

        @FXML
        private TextField partCompTxt;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are cancelling this operation.");
        alert.setContentText("Do you wish to continue?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {

        int id = Integer.parseInt(partIdTxt.getText());
        String name = partNameTxt.getText();
        try {
            double price = Double.parseDouble(partPriceTxt.getText());
            int stock = Integer.parseInt(partStockTxt.getText());
            int max = Integer.parseInt(partMaxTxt.getText());
            int min = Integer.parseInt(partMinTxt.getText());
            boolean isInhouse = inhouseRBtn.isSelected();

            if ((stock >= min) && (stock <= max)) {
                if (isInhouse) {
                    try {
                        int machineId = Integer.parseInt(partCompTxt.getText());
                        int index = id - 1;
                        Part inPart = new InhousePart(id, name, price, stock, min, max, machineId);
                        Inventory.addPart(inPart);
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Machine ID Error");
                        alert.setContentText("Machine ID must be an integer!");

                        alert.showAndWait();
                    }
                } else {
                    String compName = partCompTxt.getText();
                    Part outPart = new OutsourcedPart(id, name, price, stock, min, max, compName);
                    int index = id - 1;
                    Inventory.addPart(outPart);
                }
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Stock Amount Invalid");
                alert.setContentText("Inventory amount must be between min and max!");

                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Error");
            alert.setContentText("Inventory, Maximum, and Minimum values must be integers! Price value must include a decimal!");

            alert.showAndWait();
        }
    }

    @FXML
    void onActionDisplayCompName(ActionEvent event) {
        partCompLbl.setText("Company Name");
        partCompTxt.setPromptText("Company Name");
    }

    @FXML
    void onActionDisplayMachineId(ActionEvent event) {
        partCompLbl.setText("Machine ID");
        partCompTxt.setPromptText("Machine ID");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        partIdTxt.setText(Integer.toString(Part.autoNextID()));
    }
}
