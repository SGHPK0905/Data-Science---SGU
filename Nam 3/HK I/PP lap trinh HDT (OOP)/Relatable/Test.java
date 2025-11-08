package interfaceDemo;
 public class Test {
    public static void main(String[] args) {
        Relatable a = new RectanglePlus (4,6);
        Relatable c = new CirclePlus(5);
        if (a.isLargerThan(c)==1) {
            System.out.print("Hình chữ nhật lớn hơn hình tròn");
            System.out.print("Diện tích hình chữ nhật bé hơn hình tròn");
        }
    }
}
