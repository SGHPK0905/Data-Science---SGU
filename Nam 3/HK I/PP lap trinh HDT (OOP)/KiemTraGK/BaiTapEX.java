package KiemTraGK;
// Ngôn ngữ: Java
// Tên file: GiaiBaiTapThem.java

// 1. IMPORT TẤT CẢ Ở ĐẦU FILE
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

// 2. LỚP CHÍNH (PUBLIC)
/**
 * Lớp Main chính để giải các bài toán thêm (Câu 3-8).
 * Đây là lớp PUBLIC duy nhất trong file này.
 */
public class BaiTapEX {

    public static void main(String[] args) {
        
        // ---- Khởi tạo dữ liệu mẫu (cho Câu 3, 4, 5, 6) ----
        // Tạo một đa giác 5 cạnh (ngũ giác)
        PolyLine myPolygon = new PolyLine();
        myPolygon.appendPoint(1, 1);
        myPolygon.appendPoint(5, 0);
        myPolygon.appendPoint(7, 4);
        myPolygon.appendPoint(3, 6);
        myPolygon.appendPoint(0, 4);
        
        System.out.println("Đa giác mẫu: " + myPolygon);
        
        // ---------------------------------------------
        // --- CÂU 3: VẼ ĐA GIÁC ---
        // ---------------------------------------------
        System.out.println("\n--- CÂU 3: VẼ ĐA GIÁC ---");
        System.out.println("Đang mở một cửa sổ đồ họa để vẽ đa giác...");
        // Gọi lớp đồ họa để vẽ
        SwingUtilities.invokeLater(() -> new PolygonViewer(myPolygon));

        // ---------------------------------------------
        // --- CÂU 4: KIỂM TRA ĐIỂM TRONG ĐA GIÁC ---
        // ---------------------------------------------
        System.out.println("\n--- CÂU 4: KIỂM TRA ĐIỂM ---");
        Point p_inside = new Point(3, 3);
        Point p_outside = new Point(10, 10);
        
        System.out.printf("Điểm %s có nằm trong đa giác không? -> %b\n",
                p_inside, myPolygon.contains(p_inside)); // Gọi hàm đã viết
        System.out.printf("Điểm %s có nằm trong đa giác không? -> %b\n",
                p_outside, myPolygon.contains(p_outside)); // Gọi hàm đã viết

        // ---------------------------------------------
        // --- CÂU 5: TÍNH DIỆN TÍCH ---
        // ---------------------------------------------
        System.out.println("\n--- CÂU 5: TÍNH DIỆN TÍCH ---");
        // Gọi hàm đã viết
        System.out.printf("Diện tích đa giác là: %.2f\n", myPolygon.getArea());

        // ---------------------------------------------
        // --- CÂU 6: BỎ ĐỈNH ĐỂ DIỆN TÍCH MAX ---
        // ---------------------------------------------
        System.out.println("\n--- CÂU 6: BỎ ĐỈNH TỐI ƯU ---");
        // Gọi hàm đã viết
        Point removedPoint = myPolygon.findMaxAreaByRemovingVertex();
        System.out.println("Đỉnh cần bỏ để diện tích lớn nhất là: " + removedPoint);
        
        
        // ---------------------------------------------
        // --- CÂU 7: GIAO ĐIỂM (l1) VÀ (f) ---
        // ---------------------------------------------
        System.out.println("\n--- CÂU 7: TÌM GIAO ĐIỂM ---");
        // l1: y = 2x + 3  (m1=2, c1=3)
        Line l1 = new Line(2, 3);
        // f: y = x^2 - x + 1 (a=1, b=-1, c=1)
        Parabola f = new Parabola(1, -1, 1);
        System.out.println("Cho đường thẳng l1: " + l1);
        System.out.println("Cho Parabol f: " + f);

        List<Point> intersections = findIntersections(l1, f);
        
        if (intersections.isEmpty()) {
            System.out.println("-> l1 và f không cắt nhau.");
        } else {
            System.out.println("-> l1 và f cắt nhau tại các điểm:");
            for (Point p : intersections) {
                System.out.println("   " + p);
            }
        }

        // ---------------------------------------------
        // --- CÂU 8: TIẾP TUYẾN SONG SONG ---
        // ---------------------------------------------
        System.out.println("\n--- CÂU 8: TÌM TIẾP TUYẾN SONG SONG ---");
        System.out.println("Tìm l2 song song với l1: " + l1);
        System.out.println("Và tiếp xúc với f: " + f);
        
        Line l2 = findTangent(l1, f);
        System.out.println("-> Phương trình đường thẳng l2 là: " + l2);
    }
    
