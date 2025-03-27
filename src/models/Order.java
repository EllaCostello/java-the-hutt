package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Order {
    private final ArrayList<OrderLine> orderLines;
    private OrderStatus orderStatus;
    private LocalDateTime pickUpTime;
    private static int previousID;
    private final int id;

    public Order(int inputTime) {
        this.id = ++previousID;
        this.orderLines = new ArrayList<>();
        this.orderStatus = OrderStatus.IN_PROGRESS;
        calculatePickUpTime(inputTime);
    }

    private void calculatePickUpTime(int inputTime) {
        pickUpTime = LocalDateTime.now().plus(inputTime, ChronoUnit.MINUTES).truncatedTo(ChronoUnit.SECONDS);
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public void addOrderLine(Product product, int quantity) {
        orderLines.add(new OrderLine(product, quantity));
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public double getTotal() {
        double total = 0;
        for (OrderLine line : orderLines) {
            total += line.getTotalPrice();
        }
        return total;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String printCurrentOrder() {
        System.out.println("Ordre: ");
        for (OrderLine o : orderLines) {
            System.out.println(o);
        }
        return "";
    }

    @Override
    public String toString() {
        double updatedTotal = getTotal();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = pickUpTime.format(formatter);

        System.out.println("________________________________________________________________________");
        return printCurrentOrder() + "\n" +
                "Total pris: " + updatedTotal + "\n" +
                "Afhentningstid: " + formattedTime + "\n" +
                "Status: " + orderStatus + "\n" +
                "ID: " + id + "\n" +
                "________________________________________________________________________";

    }
}
