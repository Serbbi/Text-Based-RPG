package nl.rug.oop.rpg.Entities.StoryTellers;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * NPC who prints a part of the story.
 */
public class StoryTeller2 extends NPC {
    public StoryTeller2(String description){
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("After some time of the separation, a wild KFC appeared nearby.");
        System.out.println("A few days have passed and things were looking like going back to normal.");
        System.out.println("Kids started eating crap food again, and going out to mess with the shopkeepers.");
        System.out.println("But then, the KFC closed too! It was horrible! For these people the sun wasn't rising " +
                "for anything.");
        System.out.println("Somewhere in a basement there was a guy and his orange cat, planning a plan...");
    }
}
