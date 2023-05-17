package nl.rug.oop.rpg.Entities;

/**
 * Represents a weapon used to attack an Attackable entity.
 */
public class Weapon extends Item {

    private int maxDamage;

    public Weapon(String name, String description, int maxDamage) {
        super(name, description);
        this.setMaxDamage(maxDamage);
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    /**
     * Prints out the name, description and max damage of a weapon.
     */
    public void inspect() {
        System.out.printf("%s - %s (Damage= %d)\n", this.getName(), this.getDescription(), this.getMaxDamage());

        // System.out.printf("%s This weapon can deal at most %d hitpoints of damage.\n", this.getDescription(),
        //         this.getMaxDamage());
    }
}
