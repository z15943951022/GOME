package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {

	private static String  driver;
	private static String  url;
	private static String userName;
	private static String passWord;
	static{
		init();
	}
	public static void init(){
		//1.创建属性类实体
		Properties properties =new Properties();
		//2.加载配置文件生产流
		InputStream is=GetConnection.class.getClassLoader().getResourceAsStream("dataBase.properties");
		//3.将流加载到属性类列表中
		try {
			properties.load(is);
			//4.根据键读取配置信息
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			userName=properties.getProperty("userName");
			passWord=properties.getProperty("passWord");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection connection=null;
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,userName,passWord);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	/**
	 * 释放资源
	 * @param mages
	 * @return
	 */
	public static boolean close(AutoCloseable...mages){
		for(AutoCloseable mage:mages){
			if(null!=mage){
				try {
					mage.close();
				} catch (Exception e) {
					return false;
				}
			}
		}
		return true;
	}
	
}
