package com.karatek.gutilities.listener;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BroadcastListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        //get Player
        Player p = e.getPlayer();
        //check beginning
        if(e.getMessage().startsWith("@bc")) {
            //check senders permission
            if(!p.hasPermission("gamelmc.broadcast")) {
                p.sendMessage("§cDazu hast du keine Rechte!");
                e.setCancelled(true);
            } else {
                //broadcast
                String bcmsgorig = e.getMessage();
                String bcmsg = bcmsgorig.replaceAll("@bc", "§a§l");
                Bukkit.broadcastMessage("-------------------" + Main.pre + "-------------------");
                Bukkit.broadcastMessage(bcmsg);
                Bukkit.broadcastMessage("-------------------" + Main.pre + "-------------------");
                e.setCancelled(true);
                p.sendMessage(Main.pre + "§r Deine Nachicht wurde ausgegeben.");
            }
        }
    }
}
