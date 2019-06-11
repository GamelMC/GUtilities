package de.gamelmc.gutilities.main;

import com.karatek.gutilities.commands.*;
import com.karatek.gutilities.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {


    public static String prefix = "§r[§6GamelMC§r] ";
    public static String pre = prefix;
    public static boolean unstable = true;
    public static String version = "1.0";


    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDas GUtilities Plugin wurde aktiviert.");

        instance = this;

        //register Commands
        this.getCommand("kick").setExecutor(new Command_Kick());
        this.getCommand("kopf").setExecutor(new Command_Kopf());
        this.getCommand("chatclear").setExecutor(new Command_ChatClear());
        this.getCommand("cc").setExecutor(new Command_ChatClear());
        this.getCommand("gversion").setExecutor(new Command_Version());
        this.getCommand("tc").setExecutor(new Command_TeamChat());

        //get PluginManager
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new PlayerSignListener(), this);
        pm.registerEvents(new SignColorEvent(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new PrefixListener(), this);
        pm.registerEvents(new BroadcastListener(), this);
        pm.registerEvents(new PlayerJoinEvent(), this);
        pm.registerEvents(new TeamChatListener(), this);
        pm.registerEvents(new UpperCaseListener(), this);

    }



}
