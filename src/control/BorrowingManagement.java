package control;

import model.*;
import util.CheckInput;
import util.Validator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BorrowingManagement {
    private String fileSave="borrowing.txt";
    BookManagement bm = new BookManagement();
    public static Borrowing addBorrowing() {
        Calendar borrowDate = CheckInput.enterDate("Mời nhập ngày mượn(dd/MM/yy)", "dd/MM/yy");
        Calendar borrowReturn = CheckInput.enterDate("Mời nhập ngày trả(dd/MM/yy)", "dd/MM/yy");
        Borrowing brw = new Borrowing(borrowDate,borrowReturn);
        Borrowing.brs.add(brw);
        return brw;
    }
    public void readFileBorrowing() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSave))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String dayBorrowstr = data[0].trim();
                    SimpleDateFormat dateBorrowfm = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar dayBorrow = Calendar.getInstance();
                    String dayReuturnstr = data[1].trim();
                    SimpleDateFormat dateReturnfm = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar dayReturn = Calendar.getInstance();
                }
            }
            System.out.println("Read File Done!");
        } catch (IOException e) {
            System.out.println("Read File Error!");
            e.printStackTrace();
        }
    }
    public void returnBook() {
        System.out.println("Mời nhập id người dùng");
        String id = CheckInput.enterString("Id User", Validator.REGEX_USER_ID);
        ArrayList<User> searchU = BorrowCardManagement.searchU(i -> i.getId().equals(id));
        ArrayList<BorrowCard> searchBC = BorrowCardManagement.searchBC(i->i.getUsers().equals(searchU));
        ArrayList<Book> searchB = BorrowCardManagement.searchB(i->i.getId().equals(searchBC));
        if(searchB.isEmpty()){
            System.out.println("bạn đã trả sách");
        }
        else{
            while(true){
                System.out.println("Do you want to delete?");
                String a = CheckInput.enterString("(y/n)", Validator.REGEX_QUESTION);
                if (a.equals("y")) {
                    bm.removeBookFromList(searchB.get(0).getId());
                    System.out.println("Delete Customer Success");
                    // Hiển thị danh sách khách hàng còn lại
                }
                else {
                    break;
                }
            }
        }
    }

}
