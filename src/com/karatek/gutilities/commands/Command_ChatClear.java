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

public class Command_ChatClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            for (int i= 0; i < 105; ++i) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(!all.hasPermission("gamelmc.chatclear.see")) {
                        all.sendMessage("");
                    }
                }
            }
             Bukkit.broadcastMessage(Main.pre + " §7Der Chat wurde von §e" + "§4§lConsole" + "§7 geleert!");
            return true;
        }
        //get player
        Player p = (Player) sender;
        //check players permission
        if(!p.hasPermission("gamelmc.chatclear")) {
            p.sendMessage("§cDazu hast du keine Rechte!");
        } else {
            //get all players and clear the chat
            for (int i= 0; i < 105; ++i) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(!all.hasPermission("gamelmc.chatclear.see")) {
                        all.sendMessage("");
                    }
                }
            }
            //send message
            Bukkit.broadcastMessage(Main.pre + " §7Der Chat wurde von §e" + p.getDisplayName() + "§7 geleert!");
        }
        return false;
    }

}
