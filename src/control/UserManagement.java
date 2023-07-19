package control;

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
                    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dateOfBirth = LocalDate.parse(birthStr, dateFormat);
                    // Chuyển đổi LocalDate thành Calendar
                    Calendar birth = Calendar.getInstance();
                    birth.set(dateOfBirth.getYear(), dateOfBirth.getMonthValue() - 1, dateOfBirth.getDayOfMonth());
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




