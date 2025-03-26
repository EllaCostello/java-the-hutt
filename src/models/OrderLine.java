package models;

public class OrderLine {
    private double currentPrice;
    private String currentName;
    private String currentIngredience;
    private int currentProductNumber;

    public OrderLine(Product product) {
        this.currentPrice = product.getPrice();
        this.currentName = product.getName();
        this.currentIngredience = product.getIngredients();
        this.currentProductNumber = product.getProductNumber();
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getCurrentName() {
        return currentName;
    }
    public int getProductNumber() {
        return currentProductNumber;
    }


    public String getCurrentIngredience() {
        return currentIngredience;
    }
    public String toString() {
        return currentProductNumber + ". " + currentName + ", pris: " + currentPrice;
    }
}
