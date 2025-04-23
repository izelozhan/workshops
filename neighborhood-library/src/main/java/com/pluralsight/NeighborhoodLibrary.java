package com.pluralsight;

public class NeighborhoodLibrary {


    public static void main(String[] args) {
        Book[] books = prepareData();

        boolean exit = false;
        while(!exit) {
            displayHomeScreen();
            int action = getUserAction();
            if (action == 3) { //exit
                exit = true;
            } else if (action == 1) {
                showAvailableBooks(books);
            } else {
                showCheckedOutBooks(books);
            }
        }
    }

    static void showCheckedOutBooks(Book[] books) {

    }

    static void showAvailableBooks(Book[] books) {

    }

    static void displayHomeScreen() {

    }

    static int getUserAction() {

        int option = 0;

        //option al
        //exit ise uygulamadan cik

        return option;

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
}
