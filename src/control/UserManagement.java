package control;

import model.User;
import util.CheckInput;
import util.Validator;

import java.util.Calendar;

public class UserManagement {
    public void addUser() {
        String id = CheckInput.enterString("Mời nhập mã đọc giả", Validator.REGEX_USER_ID, (idStr) -> {
            for (User u : User.arrus) {
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
        User.arrus.add(u);
    }
}
