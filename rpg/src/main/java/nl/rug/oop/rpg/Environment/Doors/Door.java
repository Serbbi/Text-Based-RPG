package nl.rug.oop.rpg.Environment.Doors;

import java.io.Serializable;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Environment.Room;
import nl.rug.oop.rpg.Interfaces.Inspectable;
import nl.rug.oop.rpg.Interfaces.Interactable;

/**
 * Class that represents a door in a room. Each room has many doors
 */
public class Door implements Inspectable, Interactable, Serializable {

    private static final long serialVersionUID = 45L;
    
    private String description;

    private Room room;

    /**
     * Main Constructor.
     * 
     * @param description Description of door.
     * @param room        Which room is the door assigned to.
     */
    public Door(String description, Room room) {
        this.description = description;
        this.room = room;
    }

    /**
     * Allows the player to inspect the door.
     */
    public void inspect() {
        System.out.printf("%s\n", this.description);
    }

    /**
     * Allows player to interact with the door.
     * Moves player to the room the door is connected to.
     * 
     * @param player The player to move.
     */
    public void interact(Player player) {
        player.setCurrentRoom(room);
    }
}
