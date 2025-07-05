
import java.util.Scanner;

public class InputValidator {
    static Scanner scanner = new Scanner(System.in);

    public static int getValidatedInteger(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
            return getValidatedInteger(prompt);
        }
    }

    public static String getValidatedString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return getValidatedString(prompt);
        }
        return input;
    }
}
