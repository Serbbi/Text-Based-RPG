package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;

/**
 * The menu displays all the NPCs in the room.
 */
public class LookForCompanyMenu implements MenuOption{
    /**
     * The menu for finding friends.
     *
     * @param game The current game.
     */
    @Override
    public void execute(Game game) {
        Player player = game.getPlayer();

        int command;

        if (player.getCurrentRoom().getNpcs().size() == 0) {
            System.out.println("There's nobody here.");
            return;
        }

        System.out.println("You look if there's someone here.\nYou see:");
        player.getCurrentRoom().listNPCs();

        System.out.println("Interact ? (-1 : do nothing)");

        try {
            command = StdIO.integerInput(-1, player.getCurrentRoom().getNpcs().size() - 1);

        } catch (IOException e) {
            System.out.println("Invalid Input.");
            return;
        }
        if (command == -1) {
            return;
        }
        NPC chosenNPC = player.getCurrentRoom().getNpcs().get(command);
        chosenNPC.interact(player);
    }
}
