package models;

import java.util.ArrayList;

// Authors Theis and Niklas
public class Product {
    private String name;
    // name String
    private double price;
    // Price Double
    private int productNumber;
    private String ingredients;

    private ArrayList<Product> products;

    public Product(int productNumber, double price, String name, String ingredients) {
        this.ingredients = ingredients;
        this.name = name;
        this.price = price;
        this.productNumber = productNumber;

    }

    public String getIngredient() {
        return ingredients;
    }
    public void setIngredient(String ingredients) {
        this.ingredients = ingredients;
    }

    public Product() {
        products = new ArrayList<>();
        products.add(new Product(1, 59.0, "Amerikaner", "tomatoesauce, ost, skinke, oksfars og oregano"));
        products.add(new Product(2, 57.0, "Capriciosa", "tomatoesauce, ost, pepperoni og oregano"));
        products.add(new Product(3, 63.0, "Carbonara", "tomatoesauce, ost, kødsauce, spaghetti, cocktailpølser og oregano"));
        products.add(new Product(4, 65.0, "Dennis", "tomatoesauce, ost, skinke, pepperoni, cocktailpølser og oregano"));
        products.add(new Product(5, 57.0, "Bertil", "tomatoesauce, ost, bacon og oregano"));
        products.add(new Product(6, 61.0, "Silvia", "tomatoesauce, ost, pepperoni, rød peber, løg, oliven og oregano"));
        products.add(new Product(7, 61.0, "Victoria", "tomatoesauce, ost, skinke, ananas, champignon, løg og oregano"));
        products.add(new Product(8, 61.0, "Torino", "tomatoesauce, ost, skinke, bacon, kebab, chili og oregano"));
        products.add(new Product(9, 61.0, "Capricciosa", "tomatoesauce, ost, skinke, champignon og oregano"));
        products.add(new Product(10, 61.0, "Hawaii", "tomatoesauce, ost, skinke, ananas og oregano"));
        products.add(new Product(11, 61.0, "La Blissola", "tomatoesauce, ost, skinke, rejer og oregano"));
        products.add(new Product(12, 61.0, "Venezia", "tomatoesauce, ost, skinke, bacon og oregano"));
        products.add(new Product(13, 61.0, "Italia", "tomatoesauce, ost, pepperoni, bacon, løg og oregano"));
        products.add(new Product(14, 55.0, "Margherita", "tomatoesauce, ost, basilikum og oregano"));
        products.add(new Product(15, 63.0, "Quattro Formaggi", "tomatoesauce, ost, mozzarella, parmesan, gorgonzola og oregano"));
        products.add(new Product(16, 62.0, "Pollo", "tomatoesauce, ost, kylling, champignon, løg og oregano"));
        products.add(new Product(17, 59.0, "Diavola", "tomatoesauce, ost, stærk salami, chili og oregano"));
        products.add(new Product(18, 61.0, "Tonno", "tomatoesauce, ost, tun, løg, oliven og oregano"));
        products.add(new Product(19, 60.0, "Vegetariana", "tomatoesauce, ost, rød peber, champignon, oliven, løg og oregano"));
        products.add(new Product(20, 64.0, "Prosciutto", "tomatoesauce, ost, parmaskinke, rucola og oregano"));
        products.add(new Product(21, 58.0, "Napoli", "tomatoesauce, ost, ansjoser, kapers og oregano"));
        products.add(new Product(22, 62.0, "Bolognese", "tomatoesauce, ost, kødsauce, parmesan og oregano"));
        products.add(new Product(23, 59.0, "Rucola", "tomatoesauce, ost, cherrytomater, rucola og oregano"));
        products.add(new Product(24, 63.0, "Kebab Special", "tomatoesauce, ost, kebab, salat, dressing og oregano"));
        products.add(new Product(25, 58.0, "Funghi", "tomatoesauce, ost, champignon, hvidløg og oregano"));
        products.add(new Product(26, 64.0, "Pesto", "tomatoesauce, ost, pesto, kylling, pinjekerner og oregano"));
        products.add(new Product(27, 66.0, "Frutti di Mare", "tomatoesauce, ost, rejer, muslinger, blæksprutte og oregano"));
        products.add(new Product(28, 60.0, "Salami", "tomatoesauce, ost, salami, rød peber og oregano"));
        products.add(new Product(29, 63.0, "BBQ Chicken", "tomatoesauce, ost, kylling, BBQ sauce, løg og oregano"));
        products.add(new Product(30, 67.0, "Truffle", "tomatoesauce, ost, champignon, trøffelolie, parmesan og oregano"));

    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        products.add(product);
        System.out.println("Tilføjede " + product + " til menu");
    }

    public void removeProducts(Product product) {
        product.removeProducts(product);
        System.out.println("Fjernede " + product + " fra menu");
    }
    public double getPrice() {
        return price;
    }




    public int getProductNumber() {return productNumber; }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void modifyProduct(int productNumber, double price) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductNumber() == productNumber) {
                products.get(i).setPrice(price);
            }
        }
    }

    public void showProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return  productNumber + ". " + name + ", pris: " + price;
    }


    public String productMenu() {
        if (productNumber < 10) {
            return """
                    %-85s %.0f
                    \033[3m%s\033[0m""".formatted(name, price, ingredients);
        }
        return """
                %-84s %.0f
                \033[3m%s\033[0m""".formatted(name, price, ingredients);
    }

//getters and setters


}