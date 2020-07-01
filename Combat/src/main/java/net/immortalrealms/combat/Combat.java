package net.immortalrealms.combat;

import org.bukkit.plugin.java.JavaPlugin;

public class Combat extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CombatTag(), this);
        getServer().getPluginManager().registerEvents(new FallDamage(), this);
    }
}
