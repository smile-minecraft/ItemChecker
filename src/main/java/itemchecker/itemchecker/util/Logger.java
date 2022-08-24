package itemchecker.itemchecker.util;

import org.bukkit.Bukkit;

public class Logger {

    public static void info(String message){
        Bukkit.getLogger().info(message);
    }

    public static void severe(String message){
        Bukkit.getLogger().severe(message);
    }

    public static void warning(String message){
        Bukkit.getLogger().warning(message);
    }

    public static void debug(String message){
        Bukkit.getLogger().info(message);
    }

}
