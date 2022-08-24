package itemchecker.itemchecker;

import fr.andross.banitem.BanItem;
import fr.andross.banitem.BanItemAPI;
import itemchecker.itemchecker.listener.PlayerListener;
import itemchecker.itemchecker.util.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemChecker extends JavaPlugin {

    private static Plugin plugin;

    {
        plugin = this;
    }


    private static Economy econ = null;

    @Override
    public void onEnable() {
        if (!setupBanItem()){
            Logger.severe("Could not find BanItem, disabling plugin");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        final BanItem banItem = (BanItem) getServer().getPluginManager().getPlugin("BanItem");
        final BanItemAPI banItemApi = banItem.getApi();

        if (!setupEconomy() ) {
            Logger.severe(String.format("[%s] - Could not find Vault!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Logger.info("ItemChecker已經成功啟動!");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    private boolean setupBanItem() {
        return getServer().getPluginManager().getPlugin("BanItem") != null;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return true;
    }

    public static Economy getEconomy() {
        return econ;
    }
    public static Plugin getPlugin() {
        return plugin;
    }

}
