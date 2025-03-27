package services;

import models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class OrderManager {
    private final Menu menu;
    private final ArrayList<Order> activeOrders;
    private final OrderStatistics orderStatistics;
    Scanner scanner;

    public OrderManager(Menu menu) {
        this.menu = menu;
        this.activeOrders = new ArrayList<>();
        this.orderStatistics = new OrderStatistics();
        this.scanner = new Scanner(System.in);

    }

    public void createOrder() {
        System.out.print("Indtast afhentningstid i minutter: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Ugyldigt input, prøv igen: ");
            scanner.next();
        }
        int pickupTime = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(pickupTime);

        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Indtast produktnummer (eller 0 for at afslutte): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ugyldigt input, prøv igen: ");
                scanner.nextLine();
            }
            int productNumber = scanner.nextInt();
            scanner.nextLine();

            if (productNumber == 0) {
                addingProducts = false;
                continue;
            }

            Product product = menu.findProductByNumber(productNumber);
            if (product == null) {
                System.out.println("Produkt ikke fundet, prøv igen.");
                continue;
            }

            System.out.print("Indtast antal: ");
            while (!scanner.hasNextInt() || scanner.nextInt() != 0) {
                System.out.print("Ugyldigt antal, prøv igen: ");
                scanner.next();
            }
            int quantity = scanner.nextInt();
            scanner.nextLine();


            order.addOrderLine(product, quantity);
            System.out.println(quantity + " stk. " + product.getName() + " tilføjet til ordre." );
        }

        activeOrders.add(order);
        System.out.println("Ordre #" + order.getId() + " oprettet.");
        System.out.println(order);

    }

    public void completeOrder() {
        System.out.print("Indtast ordre-ID der skal færdiggøres: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Ugyldigt input, prøv igen: ");
            scanner.next();
        }
        int orderId = scanner.nextInt();
        scanner.nextLine();

        Order orderToComplete = findOrder(orderId);
        if (orderToComplete == null) {
            System.out.println("Ordre ikke fundet.");
            return;
        }

        activeOrders.remove(orderToComplete);
        orderToComplete.setOrderStatus(OrderStatus.COMPLETED);
        orderStatistics.addCompletedOrder(orderToComplete);
        System.out.println("Ordre #" + orderToComplete.getId() + " færdiggjort.");
    }

    public void cancelOrder() {
        System.out.print("Indtast ordre-ID der skal annulleres: ");

        Order orderToCancel = handleIDInput();
        if (orderToCancel == null) {
            System.out.println("Ordre ikke fundet.");
            return;
        }

        activeOrders.remove(orderToCancel);
        orderToCancel.setOrderStatus(OrderStatus.CANCELLED);
        System.out.println("Ordre #" + orderToCancel.getId() + " annulleret.");
    }

    private Order findOrder(int orderId) {
        return activeOrders.stream()
                .filter(o -> o.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    public void displayOrderList() {
        ArrayList<Order> allOrdersSorted = activeOrders;

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
        orderStatistics.calculateMostOrderedItems();
    }

    public void displayTurnover() {
        System.out.printf("Omsætning I ALT: %.2f kr.\n", orderStatistics.getTurnover());
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

            if (findOrder(chosenID) != null) {
                return findOrder(chosenID);
            }
            System.out.println("Vi kunne ikke finde ordren tilknyttet dette ID, prøv venligst igen: ");
        }
    }
}
