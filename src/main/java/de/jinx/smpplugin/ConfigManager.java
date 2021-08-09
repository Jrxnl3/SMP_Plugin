package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {


    File endFile;
    FileConfiguration endCfg;


    public ConfigManager() {
        endFile = new File(SmpPlugin.getPlugin().getDataFolder() + File.separator + "end.yml");
        endCfg = YamlConfiguration.loadConfiguration(endFile);
    }

    public File getEndFile() {
        return endFile;
    }

    public FileConfiguration getEndCfg() {
        return endCfg;
    }

    public void reload(){
        endFile = new File(SmpPlugin.getPlugin().getDataFolder() + File.separator + "end.yml");
        endCfg = YamlConfiguration.loadConfiguration(endFile);
    }

    public void saveEnd(){
        try {
            endCfg.save(endFile);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(SmpPlugin.PREFIX + "§aCould not save" + endFile.getName() + ".");
        }
    }
}
