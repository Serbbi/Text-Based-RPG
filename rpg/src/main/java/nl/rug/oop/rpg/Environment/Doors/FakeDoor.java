package nl.rug.oop.rpg.Environment.Doors;

import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * A Decoy door that doesn't go anywhere.
 */
public class FakeDoor extends Door {

    /**
     * Main Constructor.
     * Sets the super param room to null as this door isn't connected to a room.
     * 
     * @param description Description of the door.
     */
    public FakeDoor(String description) {
        super(description, null);
    }

    /**
     * Allows player to interact with the door.
     * 
     * @param player The player that is interacting with the door.
     */
    public void interact(Player player) {
        System.out.println("This door is fake... Seems it was just paint.");
    }
}
