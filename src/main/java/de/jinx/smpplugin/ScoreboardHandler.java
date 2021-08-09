package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardHandler {

    public static void createScoreboard(Player p) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("test", "dummy", "§2SM§aPain§6");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("").setScore(8);
        obj.getScore("§6§lPlayer:").setScore(7);
        obj.getScore("§a" + p.getName()).setScore(6);
        obj.getScore(" ").setScore(5);
        obj.getScore("§6§lObjective").setScore(4);
        obj.getScore("§aBuild a Tower").setScore(3);
        obj.getScore("  ").setScore(2);
        obj.getScore("§d§lDiscord:").setScore(1);
        obj.getScore("§adiscord.gg/wUUKbk7eaz").setScore(0);

        p.setScoreboard(scoreboard);
    }

    }
