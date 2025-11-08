public class Diem extends DoiTuong {
    double x, y, z;
    public Diem(double x, double y, double z) {
        super("Diem");
        this.x = x; this.y = y; this.z = z;
    }
    
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    
    public String toString() { return "(" + x + ", " + y + ", " + z + ")"; }
}