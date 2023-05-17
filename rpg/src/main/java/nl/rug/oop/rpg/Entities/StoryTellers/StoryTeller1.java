package nl.rug.oop.rpg.Entities.StoryTellers;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * NPC who prints a part of the story.
 */
public class StoryTeller1 extends NPC {

    public StoryTeller1(String description){
        super(description);
    }

    @Override
    public void interact(Player player) {
        System.out.println("There were once was peace in the lands.  " +
                "They all coexisted in peace and fertility... till one day.");
        System.out.println("They consisted of three major areas, the land of the fairies, " +
                "the underground and the chocolate mountains.");
        System.out.println("The local MCDonald's closed down for an unexpected reason.");
        System.out.println("The people went crazy and started battling for survival.");
        System.out.println("The Lords at that time decided to part ways and built walls to prevent the ongoing wars.");
        System.out.println("The peasants were stupid and were battling blinded by the absence of the " +
                "almighty BIGMAC...");
    }
}
