package btphanso;

public class PS {
    private int ts;
    private int ms;

    public PS(int ts, int ms) {
        if (ms == 0) {
            throw new IllegalArgumentException("Mau so khac 0");
        }
        this.ts = ts;
        this.ms = ms;
        rutGon();
    }

    // Rút gọn phân số
    private void rutGon() {
        int gcd = UCLN(Math.abs(ts), Math.abs(ms));
        ts /= gcd;
        ms /= gcd;
        if (ms < 0) {
            ts = -ts;
            ms = -ms;
        }
    }

    private int UCLN(int a, int b) {
        return b == 0 ? a : UCLN(b, a % b);
    }

    public double giaTri() {
        return (double) ts / ms;
    }

    @Override
    public String toString() {
        return ts + "/" + ms;
    }
}
