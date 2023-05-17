package nl.rug.oop.rpg.Menu;

import java.io.IOException;

import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.GameSaver;
import nl.rug.oop.rpg.GameEngine.StdIO;

/**
 * Menu which shows up when saving a game with a custom name.
 */
public class SaveMenu implements MenuOption {

    @Override
    public void execute(Game game) {
        try {
            String gameName = StdIO.stringInput();

            GameSaver.saveGame(game, gameName);

            System.out.println("Game has been saved!");
        } catch (IOException e) {
            System.out.println("Unable to save the game.");
        }
    }

}
