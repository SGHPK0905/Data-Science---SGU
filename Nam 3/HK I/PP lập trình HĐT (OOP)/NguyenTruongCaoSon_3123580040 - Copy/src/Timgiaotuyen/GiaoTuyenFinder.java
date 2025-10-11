import static java.lang.Math.abs;

public class GiaoTuyenFinder {
    
    private static final double EPSILON = 1e-9; 

    public static DuongThang timGiaoTuyen(MatPhang p1, MatPhang p2) {
        // Sử dụng Getters: p1.getA(), p1.getB(), v.v.
        double A1 = p1.getA(), B1 = p1.getB(), C1 = p1.getC(), D1 = p1.getD();
        double A2 = p2.getA(), B2 = p2.getB(), C2 = p2.getC(), D2 = p2.getD();

        Vector n1 = p1.phapTuyen();
        Vector n2 = p2.phapTuyen();
        Vector u = Vector.tichCoHuong(n1, n2); 

        // Kiem tra Song Song/Trung nhau (VTCP la vector khong)
        if (abs(u.getX()) < EPSILON && abs(u.getY()) < EPSILON && abs(u.getZ()) < EPSILON) { // Dùng u.getX()
            
            double k = 0;
            if (abs(A1) > EPSILON) k = A2 / A1;
            else if (abs(B1) > EPSILON) k = B2 / B1;
            else if (abs(C1) > EPSILON) k = C2 / C1;
            else return null; 

            if (abs(D1 * k - D2) < EPSILON) {
                System.out.println("Hai mat phang TRUNG NHAU. Giao tuyen la chinh mat phang do.");
            } else {
                System.out.println("Hai mat phang SONG SONG TUYET DOI. Khong co giao tuyen.");
            }
            return null;
        }

        // Cat nhau: Tim Diem Chung A
        Diem A = timDiemChung(A1, B1, C1, D1, A2, B2, C2, D2);

        if (A != null) {
            System.out.println("Hai mat phang cat nhau theo mot duong thang.");
            return new DuongThang(A, u);
        } else {
            System.out.println("Loi tim diem chung.");
            return null;
        }
    }

    private static Diem timDiemChung(double A1, double B1, double C1, double D1, 
                              double A2, double B2, double C2, double D2) {
        // ... (Logic giải hệ phương trình giữ nguyên, sử dụng A1, B1,... đã lấy qua Getters)
        
        // Thử z = 0 (tim x, y)
        double detXY = A1 * B2 - A2 * B1;
        if (abs(detXY) > EPSILON) {
            double detX = (-D1) * B2 - (-D2) * B1;
            double detY = A1 * (-D2) - A2 * (-D1);
            return new Diem(detX / detXY, detY / detXY, 0);
        }
        
        // Thử y = 0 (tim x, z)
        double detXZ = A1 * C2 - A2 * C1;
        if (abs(detXZ) > EPSILON) {
            double detX = (-D1) * C2 - (-D2) * C1;
            double detZ = A1 * (-D2) - A2 * (-D1);
            return new Diem(detX / detXZ, 0, detZ / detXZ);
        }

        // Thử x = 0 (tim y, z)
        double detYZ = B1 * C2 - B2 * C1;
        if (abs(detYZ) > EPSILON) {
            double detY = (-D1) * C2 - (-D2) * C1;
            double detZ = B1 * (-D2) - B2 * (-D1);
            return new Diem(0, detY / detYZ, detZ / detYZ);
        }
        
        return null;
    }
}