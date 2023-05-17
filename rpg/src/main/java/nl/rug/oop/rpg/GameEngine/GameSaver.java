package nl.rug.oop.rpg.GameEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Used for file IO to save and load games.
 */
public class GameSaver {

    /**
     * Initialises the savegames Path.
     * 
     * @return Path
     * @throws IOException IOException
     */
    private static File initFolder() throws IOException {
        // Path saveDirectory = Path.of("savedgames");
        // Files.createDirectory(saveDirectory);

        File saveDirectory = new File("savedgames");
        saveDirectory.mkdir();

        return saveDirectory;
    }

    /**
     * Saves a file to the quicksave file.
     *
     * @param game     Game to be saved.
     * @param gameName name of the save file.
     * @throws IOException IOException
     */
    public static void saveGame(Game game, String gameName) throws IOException {

        File saveDirectory = initFolder();
        File saveFile = new File(saveDirectory.getName() + "/" + gameName + ".ser");

        FileOutputStream fos = new FileOutputStream(saveFile);
        ObjectOutputStream out = new ObjectOutputStream(fos);

        out.writeObject(game);

        out.flush();
        fos.close();
    }

    /**
     * Loads a saved game.
     *
     * @param gameName name of the save file to be loaded
     * @return Game
     * @throws IOException            IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static Game loadGame(String gameName) throws IOException, ClassNotFoundException {
        File saveDirectory = initFolder();
        File saveFile = new File(saveDirectory.getName() + "/" + gameName);

        FileInputStream fis = new FileInputStream(saveFile);
        ObjectInputStream inp = new ObjectInputStream(fis);

        Game game = (Game) inp.readObject();

        inp.close();

        return game;
    }

    /**
     * Loads a game from savedgames folder.
     * 
     * @return Game loaded from file
     * @throws IOException            Unable to load the file
     * @throws ClassNotFoundException Unable to read object from file.
     */
    public static Game loadGameSave() throws IOException, ClassNotFoundException {
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

        int command = -1;
        command = StdIO.integerInput(-1, listOfFiles.length);

        if (command == -1) {
            return null;
        }
        String gameName = listOfFiles[command].getName();

        return loadGame(gameName);
    }
}
