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

import de.gamelmc.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(all.hasMetadata("spyer")) {
                if(all.getUniqueId() == p.getUniqueId()) return;
                if(p.hasMetadata("cmdspybypass")) return;
                all.sendMessage(Main.prefix + "§rDer Spieler " + p.getDisplayName() + " §rhat einen Command ausgeführt: §a" + e.getMessage());
            }
        }
        ScoreboardManager.getManager().setBoard(p);
    }


}
