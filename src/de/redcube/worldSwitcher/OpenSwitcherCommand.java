package de.redcube.worldSwitcher;

import de.redcube.worldSwitcher.gui.SelectorGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenSwitcherCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            p.openInventory(SelectorGUI.selectorInv);
        }

        return true;
    }

}
