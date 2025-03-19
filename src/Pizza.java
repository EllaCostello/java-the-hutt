import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    // name String
    private double price;
    // Price Double
    private int pizzaNumber;

    private ArrayList<Pizza> pizzas;

    public Pizza(String name, double price, int pizzaNumber) {
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;

    }

    public Pizza() {
        pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Amerikaner: tomatoesauce, ost, skinke, oksfars og oregano", 59.0, 1));
        pizzas.add(new Pizza("Capriciosa: tomatoesauce, ost, pepperoni og oregano", 57.0, 2));
        pizzas.add(new Pizza("Carbonara: tomatoesauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63.0, 3));
        pizzas.add(new Pizza("Dennis: tomatoesauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65.0, 4));
        pizzas.add(new Pizza("Bertil: tomatoesauce, ost, bacon og oregano", 57.0, 5));
        pizzas.add(new Pizza("Silvia: tomatoesauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61.0, 6));
        pizzas.add(new Pizza("Victoria: tomatoesauce, ost, skinke, ananas, champignon, løg og oregano", 61.0, 7));
        pizzas.add(new Pizza("Torino: tomatoesauce, ost, skinke, bacon, kebab, chili og oregano", 61.0, 8));
        pizzas.add(new Pizza("Capricciosa: tomatoesauce, ost, skinke, champignon og oregano", 61.0, 9));
        pizzas.add(new Pizza("Hawaii: tomatoesauce, ost, skinke, ananas og oregano", 61.0, 10));
        pizzas.add(new Pizza("La Blissola: tomatoesauce, ost, skinke, rejer og oregano", 61.0, 11));
        pizzas.add(new Pizza("Venezia: tomatoesauce, ost, skinke, bacon og oregano", 61.0, 12));
        pizzas.add(new Pizza("Italia: tomatoesauce, ost, pepperoni, bacon, løg og oregano", 61.0, 13));
        pizzas.add(new Pizza("Margherita: tomatoesauce, ost, basilikum og oregano", 55.0,14));
        pizzas.add(new Pizza("Quattro Formaggi: tomatoesauce, ost, mozzarella, parmesan, gorgonzola og oregano", 63.0,15));
        pizzas.add(new Pizza("Pollo: tomatoesauce, ost, kylling, champignon, løg og oregano", 62.0,16));
        pizzas.add(new Pizza("Diavola: tomatoesauce, ost, stærk salami, chili og oregano", 59.0,17));
        pizzas.add(new Pizza("Tonno: tomatoesauce, ost, tun, løg, oliven og oregano", 61.0,18));
        pizzas.add(new Pizza("Vegetariana: tomatoesauce, ost, rød peber, champignon, oliven, løg og oregano", 60.0,19));
        pizzas.add(new Pizza("Prosciutto: tomatoesauce, ost, parmaskinke, rucola og oregano", 64.0,20));
        pizzas.add(new Pizza("Napoli: tomatoesauce, ost, ansjoser, kapers og oregano", 58.0, 21));
        pizzas.add(new Pizza("Bolognese: tomatoesauce, ost, kødsauce, parmesan og oregano", 62.0,22));
        pizzas.add(new Pizza("Rucola: tomatoesauce, ost, cherrytomater, rucola og oregano", 59.0,23));
        pizzas.add(new Pizza("Kebab Special: tomatoesauce, ost, kebab, salat, dressing og oregano", 63.0,24));
        pizzas.add(new Pizza("Funghi: tomatoesauce, ost, champignon, hvidløg og oregano", 58.0,25));
        pizzas.add(new Pizza("Pesto: tomatoesauce, ost, pesto, kylling, pinjekerner og oregano", 64.0,26));
        pizzas.add(new Pizza("Frutti di Mare: tomatoesauce, ost, rejer, muslinger, blæksprutte og oregano", 66.0,27));
        pizzas.add(new Pizza("Salami: tomatoesauce, ost, salami, rød peber og oregano", 60.0,28));
        pizzas.add(new Pizza("BBQ Chicken: tomatoesauce, ost, kylling, BBQ sauce, løg og oregano", 63.0,29));
        pizzas.add(new Pizza("Truffle: tomatoesauce, ost, champignon, trøffelolie, parmesan og oregano", 67.0,30));
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

    public void showPizzas() {
        for (Pizza p : pizzas) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return  name + '\'' +
                ", pris = " + price +
                ", pizzaNumber = " + pizzaNumber ;
    }

//getters and setters


}
