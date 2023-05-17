package nl.rug.oop.rpg.Environment;

import java.io.Serializable;

import nl.rug.oop.rpg.Entities.Enemy.Enemy;
import nl.rug.oop.rpg.Entities.StoryTellers.StoryTeller1;
import nl.rug.oop.rpg.Entities.Traders.ToiletTrader;
import nl.rug.oop.rpg.Environment.Doors.Door;

/**
 * Holds all the toilet rooms.
 */
public class ToiletArea implements MapArea, Serializable{

    private static final long serialVersionUID = 42L;

    private Room toilet;
    private Room cubicle1;
    private Room cubicle2;
    private Room cubicle3;

    /**
     * Constructor.
     */
    public ToiletArea() {
        buildRooms();
        addNPCs();
    }

    /**
     * Builds all of the rooms in Toilet area of the map.
     * Overrides interface method.
     */
    @Override
    public void buildRooms() {
        this.toilet = new Room("A place where dreams come true!");

        this.cubicle1 = new Room("A nasty looking toilet and no toilet paper, what a disaster.");

        this.cubicle2 = new Room("A rather fancy toilet, but no way out!");

        this.cubicle3 = new Room("A land of fairies, butterflies, rainbows and chocolate. Paradise on Earth!");
    }

    /**
     * Adds NPCs to rooms in the area of the map.
     * Overrides interface method.
     */
    @Override
    public void addNPCs() {
        toilet.addNPC(new ToiletTrader("A big red cape, covering the face of a suspicious salesman."));
        toilet.addNPC(new Enemy("There seems to be an scary monster sleeping in the corner.", 5));
        toilet.addNPC(new StoryTeller1("A guy who looks like he could use a cheeseburger."));

        cubicle1.addNPC(new Enemy("Just a moderate size fly on the wall.", 2));

        cubicle3.addNPC(new Enemy("Just a random fly on the wall.", 1));
    }

    /**
     * Getter for toilet attribute.
     * 
     * @return Room
     */
    public Room getToilet() {
        return this.toilet;
    }

    /**
     * Getter for cubicle1 attribute.
     * 
     * @return Room
     */
    public Room getCubicle1() {
        return this.cubicle1;
    }

    /**
     * Getter for cubicle2 attribute.
     * 
     * @return Room
     */
    public Room getCubicle2() {
        return this.cubicle2;
    }

    /**
     * Getter for cubicle3 attribute.
     * 
     * @return Room
     */
    public Room getCubicle3() {
        return this.cubicle3;
    }

    /**
     * Adds door to toilet.
     * 
     * @param door Door
     */
    public void addToiletDoor(Door door) {
        this.toilet.addDoor(door);
    }

    /**
     * Adds door to cubicle1.
     * 
     * @param door Door
     */
    public void addCubicle1Door(Door door) {
        this.cubicle1.addDoor(door);
    }

    /**
     * Adds door to cubicle2.
     * 
     * @param door Door
     */
    public void addCubicle2Door(Door door) {
        this.cubicle2.addDoor(door);
    }

    /**
     * Adds door to cubicle3.
     * 
     * @param door Door
     */
    public void addCubicle3Door(Door door) {
        this.cubicle3.addDoor(door);
    }

}
