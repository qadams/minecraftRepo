package me.quinn.healerplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override 
	public void onEnable() {
		getCommand("hbook").setExecutor(new CommandHwand());
	}
}