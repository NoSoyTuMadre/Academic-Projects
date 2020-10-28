import Model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C482 - Software I
 * Project: Inventory Management System
 */

public class Toni_Fields_Inventory_System extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     *
     * @param args the command line arguments
     */

public static void main(String[] args){

        ObservableList<Part> associatedParts = FXCollections.observableArrayList();

        //Initial Data
    InhousePart bearing = new InhousePart(Part.autoNextID(), "Axle Bearing", 74.53, 3, 2, 10, 502);
    OutsourcedPart leafspring = new OutsourcedPart(Part.autoNextID(), "Leafspring", 174.29, 5, 3, 8, "Freightliner of Atlanta");
    OutsourcedPart bushing = new OutsourcedPart(Part.autoNextID(), "Hanger Bushing", 55.99, 8, 3, 8, "Pilot Travel Centers");
    Product truck = new Product(Product.autoNextID(), "Freightliner", 20000.00, 2, 0, 10);
    Product tractor = new Product(Product.autoNextID(), "John Deere", 800.00, 8, 0, 10);

    truck.addAssociatedPart(bearing);
    truck.addAssociatedPart(leafspring);
    tractor.addAssociatedPart(bearing);
    tractor.addAssociatedPart(bushing);
    Inventory.addPart(bearing);
    Inventory.addPart(leafspring);
    Inventory.addPart(bushing);
    Inventory.addProduct(truck);
    Inventory.addProduct(tractor);

    launch(args);
    }
}
