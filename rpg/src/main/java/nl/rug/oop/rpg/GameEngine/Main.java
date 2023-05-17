package nl.rug.oop.rpg.GameEngine;

import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Main Class.
 */
public class Main {

    /**
     * Runs the game.
     */
    public static void welcomeScreen() {
        System.out.println("Welcome!");
        int command = -1;
        while (command == -1) {
            System.out.println("What would you like to do?");
            System.out.println(" (0) New Game");
            System.out.println(" (1) Load Game");
            System.out.println(" (2) Exit");
            try {
                command = StdIO.integerInput(2);
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Please try again:");
                StdIO.clearLineFeed();
            } catch (IOException e) {
                System.out.println("Invalid! Please try again:");
                StdIO.clearLineFeed();
            }
        }
        if (command == 2) {
            return;
        }

        Game game = new Game();
        if (command == 0) {
            System.out.println("What's your name?");
            game.getPlayer().setName(StdIO.stringInput());
            game.play();
        }

        if (command == 1) {
            boolean valid = false;
            while (!valid) {
                try {
                    game = GameSaver.loadGameSave();
                    if (game == null) {
                        return;
                    }
                    valid = true;
                } catch (IOException e) {
                    System.out.println("Invalid! Please try again...");
                } catch (ClassNotFoundException e) {
                    System.out.println("Invalid! Please try again...");
                }
            }
            game.play();
        }
    }

    /**
     * Main Method.
     *
     * @param args main method arguments.
     */
    public static void main(String[] args) {
        welcomeScreen();
        System.out.println("Goodbye!");
        StdIO.closeScanner();
    }
}