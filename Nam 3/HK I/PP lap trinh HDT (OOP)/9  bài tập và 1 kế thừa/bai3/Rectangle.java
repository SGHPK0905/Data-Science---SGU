package bai3;

public class Rectangle {
    private float lenght ;
    private float width ;
    
    //
    public Rectangle(){
        this.lenght = 1.0f ; 
        this.width = 1.0f ; 
        System.out.println("Construct a Rectangle with Rectangle()");
    }
    public Rectangle(float lenght , float width){
        this.lenght = lenght;
        this.width = width ; 
        System.out.println("Construct a Rectangle with Rectangle(length,width)");
    }
    public float getleght(){
        return this.lenght;
    }
    public void setleght(float lenght){
        this.lenght = lenght ; 
    }
    public float getwidth(){
        return this.width;
    }
    public void setwidth(float width){
        this.width = width; 
    }
    public double getArea(){
        return lenght * width ;
    }
    public double getPerimeter(){
        return (lenght + width) * 2;
    }
    public String toString(){
        return "Rectangle[length" + lenght + "width" + width +"]";
    }

}
