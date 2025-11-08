public class Circle {
    // Các thuộc tính có mức độ truy suất private 
    private double radius;
    private String color;

    // Bộ khởi tạo 
    public Circle(){
        this.radius = 1.0;
        this.color = "red";
        System.out.println(" Construct a Circle with Circle ()"); // de kiem tra 
    }
    public Circle(double radius){
        this.radius = radius;
        this.color = "red";
        System.out.println("Construct a Cirle with Circle(radius)");
    }
    
    public Circle (double radius, String color){
        this.radius = radius;
        this.color = color;
        System.out.println("Construct a Circle with Circle(radius,color)"); 
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color ; 
    }
    
    // mo ta thong tin doi tuong theo dang chuoi 
    public String toString(){
        return "Circle[radius=" + radius + "color=" + color +"]";
    }

    // tinh dien tich hinh tron 
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getcircumference(){
        return 2 * Math.PI * radius ; 
    }
}