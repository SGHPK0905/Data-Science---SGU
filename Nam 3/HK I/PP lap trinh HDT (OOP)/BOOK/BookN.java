package BOOK;

public class BookN {

    private String name;
    private Author[] authors; // Mảng các tác giả
    private double price;
    private int qty = 0;

    // Hàm khởi tạo
    public BookN(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public BookN(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    // Phương thức getters
    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    // Phương thức setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // Phương thức toString()
    @Override
    public String toString() {
        // Xây dựng chuỗi cho mảng tác giả theo định dạng {Author[...], Author[...]}
        String authorsString = "{";
        for (int i = 0; i < authors.length; i++) {
            authorsString += authors[i].toString();
            if (i < authors.length - 1) {
                authorsString += ", ";
            }
        }
        authorsString += "}";

        return "Book[name=" + name + ", authors=" + authorsString + ", price=" + price + ", qty=" + qty + "]";
    }

    // Phương thức bổ sung từ sơ đồ
    public String getAuthorNames() {
        String names = "";
        for (int i = 0; i < authors.length; i++) {
            names += authors[i].getName();
            if (i < authors.length - 1) {
                names += ", ";
            }
        }
        return names;
    }
}