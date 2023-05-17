package nl.rug.oop.rpg.Menu;

import java.io.IOException;

import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.GameSaver;

/**
 * Menu Option for performing a quick load.
 */
public class QuickLoadMenu implements MenuOption {

    @Override
    public void execute(Game game) {
        try {
            Game loadedGame = GameSaver.loadGame("quicksave.ser");
            
            System.out.printf("Welcome back %s", loadedGame.getPlayer().getName());

            game.setMap(loadedGame.getMap());
            game.setPlayer(loadedGame.getPlayer());

            System.out.println("Game has been loaded!");
        } catch (IOException e) {
            System.out.println("Unable to load game.");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load game.");
        }

    }
}
