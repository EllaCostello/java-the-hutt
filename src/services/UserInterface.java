package services;

import models.*;
import util.InputHelper;

public class UserInterface {

    private final Menu MENU = new Menu();
    private final OrderManager ORDER_MANAGER = new OrderManager(MENU);

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
                
                \s""");

            handleMenuChoice();
        }
    }

    private void handleMenuChoice() {
        int choice = InputHelper.getIntInput("Indtast valg her: ", "Vi kunne ikke forstå dit ønske, prøv igen: ");


        switch (choice) {
            case 1 -> MENU.displayMenu();
            case 2 -> ORDER_MANAGER.displayOrderList();
            case 3 -> ORDER_MANAGER.createOrder();
            case 4 -> ORDER_MANAGER.completeOrder();
            case 5 -> ORDER_MANAGER.cancelOrder();
            case 6 -> ORDER_MANAGER.displayMostPopularItem();
            case 7 -> ORDER_MANAGER.displayTurnover();
            case 8 -> modifyProduct();
            case 9 -> {
                System.out.println("Afslutter programmet...");
                System.exit(0);
            }
            default -> System.out.println("Ugyldigt valg. Prøv igen.");
        }
    }

    public void modifyProduct() {
        int productNumber = InputHelper.getIntInput("Indtast produktnummer på det Produkt der skal ændres: ","Vi kunne ikke forstå din anmodning, prøv igen: " );


        Product product = MENU.findProductByNumber(productNumber);

        if (product != null) {
            System.out.println("Nuværende pris for " + product.getName() + ": " + product.getPrice() + " kr.");
            double newPrice = InputHelper.getDoubleInput("Indtast ny pris: ", "Fejl!");

            product.setPrice(newPrice);

            System.out.println("Produktprisen er blevet ændret.");
        } else {
            System.out.println("Produkt med det nummer blev ikke fundet.");
        }
    }

}