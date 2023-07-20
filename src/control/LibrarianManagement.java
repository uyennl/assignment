package control;

import model.BorrowCard;
import model.Librarian;
import model.User;
import util.CheckInput;
import util.Validator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class LibrarianManagement {
    private String fileSave="librarian.txt";
    public void addLibrarian() {
        String id = CheckInput.enterString("Mời nhập mã thủ thư", Validator.REGEX_LIBRARIAN, (idStr) -> {
            for (Librarian l : Librarian.lbs) {
                if (l.getId().equals(idStr)) {
                    return true;
                }
            }
            return false;
        });
        String name = CheckInput.enterString("Mời nhập tên của thủ thư", Validator.REGEX_FULL_NAME_VN);
        int age = CheckInput.enterInt("Mời nhập tuổi của thủ thư", true);
        String sex = CheckInput.enterString("Mời nhập giới tính của thủ thư");
        String phone = CheckInput.enterString("Mời nhập số điện thoại của thủ thư", Validator.REGEX_PHONE_NUMBER);
        Calendar birth = CheckInput.enterDate("Ngày sinh của thủ thư (dd/mm/yyyy)", "dd/MM/yyyy");
        String password = CheckInput.enterString("Mới nhập mật khẩu của thủ thư");
        Librarian l = new Librarian(id, name, age, sex, phone, birth, password);
    }

    public void readFileLibrarian() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSave))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String id = data[0];
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String sex = data[3];
                    String phone = data[4];
                    String birthStr = data[5].trim();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar birth = Calendar.getInstance();
                    Librarian lib = new Librarian(id,name,age,sex,phone,birth);
                    Librarian.lbs.add(lib);


                }
            }
            System.out.println("Read File Done!");
        } catch (IOException e) {
            System.out.println("Read File Error!");
            e.printStackTrace();
        }
    }
}





