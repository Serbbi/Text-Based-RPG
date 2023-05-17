package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.GameEngine.StdIO;

/**
 * The menu which displays the players weapons.
 */
public class CheckWeaponsMenu implements MenuOption {
    @Override
    public void execute(Game game) {
        Player player = game.getPlayer();
        if (player.getWeaponCount() == 0) {
            System.out.println("You have no weapons");
            return;
        }

        player.displayWeaponsList();

        // for (int i = 0; i < player.getWeapons().length; i++) {
        // Weapon weapon = player.getWeapons()[i];
        // System.out.printf(" Slot %d: ", i+1);
        // if (weapon != null) {
        // weapon.inspect();
        // } else {
        // System.out.println("Empty!/");
        // }
        // }

        if (player.getWeaponCount() > 1) {
            System.out.println("Would you like to swap weapons around?");
            boolean swap = StdIO.yesNoInput();
            if (!swap) {
                player.swapWeapons();
            }
        }
    }
}
