package models;

import java.util.ArrayList;

public class Statistics {
    private ArrayList<Order> allTimeOrders;

    public Statistics() {
        allTimeOrders = new ArrayList<>();
    }

    public ArrayList<Order> getAllTimeOrders() {
        return allTimeOrders;
    }

    public void collectAllTimeOrders() {
        allTimeOrders.clear();
        OrderHistory history = Order.getOrderHistory();

        for (Order order : history.getAllOrdersList()) {
            if (order.getOrderstatus() == OrderStatus.COMPLETED) {
                allTimeOrders.add(order);
            }
        }

        System.out.println("Total completed orders collected: " + allTimeOrders.size());
    }

    public void calculateMostOrderedItems(ArrayList<Order> allTimeOrders) {
        if (allTimeOrders.isEmpty()) {
            System.out.println("No orders available to analyze.");
            return;
        }

        int[] productCount = new int[31];

//        for (Order order : allTimeOrders) {
//            for (Product product : order.getOrderList()) {
//                int productNumber = product.getProductNumber();
//                productCount[productNumber]++;
//            }
//        }

        int maxCount = 0;
        int mostPopularProductNumber = 0;

        for (int i = 1; i < productCount.length; i++) {
            if (productCount[i] > maxCount) {
                maxCount = productCount[i];
                mostPopularProductNumber = i;
            }
        }

        Product product = new Product();
        String productName = product.getProducts().get(mostPopularProductNumber - 1).toString();

        System.out.println("Mest populære produkt: " + productName);
        System.out.println("Bestilt " + maxCount + " gange");
    }
}