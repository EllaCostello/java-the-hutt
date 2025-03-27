package services;

import models.*;

import java.util.Scanner;
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();
    private final OrderManager orderManager = new OrderManager(menu);

    public void printMainMenu() {
        while (true) {
            System.out.println("""
                    ---------------
                   |     START     |
                    ---------------
                Hvad kunne du tænke dig?
                
                1. Vis menukort
                2. Vis aktive ordre
                3. Opret ny ordre
                4. Færdiggør ordre
                5. Annuller ordre
                6. Se mest populære produkt
                7. Se total omsætning
                8. Ændre prisen på et produkt
                9. Afslut program
                
                Indtast valg her:\s""");

            handleMenuChoice();
        }
    }

    private void handleMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Vi kunne ikke forstå dit ønske, prøv igen: ");
            scanner.next();
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> menu.displayMenu();
            case 2 -> orderManager.displayOrderList();
            case 3 -> orderManager.createOrder();
            case 4 -> orderManager.completeOrder();
            case 5 -> orderManager.cancelOrder();
            case 6 -> orderManager.displayMostPopularItem();
            case 7 -> orderManager.displayTurnover();
            case 8 -> modifyProduct();
            case 9 -> {
                System.out.println("Afslutter programmet...");
                System.exit(0);
            }
            default -> System.out.println("Ugyldigt valg. Prøv igen.");
        }
    }

    public void modifyProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast produktnummer på det Produkt der skal ændres:");

        while (!scanner.hasNextInt()) {
            System.out.println("Vi kunne ikke forstå din anmodning, prøv igen: ");
        }

        int productNumber = scanner.nextInt();
        scanner.nextLine();

        Product product = menu.findProductByNumber(productNumber);

        if (product != null) {
            System.out.println("Nuværende pris for " + product.getName() + ": " + product.getPrice() + " kr.");
            System.out.print("Indtast ny pris: ");
            double newPrice = scanner.nextDouble();

            product.setPrice(newPrice);

            System.out.println("Produktprisen er blevet ændret.");
        } else {
            System.out.println("Produkt med det nummer blev ikke fundet.");
        }
    }

}