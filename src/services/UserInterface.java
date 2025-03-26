package services;

import models.*;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderManager orderManager = new OrderManager();
    private final Menu menu = new Menu();
    private final OrderHistory orderHistory = new OrderHistory();

    public UserInterface() {}

    public void printMainMenu() {
        System.out.println("""
                    ---------------
                   |     START     |
                    ---------------
                Hvad kunne du tænke dig?
                
                1. Vis menukort
                2. Vis aktive ordre
                3. Opret ny ordre
                4. Vis ordredetaljer
                5. Færdiggør ordre
                6. Annuller ordre
                7. Se mest populære produkter (Top 3)
                8. Se total omsætning
                9. Afslut program
                
                Indtast valg her:\s""");

        handleMenuChoice();
    }

    public void handleMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Vi kunne ikke forstå dit ønske, prøv igen: ");
            scanner.next();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                menu.displayMenu();
                break;
            case 2:
                orderManager.displayOrderList();
                break;
            case 3:
                orderManager.createOrder();
                break;
            case 4:
                orderManager.viewOrderDetails();
                break;
            case 5:
                orderManager.completeOrder();
                break;
            case 6:
                orderManager.cancelOrder();
                break;
            case 7:
                showPopularPizzas();
                break;
            case 8:
                showTurnover();
                break;
            case 9:
                System.out.println("Afslutter programmet...");
                System.exit(0);
                break;
            default:
                System.out.println("Ugyldig valg. Prøv igen.");
        }

        // Return to menu after action (Added for nicer flow - Gustav)
        pressEnterToContinue();
        printMainMenu();
    }

    private void showPopularPizzas() {
        Statistics stats = new Statistics();
        stats.collectAllTimeOrders();

        if (stats.getAllTimeOrders().isEmpty()) {
            System.out.println("\nIngen ordrer at analysere endnu.");
        } else {
            System.out.println("\n--- Top 3 mest populære produkter ---");
            stats.printTop3MostPopularPizzas(stats.getAllTimeOrders());
        }
    }

    private void showTurnover() {
        double turnover = orderHistory.getTurnover();
        System.out.printf("\nTotal omsætning: %.2f kr.\n", turnover);
    }

    private void pressEnterToContinue() {
        System.out.print("\nTryk Enter for at fortsætte...");
        scanner.nextLine();
    }
}