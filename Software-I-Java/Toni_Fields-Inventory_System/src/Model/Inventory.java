package Model;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * @author Toni Fields
 *
 * Student: Toni Fields
 * Student ID: #001307628
 * Course: C482 - Software I
 * Project: Inventory Management System
 */

public class Inventory {

    //declare fields
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    private static ObservableList<Part> partsFound = FXCollections.observableArrayList();
    private static ObservableList<Product> productsFound = FXCollections.observableArrayList();

    //declare methods
    public static ObservableList<Part> getPartsFound() {
        return partsFound;
    }
    public static ObservableList<Product> getProductsFound() {
        return productsFound;
    }
    public static void addPart(Part newPart) {
        if (newPart != null) {
            allParts.add(newPart);
            System.out.println("Part Added Successfully");
            return;
        }
        System.out.println("Add Part Failed");
    }
    public static void addProduct(Product newProduct) {
        if (newProduct != null) {
            allProducts.add(newProduct);
            System.out.println("Product Added Successfully");
            return;
        }
        System.out.println("Add Product Failed");
    }
    public static Part lookupPart(int partId) {
        for (Part part : allParts) {
            if(part.getId() == partId) {
                System.out.println("Part Found");
                return part;
            }
        }
        System.out.println("Part Not Found");
        return null;
    }
    public static Product lookupProduct(int productId) {
            for (Product product : allProducts) {
                if(product.getId() == productId) {
                    System.out.println("Product Found");
                    return product;
                }
            }
            System.out.println("Product Not Found");
            return null;
    }
    public static ObservableList<Part> lookupPart(String partName) {
        for (Part part : allParts) {
            if(part.getName() == partName) {
                System.out.println("Part Found");
                return ((ObservableList<Part>) part);
            }
        }
        System.out.println("Part Not Found");
        return null;
    }
    public static ObservableList<Product> lookupProduct(String productName) {
        for (Product product : allProducts) {
            if(product.getName() == productName) {
                System.out.println("Product Found");
                return ((ObservableList<Product>) product);
            }
        }
        System.out.println("Product Not Found");
        return null;
    }
    public static void updatePart(int index, Part selectedPart) {
        for(Part part : allParts){
            if(selectedPart.getId() == (index + 1)) {
                allParts.set(index, selectedPart);
                System.out.println("Part Update Complete");
                return;
            }
        }
        System.out.println("Part Update Failed");
/*        int sameId = -1;
        for (Part part : Inventory.allParts) {
            if ((part.getId() == selectedPart.getId()) && sameId < 1) {
                System.out.println("Index: " + index + " ID: " + selectedPart.getId() + " Same ID: " + sameId);  //test
                allParts.set(index, selectedPart);
                sameId = sameId + 1;
                System.out.println("Index: " + index + " ID: " + selectedPart.getId() + " Same ID: " + sameId);  //test
                System.out.println("Part Update Complete");

                for (Product product : Inventory.allProducts) {
                    if (product.getAllAssociatedParts() == selectedPart) {
                        product.deleteAssociatedPart(selectedPart);
                        product.getAllAssociatedParts().set(index, selectedPart);
                    }
/*                        System.out.println("Index: " + index + " Product ID: " + selectedProduct.getId());  //test
                        getAllProducts().set((index - 1), selectedProduct);
                        System.out.println("Index: " + index + " Prooduct ID: " + selectedProduct.getId());  //test
                        System.out.println("Product Update Complete");
                        return;



                        return;
                    }
                    */
 /*                   if ((part.getId() == selectedPart.getId()) && sameId >= 1) {
                        allParts.remove(index);

  */
/*
                }
                System.out.println("Part Update Failed");
            }
            */
        }
    public static void updateProduct(int index, Product selectedProduct) {
        for (Product product : allProducts) {
            if (product.getId() == selectedProduct.getId()) {
                allProducts.set(index, selectedProduct);
                System.out.println("Product Update Complete");
                return;
            }
        }
        System.out.println("Product Update Failed");
    }
/*        for (Product product : getAllProducts()) {
            if (product.getId() == selectedProduct.getId()) {
                System.out.println("Index: " + index + " Product ID: " + selectedProduct.getId());  //test
                getAllProducts().set((index - 1), selectedProduct);
                System.out.println("Index: " + index + " Prooduct ID: " + selectedProduct.getId());  //test
                System.out.println("Product Update Complete");
                return;
            }
        }
        System.out.println("Product Update Failed");
    }

 */
    public static boolean deletePart(Part selectedPart) {
        for (Part part : allParts) {
            if (part.getId() == selectedPart.getId()) {
                allParts.remove(part);
                System.out.println("Part Delete Complete");
                return true;
            }
        }
        System.out.println("Part Delete Failed");
        return false;
    }
    public static boolean deleteProduct(Product selectedProduct) {
        for (Product product : allProducts) {
            if (product.getId() == selectedProduct.getId()) {
                allProducts.remove(product);

                System.out.println("Product Delete Complete");
                return true;
            }
        }
        System.out.println("Product Delete Failed");
        return false;
    }
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
