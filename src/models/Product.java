package models;

public class Product {
    private final String name;
    private double price;
    private final int productNumber;
    private final String ingredients;

    public Product(int productNumber, double price, String name,  String ingredients) {
        this.productNumber = productNumber;
        this.price = price;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double inputPrice) {
        price = inputPrice;
    }

    public int getProductNumber() {
        return productNumber;
    }

    @Override
    public String toString() {
        return  productNumber + ". " + name + ", pris: " + price;
    }


    public String toStringForMenu() {
        if (productNumber < 10) {
            return """
                    %d. %-85s %.0f
                    \033[3m%s\033[0m""".formatted(productNumber, name, price, ingredients);
        }
        return """
                %d. %-84s %.0f
                \033[3m%s\033[0m""".formatted(productNumber, name, price, ingredients);
    }
}
