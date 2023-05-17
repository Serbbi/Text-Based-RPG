package nl.rug.oop.rpg.Entities.Player;

import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.GameEngine.StdIO;

import javax.management.InvalidAttributeValueException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * The inventory class where the player's weapons are stored.
 */
public class Inventory implements Serializable {

    private static final long serialVersionUID = 49L;

    static final int NUM_WEAPONS = 4;
    private Weapon[] weapons;

    /**
     * Inventory constructor.
     * 
     * @throws InvalidAttributeValueException Invalid length inventory.
     */
    public Inventory() throws InvalidAttributeValueException {
        setInventory();
    }

    /**
     * Inventory setter.
     * 
     * @throws InvalidAttributeValueException Invalid length inventory.
     */
    public void setInventory() throws InvalidAttributeValueException {
        weapons = new Weapon[NUM_WEAPONS];
        setWeapons(weapons);
    }

    /**
     * Sets weapons list.
     *
     * @param weapons List of weapons
     * @throws InvalidAttributeValueException Thrown if length of new array doesn't
     *                                        match the required length of weapons
     *                                        array.
     */
    public void setWeapons(Weapon[] weapons) throws InvalidAttributeValueException {
        if (weapons.length != NUM_WEAPONS) {
            throw new InvalidAttributeValueException(
                    String.format("A player can't have more than %d weapons.", NUM_WEAPONS));
        }
        this.weapons = weapons;
    }

    /**
     * Getter for entire weapons List.
     *
     * @return Weapons array
     */
    public Weapon[] getWeapons() {
        return this.weapons;
    }

    /**
     * Adds the new weapon at the specified index position if empty.
     * If that index is full, user prompted to decide which weapon to keep.
     *
     * @param weapon New weapon to add to weapons array.
     * @param i      Index at which the weapon should be added.
     */
    public void addWeapon(Weapon weapon, int i) {
        if (this.getWeapon(i) == null) {
            this.weapons[i] = weapon;
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("This weapon slot is full. Which weapon would you like to keep?");

            int command = -1;

            do {
                if (command != -1) {
                    System.out.println("Invalid! Please try again: Which weapon would you like to keep?");
                }
                System.out.printf(" (0) Old: ");
                this.getWeapon(i).inspect();

                System.out.println(" (1) New: ");
                weapon.inspect();

                command = in.nextInt();

            } while (command != 0 || command != 1);

            if (command == 1) {
                this.weapons[i] = weapon;
            }

            in.close();
        }
    }

    /**
     * Adds a weapon at the first non-null index.
     *
     * @param weapon Weapon to be added.
     */
    public void addWeapon(Weapon weapon) {
        for (int i = 0; i < NUM_WEAPONS; i++) {
            if (this.getWeapon(i) == null) {
                this.addWeapon(weapon, i);
                System.out.printf("The weapon was added at weapon slot %d. ", i + 1);
                return;
            }
        }
        System.out.println("You have no free weapon slots! Which weapon would you like to drop?");
        int command = -1;
        System.out.printf(" (0) NEW: ");
        weapon.inspect();

        for (int i = 0; i < NUM_WEAPONS; i++) {
            System.out.printf(" (%d) OLD: ", i + 1);
            this.getWeapon(i).inspect();
        }
        try {
            command = StdIO.integerInput(0, NUM_WEAPONS);

        } catch (IOException e) {
            System.out.println("Invalid Input.");
            return;
        }
        if (command == 0) {
            return;
        }
        this.weapons[command - 1] = weapon;
    }

    /**
     * Returns the weapon at index i.
     * Has checks to ensure that requested index is in bounds.
     *
     * @param i Index of weapon to be retrieved
     * @return Weapon
     */
    public Weapon getWeapon(int i) {
        if (i < 0 || i >= NUM_WEAPONS) {
            throw new IndexOutOfBoundsException("A player cannot have more than 4 weapons!");
        }
        return this.weapons[i];
    }

    /**
     * Returns the player's primary weapon.
     *
     * @return Weapon
     */
    public Weapon getPrimaryWeapon() {
        if (this.getWeapon(0) != null) {
            return this.getWeapon(0);
        } else if (this.getWeapon(1) != null) {
            System.out.println("Switching to secondary weapon!");
            return this.getWeapon(1);
        } else {
            System.out.println("You have resorted to your fists as they are your last option!");
            return new Weapon("Fists", "Your hands!", 2);
        }
    }

    /**
     * Returns the max damage of the primary weapons.
     *
     * @return int max damage
     */
    public int getPrimaryWeaponDamage() {
        return this.getPrimaryWeapon().getMaxDamage();
    }

    /**
     * Swaps positions of two weapons in weapons list.
     */
    public void swapWeapons() {
        int moveWeaponIndex = -1;
        while (moveWeaponIndex == -1) {
            System.out.println("Which weapon would you like to move?");

            this.displayWeaponsList();

            try {
                moveWeaponIndex = StdIO.integerInput(1, 4);
            } catch (IOException e) {
                System.out.println("Invalid! Please try again!");
            }
        }

        int command = -1;
        while (command == -1) {
            System.out.println("Which weapon would you like to swap with?");

            this.displayWeaponsList();

            try {
                command = StdIO.integerInput(1, 4);
            } catch (IOException e) {
                System.out.println("Invalid! Please try again!");
            }
        }
        Weapon temp = this.getWeapons()[command - 1];

        this.weapons[command - 1] = this.getWeapon(moveWeaponIndex - 1);
        this.weapons[moveWeaponIndex - 1] = temp;
    }

    /**
     * Prints out the slots in the inventory and the weapons.
     */
    public void displayWeaponsList() {
        for (int i = 0; i < this.getWeapons().length; i++) {
            Weapon weapon = this.getWeapons()[i];
            System.out.printf(" Slot %d: ", i + 1);
            if (weapon != null) {
                weapon.inspect();
            } else {
                System.out.printf("Empty!\n");
            }
        }
    }

    /**
     * Counts the amount of weapons in the inventory.
     * 
     * @return the amount of weapons in the inventory
     */
    public int getWeaponCount() {
        int count = 0;
        for (Weapon weapon : this.weapons) {
            if (weapon != null) {
                count++;
            }
        }
        return count;
    }
}
