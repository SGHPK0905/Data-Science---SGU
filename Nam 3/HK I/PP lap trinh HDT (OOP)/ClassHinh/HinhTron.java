package ClassHinh;

public class HinhTron extends hinh {
    private double r;

    public HinhTron(double r) {
        if (r <= 0) throw new IllegalArgumentException("Bán kính phải > 0");
        this.r = r;
    }

    @Override
    public double chuVi() {
        return 2 * Math.PI * r;
    }

    @Override
    public double dienTich() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return String.format("HinhTron(r=%.2f, S=%.2f)", r, dienTich(), chuVi());
    }
}