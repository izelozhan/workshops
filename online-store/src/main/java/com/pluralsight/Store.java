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

            switch (userChoice){
                case "1":
                    System.out.println("Display data");
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
}
