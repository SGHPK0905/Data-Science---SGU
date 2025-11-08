package movablepoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint m1 = new MovablePoint(1, 2, 0.5f, 0.5f);
        System.out.println(m1); // (1.0,2.0), speed=(0.5,0.5)
        m1.move();
        System.out.println(m1); // (1.5,2.5), speed=(0.5,0.5)
    }
}
