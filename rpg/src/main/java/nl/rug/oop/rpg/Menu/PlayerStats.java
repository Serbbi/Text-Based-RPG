package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.GameEngine.Game;

/**
 * Menu that shows the player's name and hitpoints.
 */
public class PlayerStats implements MenuOption{
    @Override
    public void execute(Game game) {
        System.out.println("Player name: " + game.getPlayer().getName());
        System.out.println("Player health: " + game.getPlayer().getHealth());
    }
}
