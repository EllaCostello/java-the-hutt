package models;



public class OrderLine {
    private Product product;

    public OrderLine(Product product) {
        this.product = product; // Store product reference only
    }

    public double getCurrentPrice() {
        return product.getPrice(); // Always fetch latest price from the Product
    }

    public String getCurrentName() {
        return product.getName();
    }

    public int getProductNumber() {
        return product.getProductNumber();
    }

    public String getCurrentIngredience() {
        return product.getIngredients();
    }

    public String toString() {
        return getProductNumber() + ". " + getCurrentName() + ", pris: " + getCurrentPrice();
    }
}


//public class OrderLine {
//    private double currentPrice;
//    private String currentName;
//    private String currentIngredience;
//    private int currentProductNumber;
//    private Product product;
//
//    public OrderLine(Product product) {
//        this.currentPrice = product.getPrice();
//        this.currentName = product.getName();
//        this.currentIngredience = product.getIngredients();
//        this.currentProductNumber = product.getProductNumber();
//        this.product = product;
//    }
//
//    public double getCurrentPrice() {
//        return currentPrice;
//    }
//
//    public String getCurrentName() {
//        return currentName;
//    }
//    public int getProductNumber() {
//        return currentProductNumber;
//    }
//    public void updatePrice() {
//        this.currentPrice = product.getPrice();
//    }
//
//    public String getCurrentIngredience() {
//        return currentIngredience;
//    }
//    public String toString() {
//        return currentProductNumber + ". " + currentName + ", pris: " + currentPrice;
//    }
//}
