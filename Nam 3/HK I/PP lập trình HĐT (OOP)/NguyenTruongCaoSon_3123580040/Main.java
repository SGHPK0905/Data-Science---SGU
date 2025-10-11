
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap mat phang 1 (A B C D): ");
        double A1 = sc.nextDouble(), B1 = sc.nextDouble(), C1 = sc.nextDouble(), D1 = sc.nextDouble();
        MatPhang mp1 = new MatPhang(A1, B1, C1, D1);

        System.out.println("Nhap mat phang 2 (A B C D): ");
        double A2 = sc.nextDouble(), B2 = sc.nextDouble(), C2 = sc.nextDouble(), D2 = sc.nextDouble();
        MatPhang mp2 = new MatPhang(A2, B2, C2, D2);

        Vector n1 = mp1.phapTuyen();
        Vector n2 = mp2.phapTuyen();

        Vector vChiPhuong = Vector.tichCoHuong(n1, n2);

        double[][] A = { {A1, B1}, {A2, B2} };
        double[] B = { -D1, -D2 };
        double det = A[0][0]*A[1][1] - A[0][1]*A[1][0];
        double x0, y0, z0 = 0;

        if (Math.abs(det) < 1e-9) {
            z0 = 1;
            B[0] = -D1 - C1*z0;
            B[1] = -D2 - C2*z0;
            det = A[0][0]*A[1][1] - A[0][1]*A[1][0];
        }

        x0 = (B[0]*A[1][1] - B[1]*A[0][1]) / det;
        y0 = (A[0][0]*B[1] - A[1][0]*B[0]) / det;

        Diem diemChung = new Diem(x0, y0, z0);
        DuongThang giaoTuyen = new DuongThang(diemChung, vChiPhuong);

        System.out.println("\nPhuong trinh tham so cua giao tuyen:");
        System.out.println("Diem di qua: " + giaoTuyen.diemThuoc);
        System.out.println("Vector chi phuong: " + giaoTuyen.chiPhuong);

        System.out.printf("\n=> (x, y, z) = (%.2f, %.2f, %.2f) + t*(%.2f, %.2f, %.2f)\n",
                diemChung.x, diemChung.y, diemChung.z,
                vChiPhuong.x, vChiPhuong.y, vChiPhuong.z);

        sc.close();
    }
}
