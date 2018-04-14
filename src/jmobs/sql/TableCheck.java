package jmobs.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableCheck {

	private static Connection conn = SQL.conn;
	
	public static boolean getTableExist(String tableName) {
		
		String command = "";
		
		command = String.format("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'jmobs' AND TABLE_NAME = '%s' AND TABLE_TYPE = 'BASE TABLE'",tableName);

		try {
			
			PreparedStatement state = conn.prepareStatement(command);
			
			ResultSet result = state.executeQuery();
			
			boolean find = result.next();
			
			result.close();
			
			return find;
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
			return false;
			
		}
		
	}
	
	public static void createMobsInfo() {
		
		String command = "";
		
		command = String.format("CREATE TABLE mobs_info(Mobs_UUID text,Mobs_name text,Mobs_type text,Mobs_random text,Mobs_health int,Mobs_spawn_x int,Mobs_spawn_z int)", "");

		try {
			
			PreparedStatement state = conn.prepareStatement(command);
			state.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
