package me.quinn.customcommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTps implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			player.teleport(player.getWorld().getSpawnLocation());
			player.sendMessage(ChatColor.BLUE + "You've been teleported to the spawn!");
		}
		return true;
	}

}
