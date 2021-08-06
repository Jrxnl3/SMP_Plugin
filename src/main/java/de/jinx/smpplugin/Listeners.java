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
        e.setJoinMessage(SmpPlugin.PREFIX + e.getPlayer().getName() + " has joined §2SM§aPain§6 :)");
    }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent e){
        ScoreboardHandler.createScoreboard(e.getPlayer());
        e.setQuitMessage(SmpPlugin.PREFIX + e.getPlayer().getName() + " has quitted §2SM§aPain§6 :(");
    }

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        System.out.println(e.getDeathMessage());
        System.out.println("Death Location X:"+p.getLocation().getBlockX() + " Y: "+p.getLocation().getBlockY()+ " Z: "+p.getLocation().getBlockZ());

        e.setDeathMessage("§6"+p.getName() + " has just sadly passed away. :( \n F in the Chat.");
        p.sendMessage("§cYou died at X:"+p.getLocation().getBlockX() + " Y: "+p.getLocation().getBlockY()+ " Z: "+p.getLocation().getBlockZ());

    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {

            int p1HouseX = 324;
            int p2xHouseX = 361;
            int p1HouseZ = 342;
            int p2HouseZ = 397;

            int explodedX = event.getLocation().getBlockX();
            int explodedZ = event.getLocation().getBlockZ();

            if(event.getEntity().getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
                if (explodedX > p1HouseX && explodedX < p2xHouseX) {
                    if (explodedZ > p1HouseZ && explodedZ < p2HouseZ) {
                        Bukkit.getPlayer("Jinx_Dev").sendMessage("An Creeper exploded at " + event.getLocation().getBlockX() + " Y: " + event.getLocation().getBlockY() + " Z: " + event.getLocation().getBlockZ());
                        event.setCancelled(true);
                    }
                }
            }
    }

}
