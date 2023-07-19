package control;

import model.*;
import util.CheckInput;
import util.Validator;

import java.util.ArrayList;
import java.util.function.Predicate;


public class BorrowCardManagement {
    public ArrayList<Book> searchB(Predicate<Book> p) {
        ArrayList<Book> cs = new ArrayList<>();
        for (Book b : Book.bs) {
            if (p.test(b)) {
                cs.add(b);
            }
        }
        return cs;
    }
    public ArrayList<User> searchU(Predicate<User> p) {
        ArrayList<User> us = new ArrayList<>();
        for (User u : User.uss) {
            if (p.test(u)) {
                us.add(u);
            }
        }
        return us;
    }
    public ArrayList<BorrowCard> searchBC(Predicate<BorrowCard> p) {
        ArrayList<BorrowCard> brc = new ArrayList<>();
        for (BorrowCard bc : BorrowCard.brcs ) {
            if (p.test(bc)) {
                brc.add(bc);
            }
        }
        return brc;
    }
    public  void addBook(){
        String idUser = CheckInput.enterString("Mời nhập mã đọc giả ", Validator.REGEX_USER_ID);
        ArrayList<User> searchU = searchU(i -> i.getId().equals(idUser));
        ArrayList<BorrowCard> searchBC = searchBC(i->i.getUsers().equals(searchU));
        searchBC.
        ArrayList<Book> searchB = searchB(i->i.getId().equals(searchBC));
        if(){

        }
        if (searchU.isEmpty()) {
            BorrowCard brc = new BorrowCard(UserManagement.addUser(),BookManagement.addBook(),BorrowingManagement.addBorrowing());
            BorrowCard.brcs.add(brc);
        } else {
            if(searchB.isEmpty()){
                BorrowCard brc = new BorrowCard(searchU.get(0),BookManagement.addBook(),BorrowingManagement.addBorrowing());
                BorrowCard.brcs.add(brc);
            }
           else {
                System.out.println("Bạn chưa trả sách");
                searchB.forEach(i-> System.out.println(i.bookBR()));
                System.out.println("Trả sách đi rồi cho mượn");
            }
        }

    }


}
