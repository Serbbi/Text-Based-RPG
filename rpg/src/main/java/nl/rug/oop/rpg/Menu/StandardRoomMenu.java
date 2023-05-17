package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.GameEngine.Game;

/**
 * This menu displays the standard actions a player can take.
 */
public class StandardRoomMenu implements MenuOption{
    /**
     * Standard menu.
     */
    @Override
    public void execute(Game game) {
        System.out.println("What do you want to do?");
        System.out.println(" (0) Look around");
        System.out.println(" (1) Look for a way out");
        System.out.println(" (2) Look for company");
        System.out.println(" (3) Manage weapons");
        System.out.println(" (4) Player stats");
        System.out.println(" (5) Quick Save");
        System.out.println(" (6) Quick Load");
        System.out.println(" (7) Save");
        System.out.println(" (8) Load");
        System.out.println(" (9) Leave the game");
    }
}
