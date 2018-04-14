package jmobs.mobs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import jmobs.sql.MobAction;

public class MobData {
	
	public void createMobs(Player player,String ID) {
		
		String uuid = UUID.nameUUIDFromBytes(ID.getBytes()).toString();
		
		if(MobAction.getMobsExist(uuid) == true) {
			
			player.sendMessage("硂唉┣竒: " + ID);
			return;
			
		}
		
		player.sendMessage("承硑┣Θ!");
		
		MobAction.createMobs(uuid);
		
	}
	
	public void setSpawnMode(Player player,String ID,String type) {
		
		String uuid = UUID.nameUUIDFromBytes(ID.getBytes()).toString();
		
		List<String> list = new ArrayList<String>();
		
		list.add("local");
		list.add("world");
		
		if(!list.contains(type.toLowerCase())) {
			
			player.sendMessage("тぃ硂ネΘ家Α: " + type);
			player.sendMessage("local -> 跋办家Α");
			player.sendMessage("world -> 家Α");
			return;
			
		}
		
		MobAction.setSpawnMode(uuid, type);
		
		player.sendMessage("ネΘ家Α砞﹚ЧΘ!");
		
	}

}
