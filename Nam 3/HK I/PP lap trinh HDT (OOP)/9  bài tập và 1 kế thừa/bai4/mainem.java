package bai4;

public class mainem {
    public static void main(String[] args) {
        Employee employee1 = new Employee(5, "dat", "nguyen", 500);
        System.out.println("ID is " + employee1.getID()
        + ", Name is " + employee1.getName()
        + ", salary is " + employee1.getsalary()
        + ", Annual salary is " + employee1.getAnnualsalary()
        + ", raise by " + employee1.raiseSalary(50));

    }
    
}
