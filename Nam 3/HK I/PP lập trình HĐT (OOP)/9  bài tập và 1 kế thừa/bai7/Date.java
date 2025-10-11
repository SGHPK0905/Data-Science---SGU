package bai7;

public class Date {
    private int day;
    private int month;
    private int year;

    //
    public Date(int day,int month,int year){
        if(day >= 1 && day <= 31){
            this.day = day;
        }
        if(month >= 1 && month <= 12){
            this.month = month;
        }
        if(year >= 1999 && year <= 9999){
            this.year = year;
        }
        System.out.println("Construct a Date with Date(day,month,year)");
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year ;
    }
    public void setDate(int day , int month , int year ){
    }
    public String toString(){
        return "Date[ " + day + "-" + month + "-" + year + "]";
    }

}
