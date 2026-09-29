public class Cylinder extends Circle {
    // cac thuoc tinh co muc do truy suat private 
    private double height;

    // bo khoi tao 
    public Cylinder(){
        super();
        this.height = 1.0;
        System.out.println("Construct a Cylinder with Cylinder()");
    }
    public Cylinder(double height){
        super();
        this.height = height;
        System.out.println("Contruct a Cylinder with Cyliner(height)");
    }
    public Cylinder (double height , double radius , String color){
        super(radius , color);
        this.height = height ;
        System.out.println("Construct a Cylinder with Cylinder(height,radius,color)");
    }

    // phuong thuc cong khai getters va setters de lay thong tin thuoc tinh private 
    public double getheight(){
        return this.height;
    }
    public void setheight(double height){
        this.height = height;
    }

    //  tinh khoi hinh khoi 
    public double getVolume(){
        return getArea()*height;
    }

    // mo ta thong tin doi tuong theo chuoi 
    public String toString(){
        return "this is a Cylinder";
    }
    public double getAreaCY(){
        double S = 2 * Math.PI * getRadius() * height ; 
        return S + 2 * getArea() ;
    }
    public double getAreaCy2(){
        double S = getcircumference() * height ;
        return S + 2 * getArea(); 
    }
}
