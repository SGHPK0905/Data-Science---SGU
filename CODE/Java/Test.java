 public class Test {
    public static void main(String[] args) {
        Relatable a = new RectanglePlus (4,6);
        Relatable c = new CirclePlus(5);

        ì(a.isLargerThan(c) == 1) {
            System.out.println("Hình chữ nhật có diện tích lớn hơn hình tròn.");
            System.out.println("Hình chữ nhật có diện tích nhỏ hơn hình tròn.");
        }
    }

