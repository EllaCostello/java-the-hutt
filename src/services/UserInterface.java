package services;

import models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Product productMenu = new Product();
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
                    displayMenu();
                    break;
                case 2:
                    displayOrderList();
                    break;
                case 3:
                    createOrder();
                    break;
                case 4:
//                    productMenu.modifyProduct(1, 100);
                    viewOrderDetails();
                    break;
                case 5:
                    completeOrder();
                    break;
                case 6:
                    cancelOrder();
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

    public void displayMenu() {
        System.out.print("""
                                             ----------------                                          ------
                                            |    Menukort    |                                        | Pris |
                                             ----------------                                          ------
                """);
        for (Product product : productMenu.getProducts()) {
            System.out.println(product.getProductNumber() + ". " + product.productMenu());
        }
    }


    public void displayOrderList() {
        ArrayList<Order> allOrdersSorted = orderHistory.getAllOrdersList();

        if (!allOrdersSorted.isEmpty()) {
            System.out.println("""
                                              ------------------
                                             |   Aktive Ordre  |
                                              ------------------
                    """);

            allOrdersSorted.stream()
                    .filter(order -> order.getOrderstatus() == OrderStatus.IN_PROGRESS)
                    .sorted(Comparator.comparing(Order::getPickupTime))
                    .forEach(System.out::println);
        } else {
            System.out.println("Der er ingen aktive ordre");
        }
    }


    public void createOrder() {
        System.out.println("Indtast afhentningstid i minutter:");
        int pickupTime = scanner.nextInt();
        scanner.nextLine();

        Order newOrder = new Order(pickupTime);
        boolean addingPizzas = true;

        while (addingPizzas) {
            System.out.println("Indtast product nummer (0 for at afslutte):");
            int pizzaNum = scanner.nextInt();
            scanner.nextLine();

            if (pizzaNum == 0) {
                addingPizzas = false;
            } else {
                newOrder.addProductToOrder(pizzaNum);
            }
        }

        System.out.println("Din ordre:");
        System.out.println(newOrder);
        orderHistory.addToHistory(newOrder);
    }

    public void completeOrder() {
        displayOrderList();

        System.out.println("""
                Indtast venligst ID på den ordre du gerne vil færdiggøre:\s""");

        Order orderToComplete = handleIDInput();

        if (orderToComplete != null) {
            orderToComplete.setOrderstatus(OrderStatus.COMPLETED);
            System.out.println("Ordre med ID: " + orderToComplete.getId() + " er nu færdiggjort");
        }
    }

    public void viewOrderDetails() {
        System.out.println("Indtast venligst ID på den ordre du gerne vil se: ");

        Order orderToView = handleIDInput();

        if (orderToView != null) {
            System.out.println(orderToView);
        }
    }

    public void cancelOrder() {
        System.out.println("Indtast venlig ID på den ordre der skal annuleres: ");

        Order orderToCancel = handleIDInput();

        if (orderToCancel != null) {
            System.out.println("DU ER VED AT ANNULERE DENNE ORDRE:");
            System.out.println(orderToCancel);
            System.out.println("""
                    1. BEKRÆFT
                    2. FOTRYD
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                orderHistory.getAllOrdersList().remove(orderToCancel);
                System.out.println("Ordren er blevet annuleret");
            }
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

    public Order handleIDInput() {
        int chosenID;

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Vi kunne ikke forstå dit ønske, prøv venligst igen: ");
                scanner.nextLine();
                continue;
            }

            chosenID = scanner.nextInt();
            scanner.nextLine();

            for (Order order : orderHistory.getAllOrdersList()) {
                if (order.getId() == chosenID) {
                    return order;
                }
            }
            System.out.println("Vi kunne ikke finde ordren tilknyttet dette ID, prøv venligst igen: ");
        }
    }
}