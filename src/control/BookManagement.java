package control;

import model.Book;
import util.CheckInput;
import util.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class BookManagement {


    public static Book addBook() {
        System.out.println("Nhập thông tin sách ");
        String id = CheckInput.enterString("Mời nhập mã sách",Validator.REGEX_BOOK);
        String type = CheckInput.enterString("Mời nhập thể loại sách", Validator.REGEX_FULL_NAME_VN);
        String title = CheckInput.enterString("Mời nhập tên sách");
        String author = CheckInput.enterDate("Mời nhập tên tác giả");
        int publicationyear = CheckInput.enterInt("Publication Year");
        String nxb = CheckInput.enterString("Mời nhập nxb");
        long price = CheckInput.enterLong("Mời nhập giá sách", true);
        Book bk = new Book(id,type, title, author, publicationyear, nxb, price);
        Book.bs.add(bk);
        return bk;
    }

    public void searchByCriteria(Predicate<Book> criteria) {
        List<Book> informationSearch = new ArrayList<>();
        for (Book book : Book.bs) {
            if (criteria.test(book)) {
                informationSearch.add(book);
            }
        }
        if (informationSearch.isEmpty()) {
            System.out.println("Cannot find any information!");
        } else {
            System.out.println("=======Information Search=======");
            informationSearch.forEach(System.out::println);
        }
    }

    public  void findByID() {
        String id = CheckInput.enterString("Id want to find",Validator.REGEX_BOOK);
        Predicate<Book> criteria = book -> book.getId().equalsIgnoreCase(id);
        searchByCriteria(criteria);
    }

    public void findByTitle() {
        String title = CheckInput.enterString("Title want to find");
        Predicate<Book> criteria = book -> book.getTitle().equalsIgnoreCase(title);
        searchByCriteria(criteria);
    }

    public void findByAuthor() {
        String author = CheckInput.enterString("Author want to find",Validator.REGEX_FULL_NAME_VN);
        Predicate<Book> criteria = book -> book.getAuthor().equalsIgnoreCase(author);
        searchByCriteria(criteria);
    }

    public void findByNXB() {
        String nxb = CheckInput.enterString("NXB");
        Predicate<Book> criteria = book -> book.getNxb().equalsIgnoreCase(nxb);
        searchByCriteria(criteria);
    }

    public void findByPublicationYear() {
        int year = CheckInput.enterInt("Year");
        Predicate<Book> criteria = book -> book.getPublicationyear() == year;
        searchByCriteria(criteria);
    }

    public void deleteBook() {
        String id = CheckInput.enterString("Id want to find",Validator.REGEX_BOOK);
        Book.bs.removeIf(book -> book.getId().equalsIgnoreCase(id));
    }

    public void sortById() {

        Book.bs.sort(Comparator.comparing(Book::getId));
    }

    public void sortByPublicationYear() {
        Book.bs.sort(Comparator.comparingInt(Book::getPublicationyear));
    }

    public static void updateBook(String id) {
        Book bookToUpdate = null;
        for (Book book : Book.bs) {
            if (book.getId().equalsIgnoreCase(id)) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate != null) {
            // Prompt the user to enter the updated information for the book
            String title = CheckInput.enterString("Mời nhập tên sách mới");
            String author = CheckInput.enterString("Mời nhập tên tác giả mới");
            int publicationYear = CheckInput.enterInt("Mời nhập năm xuất bản mới", false);
            String nxb = CheckInput.enterString("Mời nhập NXB mới");
            long price = CheckInput.enterLong("Mời nhập giá sách mới", true);

            // Update the book's information
            bookToUpdate.setTitle(title);
            bookToUpdate.setAuthor(author);
            bookToUpdate.setPublicationyear(publicationYear);
            bookToUpdate.setNxb(nxb);
            bookToUpdate.setPrice(price);

            System.out.println("Book information updated successfully!");
        } else {
            System.out.println("Cannot find the book with the provided ID!");
        }
    }
    public static  void searchBookById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sách cần tìm kiếm: ");
        String id = scanner.nextLine();
        for (Book book : Book.bs) {
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
        for (Book book : Book.bs) {
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

            for (Book book : Book.bs) {
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

        for (Book book : Book.bs) {
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

    private String fileSave="book.txt";


    public void  readFileBook() {
        try (BufferedReader reader = new BufferedReader(new FileReader("book.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    String id = data[0];
                    String type = data[1];
                    String title = data[2];
                    String author = data[3];
                    int publicationYear = Integer.parseInt(data[4]);
                    String nxb  = data[5];
                    long price = Long.parseLong(data[6]);
                    Book book = new Book(id,type,title, author,publicationYear,nxb,price);
                    Book.bs.add(book);
                }
            }
            System.out.println("Read File Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Read File Error!");
            e.printStackTrace();
        }
    }
    public void removeBookFromList(String bookISBN) {
        try {
            File inputFile = new File("borrowCard.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(bookISBN)) {
                    continue; // Bỏ qua dòng chứa thông tin sách cần xóa
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            // Xóa tệp gốc và đổi tên tệp tạm thành tên tệp gốc
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}


