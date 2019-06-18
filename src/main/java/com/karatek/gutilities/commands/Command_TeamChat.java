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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class Command_TeamChat implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("§cDu musst ein Spieler sein!");
            return false;
        } else {
            Player p = (Player) sender;
            if(!p.hasPermission("gamelmc.teamchat")) {
                p.sendMessage("§cDazu hast du keine Rechte!");
                return false;
            } else {
                if(p.hasMetadata("tclogin")) {
                    p.sendMessage(Main.prefix + "Status im Teamchat: §causgeloggt");
                    p.removeMetadata("tclogin", Main.getInstance());
                } else {
                    p.sendMessage(Main.prefix + "Status im Teamchat: §aeingeloggt");
                    p.setMetadata("tclogin", new FixedMetadataValue(Main.getInstance(), 0));

                }

            }
        }
        return false;
    }
}
