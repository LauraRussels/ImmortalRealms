package net.immortalrealms.players.event;

import net.immortalrealms.combat.CombatTag;
import net.immortalrealms.players.stats.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends PlayerStats implements Listener {
    @EventHandler(priority = EventPriority.MONITOR) private void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        if(CombatTag.combatTag.contains(player)) {
            setPlayerDeaths(player, getPlayerDeaths(player) + 1);
            setPlayerScore(player, (int) (getPlayerScore(player) - Math.round(getPlayerScore(player) * 0.2)));
        }
    }
}
