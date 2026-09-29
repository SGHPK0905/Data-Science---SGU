package KiemTraGK.Cau1;

public class Point {
    // 1. Thuộc tính (Attributes)
    private int x;
    private int y;

    // 2. Phương thức khởi tạo (Constructors)
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 3. Các phương thức Getter và Setter (để truy cập thuộc tính private)
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distanceTo(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}