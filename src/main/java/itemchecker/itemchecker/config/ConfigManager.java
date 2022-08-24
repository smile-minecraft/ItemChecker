package itemchecker.itemchecker.config;

import itemchecker.itemchecker.ItemChecker;
import org.bukkit.plugin.Plugin;

public class ConfigManager {
    static Plugin plugin = ItemChecker.getPlugin();


    public static int getInt(String path) {
        return plugin.getConfig().getInt(path);
    }

    public static boolean getBoolean(String path) {
        return plugin.getConfig().getBoolean(path);
    }

    public static String getString(String path) {
        return plugin.getConfig().getString(path);
    }



    public static void set(String path, Object value) {
        plugin.getConfig().set(path, value);
    }

    public static void addDefault(String path, Object value) {
        if (!plugin.getConfig().contains(path)) {
            plugin.getConfig().addDefault(path, value);
        }
    }

    public static void saveConfig() {
        plugin.saveConfig();
    }

    public static void reloadConfig() {
        plugin.reloadConfig();
    }

    public static void saveDefaultConfig() {
        plugin.saveDefaultConfig();
    }



}
