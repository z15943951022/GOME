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
		 * ����userId�õ����ﳵ�ܼƼ�Ǯ
		 */
		double getTotalByUserId(long userId);
		/**
		 * ���ݹ��ﳵid�õ����ﳵ����
		 */
		BuyCar findBuyCarById(long buyCarId);
		/**
		 * ���ݹ��ﳵ�����ж��Ƿ�����ͬ������ͬ���ع��ﳵ����
		 */
		BuyCar equals(BuyCar buyCar);

}
