package nl.rug.oop.rpg.Entities.Enemy;

import nl.rug.oop.rpg.Entities.Weapon;

/**
 * Boss enemies are a subclass of Enemy.
 */
public class BossEnemy extends Enemy {

    private int status = 0;

    private final String deathMessage = "This boss is dead...";

    /**
     * Constructor for boss enemies.
     * 
     * @param description description of the enemy
     * @param health      health of the enemy
     */
    public BossEnemy(String description, int health) {
        super(description, health);
    }

    public BossEnemy(String description, int health, Weapon weapon) {
        super(description, health, weapon);
    }

    /**
     * Depending on the boss's health it displays different messages.
     * 
     * @param health takes the health of the enemy
     */
    @Override
    public void attackQuotes(int health) {
        if (health < 25 && status == 2) {
            System.out.println("\nYou puny human... YOU WILL FALL!");
            status = 3;
        } else if (health < 50 && status == 1) {
            System.out.println("\nI'm done playing around!");
            status = 2;
        } else if (health < 75 && status == 0) {
            System.out.println("\nYou think you can defeat me?? Think again!");
            status = 1;
        }
    }

}
