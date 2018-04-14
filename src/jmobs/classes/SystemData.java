package jmobs.classes;


import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import jmobs.main.Main;

public class SystemData {
	
	static Main plugin = Main.plugin;
	
	public static void System(File file,FileConfiguration fc) {
		
		fc.set("SQL.host", "");
		fc.set("SQL.user", "");
		fc.set("SQL.password", "");
		
		plugin.reload();
		
	}

}
