package net.immortalrealms.players;

import net.immortalrealms.players.event.PlayerDeath;
import net.immortalrealms.players.event.PlayerJoin;
import net.immortalrealms.players.event.PlayerQuit;
import net.immortalrealms.utility.ScoreboardHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Players extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeath(new ScoreboardHandler()), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(new ScoreboardHandler()), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
    }
}
