package com.karatek.gutilities.listener;

import de.gamelmc.gutilities.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class PlusListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        if(msg.equalsIgnoreCase("++dev")) {
            if(!p.hasPermission("gamelmc.devmode")) return;
            e.setCancelled(true);
            if(p.hasMetadata("devmode")) {
                p.removeMetadata("devmode", Main.getInstance());
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §cdeaktiviert.");
                return;
            } else {
                p.setMetadata("devmode", new FixedMetadataValue(Main.getInstance(), 0));
                p.sendMessage(Main.devprefix + "Entwicklungsmodus: §aaktiviert.");
                return;
            }
        }

        if(msg.startsWith("++") && p.hasMetadata("devmode")) {
            e.setCancelled(true);
            if(msg.equalsIgnoreCase("++help")) {
                sendHelp(p);
                return;
            }
            if(msg.equalsIgnoreCase("++reloadmsg")) {
                if (p.hasMetadata("reloadmsg")) {
                    p.sendMessage(Main.devprefix + "Reload Debug Modus: §cdeativiert§r.");
                    p.removeMetadata("reloadmsg", Main.getInstance());
                    return;

                } else {
                    p.sendMessage(Main.devprefix + "Reload Debug Modus: §aaktiviert§r.");
                    p.setMetadata("reloadmsg", new FixedMetadataValue(Main.getInstance(), 0));
                    return;
                }
            }
            if(msg.equalsIgnoreCase("++scoremsg")) {
                if (p.hasMetadata("scoremsg")) {
                    p.sendMessage(Main.devprefix + "Scoreboard Debug Modus: §cdeativiert§r.");
                    p.removeMetadata("scoremsg", Main.getInstance());
                    return;

                } else {
                    p.sendMessage(Main.devprefix + "Scoreboard Debug Modus: §aaktiviert§r.");
                    p.setMetadata("scoremsg", new FixedMetadataValue(Main.getInstance(), 0));
                    return;
                }
            }
            if(msg.equalsIgnoreCase("++test")) {
                p.sendMessage(Main.devprefix + "Der Entwicklermodus ist aktiviert!");
                return;
            }
            if(msg.equalsIgnoreCase("++devlocker")) {
                if(Main.devlock) {
                    Main.devlock = false;
                    p.sendMessage(Main.devprefix + "DevLocker: §causgeschltet§r.");
                    Bukkit.broadcastMessage(Main.prefix + "§rDer §cDevLocker §rist wieder ausgeschaltet.");
                    Bukkit.getServer().getConsoleSender().sendMessage(Main.devprefix + "DevLocker: §causgeschltet§r.");
                    return;
                } else {
                     Main.devlock = true;
                     p.sendMessage(Main.devprefix + "DevLocker: §aeingeschltet§r.");
                     Bukkit.broadcastMessage(Main.prefix + "§rDer §cDevLocker §rist derzeit §aaktiviert§r. Nur noch §bDeveloper§r können derzeit Änderungen durchführen!");
                     Bukkit.getServer().getConsoleSender().sendMessage(Main.devprefix + "DevLocker: §aeingeschltet§r.");
                     return;
                }
            }
            if(msg.equalsIgnoreCase("++spybps")) {
                if(p.hasMetadata("cmdspybypass")) {
                    p.sendMessage(Main.devprefix + "CommandSpy Bypass: §cdeativiert§r.");
                    p.removeMetadata("cmdspybypass", Main.getInstance());
                    return;

                } else {
                    p.sendMessage(Main.devprefix + "CommandSpy Bypass: §aaktiviert§r.");
                    p.setMetadata("cmdspybypass", new FixedMetadataValue(Main.getInstance(), 0));
                    return;
                }
            } else {
               p.sendMessage(Main.devprefix + "Unbekannter Befehl.");
            }
        }

    }

    public void sendHelp(Player p) {
        p.sendMessage("§7---------------------- " + Main.devprefix + "§7---------------------\n" +
                "§7• §6++test §r-§7 Prüft, ob der DevMode aktiviert ist.\n" +
                checkActive(p, "reloadmsg") + " §6++reloadmsg §r-§7 Schaltet Debug Informationen zum Laden von GUtilities ein oder aus.\n" +
                checkActive(p, "cmdspybypass") +" §6++spybps §r-§7 Macht dich unsichtbar gegenüber dem CommandSpy.\n" +
                checkActive(p,"scoremsg") + " §6++scoremsg §r-§7 Schaltet Debug Informationen zum Scoreboard an oder aus.\n" +
                devlockChecker() + " §6++devlocker §r-§7 Schaltet den DevLocker ein/aus.\n" +
                checkActive(p, "devmode") + " §6++dev §r-§7 Schaltet den Entwicklermodus aus.");
    }

    public String checkActive(Player player, String metadata) {
        if(player.hasMetadata(metadata)) return "§a§l•";
        else return "§c§l•";
    }

    public String devlockChecker() {
        if(Main.devlock) return "§a§l•";
        else return "§c§l•";
    }

}
