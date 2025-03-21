import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Pizza pizzaMenu = new Pizza();
    private OrderHistory orderHistory = new OrderHistory();
    // private ArrayList<Order> getActiveOrders = Order.ge;


    public UserInterface() { }

    public void printMainMenu() {
        System.out.println("""
                    ---------------
                   |     START     |
                    ---------------
                Hvad kunne du tænke dig?
                
                1. Vis menukort
                2. Vis aktive ordre
                3. Opret ny ordre
                4. Se mest populære vare
                5. Se total omsætning
                6. Afslut program
                
                Indtast valg her:\s""");

        handleMenuChoice();
    }

    public void handleMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Vi kunne ikke forstå dit ønske, prøv igen: ");
            scanner.next();
        }
        boolean running = true;
        while (running) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    // displayOrderList();
                    break;
                case 3:
                    createOrder();
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

            printMainMenu();
        }
    }

    public void displayMenu() {
        System.out.print("""
                                             ----------------                                          ------
                                            |    Menukort    |                                        | Pris |
                                             ----------------                                          ------
                """);
        for (Pizza pizza : pizzaMenu.getPizzas()) {
            System.out.println(pizza.getPizzaNumber() + ". " + pizza.pizzaMenu());
        }
    }

    /*
    public void displayOrderList() {
        System.out.println("---- Ordre Liste ----");
        for (Order order : order.getActiveOrders()) {
            System.out.println(order);
        }

    }

     */

    public void createOrder() {
        System.out.println("Indtast afhentningstid i minutter:");
        int pickupTime = scanner.nextInt();
        scanner.nextLine();

        Order newOrder = new Order(pickupTime);
        boolean addingPizzas = true;

        while (addingPizzas) {
            System.out.println("Indtast pizza nummer (0 for at afslutte):");
            int pizzaNum = scanner.nextInt();
            scanner.nextLine();

            if (pizzaNum == 0) {
                addingPizzas = false;
            } else {
                newOrder.addPizzaToOrder(pizzaNum);
            }
        }

        System.out.println("Din ordre:");
        System.out.println(newOrder);
        orderHistory.addToHistory(newOrder);
    }
}