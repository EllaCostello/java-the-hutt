import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



// Authors Theis and Niklas
public class Order {
    private Pizza pizza = new Pizza();
    private OrderStatus orderstatus;
    private LocalDateTime pickupTime;
    private ArrayList<Pizza> orderList;
    private static int lasId = 0; // sætter static så alle instances kan se den
    private int id;
    private double total = 0.0;
    private static OrderHistory orderHistory = new OrderHistory();



    public void addPizzaToOrder(int pizzaNummer) {
        if (pizzaNummer > 0 && pizzaNummer <= pizza.getPizzas().size()) {
            orderList.add(pizza.getPizzas().get(pizzaNummer - 1));
            System.out.println("Ordren har nu: " + orderList);
            this.total += pizza.getPrice();

        } else {
            System.out.println("pizza nummer eksisterer ikke.");
        }

    }
    public Order(int inputTime) {
        this.id = ++lasId; // incrementer lastId for hver order og opdaterer id
        this.orderList = new ArrayList<>();
        this.orderstatus = OrderStatus.IN_PROGRESS;
        calculatePickupTime(inputTime);

    }
    public int getId() {
        return id; // har tilføjet getter for iD hvis det er nødvendigt
    }

    public double calculateFullPrice() {
        total = 0.0;
        for (Pizza pizza : orderList) {
            total += pizza.getPrice();
        }
        return total;
    }

    // + method : calculatePickupTime(dateTime time)
    public void calculatePickupTime(int inputTime) {
        pickupTime = LocalDateTime.now().plus(inputTime, ChronoUnit.MINUTES).truncatedTo(ChronoUnit.SECONDS);
    }

    public String printCurrentOrder() {
        System.out.println("Order: ");
        for (Pizza p : orderList) {
            System.out.println(p);
        }
        return "";
    }

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

//    public void

    public void setOrderstatus(OrderStatus orderStatus) {
        this.orderstatus = orderStatus;
        if (this.orderstatus == OrderStatus.COMPLETED) {
            orderHistory.addToHistory(this);
        }
    }
    public void setIngredient(int pizzaNumber, String ingredient) {
        for (Pizza p : orderList) {
            if (p.getPizzaNumber() == pizzaNumber) {
                p.setIngredient(ingredient);

            }
        }
    }

    public String getIngredient(int pizzaNumber) {
        for (Pizza p : orderList) {
            if (p.getPizzaNumber() == pizzaNumber) {
                return p.getIngredient();
            }
        }return "-1";
    }

    public static OrderHistory getOrderHistory() {
        return orderHistory;
    }



    public String toString() {
        double updatedTotal = calculateFullPrice();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = pickupTime.format(formatter);

        System.out.println("________________________________________________________________________");
        return printCurrentOrder() + "\n" +
                "Total pris: " + updatedTotal + "\n" +
                "Afhentningstid: " + formattedTime + "\n" +
                "Status: " + orderstatus + "\n" +
                "ID: " + id + "\n" +
                "________________________________________________________________________";

    }
}
