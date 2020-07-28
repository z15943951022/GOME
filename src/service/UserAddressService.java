package service;

import java.util.List;

import entity.UserAddress;

public interface UserAddressService {

	/**
	 * 添加用户地址
	 * @param address
	 * @return
	 */
	int addAddress(UserAddress address);
	
	/**
	 * 查询用户地址
	 * @param userId
	 * @return
	 */
	List<UserAddress> findByUserId(long userId);
	
	/**
	 * 根据地址ID删除
	 * @param addressId
	 * @return
	 */
	int deleteById(long addressId);
	
	/**
	 * 根据地址ID查询地址
	 * @param addressId
	 * @return
	 */
	UserAddress findAddressById(Long addressId);
	
	/**
	 * 
	 * 根据地址Id修改地址
	 * @param userAddress
	 */
	int updateAddressById(UserAddress userAddress);
	


		 /**
           * 根据用户id和默认是1的，查询收货人、详细地址、手机号
           */
          List<UserAddress> findByUserIdAndDefaultBoolean(long userId,int defaultBoolean);
}
