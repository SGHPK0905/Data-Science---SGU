package BOOK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
public class TestBook {

    public static void main(String[] args) {
        
        // ======================================================
        // TEST BÀI 1 (VỚI class Book1)
        // ======================================================
        System.out.println("--- Test Bai 1 (class Book1) ---");
        
        // 1. Tạo tác giả
        Author authorOne = new Author("Nguyen Van A", "nva@example.com", 'm');
        
        // 2. Tạo đối tượng Book1
        Book1 book1 = new Book1("Lap trinh Java", authorOne, 150000, 100);
        
        // 3. In thông tin
        System.out.println(book1); 
        System.out.println("Ten tac gia: " + book1.getAuthor().getName());
        
        
        // ======================================================
        // TEST BÀI 2 (VỚI class BookN)
        // ======================================================
        System.out.println("\n--- Test Bai 2 (class BookN) ---");
        
        // 1. Tạo các tác giả
        Author authorB = new Author("Tran Thi B", "ttb@example.com", 'f');
        Author authorC = new Author("Le Van C", "lvc@example.com", 'm');
        
        // 2. Tạo mảng tác giả
        Author[] authorsList = { authorB, authorC };
        
        // 3. Tạo đối tượng BookN
        BookN bookN = new BookN("Cau truc du lieu", authorsList, 200000, 50);
        
        // 4. In thông tin
        System.out.println(bookN);
        System.out.println("Ten cac tac gia: " + bookN.getAuthorNames());

        // ======================================================
        // YÊU CẦU MỚI: TÌM TÁC GIẢ VIẾT NHIỀU SÁCH NHẤT
        // ======================================================
        System.out.println("\n--- Tim tac gia viet nhieu sach nhat ---");
        
        // 1. Tạo một danh sách các tác giả để chọn ngẫu nhiên
        List<Author> authorPool = new ArrayList<>();
        authorPool.add(new Author("Pham Thi D", "ptd@example.com", 'f'));
        authorPool.add(new Author("Hoang Van E", "hve@example.com", 'm'));
        authorPool.add(new Author("Trinh Cong F", "tcf@example.com", 'm'));
        authorPool.add(new Author("Doan Van G", "dvg@example.com", 'm'));
        authorPool.add(new Author("Bui Thi H", "bth@example.com", 'f'));

        // 2. Tạo 100 đầu sách ngẫu nhiên
        List<Book1> bookList = generateRandomBooks(100, authorPool);

        // In ra danh sách sách đã tạo để kiểm tra
        System.out.println("\n--- Danh sach 100 sach ngau nhien ---");
        int count = 1;
        for (Book1 b : bookList) {
            System.out.println(count++ + ". " + b);
        }

        // 3. Tìm tác giả viết nhiều sách nhất
        findMostProlificAuthor(bookList);
    }

    /**
     * Tạo danh sách các cuốn sách ngẫu nhiên.
     * @param numberOfBooks Số lượng sách cần tạo.
     * @param authorPool Danh sách các tác giả để chọn.
     * @return Một danh sách các đối tượng Book1.
     */
    public static List<Book1> generateRandomBooks(int numberOfBooks, List<Author> authorPool) {
        List<Book1> books = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < numberOfBooks; i++) {
            // Chọn một tác giả ngẫu nhiên từ danh sách
            Author randomAuthor = authorPool.get(rand.nextInt(authorPool.size()));
            
            // Tạo tên sách ngẫu nhiên, đa dạng hơn
            String[] prefixes = {"Lập trình", "Cơ sở", "Nhập môn", "Nâng cao về", "Khám phá", "Toàn tập"};
            String[] subjects = {"Java", "Python", "C++", "Cấu trúc dữ liệu", "Giải thuật", "Mạng máy tính", "AI", "Học máy"};
            String[] suffixes = {"căn bản", "cho người mới bắt đầu", "và ứng dụng", "hiện đại"};

            String prefix = prefixes[rand.nextInt(prefixes.length)];
            String subject = subjects[rand.nextInt(subjects.length)];
            String bookName = (rand.nextBoolean()) ? (prefix + " " + subject) : (prefix + " " + subject + " " + suffixes[rand.nextInt(suffixes.length)]);

            double price = 50000 + rand.nextInt(250000); // Giá từ 50,000 đến 300,000
            int qty = 5 + rand.nextInt(11); // Số lượng khoảng 10 (từ 5 đến 15)

            books.add(new Book1(bookName, randomAuthor, price, qty));
        }
        return books;
    }

    /**
     * Tìm và in ra tác giả viết nhiều sách nhất từ một danh sách sách.
     * @param books Danh sách các cuốn sách.
     */
    public static void findMostProlificAuthor(List<Book1> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("Danh sach sach rong.");
            return;
        }

        HashMap<String, Integer> authorBookCount = new HashMap<>();
        for (Book1 book : books) {
            String authorName = book.getAuthor().getName();
            authorBookCount.put(authorName, authorBookCount.getOrDefault(authorName, 0) + 1);
        }

        String mostProlificAuthor = authorBookCount.entrySet().stream()
                .max(HashMap.Entry.comparingByValue()).get().getKey();
        System.out.println("Tac gia viet nhieu sach nhat la: " + mostProlificAuthor + " voi " + authorBookCount.get(mostProlificAuthor) + " cuon sach.");
    }
}