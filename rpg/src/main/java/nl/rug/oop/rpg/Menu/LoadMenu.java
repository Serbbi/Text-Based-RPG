package nl.rug.oop.rpg.Menu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.GameSaver;
import nl.rug.oop.rpg.GameEngine.StdIO;

/**
 * Menu which shows a list of save files to be loaded.
 */
public class LoadMenu implements MenuOption {

    @Override
    public void execute(Game game) {

        Path saveDirectory = Paths.get("savedgames");
        File folder = new File(String.valueOf(saveDirectory.getFileName()));
        File[] listOfFiles = folder.listFiles();

        System.out.println("Which file?\n(-1) none");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.printf("(%d) ", i);
                System.out.printf(listOfFiles[i].getName() + "\n");
            }
        }

        try {
            int command = -1;
            command = StdIO.integerInput(-1, listOfFiles.length);

            if (command == -1) {
                return;
            }
            String gameName = listOfFiles[command].getName();

            Game loadedGame = GameSaver.loadGame(gameName);
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
