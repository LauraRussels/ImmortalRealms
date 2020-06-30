package net.immortalrealms.utility;

import net.immortalrealms.players.stats.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler extends PlayerStats {
    public void setScoreboard(Player player) {
        final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = board.registerNewObjective(ChatUtility.colorText("&9&lImmortal"), "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score kills = objective.getScore(ChatUtility.colorText("&3Kills &e" + getPlayerKills(player)));
        kills.setScore(8);

        Score var = objective.getScore(ChatColor.YELLOW + " ");
        var.setScore(7);

        Score deaths = objective.getScore(ChatUtility.colorText("&3Deaths &e" + getPlayerDeaths(player)));
        deaths.setScore(6);

        Score var2 = objective.getScore(ChatColor.GREEN + " ");
        var2.setScore(5);

        Score score = objective.getScore(ChatUtility.colorText("&3Score &e" + getPlayerScore(player)));
        score.setScore(4);

        Score var3 = objective.getScore(ChatColor.BLUE + " ");
        var3.setScore(2);

        Score exp = objective.getScore(ChatUtility.colorText("&3Exp &e" + getPlayerExperience(player)));
        exp.setScore(3);

        Score var4 = objective.getScore(ChatColor.RED + " ");
        var4.setScore(2);

        Score KD = objective.getScore(ChatUtility.colorText("&3KD &e" + getPlayerKills(player) / getPlayerDeaths(player)));
        KD.setScore(1);

        player.setScoreboard(board);
    }
}
