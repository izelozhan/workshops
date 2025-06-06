package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;

    public static void main(String[] args) {
        Book[] books = prepareData();
        while (!exit) {
            getUserAction(books);
        }
    }

    static Book[] prepareData() {
        Book[] books = new Book[20];
        String isbnPrefix = "123456789";
        String[] bookNames = {
                "The Lord of the Rings",
                "The Hobbit",
                "Harry Potter and the Sorcerer's Stone",
                "A Game of Thrones",
                "To Kill a Mockingbird",
                "1984",
                "Pride and Prejudice",
                "The Great Gatsby",
                "Moby Dick",
                "The Catcher in the Rye",
                "Brave New World",
                "The Chronicles of Narnia",
                "Jane Eyre",
                "Wuthering Heights",
                "Fahrenheit 451",
                "The Kite Runner",
                "The Hunger Games",
                "The Alchemist",
                "The Da Vinci Code",
                "Life of Pi"
        };
        for (int i = 0; i < bookNames.length; i++) {
            books[i] = new Book(i, isbnPrefix + i, bookNames[i], false, "");
        }
        return books;
    }

    static int displayHomeScreen() {
        System.out.println("\nSelect one of the following options:");
        System.out.println("\t1) Show Available Books");
        System.out.println("\t2) Show Checked Out Books");
        System.out.println("\t3) Exit Program");
        System.out.print("Entered: ");

        int input;
        return input = Integer.parseInt(scanner.nextLine());
    }
    static void getUserAction(Book[] books) {
        displayHomeScreen();
        int action = displayHomeScreen();
        if (action == 3) { //exit
            exit = true;
        } else if (action == 1) {
            showAvailableBooks(books);
        } else {
            showCheckedOutBooks(books);
        }
    }
    static void showAvailableBooks(Book[] books) {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }
    static void showCheckedOutBooks(Book[] books) {
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println(book);
            }
        }
    }




}
