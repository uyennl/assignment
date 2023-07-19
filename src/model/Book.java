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
    private String type;
    private int quantity;
    private boolean borrowed;
    public static ArrayList<Book> bs = new ArrayList<>();


    public Book() {
    }

    public Book(String id,String type, String title, String author, int publicationyear, String nxb, long price) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.nxb = nxb;
        this.price = price;
    }

    public Book(String title) {
        this.title = title;
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
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<Book> getBs() {
        return bs;
    }

    public static void setBs(ArrayList<Book> bs) {
        Book.bs = bs;
    }

    public void renewBook(String newTitle) {
        this.title = newTitle;
        System.out.println("Gia hạn thành công. Tiêu đề sách mới: " + this.title);
    }

    public static Book getBook(ArrayList<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Book{" + "id = '" + id +"type = '"+type+
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationyear='" + publicationyear + '\'' +
                ", nxb='" + nxb + '\'' +
                ", price=" + price +
                '}';
    }
    public String bookBR(){
        return "Book{" + "id = '" + id +
                    '}';
    }

}
