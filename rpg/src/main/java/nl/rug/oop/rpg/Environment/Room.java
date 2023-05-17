package nl.rug.oop.rpg.Environment;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Environment.Doors.Door;
import nl.rug.oop.rpg.Interfaces.Inspectable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A room in the RPG game.
 */
public class Room implements Inspectable, Serializable {

    private static final long serialVersionUID = 41L;

    private String description;
    private List<Door> doors;
    private List<NPC> npcs;

    /**
     * Main Constructor.
     * 
     * @param description Description of the room.
     * @param doors       List of doors.
     * @param npcs        List of NPCs.
     */
    public Room(String description, List<Door> doors, List<NPC> npcs) {
        setDescription(description);
        setDoors(doors);
        setNPCs(npcs);
    }

    /**
     * Constructor. Sets doors list to empty list.
     * Calls the main constructor
     * 
     * @param description Description of the room.
     */
    public Room(String description) {
        this(description, new ArrayList<Door>(), new ArrayList<NPC>());
    }

    /**
     * Getter for the description field.
     * 
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for doors list field.
     * 
     * @return List/<Door/>
     */
    public List<Door> getDoors() {
        return this.doors;
    }

    /**
     * Returns door at specified index.
     * 
     * @param i Index of door to return
     * @return Door
     */
    public Door getDoor(int i) {
        return this.doors.get(i);
    }

    /**
     * Returns the number of doors in the room.
     * 
     * @return int
     */
    public int getDoorsCount() {
        return this.getDoors().size();
    }

    /**
     * Sets the description field.
     * 
     * @param description Description of current room.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for doors list field.
     * 
     * @param doors ArrayList of doors.
     */
    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    /**
     * Adds a door to the doors list.
     * 
     * @param door New door to be added
     */
    public void addDoor(Door door) {
        this.doors.add(door);
    }

    /**
     * Setter for NPCs list field.
     * 
     * @param npcs ArrayList of NPCs
     */
    public void setNPCs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    /**
     * Adds a npc to the npcs list.
     * 
     * @param npc New npc to be added
     */
    public void addNPC(NPC npc) {
        this.npcs.add(npc);
    }

    /**
     * Getter for NPCs list field.
     * 
     * @return returns a list of NPCs
     */
    public List<NPC> getNpcs() {
        return npcs;
    }

    /**
     * Returns the number of NPCs in the room.
     * 
     * @return int
     */
    public int getNPCsCount() {
        return this.getNpcs().size();
    }

    /**
     * List all NPC that are in the room in format for choosing in interface menu.
     */
    public void listNPCs() {
        int i = 0;
        for (NPC npc : this.getNpcs()) {
            System.out.printf(" (%d) ", i);
            npc.inspect();
            i++;
        }
    }

    /**
     * Allows the player to inspect the current room that they are in.
     * Outputs description to the console.
     */
    public void inspect() {
        System.out.printf("You see: %s The Room has %d doors. \n", this.getDescription(), getDoorsCount());
    }

    /**
     * Outputs the description of each door in the room using the Door's inspect
     * method.
     */
    public void findWayOut() {
        System.out.println("You look around for doors. You see:");
        System.out.println(" (0) Stay Here");
        for (int i = 0; i < getDoorsCount(); i++) {
            // Used printf so that the inspect can fall on the same line
            System.out.printf(" (%d) ", i + 1);
            this.doors.get(i).inspect();
        }
    }

}
