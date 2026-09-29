package KiemTraGK.Cau2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        
        // 1. Tạo mảng 5 phương trình bậc hai
        int n = 5;
        PTB2[] mangPhuongTrinh = new PTB2[n];

        // 2. Khởi tạo đối tượng Random để tạo giá trị ngẫu nhiên
        Random rand = new Random();

        // 3. Điền vào mảng với các giá trị a, b, c ngẫu nhiên
        System.out.println("--- TẠO MẢNG PHƯƠNG TRÌNH NGẪU NHIÊN ---");
        for (int i = 0; i < n; i++) {
           
            double a = Math.round((rand.nextDouble() * 20 - 10) * 100.0) / 100.0;
            double b = Math.round((rand.nextDouble() * 20 - 10) * 100.0) / 100.0;
            double c = Math.round((rand.nextDouble() * 20 - 10) * 100.0) / 100.0;

            mangPhuongTrinh[i] = new PTB2(a, b, c);
        }

        // 4. Xuất nghiệm các phương trình
        System.out.println("\n--- GIẢI CÁC PHƯƠNG TRÌNH ---");
        for (int i = 0; i < mangPhuongTrinh.length; i++) {
            PTB2 pt = mangPhuongTrinh[i];
            
            System.out.println("Phương trình " + (i+1) + ": " + pt); 
            
            System.out.println("Nghiệm: " + pt.getSolution()); 
            System.out.println("------------------------------------");
        }
    }
}