package me.quinn.joinquitmessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(p.hasPlayedBefore())
			e.setJoinMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " joined");
		else
			e.setJoinMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + ", welcome to Quinn's server!");
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.YELLOW + p.getName() + ChatColor.GREEN + " has left the server!");
	}
	
}
