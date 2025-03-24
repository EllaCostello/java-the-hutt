import services.UserInterface;

public class Main {
    public static void main(String[] args) {
        while (true) {
            UserInterface userInterface = new UserInterface();
            userInterface.printMainMenu();
        }
    }
}