public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.printMenu();

        Order order = new Order();
        order.addPizzaToOrder(1);
        order.addPizzaToOrder(30);
        System.out.println(order.calculateFullPrice());

        order.calculatePuckupTime(15);


    }
}
