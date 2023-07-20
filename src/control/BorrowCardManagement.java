package control;

import model.*;
import util.CheckInput;
import util.Validator;

import java.io.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Predicate;


public class BorrowCardManagement {
    private String fileSave="borrowCard.txt";
   static Book b = new Book();
    public static ArrayList<Book> searchB(Predicate<Book> p) {
        ArrayList<Book> cs = new ArrayList<>();
        for (Book b : Book.bs) {
            if (p.test(b)) {
                cs.add(b);
            }
        }
        return cs;
    }
    public static void addWNew(){
        BorrowCard brc = new BorrowCard(UserManagement.addUser(),BookManagement.addBook(),BorrowingManagement.addBorrowing());
        BorrowCard.brcs.add(brc);
        b.borrowBook();
    }

    public static ArrayList<User> searchU(Predicate<User> p) {
        ArrayList<User> us = new ArrayList<>();
        for (User u : User.uss) {
            if (p.test(u)) {
                us.add(u);
            }
        }
        return us;
    }
    public static ArrayList<BorrowCard> searchBC(Predicate<BorrowCard> p) {
        ArrayList<BorrowCard> brc = new ArrayList<>();
        for (BorrowCard bc : BorrowCard.brcs ) {
            if (p.test(bc)) {
                brc.add(bc);
            }
        }
        return brc;
    }    public static  void addBorrowCardWOld(){
        String idUser = CheckInput.enterString("Mời nhập mã đọc giả ", Validator.REGEX_USER_ID);
        ArrayList<User> searchU = searchU(i -> i.getId().equals(idUser));
        ArrayList<BorrowCard> searchBC = searchBC(i->i.getUsers().equals(searchU));
       Calendar returnbook =  searchBC.get(0).getBroBorrowings().getReturnDate();
       Calendar now = Calendar.getInstance();
        ArrayList<Book> searchB = searchB(i->i.getId().equals(searchBC));
        if (searchU.isEmpty()) {
            addWNew();
        } else {
            if(returnbook.after(now)){
                BorrowCard brc = new BorrowCard(searchU.get(0),BookManagement.addBook(),BorrowingManagement.addBorrowing());
                BorrowCard.brcs.add(brc);
                b.borrowBook();
            }
           else {
                System.out.println("Bạn chưa trả sách");
                searchB.forEach(i-> System.out.println(i.bookBR()));
                System.out.println("Hạn Trả là: " + returnbook );
                System.out.println("Trả sách đi rồi cho mượn");
            }
        }

    }
    public void saveFileBorrow(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileSave))) {
            for (BorrowCard card : BorrowCard.brcs ){
                writer.write( card.getUsers()+", "+ card.getBooks() +", "+ card.getBroBorrowings());
                writer.newLine();
            }
            System.out.println("Save File Done!");
        }catch (IOException e){
            System.out.println("Save File Found!");
            e.printStackTrace();
        }
    }
    public void readFileBorrow() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSave))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String idBook = data[0];
                    String type = data[1];
                    String title = data[2];
                    String idUser = data[3];
                    String nameUser = data[4];
                    String dayBorrowstr = data[5].trim();
                    SimpleDateFormat dateBorrowfm = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar dayBorrow = Calendar.getInstance();
                    String dayReuturnstr = data[6].trim();
                    SimpleDateFormat dateReturnfm = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar dayReturn = Calendar.getInstance();
                    Book book = new Book(idBook,type,title);
                    User user = new User(idUser,nameUser);
                    Borrowing borrow = new Borrowing(dayBorrow,dayReturn);
                    BorrowCard borrowCard = new BorrowCard(user,book,borrow);
                    BorrowCard.brcs.add(borrowCard);
                }
            }
            System.out.println("Read File Done!");
        } catch (IOException e) {
            System.out.println("Read File Error!");
            e.printStackTrace();
        }
    }

}
