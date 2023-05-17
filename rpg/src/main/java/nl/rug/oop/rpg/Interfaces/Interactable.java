package nl.rug.oop.rpg.Interfaces;

import nl.rug.oop.rpg.Entities.Player.Player;

/**
 * An interface that classes can implement so that they can be interacted by players.
 */
public interface Interactable {

    void interact(Player player);
}
