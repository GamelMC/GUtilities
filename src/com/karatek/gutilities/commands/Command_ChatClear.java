package com.karatek.gutilities.commands;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_ChatClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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
