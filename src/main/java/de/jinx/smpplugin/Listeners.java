package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class Listeners implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e){
        ScoreboardHandler.createScoreboard(e.getPlayer());
        e.setJoinMessage(SmpPlugin.PREFIX +"§b" +e.getPlayer().getName() + " §6has joined §2SM§aPain§6 :)");
    }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent e){
        ScoreboardHandler.createScoreboard(e.getPlayer());
        e.setQuitMessage(SmpPlugin.PREFIX + "§b"+e.getPlayer().getName() + "§6 has quitted §2SM§aPain§6 :(");
    }

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        System.out.println(e.getDeathMessage());
        System.out.println("Death Location X:"+p.getLocation().getBlockX() + " Y: "+p.getLocation().getBlockY()+ " Z: "+p.getLocation().getBlockZ());

        e.setDeathMessage("§6"+p.getName() + " has just sadly passed away. :( \n F in the Chat.");
        p.sendMessage("§cYou died at X:"+p.getLocation().getBlockX() + " Y: "+p.getLocation().getBlockY()+ " Z: "+p.getLocation().getBlockZ());

    }
}
