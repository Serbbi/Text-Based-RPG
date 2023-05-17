package nl.rug.oop.rpg.Menu;

import java.util.HashMap;
import java.util.Map;

/**
 * InterfaceMenu class where most of the interactive menus are.
 */
public class InterfaceMenu {

    private Map<Integer, MenuOption> menuOption;

    /**
     * InterfaceMenu constructor.
     */
    public InterfaceMenu() {
        menuOption = new HashMap<>();
        menuOption.put(-1, new StandardRoomMenu());
        menuOption.put(0, new InspectMenu());
        menuOption.put(1, new FindWayOutMenu());
        menuOption.put(2, new LookForCompanyMenu());
        menuOption.put(3, new CheckWeaponsMenu());
        menuOption.put(4, new PlayerStats());
        menuOption.put(5, new QuickSaveMenu());
        menuOption.put(6, new QuickLoadMenu());
        menuOption.put(7, new SaveMenu());
        menuOption.put(8, new LoadMenu());
        menuOption.put(9, new CloseGameMenu());
    }
    
    public Map<Integer, MenuOption> getMenuOption() {
        return menuOption;
    }
}
