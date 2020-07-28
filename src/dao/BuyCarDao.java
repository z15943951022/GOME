package dao;

import java.sql.SQLException;
import java.util.List;

import entity.BuyCar;



/**
 * 
 * ?????????
 * @author ??????
 *
 */
public interface BuyCarDao {
	
		/**
		 * ?????id??????????
		 * @param buycar
		 * @return
		 * @throws SQLException 
		 */
		int addByUserId(BuyCar buycar) throws SQLException;
		/**
		 * ?????id?????????
		 * @param buycar
		 * @return
		 * @throws SQLException 
		 */
		 int deleteByBuyCarId(long buyCarId) throws SQLException;
		/**
		 * ?????id??????????
		 * @param buycar
		 * @return
		 * @throws SQLException 
		 */
		int UpdateByBuyCarId(BuyCar buycar) throws SQLException;
	
		/**
		 * ?????id??????????
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
		 * 根据购物车对象，判断是否有相同，有相同返回购物车对象
		 */
		BuyCar equals(BuyCar buyCar);

}
