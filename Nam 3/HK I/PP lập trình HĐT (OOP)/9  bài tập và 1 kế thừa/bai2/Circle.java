package bai2;

public class Circle {
    private double radius ;

    //
    public Circle(){
        this.radius = 1.0;
        System.out.println("Construct a Circle with Circle()");    
    }
    public Circle(double radius){
        this.radius = radius ;
        System.out.println("Construct a Circle with Circle(radius)");
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius ;
    }
    public double getArea(){
        return 3.1416 * radius * radius;
    }
    public double getCircumference(){
        return 2 * 3.1416 * radius ; 
    }
    public String tosString(){
        return "Circle[Radius" + radius + "]";
    }
    
}
