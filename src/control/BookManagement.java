package control;

import model.Book;
import util.CheckInput;
import util.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class BookManagement {
    private List<Book> books;

    public BookManagement() {
        this.books = new ArrayList<>();
    }

    public static Book addBook() {
        System.out.println("Nhập thông tin sách ");
        String id = CheckInput.enterString("Mời nhập mã sách");
        String type = CheckInput.enterString("Mời nhập thể loại sách", Validator.REGEX_FULL_NAME_VN);
        String title = CheckInput.enterString("Mời nhập tên sách");
        String author = CheckInput.enterDate("Mời nhập tên tác giả");
        int publicationyear = CheckInput.enterInt("Mời nhập năm xuất bản", false);
        String nxb = CheckInput.enterString("Mời nhập nxb");
        long price = CheckInput.enterLong("Mời nhập giá sách", true);
        Book bk = new Book(id,type, title, author, publicationyear, nxb, price);
        Book.bs.add(bk);
        return bk;
    }

    public void searchByCriteria(Predicate<Book> criteria) {
        List<Book> informationSearch = new ArrayList<>();
        for (Book book : books) {
            if (criteria.test(book)) {
                informationSearch.add(book);
            }
        }
        if (informationSearch.isEmpty()) {
            System.out.println("Cannot find any information!");
        } else {
            System.out.println("=======Information Search=======");
            informationSearch.forEach(System.out::println);
        }
    }

    public void findByID(String id) {
        Predicate<Book> criteria = book -> book.getId().equalsIgnoreCase(id);
        searchByCriteria(criteria);
    }

    public void findByTitle(String title) {
        Predicate<Book> criteria = book -> book.getTitle().equalsIgnoreCase(title);
        searchByCriteria(criteria);
    }

    public void findByAuthor(String author) {
        Predicate<Book> criteria = book -> book.getAuthor().equalsIgnoreCase(author);
        searchByCriteria(criteria);
    }

    public void findByNXB(String nxb) {
        Predicate<Book> criteria = book -> book.getNxb().equalsIgnoreCase(nxb);
        searchByCriteria(criteria);
    }

    public void findByPublicationYear(int year) {
        Predicate<Book> criteria = book -> book.getPublicationyear() == year;
        searchByCriteria(criteria);
    }

    public void deleteBook(String id) {
        books.removeIf(book -> book.getId().equalsIgnoreCase(id));
    }

    public void sortById() {
        books.sort(Comparator.comparing(Book::getId));
    }

    public void sortByPublicationYear() {
        books.sort(Comparator.comparingInt(Book::getPublicationyear));
    }

    public void updateBook(String id) {
        Book bookToUpdate = null;
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate != null) {
            // Prompt the user to enter the updated information for the book
            String title = CheckInput.enterString("Mời nhập tên sách mới");
            String author = CheckInput.enterString("Mời nhập tên tác giả mới");
            int publicationYear = CheckInput.enterInt("Mời nhập năm xuất bản mới", false);
            String nxb = CheckInput.enterString("Mời nhập NXB mới");
            long price = CheckInput.enterLong("Mời nhập giá sách mới", true);

            // Update the book's information
            bookToUpdate.setTitle(title);
            bookToUpdate.setAuthor(author);
            bookToUpdate.setPublicationyear(publicationYear);
            bookToUpdate.setNxb(nxb);
            bookToUpdate.setPrice(price);

            System.out.println("Book information updated successfully!");
        } else {
            System.out.println("Cannot find the book with the provided ID!");
        }
    }
}


