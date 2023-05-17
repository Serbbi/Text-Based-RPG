package nl.rug.oop.rpg.GameEngine;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Environment.Map;
import nl.rug.oop.rpg.Menu.InterfaceMenu;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * This is where the initialization of the game takes place.
 */
public class Game implements Serializable {
    private static final long serialVersionUID = 48L;

    private Map map;
    private Player player;

    /**
     * Constructor that initialises a new game.
     */
    public Game() {
        this.map = new Map();
        this.player = new Player(map.getStartingRoom(), 100);
    }

    public Game(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    /**
     * Initialization of objects in the game and main game loop.
     */
    public void play() {
        InterfaceMenu menu = new InterfaceMenu();

        System.out.println("Hello!");

        int command = -1;

        while (true) {
            menu.getMenuOption().get(-1).execute(this);

            try {
                command = StdIO.integerInput(0, 9);
                menu.getMenuOption().get(command).execute(this);
            } catch (InputMismatchException e) {
                System.out.println("Invalid! Please try again:");
                StdIO.clearLineFeed();
            } catch (IOException e) {
                System.out.println("Invalid! Please try again:");
                StdIO.clearLineFeed();
            }

            // Ends the game after the end game menu option has been called.
            // Only exits after the menu option has asked about saving.
            if (command == 9) {
                break;
            }

            if (player.isDead()) {
                player.die();
                return;
            }
        }
    }

    public static void endGame() {
        StdIO.closeScanner();
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return this.player;
    }
}
