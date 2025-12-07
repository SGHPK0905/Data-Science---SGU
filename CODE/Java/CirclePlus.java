public class CirclePlus extends Circle implements Relatable {

    // Constructors
    public CirclePlus() {
        super();
    }                                                                                                                                                                                      

    public CirclePlus(int r) {
        super(r);
    }

    public CirclePlus(Point p, int r) {
        super(p, r);
    }

    // Hàm so sánh diện tích 2 hình tròn
    // Trả về: 1 nếu lớn hơn, -1 nếu nhỏ hơn, 0 nếu bằng nhau
    @Override
    public int isLargerThan(Relatable other) {
        // Ép kiểu từ Relatable sang CirclePlus
        CirclePlus otherCircle = (CirclePlus) other;

        if (this.getArea() < otherCircle.getArea()) {
            return -1;
        } else if (this.getArea() > otherCircle.getArea()) {
            return 1;
        } else {
            return 0;
        }
    }
}
