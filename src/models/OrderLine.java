package models;

public class OrderLine {
    private String productName;
    private double productPrice;
    private int productNumber;
    private String productIngredients;

    public OrderLine(Product product) {
        this.productNumber = product.getNumber();
        this.productName = product.getName();
        this.productPrice = product.getPrice();
        this.productIngredients = product.getIngredients();
    }

    public double getTotalPrice() {
        return productPrice;
    }

}