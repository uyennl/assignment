package control;

import model.*;
import util.CheckInput;
import util.Validator;



public class BorrowCardManagement {


    public static void addBorrowCard() {
        String idUser = CheckInput.enterString("Mời nhập mã đọc giả ", Validator.REGEX_USER_ID);
        String idLib = CheckInput.enterString("Mời nhập mã thủ thư ", Validator.REGEX_LIBRARIAN);
        String idBook = CheckInput.enterString("Mời nhập mã sách ");
        BorrowingManagement.addBorrowing();

    }
}
