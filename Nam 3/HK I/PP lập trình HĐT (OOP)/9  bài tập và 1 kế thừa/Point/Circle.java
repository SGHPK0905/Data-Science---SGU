package Point;

public class Circle {
    private Point center;
    private int r ;
    
    //
    public Circle(){
        this.center = new Point() ;
        this.r = 1 ;
        System.out.println("Construct a Circle with Circle()");
    }
    public Circle(Point p , int R){
        this.center = p ;
        this.r = R ;
        System.out.println("Construct a Circle with Circle(p,R)"); 
    }
    public Point getCenter(){
        return this.center ;
    }
    public void setCenter(Point p){
        this.center = p ;
    }
    public int getR(){
        return this.r;
    }
    public void setR(int R){
        this.r = R ; 
    }
    public double getArea(){
        return 3.1416 * r * r ;
    }
    public String toString(){
        return "Circle[center" + center + "radius" + r + "]";
    }
    

}
