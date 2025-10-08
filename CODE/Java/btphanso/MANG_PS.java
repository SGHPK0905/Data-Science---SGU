package btphanso;

import java.util.Random;

public class MANG_PS {
    private PS[] arr;
    private int n;

    public MANG_PS(int n) {
        this.n = n;
        arr = new PS[n];
    }

    public void taoNgauNhien() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int ts = rand.nextInt(201) - 100;
            int ms;
            do {
                ms = rand.nextInt(201) - 100;
            } while (ms == 0);
            arr[i] = new PS(ts, ms);
        }
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            System.out.println("Phan so " + (i + 1) + ": " + arr[i]);
        }
    }

    public void timMax() {
        PS max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].giaTri() > max.giaTri()) {
                max = arr[i];
            }
        }
        System.out.println("Phan so lon nhat: " + max);
    }
}
