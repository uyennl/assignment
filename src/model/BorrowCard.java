package model;

import java.util.ArrayList;

public class BorrowCard {
    private User user;
    private  Book book;
    private ArrayList<Borrowing> borrow;
    public static ArrayList<BorrowCard> brw = new ArrayList<>();

    public BorrowCard(User user, Book book, ArrayList<Borrowing> borrow) {
        this.user = user;
        this.book = book;
        this.borrow = borrow;
    }

    public BorrowCard() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static ArrayList<BorrowCard> getBrw() {
        return brw;
    }

    public static void setBrw(ArrayList<BorrowCard> brw) {
        BorrowCard.brw = brw;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Borrowing> getBorrow() {
        return borrow;
    }

    public void setBorrow(ArrayList<Borrowing> borrow) {
        this.borrow = borrow;
    }

    @Override
    public String toString() {
        return "BorrowCard{" +
                "user=" + user +
                ", book=" + book +
                ", borrow=" + borrow +
                '}';
    }
}
