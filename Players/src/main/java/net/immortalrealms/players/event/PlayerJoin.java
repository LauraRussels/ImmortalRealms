package net.immortalrealms.players.event;

import net.immortalrealms.players.stats.PlayerStats;
import net.immortalrealms.utility.ScoreboardHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoin extends PlayerStats implements Listener {
    private ScoreboardHandler scoreboardHandler;
    public PlayerJoin(ScoreboardHandler scoreboardHandler) { this.scoreboardHandler = scoreboardHandler; }

    @EventHandler(priority = EventPriority.HIGHEST) private void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        // Setup scoreboard.
        scoreboardHandler.setScoreboard(player);

        // Setup player inventory.
        player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD, 1));
        player.getInventory().setItem(1, new ItemStack(Material.FISHING_ROD, 1));
        player.getInventory().setItem(2, new ItemStack(Material.BOW, 1));
        player.getInventory().setItem(3, new ItemStack(Material.FLINT_AND_STEEL, 1));
        player.getInventory().setItem(4, new ItemStack(Material.ARROW, 16));

        /*
        * @param settingsMeta - allow for display name change.
         */
        final ItemStack settings = new ItemStack(Material.NETHER_STAR, 1);
        final ItemMeta settingsMeta = settings.getItemMeta();

        settingsMeta.setDisplayName("Settings");
        settings.setItemMeta(settingsMeta);

        player.getInventory().setItem(8, settings);

        if(player.hasPlayedBefore()) return;

        setPlayerKills(player, 0);
        setPlayerDeaths(player, 0);
        setPlayerScore(player, 100);
        setPlayerExperience(player, 0);
    }
}