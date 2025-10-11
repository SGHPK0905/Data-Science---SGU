public class Vector extends DoiTuong {
    double x, y, z;
    public Vector(double x, double y, double z) {
        super("Vector");
        this.x = x; this.y = y; this.z = z;
    }
    
    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    
    public static Vector tichCoHuong(Vector a, Vector b) {
        return new Vector(a.y*b.z - a.z*b.y, a.z*b.x - a.x*b.z, a.x*b.y - a.y*b.x);
    }
}