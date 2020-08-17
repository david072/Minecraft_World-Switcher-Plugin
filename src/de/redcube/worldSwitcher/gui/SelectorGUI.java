package de.redcube.worldSwitcher.gui;

import de.redcube.worldSwitcher.util.Constants;
import de.redcube.worldSwitcher.util.InventoryItem;
import de.redcube.worldSwitcher.util.Util;
import de.redcube.worldSwitcher.worlds.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class SelectorGUI {

    public static final int inventoryWidth = 9;
    public static final int inventoryHeight = 6;
    public static final Inventory selectorInv = Bukkit.createInventory(null, inventoryHeight * inventoryWidth, "§0» §2World Switcher");

    public SelectorGUI() {
        addItems();
    }

    public static void addItems() {
        InventoryItem[][] itemsToAdd = new InventoryItem[inventoryHeight][inventoryWidth];
        int xCount = 0;
        for(int y = 0; y < inventoryHeight; y++) {
            switch(xCount) {
                case 0:
                case 1:
                case 4:
                case 5:
                    for(int x = 0; x < inventoryWidth; x++) {
                        itemsToAdd[y][x] = Constants.blackGlassPane;
                    }
                    break;
                case 2:
                    itemsToAdd[y][0] = Constants.blackGlassPane;
                    itemsToAdd[y][8] = Constants.blackGlassPane;

                    itemsToAdd[y][1] = WorldManager.getItemFromWorld(0);
                    itemsToAdd[y][2] = WorldManager.getItemFromWorld(1);
                    itemsToAdd[y][3] = WorldManager.getItemFromWorld(2);
                    itemsToAdd[y][4] = WorldManager.getItemFromWorld(3);
                    itemsToAdd[y][5] = WorldManager.getItemFromWorld(4);
                    itemsToAdd[y][6] = WorldManager.getItemFromWorld(5);
                    itemsToAdd[y][7] = WorldManager.getItemFromWorld(6);

                    break;
                case 3:
                    itemsToAdd[y][0] = Constants.blackGlassPane;
                    itemsToAdd[y][8] = Constants.blackGlassPane;

                    itemsToAdd[y][1] = WorldManager.getItemFromWorld(7);
                    itemsToAdd[y][2] = WorldManager.getItemFromWorld(8);
                    itemsToAdd[y][3] = WorldManager.getItemFromWorld(9);
                    itemsToAdd[y][4] = WorldManager.getItemFromWorld(10);
                    itemsToAdd[y][5] = WorldManager.getItemFromWorld(11);
                    itemsToAdd[y][6] = WorldManager.getItemFromWorld(12);
                    itemsToAdd[y][7] = WorldManager.getItemFromWorld(13);

                    break;
            }
            xCount++;
        }

        int inventoryIndex = 0;
        for(int y = 0; y < inventoryHeight; y++) {
            for(int x = 0; x < inventoryWidth; x++) {
                selectorInv.setItem(inventoryIndex, itemsToAdd[y][x].getItem());
                inventoryIndex++;
            }
        }
    }

}
