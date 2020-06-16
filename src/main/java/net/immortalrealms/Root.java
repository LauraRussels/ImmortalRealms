package net.immortalrealms;

import net.immortalrealms.players.combat.CombatTag;
import net.immortalrealms.players.event.PlayerDeath;
import net.immortalrealms.players.event.PlayerJoin;
import net.immortalrealms.players.event.PlayerQuit;
import net.immortalrealms.utils.ScoreboardHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Root extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Player events
        getServer().getPluginManager().registerEvents(new PlayerDeath(new ScoreboardHandler()), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(new ScoreboardHandler()), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);

        // Combat events
        getServer().getPluginManager().registerEvents(new CombatTag(), this);
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
        saveConfig();
    }
}