package bai9;

public class mainB {
    public static void main(String[] args) {
        Ball ball1 = new Ball(2.0f, 5.0f, 10, 5, 45);
        System.out.println("x is " + ball1.getX()
        +", y is " + ball1.getY()
        +", xDelta is " + ball1.getXDelta()
        +", yDelta is " + ball1.getYDelta()
        +", Radius is " + ball1.getRadius());

        ball1.reflectHorizontal();
        ball1.reflectVertical();
        ball1.move();
        System.out.println("after move x " + ball1.getX()
        +", y is " + ball1.getY()
        +", xDelta is " + ball1.getXDelta()
        +", yDelta is " + ball1.getYDelta()
        +", Radius is " + ball1.getRadius());
    }
    
}
