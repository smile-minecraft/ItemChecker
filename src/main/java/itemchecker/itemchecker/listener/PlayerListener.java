package itemchecker.itemchecker.listener;

import fr.andross.banitem.events.PlayerBanItemEvent;
import fr.andross.banitem.items.BannedItem;
import itemchecker.itemchecker.ItemChecker;
import itemchecker.itemchecker.config.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerListener implements Listener {

    @EventHandler
    public void onSpawnerRemove(PlayerBanItemEvent event) {
        Float price;
        Player player = event.getPlayer();
        BannedItem item = event.getBannedItem();
        if (item.getType() == Material.SPAWNER) {
            player.sendMessage(ChatColor.YELLOW+"由於遊戲平衡的關係，生怪磚將被強制回收，\n你將獲得部分賠償");
            ItemChecker.getEconomy().depositPlayer(player, ConfigManager.getInt("item.price.spawner"));
            player.sendMessage(ChatColor.YELLOW+"你獲得了"+ConfigManager.getInt("item.price.spawner")+"元");
        }
    }

}
