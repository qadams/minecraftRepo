package me.quinn.healerplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override 
	public void onEnable() {
		getCommand("hbook").setExecutor(new CommandHwand());
		Listener myEvtHnd = (Listener) new CommandHwand();
        Bukkit.getPluginManager().registerEvents( myEvtHnd, this );
	}
}