package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;

/**
 * Menu for finding new doors.
 */
public class FindWayOutMenu implements MenuOption{
    /**
     * The menu for finding new doors.
     *
     * @param game The current game.
     */
    @Override
    public void execute(Game game) {
        Player player = game.getPlayer();

        if (player.getCurrentRoom().getDoorsCount() == 0) {
            System.out.println("Looks like you are stuck :(");
            return;
        }

        player.getCurrentRoom().findWayOut();

        int command = -1;
        // Repeats
        while (command == -1) {
            try {
                command = StdIO.integerInput(-1, player.getCurrentRoom().getDoorsCount());
            } catch (IOException e) {
                System.out.println("Invalid input. Please try again.");
                player.getCurrentRoom().findWayOut();
            }
        }

        if (command != 0) {
            player.getCurrentRoom().getDoor(command - 1).interact(player);
        }
    }

}
