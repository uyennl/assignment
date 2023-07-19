package model;

import java.util.ArrayList;
import java.util.Calendar;

public class BorrowCard {
    private User users;
    private Book books;
    private Borrowing broBorrowings;
    public static ArrayList<BorrowCard> brcs = new ArrayList<>();

    public BorrowCard(User users, Book books, Borrowing broBorrowings) {
        this.users = users;
        this.books = books;
        this.broBorrowings = broBorrowings;
    }

    public BorrowCard(User users) {
        this.users = users;
    }

    public BorrowCard(Book books) {
        this.books = books;
    }

    public BorrowCard(Borrowing broBorrowings) {
        this.broBorrowings = broBorrowings;
    }

    public BorrowCard() {
    }


    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public Borrowing getBroBorrowings() {
        return broBorrowings;
    }

    public void setBroBorrowings(Borrowing broBorrowings) {
        this.broBorrowings = broBorrowings;
    }

    @Override
    public String toString() {
        return "BorrowCard{" +
                "users=" + users +
                ", books=" + books +
                ", broBorrowings=" + broBorrowings +
                '}';
    }
}
