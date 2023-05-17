package nl.rug.oop.rpg.Environment.Doors;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Environment.Room;
import nl.rug.oop.rpg.GameEngine.StdIO;
import nl.rug.oop.rpg.Interfaces.Attackable;

/**
 * A door that attacks the player when they interact with it.
 */
public class HostileDoor extends Door implements Attackable {

    private int health;
    private int maxAttackDamage;

    /**
     * Main constructor.
     * 
     * @param description     Description of the door.
     * @param room            Room the door connects too.
     * @param health          Health of the door.
     * @param maxAttackDamage Max damage that the door can deal when it is attacked.
     */
    public HostileDoor(String description, Room room, int health, int maxAttackDamage) {
        super(description, room);
        this.health = health;
        this.maxAttackDamage = maxAttackDamage;
    }

    /**
     * Determines if the door is dead.
     * 
     * @return boolean State of door death.
     */
    @Override
    public boolean isDead() {
        return this.getHealth() < 1;
    }

    /**
     * Implements the attack method from Attackable.
     * When the door is attacked, it loses a random amount of damage between 1 and
     * the maxAttack parameter.
     * 1 point of damage on an enemy is guaranteed; the amount of damage is random.
     * maxAttack is determined by what is being used to his the player.
     * 
     * @param maxAttack the maximum damage that can be dealt by this attack.
     */
    public void attack(int maxAttack) {
        Random random = new Random();
        int hit = random.nextInt(1, maxAttack);

        if (hit > maxAttack * 0.75) {
            System.out.println("Critical hit. ");
        } else if (hit > maxAttack * 0.25) {
            System.out.println("That's a hit. ");
        } else if (hit > 0) {
            System.out.println("A wet noodle can hit harder than that! ");
        } else {
            System.out.println("You missed!");
        }
        System.out.printf("The enemy too %d hitpoints of damage.", hit);

        this.setHealth(this.getHealth() - hit);
    }

    /**
     * The door interaction with the player.
     * If the door is not dead, then it will attack the player.
     * If the door is dead, then it performs the normal door behavior from parent
     * door class.
     * 
     * @param player Player interacting with the door.
     */
    public void interact(Player player) {
        if (this.isDead()) {
            // Once the door is dead, it behaves like a normal door.
            super.interact(player);
            return;
        }

        while (!player.isDead()) {
            System.out.printf("You have %d health.\n", player.getHealth());
            System.out.println("What do you want to do?");
            System.out.println(" (0) Run away");
            System.out.println(" (1) Attack");
            int command = -1;
            try {
                command = StdIO.integerInput(0, 1);
            } catch (IOException e) {
                System.out.println("Invalid input!");
                return;
            }
            if (command == 0) {
                break;
            } else if (command == 1) {
                attack(player.getPrimaryWeaponDamage());
                if (!this.isDead()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Problem with waiting.");
                    }
                    player.attack(this.getMaxAttackDamage());
                } else {
                    System.out.println("The door died!");
                    break;
                }
            }
        }

    }

    /**
     * Setter for heath attribute.
     * 
     * @param health Health of the player;
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter for health attribute field.
     * 
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter for max damage field.
     * 
     * @return int
     */
    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    /**
     * Setter for max damage attribute.
     * 
     * @param maxAttackDamage int
     */
    public void setMaxAttackDamage(int maxAttackDamage) {
        this.maxAttackDamage = maxAttackDamage;
    }

}
