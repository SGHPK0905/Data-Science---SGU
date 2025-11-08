package BOOK;
public class TestBook {

    public static void main(String[] args) {
        
        // ======================================================
        // TEST BÀI 1 (VỚI class Book1)
        // ======================================================
        System.out.println("--- Test Bài 1 (class Book1) ---");
        
        // 1. Tạo tác giả
        Author authorOne = new Author("Nguyễn Văn A", "nva@example.com", 'm');
        
        // 2. Tạo đối tượng Book1
        Book1 book1 = new Book1("Lập trình Java", authorOne, 150000, 100);
        
        // 3. In thông tin
        System.out.println(book1); 
        System.out.println("Tên tác giả: " + book1.getAuthor().getName());
        
        
        // ======================================================
        // TEST BÀI 2 (VỚI class BookN)
        // ======================================================
        System.out.println("\n--- Test Bài 2 (class BookN) ---");
        
        // 1. Tạo các tác giả
        Author authorB = new Author("Trần Thị B", "ttb@example.com", 'f');
        Author authorC = new Author("Lê Văn C", "lvc@example.com", 'm');
        
        // 2. Tạo mảng tác giả
        Author[] authorsList = { authorB, authorC };
        
        // 3. Tạo đối tượng BookN
        BookN bookN = new BookN("Cấu trúc dữ liệu", authorsList, 200000, 50);
        
        // 4. In thông tin
        System.out.println(bookN);
        System.out.println("Tên các tác giả: " + bookN.getAuthorNames());
    }
}