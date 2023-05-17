package nl.rug.oop.rpg.Environment;

import java.io.Serializable;

import nl.rug.oop.rpg.Entities.Enemy.BossEnemy;
import nl.rug.oop.rpg.Entities.Enemy.Enemy;
import nl.rug.oop.rpg.Entities.StoryTellers.StoryTeller2;
import nl.rug.oop.rpg.Entities.Traders.Shrek;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.Entities.Wizards.Gustaf;
import nl.rug.oop.rpg.Environment.Doors.Door;

/**
 * Holds all the sewer rooms.
 */
public class SewerArea implements MapArea, Serializable{

    private static final long serialVersionUID = 43L;

    private Room sewerEntrance;
    private Room sewerRoom1;
    private Room sewerRoom2;
    private Room sewerBossRoom;

    /**
     * Constructor.
     */
    public SewerArea() {
        buildRooms();
        addNPCs();
    }

    /**
     * Builds all of the rooms in SewerArea area of the map.
     * Overrides interface method.
     */
    @Override
    public void buildRooms() {
        this.sewerEntrance = new Room("A green goo river going down into what seems to be an abyss." +
                " Also Shrek is here." +
                " Trash and dancing rats everywhere.");

        this.sewerRoom2 = new Room("A broken down time machine. Cringe moments from the past come" +
                " to your mind.");

        this.sewerBossRoom = new Room("A big misty room with what seems to be a giant throne. OH NO!" +
                " IT'S THE BASED KING RAT!");

        this.sewerRoom1 = new Room("A big cardboard box, socks on a string and rats making a barbeque.");
    }

    /**
     * Adds NPCs to rooms in the area of the map.
     * Overrides interface method.
     */
    @Override
    public void addNPCs() {
        sewerEntrance.addNPC(new Shrek("Ogres are like onions."));
        sewerEntrance.addNPC(new Enemy("A not so cute baby rat.", 3));
        sewerEntrance.addNPC(new Enemy("Black Rat.", 5));
        sewerEntrance.addNPC(new Enemy("Yellow Rat.", 5));

        sewerRoom1.addNPC(new StoryTeller2("A sad girl with a KFC bucket of chicken wings."));
        sewerRoom1.addNPC(new Enemy("Small Slime.", 4));
        sewerRoom1.addNPC(new Enemy("Mega Slime.", 10));
        sewerRoom1.addNPC(new Enemy("GIGA Slime.", 20,
                new Weapon("Sticky Piston", "A piston as a weapon?", 9)));
        sewerRoom1.addNPC(new Enemy("Red Rat.", 5,
                new Weapon("Rat Claws", "The claws from a rat.", 7)));

        sewerRoom2.addNPC(new Enemy("Mega Slime.", 11));
        sewerRoom2.addNPC(new Enemy("Mega Slime the sequel.", 11));
        sewerRoom2.addNPC(new Enemy("Cockroach with a knife.", 30,
                new Weapon("Smol knife", "Plastic knife made for kids.", 11)));
        sewerRoom2.addNPC(new Enemy("Intergalactic banana pirate.", 36));
        sewerRoom2.addNPC(new Enemy("Pink Rat.", 5));
        sewerRoom2.addNPC(new Gustaf("Gustaf."));

        sewerBossRoom.addNPC(new BossEnemy("RAT KING?", 100,
                new Weapon("Big Rat Claws", "Oh, they have some shiny rings on them.", 18)));
        sewerBossRoom.addNPC(new Enemy("Rainbow Rat", 60,
                new Weapon("Rainbow FlipFlop", "The kind my mum used to beat me up with.", 999)));
    }

    /**
     * Getter for sewerEntrance attribute.
     * 
     * @return Room
     */
    public Room getSewerEntrance() {
        return this.sewerEntrance;
    }

    /**
     * Getter for sewerRoom1 attribute.
     * 
     * @return Room
     */
    public Room getSewerRoom1() {
        return this.sewerRoom1;
    }

    /**
     * Getter for sewerRoom2 attribute.
     * 
     * @return Room
     */
    public Room getSewerRoom2() {
        return this.sewerRoom2;
    }

    /**
     * Getter for sewerBossRoom attribute.
     * 
     * @return Room
     */
    public Room getSewerBossRoom() {
        return this.sewerBossRoom;
    }

    /**
     * Adds door to sowerEntrance.
     * 
     * @param door Door
     */
    public void addSewerEntranceDoor(Door door) {
        this.sewerEntrance.addDoor(door);
    }

    /**
     * Adds door to sewerRoom1.
     * 
     * @param door Door
     */
    public void addSewerRoom1Door(Door door) {
        this.sewerRoom1.addDoor(door);
    }

    /**
     * Adds door to sewerRoom2.
     * 
     * @param door Door
     */
    public void addSewerRoom2Door(Door door) {
        this.sewerRoom2.addDoor(door);
    }

    /**
     * Adds door to sowerBossRoom.
     * 
     * @param door Door
     */
    public void addSewerBossRoomDoor(Door door) {
        this.sewerBossRoom.addDoor(door);
    }

}
