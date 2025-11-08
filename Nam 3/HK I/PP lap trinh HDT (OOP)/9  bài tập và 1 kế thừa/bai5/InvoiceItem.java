package bai5;

public class InvoiceItem {
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;
    
    //
    public InvoiceItem(String id, String desc, int qty , double unitPrice){
        this.id = id;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public String getID(){
        return this.id;
    }
    public String getDesc(){
        return this.desc;
    }
    public int getQty(){
        return this.qty;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }
    public double getTotal(){
        return unitPrice * qty ; 
    }
    public String toString(){
        return "InvoiceItem[id" + id + "desc" + desc + "qty" + qty + "unitPrice" + unitPrice + "]";
    }
    


}
