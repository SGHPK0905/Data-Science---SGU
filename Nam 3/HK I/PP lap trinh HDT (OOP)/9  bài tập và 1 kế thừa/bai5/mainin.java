package bai5;

public class mainin {
    public static void main(String[] args) {
        InvoiceItem invoiceItem1 = new InvoiceItem("so nam", "tuan", 10000, 100000);
        System.out.println(" ID is " + invoiceItem1.getID()
        +", DESC is " + invoiceItem1.getDesc()
        +", QTY is " + invoiceItem1.getQty()
        +", UnitPrice is " + invoiceItem1.getUnitPrice());

    }
}
