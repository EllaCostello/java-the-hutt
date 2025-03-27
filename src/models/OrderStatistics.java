package models;

import java.util.ArrayList;

public class OrderStatistics {
    private final ArrayList<Order> COMPLETED_ORDERS;
    private double totalTurnover;

    public OrderStatistics() {
        this.COMPLETED_ORDERS = new ArrayList<>();
        this.totalTurnover = 0.0;
    }

    public void addCompletedOrder(Order order) {
        COMPLETED_ORDERS.add(order);
        totalTurnover += order.getTotal();
    }

    public double getTurnover() {
        return totalTurnover;
    }

    public void calculateMostOrderedItems() {
        if (COMPLETED_ORDERS.isEmpty()) {
            System.out.println("Ingen bestillinger er gennemført endnu.");
            return;
        }

        ArrayList<Product> orderedProducts = new ArrayList<>();
        ArrayList<Integer> productCounts = new ArrayList<>();

        for (Order order : COMPLETED_ORDERS) {
            for (OrderLine line : order.getORDER_LINES()) {
                Product product = line.getProduct();
                int quantity = line.getQUANTITY();
                int index = orderedProducts.indexOf(product);

                if (index == -1) {
                    orderedProducts.add(product);
                    productCounts.add(quantity);
                } else {
                    productCounts.set(index, productCounts.get(index) + quantity);
                }
            }
        }

        int maxCount = 0;
        Product mostPopular = null;

        for (int i = 0; i < orderedProducts.size(); i++) {
            if (productCounts.get(i) > maxCount) {
                maxCount = productCounts.get(i);
                mostPopular = orderedProducts.get(i);
            }
        }

        if (mostPopular != null) {
            System.out.printf("Mest populære produkt: %s (Bestilt: %d gange)\n",
                    mostPopular.getName(), maxCount);
        }
    }
}
