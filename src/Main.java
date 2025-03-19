public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.printMenu();

        Order order = new Order(30);
        order.addPizzaToOrder(1);
        order.addPizzaToOrder(30);
        System.out.println(order);




    }
}
