package services;

import models.Menu;
import models.Order;
import models.OrderHistory;
import models.OrderStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class OrderManager {
    private Scanner scanner;
    private OrderHistory orderHistory;
    private Menu menu;

    public OrderManager() {
        this.orderHistory = new OrderHistory();
        this.menu = new Menu();
        this.scanner = new Scanner(System.in);
    }

    public void createOrder() {
        System.out.println("Indtast afhentningstid i minutter:");
        int pickupTime = scanner.nextInt();
        scanner.nextLine();

        Order newOrder = new Order(pickupTime);
        boolean addingProducts = true;

        while (addingProducts) {
            System.out.println("Indtast product nummer (0 for at afslutte):");

            while (!scanner.hasNextInt()) {
                System.out.println("Ugyldig Indtastning, prøv igen: ");
                scanner.nextLine();
            }

            int pizzaNum = scanner.nextInt();
            scanner.nextLine();

            if (pizzaNum == 0) {
                addingProducts = false;
            } else {
                newOrder.addProductToOrder(pizzaNum);
            }
        }

        System.out.println("Din ordre:");
        System.out.println(newOrder);
        orderHistory.addToHistory(newOrder);
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
