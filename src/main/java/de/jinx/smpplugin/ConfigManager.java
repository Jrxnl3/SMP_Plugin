package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {


    File votingFile;
    FileConfiguration votingCfg;


    public ConfigManager() {
        votingFile = new File(SmpPlugin.getPlugin().getDataFolder() + File.separator + "voting.yml");
        votingCfg = YamlConfiguration.loadConfiguration(votingFile);
    }

    public File getVotingFile() {
        return votingFile;
    }

    public FileConfiguration getVotingCfg() {
        return votingCfg;
    }

    public void saveVoting(){
        try {
            votingCfg.save(votingFile);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(SmpPlugin.PREFIX + "§aCould not save" + votingFile.getName() + ".");
        }
    }
}
