package nl.rug.oop.rpg.Environment;

import java.io.Serializable;

import nl.rug.oop.rpg.Entities.Enemy.BossEnemy;
import nl.rug.oop.rpg.Entities.Enemy.Enemy;
import nl.rug.oop.rpg.Entities.StoryTellers.StoryTeller5;
import nl.rug.oop.rpg.Entities.Traders.MuffinMan;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.Entities.Wizards.Elena;
import nl.rug.oop.rpg.Environment.Doors.Door;

/**
 * Holds all the fairy land rooms.
 */
public class FairyLandArea implements MapArea, Serializable {

    private static final long serialVersionUID = 42L;
    
    private Room fairyLand;
    private Room fairyRoom1;
    private Room fairyRoom2;
    private Room fairyRoom3;
    private Room fairyRoom4;
    private Room fairyBossRoom;

    /**
     * Constructor.
     */
    public FairyLandArea() {
        buildRooms();
        addNPCs();
    }

    /**
     * Builds all of the rooms in Fairy Land area of the map.
     * Overrides interface method.
     */
    @Override
    public void buildRooms() {
        this.fairyLand = new Room("A huge tree stump with flowing rivers of fairy dust. Oh, is that lil'" +
                " Tinkerbell??");

        this.fairyRoom1 = new Room("Fairy super bowl game? Unfortunately I don't have any tickets," +
                " but I have another Idea. hehe");

        this.fairyRoom2 = new Room("Fairy corn fields. They are the same, but different.");

        this.fairyRoom3 = new Room("Fairy Barbie riding in a fairy car with hairy Ken.");

        this.fairyRoom4 = new Room("A room which feels like it precedes a boss room. Weird.");

        this.fairyBossRoom = new Room("Wow, a boss room. Yeah, we got a FAIRY BOSS, ever heard of it?");

    }

    /**
     * Adds NPCs to rooms in the area of the map.
     * Overrides interface method.
     */
    @Override
    public void addNPCs() {
        fairyLand.addNPC(new StoryTeller5("An orange and chunky cat."));
        fairyLand.addNPC(new Enemy("Tuna Mini Boss", 80));

        fairyRoom1.addNPC(new Enemy("Fairy Guard", 10));
        fairyRoom1.addNPC(new Enemy("Fairy Gardener", 20));
        fairyRoom1.addNPC(new Enemy("Fairy Boxer", 30));

        fairyRoom2.addNPC(new MuffinMan("A baker of some sort."));
        fairyRoom2.addNPC(new Enemy("Cute little hedgehog", 20));
        fairyRoom2.addNPC(new Enemy("Sonic the hedgehog", 40,
                new Weapon("Speed", "Gotta go fast!", 14)));
        fairyRoom2.addNPC(new Enemy("Mario", 60,
                new Weapon("LevelUp Mushroom", "Use this to LevelDown your enemies.", 17)));

        fairyRoom3.addNPC(new Elena("A witch on a broom stick."));
        fairyRoom3.addNPC(new Enemy("A cat with cool shades.", 28,
                new Weapon("Cat hairs", "The eaten and puked hair of a cat.", 9)));
        fairyRoom3.addNPC(new Enemy("Evil grass.", 2));
        fairyRoom3.addNPC(new Enemy("Peter Pan.", 30,
                new Weapon("Peter Sword", "Peter Pan's Sword, take from the poor, give to the rich.", 14)));
        fairyRoom3.addNPC(new Enemy("Captain FairyLeg.", 27));
        fairyRoom3.addNPC(new Enemy("Baby Fairies.", 10,
                new Weapon("Baby screams", "Really loud baby screams at night!", 20)));

        fairyRoom4.addNPC(new Enemy("Fat Fairy Bouncer", 50,
                new Weapon("Super Fists", "Your regular hands, but with added strength.", 10)));
        fairyRoom4.addNPC(new Enemy("The Eminem of FairyLand", 37));
        fairyRoom4.addNPC(new Enemy("SnoopFairy", 39,
                new Weapon("Pot", "Yoooo...", 20)));
        fairyRoom4.addNPC(new Enemy("50Fairy", 50,
                new Weapon("50 cents", "Have any change?", 5)));

        fairyBossRoom.addNPC(new BossEnemy("Fairy Boss", 101,
                new Weapon("Wafer dagger", "Magically feed your enemies.", 19)));
    }

    /**
     * Getter for fairyLand attribute.
     * 
     * @return Room
     */
    public Room getFairyLand() {
        return this.fairyLand;
    }

    /**
     * Getter for fairyRoom1 attribute.
     * 
     * @return Room
     */
    public Room getFairyRoom1() {
        return this.fairyRoom1;
    }

    /**
     * Getter for fairyRoom2 attribute.
     * 
     * @return Room
     */
    public Room getFairyRoom2() {
        return this.fairyRoom2;
    }

    /**
     * Getter for fairyRoom3 attribute.
     * 
     * @return Room
     */
    public Room getFairyRoom3() {
        return this.fairyRoom3;
    }

    /**
     * Getter for fairyRoom4 attribute.
     * 
     * @return Room
     */
    public Room getFairyRoom4() {
        return this.fairyRoom4;
    }

    /**
     * Getter for fairyBossRoom attribute.
     * 
     * @return Room
     */
    public Room getFairyBossRoom() {
        return this.fairyBossRoom;
    }

    /**
     * Adds a doors to fairyLand.
     * 
     * @param door Door to be added.
     */
    public void addFairyLandDoor(Door door) {
        this.fairyLand.addDoor(door);
    }

    /**
     * Adds a doors to fairyRoom1.
     * 
     * @param door Door to be added.
     */
    public void addFairyRoom1Door(Door door) {
        this.fairyRoom1.addDoor(door);
    }

    /**
     * Adds a doors to fairyRoom2.
     * 
     * @param door Door to be added.
     */
    public void addFairyRoom2Door(Door door) {
        this.fairyRoom2.addDoor(door);
    }

    /**
     * Adds a doors to fairyRoom3.
     * 
     * @param door Door to be added.
     */
    public void addFairyRoom3Door(Door door) {
        this.fairyRoom3.addDoor(door);
    }

    /**
     * Adds a doors to fairyRoom4.
     * 
     * @param door Door to be added.
     */
    public void addFairyRoom4Door(Door door) {
        this.fairyRoom4.addDoor(door);
    }

    /**
     * Adds a doors to fairyBossRoom.
     * 
     * @param door Door to be added.
     */
    public void addFairyBossRoomDoor(Door door) {
        this.fairyBossRoom.addDoor(door);
    }

}
