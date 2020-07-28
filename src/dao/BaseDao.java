package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.GetConnection;

public class BaseDao {

	protected Connection connection;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public BaseDao(){};
	/**
	 *  构造连接
	 * @param connection
	 */
	public BaseDao(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * 增删改
	 * @param sql
	 * @param obj
	 * @return int
	 * @throws SQLException 
	 */
	protected int executeUpdate(String sql,Object[]obj) throws SQLException{
		int rel=-1;
		if(null!=connection){
			try {
				ps=connection.prepareStatement(sql);
				if(null!=obj){
					for(int j=0;j<obj.length;j++){
						ps.setObject(j+1, obj[j]);
					}
				}
				rel=ps.executeUpdate();
			} catch (SQLException e) {
				throw e;
			}finally{
				GetConnection.close(ps);
			}
		}
		return rel;
	}
	
	/**
	 *查询 
	 * @param sql
	 * @param obj
	 * @return
	 * @throws SQLException 
	 */
	protected ResultSet executeQuery(String sql,Object[]obj) throws SQLException{
		if(null!=connection){
			ps=connection.prepareStatement(sql);
			if(null!=obj){
				for(int j=0;j<obj.length;j++){
					ps.setObject(j+1, obj[j]);
				}
			}
			rs=ps.executeQuery();
		}
		return rs;
	}
	
	
	
}
