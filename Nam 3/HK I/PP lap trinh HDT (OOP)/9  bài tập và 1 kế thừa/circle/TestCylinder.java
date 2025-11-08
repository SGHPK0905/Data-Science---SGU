public class TestCylinder extends Cylinder {
    public static void main(String[] args){
        Cylinder cy1= new Cylinder();
        // doi tuong duong tron duoc tao theo bo khoi tao Circle()
        // doi tuong hinh tru duoc tao theo bo khoi tao Cyliner()
        System.out.println("Radius is " + cy1.getRadius()
        + ", Heiht is " + cy1.getheight()
        + ", Color is " + cy1.getColor()
        + ", Base area is " + cy1.getArea()
        + ", Volume is " + cy1.getVolume()
        + ", AreaCy is " + cy1.getAreaCY());
        // radius is 1.0 height is 1.0 , color is red , 
        // base area is 3.1416 , volume is 3.1416 

        Cylinder cy2 = new Cylinder(5.0 , 2.0 , "red");
        // duong tron duoc tao theo bo khoi tao Circle(radius)
        //hinh tru duoc tao theo bo khoi tao Cylinder (height,radius)
        System.out.println("Radius is " + cy2.getRadius()
        + ", Height is " + cy2.getheight()
        + ", color is " + cy2.getColor()
        + ", base area is " + cy2.getArea()
        + ", Volume is " +cy2.getVolume()
        + ", AreaCy is "+cy2.getAreaCY());
    }
    
}
