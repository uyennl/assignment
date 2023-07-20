package control;

import model.Book;
import model.BorrowCard;
import model.User;
import util.CheckInput;
import util.Validator;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import util.CheckInput;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.function.Predicate;

public class UserManagement {
    private String fileSave="Customer.txt";

    public static User  addUser() {
        System.out.println("Nhập Thông tin người mượn");
        String id = CheckInput.enterString("Mời nhập mã đọc giả", Validator.REGEX_USER_ID, (idStr) -> {
            for (User u : User.uss) {
                if (u.getId().equals(idStr)) {
                    return true;
                }
            }
            return false;
        });
        String name = CheckInput.enterString("Mời nhập tên của độc giả", Validator.REGEX_FULL_NAME_VN);
        int age = CheckInput.enterInt("Mời nhập tuổi của độc giả", true);
        String sex = CheckInput.enterString("Mời nhập giới tính của độc giả");
        String phone = CheckInput.enterString("Mời nhập số điện thoại của độc giả", Validator.REGEX_PHONE_NUMBER);
        Calendar birth = CheckInput.enterDate("Ngày sinh của độc giả (dd/mm/yyyy)", "dd/MM/yyyy");
        User u = new User(id, name, age, sex, phone, birth);
        User.uss.add(u);
        return u;
    }
    public static void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID người dùng cần xóa: ");
        String id = scanner.nextLine();

        User userToDelete = null;
        for(User user : User.uss) {
            if(user.getId().equals(id)) {
                userToDelete = user;
                break;
            }
        }

        if(userToDelete != null) {
            User.uss.remove(userToDelete);
            System.out.println("Xóa người dùng thành công!");
        } else {
            System.out.println("Không tìm thấy người dùng có ID " + id);
        }
    }

    public static void searchUserByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID người dùng cần tìm kiếm: ");
        String id = scanner.nextLine();

        boolean found = false;
        for(User user : User.uss) {
            if(user.getId().equals(id)) {
                System.out.println("Tìm thấy người dùng:");
                System.out.println(user.toString());
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Không tìm thấy người dùng có ID " + id);
        }
    }

    public static void searchUserByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên người dùng cần tìm kiếm: ");
        String name = scanner.nextLine();

        boolean found = false;
        for(User user : User.uss) {
            if(user.getName().equalsIgnoreCase(name)) {
                System.out.println("Tìm thấy người dùng:");
                System.out.println(user.toString());
                found = true;
            }
        }

        if(!found) {
            System.out.println("Không tìm thấy người dùng có tên " + name);
        }
    }

    public static void searchOver(){
        String idUser = CheckInput.enterString("Mời nhập mã đọc giả ", Validator.REGEX_USER_ID);
        ArrayList<User> searchU = BorrowCardManagement.searchU(i -> i.getId().equals(idUser));
        ArrayList<BorrowCard> searchBC = BorrowCardManagement.searchBC(i->i.getUsers().equals(searchU));
        Calendar returnbook =  searchBC.get(0).getBroBorrowings().getReturnDate();
        Calendar now = Calendar.getInstance();
        ArrayList<Book> searchB = BorrowCardManagement.searchB(i->i.getId().equals(searchBC));
            if(returnbook.after(now)){
                System.out.println("bạn đã trả sách rồi");
            }
            else {
                System.out.println("Bạn chưa trả sách");
                searchB.forEach(i-> System.out.println(i.bookBR()));
                System.out.println("Hạn Trả là: " + returnbook );
                System.out.println("Trả sách đi rồi cho mượn");
            }


    }
//    public void searchOverdueBooks() {
//        System.out.println("Danh sách người dùng có sách quá hạn chưa trả:");
//        boolean found = false;
//        for(User user : User.uss) {
//            if(user.hasOverdueBooks()) {
//                System.out.println(user.toString());
//                found = true;
//            }
//        }
//
//        if(!found) {
//            System.out.println("Không có người dùng nào có sách quá hạn chưa trả.");
//        }
//    }


    public void saveFileUser(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileSave))) {
            for(User usez: User.uss){
                writer.write(usez.getId()+", "+ usez.getName() +", "+ usez.getAge()+", " +usez.getSex()+ ", "+usez.getPhone()+", "+usez.getBirth() );
                writer.newLine();
            }
            System.out.println("Save File Done!");
        }catch (IOException e){
            System.out.println("Save File Found!");
            e.printStackTrace();
        }
    }
    public void readFileUser() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSave))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String id = data[0];
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String sex = data[3];
                    String phone = data[4];
                    String birthStr = data[5].trim();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar birth = Calendar.getInstance();
                    User user = new User(id, name, age, sex, phone, birth);
                    User.uss.add(user);
                }
            }
            System.out.println("Read File Done!");
        } catch (IOException e) {
            System.out.println("Read File Error!");
            e.printStackTrace();
        }
    }
}




