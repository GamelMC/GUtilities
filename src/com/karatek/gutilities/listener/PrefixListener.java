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
        ScoreboardManager.getManager().setBoard(p);

    }
}
