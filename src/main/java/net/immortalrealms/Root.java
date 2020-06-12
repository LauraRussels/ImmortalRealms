package net.immortalrealms;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Root extends JavaPlugin {
    public static HashMap<Player, Integer> killStreak;

    @Override
    public void onEnable() {
        if(this.getServer().getOnlinePlayers() == null) return;

        killStreak = new HashMap<>();
        this.getServer().getOnlinePlayers().forEach(player -> killStreak.put(player, 0));

        saveDefaultConfig();
    }

    @Override
    public FileConfiguration getConfig() {
        return super.getConfig();
    }

    @Override
    public void saveConfig() {
        super.saveConfig();
    }

    @Override
    public void onDisable() {
        killStreak.clear();
    }
}
