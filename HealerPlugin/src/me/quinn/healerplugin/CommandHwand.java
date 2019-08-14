package me.quinn.healerplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandHwand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 0) {
				spawnHealingBook(player);
			} else {
				player.sendMessage(ChatColor.RED + "Invalid Number Of Arguments. Try /hbook");
			}
		}
		return true;
	}
	
	public void spawnHealingBook(Player player) {
	
		// Add a hard-coded custom item for now
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta im = item.getItemMeta();
		String displayName = "Healing Book";
		List<String> lores = new ArrayList<String>();
		im.setDisplayName(ChatColor.BOLD.toString() + ChatColor.DARK_RED.toString() + "" + displayName);
		lores.add(ChatColor.GREEN.toString() + "From the deep and dark crevices");
		lores.add(ChatColor.GREEN.toString() + "of Quinn's anus.");
		lores.add(ChatColor.GREEN.toString() + "Nick and Andrew are icky.");
		lores.add(ChatColor.AQUA.toString() + "Love you Trevor!");
		im.setLore(lores);
		item.setItemMeta(im);	
		
		boolean playerHasItem = player.getInventory().contains(item);
		int hasAvailableSlot = player.getInventory().firstEmpty();
		
		// If the item is not in your inventory and your inventory has an available slot
		if(((!playerHasItem) && hasAvailableSlot != -1)) {
			player.sendMessage(ChatColor.AQUA + "Spawning your healing book!");
			player.getInventory().addItem(item);
			player.updateInventory();
		} else if(playerHasItem && hasAvailableSlot == -1) {
			player.sendMessage(ChatColor.RED + "Player has the healing book already and inventory is full!");			
		} else if(playerHasItem) {
			player.sendMessage(ChatColor.RED + "Player has the healing book already!");
		} else if(hasAvailableSlot == -1) {
			player.sendMessage(ChatColor.RED + "Player inventory is full! Cannot give healing book!");
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerClick(PlayerInteractEvent event){
	    Player player = event.getPlayer();
	    Action action = event.getAction();
	    ItemStack item = event.getItem();
	    String displayName = ChatColor.BOLD.toString() + ChatColor.DARK_RED.toString() + "Healing Book";
	    player.sendMessage("Item: " + displayName);
	     if ( action.equals( Action.RIGHT_CLICK_AIR ) || action.equals( Action.RIGHT_CLICK_BLOCK ) ) {
	         if ( item != null && item.getItemMeta().getDisplayName() == displayName ) {
	             player.sendMessage( "You have right clicked the healing book!" );
	         } 
	     }
	}
}
