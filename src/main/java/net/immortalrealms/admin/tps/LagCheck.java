package net.immortalrealms.admin.tps;

import net.immortalrealms.permissions.PermissionsHandler;
import net.immortalrealms.utils.ChatUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LagCheck extends PermissionsHandler implements Runnable {
    @Override
    public void run() {
        if(Lag.getTPS() <= 18) {
            for(Player player : Bukkit.getOnlinePlayers()) {
                // Avoid console throwing errors if no-one is online to receive the message.
                if(player == null) return;

                if(isAdministrator(player)) {
                    player.sendMessage(ChatUtility.colorText("&4&l│ &cWARNING\n "));

                    player.sendMessage(ChatUtility.colorText("&c&l> &7Server memory may be &coverloaded&7 Please inform an Administrator.\n "));

                    player.sendMessage(ChatUtility.colorText("&4&l│ &cINFORMATION\n "));

                    player.sendMessage(ChatUtility.colorText("&c&l> &7Current TPS: &c" + Lag.getTPS()));
                    player.sendMessage(ChatUtility.colorText("&c&l> &7Current memory usage: &c" + Lag.getFreeMemory() + "/" + Lag.getTotalMemory() + "MB."));
                }
            }
        }
    }
}
