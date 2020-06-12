package net.immortalrealms.players.event;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.VisibilityManager;
import com.gmail.filoghost.holographicdisplays.api.line.HologramLine;
import com.gmail.filoghost.holographicdisplays.api.line.ItemLine;
import com.gmail.filoghost.holographicdisplays.api.line.TextLine;
import net.immortalrealms.Root;
import net.immortalrealms.players.stats.KillStreak;
import net.immortalrealms.players.stats.PlayerStats;
import net.immortalrealms.utils.ChatUtility;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.EnumSet;

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

            // Damager handling

            setPlayerKills(damager, (getPlayerKills(damager) + 1));
            setPlayerExperience(damager, (getPlayerExperience(damager) + 100));
            setPlayerScore(damager, (int) (getPlayerScore(player) + Math.round(getPlayerScore(damager) * 0.2)));

            // Dead player handling

            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1, 10);
            setPlayerDeaths(player, (getPlayerDeaths(player) + 1));
            if(getPlayerScore(player) > 10) {
                setPlayerScore(player, (int) (getPlayerScore(player) - Math.round(getPlayerScore(damager) * 0.2)));
            }

            Location playerLocAdjust = new Location(player.getWorld(), player.getLocation().getX(), (player.getLocation().getY() + 3.5), player.getLocation().getZ());

            Hologram hologram = HologramsAPI.createHologram(Root.getPlugin(Root.class), playerLocAdjust);
            hologram.clearLines();

            hologram.appendTextLine(ChatUtility.colorText("&4&l** &c&lPLAYER DEATH &4&l**"));
            hologram.appendTextLine(ChatUtility.colorText("&f&lRIP &f" + player.getName() + " - " + damager.getName() + "'s &e#" + getPlayerKills(damager) + " &fvictim."));
            hologram.appendTextLine(ChatUtility.colorText("&f+ &e" + Math.round(getPlayerScore(damager) * 0.2) + " &fscore."));
            hologram.appendTextLine(ChatUtility.colorText("&f+ &e100 &fexperience."));

            Bukkit.getScheduler().runTaskLater(Root.getPlugin(Root.class), hologram::delete, 200L);
        }
    }
}