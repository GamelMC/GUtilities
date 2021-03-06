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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ScoreboardManager implements Listener {

    private static ScoreboardManager manager;


    public void setBoard(Player p) {
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = s.registerNewObjective("aaa", "bbb");
        int players = Bukkit.getServer().getOnlinePlayers().size();
        // Einstellungen des Scoreboards
        o.setDisplayName("§6§lGamelMC§r.§6§lde");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        //Scores für das Scoreboard
        //Score Rang = o.getScore("> §3§lRang:");
        //if(PermissionsEx.getUser(p).inGroup("Admin")) {
        //    Score getRang = o.getScore("§cAdmin");
        //    getRang.setScore(10);
        //}
        //Score getRang = o.getScore(PermissionsEx.getUser(p).getPrefix().replace(":", null).replace(" ", null));
        //getRang.setScore(10);
        Score Rang = o.getScore("> §3§lRang:");

        if(PermissionsEx.getUser(p).inGroup("Admin")) {
            Score getRang = o.getScore("§cAdmin");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("Owner")) {
            Score getRang = o.getScore("§4§lOwner");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("Developer")) {
            Score getRang = o.getScore("§b§lDeveloper");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("Moderator")) {
            Score getRang = o.getScore("§2Moderator");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("Supporter")) {
            Score getRang = o.getScore("§aSupporter");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("Supporter")) {
            Score getRang = o.getScore("§aSupporter");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Friend")) {
            Score getRang = o.getScore("§dTeamFreund");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("FriendPlus")) {
            Score getRang = o.getScore("§dTeamFreund+");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("YouTuber+")) {
            Score getRang = o.getScore("§5YouTuber§4+");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("default")) {
            Score getRang = o.getScore("§7Spieler");
            getRang.setScore(10);
        }
        if(PermissionsEx.getUser(p).inGroup("Builder")) {
            Score getRang = o.getScore("§eBuilder");
            getRang.setScore(10);
        }


        Score Platzhalter0 = o.getScore("§0");
        Score Platzhalter1 = o.getScore("§1");
        Score Name = o.getScore("> §3§lName:");
        Score getName = o.getScore("§r" + p.getName());
        Score Platzhalter2 = o.getScore("§2");
        Score Kills = o.getScore(">§3§l TeamSpeak:");
        Score getKillsScore = o.getScore("§rgamelts.nitrado.net");
        Score Platzhalter3 = o.getScore("§3");
        Score Deaths = o.getScore(">§3§l Spieler:");
        Score getDeathsScore = o.getScore(" §r" + players + "/500");
        Score Platzhalter4 = o.getScore("§4");

        // Punkte für die Scores

        Platzhalter0.setScore(12);
        //Rang.setScore(11);
        Platzhalter1.setScore(9);
        Name.setScore(8);
        getName.setScore(7);
        Platzhalter2.setScore(6);
        Kills.setScore(5);
        getKillsScore.setScore(4);
        Platzhalter3.setScore(3);
        Deaths.setScore(2);
        getDeathsScore.setScore(1);
        Platzhalter4.setScore(0);

        p.setScoreboard(s);
        if(p.hasMetadata("scoremsg")) {
            p.sendMessage(Main.devprefix + "Dein Scoreboard wurde gesetzt!");
        }
    }

    public static ScoreboardManager getManager() {
        return manager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        manager = this;
        setBoard(e.getPlayer());
    }


}
