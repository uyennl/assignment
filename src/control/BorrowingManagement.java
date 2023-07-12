package control;

import util.CheckInput;

import java.util.Calendar;

public class BorrowingManagement {
    public static void addBorrowing() {
        Calendar borrowDate = CheckInput.enterDate("Mời nhập ngày mượn(dd/MM/yy)", "dd/MM/yy");
        Calendar borrowReturn = CheckInput.enterDate("Mời nhập ngày trả(dd/MM/yy)", "dd/MM/yy");
    }

}
