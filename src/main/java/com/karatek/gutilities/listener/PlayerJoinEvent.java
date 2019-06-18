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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        if(e.getPlayer().hasPermission("gamelmc.teamchat")) {
            boolean loggedin = p.hasMetadata("tclogin");
            if(loggedin) {
                p.sendMessage(Main.prefix + "Status im Teamchat: §aeingeloggt.");
            } else {
                p.sendMessage(Main.prefix + "Status im Teamchat: §causgeloggt.");
            }
        }
        PermissionUser pu = PermissionsEx.getUser(p);
        if(pu.inGroup("Developer") || pu.inGroup("MainDeveloper")) {
            boolean devmode = p.hasMetadata("devmode");
            if(devmode) {
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §aaktiviert.");
            } else {
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §cdeaktiviert.");
            }
        }

    }


}
