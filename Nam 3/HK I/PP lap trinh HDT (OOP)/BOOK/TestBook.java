package BOOK;
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
    }
}