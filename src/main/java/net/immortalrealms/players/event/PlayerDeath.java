package net.immortalrealms.players.event;

import net.immortalrealms.Root;
import net.immortalrealms.players.stats.KillStreak;
import net.immortalrealms.players.stats.PlayerStats;
import net.immortalrealms.utils.ChatUtility;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.time.Duration;
import java.time.Instant;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.SECONDS;

public class PlayerDeath extends PlayerStats implements Listener {
    @EventHandler(priority = EventPriority.HIGH) private void onPlayerDeath(EntityDamageByEntityEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        if(!(event.getDamager() instanceof Player)) return;

        final Player player = (Player) event.getEntity();
        final Player damager = (Player) event.getDamager();

        final double playerHealth = player.getHealth();
        final double damageDealt = event.getDamage();

        // Damager will kill player on next hit, so we cancel it to force respawn.
        if(playerHealth - damageDealt <= 0.0D) {
            event.setCancelled(true);

            ArmorStand armorStand = (ArmorStand) player.getWorld().spawn(player.getLocation(), ArmorStand.class);
            armorStand.setGravity(false);
            armorStand.setCanPickupItems(false);
            armorStand.setCustomName(ChatUtility.colorText("&4&l** &cPLAYER DEATH &4&l**\n" +
                    "&7RIP " + player.getName() + " - " + damager.getName() + "'s &e#" + getPlayerKills() + " &7victim.\n" +
                    "&7+ &e" + Math.round(getPlayerScore() * 0.2) + " &7score.\n" +
                    "&7+ &e100 &7experience."));
            armorStand.setCustomNameVisible(true);
            armorStand.setVisible(false);

            Bukkit.getScheduler().runTaskLater(Root.getPlugin(Root.class), armorStand::remove, 200L);

            // Dead player handling

            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1, 10);
            setPlayerDeaths(getPlayerDeaths() + 1);

            // Damager handling

            setPlayerKills(getPlayerKills() + 1);
            setPlayerExperience(getPlayerExperience() + 100);
            setPlayerScore((int) (getPlayerScore() + Math.round(getPlayerScore() * 0.2)));

            Root.killStreak.replace(player, getKillStreak(player), getKillStreak(player) + 1);

            EnumSet.allOf(KillStreak.class).forEach(killStreak -> {
                if(killStreak.getActualInteger() == getKillStreak(damager)) {
                    setPlayerExperience(getPlayerExperience() + killStreak.getBonusExperience());

                    damager.sendMessage(ChatUtility.colorText("&e&l* BONUS &eYou gained an extra " + killStreak.getBonusExperience() + " experience."));
                    Root.getPlugin(Root.class).getServer().getOnlinePlayers().forEach(players -> players.sendMessage(ChatUtility.colorText("&c&l* KILL STREAK &c" + damager.getName() + " is on a kill streak of " + killStreak.getActualInteger() + "!")));
                }
            });
        }
    }
}