package nl.rug.oop.rpg.Entities.Traders;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;

/**
 * NPC who sells weapons.
 */
public class MuffinMan extends NPC {

    private Weapon[] weapons;

    /**
     * Constructor for trader MuffinMan.
     * @param description a string describing the NPC
     */
    public MuffinMan(String description) {
        super(description);
        weapons = new Weapon[4];
        weapons[0] = new Weapon("Pin Roller", "Flatten your enemies like dough.", 14);
        weapons[1] = new Weapon("Sprinkles", "Throw sprinkles in the monster's eyes!", 15);
        weapons[2] = new Weapon("Baguette", "Similar to a sword, but made of bread.", 18);
        weapons[3] = new Weapon("GingerBread Man's left leg", "A mini gingerbread leg.", 20);
    }

    @Override
    public void interact(Player player) {
        System.out.println("Hello traveler! Interested in some goods?");
        for(int i = 0; i < 4; i++) {
            System.out.printf("(%d)", i);
            weapons[i].inspect();
        }
        int command = 0;
        try {
            command = StdIO.integerInput(3);
        } catch (IOException e) {
            System.out.println("See you another time!");
            return;
        }
        System.out.println("Here you go!");
        player.addWeapon(weapons[command]);
    }
}
