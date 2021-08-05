package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler {

    public static void createScoreboard(Player p) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("test", "dummy", "§6/vote for cool SMP Name :)");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("").setScore(9);
        obj.getScore("§6§lPlayer:").setScore(8);
        obj.getScore("§a" + p.getName()).setScore(7);
        obj.getScore(" ").setScore(6);
        obj.getScore("§6Commands").setScore(5);
        obj.getScore("§2/vote").setScore(4);
        obj.getScore("§2/votelist").setScore(3);
        obj.getScore("   ").setScore(2);
        obj.getScore("§dDiscord:").setScore(1);
        obj.getScore("§adiscord.gg/wUUKbk7eaz").setScore(0);

        p.setScoreboard(scoreboard);
    }

    }