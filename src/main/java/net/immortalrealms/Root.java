package net.immortalrealms;

import net.immortalrealms.admin.commands.RankCommand;
import net.immortalrealms.admin.tps.Lag;
import net.immortalrealms.admin.tps.LagCheck;
import net.immortalrealms.permissions.users.UserEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Root extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new LagCheck(), 0L, 6000L);

        getServer().getPluginManager().registerEvents(new UserEvents(), this);

        getCommand("rank").setExecutor(new RankCommand());
    }
}
