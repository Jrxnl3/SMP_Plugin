package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmpPlugin extends JavaPlugin {

    private static SmpPlugin plugin;
    public static String PREFIX = "§5SMP §6Name >> ";

    @Override
    public void onEnable() {
        plugin = this;


        System.out.println("SMP Plugin has loaded!");
        PluginManager pl = Bukkit.getPluginManager();

        pl.registerEvents(new Listeners(),this);

        this.getCommand("broadcast").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SmpPlugin getPlugin() {
        return plugin;
    }

}
