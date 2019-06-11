package com.karatek.gutilities.commands;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Command_Kopf implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //check if sender is a player
        if(sender instanceof Player) {
            Bukkit.getConsoleSender().sendMessage(Main.prefix + "Du musst ein Spieler sein!");

        }
        //get player
        Player p = (Player)sender;
        //check senders permission
        if(!p.hasPermission("gamelmc.kopf")) {
            p.sendMessage("§cDazu hast du keine Rechte!");
            return true;
        } if(args.length == 1) {
            //create itemstack if syntax is correct
            ItemStack is = new ItemStack(Material.SKULL_ITEM, 1 , (short)3);
            SkullMeta im = (SkullMeta)is.getItemMeta();
            //set metadata
            im.setOwner(args[0]);
            im.setDisplayName(args[0]);
            is.setItemMeta(im);
            //give the sender the item
            p.getInventory().addItem(new ItemStack[] {is});
            //update senders inventory
            p.updateInventory();
            //send message
            p.sendMessage(Main.pre + " Dir wurde der Kopf von §a" + args[0] + "§r gegeben.");
            return true;
        } else {

            //send help if syntax is wrong
            p.sendMessage(Main.pre + " Verwendung: /kopf <Spieler>");
            return true;

        }
    }
}
