package nl.rug.oop.rpg.Environment;

import java.io.Serializable;

import nl.rug.oop.rpg.Environment.Doors.Door;
import nl.rug.oop.rpg.Environment.Doors.FakeDoor;
import nl.rug.oop.rpg.Environment.Doors.HostileDoor;

/**
 * The map class stores all the data about the game.
 */
public class Map implements Serializable {

    private static final long serialVersionUID = 40L;

    private Room hallway;

    private FairyLandArea fairyLandArea;
    private SewerArea sewerArea;
    private ToiletArea toiletArea;
    private FactoryArea factoryArea;
    private Room startingRoom;

    /**
     * Main Constructor.
     */
    public Map() {
        buildMap();
    }

    /**
     * Creates connects all the doors for the rooms in toilet area of the map.
     */
    public void connectToiletDoors() {
        toiletArea.addToiletDoor(new Door("Blue door to first cubicle.", this.toiletArea.getCubicle1()));
        toiletArea.addToiletDoor(new Door("Blue door to second cubicle.", this.toiletArea.getCubicle2()));
        toiletArea.addToiletDoor(new Door("Blue door to third cubicle.", this.toiletArea.getCubicle3()));
        toiletArea.addToiletDoor(new Door("Entrance door to toilet.", hallway));
        toiletArea.addToiletDoor(new FakeDoor("Looks like a closet."));

        toiletArea.addCubicle1Door(new Door("Back in the Toilet.", this.toiletArea.getToilet()));
        toiletArea.addCubicle1Door(new Door("Descend in the sewer system.", this.sewerArea.getSewerEntrance()));

        toiletArea.addCubicle2Door(new Door("Back in the Toilet.", this.toiletArea.getToilet()));

        toiletArea.addCubicle3Door(new Door("Back in the Toilet.", this.toiletArea.getToilet()));
        toiletArea.addCubicle3Door(new Door("Door to the stadium.", this.fairyLandArea.getFairyRoom1()));
        toiletArea.addCubicle3Door(new Door("Door to the fields.", this.fairyLandArea.getFairyRoom2()));
    }

    /**
     * Creates connects all the doors for the rooms in factory area of the map.
     */
    public void connectFactoryDoors() {
        factoryArea.addFactoryRoom1Door(new Door("Door to the hallway.", hallway));
        factoryArea.addFactoryRoom1Door(new Door("Door to the perfume cauldron.", this.factoryArea.getFactoryRoom2()));
        factoryArea.addFactoryRoom1Door(new Door("Door to the beach.", this.factoryArea.getFactoryRoom3()));

        factoryArea.addFactoryRoom2Door(new Door("Door to factory entrance.", this.factoryArea.getFactoryRoom1()));
        factoryArea.addFactoryRoom2Door(new Door("Door to your happy place :)", this.factoryArea.getFactoryRoom4()));

        factoryArea.addFactoryRoom3Door(new Door("Door to factory entrance.", this.factoryArea.getFactoryRoom1()));
        factoryArea.addFactoryRoom3Door(new Door("Door to your happy place :)", this.factoryArea.getFactoryRoom4()));

        factoryArea.addFactoryRoom4Door(new Door("Door to the perfume cauldron.", this.factoryArea.getFactoryRoom2()));
        factoryArea.addFactoryRoom4Door(new Door("Door to the beach.", this.factoryArea.getFactoryRoom3()));
        factoryArea.addFactoryRoom4Door(new Door("Door to the chocolate heaven.", this.factoryArea.getFactoryRoom5()));

        factoryArea.addFactoryRoom5Door(new Door("Door to your happy place :)", this.factoryArea.getFactoryRoom4()));
        factoryArea.addFactoryRoom5Door(new Door("*hears boss music*", this.factoryArea.getFactoryBossRoom()));
        factoryArea.addFactoryRoom5Door(new Door("Door to fairy land?", this.fairyLandArea.getFairyLand()));

        factoryArea.addFactoryBossRoomDoor(new Door("Door to chocolate factory.", this.factoryArea.getFactoryRoom5()));
    }

