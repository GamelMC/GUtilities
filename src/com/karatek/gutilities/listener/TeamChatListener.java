package com.karatek.gutilities.listener;

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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TeamChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if(p.hasMetadata("tclogin")) {
            e.setCancelled(true);
            if(p.hasMetadata("devmode")) {
                if(e.getMessage().startsWith("++")) return;
            }
            if(e.getMessage().equalsIgnoreCase("++dev")) {
                e.setCancelled(true);
            }
            for(Player all : Bukkit.getOnlinePlayers()) {

                if(all.hasMetadata("tclogin")) {
                    all.sendMessage("§f[§4§lTEAMCHAT§r§f] " + p.getDisplayName() + " §8>> §r" + e.getMessage());
                }
            }
        } else {
            if(e.getMessage().startsWith("++dev")) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }

        }
    }

}
