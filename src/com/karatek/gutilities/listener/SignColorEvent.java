package com.karatek.gutilities.listener;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignColorEvent implements Listener {


    @EventHandler
    public void onSign(SignChangeEvent e)  {

        //get Player
        Player p = e.getPlayer();



        //check Permission
        if(p.hasPermission("gamelmc.colorsign")) {

            //get Strings
            String l1 = e.getLine(0).replace("&", "§");
            String l2 = e.getLine(1).replace("&", "§");
            String l3 = e.getLine(2).replace("&", "§");
            String l4 = e.getLine(3).replace("&", "§");

            //set Colour
            e.setLine(0, l1);
            e.setLine(1, l2);
            e.setLine(2, l3);
            e.setLine(3, l4);
        } else {
            p.sendMessage(Main.pre + "Du hast keine Rechte um farbig zu schreiben!");
        }
    }

}
