package com.karatek.gutilities.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TeamChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(p.hasMetadata("tclogin")) {
            for(Player all : Bukkit.getOnlinePlayers()) {

                    if(all.hasMetadata("tclogin")) {
                        all.sendMessage("§f[§4§lTEAMCHAT§r§f] " + p.getDisplayName() + " §8>> §r" + e.getMessage());
                    }
                }
            e.setCancelled(true);
        } else {
            return;
        }
    }

}
