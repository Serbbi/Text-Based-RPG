package nl.rug.oop.rpg.Entities.Traders;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;

/**
 * NPC who sells weapons.
 */
public class GingerBreadMan extends NPC {

    private Weapon[] weapons;

    /**
     * Constructor for trader GingerBreadMan.
     * @param description a string describing the NPC
     */
    public GingerBreadMan(String description) {
        super(description);
        weapons = new Weapon[4];
        weapons[0] = new Weapon("Chocolate Croissant", "Let me feed you some french.", 13);
        weapons[1] = new Weapon("Throwing Cactus Needles", "How can you hold these?", 16);
        weapons[2] = new Weapon("No u", "Defeat your enemies with facts.", 10);
        weapons[3] = new Weapon("Asparagus ", "One of the strongest swords to ever exist.", 15);
    }

    @Override
    public void interact(Player player) {
        System.out.println("Do you know the MuffinMan?");
        for(int i = 0; i < 4; i++) {
            System.out.printf("(%d)", i);
            weapons[i].inspect();
        }
        int command = 0;
        try {
            command = StdIO.integerInput(3);
        } catch (IOException e) {
            System.out.println("Call me maybe!");
            return;
        }
        System.out.println("You really chose that?");
        player.addWeapon(weapons[command]);
    }
}
