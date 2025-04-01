package services;

import models.*;
import util.InputHelper;

import java.util.ArrayList;
import java.util.Comparator;

public class OrderManager {
    private final Menu MENU;
    private final ArrayList<Order> ACTIVE_ORDERS;
    private final OrderStatistics ORDER_STATISTICS;

    public OrderManager(Menu menu) {
        this.MENU = menu;
        this.ACTIVE_ORDERS = new ArrayList<>();
        this.ORDER_STATISTICS = new OrderStatistics();


    }

    public void createOrder() {
        int pickupTime = InputHelper.getIntInput("Indtast afhentningstid i minutter: ", "Ugyldigt input, prøv igen: ");

        Order order = new Order(pickupTime);

        boolean addingProducts = true;
        while (addingProducts) {

            int productNumber = InputHelper.getIntInput("Indtast produktnummer (eller 0 for at afslutte): ","Ugyldigt input, prøv igen: " );


            if (productNumber == 0) {
                addingProducts = false;
                continue;
            }

            Product product = MENU.findProductByNumber(productNumber);
            if (product == null) {
                System.out.println("Produkt ikke fundet, prøv igen.");
                continue;
            }

            int quantity = InputHelper.getIntInput("Indtast antal: ", "Ugyldigt antal prøv igen: ");



            order.addOrderLine(product, quantity);
            System.out.println(quantity + " stk. " + product.getName() + " tilføjet til ordre." );
        }

        ACTIVE_ORDERS.add(order);
        System.out.println("Ordre #" + order.getID() + " oprettet.");
        System.out.println(order);

    }

    public void completeOrder() {

        int orderId = InputHelper.getIntInput("Indtast ordre-ID der skal færdiggøres: ", "Ugyldigt input prøv igen: ");


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
            chosenID = InputHelper.getIntInput("Indtast ordre-ID der skal annulleres: ", "Vi kunne ikke forstå dit ønske, prøv venligst igen: ");


            if (findOrder(chosenID) != null) {
                return findOrder(chosenID);
            }
            System.out.println("Vi kunne ikke finde ordren tilknyttet dette ID, prøv venligst igen: ");
        }
    }
}
