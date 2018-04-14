package jmobs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jmobs.classes.MessageManager;
import jmobs.main.Main;


public class SQL {
	
	public static Connection conn;
	
	static Main plugin = Main.plugin;
	
	public synchronized static void connection(){
		
		try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String host = plugin.syc.getString("SQL.host");
		
		if(host == "") {
			
			System.out.println(MessageManager.ERROR_HostHadNotSet);
			return;
			
		}
		
		String password = plugin.syc.getString("SQL.password");
		
		String user = plugin.syc.getString("SQL.user");
		
		String dataSource = String.format("jdbc:mysql://%s:3306/jmobs?useUnicode=true&characterEncoding=utf-8",host);
		
		conn = DriverManager.getConnection(dataSource,user,password);
		
		System.out.println(MessageManager.INFO_ConnectSuccessful);
		
		}catch (ClassNotFoundException e) {
			
			System.out.println(MessageManager.ERROR_MissingSQLClass);
			
		} catch (SQLException e) {
			
			System.out.println(MessageManager.ERROR_WrongInfo);
		
		}
		
	}

}
