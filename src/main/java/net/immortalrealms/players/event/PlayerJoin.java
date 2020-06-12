package net.immortalrealms.players.event;

import net.immortalrealms.Root;
import net.immortalrealms.players.stats.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin extends PlayerStats implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST) private void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if(player.hasPlayedBefore()) return;

        setPlayerKills(player, 0);
        setPlayerDeaths(player, 0);
        setPlayerScore(player, 100);
        setPlayerExperience(player, 0);
    }
}