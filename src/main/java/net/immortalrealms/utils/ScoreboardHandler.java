package net.immortalrealms.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler {
    public void setScoreboard(Player player) {
        final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = board.registerNewObjective(ChatUtility.colorText("&e&lImmortal Realms"), "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);


    }
}
