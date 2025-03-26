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

        // Find highest pizza number
        int maxProductNumber = 0;
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                if (product.getProductNumber() > maxProductNumber) {
                    maxProductNumber = product.getProductNumber();
                }
            }
        }

        // Count pizza orders
        int[] productCount = new int[maxProductNumber + 1];
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                productCount[product.getProductNumber()]++;
            }
        }

        // Find most popular
        int maxCount = 0;
        int mostPopularProductNumber = 0;
        for (int i = 1; i < productCount.length; i++) {
            if (productCount[i] > maxCount) {
                maxCount = productCount[i];
                mostPopularProductNumber = i;
            }
        }

        // Get pizza name
        String productName = "Unknown Product";
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                if (product.getProductNumber() == mostPopularProductNumber) {
                    productName = product.toString();
                    break;
                }
            }
            if (!productName.equals("Unknown Product")) break;
        }

        System.out.println("Mest populære produkt: " + productName);
        System.out.println("Bestilt " + maxCount + " gange");
    }

    public void printTop3MostPopularPizzas(ArrayList<Order> allTimeOrders) {
        if (allTimeOrders.isEmpty()) {
            System.out.println("No orders available to analyze.");
            return;
        }

        // Find highest pizza number
        int maxProductNumber = 0;
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                if (product.getProductNumber() > maxProductNumber) {
                    maxProductNumber = product.getProductNumber();
                }
            }
        }

        // Count pizza orders
        int[] productCount = new int[maxProductNumber + 1];
        for (Order order : allTimeOrders) {
            for (Product product : order.getOrderList()) {
                productCount[product.getProductNumber()]++;
            }
        }

        System.out.println("\nTop 3 Most Popular Pizzas:");
        for (int rank = 1; rank <= 3; rank++) {
            int maxCount = 0;
            int popularPizzaNumber = 0;

            // Find current most popular
            for (int i = 1; i < productCount.length; i++) {
                if (productCount[i] > maxCount) {
                    maxCount = productCount[i];
                    popularPizzaNumber = i;
                }
            }

            // Print and exclude from next iterations
            if (maxCount > 0) {
                String pizzaName = "Unknown Pizza";
                for (Order order : allTimeOrders) {
                    for (Product product : order.getOrderList()) {
                        if (product.getProductNumber() == popularPizzaNumber) {
                            pizzaName = product.toString();
                            break;
                        }
                    }
                    if (!pizzaName.equals("Unknown Pizza")) break;
                }

                System.out.printf("%d. %s (Ordered %d times)%n",
                        rank, pizzaName, maxCount);
                productCount[popularPizzaNumber] = 0;
            } else {
                break; // No more pizzas with orders
            }
        }
    }
}