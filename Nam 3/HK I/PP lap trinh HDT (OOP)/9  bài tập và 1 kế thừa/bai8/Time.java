package bai8;

public class Time {
    private int hour;
    private int minute;
    private int second;
    
    //
    public Time(int hour, int minute, int second){
        if (hour >= 0 && hour <= 24){
            this.hour = hour ;
        }
        if (minute >= 0 && minute <= 60){
            this.minute = minute;
        }
        if (second >= 0 && second <= 60){
            this.second = second;
        }
        System.out.println("Construct a Time with(hour,minuted,second)");
    }
    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    public void setHour(int hour){
        this.hour = hour ;
    }
    public void setMinute(int minute){
        this.minute = minute;
    }
    public void setSecond(int second){
        this.second = second;
    }
    public void setTime(int hour, int minute, int second){
    }
    public String toString(){
        return "Time[" + hour + ":" + minute + ":" + second + "]";
    }
    public Time nextSecond(){
        second++;
        if(second >= 60){
            second = 0;
            minute++;
            if(minute >= 60){
                minute = 0;
                hour++;
                if(hour >= 24){
                    hour = 0 ; 
                }
            }
        }
        return this;
    }
    public Time previousSecond(){
        second--;
        if(second < 0){
            second = 59;
            minute --;
            if(minute < 0){
                minute = 59;
                hour --;
                if(hour < 0 ){
                    hour = 23;
                }
            }
        }
        return this;
    }



}
