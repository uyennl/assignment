package control;

import model.*;
import java.util.ArrayList;

public class LibraryManagement {
    public static Book searchByTitle(String title) {
        for (Book book : Book.bs) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book searchById(String id) {
        for (Book book : Book.bs) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public static ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : Book.bs) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

}








