package nl.rug.oop.rpg.Entities.Wizards;

import nl.rug.oop.rpg.Entities.Enemy.Enemy;
import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * A NPC who heals you anytime after you killed all the numbers in the room.
 */
public class Elena extends NPC {

    private int oneTime = 1;

    /**
     * Constructor for wizard NPC Elena.
     * @param description a string describing the NPC
     */
    public Elena(String description) {
        super(description);
    }

    @Override
    public void interact(Player player) {
        if (oneTime == 1) {
            System.out.println("I sense that you are hungry. And I happen to have just the thing for you...");
        }
        System.out.println("Greetings Traveler! I'm the all knowing witch Elena.");
        System.out.println("If you kill all the monsters in the room, I'll give you unlimited marshmallows!");
        for (NPC npcs: player.getCurrentRoom().getNpcs()) {
            if (npcs.getClass() == Enemy.class) {
                if (!((Enemy) npcs).isDead()) {
                    System.out.println("Oh, you still have monsters to kill...");
                    return;
                }
            }
        }
        System.out.println("Take this marshmallow and eat it!");
        player.setHealth(player.getHealth() + 20);
        System.out.println("You ate the marshmallow and gained 20 health.");
    }
}
