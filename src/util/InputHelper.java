package util;

import java.util.Scanner;

public final class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    private InputHelper() {}

    public static int getIntInput(String prompt, String errorMessage) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print(errorMessage);
            scanner.nextLine();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
    public static double getDoubleInput(String prompt, String errorMessage) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print(errorMessage);
            scanner.nextLine();
        }
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

}
