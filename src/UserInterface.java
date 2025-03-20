import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Pizza pizzaMenu = new Pizza();
    private OrderHistory orderHistory = new OrderHistory();


    public void inputHandling() {
        boolean running = true;
        while (running) {
            System.out.print("Vælg et alternativ: ");
            System.out.println("1. Vis menu");
            System.out.println("2. Vis Se ordre liste");
            System.out.println("3. Opret ordre");
            System.out.println("4. Se mest populære varer");
            System.out.println("5. Se total omsætning");
            System.out.println("6. Afslut program");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // displayMenu(menu);
                    break;
                case 2:
                    // DisplayOrderList(0rder);
                    break;
                case 3:
                    // CreateOrder(order);
                    break;
                case 4:
                    // getMostPopularItem(statistics);
                    break;
                case 5:
                    // getTurnover(statistics);
                    break;
                case 6:
                    running = false;
                    System.out.println("Afslutter programmet...");
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igen.");
            }
        }
    }

    public void displayMenu() {
        System.out.println(" ---- Pizza Menu ---- ");
        for (Pizza pizza : pizzaMenu.getPizzas()) {
            System.out.println(pizza.getPizzaNumber() + ". " + pizza);
        }
    }

    private void displayOrderList() {
        System.out.println("\n---- Ordre Liste ----");
        orderHistory.getAllOrders();
    }
}
