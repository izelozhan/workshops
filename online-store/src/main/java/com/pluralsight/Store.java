package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/main/resources/products.csv";
        HashMap<String, Product> productData = new HashMap<>();

        //load productData
        loadProducts(filePath, productData);

        boolean exit = false;

        System.out.println("Welcome to our Workshop-3 Online Shop!");

        while (!exit) {
            System.out.println("How do you want to start?");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.println("Display data");
                    displayProducts(productData);
                    searchProduct(productData, scanner);

                    break;
                case "2":
                    System.out.println("Display cart");
                    break;
                case "3":
                    exit = true;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Please try again.");
            }

        }
    }

    private static void loadProducts(String filePath, HashMap<String, Product> productData) {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader buffReader = new BufferedReader(fileReader);

            String readProducts;

            while ((readProducts = buffReader.readLine()) != null) {
                String[] productParts = readProducts.split("\\|");

                if (productParts[0].equalsIgnoreCase("sku")) {
                    continue;
                }

                String sku = productParts[0];
                String name = productParts[1];
                double price = Double.parseDouble(productParts[2]);
                String department = productParts[3];

                Product newProduct = new Product(sku, name, price, department);
                productData.put(name, newProduct);
            }
            fileReader.close();
            buffReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayProducts(HashMap<String, Product> productData) {
        //header
        // \t\t is for tabs one \t is one tab
        System.out.println("PRODUCT LIST");
        System.out.println("SKU\t|\tName\t|\tPrice\t|\tDepartment");
        //print each product with the same format
        for (Product product : productData.values()) {
            System.out.println(product.sku + "|" + product.name + "|" + product.price + "|" + product.department);
        }

    }

    private static void searchProduct(HashMap<String, Product> productData, Scanner scanner) {
        System.out.println("Which product are you looking for?");
        String searchString = scanner.nextLine().trim();

        //if user enters price as string, need to convert to double
        double searchPrice = Double.parseDouble(searchString);

        //user be able to search by name, price or department
        for(Product product : productData.values()){
            String name = product.name.trim();
            double price = product.price;
            String department = product.department.trim();

            if (name.equalsIgnoreCase(searchString) || department.equalsIgnoreCase(searchString)){
                System.out.println("Your searched matches these products; ");
                System.out.println(product.sku + "|" + product.name + "|" + product.price + "|" + product.department);
            }
        }
    }

}
