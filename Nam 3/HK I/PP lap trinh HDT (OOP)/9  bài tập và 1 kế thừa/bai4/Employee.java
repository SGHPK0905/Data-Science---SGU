package bai4;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    
    //
    public Employee(int id , String firstName , String lastName , int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        System.out.println("Contruct an Employee with Employee(id,firstName,lastName,salary)");
    }
    public int getID(){
        return this.id;
    }
    public String getfirstName(){
        return this.firstName;
    }
    public String getlastName(){
        return this.lastName;
    }
    public String getName(){
        return getfirstName() + getlastName();
    }
    public int getsalary(){
        return this.salary;
    }
    public void setsalary(int salary){
        this.salary = salary;
    }
    public int getAnnualsalary(){
        return salary * 12 ; 
    }
    public int raiseSalary(int percent){
        return getsalary() + (getsalary()* percent / 100);
    }
    public String toString(){
        return "Employee[id" + id + "name" + (firstName + lastName) + "salary" + salary + "]";
    }

    



}
