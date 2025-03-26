package models;

import java.util.ArrayList;

public class Statistics {
    private ArrayList<Order> allTimeOrders = new ArrayList<>();

    // Keep this public getter since it's used in UserInterface
    public ArrayList<Order> getAllTimeOrders() {
        return allTimeOrders;
    }

    public void collectAllTimeOrders() {
        allTimeOrders.clear();
        for (Order order : Order.getOrderHistory().getAllOrdersList()) {
            if (order.getOrderstatus() == OrderStatus.COMPLETED) {
                allTimeOrders.add(order);
            }
        }
    }

    private int findMaxPizzaNumber() {
        int max = 0;
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                max = Math.max(max, product.getProductNumber());
            }
        }
        return max;
    }

    private int[] countPizzaOrders() {
        int[] counts = new int[findMaxPizzaNumber() + 1];
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                counts[product.getProductNumber()]++;
            }
        }
        return counts;
    }

    public void calculateMostOrderedItems() {
        if (allTimeOrders.isEmpty()) {
            System.out.println("Ingen ordrer at analysere.");
            return;
        }

        int[] counts = countPizzaOrders();
        int maxCount = 0, popularNum = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                popularNum = i;
            }
        }

        String name = findPizzaName(popularNum);
        System.out.println("Mest populære produkt: " + name);
        System.out.println("Bestilt " + maxCount + " gange");
    }

    public void printTop3MostPopularPizzas(ArrayList<Order> allTimeOrders) {
        if (this.allTimeOrders.isEmpty()) {
            System.out.println("Ingen ordrer at analysere.");
            return;
        }

        int[] counts = countPizzaOrders();
        System.out.println("\nTop 3 mest populære pizzaer:");

        for (int rank = 1; rank <= 3; rank++) {
            int maxCount = 0, popularNum = 0;
            for (int i = 1; i < counts.length; i++) {
                if (counts[i] > maxCount) {
                    maxCount = counts[i];
                    popularNum = i;
                }
            }

            if (maxCount == 0) break;

            String name = findPizzaName(popularNum);
            System.out.printf("%d. %s (Bestilt %d gange)%n", rank, name, maxCount);
            counts[popularNum] = 0;
        }
    }

    private String findPizzaName(int productNumber) {
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                if (product.getProductNumber() == productNumber) {
                    return product.toString();
                }
            }
        }
        return "Ukendt pizza";
    }
}