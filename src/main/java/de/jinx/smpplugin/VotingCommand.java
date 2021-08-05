package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VotingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ConfigManager cfM = new ConfigManager();

        SmpPlugin.getPlugin().reloadConfig(cfM.getVotingCfg(),cfM.getVotingFile());

        if(label.equalsIgnoreCase("vote")) {

            if(args.length >= 1) {

                if(cfM.getVotingCfg().getBoolean("HasVoted."+sender.getName()) == false) {

                    if (cfM.getVotingCfg().get("Voting." + args[0]) == null) {
                        cfM.getVotingCfg().set("Voting." + args[0], 1);

                    } else {
                        int votes = cfM.getVotingCfg().getInt("Voting." + args[0]);
                        votes++;
                        cfM.getVotingCfg().set("Voting." + args[0], votes);
                    }

                    cfM.getVotingCfg().set("HasVoted." + sender.getName(), true);

                    cfM.saveVoting();

                    sender.sendMessage(SmpPlugin.PREFIX+"You have successfully voted!");
                }else
                    sender.sendMessage(SmpPlugin.PREFIX+"You have already voted!");
            }else{
                sender.sendMessage(SmpPlugin.PREFIX+"/voting {name} | The Name can only be one word! \nRacist etc. Names are getting banned! (The User too)");
            }
        }else if(label.equalsIgnoreCase("votelist")){
            ConfigurationSection cfs =  cfM.getVotingCfg().getConfigurationSection("Voting");
            sender.sendMessage(SmpPlugin.PREFIX+"These are the current following Votes: ");
            for (String key : cfs.getKeys(false)) {
                sender.sendMessage(key);
            }
        }else if(label.equalsIgnoreCase("broadcast")){
            String text = "";

            for (int i = 0; i < args.length; i++) {

                text += args[i].replace("&","§") + " ";
            }
            Bukkit.broadcastMessage("§4 SERVER >> " + text);

        }
        return false;
    }
}