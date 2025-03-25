package services;

import models.Menu;
import models.Order;
import models.OrderHistory;

import java.util.ArrayList;
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

    public void cancelOrder() {};

    public void viewOrder() {};


}
