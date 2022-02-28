package webshop;

public class Product {
    private long Id;
    private String productName;
    private int price;
    private int stock;

    public Product(long id, String productName, int price, int stock) {
        Id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public Product(String productName, int price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return Id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}

//    Product product = new Product(1L, "Computer", 340_000, 5);
//
//    assertEquals(1L, product.getId());
//        assertEquals("Computer", product.getProductName());
//        assertEquals(340_000, product.getPrice());
//        assertEquals(5, product.getStock());
