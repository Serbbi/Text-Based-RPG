package nl.rug.oop.rpg.Entities.StoryTellers;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * NPC who prints a part of the story.
 */
public class StoryTeller4 extends NPC {
    public StoryTeller4(String description) {
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("The basement dude was as many would imagine him, a goose. No, really, he was a goose " +
                "and had a pet friend cat.");
        System.out.println("The goose planned to build a bigger and better fast food restaurant, but he needed the" +
                " people to follow him.");
        System.out.println("He needed the three most valuable items in the lands. Little did he knew, these were tied" +
                " to the bearers like a tie.");
        System.out.println("As he failed his ambitions due to a lack of energy and laziness, his cat went on a" +
                " journey to far away lands.");
    }
}
