public class Cylinder extends Circle {
    // Thuộc tính riêng của Cylinder
    private double height = 1.0;

    // Constructor mặc định
    public Cylinder() {
        super(); // Gọi constructor của lớp cha Circle
    }

    // Constructor có bán kính
    public Cylinder(double radius) {
        super(radius); // Gọi constructor của lớp cha Circle với radius
    }

    // Constructor có bán kính và chiều cao
    public Cylinder(double radius, double height) {
        super(radius); // Gọi constructor của lớp cha Circle với radius
        this.setHeight(height);
    }

    // Constructor có bán kính, chiều cao và màu
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // Gọi constructor của lớp cha Circle với radius và color
        this.setHeight(height);
    }

    // Getter cho height
    public double getHeight() {
        return height;
    }

    // Setter cho height
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Chiều cao không hợp lệ!");
        }
        this.height = height;
    }

    // Tính diện tích đáy (kế thừa từ Circle)
    public double getBaseArea() {
        return getArea(); // Sử dụng phương thức getArea() từ lớp cha
    }

    // Tính diện tích xung quanh
    public double getSideArea() {
        return 2 * Math.PI * getRadius() * height;
    }

    // Tính diện tích toàn phần
    public double getTotalArea() {
        return 2 * getBaseArea() + getSideArea();
    }

    // Tính thể tích
    public double getVolume() {
        return getBaseArea() * height;
    }

    // Trả về thông tin Cylinder dạng String
    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height + "]";
    }

    // Hàm main để test
    public static void main(String[] args) {
        Cylinder cyl1 = new Cylinder();
        System.out.println("Cylinder 1: " + cyl1.toString() + ", Base Area: " + cyl1.getBaseArea() + ", Volume: " + cyl1.getVolume());
        
        Cylinder cyl2 = new Cylinder(3.0);
        System.out.println("Cylinder 2: " + cyl2.toString() + ", Base Area: " + cyl2.getBaseArea() + ", Volume: " + cyl2.getVolume());
        
        Cylinder cyl3 = new Cylinder(2.0, 5.0);
        System.out.println("Cylinder 3: " + cyl3.toString() + ", Base Area: " + cyl3.getBaseArea() + ", Volume: " + cyl3.getVolume());
        
        Cylinder cyl4 = new Cylinder(4.0, 6.0, "blue");
        System.out.println("Cylinder 4: " + cyl4.toString() + ", Base Area: " + cyl4.getBaseArea() + ", Volume: " + cyl4.getVolume());
        System.out.println("Total Area: " + cyl4.getTotalArea() + ", Side Area: " + cyl4.getSideArea());
    }
}