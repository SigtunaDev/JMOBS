package jmobs.main;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import jmobs.classes.MessageManager;
import jmobs.classes.SystemData;
import jmobs.command.Mobs_command;
import jmobs.sql.SQL;
import jmobs.sql.TableCheck;


public class Main extends JavaPlugin{
	
	public static Main plugin;
	
	public File sys;
	public FileConfiguration syc;
	
	public void onEnable() {
		
		plugin = this;
		
		sys = new File(this.getDataFolder() + "/Setting.yml");
		syc = YamlConfiguration.loadConfiguration(sys);
		
		getLogger().info("JMobs working! version: 0.0.1");
		
		checkFile();
		
		SQL.connection();
		
		checkTable();
		
		this.getCommand("jmobs").setExecutor(new Mobs_command());
		
	}
	
	public void checkFile() {
		
		if(!sys.exists()) {
			
			SystemData.System(sys, syc);
			getLogger().info(MessageManager.INFO_SystemDataMake);
			
		}
		
	}
	
	public void checkTable() {
		
		if(TableCheck.getTableExist("mobs_info") == false) {
			
			TableCheck.createMobsInfo();
			
			getLogger().info("找不到TABLE: mobs_info，已自動創建。");
			
		}
		
	}
	
	public void reload() {
		
		try {
			
			syc.save(sys);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}

}
