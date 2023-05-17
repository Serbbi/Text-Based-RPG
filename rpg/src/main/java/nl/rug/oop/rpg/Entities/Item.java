package nl.rug.oop.rpg.Entities;

import java.io.Serializable;

import nl.rug.oop.rpg.Interfaces.Inspectable;

/**
 * Represents any item that can be found during the game.
 */
public abstract class Item implements Inspectable, Serializable {

    private static final long serialVersionUID = 49L;

    private String name;
    private String description;

    /**
     * Main constructor.
     * 
     * @param name        Name of item
     * @param description Description of item
     */
    public Item(String name, String description) {
        setName(name);
        setDescription(description);
    }

    /**
     * Allows the player to inspect the item.
     */
    public void inspect() {
        System.out.printf(this.getDescription());
    }

    /**
     * Setter for description attribute.
     * 
     * @param description Description of item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for name attribute.
     * 
     * @param name Name of item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for name attribute.
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for description attribute.
     * 
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

}
