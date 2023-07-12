package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Book{
    private String id;
    private String title;
    private String author;
    private int publicationyear;
    private String nxb;
    private long price;

public static ArrayList<Book> b = new ArrayList<>();


    public Book() {
    }

    public Book(String id,String title, String author, int publicationyear, String nxb, long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.nxb = nxb;
        this.price = price;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return "Book{" +"id = '"+id+
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationyear='" + publicationyear + '\'' +
                ", nxb='" + nxb + '\'' +
                ", price=" + price +
                '}';
    }

}