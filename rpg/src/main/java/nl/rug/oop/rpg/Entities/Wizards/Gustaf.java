package nl.rug.oop.rpg.Entities.Wizards;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.GameEngine.StdIO;

/**
 * NPC who gives certain buffs to the player.
 */
public class Gustaf extends NPC {

    private int oneTime = 1;

    /**
     * Constructor for wizard NPC who heals the player.
     * @param description a string describing the NPC
     */
    public Gustaf(String description) {
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("Hi, I'm Gustaf!");
        if (oneTime == 1) {
            System.out.println("Don't tell anyone..., but I'm just a guy pretending to be a wizard.");
            oneTime = 0;
        }
        System.out.println("Want more health?");
        boolean command = StdIO.yesNoInput();
        if (!command) {
            System.out.println("Gustaf gives you a weird looking potion." +
                    " You decide to take your chances and drink it...");
            player.setHealth(player.getHealth() + 20);
            System.out.println("You received 20 health...");
        }
    }
}
