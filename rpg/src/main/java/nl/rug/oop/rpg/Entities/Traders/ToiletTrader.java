package nl.rug.oop.rpg.Entities.Traders;

import nl.rug.oop.rpg.Entities.Enemy.Enemy;
import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Entities.Weapon;

/**
 * This is a NPC in the toilet room.
 * Gives a besic weapon if the enemy in the room is killed.
 */
public class ToiletTrader extends NPC {

    private int oneTime = 1;

    public ToiletTrader(String description) {
        super(description);
    }

    /**
     * Displays a message.
     * If the enemy in the room is killed then the NPC will give a weapon.
     * @param player who interacts with the NPC
     */
    @Override
    public void interact(Player player) {
        if (oneTime == 1) {
            System.out.println("Hey there buddy. New around here? Ah, I see, well, welcome. " +
                    "I'll get straight to the point, if you slay the monster in the corner " +
                    "i could lend you a sword to help you in your adventures!");
        } else {
            System.out.println("I would suggest going to the sewers first.");
        }
        for (NPC npc: player.getCurrentRoom().getNpcs()) {
            if(npc.getClass() == Enemy.class) {
                if (((Enemy) npc).isDead() && oneTime == 1) {
                    System.out.println("Here you go!");
                    player.addWeapon(new Weapon("Basic Sword", "I've seen sharper spoons than this.", 5));
                    oneTime = 0;
                }
            }
        }
    }
}
