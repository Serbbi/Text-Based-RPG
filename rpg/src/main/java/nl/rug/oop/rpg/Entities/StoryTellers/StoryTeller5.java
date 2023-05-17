package nl.rug.oop.rpg.Entities.StoryTellers;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * NPC who prints a part of the story.
 */
public class StoryTeller5 extends NPC {
    public StoryTeller5(String description) {
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("You stranger, you could do it... You are the one I was looking for.");
        System.out.println("Can you just rub me on the belly... yeah right there.. oh yeah... ok now stop," +
                " I said STOP!");
        System.out.println("Now seriously, you have to defeat the three bosses to unleash the" +
                " FREDDY FAZBEAR'S PIZZERIA!");
        System.out.println("Go on my belly scratcher... Make us proud! End the suffering!");
        System.out.println("Do I smell some tuna??");
    }
}
