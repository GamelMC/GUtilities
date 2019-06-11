package com.karatek.gutilities.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PrefixListener implements Listener {

    @EventHandler

    public void onChat(AsyncPlayerChatEvent e) {
        //get player
        Player p = e.getPlayer();
        //get message
        String msg = e.getMessage();
        //check permission for adminchat
        if(p.hasMetadata("tclogin")) return;
        if(!p.hasPermission("gamelmc.adminchat")) {
            e.setFormat(p.getDisplayName() + " §r: " + msg);
        }
        if(p.hasPermission("gamelmc.adminchat")) {
            e.setFormat("§8»\n§r" + p.getDisplayName() + " §r: §a§l" + msg + "\n§8»");
        }
    }
}
