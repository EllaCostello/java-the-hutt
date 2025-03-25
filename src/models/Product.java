package models;

// Authors Theis and Niklas
public class Product {
    private String name;
    private double price;
    private int productNumber;
    private String ingredients;

    public Product(int productNumber, double price, String name, String ingredients) {
        this.name = name;
        this.price = price;
        this.productNumber = productNumber;
        this.ingredients = ingredients;
    }
    public String getName() { return name; }

    public int getProductNumber() { return productNumber; }

    public double getPrice() { return price; }


    public String getIngredients() { return ingredients; }

    public void setIngredient(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return  productNumber + ". " + name + ", pris: " + price;
    }


    public String toStringForMenu() {
        if (productNumber < 10) {
            return """
                    %-85s %.0f
                    \033[3m%s\033[0m""".formatted(name, price, ingredients);
        }
        return """
                %-84s %.0f
                \033[3m%s\033[0m""".formatted(name, price, ingredients);
    }
}