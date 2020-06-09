package net.immortalrealms.utils;

import org.bukkit.ChatColor;

public class ChatUtility {
    public static String colorText(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
