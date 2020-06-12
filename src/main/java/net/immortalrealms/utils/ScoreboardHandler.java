package net.immortalrealms.utils;

import net.immortalrealms.players.stats.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler extends PlayerStats {
    public void setScoreboard(Player player) {
        final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = board.registerNewObjective(ChatUtility.colorText("&c&lImmortal Realms"), "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score kills = objective.getScore(ChatUtility.colorText("&6Kills &e" + getPlayerKills(player)));
        kills.setScore(5);

        Score deaths = objective.getScore(ChatUtility.colorText("&6Deaths &e" + getPlayerDeaths(player)));
        deaths.setScore(4);

        Score score = objective.getScore(ChatUtility.colorText("&6Score &e" + getPlayerScore(player)));
        score.setScore(3);

        Score exp = objective.getScore(ChatUtility.colorText("&6Exp &e" + getPlayerExperience(player)));
        exp.setScore(2);

        Score KD = objective.getScore(ChatUtility.colorText("&6KD &e" + getPlayerKills(player) / getPlayerDeaths(player)));
        KD.setScore(1);

        player.setScoreboard(board);
    }
}
