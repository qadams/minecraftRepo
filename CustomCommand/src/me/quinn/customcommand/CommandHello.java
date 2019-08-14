package me.quinn.customcommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHello implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 1) {
				switch(args[0]) {
				case "dolphin":
					player.sendMessage(ChatColor.BLUE + "Hello " + args[0]);
					break;
				case "bear":
					player.sendMessage(ChatColor.BLUE + "Hello " + args[0]);
					break;
				case "dinosaur":
					player.sendMessage(ChatColor.BLUE + "Hello " + args[0]);
					break;
				default:
					player.sendMessage(ChatColor.DARK_RED + "" + args[0] + " is an invalid argument!");
					break;
				}
			} else {
				player.sendMessage(ChatColor.BLUE + "Hello, " + player.getName());
			}
		}
		return true;
	}

}
