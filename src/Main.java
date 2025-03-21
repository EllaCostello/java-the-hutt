public class Main {
    public static void main(String[] args) {
        /* Order order = new Order(30);
        order.addPizzaToOrder(1);
        order.addPizzaToOrder(30);
        order.setOrderstatus(OrderStatus.ACTIVE);

        Order order1 = new Order(15);
        order1.addPizzaToOrder(5);
        order1.setOrderstatus(OrderStatus.ACTIVE);

        Order order2 = new Order(40);
        order2.addPizzaToOrder(10);
        order2.setOrderstatus(OrderStatus.ACTIVE);
        order2.setOrderstatus(OrderStatus.COMPLETED);

        Order.getOrderHistory().getAllOrders();
        System.out.println(Order.getOrderHistory().returnTurnoverTotal());

        order2.setIngredient(10, "tomato");
        order2.getIngredient(1);
        System.out.println(order2.getIngredient(10));

        // Statistics integration
        Statistics stats = new Statistics();
        stats.collectAllTimeOrders();
        stats.calculateMostOrderedItems(stats.getAllTimeOrders());

         */


        while (true) {
            UserInterface userInterface = new UserInterface();
            userInterface.printMainMenu();
        }
    }
}