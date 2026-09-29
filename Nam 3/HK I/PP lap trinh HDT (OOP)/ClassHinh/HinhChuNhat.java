package ClassHinh;

public class HinhChuNhat extends hinh {
    private double width;
    private double height;

    public HinhChuNhat(double width, double height) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Kích thước phải > 0");
        this.width = width;
        this.height = height;
    }

    @Override
    public double chuVi() {
        return 2 * (width + height);
    }

    @Override
    public double dienTich() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("HinhChuNhat(w=%.2f,h=%.2f, S=%.2f)", width, height, dienTich(), chuVi());
    }
}