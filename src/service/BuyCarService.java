package service;

import java.util.List;

import entity.BuyCar;

public interface BuyCarService {
	/**
	 * 由用户id增加一条信息
	 * @param buycar
	 * @return
	 */
	int addByUserId(BuyCar buycar);
	/**
	 * 由购物车id删除一条信息
	 * @param buycar
	 * @return
	 */
	int deleteByBuyCarId(long buyCarId);
	/**
	 * 由购物车id修改商品数量
	 * @param buycar
	 * @return
	 */
	int UpdateByBuyCarId(BuyCar buycar);

	/**
	 * 由用户id查询所有信息
	 * @param buycar
	 * @return
	 */
	List<BuyCar> selectByUserId(long userId);
	/**
	 * 根据userId得到购物车总计价钱
	 */
	double getTotalByUserId(long userId);
	/**
	 * 根据购物车id得到购物车对象
	 */
	BuyCar findBuyCarById(long buyCarId);
	/**
	 * 根据购物车对象，判断是否有相同
	 */
	BuyCar equals(BuyCar buyCar);
}
