package bai8;

public class mainT {
    public static void main(String[] args){
        Time time1 = new Time(4, 56, 59);
        System.out.println("Hour is " + time1.getHour()
        +", Minute is " + time1.getMinute()
        +", Second is " + time1.getSecond());

        Time time2 = new Time(5, 42 , 59);
        System.out.println("Hour is " + time2.getHour()
        +", Minute is " + time2.getMinute()
        +", Second is " + time2.getSecond());

        time1.nextSecond();
        time2.previousSecond();
        System.out.println("after time : " + time1);
        System.out.println("after time : " + time2);
    }
    
}
