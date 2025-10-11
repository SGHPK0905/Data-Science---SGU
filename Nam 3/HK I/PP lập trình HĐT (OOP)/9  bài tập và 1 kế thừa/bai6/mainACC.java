package bai6;

public class mainACC {
    public static void main(String[] args) {
        Account account1 = new Account("so nam", "dat", 5000);
        System.out.println("ID is " + account1.getID()
        + ", Name is " + account1.getName() 
        + ", Balance is " + account1.getbalance());

        // 
        account1.credict(1000);
        account1.debit(1500);
        System.out.println("After transaction :" + account1.getbalance());
        //
        Account account2 = new Account("so sau", "tuan", 6000);
        account1.tranferTo(1000,account2);
        System.out.println("Account 1 " + account1.toString());
        System.out.println("Account 2 " + account2.toString());
    }
    
}
