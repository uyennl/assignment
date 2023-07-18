package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Book;
public class Librarian extends Person {
    private String password;
    public static ArrayList<Librarian> arrlb = new ArrayList<>();

    public Librarian(String id, String name, int age, String sex, String phone, Calendar birth, String password) {
        super(id, name, age, sex, phone, birth);
        this.password = password;
    }

    public Librarian(String id, String name, int age, String sex, String phone, Calendar birth) {
        super(id, name, age, sex, phone, birth);
    }

    public Librarian() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void borrowBook(User user, Book book, Date borrowingDate, Date returnDate) {
        if (book.isBorrowed()) {
            System.out.println("Sách đã được mượn.");
        } else {
            book.setBorrowed(true);
            System.out.println("Sách '" + book.getTitle() + "' đã được mượn bởi " + user.getName());
            System.out.println("Ngày mượn: " + borrowingDate.getDay() + "/" + borrowingDate.getMonth() + "/" + borrowingDate.getYear());
            System.out.println("Ngày trả: " + returnDate.getDay() + "/" + returnDate.getMonth() + "/" + returnDate.getYear());
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

    public void renewBook(User user, Book book, Date newReturnDate) {
        if (book.isBorrowed()) {
            System.out.println("Sách '" + book.getTitle() + "' đã được gia hạn bởi " + user.getName());
            System.out.println("Ngày trả mới: " + newReturnDate.getDay() + "/" + newReturnDate.getMonth() + "/" + newReturnDate.getYear());
        } else {
            System.out.println("Sách không được mượn.");
        }
    }

    public void searchBook(String title) {
        ArrayList<Book> books = Book.b;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Tìm thấy sách có tiêu đề '" + title + "':");
                System.out.println(book);
                return;
            }
        }
        System.out.println("Không tìm thấy sách có tiêu đề '" + title + "'.");
    }



    @Override
    public String toString() {
        return "Librarian{"+super.toString() +
                "password='" + password + '\'' +
                '}';
    }
}






