import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Pizza pizzaMenu;
    private OrderHistory orderHistory = new OrderHistory();


    public UserInterface(Pizza pizzaMenu) {
        this.pizzaMenu = pizzaMenu;
    }

    public void inputHandling() {
        boolean running = true;
        while (running) {
            System.out.println(" ");
            System.out.println("Vælg et alternativ: ");
            System.out.println("1. Vis menu");
            System.out.println("2. Vis ordre liste");
            System.out.println("3. Opret ordre");
            System.out.println("4. Se mest populære varer");
            System.out.println("5. Se total omsætning");
            System.out.println("6. Afslut program");
            System.out.println(" ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    displayOrderList();
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
        }
    }

    public void displayMenu() {
        System.out.println(" ---- Pizza Menu ---- ");
        for (Pizza pizza : pizzaMenu.getPizzas()) {
            System.out.println(pizza.getPizzaNumber() + ". " + pizza);
        }
    }

    public void displayOrderList() {
        System.out.println("---- Ordre Liste ----");
        orderHistory.getAllOrders();
    }

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
