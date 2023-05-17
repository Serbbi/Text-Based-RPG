package nl.rug.oop.rpg.Entities.Traders;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;

/**
 * NPC who sells weapons.
 */
public class Shrek extends NPC {

    private int oneTime = 1;

    private Weapon[] weapons;

    /**
     * Shrek constructor.
     * @param description The description of the NPC
     */
    public Shrek(String description) {
        super(description);
        weapons = new Weapon[4];
        weapons[0] = new Weapon("Rat Beater", "The perfect weapon to beat rats.", 2);
        weapons[1] = new Weapon("Basic Stick", "Just a little stick.", 2);
        weapons[2] = new Weapon("Swamp Defender", "Intruders on your swamp? No problem.", 10);
        weapons[3] = new Weapon("Health Potion", "Restores 50 hitpoints.", 0);
    }

    @Override
    public void interact(Player player) {
        if(oneTime == 1) {
            System.out.println("SomeBODY once told me the world is gonna roll me\n" +
                    "I ain't the sharpest tool in the shEEEd\n" +
                    "She was looking kind of dumb with her finger and her thumb\n" +
                    "In the shape of an \"L\" on her forehead!");
            oneTime = 0;
        }
        System.out.println("Hello there little guy, I'm Shrek. I sell weapons and potions. Want to try some?");
        for(int i = 0; i < 4; i++) {
            System.out.printf("(%d)", i);
            weapons[i].inspect();
        }
        int command = 0;
        try {
            command = StdIO.integerInput(2);
        } catch (IOException e) {
            System.out.println("See you another time!");
            return;
        }
        System.out.println("Here you go!");
        if (command == 3) {
            System.out.println("You drink the healing potion. Your wounds are magically healed.");
            player.setHealth(player.getHealth() + 50);
        } else {
            player.addWeapon(weapons[command]);
        }
    }
}
