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
			
			player.sendMessage("�o���Ǫ��w�g�s�b: " + ID);
			return;
			
		}
		
		player.sendMessage("�гy�Ǫ����\!");
		
		MobAction.createMobs(uuid);
		
	}
	
	public void setSpawnMode(Player player,String ID,String type) {
		
		String uuid = UUID.nameUUIDFromBytes(ID.getBytes()).toString();
		
		List<String> list = new ArrayList<String>();
		
		list.add("local");
		list.add("world");
		
		if(!list.contains(type.toLowerCase())) {
			
			player.sendMessage("�䤣��o�ӥͦ��Ҧ�: " + type);
			player.sendMessage("local -> �ϰ�Ҧ�");
			player.sendMessage("world -> �@�ɼҦ�");
			return;
			
		}
		
		MobAction.setSpawnMode(uuid, type);
		
		player.sendMessage("�ͦ��Ҧ��]�w����!");
		
	}

}
