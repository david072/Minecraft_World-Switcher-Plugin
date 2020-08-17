package de.redcube.worldSwitcher.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;

public class InventoryItem {

    private final String displayName;
    private final String[] lore;
    private final Material material;

    private ItemStack item;
    private ItemMeta itemMeta;

    public InventoryItem(String displayName, Material material, String... lore) {
        this.displayName = displayName;
        this.lore = lore;
        this.material = material;

        buildItem();
    }

    private ArrayList<String> convertLore(String[] lore) {
        ArrayList<String> result = new ArrayList<>();
        Collections.addAll(result, lore);

        return result;
    }

    private void buildItem() {
        item = new ItemStack(material, 1);
        itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);
        if(lore != null) itemMeta.setLore(convertLore(lore));
        item.setItemMeta(itemMeta);
    }

    public String getDisplayName() {
        return displayName;
    }

    public String[] getLore() {
        return lore;
    }

    public Material getMaterial() {
        return material;
    }

    public ItemStack getItem() {
        return item;
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

}
