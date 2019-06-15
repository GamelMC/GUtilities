package com.karatek.gutilities.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakListener implements Listener {


    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        ScoreboardManager.getManager().setBoard(e.getPlayer());
    }
}
