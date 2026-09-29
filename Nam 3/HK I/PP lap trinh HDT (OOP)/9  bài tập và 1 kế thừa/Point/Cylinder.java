package Point;

public class Cylinder extends Circle {
    private int height;

    //
    public Cylinder(){
        this.height = 1 ;
        System.out.println("Construct a Cylinder with Cylinder()");
    }
    public Cylinder(Point p , int R , int height){
        super(p,R);
        this.height = height;
        System.out.println("Construct a Cylinder with Cylinder(p,R,height)");
    }
    public int getHeight(){
        return this.height;
    }
    public void setheight(int height){
        this.height = height;
    }
    public double Circumference(){
        return 2 * 3.1416 * getR();
    }
    public double getArea(){
        double S = Circumference() * height;
        return S + 2 * super.getArea();
    }
    public double getVolume(){
        return super.getArea() * height;
    }
    public String toString(){
        return "Cylinder[Point" + getCenter() + " " + "Radius" + getR() + " "  + "Height" + height + "]";
    }


    
}
