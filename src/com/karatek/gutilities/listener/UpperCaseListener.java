package com.karatek.gutilities.listener;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class UpperCaseListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        //get player
        Player p = e.getPlayer();
        //check for uppercase letter
        final String m = e.getMessage().trim();
        float uppercaseLetter = 0;
        for(int i = 0; i < m.length(); i ++ ) {
            if(Character.isUpperCase(m.charAt(i)) && Character.isLetter(m.charAt(i))) {
                uppercaseLetter++;
            }
        }
        if(uppercaseLetter / (float) m.length() > 0.4F) {
            //check bypass permission
            if(!p.hasPermission("gamelmc.useuppercase")) {
                //cancel event and send message
                e.getPlayer().sendMessage(Main.pre + " Bitte benutze nicht so viele Großbuchstaben!");
                e.setCancelled(true);
            }
        }
    }
}
