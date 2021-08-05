package de.jinx.smpplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("broadcast")){
            String text = "";

            for (int i = 0; i < args.length; i++) {

                text += args[i].replace("&","§") + " ";
            }
            Bukkit.broadcastMessage("§4 SERVER >> " + text);

        }else if(label.equalsIgnoreCase("rename")){
            if(player.getLevel() >= 1) {
                if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                    String text = formateArgs(args);

                    ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();

                    player.setLevel(player.getLevel() - 1);

                    itemMeta.setDisplayName(text);

                    player.getInventory().getItemInMainHand().setItemMeta(itemMeta);
                }else
                    player.sendMessage(SmpPlugin.PREFIX+"You dont have an Item your Main Hand!");
            }else
                player.sendMessage(SmpPlugin.PREFIX +"§cYou dont have enough levels to rename!");
        }
        return false;
    }

    public String formateArgs(String[] argsToFormate){
        String text = "";
        for (int i = 0; i < argsToFormate.length; i++) {

            text += argsToFormate[i].replace("&","§") + " ";
        }
        return text;
    }
}