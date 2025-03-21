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

        int[] pizzaCount = new int[31];

        for (Order order : allTimeOrders) {
            for (Pizza pizza : order.getOrderList()) {
                int pizzaNumber = pizza.getPizzaNumber();
                pizzaCount[pizzaNumber]++;
            }
        }

        int maxCount = 0;
        int mostPopularPizzaNumber = 0;

        for (int i = 1; i < pizzaCount.length; i++) {
            if (pizzaCount[i] > maxCount) {
                maxCount = pizzaCount[i];
                mostPopularPizzaNumber = i;
            }
        }

        Pizza pizza = new Pizza();
        String pizzaName = pizza.getPizzas().get(mostPopularPizzaNumber - 1).toString();

        System.out.println("Most popular pizza: " + pizzaName);
        System.out.println("Ordered " + maxCount + " times");
    }
}

//calculateTurnover(arraysList<order> allTimeOrders)