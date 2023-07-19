package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Library {

    public Library() {
    }

    public void borrowBook(User user, Book book, Calendar borrowingDate, Calendar returnDate) {
        if (book.isBorrowed()) {
            System.out.println("Sách đã được mượn.");
        } else {
            book.setBorrowed(true);
            System.out.println("Sách '" + book.getTitle() + "' đã được mượn bởi " + user.getName());
            System.out.println("Ngày mượn: " + borrowingDate.get(Calendar.DAY_OF_MONTH) + "/" + (borrowingDate.get(Calendar.MONTH) + 1) + "/" + borrowingDate.get(Calendar.YEAR));
            System.out.println("Ngày trả: " + returnDate.get(Calendar.DAY_OF_MONTH) + "/" + (returnDate.get(Calendar.MONTH) + 1) + "/" + returnDate.get(Calendar.YEAR));
            new BorrowCard(user, book, borrowingDate, returnDate); // Create a new borrowing record

        }
    }

    public void returnBook(User user, Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println("Sách '" + book.getTitle() + "' đã được trả bởi " + user.getName());
        } else {
            System.out.println("Sách không được mượn.");
        }
    }



}
