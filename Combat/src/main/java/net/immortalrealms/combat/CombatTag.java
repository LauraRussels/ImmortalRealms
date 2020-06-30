package net.immortalrealms.combat;

import net.immortalrealms.utility.ChatUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;


public class CombatTag implements Listener {
    public static ArrayList<Player> combatTag = new ArrayList<>();

    @EventHandler(priority = EventPriority.MONITOR) private void onInteract(EntityDamageByEntityEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        if(!(event.getDamager() instanceof Player)) return;

        final Player player = (Player) event.getEntity();
        final Player damager = (Player) event.getDamager();

        if(event.getCause() == EntityDamageEvent.DamageCause.PROJECTILE || event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            if(combatTag.contains(player)) return;
            if(combatTag.contains(damager)) return;

            combatTag.add(player);
            player.sendMessage(ChatUtility.colorText("&4&l* &cYou have been combat tagged by " + damager.getName() + ".\n" +
                    "&7* Logging out within 20 seconds will result in stat loss."));

            combatTag.add(damager);
            damager.sendMessage(ChatUtility.colorText("&4&l* &cYou have combat tagged " + player.getName() + ".\n" +
                    "&7* Logging out within 20 seconds will result in stat loss."));

            Bukkit.getScheduler().runTaskLater(Combat.getPlugin(Combat.class), () -> {
                combatTag.remove(player);
                combatTag.remove(damager);
            }, 20 * 20L);
        }
    }
}