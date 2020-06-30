package net.immortalrealms.utility;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatUtility extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();
    }

    public static String colorText(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
