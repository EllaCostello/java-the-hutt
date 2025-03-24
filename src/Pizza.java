import java.util.ArrayList;

// Authors Theis and Niklas
public class Pizza {
    private String name;
    // name String
    private double price;
    // Price Double
    private int pizzaNumber;
    private String ingredients;

    private ArrayList<Pizza> pizzas;

    public Pizza(int pizzaNumber, double price, String name, String ingredients) {
        this.ingredients = ingredients;
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;

    }

    public String getIngredient() {
        return ingredients;
    }
    public void setIngredient(String ingredients) {
        this.ingredients = ingredients;
    }

    public Pizza() {
        pizzas = new ArrayList<>();
        pizzas.add(new Pizza(1, 59.0, "Amerikaner", "tomatoesauce, ost, skinke, oksfars og oregano"));
        pizzas.add(new Pizza(2, 57.0, "Capriciosa", "tomatoesauce, ost, pepperoni og oregano"));
        pizzas.add(new Pizza(3, 63.0, "Carbonara", "tomatoesauce, ost, kødsauce, spaghetti, cocktailpølser og oregano"));
        pizzas.add(new Pizza(4, 65.0, "Dennis", "tomatoesauce, ost, skinke, pepperoni, cocktailpølser og oregano"));
        pizzas.add(new Pizza(5, 57.0, "Bertil", "tomatoesauce, ost, bacon og oregano"));
        pizzas.add(new Pizza(6, 61.0, "Silvia", "tomatoesauce, ost, pepperoni, rød peber, løg, oliven og oregano"));
        pizzas.add(new Pizza(7, 61.0, "Victoria", "tomatoesauce, ost, skinke, ananas, champignon, løg og oregano"));
        pizzas.add(new Pizza(8, 61.0, "Torino", "tomatoesauce, ost, skinke, bacon, kebab, chili og oregano"));
        pizzas.add(new Pizza(9, 61.0, "Capricciosa", "tomatoesauce, ost, skinke, champignon og oregano"));
        pizzas.add(new Pizza(10, 61.0, "Hawaii", "tomatoesauce, ost, skinke, ananas og oregano"));
        pizzas.add(new Pizza(11, 61.0, "La Blissola", "tomatoesauce, ost, skinke, rejer og oregano"));
        pizzas.add(new Pizza(12, 61.0, "Venezia", "tomatoesauce, ost, skinke, bacon og oregano"));
        pizzas.add(new Pizza(13, 61.0, "Italia", "tomatoesauce, ost, pepperoni, bacon, løg og oregano"));
        pizzas.add(new Pizza(14, 55.0, "Margherita", "tomatoesauce, ost, basilikum og oregano"));
        pizzas.add(new Pizza(15, 63.0, "Quattro Formaggi", "tomatoesauce, ost, mozzarella, parmesan, gorgonzola og oregano"));
        pizzas.add(new Pizza(16, 62.0, "Pollo", "tomatoesauce, ost, kylling, champignon, løg og oregano"));
        pizzas.add(new Pizza(17, 59.0, "Diavola", "tomatoesauce, ost, stærk salami, chili og oregano"));
        pizzas.add(new Pizza(18, 61.0, "Tonno", "tomatoesauce, ost, tun, løg, oliven og oregano"));
        pizzas.add(new Pizza(19, 60.0, "Vegetariana", "tomatoesauce, ost, rød peber, champignon, oliven, løg og oregano"));
        pizzas.add(new Pizza(20, 64.0, "Prosciutto", "tomatoesauce, ost, parmaskinke, rucola og oregano"));
        pizzas.add(new Pizza(21, 58.0, "Napoli", "tomatoesauce, ost, ansjoser, kapers og oregano"));
        pizzas.add(new Pizza(22, 62.0, "Bolognese", "tomatoesauce, ost, kødsauce, parmesan og oregano"));
        pizzas.add(new Pizza(23, 59.0, "Rucola", "tomatoesauce, ost, cherrytomater, rucola og oregano"));
        pizzas.add(new Pizza(24, 63.0, "Kebab Special", "tomatoesauce, ost, kebab, salat, dressing og oregano"));
        pizzas.add(new Pizza(25, 58.0, "Funghi", "tomatoesauce, ost, champignon, hvidløg og oregano"));
        pizzas.add(new Pizza(26, 64.0, "Pesto", "tomatoesauce, ost, pesto, kylling, pinjekerner og oregano"));
        pizzas.add(new Pizza(27, 66.0, "Frutti di Mare", "tomatoesauce, ost, rejer, muslinger, blæksprutte og oregano"));
        pizzas.add(new Pizza(28, 60.0, "Salami", "tomatoesauce, ost, salami, rød peber og oregano"));
        pizzas.add(new Pizza(29, 63.0, "BBQ Chicken", "tomatoesauce, ost, kylling, BBQ sauce, løg og oregano"));
        pizzas.add(new Pizza(30, 67.0, "Truffle", "tomatoesauce, ost, champignon, trøffelolie, parmesan og oregano"));

    }


    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void addPizzas(Pizza pizza) {
        pizzas.add(pizza);
        System.out.println("Tilføjede " + pizza + " til menu");
    }

    public void removePizza(Pizza pizza) {
        pizza.removePizza(pizza);
        System.out.println("Fjernede " + pizza + " fra menu");
    }
    public double getPrice() {
        return price;
    }




    public int getPizzaNumber() {return pizzaNumber; }



    public void showPizzas() {
        for (Pizza p : pizzas) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return  pizzaNumber + ". " + name + ", pris: " + price;
    }


    public String pizzaMenu() {
        if (pizzaNumber < 10) {
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