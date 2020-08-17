package de.redcube.worldSwitcher.util;

import com.mojang.datafixers.kinds.Const;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Util {

    public static ItemStack createBlackGlassPane() {
        ItemStack stack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§0.");
        stack.setItemMeta(meta);

        return stack;
    }

}
