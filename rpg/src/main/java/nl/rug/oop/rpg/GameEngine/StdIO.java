package nl.rug.oop.rpg.GameEngine;

import java.io.IOException;
import java.util.Scanner;

/**
 * Used for taking inputs, and doing common outputs.
 */
public class StdIO {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Closes the static scanner.
     */
    public static void closeScanner() {
        scanner.close();
    }

    /**
     * Getter for scanner.
     * 
     * @return scanner thing
     */
    public static Scanner getScanner() {
        return scanner;
    }

    /**
     * Used to take a yes, no response from the user.
     * 
     * @return boolean (yes = true, no = false)
     * @throws IOException Thrown if input is not 1 or 0
     */
    public static boolean yesNoInput() {
        int command = -1;
        while (command != 0 && command != 1) {
            System.out.println(" (0) Yes");
            System.out.println(" (1) No");

            command = scanner.nextInt();

            if (command == 1) {
                return true;
            } else if (command == 0) {
                return false;
            } else {
                System.out.println("Invalid! Please try again...");
            }
        }
        return false;

    }

    /**
     * Takes a string input from the terminal.
     * 
     * @return String input from user.
     */
    public static String stringInput() {
        String string = scanner.nextLine();
        if (string.equals("")) {
            string = scanner.nextLine();
        }
        return string;
    }

    /**
     * Used to take input between 0 and max from user using static scanner.
     * 
     * @param max Maximum integer that can be entered.
     * @return Integer between 0 and max
     * @throws IOException If results is outside allowed range.
     */
    public static int integerInput(int max) throws IOException {
        return StdIO.integerInput(0, max);
    }

    /**
     * Used to take input between min and max from user using static scanner.
     * 
     * @param min Minimum integer that can be entered.
     * @param max Maximum integer that can be entered.
     * @return Integer between min and max
     * @throws IOException If results is outside allowed range.
     */
    public static int integerInput(int min, int max) throws IOException {
        
        int command = scanner.nextInt();

        if (command >= min && command <= max) {
            return command;
        } else {
            throw new IOException("Invalid input.");
        }

    }

    /**
     * Used to clear the line feed in the case of invalid input on integerInput.
     */
    public static void clearLineFeed() {
        scanner.nextLine();
    }

}
