package models;

public class OrderLine {
    final Product product;
    private final int QUANTITY;
    private final double CURRENT_PRICE;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.QUANTITY = quantity;
        this.CURRENT_PRICE = product.getPrice();
    }

    public double getTotalPrice() {
        return CURRENT_PRICE * QUANTITY;
    }

    public Product getProduct() {
        return product;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public String toString() {
        return QUANTITY + "x " + product.getPRODUCT_NUMBER() + ". " + product.getName() + " " + this.getTotalPrice();
    }
}
