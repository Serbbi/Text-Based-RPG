package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.GameEngine.Game;

/**
 * This interface implements a method for menus to be shown.
 */
public interface MenuOption {
    void execute(Game game);
}