    // --- Hàm giải cho Câu 7 ---
    public static List<Point> findIntersections(Line l, Parabola p) {
        // ax^2 + (b-m)x + (c - c_intercept) = 0
        double a_new = p.a;
        double b_new = p.b - l.m;
        double c_new = p.c - l.c_intercept;

        PTB2 solver = new PTB2(a_new, b_new, c_new);
        System.out.println("   (Giải phương trình: " + solver + ")");
        List<Double> x_solutions = solver.getNumericSolution();
        List<Point> intersectionPoints = new ArrayList<>();
        
        for (double x : x_solutions) {
            double y = l.getY(x); // Dùng PT đường thẳng để tính y
            intersectionPoints.add(new Point(x, y));
        }
        return intersectionPoints;
    }
    
    // --- Hàm giải cho Câu 8 ---
    public static Line findTangent(Line l1, Parabola f) {
        // l2 song song l1 -> l2 có dạng: y = m1*x + c2
        double m1 = l1.m;
        
        // Xét giao điểm: ax^2 + (b-m1)x + (c - c2) = 0
        double A = f.a;
        double B = f.b - m1;
        // double C = f.c - c2; // c2 là ẩn

        // Delta = 0 để tiếp xúc
        // B^2 - 4*A*C = 0
        // (f.b - m1)^2 - 4 * (f.a) * (f.c - c2) = 0
        // (B^2) - 4*A*f.c + 4*A*c2 = 0
        // c2 = (4*A*f.c - B^2) / (4*A)
        
        if (A == 0) return null; // Lỗi

        double B_squared = B * B;
        double c2 = (4 * A * f.c - B_squared) / (4 * A);
        
        return new Line(m1, c2);
    }
}


// 3. CÁC LỚP CÒN LẠI (ĐÃ BỎ "PUBLIC")

// ---- LỚP POINT ----
/**
 * Lớp Point (từ Câu 1) [nguồn: 6]
 * (Đã bỏ public)
 */
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }
}

// ---- LỚP POLYLINE ----
/**
 * Lớp PolyLine (từ Câu 1) [nguồn: 7]
 * (Đã bỏ public)
 */
class PolyLine {
    private List<Point> points;

    public PolyLine() {
        this.points = new ArrayList<>();
    }
    
    public PolyLine(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void appendPoint(Point p) {
        this.points.add(p);
    }
    
    public void appendPoint(double x, double y) {
        this.points.add(new Point(x, y));
    }
    
    public List<Point> getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point p : points) {
            sb.append(p.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    // --- GIẢI CÂU 5: TÍNH DIỆN TÍCH ---
    public double getArea() {
        if (points.size() < 3) return 0;
        double area = 0.0;
        int n = points.size();
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            area += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }
        return Math.abs(area / 2.0);
    }

    // --- GIẢI CÂU 4: ĐIỂM CÓ NẰM TRONG ĐA GIÁC? ---
    public boolean contains(Point testPoint) {
        int n = points.size();
        boolean isInside = false;
        for (int i = 0, j = n - 1; i < n; j = i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(j);
            boolean intersect = ((p1.getY() > testPoint.getY()) != (p2.getY() > testPoint.getY())) &&
                    (testPoint.getX() < (p2.getX() - p1.getX()) * (testPoint.getY() - p1.getY()) / (p2.getY() - p1.getY()) + p1.getX());
            if (intersect) {
                isInside = !isInside;
            }
        }
        return isInside;
    }

    // --- GIẢI CÂU 6: BỎ ĐỈNH ĐỂ DIỆN TÍCH LỚN NHẤT ---
    public Point findMaxAreaByRemovingVertex() {
        int n = points.size();
        if (n <= 3) return null; 

        double maxArea = 0;
        Point pointToRemove = null;

        for (int i = 0; i < n; i++) {
            List<Point> tempPoints = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue; 
                tempPoints.add(points.get(j));
            }

            PolyLine tempPolygon = new PolyLine(tempPoints);
            double currentArea = tempPolygon.getArea();

            if (currentArea > maxArea) {
                maxArea = currentArea;
                pointToRemove = points.get(i);
            }
        }
        System.out.printf("Diện tích lớn nhất (n-1) đỉnh là: %.2f\n", maxArea);
        return pointToRemove;
    }
}


