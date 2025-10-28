// Lớp RectanglePlus kế thừa từ Rectangle và triển khai bộ giao tiếp Relatable
public class RectanglePlus implements Relatable {

   public int width = 0;
   public int height = 0;

   public RectanglePlus(int w, int h) {
       width = w;
       height = h;
    }
    public double getArea() {
        return width * height;
    }

    @Override
        public int isLargerThan(Relatable other) {
            // Ép kiểu từ Relatable sang CirclePlus
            CirclePlus otherCircle = (CirclePlus) other;
    
            if (this.getArea() < otherCircle.getArea()) {
                return -1;
            } else if (this.getArea() > otherCircle.getArea()) {
                return 1;
            } else {
                return 0;
            }
        }   
}
