package nl.rug.oop.rpg.Entities.Player;

import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.GameEngine.Game;
import nl.rug.oop.rpg.Interfaces.Attackable;
import nl.rug.oop.rpg.Environment.Room;

import java.io.Serializable;
import java.util.Random;

import javax.management.InvalidAttributeValueException;

/**
 * Player class used to represent the player of the game.
 */
public class Player implements Attackable, Serializable {

    private static final long serialVersionUID = 47L;

    private String name;
    private Room currentRoom;
    private int health;
    private Inventory inventory;

    /**
     * Main constructor.
     * 
     * @param name        Name of the player.
     * @param currentRoom The current room that the player is in.
     * @param health      The number of hitpoints that the player has.
     */
    public Player(String name, Room currentRoom, int health) {
        setName(name);
        setCurrentRoom(currentRoom);
        try {
            inventory = new Inventory();
        } catch (InvalidAttributeValueException e) {
            System.out.println("Invalid Inventory!");
        }

        // ! Must pass directly to avoid death checks
        this.health = health;
    }

    /**
     * Constructor that reads in name from console.
     * 
     * @param currentRoom The current room that the player is in.
     * @param health      The number of hitpoints that the player has.
     */
    public Player(Room currentRoom, int health) {

        setCurrentRoom(currentRoom);
        try {
            inventory = new Inventory();
        } catch (InvalidAttributeValueException e) {
            System.out.println("Invalid Inventory!");
        }

        // ! Must pass directly to avoid death checks
        this.health = health;
    }

    /**
     * Setter for the player name field.
     * 
     * @param name Player name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the reference to the current room that the player is in.
     * 
     * @param currentRoom Current room that the player is in.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Setter for health attribute.
     * If health hits 0 or lower, then the player dies, and the game ends.
     * The max health is 100, so health capped here.
     * 
     * @param health New health to be set.
     */
    public void setHealth(int health) {
        if (this.isDead()) {
            this.die();
        }
        this.health = health > 100 ? 100 : health;
    }

    /**
     * Getter for the name player name field.
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the current room field.
     * 
     * @return Room Reference to current room object.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Getter for health attribute.
     * 
     * @return int
     */
    public int getHealth() {
        return health;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addWeapon(Weapon weapon) {
        inventory.addWeapon(weapon);
    }

    public int getWeaponCount() {
        return inventory.getWeaponCount();
    }

    public void displayWeaponsList() {
        inventory.displayWeaponsList();
    }

    public void swapWeapons() {
        inventory.swapWeapons();
    }

    public Weapon getPrimaryWeapon() {
        return inventory.getPrimaryWeapon();
    }

    public int getPrimaryWeaponDamage() {
        return inventory.getPrimaryWeaponDamage();
    }

    /**
     * Returns true if the player is dead.
     * Enemy is dead when health < 1;
     * 
     * @return int
     */
    public boolean isDead() {
        return this.getHealth() < 1;
    }

    /**
     * Implements the attack method from Attackable.
     * When player is attacked, they lose a random amount of damage between 0 and
     * the maxAttack parameter.
     * maxAttack is determined by what is being used to his the player
     * 
     * @param maxAttack the maximum damage that can be dealt by this attack.
     */
    public void attack(int maxAttack) {

        Random random = new Random();
        int hit = random.nextInt(0, maxAttack);

        System.out.printf("The enemy attacked you, and dealt %d hitpoints of damage.\n", hit);
        this.setHealth(health - hit);
    }

    /**
     * Ends the game when the players health is 0 or lower.
     */
    public void die() {
        System.out.println("\n\nGAME OVER! You died! That must be embarrassing!");
        Game.endGame();
    }
}
