package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class SmpPlugin extends JavaPlugin {

    private static SmpPlugin plugin;
    public static String PREFIX = "§5SMP §6Name >> ";

    @Override
    public void onEnable() {
        plugin = this;


        System.out.println("SMP Plugin has loaded!");
        PluginManager pl = Bukkit.getPluginManager();

        pl.registerEvents(new Listeners(),this);

        setup();
        this.getCommand("vote").setExecutor(new VotingCommand());
        this.getCommand("votelist").setExecutor(new VotingCommand());
        this.getCommand("broadcast").setExecutor(new VotingCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setup() {
        FileConfiguration config;
        File configFile;


        if (!this.getPlugin().getDataFolder().exists()) {
            this.getPlugin().getDataFolder().mkdir();
        }

        configFile = new File(this.getPlugin().getDataFolder() + File.separator + "voting.yml");

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                config = YamlConfiguration.loadConfiguration(configFile);
                config.set("Voting","Ultimate-SMP");

                try {
                    config.save(configFile);
                } catch (IOException e) {
                    Bukkit.getServer().getConsoleSender().sendMessage(this.PREFIX + "§aCould not save" + configFile.getName() + ".");
                }

            } catch (Exception e) {
                Bukkit.getServer().getConsoleSender().sendMessage(this.PREFIX + "§cCould not create the settings.yml file");
            }
        }

        Bukkit.getServer().getConsoleSender().sendMessage(this.PREFIX + "§aThe voting.yml file has been created");
    }

    public void reloadConfig(FileConfiguration cfg, File cfgFile) {
        cfg = YamlConfiguration.loadConfiguration(cfgFile);
    }

    public static SmpPlugin getPlugin() {
        return plugin;
    }

}
