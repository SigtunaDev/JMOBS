package jmobs.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MobAction {
	
	private static Connection conn = SQL.conn;
	
	public static void createMobs(String uuid) {
		
		String command = "";
		
		command = String.format("INSERT INTO `mobs_info`(Mobs_UUID,Mobs_name,Mobs_type,Mobs_random,Mobs_health,Mobs_spawn_x,Mobs_spawn_z) VALUES ('%s','','','',0,0,0)", uuid);
		
		try {
			
			PreparedStatement state = conn.prepareStatement(command);
			
			state.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		
	}
	
	public static boolean getMobsExist(String uuid) {
		
		String command = "";
		
		command = String.format("SELECT * FROM `mobs_info` where Mobs_UUID = '%s'",uuid);
		
		try {
			
			PreparedStatement state = conn.prepareStatement(command);
			
			ResultSet result = state.executeQuery();
			
			boolean find = result.next();
			
			return find;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;

		}
		
	}
	
	public static void setSpawnMode(String uuid,String type) {
		
		String command = "";
		
		command = String.format("update `mobs_info` set Mobs_type = '%s' where Mobs_UUID = '%s'", type,uuid);
		
		try {
			
			PreparedStatement state = conn.prepareStatement(command);
			
			state.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();

		}
		
	}

}
