package net.immortalrealms.players.stats;

import net.immortalrealms.Root;
import org.bukkit.entity.Player;

public abstract class PlayerStats {
    public int getPlayerKills() {
        return playerKills;
    }

    public void setPlayerKills(int playerKills) {
        this.playerKills = playerKills;
    }

    public int playerKills;

    public int getPlayerDeaths() {
        return playerDeaths;
    }

    public void setPlayerDeaths(int playerDeaths) {
        this.playerDeaths = playerDeaths;
    }

    public int playerDeaths;

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int playerScore;

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int playerLevel;

    public double getPlayerExperience() {
        return playerExperience;
    }

    public void setPlayerExperience(double playerExperience) {
        this.playerExperience = playerExperience;
    }

    public double playerExperience;

    public int getKillStreak(Player player) {
        return Root.killStreak.get(player);
    }
}
