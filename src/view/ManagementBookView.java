package view;

import java.io.*;
import java.util.Scanner;
import model.Book;

public class ManagementBookView {
    public static void searchBookById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sách cần tìm kiếm: ");
        String id = scanner.nextLine();

        for (Book book : Book.b) {
            if (book.getId().equals(id)) {
                System.out.println("Thông tin sách:");
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Publication Year: " + book.getPublicationyear());
                System.out.println("NXB: " + book.getNxb());
                System.out.println("Price: " + book.getPrice());
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID " + id);
    }

    public static void searchBookByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập Tác giả của sách cần tìm kiếm: ");
        String author = scanner.nextLine();

        boolean found = false;
        for (Book book : Book.b) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Thông tin sách:");
                System.out.println("ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Publication Year: " + book.getPublicationyear());
                System.out.println("NXB: " + book.getNxb());
                System.out.println("Price: " + book.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách của tác giả " + author);
        }
    }

    public static void updateBooksToFile() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập ID sách muốn cập nhật: ");
            String id = scanner.nextLine();

            File file = new File("src/data/kho.txt");
            File tempFile = new File("src/data/kho_temp.txt");
            PrintWriter writer = new PrintWriter(tempFile);

            for (Book book : Book.b) {
                if (book.getId().equals(id)) {
                    System.out.println("Nhập thông tin mới cho sách:");
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume the newline left by nextInt()

                    book.setAuthor(author);
                    book.setPrice((int) price);
                    book.setQuantity(quantity);

                    System.out.println("Đã cập nhật thông tin sách có ID " + id);
                }

                writer.println(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," +
                        book.getPublicationyear() + "," + book.getNxb() + "," + book.getPrice() + "," + book.getQuantity());
            }

            writer.close();
            boolean successful = tempFile.renameTo(file);

            if (successful) {
                System.out.println("Đã cập nhật và lưu danh sách vào file " + file.getAbsolutePath());
            } else {
                System.out.println("Lỗi: Không thể cập nhật danh sách sách");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file");
        }
    }

    public static void checkBookAvailability() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sách cần kiểm tra: ");
        String id = scanner.nextLine();

        for (Book book : Book.b) {
            if (book.getId().equals(id)) {
                if (book.getQuantity() > 0) {
                    System.out.println("Sách còn trong kho");
                } else {
                    System.out.println("Sách đã hết trong kho");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ID " + id);
    }

    public static void searchCustomer(String[] args) {
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
                    searchBookById();
                    break;
                case 2:
                    searchBookByAuthor();
                    break;
                case 3:
                    updateBooksToFile();
                    break;
                case 4:
                    checkBookAvailability();
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
