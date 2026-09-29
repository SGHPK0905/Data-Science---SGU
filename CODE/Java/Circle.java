public class Circle {
    // Thuộc tính (private - đóng gói)
    private double radius = 1.0;
    private String color = "red";

    // Constructor mặc định
    public Circle() {
    }

    // Constructor có bán kính
    public Circle(double radius) {
        this.setRadius(radius);
    }

    // Constructor có bán kính và màu
    public Circle(double radius, String color) {
        this.setRadius(radius);
        this.setColor(color);
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    // Setter
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Bán kính không hợp lệ!");
        }
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Trả về thông tin Circle dạng String
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }

    // Tính diện tích
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Hàm main để test
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.5);
        Circle c3 = new Circle(3.5, "blue");

        System.out.println(c1.toString() + ", area=" + c1.getArea());
        System.out.println(c2.toString() + ", area=" + c2.getArea());
        System.out.println(c3.toString() + ", area=" + c3.getArea());
    }
}