// ---- LỚP PTB1 ----
/**
 * Lớp PTB1 (Phương trình bậc nhất) [nguồn: 10]
 * (Đã bỏ public)
 */
class PTB1 {
    protected double b, c;

    public PTB1(double b1, double c1) {
        this.b = b1;
        this.c = c1;
    }

    public String getSolution() {
        if (b == 0) {
            return (c == 0) ? "Vô số nghiệm" : "Vô nghiệm";
        } else {
            return "x = " + (-c / b);
        }
    }
    
    public List<Double> getNumericSolution() {
        List<Double> solutions = new ArrayList<>();
        if (b != 0) {
            solutions.add(-c / b);
        }
        return solutions;
    }

    @Override
    public String toString() { return String.format("%.2fx + %.2f = 0", b, c); }
}

// ---- LỚP PTB2 ----
/**
 * Lớp PTB2 (Phương trình bậc hai) [nguồn: 15]
 * (Đã bỏ public)
 */
class PTB2 extends PTB1 {
    private double a;

    public PTB2(double a1, double b1, double c1) {
        super(b1, c1);
        this.a = a1;
    }

    @Override
    public String getSolution() {
        if (a == 0) {
            return super.getSolution();
        }
        double delta = (b * b) - (4 * a * c);
        if (delta < 0) {
            return "Vô nghiệm thực";
        } else if (delta == 0) {
            return "Nghiệm kép: x1 = x2 = " + (-b / (2 * a));
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
        }
    }
    
    public List<Double> getNumericSolution() {
        List<Double> solutions = new ArrayList<>();
        if (a == 0) {
            return super.getNumericSolution();
        }
        double delta = (b * b) - (4 * a * c);
        if (delta == 0) {
            solutions.add(-b / (2 * a));
        } else if (delta > 0) {
            solutions.add((-b + Math.sqrt(delta)) / (2 * a));
            solutions.add((-b - Math.sqrt(delta)) / (2 * a));
        }
        return solutions;
    }
    
    public double getDelta() {
        return (b * b) - (4 * a * c);
    }

    @Override
    public String toString() { return String.format("%.2fx^2 + %.2fx + %.2f = 0", a, b, c); }
}

// ---- CÁC LỚP HỖ TRỢ ----
/**
 * Lớp mô tả đường thẳng y = mx + c_intercept
 * (Đã bỏ public)
 */
class Line {
    double m;
    double c_intercept;

    public Line(double m, double c_intercept) {
        this.m = m;
        this.c_intercept = c_intercept;
    }
    
    public double getY(double x) {
        return m * x + c_intercept;
    }

    @Override
    public String toString() {
        return String.format("y = %.2fx + %.2f", m, c_intercept);
    }
}

/**
 * Lớp mô tả Parabol y = ax^2 + bx + c
 * (Đã bỏ public)
 */
class Parabola {
    double a, b, c;
    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public String toString() {
        return String.format("y = %.2fx^2 + %.2fx + %.2f", a, b, c);
    }
}

/**
 * (Câu 3) Lớp đồ họa để vẽ đa giác.
 * (Đã bỏ public)
 */
class PolygonViewer extends JFrame {
    private PolyLine polygon;
    private int padding = 40;
    private int scale = 50;

    public PolygonViewer(PolyLine polygon) {
        this.polygon = polygon;
        setTitle("Câu 3: Vẽ đa giác");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPolygon(g, polygon);
            }
        };
        add(panel);
        setVisible(true);
    }
    
    private void drawPolygon(Graphics g, PolyLine poly) {
        List<Point> points = poly.getPoints();
        if (points.isEmpty()) return;
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2));
        
        Polygon awtPolygon = new Polygon();
        for(Point p : points) {
            int drawX = (int)(p.getX() * scale) + padding;
            int drawY = (int)(p.getY() * scale) + padding; // Cần lật trục y nếu muốn (0,0) ở dưới
            awtPolygon.addPoint(drawX, drawY);
        }
        
        g.drawPolygon(awtPolygon);
        
        g.setColor(Color.RED);
        for(Point p : points) {
            int drawX = (int)(p.getX() * scale) + padding;
            int drawY = (int)(p.getY() * scale) + padding;
            g.fillOval(drawX - 4, drawY - 4, 8, 8);
            g.drawString(p.toString(), drawX + 5, drawY);
        }
    }
}