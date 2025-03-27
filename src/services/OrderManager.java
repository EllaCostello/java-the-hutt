package services;

import models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class OrderManager {
    private final Menu MENU;
    private final ArrayList<Order> ACTIVE_ORDERS;
    private final OrderStatistics ORDER_STATISTICS;
    private final Scanner SCANNER;

    public OrderManager(Menu menu) {
        this.MENU = menu;
        this.ACTIVE_ORDERS = new ArrayList<>();
        this.ORDER_STATISTICS = new OrderStatistics();
        this.SCANNER = new Scanner(System.in);

    }

    public void createOrder() {
        System.out.print("Indtast afhentningstid i minutter: ");
        while (!SCANNER.hasNextInt()) {
            System.out.print("Ugyldigt input, prøv igen: ");
            SCANNER.next();
        }
        int pickupTime = SCANNER.nextInt();
        SCANNER.nextLine();

        Order order = new Order(pickupTime);

        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Indtast produktnummer (eller 0 for at afslutte): ");
            while (!SCANNER.hasNextInt()) {
                System.out.print("Ugyldigt input, prøv igen: ");
                SCANNER.nextLine();
            }
            int productNumber = SCANNER.nextInt();
            SCANNER.nextLine();

            if (productNumber == 0) {
                addingProducts = false;
                continue;
            }

            Product product = MENU.findProductByNumber(productNumber);
            if (product == null) {
                System.out.println("Produkt ikke fundet, prøv igen.");
                continue;
            }

            System.out.print("Indtast antal: ");
            while (!SCANNER.hasNextInt()) {
                System.out.print("Ugyldigt antal, prøv igen: ");
                SCANNER.next();
            }
            int quantity = SCANNER.nextInt();
            SCANNER.nextLine();


            order.addOrderLine(product, quantity);
            System.out.println(quantity + " stk. " + product.getName() + " tilføjet til ordre." );
        }

        ACTIVE_ORDERS.add(order);
        System.out.println("Ordre #" + order.getID() + " oprettet.");
        System.out.println(order);

    }

    public void completeOrder() {
        System.out.print("Indtast ordre-ID der skal færdiggøres: ");
        while (!SCANNER.hasNextInt()) {
            System.out.print("Ugyldigt input, prøv igen: ");
            SCANNER.next();
        }
        int orderId = SCANNER.nextInt();
        SCANNER.nextLine();

        Order orderToComplete = findOrder(orderId);
        if (orderToComplete == null) {
            System.out.println("Ordre ikke fundet.");
            return;
        }

        ACTIVE_ORDERS.remove(orderToComplete);
        orderToComplete.setOrderStatus(OrderStatus.COMPLETED);
        ORDER_STATISTICS.addCompletedOrder(orderToComplete);
        System.out.println("Ordre #" + orderToComplete.getID() + " færdiggjort.");
    }

    public void cancelOrder() {
        System.out.print("Indtast ordre-ID der skal annulleres: ");

        Order orderToCancel = handleIDInput();
        if (orderToCancel == null) {
            System.out.println("Ordre ikke fundet.");
            return;
        }

        ACTIVE_ORDERS.remove(orderToCancel);
        orderToCancel.setOrderStatus(OrderStatus.CANCELLED);
        System.out.println("Ordre #" + orderToCancel.getID() + " annulleret.");
    }

    private Order findOrder(int orderId) {
        return ACTIVE_ORDERS.stream()
                .filter(o -> o.getID() == orderId)
                .findFirst()
                .orElse(null);
    }

    public void displayOrderList() {
        ArrayList<Order> allOrdersSorted = ACTIVE_ORDERS;

        if (!allOrdersSorted.isEmpty()) {
            System.out.println("""
                                              ------------------
                                             |   Aktive Ordre  |
                                              ------------------
                    """);

            allOrdersSorted.stream()
                    .filter(order -> order.getOrderStatus() == OrderStatus.IN_PROGRESS)
                    .sorted(Comparator.comparing(Order::getPickUpTime))
                    .forEach(System.out::println);
        } else {
            System.out.println("Der er ingen aktive ordre");
        }
    }

    public void displayMostPopularItem() {
        ORDER_STATISTICS.calculateMostOrderedItems();
    }

    public void displayTurnover() {
        System.out.printf("Omsætning I ALT: %.2f kr.\n", ORDER_STATISTICS.getTurnover());
    }

    public Order handleIDInput() {
        int chosenID;

        while (true) {
            if (!SCANNER.hasNextInt()) {
                System.out.println("Vi kunne ikke forstå dit ønske, prøv venligst igen: ");
                SCANNER.nextLine();
                continue;
            }

            chosenID = SCANNER.nextInt();
            SCANNER.nextLine();

            if (findOrder(chosenID) != null) {
                return findOrder(chosenID);
            }
            System.out.println("Vi kunne ikke finde ordren tilknyttet dette ID, prøv venligst igen: ");
        }
    }
}
