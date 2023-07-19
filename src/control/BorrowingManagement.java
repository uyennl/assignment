package control;

import model.Book;
import model.BorrowCard;
import model.Borrowing;
import util.CheckInput;

import java.util.ArrayList;
import java.util.Calendar;

public class BorrowingManagement {
    ArrayList<Borrowing> brw = new ArrayList<>();
    public static Borrowing addBorrowing() {
        Calendar borrowDate = CheckInput.enterDate("Mời nhập ngày mượn(dd/MM/yy)", "dd/MM/yy");
        Calendar borrowReturn = CheckInput.enterDate("Mời nhập ngày trả(dd/MM/yy)", "dd/MM/yy");
        Borrowing brw = new Borrowing(borrowDate,borrowReturn);
        Borrowing.brs.add(brw);
        return brw;
    }

}
