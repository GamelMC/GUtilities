package com.karatek.gutilities.commands;

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
