public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.printMenu();
        Pizza pizza = new Pizza();
        UserInterface userInterface = new UserInterface(pizza);
        userInterface.inputHandling();
    }
}
