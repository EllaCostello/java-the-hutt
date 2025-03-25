package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



// Authors Theis and Niklas
public class Order {
    // private Product product = new Product();
    private OrderStatus orderstatus;
    private LocalDateTime pickupTime;
    private ArrayList<Product> orderList;
    private static int lasId = 0; // sætter static så alle instances kan se den
    private int id;
    private double total = 0.0;
    private static OrderHistory orderHistory = new OrderHistory();
    private ArrayList<Order> activeOrders = new ArrayList<>();

    public Order(int inputTime) {
        this.id = ++lasId; // incrementer lastId for hver order og opdaterer id
        this.orderList = new ArrayList<>();
        this.orderstatus = OrderStatus.IN_PROGRESS;
        calculatePickupTime(inputTime);

    }

    public ArrayList<Product> getOrderList() {
        return orderList;
    }
    /*
    public void addProductToOrder(int productNumber) {
        if (productNumber > 0 && productNumber <= product.getProducts().size()) {
            orderList.add(product.getProducts().get(productNumber - 1));
            System.out.println("Ordren har nu: " + orderList);
            this.total += product.getPrice();

        } else {
            System.out.println("Produkt med dette nummer eksisterer ikke.");
        }

    }

     */

    public int getId() {
        return id; // har tilføjet getter for iD hvis det er nødvendigt
    }

    public double calculateFullPrice() {
        total = 0.0;
        for (Product product : orderList) {
            total += product.getPrice();
        }
        return total;
    }

    // + method : calculatePickupTime(dateTime time)
    public void calculatePickupTime(int inputTime) {
        pickupTime = LocalDateTime.now().plus(inputTime, ChronoUnit.MINUTES).truncatedTo(ChronoUnit.SECONDS);
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public String printCurrentOrder() {
        System.out.println("models.Order: ");
        for (Product p : orderList) {
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
        if (this.orderstatus == OrderStatus.ACTIVE) {
            activeOrders.add(this);
        }
    }

    public ArrayList<Order> getActiveOrders() {
        return activeOrders;
    }
    public void setIngredient(int productNumber, String ingredient) {
        for (Product p : orderList) {
            if (p.getProductNumber() == productNumber) {
                p.setIngredient(ingredient);

            }
        }
    }
    /*
    public String getIngredient(int productNumber) {
        for (Product p : orderList) {
            if (p.getProductNumber() == productNumber) {
                return p.getIngredient();
            }
        }return "-1";
    }

     */

    public static OrderHistory getOrderHistory() {
        return orderHistory;
    }


    /*
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

     */
}
