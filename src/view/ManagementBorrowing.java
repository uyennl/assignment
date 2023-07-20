package view;

import control.BorrowCardManagement;
import control.BorrowingManagement;

public class ManagementBorrowing extends Menu{
    public ManagementBorrowing() {
    }

    public ManagementBorrowing(String title, String[] option) {
        super(title, option);
    }
    BorrowingManagement brm = new BorrowingManagement();
    @Override
    public boolean execute(int choice) {
        switch (choice) {
            case 1:
                BorrowCardManagement.addWNew();
                break;
            case 2:
BorrowCardManagement.addBorrowCardWOld();
                break;
            case 3:
                brm.returnBook();
                break;
            case 4:
                return true;

            default:
                break;
        }
        return false;
    }
   public static Menu menuBorw = new Menu("Borrowing Management\n--------------------", new String[]{"Add Borrow Card With New User","Add Borrow Card With old User", "Return Book", "Exit"}) {
        @Override
        public boolean execute(int choice) {
            return false;
        }
    };


}
