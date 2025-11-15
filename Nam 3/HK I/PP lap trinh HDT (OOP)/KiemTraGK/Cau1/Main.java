package KiemTraGK.Cau1;

import java.util.ArrayList;
import java.util.List;     


public class Main {

    public static void main(String[] args) {
        
        System.out.println("--- 🚀 Bắt đầu kiểm tra PolyLine ---");

        PolyLine rectangle = new PolyLine();

 
        rectangle.appendPoint(0, 0);
        rectangle.appendPoint(5, 0);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(0, 4);
        rectangle.appendPoint(p4);   

        System.out.println("Các điểm của PolyLine: " + rectangle.toString());
        System.out.println("Tổng độ dài (đường hở): " + rectangle.getLength());
        System.out.println("Chu vi (đa giác kín): " + rectangle.getPerimeter());


        System.out.println("Diện tích (đa giác kín): " + rectangle.getArea());

        System.out.println("\n--- 🧪 Kiểm tra trường hợp đặc biệt (ít điểm) ---");
        

        PolyLine line = new PolyLine();
        line.appendPoint(1, 1);
        line.appendPoint(4, 5);

        System.out.println("Các điểm của Line: " + line.toString()); 
        System.out.println("Độ dài (hở): " + line.getLength());    
        System.out.println("Chu vi (kín): " + line.getPerimeter()); 
        System.out.println("Diện tích (kín): " + line.getArea());  
    }
}