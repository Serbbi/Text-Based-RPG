package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.GameEngine.Game;

/**
 * The menu displays info about the current room.
 */
public class InspectMenu implements MenuOption{
    /**
     * Inspection menu.
     *
     * @param game The current game.
     */
    @Override
    public void execute(Game game) {
        game.getPlayer().getCurrentRoom().inspect();
    }
}
