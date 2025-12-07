// Lớp RectanglePlus kế thừa từ Rectangle và triển khai bộ giao tiếp Relatable
public class RectanglePlus extends Rectangle implements Relatable {

    // Constructors
    public RectanglePlus() {
        super();
    }                                                                                                                                                                                      

    public RectanglePlus(int w, int h) {
        super(w, h);
    }

    public RectanglePlus(Point p, int w, int h) {
        super(p, w, h);
    }

    // Hàm so sánh diện tích 2 hình chữ nhật
    // Trả về: 1 nếu lớn hơn, -1 nếu nhỏ hơn, 0 nếu bằng nhau
    @Override
    public int isLargerThan(Relatable other) {
        // Ép kiểu từ Relatable sang RectanglePlus
        RectanglePlus otherRect = (RectanglePlus) other;

        if (this.getArea() < otherRect.getArea()) {
            return -1;
        } else if (this.getArea() > otherRect.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}
