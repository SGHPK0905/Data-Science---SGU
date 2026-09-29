
public class DuongThang {
    public Diem diemThuoc;
    public Vector chiPhuong;

    public DuongThang(Diem d, Vector v) {
        this.diemThuoc = d;
        this.chiPhuong = v;
    }

    @Override
    public String toString() {
        return "Điem: " + diemThuoc + " ; Vector chi phuong: " + chiPhuong;
    }
}
