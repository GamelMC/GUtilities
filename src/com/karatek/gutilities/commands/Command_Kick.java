package com.karatek.gutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("§aDu musst ein Spieler sein!");
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
                        kickPlayer(target, reason, p);
                    }
                }
            }
        }

        return false;
    }

    public void kickPlayer(Player target, String reason, Player sender) {
        target.kickPlayer("§8[§4Strafe§8] §cDu wurdest §4vom Server geworfen§c.\n" +
                "\n" +
                "§eGrund: §r" + reason);
    }
}
