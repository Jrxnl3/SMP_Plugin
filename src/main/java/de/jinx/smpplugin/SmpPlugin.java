package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SmpPlugin extends JavaPlugin {

    private static SmpPlugin plugin;
    public static String PREFIX = "§2SM§aPain§6 >> §r";

    ConfigManager cfm;

    @Override
    public void onEnable() {
        plugin = this;


        PluginManager pl = Bukkit.getPluginManager();

        pl.registerEvents(new Listeners(),this);

        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: WHAT HAVE YOU DONE??");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: WHY DID YOU §cKILLED §6THE PROTECTOR OF THE OVERWORLD???");
        Listeners.text.add("§4§lEvil Spirits rise from the §5§lEnd§4§l into the §a§lOverworld.");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: Oh no, those §4§lEvil Spirits §6will cause tremendous amount of §4chaos §6and §4damage§6.");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: What am I seeing through this telescope?");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: Wait, is this a?");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: ...");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6:§4 AN ASTEROID??");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: GO and build me a §bTower§6 so I can move into your Town!");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: And help you destroy this §4asteroid§6!");
        Listeners.text.add("§6[§5§kHiddenNPC§6] §r§6: I may have the §aTools§6 needed.");


        this.getCommand("broadcast").setExecutor(new Commands());
        this.getCommand("rename").setExecutor(new Commands());
        this.getCommand("testString").setExecutor(new Commands());

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(NamespacedKey.fromString("smpplugin"),new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH,1,20*30);
        SmokingRecipe leatherSmoker = new SmokingRecipe(NamespacedKey.fromString("smpplugin"),new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH,1,20*20);

        ItemStack itemString = new ItemStack(Material.STRING);
        itemString.setAmount(3);
        
        ShapelessRecipe woolToString = new ShapelessRecipe(NamespacedKey.fromString("smpplugin"),itemString);

        woolToString.addIngredient(Material.WHITE_WOOL);

        getServer().addRecipe(furnaceRecipe);
        getServer().addRecipe(leatherSmoker);
        getServer().addRecipe(woolToString);

        cfm = setup();

        cfm.saveEnd();

        System.out.println("SMPain has loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SmpPlugin getPlugin() {
        return plugin;
    }

    public ConfigManager setup() {
        FileConfiguration endConfig;
        File endFile;

        if (!SmpPlugin.getPlugin().getDataFolder().exists()) {
            SmpPlugin.getPlugin().getDataFolder().mkdir();
        }


        endFile = new File(SmpPlugin.getPlugin().getDataFolder() + File.separator + "end.yml");
        if (!endFile.exists()) {
            try {
                endFile.createNewFile();
            } catch (Exception e) {
                Bukkit.getServer().getConsoleSender().sendMessage(SmpPlugin.PREFIX + "§cCould not create the end.yml file");
            }
        }
        endConfig = YamlConfiguration.loadConfiguration(endFile);
        endConfig.set("EndCompleted",false);
        return new ConfigManager();
    }

}
