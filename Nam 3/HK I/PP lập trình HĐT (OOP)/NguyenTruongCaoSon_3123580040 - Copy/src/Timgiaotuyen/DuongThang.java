public class DuongThang extends DoiTuong {
    Diem A; Vector u;
    public DuongThang(Diem A, Vector u) {
        super("Duong thang giao tuyen");
        this.A=A; this.u=u;
    }
    
    public void hienThi() {
        // Sử dụng Getters thay vì truy cập trực tiếp
        System.out.println("Giao tuyen di qua A" + A + " va co VTCP: (" + u.getX() + ", " + u.getY() + ", " + u.getZ() + ")");
    }
}