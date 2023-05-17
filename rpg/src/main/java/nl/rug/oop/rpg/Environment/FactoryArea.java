package nl.rug.oop.rpg.Environment;

import java.io.Serializable;

import nl.rug.oop.rpg.Entities.Enemy.BossEnemy;
import nl.rug.oop.rpg.Entities.Enemy.Enemy;
import nl.rug.oop.rpg.Entities.StoryTellers.StoryTeller3;
import nl.rug.oop.rpg.Entities.StoryTellers.StoryTeller4;
import nl.rug.oop.rpg.Entities.Traders.GingerBreadMan;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.Entities.Wizards.Alfred;
import nl.rug.oop.rpg.Environment.Doors.Door;

/**
 * Holds all the factory rooms.
 */
public class FactoryArea implements MapArea, Serializable {

    private static final long serialVersionUID = 44L;

    private Room factoryRoom1;
    private Room factoryRoom2;
    private Room factoryRoom3;
    private Room factoryRoom4;
    private Room factoryRoom5;
    private Room factoryBossRoom;

    /**
     * Constructor.
     */
    public FactoryArea() {
        buildRooms();
        addNPCs();
    }

    /**
     * Builds all of the rooms in Factory Area area of the map.
     * Overrides interface method.
     */
    @Override
    public void buildRooms() {
        this.factoryRoom1 = new Room("A short short short hallway. It's short");

        this.factoryRoom2 = new Room("A weird fragrance travels to your nose. You feel a bit dizzy.");

        this.factoryRoom3 = new Room("A sunny beach, waves crashing to the shore, but wait," +
                " is that a projector? This is all staged!");

        this.factoryRoom4 = new Room("Wonder what could it be... https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        this.factoryRoom5 = new Room("Chocolate waterfalls and Umpa Lumpas everywhere.");

        this.factoryBossRoom = new Room("A kangaroo? Wait, is that hit artist and rapper DA BABY??");
    }

    /**
     * Adds NPCs to rooms in the area of the map.
     * Overrides interface method.
     */
    @Override
    public void addNPCs() {
        factoryRoom1.addNPC(new StoryTeller3("A shadow of what it was before a fat child."));
        factoryRoom1.addNPC(new Enemy("A factory worker.", 11));
        factoryRoom1.addNPC(new Enemy("Living flame.", 12,
                new Weapon("Fire Ball", "Hot to touch.", 6)));

        factoryRoom2.addNPC(new GingerBreadMan("GingerBreadMan with missing left leg."));
        factoryRoom2.addNPC(new Enemy("Lollipop Gang Member.", 16));
        factoryRoom2.addNPC(new Enemy("Happy Salamander.", 17,
                new Weapon("Salamander Tail", "Slap enemies with a fake, removeable tail", 9)));
        factoryRoom2.addNPC(new Enemy("Who knows what is that thing??", 18));
        factoryRoom2.addNPC(new Enemy("Lollipop Gang Leader.", 40,
                new Weapon("Lollipop Hammer", "Tasty.", 10)));

        factoryRoom3.addNPC(new Enemy("Chocolate river sailor.", 20));
        factoryRoom3.addNPC(new Enemy("Umpa Lumpa.", 26));
        factoryRoom3.addNPC(new Enemy(".", 30,
                new Weapon("", "", 1)));

        factoryRoom4.addNPC(new StoryTeller4("A storyteller of some kind."));
        factoryRoom4.addNPC(new Alfred("Alfred."));
        factoryRoom4.addNPC(new Enemy("Alfred2?", 25,
                new Weapon("Alfred's Spear", "Long reach but bad aim.", 15)));
        factoryRoom4.addNPC(new Enemy("Alfred3??", 44,
                new Weapon("Alfred's Spear", "Long reach but bad aim.", 15)));

        factoryRoom5.addNPC(new Enemy("Crazy Strong Umpa Lumpa", 30,
                new Weapon("Candy Cane", "Give them a taste of sugar.", 10)));
        factoryRoom5.addNPC(new Enemy("White chocolate entity.", 30));
        factoryRoom5.addNPC(new Enemy("Black chocolate entity.", 36));
        factoryRoom5.addNPC(new Enemy("Black & White chocolate entity.", 39,
                new Weapon("Hot chocolate Mug", "Pour some chocolate on that!", 17)));

        factoryBossRoom.addNPC(new BossEnemy("DA BABY", 100,
                new Weapon("Diamond Sword", "A sword made of three diamonds, reminds you of something...", 50)));
    }

    /**
     * Getter for factoryRoom1 attribute.
     * 
     * @return Room
     */
    public Room getFactoryRoom1() {
        return this.factoryRoom1;
    }

    /**
     * Getter for factoryRoom2 attribute.
     * 
     * @return Room
     */
    public Room getFactoryRoom2() {
        return this.factoryRoom2;
    }

    /**
     * Getter for factoryRoom3 attribute.
     * 
     * @return Room
     */
    public Room getFactoryRoom3() {
        return this.factoryRoom3;
    }

    /**
     * Getter for factoryRoom4 attribute.
     * 
     * @return Room
     */
    public Room getFactoryRoom4() {
        return this.factoryRoom4;
    }

    /**
     * Getter for factoryRoom5 attribute.
     * 
     * @return Room
     */
    public Room getFactoryRoom5() {
        return this.factoryRoom5;
    }

    /**
     * Getter for factoryBossRoom attribute.
     * 
     * @return Room
     */
    public Room getFactoryBossRoom() {
        return this.factoryBossRoom;
    }

    /**
     * Adds door to factoryRoom1.
     * 
     * @param door Door
     */
    public void addFactoryRoom1Door(Door door) {
        this.factoryRoom1.addDoor(door);
    }

    /**
     * Adds door to factoryRoom2.
     * 
     * @param door Door
     */
    public void addFactoryRoom2Door(Door door) {
        this.factoryRoom2.addDoor(door);
    }

    /**
     * Adds door to factoryRoom3.
     * 
     * @param door Door
     */
    public void addFactoryRoom3Door(Door door) {
        this.factoryRoom3.addDoor(door);
    }

    /**
     * Adds door to factoryRoom4.
     * 
     * @param door Door
     */
    public void addFactoryRoom4Door(Door door) {
        this.factoryRoom4.addDoor(door);
    }

    /**
     * Adds door to factoryRoom5.
     * 
     * @param door Door
     */
    public void addFactoryRoom5Door(Door door) {
        this.factoryRoom5.addDoor(door);
    }

    /**
     * Adds door to factoryBossRoom.
     * 
     * @param door Door
     */
    public void addFactoryBossRoomDoor(Door door) {
        this.factoryBossRoom.addDoor(door);
    }

}
