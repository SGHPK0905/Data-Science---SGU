package bai6;

public class Account {
    private String id;
    private String name;
    private int balance = 0; 
    
    //
    public Account(String id, String name ){
        this.id = id ;
        this.name = name;
        System.out.println("Construct an Account with Account(id,name)"); 

    }
    public Account(String id, String name, int balance){
        this.id = id ;
        this.name = name;
        this.balance = balance;
        System.out.println("Construct an Account with Account(id,name,balance)");
    }
    public String getID(){
        return this.id ;
    }
    public String getName(){
        return this.name;
    }
    public int getbalance(){
        return this.balance;
    }
    public int credict(int amount){
        return balance = balance + amount;
    }
    public int debit(int amount){
        if (amount <= balance){
            balance = balance - amount ; 
        } else {System.out.println("amount exceeded");}
        return balance;
    }
    public int tranferTo(int amount, Account anotherAccoun){
        if (amount <= balance){
            balance = balance - amount;
            anotherAccoun.credict(amount);
        } else System.out.println("amount exceeded");
        return balance;
    }
    public String toString(){
        return "Account[ id " + id + " name " + name + " balance " + balance +"]";
    }


}
