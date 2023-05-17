package nl.rug.oop.rpg.Entities;

import java.io.Serializable;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Interfaces.Inspectable;
import nl.rug.oop.rpg.Interfaces.Interactable;

/**
 * A NPC in the game.
 */
public abstract class NPC implements Interactable, Inspectable, Serializable {

    private static final long serialVersionUID = 46L;

    private String description;

    /**
     * NPC constructor.
     * @param description description of the NPC
     */
    public NPC(String description){
        setDescription(description);
    }

    /**
     * The description setter.
     * @param description description of the NPC
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * The description getter.
     * @return returns the description of the NPC
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * The NPC interaction with the player.
     * @param player who interacts with the NPC
     */
    @Override
    public void interact(Player player) {
        System.out.println("The creature is asleep so you can't interact with it.");
    }

    /**
     * The NPC inspection with the player.
     */
    @Override
    public void inspect() {
        System.out.println(this.getDescription());
    }

}
