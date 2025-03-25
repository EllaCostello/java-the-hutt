package models;

public class OrderLine {
    private double currentPrice;
    private String currentName;
    private String currentIngredience;

    public OrderLine(Product product) {
        this.currentPrice = product.getPrice();
        this.currentName = product.getName();
        this.currentIngredience = product.getIngredient();
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getCurrentName() {
        return currentName;
    }

    public String getCurrentIngredience() {
        return currentIngredience;
    }
    public String toString() {
        return "name " + currentName + " price " + currentPrice + " ingredience " + currentIngredience;
    }
}
