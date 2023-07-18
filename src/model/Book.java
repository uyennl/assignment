package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Book {
    private String id;
    private String title;
    private String author;
    private int publicationyear;
    private String nxb;
    private long price;
    private int quantity;

    public static ArrayList<Book> b = new ArrayList<>();

    public Book() {
    }

    public Book(String id, String title, String author, int publicationyear, String nxb, long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.nxb = nxb;
        this.price = price;
    }

    public Book(String id, String title, String author, int publicationyear, String nxb, long price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.nxb = nxb;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static ArrayList<Book> getB() {
        return b;
    }

    public static void setB(ArrayList<Book> b) {
        Book.b = b;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(int publicationyear) {
        this.publicationyear = publicationyear;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isBorrowed() {
        // Implement the logic to check if the book is borrowed
        // Return true if the book is currently borrowed, false otherwise
        // You can implement this based on your requirements
        // For example, you can add a new property 'borrowed' in Book class and set it accordingly when a book is borrowed or returned.
        // For now, it will always return false since we don't have the logic to track book borrowing in this code snippet.
        return false;
    }

    @Override
    public String toString() {
        return "Book{" + "id = '" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationyear='" + publicationyear + '\'' +
                ", nxb='" + nxb + '\'' +
                ", price=" + price +
                '}';
    }
}
