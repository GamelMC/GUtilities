package com.karatek.gutilities.commands;

/*
 * GUtilities
 * Copyright (C) 2019 GamelMC Developers / Karatek_HD
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import de.gamelmc.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Version implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //check if sender is player or console
        if(!(sender instanceof Player)) {
            //send version
            Bukkit.getConsoleSender().sendMessage("This Server is running GUtilities " + Main.version + ".");
            if(Main.unstable) {
                //send message for unstable version
                Bukkit.getConsoleSender().sendMessage("This Version is unstable.");
            }
            Bukkit.getServer().getConsoleSender().sendMessage("§6§lGUtilities\n" +
                    "§rCopyright (C) 2019 GamelMC Developers\n" +
                    "This program is free software: you can redistribute it and/or modify\n" +
                    "it under the terms of the GNU General Public License as published by\n" +
                    "the Free Software Foundation, either version 3 of the License, or\n" +
                    "(at your option) any later version.\n\n" +
                    "§cYou should have received a copy of the GNU General Public License\n" +
                    "§calong with this program.  If not, see §4https://www.gnu.org/licenses/§c.");
            return true;
        } else {
            //get sender
            Player p = (Player) sender;
            //send version
            p.sendMessage("This Server is running GUtilities §a" + Main.version + "§r.");
            if(Main.unstable) {
                //send message for unstable version
                p.sendMessage("This Version is unstable.");
            }
            p.sendMessage("§6§lGUtilities\n" +
                    "§rCopyright (C) 2019 GamelMC Developers\n" +
                    "This program is free software: you can redistribute it and/or modify\n" +
                    "it under the terms of the GNU General Public License as published by\n" +
                    "the Free Software Foundation, either version 3 of the License, or\n" +
                    "(at your option) any later version.\n\n" +
                    "§cYou should have received a copy of the GNU General Public License\n" +
                    "§calong with this program.  If not, see §4https://www.gnu.org/licenses/§c.");
        }
        return false;
    }

}
