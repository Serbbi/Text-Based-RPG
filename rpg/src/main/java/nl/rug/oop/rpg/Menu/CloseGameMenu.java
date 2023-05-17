package nl.rug.oop.rpg.Menu;

import java.io.IOException;

import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.GameSaver;
import nl.rug.oop.rpg.GameEngine.StdIO;

/**
 * Menu which shows up when exiting the game.
 */
public class CloseGameMenu implements MenuOption {

    @Override
    public void execute(Game game) {
        System.out.println("Would you like to save this game?");
        boolean command = StdIO.yesNoInput();

        if (!command) {
            try {

                System.out.println("Game save name:");
                String gameName = StdIO.stringInput();
                GameSaver.saveGame(game, gameName);

            } catch (IOException e) {
                System.out.println("Unable to save the game.");
            }
        }

        Game.endGame();
    }

}
