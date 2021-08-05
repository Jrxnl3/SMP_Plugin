package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equalsIgnoreCase("broadcast")){
            String text = "";

            for (int i = 0; i < args.length; i++) {

                text += args[i].replace("&","§") + " ";
            }
            Bukkit.broadcastMessage("§4 SERVER >> " + text);

        }
        return false;
    }
}