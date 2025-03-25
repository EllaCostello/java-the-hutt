package services;

import models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    OrderManager orderManager = new OrderManager();
    // private Product productMenu = new Product();
    private Menu menu = new Menu();
    private OrderHistory orderHistory = new OrderHistory();

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
                4. Vis ordredetaljer
                5. Færdiggør ordre
                6. Annuller ordre
                7. Se mest populære product
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
        boolean running = true;
        while (running) {
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
                    displayMostPopularItem();
                    break;
                case 8:
                    getTurnover();
                    break;
                case 9:
                    running = false;
                    System.out.println("Afslutter programmet...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igen.");
            }

            printMainMenu();
        }
    }

    public void displayMostPopularItem() {
        Statistics statistics = new Statistics();
        statistics.calculateMostOrderedItems(orderHistory.getAllOrdersList());
    }

    public void getTurnover() {
        double turnover = orderHistory.getTurnover();
        System.out.printf("Omsætning I ALT: %.2f \n", turnover);
    }

}