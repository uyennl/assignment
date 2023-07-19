package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Borrowing {
    private Calendar borrowingDate;
    private Calendar returnDate;
    public static ArrayList<Borrowing> brs = new ArrayList<>();

    public Borrowing() {
    }


    public Borrowing(Calendar borrowingDate, Calendar returnDate) {
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }



    public Calendar getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Calendar borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