    /**
     * Creates connects all the doors for the rooms in fairy land area of the map.
     */
    public void connectFairyLandDoors() {
        fairyLandArea.addFairyRoom1Door(new Door("Door to the cubicle.", this.toiletArea.getCubicle3()));
        fairyLandArea.addFairyRoom1Door(new Door("Door to the fields.", this.fairyLandArea.getFairyRoom2()));
        fairyLandArea.addFairyRoom1Door(new Door("Door to infinity and beyond.", this.fairyLandArea.getFairyRoom3()));

        fairyLandArea.addFairyRoom2Door(new Door("Door to the stadium.", this.fairyLandArea.getFairyRoom1()));
        fairyLandArea.addFairyRoom2Door(new Door("Door to the cubicle.", this.toiletArea.getCubicle3()));
        fairyLandArea.addFairyRoom2Door(
                new Door("Door to fairy land? I thought this was fairy land...", this.fairyLandArea.getFairyLand()));

        fairyLandArea.addFairyRoom3Door(new Door("Door to the stadium.", this.fairyLandArea.getFairyRoom1()));
        fairyLandArea.addFairyRoom3Door(new Door("Manhole in the ground.", this.sewerArea.getSewerRoom1()));
        fairyLandArea.addFairyRoom3Door(
                new HostileDoor("Just a door to just a room.", this.fairyLandArea.getFairyRoom4(), 20, 3));

        fairyLandArea.addFairyRoom4Door(new Door("A big door to a potentially BIG and SCARY enemy. Just a warning.",
                this.fairyLandArea.getFairyBossRoom()));
        fairyLandArea.addFairyRoom4Door(new Door("Door to infinity and beyond.", this.fairyLandArea.getFairyRoom3()));

        fairyLandArea.addFairyLandDoor(new Door("Door to the fake fairy land.", this.fairyLandArea.getFairyRoom2()));
        fairyLandArea.addFairyLandDoor(new Door("Door to the chocolate factory.", this.factoryArea.getFactoryRoom5()));

        fairyLandArea.addFairyBossRoomDoor(new Door("Back in the dungeon.", this.fairyLandArea.getFairyRoom4()));
    }

    /**
     * Creates connects all the doors for the rooms in sewer area of the map.
     */
    public void connectSewerDoors() {
        sewerArea.addSewerEntranceDoor(new Door("Door to the cubicle.", this.toiletArea.getCubicle1()));
        sewerArea.addSewerEntranceDoor(new Door("Door to Rat Ville.", this.sewerArea.getSewerRoom1()));

        sewerArea.addSewerRoom1Door(new Door("Door to sewer entrance.", this.sewerArea.getSewerEntrance()));
        sewerArea.addSewerRoom1Door(new Door("Door to stinky place.", this.sewerArea.getSewerRoom2()));
        sewerArea.addSewerRoom1Door(new Door("Door to infinity and beyond.", this.fairyLandArea.getFairyRoom3()));

        sewerArea.addSewerRoom2Door(new Door("Door to Rat Ville.", this.sewerArea.getSewerRoom1()));
        sewerArea.addSewerRoom2Door(
                new Door("Door to a castle. In castles there is usually a KING.", this.sewerArea.getSewerBossRoom()));
        sewerArea.addSewerRoom2Door(new Door("Door to somewhere.", this.toiletArea.getCubicle2()));

        sewerArea.addSewerBossRoomDoor(new Door("Door to stinky place", this.sewerArea.getSewerRoom2()));
    }

    /**
     * The buildMap method creates the map of the game.
     */
    public void buildMap() {

        // Build all of the rooms in the map.

        this.fairyLandArea = new FairyLandArea();
        this.sewerArea = new SewerArea();
        this.toiletArea = new ToiletArea();
        this.factoryArea = new FactoryArea();

        this.hallway = new Room("A long long long hallway. It's long.");

        // Create all of the doors that connect the rooms.
        connectToiletDoors();
        connectFairyLandDoors();
        connectSewerDoors();
        connectFactoryDoors();

        hallway.addDoor(new Door("Door to factory entrance.", this.factoryArea.getFactoryRoom1()));
        hallway.addDoor(new Door("Back to the toilet.", this.toiletArea.getToilet()));

        setStartingRoom(this.toiletArea.getToilet());
    }

    /**
     * Setter for the starting room attribute.
     * 
     * @param room Starting room.
     */
    public void setStartingRoom(Room room) {
        this.startingRoom = room;
    }

    /**
     * Getter for the starting room attribute.
     * 
     * @return Starting room.
     */
    public Room getStartingRoom() {
        return this.startingRoom;
    }

}
