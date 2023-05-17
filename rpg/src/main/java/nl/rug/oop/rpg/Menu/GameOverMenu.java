package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;

/**
 * The menu when the player dies.
 */
public class GameOverMenu implements MenuOption{
    @Override
    public void execute(Game game) {
        Player player = game.getPlayer();

        // deletes the saved game
        System.out.println("(0) New game");
        System.out.println("(1) Exit");
        int command = -1;
        while (command == -1) {
            try {
                command = StdIO.integerInput(-1, player.getCurrentRoom().getDoorsCount());
            } catch (IOException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        if (command == 0) {
            // this has to be changed
            Game.endGame();
        } else if (command == 1) {
            System.out.println("Exiting.....");
            Game.endGame();
            System.exit(1);
        }
    }
}
