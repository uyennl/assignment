package control;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.Book;
import util.CheckInput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookManagement {
    private List<Book> b;



    public void addBook() {
        String id = CheckInput.enterString("Mời nhập mã sách");
        String title = CheckInput.enterString("Mời nhập tên sách");
        String author = CheckInput.enterDate("Mời nhập tên tác giả");
        int publicationyear = CheckInput.enterInt("Mời nhập năm xuất bản", false);
        String nxb = CheckInput.enterString("Mời nhập nxb");
        long price = CheckInput.enterLong("Mời nhập giá sách", true);
        Book bk = new Book(id, title, author, publicationyear, nxb, price);
        Book.b.add(bk);
    }

    public void searchByCriteria(Predicate<Book> criteria) {
        List<Book> informationSearch = new ArrayList<>();
        for (Book book : b) {
            if (criteria.test(book)) {
                informationSearch.add(book);
            }
        }
        if (informationSearch.isEmpty()) {
            System.out.println("Cannot find any information!");
        } else {
            System.out.println("=======Information Search=======");
           informationSearch.forEach(b-> System.out.println(b));
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
    public void findByPublicationYear( int year) {
        Predicate<Book> criteria = book -> Integer.toString(book.getPublicationyear()).equals(Integer.toString(year));
        searchByCriteria(criteria);
    }
}
