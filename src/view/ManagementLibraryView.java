package view;

import control.*;

public class ManagementLibraryView extends Menu {
    public ManagementLibraryView() {
    }

    public ManagementLibraryView(String title, String[] option) {
        super(title, option);
    }

    @Override
    public boolean execute(int choice) {
        switch (choice) {
            case 1:
                ManagementUserView.showMenu();
                break;
            case 2:
                ManagementBorrowing.menuBorw.run();
                break;
            case 3:
                ManagementWarehouseView.menuBook();
                break;
            case 4:
                return true;
            default:
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        BookManagement bm = new BookManagement();
        BorrowCardManagement brc = new BorrowCardManagement();
        BorrowingManagement br = new BorrowingManagement();
        UserManagement um = new UserManagement();
        bm.readFileBook();
        brc.readFileBorrow();
        br.readFileBorrowing();
        um.readFileUser();
        ManagementLibraryView menu = new ManagementLibraryView("Library Management\n--------------------", new String[]{"User Management", "Borrowing Management", "Warehouse Management", "Exit"});
        menu.run();

    }
}

