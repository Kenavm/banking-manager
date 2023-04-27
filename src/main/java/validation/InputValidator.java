package validation;
import java.util.Scanner;

public class InputValidator {

    public static double validateDoubleInput(String input) {
        double result = -1.0;
        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            Scanner s = new Scanner(System.in);
            result = validateDoubleInput(s.nextLine());
        }
        return result;
    }
}