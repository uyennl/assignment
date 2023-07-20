package view;

import control.UserManagement;

import java.util.Scanner;

public class ManagementUserView {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n-----------------");
            System.out.println("Menu Quản lý người dùng:");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Tìm kiếm người dùng theo ID");
            System.out.println("4. Tìm kiếm người dùng theo Tên");
            System.out.println("5. Tìm kiếm người dùng có sách quá hạn chưa trả");
            System.out.println("6. Thoát");
            System.out.print("Chọn một tác vụ (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    UserManagement.addUser();
                    break;
                case 2:
                    UserManagement.deleteUser();
                    break;
                case 3:
                    UserManagement.searchUserByID();
                    break;
                case 4:
                    UserManagement.searchUserByName();
                    break;
                case 5:
                    UserManagement.searchOver();
                    break;
                case 6:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}
