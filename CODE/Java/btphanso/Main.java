package btphanso;

public class Main {
    public static void main(String[] args) {
        MANG_PS ds = new MANG_PS(100);
        ds.taoNgauNhien();
        System.out.println("Danh sach phan so:");
        ds.xuat();
        ds.timMax();
    }
}
