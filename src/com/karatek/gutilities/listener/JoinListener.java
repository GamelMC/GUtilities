package com.karatek.gutilities.listener;

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

public class JoinListener implements Listener {

        public static void setBoard(Player p) {
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = s.registerNewObjective("aaa", "bbb");
        int players = Bukkit.getServer().getOnlinePlayers().size();

        // Einstellungen des Scoreboards

        o.setDisplayName("§6§lGamelMC§r.§6§lde");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Scores für das Scoreboard

        //Score Rang = o.getScore("> §3§lRang:");
        //if(PermissionsEx.getUser(p).inGroup("Admin")) {
        //    Score getRang = o.getScore("§cAdmin");
        //    getRang.setScore(10);
        //}
        //Score getRang = o.getScore(PermissionsEx.getUser(p).getPrefix().replace(":", null).replace(" ", null));
        //getRang.setScore(10);
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
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        setBoard(e.getPlayer());
    }


}
