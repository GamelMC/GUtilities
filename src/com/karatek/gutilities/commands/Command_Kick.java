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

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {
            if(strings.length < 1) {
                commandSender.sendMessage("§cVerwendung: /kick <Spieler> <Grund>");
                return false;
            } else {
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null) {
                    commandSender.sendMessage("$cDer Spieler §a" + strings[0] + " §cist nicht online!");
                    return false;
                } else {
                    String reason;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < strings.length; i++){
                        sb.append(strings[i]).append(" ");
                    }

                    reason = sb.toString().trim();
                    if(strings.length < 2) {
                        reason = "Vom Server geworfen.";
                    }
                    kickPlayer(target, reason);
                }
            }
            return true;
        } else {
            Player p = (Player) commandSender;
            if(!p.hasPermission("gamelmc.kick")) {
                p.sendMessage("§aDazu hast du keine Rechte!");

                return false;
            } else {
                if(strings.length < 1) {
                    p.sendMessage("§cVerwendung: /kick <Spieler> <Grund>");
                    return false;
                } else {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if(target == null) {
                        p.sendMessage("$cDer Spieler §a" + strings[0] + " §cist nicht online!");
                        return false;
                    } else {
                        String reason;
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < strings.length; i++){
                            sb.append(strings[i]).append(" ");
                        }

                        reason = sb.toString().trim();
                        if(strings.length < 2) {
                            reason = "Vom Server geworfen.";
                        }
                        kickPlayer(target, reason);
                    }
                }
            }
        }

        return false;
    }

    public void kickPlayer(Player target, String reason) {
        target.kickPlayer("§8[§4Strafe§8] §cDu wurdest §4vom Server geworfen§c.\n" +
                "\n" +
                "§eGrund: §r" + reason);
    }
}
