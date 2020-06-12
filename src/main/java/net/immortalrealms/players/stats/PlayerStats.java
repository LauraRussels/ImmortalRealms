package net.immortalrealms.players.stats;

import net.immortalrealms.Root;
import org.bukkit.entity.Player;

public abstract class PlayerStats {
    private Root root = Root.getPlugin(Root.class);

    public int getPlayerKills(Player player) {
        return root.getConfig().getInt(player.getUniqueId() + ".kills");
    }

    public void setPlayerKills(Player player, int playerKills) {
        root.getConfig().set(player.getUniqueId() + ".kills", playerKills);
        root.saveConfig();
    }

    public int getPlayerDeaths(Player player) {
        return root.getConfig().getInt(player.getUniqueId() + ".deaths");
    }

    public void setPlayerDeaths(Player player, int playerDeaths) {
        root.getConfig().set(player.getUniqueId() + ".deaths", playerDeaths);
        root.saveConfig();
    }

    public int getPlayerScore(Player player) {
        return root.getConfig().getInt(player.getUniqueId() + ".score");
    }

    public void setPlayerScore(Player player, int playerScore) {
        root.getConfig().set(player.getUniqueId() + ".score", playerScore);
        root.saveConfig();
    }

    public int getPlayerLevel(Player player) {
        return root.getConfig().getInt(player.getUniqueId() + ".level");
    }

    public void setPlayerLevel(Player player, int playerLevel) {
        root.getConfig().set(player.getUniqueId() + ".level", playerLevel);
        root.saveConfig();
    }

    public int getPlayerExperience(Player player) {
        return root.getConfig().getInt(player.getUniqueId() + ".experience");
    }

    public void setPlayerExperience(Player player, int playerExperience) {
        root.getConfig().set(player.getUniqueId() + ".experience", playerExperience);
        root.saveConfig();
    }

    public int getKillStreak(Player player) {
        return Root.killStreak.get(player);
    }
}
