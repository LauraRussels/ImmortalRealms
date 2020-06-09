package net.immortalrealms.permissions.users;

import net.immortalrealms.permissions.PermissionsHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UserEvents extends PermissionsHandler implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST) private void onUserJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        if(!player.hasPlayedBefore()) {
            setGroup(player, "default");
        }
    }
}
