package view;

import control.LibraryManagement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Book;

public class ManagementBookView {
    public String checkAuthor(Scanner input) {
        String author;
        do {
            author = input.nextLine().trim();
            if (author.isEmpty() || containsDigit(author)) {
                System.out.print("Author cannot be empty, please enter a valid Author: ");
            } else {
                break;
            }
        } while (true);
        return author;
    }

    private boolean containsDigit(String author) {
        for (char c : author.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public void searchCustomer() {
        Scanner scanner = new Scanner(System.in);
        boolean tiepTuc = true;
        while (tiepTuc){
            System.out.println("    Books");
            System.out.println("-------------------------");
            System.out.println("1. Search by ID ");
            System.out.println("2. Search by Author");
            System.out.println("3. Update");
            System.out.println("4. Exit");
            System.out.println("---------------------------");
            System.out.print("Enter selection: ");
            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    System.out.print("Enter ID: ");
                    String ID = scanner.nextLine();

                    Book book = LibraryManagement.searchById(ID);
                    if (book != null) {
                        System.out.println("List of Books");
                        System.out.println("-------------------------");
                        System.out.println(ID);
                        System.out.println("-------------------------");
                        System.out.println("Total: 1 Book");
                    } else {
                        System.out.println("No book found!");
                    }
                    break;
                case "2":
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    ArrayList<Book> foundBooks = LibraryManagement.searchByAuthor(author);
                    if (!foundBooks.isEmpty()) {
                        System.out.println("List of Books");
                        System.out.println("-------------------------");
                        for (Book foundBook : foundBooks) {
                            System.out.println(foundBook);
                        }
                        System.out.println("-------------------------");
                        System.out.println("Total: " + foundBooks.size() + " Book");
                    } else {
                        System.out.println("No book found!");
                    }
                    break;
                case "3":
                    updateBook();
                    break;
                case "4":
                    tiepTuc = false;
                    System.out.println("Application exited.");
                    break;
                default:
                    System.out.println("Invalid choice!Please choose again.");
            }
        }
    }

    public void updateBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID to update information: ");
        String ID = scanner.nextLine();
        Book bookToUpdate = LibraryManagement.searchById(ID);
        if (bookToUpdate != null) {
            System.out.println("Current Book information: ");
            System.out.println(bookToUpdate);
            System.out.print("Enter new Author: ");
            String newAuthor = checkAuthor(scanner);

            // Cập nhật thông tin sách
            bookToUpdate.setAuthor(newAuthor);

            // Lưu thông tin sách vào file
            if (saveBookToFile(bookToUpdate)) {
                System.out.println("Successfully updated book information.");
            } else {
                System.out.println("Failed to update book information.");
            }
        } else {
            System.out.println("No book found.");
        }
    }

    private boolean saveBookToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src//data//kho.txt", true))) {
            writer.write(book.getId() + ";" + book.getTitle() + ";" + book.getAuthor() + ";" + book.getPublicationyear() + ";" +  book.getNxb() + ";" +  book.getPrice() + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
