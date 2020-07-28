package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserAddressDao;
import dao.impl.UserAddressDaoImpl;
import entity.UserAddress;
import service.UserAddressService;
import util.GetConnection;

public class UserAddressServiceImpl implements UserAddressService{

	private UserAddressDao userAddressDao;
	
	/**
	 * 添加用户地址
	 */
	public int addAddress(UserAddress address) {
		Connection connection=null;
		int i=-1;
		try {
			connection = GetConnection.getConnection();
			userAddressDao=new UserAddressDaoImpl(connection);
			i=userAddressDao.addAddress(address);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return i;
	}

	
	/**
	 * 查询用户地址
	 */
	public List<UserAddress> findByUserId(long userId) {
		Connection connection =null;
		List<UserAddress> list=null;
			try {
				connection=GetConnection.getConnection();
				userAddressDao=new UserAddressDaoImpl(connection);
				list=userAddressDao.findByUserId(userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				GetConnection.close(connection);
			}
		return list;
	}


	/**
	 * 删除一条地址
	 */
	public int deleteById(long addressId) {
		int i=-1;
		Connection connection =null;
		try {
			connection=GetConnection.getConnection();
			userAddressDao=new UserAddressDaoImpl(connection);
			i=userAddressDao.deleteById(addressId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return i;
	}


	/**
	 * 根据地址id查询地址
	 */
	public UserAddress findAddressById(Long addressId) {
		Connection connection =null;
		UserAddress userAddress=null;
		try {
			connection=GetConnection.getConnection();
			userAddressDao=new UserAddressDaoImpl(connection);
			userAddress=userAddressDao.findAddressById(addressId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return userAddress;
	}

	/**
	 * 
	 * 根据地址Id修改地址
	 * @param userAddress
	 */
	public int updateAddressById(UserAddress userAddress) {
		Connection connection =null;
		int i=-1;
		try {
			connection=GetConnection.getConnection();
			userAddressDao=new UserAddressDaoImpl(connection);
			i=userAddressDao.updateAddressById(userAddress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
    public List<UserAddress> findByUserIdAndDefaultBoolean(long userId,int defaultBoolean) {
        Connection connection =null;
        List<UserAddress> listUserIdAndDefaultBoolean= new ArrayList<UserAddress>();
        try {
                  connection = GetConnection.getConnection();
                  userAddressDao=new UserAddressDaoImpl(connection);
                  listUserIdAndDefaultBoolean = userAddressDao.findByUserIdAndDefaultBoolean(userId, defaultBoolean);
        } catch (SQLException e) {
                  e.printStackTrace();
        }finally{
                  GetConnection.close(connection);
        }
        return listUserIdAndDefaultBoolean;
}

}
