package interfaceDemo;
 public class Test {
    public static void main(String[] args) {
        Relatable a = new RectanglePlus (4,6);
        Relatable c = new CirclePlus(5);

        int comparisonResult = a.isLargerThan(c);
        if (comparisonResult > 0) {
            System.out.println("obj1 is larger than obj2");
        } else if (comparisonResult < 0) {
            System.out.println("obj1 is smaller than obj2");
        } else {
            System.out.println("obj1 is equal to obj2");
        }
    }
}
