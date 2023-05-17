package nl.rug.oop.rpg.Interfaces;

/**
 * An interface that classes can implement so that they can be attacked.
 */
public interface Attackable {

    void attack(int maxAttack);

    boolean isDead();
}
