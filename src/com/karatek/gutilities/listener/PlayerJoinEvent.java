package com.karatek.gutilities.listener;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        e.setJoinMessage(null);
        if(e.getPlayer().hasPermission("gamelmc.teamchat")) {
            Player p = e.getPlayer();
            boolean loggedin = p.hasMetadata("tclogin");
            if(loggedin) {
                p.sendMessage(Main.prefix + "Status im Teamchat: §aeingeloggt.");
            } else {
                p.sendMessage(Main.prefix + "Status im Teamchat: §causgeloggt.");
            }
        }
    }


}
