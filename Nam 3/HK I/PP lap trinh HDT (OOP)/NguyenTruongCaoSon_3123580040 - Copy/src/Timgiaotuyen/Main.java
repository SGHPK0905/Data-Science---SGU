import java.util.Scanner;

public class Main {

    public static MatPhang nhapMatPhang(Scanner scanner, String tenMP) {
        System.out.println("--- Nhap mat phang " + tenMP + " (Ax + By + Cz + D = 0) ---");
        System.out.print("Nhap he so A: ");
        double a = scanner.nextDouble();
        System.out.print("Nhap he so B: ");
        double b = scanner.nextDouble();
        System.out.print("Nhap he so C: ");
        double c = scanner.nextDouble();
        System.out.print("Nhap he so D: ");
        double d = scanner.nextDouble();
        return new MatPhang(a, b, c, d);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nhap hai mat phang P1 va P2
        MatPhang p1 = nhapMatPhang(scanner, "P1");
        MatPhang p2 = nhapMatPhang(scanner, "P2");
        
        scanner.close(); 

        System.out.println("\n===== KET QUA GIAO TUYEN =====");
        
        // Goi phuong thuc tim giao tuyen
        DuongThang giao = GiaoTuyenFinder.timGiaoTuyen(p1, p2);
        
        if (giao != null) {
            giao.hienThi();
        }
        System.out.println("===============================");
    }
}