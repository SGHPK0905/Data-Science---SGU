public class CirclePlus {
    public int radius = 0;
    public CirclePlus(int r) {
        radius = r;
     }
     public double getArea() {
         return Math.PI * radius * radius;
     }
        // Hàm so sánh diện tích 2 hình tròn
     @Override
        public int isLargerThan(Relatable other) {
            // Ép kiểu từ Relatable sang CirclePlus
            CirclePlus otherCircle = (CirclerPlus) other;
    
            if (this.getArea() < otherCircle.getArea()) {
                return -1;
            } else if (this.getArea() > otherCircle.getArea()) {
                return 1;
            } else {
                return 0;
            }
        }   
}