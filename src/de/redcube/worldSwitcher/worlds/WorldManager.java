package de.redcube.worldSwitcher.worlds;

import de.redcube.worldSwitcher.util.InventoryItem;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Bukkit;
import org.bukkit.Material;

public class WorldManager {

    private static WorldClass[] worlds;
    public static final int worldsLength = 14;

    public static void init() {
        worlds = new WorldClass[worldsLength];

        for(int i = 1; i <= 14; i++) {
            int index = i - 1;
            if(Bukkit.getWorld("world_" + i) != null) {
                worlds[index] = new WorldClass("world_" + i);
                worlds[index].isAlreadyGenerated();
                worlds[index].setWorld(Bukkit.getWorld("world_" + i));
                worlds[index].setCorrespondingItem(new InventoryItem("§6World " + i, Material.WHITE_SHULKER_BOX, "§8------------", "§7§L» §2Click to warp"));
            }
            else {
                worlds[index] = new WorldClass("world_" + i);
                worlds[index].setCorrespondingItem(new InventoryItem("§6World " + i, Material.BLACK_SHULKER_BOX, "§8------------", "§7§L» §2Click to generate"));
            }
        }
    }

    public static void buildItems() {
        for(int i = 1; i <= 14; i++) {
            int index = i - 1;
            if(Bukkit.getWorld("world_" + i) != null) {
                worlds[index].setCorrespondingItem(new InventoryItem("§6World " + i, Material.WHITE_SHULKER_BOX, "§8------------", "§7§L» §2Click to warp"));
            }
            else {
                worlds[index].setCorrespondingItem(new InventoryItem("§6World " + i, Material.BLACK_SHULKER_BOX, "§8------------", "§7§L» §2Click to generate"));
            }
        }
    }

    public static InventoryItem getItemFromWorld(int worldIndex) {
        return worlds[worldIndex].getCorrespondingItem();
    }

    public static WorldClass getWorld(int worldIndex) {
        return worlds[worldIndex];
    }

    public static WorldClass generateWorld(int worldIndex) {
        worlds[worldIndex].generateWorld();
        return worlds[worldIndex];
    }

}
