package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.BuyCarDao;
import entity.BuyCar;



public class BuyCarImpl extends BaseDao implements BuyCarDao {
	//��
	public BuyCarImpl() {
		
	}
	public BuyCarImpl(Connection connection) {
		super(connection);
	}
	
	public int addByUserId(BuyCar buycar) throws SQLException {
		int rel=-1;
		String sql="insert into buycar(userId,productId,productCount,sellingPrice,buyCarSum) values(?,?,?,?,?)";
		Object[] obj={buycar.getUserId(),buycar.getProductId(),buycar.getProductCount(),buycar.getSellingPrice(),buycar.getBuyCarSum()};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}
	//ɾ
	@Override
	public int deleteByBuyCarId(long buyCarId) throws SQLException {
		int rel=-1;
		String sql="delete from BuyCar where id=?";
		Object[] obj={buyCarId};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}
	//��
	@Override
	public int UpdateByBuyCarId(BuyCar buycar) throws SQLException {
		int rel=-1;
		String sql="update BuyCar set productCount=?,buyCarSum=? WHERE id=?";
		Object[] obj = {buycar.getProductCount(),buycar.getBuyCarSum(),buycar.getId()};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}
	//��
	@Override
	public List<BuyCar> selectByUserId(long userId) {
		List<BuyCar> buyList=new ArrayList<BuyCar>();
		Object[] obj={userId};
		String sql="SELECT b.id,p.picPath,p.title,p.productAttr,b.productId,p.sellingPrice,b.productCount,b.buyCarSum FROM buycar b LEFT JOIN product p ON b.productId=p.productId WHERE userId=?";
		BuyCar buy=null;
		try {
			rs=this.executeQuery(sql, obj);
			while(rs.next()){
				buy=new BuyCar();
				buy.setId(rs.getLong("id"));
				buy.setPicPath(rs.getString("picPath"));
				buy.setTitle(rs.getString("title"));
				buy.setProductAttr(rs.getString("productAttr"));
				buy.setSellingPrice(rs.getDouble("sellingPrice"));
				buy.setProductId(rs.getLong("ProductId"));
				buy.setProductCount(rs.getInt("ProductCount"));
				buy.setBuyCarSum(rs.getDouble("buyCarSum"));
				buyList.add(buy);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs,ps);
		}
		return buyList;
	}
	
	
	public BuyCar findBuyCarById(long buyCarId) {
		BuyCar buycar=null;
		Object[] obj={buyCarId};
		String sql="SELECT id,p.picPath,p.title,p.productAttr,b.productId,p.sellingPrice,b.productCount,b.buyCarSum FROM buycar b LEFT JOIN product p ON b.productId=p.productId WHERE id=?";
		try {
			rs=this.executeQuery(sql, obj);
			if(rs.next()){
				buycar=new BuyCar();
				buycar.setId(rs.getLong("id"));
				buycar.setPicPath(rs.getString("picPath"));
				buycar.setTitle(rs.getString("title"));
				buycar.setProductAttr(rs.getString("productAttr"));
				buycar.setSellingPrice(rs.getDouble("sellingPrice"));
				buycar.setProductId(rs.getLong("ProductId"));
				buycar.setProductCount(rs.getInt("ProductCount"));
				buycar.setBuyCarSum(rs.getDouble("buyCarSum"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs,ps);
		}
		return buycar;
	}
	
	@Override
	public double getTotalByUserId(long userId) {
		double total=0;
		String sql="select SUM(buyCarSum) from buycar where userId=?";
		Object obj[]={userId};
		try {
			rs=this.executeQuery(sql, obj);
			if(rs.next()){
				total=rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return total;
	}
	@Override
	public BuyCar equals(BuyCar buyCar) {
		BuyCar buy=null;
		String sql="select * from buycar where userId=? and productId=?";
		Object obj[]={buyCar.getUserId(),buyCar.getProductId()};
		try {
			rs=this.executeQuery(sql, obj);
			if(rs.next()){
				buy=new BuyCar();
				buy.setId(rs.getLong("id"));
				buy.setUserId(rs.getLong("userId"));
				buy.setProductId(rs.getLong("ProductId"));
				buy.setProductCount(rs.getInt("ProductCount"));
				buy.setSellingPrice(rs.getDouble("sellingPrice"));
				buy.setBuyCarSum(rs.getDouble("buyCarSum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return buy;
	}
	
	
	
}

