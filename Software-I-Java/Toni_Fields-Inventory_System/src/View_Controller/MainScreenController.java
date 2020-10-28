package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class MainScreenController implements Initializable {

    Stage stage;
    Parent scene;

    //methods for helping with searches
    public ObservableList<Part> filterParts(String str) {
       if (!(Inventory.getPartsFound().isEmpty()))
           Inventory.getPartsFound().clear();
           for (Part part : Inventory.getAllParts()) {
               if (part.getName().toLowerCase().contains(str.toLowerCase()))
                   Inventory.getPartsFound().add(part);
           }
       if (Inventory.getPartsFound().isEmpty()) {
           Alert alert = new Alert(AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Your Search Yielded No Results");
           alert.setContentText("Please try your search again!");

           alert.showAndWait();

           return Inventory.getAllParts();
       }
       else
           return Inventory.getPartsFound();
    }

    public ObservableList<Product> filterProducts(String str) {
        if (!(Inventory.getProductsFound().isEmpty()))
            Inventory.getProductsFound().clear();
        for (Product product : Inventory.getAllProducts()) {
            if (product.getName().toLowerCase().contains(str.toLowerCase()))
                Inventory.getProductsFound().add(product);
        }
        if (Inventory.getProductsFound().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your Search Yielded No Results");
            alert.setContentText("Please try your search again!");

            alert.showAndWait();

            return Inventory.getAllProducts();
        }
        else
            return Inventory.getProductsFound();
    }

        @FXML
        private TextField searchPartsTxt;

        @FXML
        private TableView<Part> partsTableView;

        @FXML
        private TableColumn<Part, Integer> partsIdCol;

        @FXML
        private TableColumn<Part, String> partsNameCol;

        @FXML
        private TableColumn<Part, Integer> partsStockCol;

        @FXML
        private TableColumn<Part, Double> partsPriceCol;

        @FXML
        private TextField searchProductsTxt;

        @FXML
        private TableView<Product> productsTableView;

        @FXML
        private TableColumn<Product, Integer> productsIdCol;

        @FXML
        private TableColumn<Product, String> productsNameCol;

        @FXML
        private TableColumn<Product, Integer> productsStockCol;

        @FXML
        private TableColumn<Product, Double> productsPriceCol;

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View_Controller/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionDelPart(ActionEvent event) {
        Part part = partsTableView.getSelectionModel().getSelectedItem();

        if (part == null)
            return;

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are requesting to delete a Part.");
        alert.setContentText("Do you wish to continue?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Inventory.deletePart(part);
            partsTableView.setItems(Inventory.getAllParts());
        }
    }

    @FXML
    void onActionDelProduct(ActionEvent event) {
        Product product = productsTableView.getSelectionModel().getSelectedItem();

        if (product == null)
            return;

        else {
            if (!(product.getAllAssociatedParts().isEmpty())) {
                for (Part part : product.getAllAssociatedParts()) {
                    product.deleteAssociatedPart(part);
                }
            }

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("You are requesting to delete a Product.");
            alert.setContentText("Do you wish to continue?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Inventory.deleteProduct(product);
                productsTableView.setItems(Inventory.getAllProducts());
            }
        }
    }

    @FXML
    void onActionExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onActionModPart(ActionEvent event) throws IOException {
        Part part = partsTableView.getSelectionModel().getSelectedItem();

        if(part == null)
            return;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View_Controller/ModifyPart.fxml"));
        loader.load();

        ModifyPartController MPartController = loader.getController();
        MPartController.prepopulatePart(part);

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionModProduct(ActionEvent event) throws IOException {
        Product product = productsTableView.getSelectionModel().getSelectedItem();

        if(product == null)
            return;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View_Controller/ModifyProduct.fxml"));
        loader.load();

        ModifyProductController MProductController = loader.getController();
        MProductController.prepopulateProduct(product);

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionSearchParts(ActionEvent event) {
        if (searchPartsTxt.getText() == null) {
            return;
        }
        else partsTableView.setItems(filterParts(searchPartsTxt.getText()));
    }

    @FXML
    void onActionSearchProducts(ActionEvent event) {
//        ObservableList<Product> productsFound = FXCollections.observableArrayList();

        if (searchProductsTxt.getText() == null) {
            return;
        }
        else productsTableView.setItems(filterProducts(searchProductsTxt.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        partsTableView.setItems(Inventory.getAllParts());
        partsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        productsTableView.setItems(Inventory.getAllProducts());
        productsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productsStockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
