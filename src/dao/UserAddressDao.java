package dao;

import java.sql.SQLException;
import java.util.List;

import entity.UserAddress;

public interface UserAddressDao {

	/**
	 * 添加一条地址
	 * @param address
	 * @return
	 * @throws SQLException 
	 */
	int addAddress(UserAddress address) throws SQLException;
	
	/**
	 *根据用户 
	 * @param userId
	 * @return
	 */
	List<UserAddress> findByUserId(long userId);
	
	/**
	 * 根据地址id删除
	 * @param addressId
	 * @throws SQLException 
	 */
	int deleteById(long addressId) throws SQLException;
	
	/**
	 * 根据地址Id查询地址
	 * @param addressId
	 * @return
	 */
	UserAddress findAddressById(Long addressId);
	
	/**
	 * 
	 * 根据地址Id修改地址
	 * @param userAddress
	 * @throws SQLException 
	 */
	int updateAddressById(UserAddress userAddress) throws SQLException;
	
	/**
	 * 根据用户id和默认是1的，查询收货人、详细地址、手机号
	 */
	List<UserAddress> findByUserIdAndDefaultBoolean(long userId,int defaultBoolean);
}
