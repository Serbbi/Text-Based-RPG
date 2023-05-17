package nl.rug.oop.rpg.Entities.Wizards;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.GameEngine.StdIO;

/**
 * A NPC who gives you a weapon if you decide to take on the.
 */
public class Alfred extends NPC {

    private int oneTime = 1;

    /**
     * Constructor for wizard Alfred NPC.
     * @param description a string describing the NPC
     */
    public Alfred(String description) {
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("Sup bruh! My name is Alfred, but you can call me Alfred.");
        System.out.println("I have toothpaste to heal you." +
                " Also if you are willing to fight the boss right now, I'll teleport you there.");
        System.out.println("I'll give a weapon to fight him of course..." +
                " No don't ask me about about how I can teleport you.");

        boolean command = StdIO.yesNoInput();
        if (!command) {
            if (oneTime == 1) {
                player.addWeapon(new Weapon("Magic Wand Of Magic", "Deals magic damage.", 30));
                System.out.println("WHOOSH WHOOSH...");
                oneTime = 0;
            }
            player.setHealth(player.getHealth() + 60);
            player.getCurrentRoom().getDoor(2).interact(player);
            player.getCurrentRoom().getDoor(1).interact(player);
        } else {
            player.setHealth(player.getHealth() + 60);
            System.out.println("Cya!");
        }
    }
}
