public class MatPhang extends DoiTuong {
    double a, b, c, d;
    public MatPhang(double a, double b, double c, double d) {
        super("Mat phang");
        this.a=a; this.b=b; this.c=c; this.d=d;
    }
    
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }
    public double getD() { return d; }
    
    public Vector phapTuyen() { return new Vector(a,b,c); }
}