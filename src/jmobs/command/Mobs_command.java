package jmobs.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jmobs.main.Main;
import jmobs.mobs.MobData;

public class Mobs_command implements CommandExecutor{

	Main plugin = Main.plugin;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) return false;
		
		Player player = (Player)sender;
		
		MobData data = new MobData();
		
		if(args.length < 1) {
			
			help(sender);
			return false;
			
		}
		
		switch(args[1]) {
		
		case "create":
			
			data.createMobs(player, args[0]);
			break;
			
		case "spawntype":
			
			data.setSpawnMode(player, args[0], args[2]);
			break;
			
		default:
			
			player.sendMessage("�䤣����O: " + args[0]);
		
		}
		
		return false;
	}
	
	public void help(CommandSender sender) {
		
		sender.sendMessage("======================================");
		sender.sendMessage("JMobs ���O���n");
		sender.sendMessage("/jmobs <ID> create �гy�@���Ǫ�");
		sender.sendMessage("/jitem <ID> spawntype <local/world> �]�w�ͦ��Ҧ�");
		sender.sendMessage("======================================");
		
	}

}
