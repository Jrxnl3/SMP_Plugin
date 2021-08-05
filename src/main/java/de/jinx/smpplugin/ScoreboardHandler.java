package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler {

    public static void createScoreboard(Player p) {

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("test", "dummy", "§6Insert name :)");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("").setScore(10);
        obj.getScore("§6§lPlayer:").setScore(9);
        obj.getScore("§a" + p.getName()).setScore(8);
        obj.getScore(" ").setScore(7);
        obj.getScore("§6§lVoted Names:").setScore(6);
        obj.getScore("§2Elemental(SMP)").setScore(5);
        obj.getScore("§2SMPain").setScore(4);
        obj.getScore("§2Ultimate-SMP").setScore(3);
        obj.getScore("   ").setScore(2);
        obj.getScore("§d§lDiscord:").setScore(1);
        obj.getScore("§adiscord.gg/wUUKbk7eaz").setScore(0);

        p.setScoreboard(scoreboard);
    }

    }
