package models;

import java.util.ArrayList;

public class OrderHistory {
    private final ArrayList<Order> allOrders = new ArrayList<>();

    public ArrayList<Order> getAllOrdersList() {
        return allOrders;
    }

    public Order getOrderByID(int orderID) {
        for (Order order : allOrders) {
            if (orderID == order.getId()) {
                return order;
            }
        }
        return null;
    }

    public void getAllOrders() {
        for (Order order : allOrders) {
            System.out.println(order);
        }
    }

    public void addToHistory(Order order) {
        allOrders.add(order);
    }

    public double getTurnover() {
        double turnover = 0;

        for (Order order : allOrders) {
            turnover += order.calculateFullPrice();
        }

        return turnover;
    }
}
