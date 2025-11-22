package KiemTraGK.Cau1;

import java.util.ArrayList;
import java.util.List;
public class PolyLine {
    // 1. Thuộc tính (Attributes)
    private List<Point> points;

    // 2. Phương thức khởi tạo (Constructors)
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    // 3. Các phương thức (Methods)
    public void appendPoint(int x, int y) {
        Point newPoint = new Point(x, y);
        this.points.add(newPoint);
    }

    public void appendPoint(Point point) {
        this.points.add(point);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Point p : points) {
            sb.append(p.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    public double getLength() {
        double totalLength = 0;
        if (points.size() < 2) {
            return 0;
        }

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            totalLength += p1.distanceTo(p2);
        }
        return totalLength;
    }


    public double getPerimeter() {
        if (points.size() < 3) {
            return 0;
        }

        double length = this.getLength();
        Point firstPoint = points.get(0);
        Point lastPoint = points.get(points.size() - 1);
        length += lastPoint.distanceTo(firstPoint);

        return length;
    }

   
    public double getArea() {
        if (points.size() < 3) {
            return 0;
        }

        double area = 0.0;
        int n = points.size();

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            
            area += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }
        
        return Math.abs(area / 2.0);
    }

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
        return pointToRemove;
    }
}