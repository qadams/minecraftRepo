package me.quinn.customcommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override 
	public void onEnable() {
		getCommand("hello").setExecutor(new CommandHello());
		getCommand("gotospawn").setExecutor(new CommandTps());
	}
}
