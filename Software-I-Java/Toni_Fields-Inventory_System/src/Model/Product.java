package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C482 - Software I
 * Project: Inventory Management System
 */

public class Product {

    //create fields
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public static double sumOfParts(Product product) {
        double sum = 0.0;
        for (Part part : product.getAllAssociatedParts()) {
            sum = sum + part.getPrice();
        }
        return sum;
    }
    //set up auto-increment method for next ID creation
    static int nextID = 1;
    public static int autoNextID() {
        return nextID++;
    }
    public static int getNextID() {
        return nextID;
    }

    //create methods
    public Product() {
        this.id = -1;
        this.name = null;
        this.price = 0.0;
        this.stock = -1;
        this.min = -1;
        this.max = -1;
    }
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }
    public boolean deleteAssociatedPart(Part selectedAsPart) {
        for (Part part : associatedParts) {
            if (part.getName().equalsIgnoreCase(selectedAsPart.getName())) {
                associatedParts.remove(part);
                return true;
            }
        }
        return false;
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
}
