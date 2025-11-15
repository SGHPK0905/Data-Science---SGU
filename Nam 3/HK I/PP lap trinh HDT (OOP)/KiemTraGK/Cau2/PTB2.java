package KiemTraGK.Cau2;

public class PTB2 extends PTB1 {
    // 1. Thuộc tính (Attributes)
    private double a;

    // 2. Phương thức khởi tạo (Constructor)
    public PTB2(double a1, double b1, double c1) {
        super(b1, c1); 
        this.a = a1;
    }

    // 3. Các phương thức (Methods)
    @Override
    public String getSolution() {
        // Nếu a = 0, phương trình trở thành bậc nhất
        if (a == 0) {
            return super.getSolution();
        }
        // a != 0, giải phương trình bậc hai
        double delta = (b * b) - (4 * a * c);

        if (delta < 0) {
            return "Phương trình vô nghiệm thực";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép: x1 = x2 = " + x;
        } else {

            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
        }
    }

    @Override
    public String toString() {
        String bStr = (b < 0) ? "- " + Math.abs(b) : "+ " + b;
        String cStr = (c < 0) ? "- " + Math.abs(c) : "+ " + c;

        return a + "x^2 " + bStr + "x " + cStr + " = 0";
    }
}