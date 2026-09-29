package bai1;

public class Circle {
    private double radius ;
    private String color ; 

    //
    public Circle(){
        this.radius = 1.0 ; 
        this.color = "red"; 
        System.out.println("build circle with circle()");
    }
    public Circle(double radius ){
        this.radius = radius ; 
        this.color = "red";
        System.out.println("Construct a Circle with Circle(radius)");
    }
    public Circle(double radius , String color){
        this.radius = radius;
        this.color = color ; 
        System.out.println("Construct a Circle with Circle(radius,color)");
    }
    public double getRadius(){
        return this.radius ;
    }
    public void setRadius(double radius){
        this.radius = radius ; 
    }
    public String getColor(){
        return this.color ; 
    }
    public void getColor(String color){
        this.color = color ;
    }
    public String toString (){
        return "Circle[radius=" + radius + "color=" + color + "]";
    }
    public double getArea(){
        return  3.1416 * radius * radius ; 
    }
    public double getcircumference(){
        return 2 * 3.1416 * radius ;
    }
}
