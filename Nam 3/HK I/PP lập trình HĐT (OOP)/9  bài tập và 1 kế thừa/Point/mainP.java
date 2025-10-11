package Point;

public class mainP extends Cylinder {
    public static void main(String[] args) {
        // Test Point
        Point p1 = new Point(5, 10);
        Point p2 = new Point(8, 12);
        System.out.println("X is " + p1.getX()
        +", Y is " + p1.getY()
        +", X is " + p2.getX()
        +", Y is " + p2.getY()
        +", Distance between p1 and p2 " + p1.distance(p2) );
        

        // Test Line
        Line line = new Line(p1, p2);
        System.out.println("Line is " + line
        +", Line distance is " + line.distance()
        +", X intercept is " + line.xIntercept()
        +", Y itercept is " + line.yIntercept());

        // Test Circle
        Circle circle = new Circle(p1, 10);
        System.out.println("Center is " + circle.getCenter()
        +", Radius is " + circle.getR()
        +", Area is " + circle.getArea());
        
        // Test Cylinder
        Cylinder cylinder = new Cylinder(p1, 10, 10); 
        System.out.println("Cyliner is " + cylinder
        +", Cylinder Area is " + cylinder.getArea()
        +", Cylinder Volume is " + cylinder.getVolume());
        
        
        
        
    }
}
    

