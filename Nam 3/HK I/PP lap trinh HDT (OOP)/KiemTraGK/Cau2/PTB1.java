package KiemTraGK.Cau2;

public class PTB1 {
    // 1. Thuộc tính (Attributes)
    protected double b;
    protected double c;

    // 2. Phương thức khởi tạo (Constructor)
    public PTB1(double b1, double c1) {
        this.b = b1;
        this.c = c1;
    }

    // 3. Các phương thức (Methods)
    public String getSolution() {
        if (b == 0) {
            if (c == 0) {
                return "Phương trình có vô số nghiệm";
            } else {
                return "Phương trình vô nghiệm";
            }
        } else {
            // b != 0
            double x = -c / b;
            return "Phương trình có 1 nghiệm: x = " + x;
        }
    }

    @Override
    public String toString() {
        String cStr = (c < 0) ? "- " + Math.abs(c) : "+ " + c;
        return b + "x " + cStr + " = 0";
    }
}