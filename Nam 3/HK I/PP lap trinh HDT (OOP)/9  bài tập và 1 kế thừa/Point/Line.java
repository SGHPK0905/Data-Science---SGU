package Point;

public class Line {
    private Point A , B ; 
    //
    public Line(){
        this.A = new Point() ; 
        this.B = new Point(); 
        System.out.println("Construct a Line with (A,B)");
    }
    public Line(Point p1, Point p2){
        this.A = p1 ;
        this.B = p2 ;
        System.out.println("Construct a Line with Line(p1,p2)");
    }
    public Point getA(){
        return this.A;
    }
    public Point getB(){
        return this.B;
    }
    public void setA(Point p){
        this.A = p ; 
    }
    public void setB(Point p){
        this.B = p ;
    }
    public double distance(){
        int Dx = A.getX() - B.getX();
        int Dy = A.getY() - B.getY();
        return Math.sqrt(Dx * Dx - Dy * Dy);
    }
    public double xIntercept(){
        double slope = (A.getY()-B.getY())/ (A.getX()-B.getX());
        return A.getX() - (double)A.getY()/slope;
    }
    public double yIntercept(){
        double slope = (A.getY()-B.getY())/(A.getX()-B.getY());
        return A.getY() - (double)slope *A.getX();

    }
    public String toString(){
        return "Line[" + A.toString() + " " + B.toString() + " ]";

    }
    



    
}
