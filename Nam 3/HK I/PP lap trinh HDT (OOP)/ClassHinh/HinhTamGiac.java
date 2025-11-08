package ClassHinh;

public class HinhTamGiac extends hinh {
    private double a, b, c;

    public HinhTamGiac(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Cạnh phải > 0");
        if (a + b <= c || a + c <= b || b + c <= a) throw new IllegalArgumentException("Không thỏa bất đẳng thức tam giác");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double chuVi() {
        return a + b + c;
    }

    @Override
    public double dienTich() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(Math.max(0.0, s * (s - a) * (s - b) * (s - c)));
    }

    @Override
    public String toString() {
        return String.format("HinhTamGiac(a=%.2f,b=%.2f,c=%.2f, S=%.2f)", a, b, c, dienTich(), chuVi());
    }
}