package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmpPlugin extends JavaPlugin {

    private static SmpPlugin plugin;
    public static String PREFIX = "§2SM§aPain§6 >> §r";

    @Override
    public void onEnable() {
        plugin = this;


        System.out.println("SMPain has loaded!");
        PluginManager pl = Bukkit.getPluginManager();

        pl.registerEvents(new Listeners(),this);

        this.getCommand("broadcast").setExecutor(new Commands());
        this.getCommand("rename").setExecutor(new Commands());
        this.getCommand("testString").setExecutor(new Commands());

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(NamespacedKey.fromString("smpplugin"),new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH,1,20*30);
        SmokingRecipe leatherSmoker = new SmokingRecipe(NamespacedKey.fromString("smpplugin"),new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH,1,20*20);

        getServer().addRecipe(furnaceRecipe);
        getServer().addRecipe(leatherSmoker);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SmpPlugin getPlugin() {
        return plugin;
    }

}
