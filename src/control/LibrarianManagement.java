package control;

import model.Librarian;
import util.CheckInput;
import util.Validator;

import java.util.Calendar;

public class LibrarianManagement {
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

}
