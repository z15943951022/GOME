package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BuyCarDao;
import dao.ProductDao;
import dao.impl.BuyCarImpl;
import dao.impl.ProductDaoImpl;
import entity.BuyCar;
import service.BuyCarService;
import util.GetConnection;

public class BuyCarSerivceImpl implements BuyCarService {
	Connection connection=null;
	BuyCarDao buycardao=null;
	ProductDao productDao=null;
	
	
	public int addByUserId(BuyCar buycar) {
		 	int rel=-1;
		try {
			connection=GetConnection.getConnection();
			buycardao=new BuyCarImpl(connection);
			productDao=new ProductDaoImpl(connection);
			buycar.setSellingPrice(productDao.findProductById(buycar.getProductId()).getSellingPrice());
			buycar.setBuyCarSum(buycar.getProductCount()*buycar.getSellingPrice());
			rel=buycardao.addByUserId(buycar);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return rel;
	}

	
	public int deleteByBuyCarId(long buyCarId) {
			int rel=-1;
			try {
				connection=GetConnection.getConnection();
				buycardao=new BuyCarImpl(connection);
				rel=buycardao.deleteByBuyCarId(buyCarId);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				GetConnection.close(connection);
			}
			
		return rel;
	}

	
	public int UpdateByBuyCarId(BuyCar buycar) {
		int rel=-1;
		try {
			connection=GetConnection.getConnection();
			buycardao=new BuyCarImpl(connection);
			productDao=new ProductDaoImpl(connection);
			
			long productId=buycardao.findBuyCarById(buycar.getId()).getProductId();
			buycar.setProductId(productId);
			/*商品库存*/
			int pCS=productDao.findProductById(buycar.getProductId()).getPCS();
			buycar.setSellingPrice(productDao.findProductById(buycar.getProductId()).getSellingPrice());
			buycar.setBuyCarSum(buycar.getProductCount()*buycar.getSellingPrice());
			if(pCS>=buycar.getProductCount()&&buycar.getProductCount()!=0){
				rel=buycardao.UpdateByBuyCarId(buycar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return rel;
	}

	
	public List<BuyCar> selectByUserId(long userId) {
		List<BuyCar> buyList=new ArrayList<BuyCar>();
		try {
			connection=GetConnection.getConnection();
			buycardao=new BuyCarImpl(connection);
			buyList=buycardao.selectByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		
		return buyList;
	}


	@Override
	public double getTotalByUserId(long userId) {
		double total=0;
		try {
			connection=GetConnection.getConnection();
			buycardao=new BuyCarImpl(connection);
			total=buycardao.getTotalByUserId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return total;
	}


	@Override
	public BuyCar findBuyCarById(long buyCarId) {
		BuyCar buy=new BuyCar();
		try {
			connection=GetConnection.getConnection();
			buycardao=new BuyCarImpl(connection);
			buy=buycardao.findBuyCarById(buyCarId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return buy;
	}


	@Override
	public BuyCar equals(BuyCar buyCar) {
		BuyCar buy=null;
		try {
			connection=GetConnection.getConnection();
			buycardao=new BuyCarImpl(connection);
			
			buy=buycardao.equals(buyCar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buy;
	}

}
