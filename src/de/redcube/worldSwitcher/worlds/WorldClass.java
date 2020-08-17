package de.redcube.worldSwitcher.worlds;

import de.redcube.worldSwitcher.util.InventoryItem;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;

public class WorldClass {

    private final String name;
    private InventoryItem correspondingItem;
    private World world;
    private boolean wasGenerated = false;

    public WorldClass(String name) {
        this.name = name;
    }

    public InventoryItem getCorrespondingItem() {
        return correspondingItem;
    }

    public void setCorrespondingItem(InventoryItem correspondingItem) {
        this.correspondingItem = correspondingItem;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public boolean wasGenerated() {
        return wasGenerated;
    }

    public void isAlreadyGenerated() {
        this.wasGenerated = true;
    }

    public void generateWorld() {
        if(!wasGenerated) {
            this.world = new WorldCreator(name).createWorld();
            wasGenerated = true;
        }
    }

}
