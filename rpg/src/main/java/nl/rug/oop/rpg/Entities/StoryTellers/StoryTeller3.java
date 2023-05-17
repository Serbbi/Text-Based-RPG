package nl.rug.oop.rpg.Entities.StoryTellers;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * NPC who prints a part of the story.
 */
public class StoryTeller3 extends NPC {
    public StoryTeller3(String description) {
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("When the MCDonald's closed...I thought it was all over for me.");
        System.out.println("Days and nights were passing by, just like i was devouring the McNuggets...");
        System.out.println("But the day the KFC opened, it was like the heavens came down on earth.");
        System.out.println("I eat with such a pleasure their kid's menu... 3 buckets of wings, 4 boxes of fries" +
                " with extra mayonnaise.");
        System.out.println("It all seem too surreal to be true... and so it was... My childhood disappeared just " +
                "like the KFC...");
    }
}
