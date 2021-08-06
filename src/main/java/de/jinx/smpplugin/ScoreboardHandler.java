package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler {

    public static void createScoreboard(Player p) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("test", "dummy", "§2SM§aPain§6");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("").setScore(6);
        obj.getScore("§6§lPlayer:").setScore(5);
        obj.getScore("§a" + p.getName()).setScore(4);
        obj.getScore(" ").setScore(3);
        obj.getScore("§5§lEnd:").setScore(3);
        obj.getScore("§e15 o'clock 07.08.").setScore(3);
        obj.getScore("  ").setScore(2);
        obj.getScore("§d§lDiscord:").setScore(1);
        obj.getScore("§adiscord.gg/wUUKbk7eaz").setScore(0);

        p.setScoreboard(scoreboard);
    }

    }
