package models;

public class OrderLine {
    final Product product;
    private final int quantity;
    private final double currentPrice;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.currentPrice = product.getPrice();
    }

    public double getTotalPrice() {
        return currentPrice * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return quantity + "x " + product.getProductNumber() + ". " + product.getName() + " " + this.getTotalPrice();
    }
}
