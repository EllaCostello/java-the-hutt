public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.printMenu();

        Order order = new Order(30);
        order.addPizzaToOrder(1);
        order.addPizzaToOrder(30);
        // System.out.println(order);

        order.setOrderstatus(OrderStatus.COMPLETED);

        Order order1 = new Order(15);
        order1.addPizzaToOrder(5);
        order1.setOrderstatus(OrderStatus.COMPLETED);



        Order.getOrderHistory().getAllOrders();
        System.out.println(Order.getOrderHistory().returnTurnoverTotal());

    }
}
