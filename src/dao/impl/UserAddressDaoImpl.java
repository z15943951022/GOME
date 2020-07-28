package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.UserAddressDao;
import entity.UserAddress;

public class UserAddressDaoImpl extends BaseDao implements UserAddressDao{
	
	
	public UserAddressDaoImpl(){};
	/**
	 * 构造连接
	 * @param connection
	 */
	public UserAddressDaoImpl(Connection connection){
		super(connection);
	}

	/**
	 * 添加地址
	 * @return
	 * @throws SQLException 
	 */
	public int addAddress(UserAddress address) throws SQLException{
		int i=-1;
		String sql="INSERT INTO useraddress(consignee,userId,addressDetail,phone,defaultBoolean)VALUES(?,?,?,?,?);";
		Object[] obj={address.getConsignee(),address.getUserId(),address.getAddressDetail(),address.getPhone(),address.getDefaultBoolean()};
		i=executeUpdate(sql, obj);
		return i;
	}
	
	/**
	 * 根据用户ID查询
	 * @param userId
	 * @return
	 */
	public List<UserAddress> findByUserId(long userId){
		List<UserAddress> address=new ArrayList<UserAddress>();
		String sql="SELECT addressId,userId,consignee,addressDetail,phone,defaultBoolean FROM userAddress WHERE userId=?";
		Object[] obj={userId};
		try {
			rs=executeQuery(sql, obj);
			UserAddress userAddress=null;
			while(rs.next()){
				userAddress=new UserAddress();
				userAddress.setAddressId(rs.getLong(1));
				userAddress.setUserId(rs.getLong(2));
				userAddress.setConsignee(rs.getString(3));
				userAddress.setAddressDetail(rs.getString(4));
				userAddress.setPhone(rs.getString(5));
				userAddress.setDefaultBoolean(rs.getInt(6));
				address.add(userAddress);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{
			GetConnection.close(rs,ps);
		}
		return address;
	}
	
	/**
	 * 根据地址id删除一条订单
	 * @throws SQLException 
	 */
	public int deleteById(long addressId) throws SQLException{
		int i=-1;
		String sql="DELETE FROM useraddress WHERE addressId=?";
		Object[] obj={addressId};
		i=executeUpdate(sql, obj);
		return i;
	}
	
	/**
	 * 根据地址id查询地址
	 */
	public UserAddress findAddressById(Long addressId){
		UserAddress userAddress=null;
		String sql="SELECT addressId,userId,consignee,addressDetail,phone,defaultBoolean FROM userAddress WHERE addressId=?";
		Object[]obj={addressId};
		try {
			rs=executeQuery(sql, obj);
			if(rs.next()){
				userAddress=new UserAddress();
				userAddress.setAddressId(rs.getLong(1));
				userAddress.setUserId(rs.getLong(2));
				userAddress.setConsignee(rs.getString(3));
				userAddress.setAddressDetail(rs.getString(4));
				userAddress.setPhone(rs.getString(5));
				userAddress.setDefaultBoolean(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs,ps);
		}
	
		return userAddress;
	}
	
	/**
	 * 根据地址id修改地址
	 * @throws SQLException 
	 */
	public int updateAddressById(UserAddress userAddress) throws SQLException{
		int i=-1;
		String sql="UPDATE useraddress SET consignee =?,addressDetail=?,phone=?,defaultBoolean=? WHERE addressId=?";
		Object[] obj={userAddress.getConsignee(),userAddress.getAddressDetail(),userAddress.getPhone(),userAddress.getDefaultBoolean(),userAddress.getAddressId()};
		i=executeUpdate(sql, obj);
		return i;
	}
	
    public List<UserAddress> findByUserIdAndDefaultBoolean(long userId,int defaultBoolean) {
        List<UserAddress> listUserAddress=new ArrayList<UserAddress>();
        String sql = "SELECT consignee,addressDetail,phone FROM useraddress WHERE userId=? AND defaultBoolean=?";
        Object []obj = {userId,defaultBoolean};
        try {
                  rs = this.executeQuery(sql, obj);
                  UserAddress userAddress = null;
                  while(rs.next())
                  {
                            userAddress =  new UserAddress();
                            userAddress.setConsignee(rs.getString("consignee"));
                            userAddress.setAddressDetail(rs.getString("addressDetail"));
                            userAddress.setPhone(rs.getString("phone"));
                            listUserAddress.add(userAddress);
                  }
        } catch (SQLException e) {
                  e.printStackTrace();
        }finally{
                  GetConnection.close(rs,ps);
        }
        return listUserAddress;
}
}
