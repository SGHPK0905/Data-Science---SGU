
public class MatPhang {
    public double A, B, C, D;

    public MatPhang(double A, double B, double C, double D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public Vector phapTuyen() {
        return new Vector(A, B, C);
    }
}
