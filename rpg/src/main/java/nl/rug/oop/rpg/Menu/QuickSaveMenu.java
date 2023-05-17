package nl.rug.oop.rpg.Menu;

import java.io.IOException;

import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.GameSaver;

/**
 * Menu Option for performing a quick save.
 */
public class QuickSaveMenu implements MenuOption {

    @Override
    public void execute(Game game) {
        try {
            GameSaver.saveGame(game, "quicksave");
            System.out.println("Game has been saved!");
        } catch (IOException e) {
            System.out.println("Unable to save the game.");
        }
    }
}
