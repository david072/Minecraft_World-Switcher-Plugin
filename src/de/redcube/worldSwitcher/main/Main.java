package de.redcube.worldSwitcher.main;

import de.redcube.worldSwitcher.OpenSwitcherCommand;
import de.redcube.worldSwitcher.gui.SelectorGUI;
import de.redcube.worldSwitcher.listeners.InventoryClickListener;
import de.redcube.worldSwitcher.worlds.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        /* --- Registering stuff --- */
        registerListeners();
        registerCommands();

        /* --- Init worlds --- */
        WorldManager.init();
        new SelectorGUI();
    }

    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public void registerCommands() {
        getCommand("switcher").setExecutor(new OpenSwitcherCommand());
    }

}
