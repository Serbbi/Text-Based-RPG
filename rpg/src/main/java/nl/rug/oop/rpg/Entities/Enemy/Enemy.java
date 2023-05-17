package nl.rug.oop.rpg.Entities.Enemy;

import nl.rug.oop.rpg.Entities.NPC;
import nl.rug.oop.rpg.Entities.Player.Player;
import nl.rug.oop.rpg.Entities.Weapon;
import nl.rug.oop.rpg.Interfaces.Attackable;
import nl.rug.oop.rpg.GameEngine.StdIO;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Enemies are hostile to the player.
 * They are NPCs, and inherit all attributes from NPC.
 * The implement Attackable interface.
 */
public class Enemy extends NPC implements Attackable {
    private int health;
    private Weapon weapon;

    private final String deathMessage = "The monster is dead...";

    /**
     * Main Constructor.
     * 
     * @param description Description attribute for NPC superclass. Passed to super.
     * @param health      Starting health points of the Enemy.
     * @param weapon      Weapon that the Enemy has.
     */
    public Enemy(String description, int health, Weapon weapon) {
        super(description);
        setHealth(health);
        setWeapon(weapon);
    }

    /**
     * Constructor that initialises weapon to null.
     * 
     * @param description Description attribute for NPC superclass. Passed to super.
     * @param health      Starting health points of the Enemy.
     */
    public Enemy(String description, int health) {
        this(description, health, null);
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
     * Setter for weapon attribute.
     * 
     * @param weapon New weapon.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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
     * Getter for weapon attribute.
     * 
     * @return Weapon
     */
    public Weapon getWeapon() {
        if (this.weapon == null) {
            return new Weapon("Fists", "Your hands!", 10);
        } else {
            return weapon;
        }
    }

    /**
     * The Enemy interaction with the player.
     * 
     * @param player Player interacting with the monster.
     */
    @Override
    public void interact(Player player) {
        if (isDead()) {
            System.out.println(this.deathMessage);
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
                attackQuotes(getHealth());
                if (!this.isDead()) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Problem with waiting.");
                    }
                    player.attack(this.getWeapon().getMaxDamage());
                } else {
                    System.out.println("The enemy died!");
                    System.out.println("Would you like to inspect the weapon that the enemy was using?");
                    if (!StdIO.yesNoInput() && !"Fists".equals(this.getWeapon().getName())) {
                        this.getWeapon().inspect();
                        System.out.println("Would you like to keep this weapon?");
                        if (StdIO.yesNoInput()) {
                            return;
                        } else {
                            player.addWeapon(this.getWeapon());
                        }
                    } else {
                        System.out.println("The enemy has no weapons.");
                    }
                    return;
                }
            }
        }
        //player.die();
    }

    /**
     * Used for printing quotes based on health.
     * Mainly for bosses.
     * Meant to be overridden.
     * 
     * @param health takes the health of the enemy
     */
    public void attackQuotes(int health) {
        // System.out.println("Quote");
        return;
    }

    /**
     * Returns true if the enemy is dead.
     * Enemy is dead when health < 1;
     * 
     * @return boolean
     */
    public boolean isDead() {
        return this.getHealth() < 1;
    }

    /**
     * Implements the attack method from Attackable.
     * When the enemy is attacked, it loses a random amount of damage between 1 and
     * the maxAttack parameter.
     * Damage on an enemy is guaranteed; the amount of damage is random.
     * maxAttack is determined by what is being used to his the player.
     * 
     * @param maxAttack the maximum damage that can be dealt by this attack.
     */
    public void attack(int maxAttack) {
        Random random = new Random();
        int hit = random.nextInt(1, maxAttack);

        if (hit > maxAttack * 0.75) {
            System.out.printf("Critical hit. ");
        } else if (hit > maxAttack * 0.25) {
            System.out.printf("That's a hit. ");
        } else if (hit > 0) {
            System.out.printf("A wet noodle can hit harder than that! ");
        } else {
            System.out.printf("You missed!");
        }
        System.out.printf("The enemy took %d hitpoints of damage.", hit);

        this.setHealth(this.getHealth() - hit);
    }
}