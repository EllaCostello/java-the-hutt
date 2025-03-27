package models;

public class Product {
    private final String NAME;
    private double price;
    private final int PRODUCT_NUMBER;
    private final String INGREDIENTS;

    public Product(int productNumber, double price, String name,  String ingredients) {
        this.PRODUCT_NUMBER = productNumber;
        this.price = price;
        this.NAME = name;
        this.INGREDIENTS = ingredients;
    }

    public String getName() {
        return NAME;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double inputPrice) {
        price = inputPrice;
    }

    public int getPRODUCT_NUMBER() {
        return PRODUCT_NUMBER;
    }

    @Override
    public String toString() {
        return  PRODUCT_NUMBER + ". " + NAME + ", pris: " + price;
    }


    public String toStringForMenu() {
        if (PRODUCT_NUMBER < 10) {
            return """
                    %d. %-85s %.0f
                    \033[3m%s\033[0m""".formatted(PRODUCT_NUMBER, NAME, price, INGREDIENTS);
        }
        return """
                %d. %-84s %.0f
                \033[3m%s\033[0m""".formatted(PRODUCT_NUMBER, NAME, price, INGREDIENTS);
    }
}
