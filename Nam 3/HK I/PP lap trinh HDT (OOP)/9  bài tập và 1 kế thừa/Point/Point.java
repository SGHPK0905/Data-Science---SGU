package Point;

public class Point {
    private int x , y ;
    
    // 
    public Point(){
        this.x = 1 ;
        this.y = 1 ;
        System.out.println("Construct a POINT with POINT()");
    }
    public Point(int X ,int Y){
        this.x = X ;
        this.y = Y ;
        System.out.println("Construct a POINT with POINT(X,Y)");
    }
    public int getX(){
        return this.x;
    }
    public void setX(int X){
        this.x = X;
    }
    public int getY(){
        return this.y ;
    }
    public void setY(int Y){
        this.y = Y ; 
    }
    public double distance (Point p){
        return Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y,2));
    }
    public String toString(){
        return "POINT[X" + x + "Y" + y + "]";
    }


    
}
