package control;

import model.Book;
import util.CheckInput;

public class BookManagement {
    public void addBook() {
        String id = CheckInput.enterString("Mời nhập mã sách");
        String title = CheckInput.enterString("Mời nhập tên sách");
        String author = CheckInput.enterDate("Mời nhập tên tác giả");
        int publicationyear = CheckInput.enterInt("Mời nhập năm xuất bản", false);
        String nxb = CheckInput.enterString("Mời nhập nxb");
        long price = CheckInput.enterLong("Mời nhập giá sách", true);
        int quantity = CheckInput.enterInt("Mời nhập số lượng sách",true);
        Book bk = new Book(id, title, author, publicationyear, nxb, price,quantity);
        Book.b.add(bk);
    }
}
