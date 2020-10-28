package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static Model.Product.sumOfParts;

/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C482 - Software I
 * Project: Inventory Management System
 */

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    Product product;

    public ObservableList<Part> filterParts(String str) {
        if (!(Inventory.getPartsFound().isEmpty()))
            Inventory.getPartsFound().clear();
        for (Part part : Inventory.getAllParts()) {
            if (part.getName().toLowerCase().contains(str.toLowerCase()))
                Inventory.getPartsFound().add(part);
        }
        if (Inventory.getPartsFound().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Your Search Yielded No Results");
            alert.setContentText("Please try your search again!");

            alert.showAndWait();

            return Inventory.getAllParts();
        }
        else
            return Inventory.getPartsFound();
    }

    @FXML
        private TextField productIdTxt;

        @FXML
        private TextField productNameTxt;

        @FXML
        private TextField productStockTxt;

        @FXML
        private TextField productPriceTxt;

        @FXML
        private TextField productMaxTxt;

        @FXML
        private TextField productMinTxt;

        @FXML
        private TextField productSearchTxt;

        @FXML
        private TableView<Part> productAddTableView;

        @FXML
        private TableColumn<Part, Integer> productIdAddCol;

        @FXML
        private TableColumn<Part, String> productNameAddCol;

        @FXML
        private TableColumn<Part, Integer> productStockAddCol;

        @FXML
        private TableColumn<Part, Double> productPriceAddCol;

        @FXML
        private TableView<Part> productDelTableView;

        @FXML
        private TableColumn<Part, Integer> productIdDelCol;

        @FXML
        private TableColumn<Part, String> productNameDelCol;

        @FXML
        private TableColumn<Part, Integer> productStockDelCol;

        @FXML
        private TableColumn<Part, Double> productPriceDelCol;

    @FXML
    void onActionAddProduct(ActionEvent event) {
        Part part = productAddTableView.getSelectionModel().getSelectedItem();

        if (part == null)
            return;
        else {
            product.addAssociatedPart(part);
        }
    }

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
    void onActionDelProduct(ActionEvent event) {
        Part part = productDelTableView.getSelectionModel().getSelectedItem();
        if (part == null)
            return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("You are requesting to delete a Part from this list.");
        alert.setContentText("Do you wish to continue?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            product.deleteAssociatedPart(part);
        System.out.println("Part Deleted Successfully");
    }

    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {
        int id = Integer.parseInt(productIdTxt.getText());
        String name = productNameTxt.getText();
        try {
            int stock = Integer.parseInt(productStockTxt.getText());
            double price = Double.parseDouble(productPriceTxt.getText());
            int max = Integer.parseInt(productMaxTxt.getText());
            int min = Integer.parseInt(productMinTxt.getText());

            if (!((stock >= min) && (max >= stock))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Stock Amount Invalid");
                alert.setContentText("Inventory amount must be between min and max!");

                alert.showAndWait();
            } else if (product.getAllAssociatedParts() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Associated Parts Error");
                alert.setContentText("A product must have at least one associated part!");

                alert.showAndWait();
            } else if (price < sumOfParts(product)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Price Error");
                alert.setContentText("A product's price must be at least equal to the cost of its parts!");

                alert.showAndWait();
            } else {
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setStock(stock);
                product.setMax(max);
                product.setMin(min);

                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();

                System.out.println("Product Changes Saved");
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Error");
            alert.setContentText("Inventory, Maximum, and Minimum values must be integers! Price value must include a decimal!");

            alert.showAndWait();
            }
    }

    @FXML
    void onActionSearchProducts(ActionEvent event) {
        String string = productSearchTxt.getText();

        if (string == null) {
            return;
        }
        else productAddTableView.setItems(filterParts(string));
/*        String str = productSearchTxt.getText();
        if (str == null) {
            System.out.println("No Search Data Was Found");
            return;
        }
        for (Part part : Inventory.getAllParts()) {
            if((part.getId() == Integer.parseInt(str)) || (part.getName().equals(str)) || (part.getStock() == Integer.parseInt(str))
                    || (part.getPrice() == Double.parseDouble(str)))
            {
                System.out.println("Product Found");
                Inventory.lookupProduct(part.getId());
            }
        }

 */
    }

public void prepopulateProduct(Product product) {
        this.product = product;
    productIdTxt.setText(String.valueOf(product.getId()));
    productNameTxt.setText(product.getName());
    productStockTxt.setText(String.valueOf(product.getStock()));;
    productPriceTxt.setText(String.valueOf(product.getPrice()));
    productMaxTxt.setText(String.valueOf(product.getMax()));
    productMinTxt.setText(String.valueOf(product.getMin()));

    productDelTableView.setItems(product.getAllAssociatedParts());
    productIdDelCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    productNameDelCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    productStockDelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
    productPriceDelCol.setCellValueFactory(new PropertyValueFactory<>("price"));
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        productAddTableView.setItems(Inventory.getAllParts());
        productIdAddCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameAddCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productStockAddCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceAddCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
