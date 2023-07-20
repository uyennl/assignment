package view;

import java.util.Scanner;

import control.BookManagement;

public class ManagementWarehouseView {

    public static void menuBook() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("------ Menu -------");
            System.out.println("1. Tìm kiếm sách bằng ID");
            System.out.println("2. Tìm kiếm sách bằng Tác giả");
            System.out.println("3. Cập nhật thông tin sách");
            System.out.println("4. Kiểm tra tình trạng sách");
            System.out.println("5. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    BookManagement.searchBookById();
                    break;
                case 2:
                    BookManagement.searchBookByAuthor();
                    break;
                case 3:
                    BookManagement.updateBooksToFile();
                    break;
                case 4:
                    BookManagement.checkBookAvailability();
                    break;
                case 5:
                    System.out.println("Đã thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại");
            }
        }
    }

}
