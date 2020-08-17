package de.redcube.worldSwitcher.listeners;

import de.redcube.worldSwitcher.gui.SelectorGUI;
import de.redcube.worldSwitcher.main.Main;
import de.redcube.worldSwitcher.util.Constants;
import de.redcube.worldSwitcher.util.InventoryItem;
import de.redcube.worldSwitcher.worlds.WorldClass;
import de.redcube.worldSwitcher.worlds.WorldManager;
import net.minecraft.server.v1_16_R1.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getWhoClicked() instanceof Player) {
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() != null) {
                if(e.getInventory() == SelectorGUI.selectorInv) {
                    if(checkItem(Constants.blackGlassPane, e.getCurrentItem())) {
                        e.setCancelled(true);
                    }

                    for(int i = 0; i < WorldManager.worldsLength; i++) {
                        if(checkItem(WorldManager.getItemFromWorld(i), e.getCurrentItem())) {
                            WorldClass world = WorldManager.getWorld(i);
                            if(!world.wasGenerated()) {
                                player.closeInventory();
                                Bukkit.broadcastMessage("§2Eine Welt wird generiert!");

                                Bukkit.getOnlinePlayers().forEach((Player p) -> {
                                    p.kickPlayer("§2Eine Welt wird generiert. \nDu kannst dich in 1 Minute wieder verbinden.");
                                });

                                WorldManager.generateWorld(i);
                                WorldManager.buildItems();
                                SelectorGUI.addItems();
                            }
                            else {
                                FileConfiguration config = Main.INSTANCE.getConfig();
                                System.out.println(player.getWorld().getName());
                                config.set(player.getDisplayName() + "." + player.getWorld().getName() + ".prevPos.x", player.getLocation().getX());
                                config.set(player.getDisplayName() + "." + player.getWorld().getName() + ".prevPos.y", player.getLocation().getY());
                                config.set(player.getDisplayName() + "." + player.getWorld().getName() + ".prevPos.z", player.getLocation().getZ());
                                Main.INSTANCE.saveConfig();

                                config = Main.INSTANCE.getConfig();
                                double x = config.getDouble(player.getDisplayName() + ".world_" + (i + 1) + ".prevPos.x");
                                double y = config.getDouble(player.getDisplayName() + ".world_" + (i + 1) + ".prevPos.y");
                                double z = config.getDouble(player.getDisplayName() + ".world_" + (i + 1) + ".prevPos.z");

                                player.closeInventory();
                                player.sendMessage("§2Teleportiere dich zu §c[0, 100, 0] World " + (i + 1) + "!");

                                WorldClass finalWorld = world;
                                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.INSTANCE, () -> player.teleport(new Location(finalWorld.getWorld(), x, y, z)), 10);
                            }

                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    boolean checkItem(InventoryItem item, ItemStack stack) {
        if(item.getItemMeta().getDisplayName().equals(stack.getItemMeta().getDisplayName()) && item.getMaterial() == stack.getType()) {
            return true;
        }
        else {
            return false;
        }
    }

}
