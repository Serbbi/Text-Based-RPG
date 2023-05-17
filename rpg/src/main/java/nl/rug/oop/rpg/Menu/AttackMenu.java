package nl.rug.oop.rpg.Menu;

import nl.rug.oop.rpg.GameEngine.Game;

/**
 * The menu when attacking an enemy.
 */
public class AttackMenu implements MenuOption{
    @Override
    public void execute(Game game) {
        System.out.println("What do you want to do?");
        System.out.println(" (0) Attack");
        System.out.println(" (1) Run away");
    }
}
