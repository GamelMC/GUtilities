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
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(all.hasMetadata("joinmsg")) {
                if(all.getUniqueId() == p.getUniqueId()) return;
                all.sendMessage("§7[§4-§7] " + e.getPlayer().getName());
            }
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        e.setLeaveMessage(null);
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(all.hasMetadata("joinmsg")) {
                if(all.getUniqueId() == p.getUniqueId()) return;
                all.sendMessage("§7[§4K§7] " + e.getPlayer().getName());
            }
        }
    }

}
