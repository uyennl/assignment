package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Book;
import model.Librarian;
import model.User;
import model.Borrowing;

public class ManagementBorrowingView {

    private static  Scanner scanner = new Scanner(System.in);
    private static  Librarian librarian = new Librarian();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Mượn sách");
            System.out.println("2. Trả sách");
            System.out.println("3. Gia hạn mượn");
            System.out.println("4. Tra cứu sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    borrowBook();
                    break;

                case 2:
                    returnBook();
                    break;

                case 3:
                    renewBook();
                    break;

                case 4:
                    searchBook();
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

            System.out.println();
        }
    }

    private static void borrowBook() {
        System.out.print("Nhập tên người mượn: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        System.out.print("Nhập tiêu đề sách: ");
        String bookTitle = scanner.nextLine();
        Book book = new Book(bookTitle);

        Date borrowingDate = readDate("Nhập ngày mượn (ngày/tháng/năm): ");
        Date returnDate = readDate("Nhập ngày trả (ngày/tháng/năm): ");

        librarian.borrowBook(user, book, borrowingDate, returnDate);
    }

    private static void returnBook() {
        System.out.print("Nhập tên người trả sách: ");
        String returnUserName = scanner.nextLine();
        User returnUser = new User(returnUserName);

        System.out.print("Nhập tiêu đề sách cần trả: ");
        String returnBookTitle = scanner.nextLine();
        Book returnBook = new Book(returnBookTitle);

        librarian.returnBook(returnUser, returnBook);
    }

    private static void renewBook() {
        System.out.print("Nhập tên người gia hạn sách: ");
        String renewUserName = scanner.nextLine();
        User renewUser = new User(renewUserName);

        System.out.print("Nhập tiêu đề sách cần gia hạn: ");
        String renewBookTitle = scanner.nextLine();
        Book renewBook = new Book(renewBookTitle);

        Date newReturnDate = readDate("Nhập ngày trả mới (ngày/tháng/năm): ");

        librarian.renewBook(renewUser, renewBook, newReturnDate);
    }

    private static void searchBook() {
        System.out.print("Nhập tiêu đề sách cần tra cứu: ");
        String searchBookTitle = scanner.nextLine();
        librarian.searchBook(searchBookTitle);
    }

    private static Date readDate(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        while (true) {
            System.out.print(message);
            String dateString = scanner.nextLine();
            try {
                Date date = sdf.parse(dateString);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return new Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
            } catch (ParseException e) {
                System.out.println("Ngày tháng không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}
