package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.xml.crypto.KeySelector.Purpose;

import service.OrderService;
import util.GetConnection;
import dao.BuyCarDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import dao.UserAddressDao;
import dao.impl.BuyCarImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderDetailDaoImpl;
import dao.impl.ProductDaoImpl;
import dao.impl.UserAddressDaoImpl;
import entity.BuyCar;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.UserAddress;

public class OrderServiceImpl implements OrderService{
	OrderDao orderDao=null;
	Connection connection=null;

	/**
	 * 查询订单
	 */
	public List<Order> findOrderByUserId(long userId) {
		List<Order> list=null;
		try {
			connection=GetConnection.getConnection();
			orderDao=new OrderDaoImpl(connection);
			list=orderDao.findAllByUesrId(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return list;
	}

	public int addOrderByUserId(Order order) {
		return 0;
	}
	
	/**
	 * 添加订单业务方法
	 * 
	 */
	public int addOrder(List<BuyCar> carList,long addressId,String orderId,long userId){
		int i=-1;
		try {
			connection=GetConnection.getConnection();
			connection.setAutoCommit(false);//关闭自动提交
			//添加订单
			orderDao=new OrderDaoImpl(connection);//订单
			OrderDetailDao detail=new OrderDetailDaoImpl(connection);//详单
			ProductDao product=new ProductDaoImpl(connection);//商品
			UserAddressDao addressDap=new UserAddressDaoImpl(connection);//用户地址
			BuyCarDao buyCarDao=new BuyCarImpl(connection);
			UserAddress address= addressDap.findAddressById(addressId);
			Order order=new Order();
			order.setOrderId(orderId);//订单ID
			order.setUserId(userId);//用户ID
			order.setConsignee(address.getConsignee());//收货人
			order.setAddressDetail(address.getAddressDetail());//收获详情
			order.setPhone(address.getPhone());//电话号
			double sum=0;
			//1.生成详单
			for(BuyCar car:carList){
				OrderDetail deta=new OrderDetail();
				sum+=car.getSellingPrice()*car.getProductCount();//计算总金额
				deta.setOrderId(orderId);//设置订单号
				deta.setStatusId(1);//设置待付款
				deta.setPicPath(car.getPicPath());//设置商品片
				deta.setProductId(car.getProductId());//设置商品ID
				deta.setTitle(car.getTitle());//设置商品属性
				deta.setProductAttr(car.getProductAttr());
				deta.setSellingPrice(car.getSellingPrice());//设置卖家
				deta.setProductCount(car.getProductCount());//设置数量
				deta.setOrderSum(car.getBuyCarSum());
				detail.addByOrderId(deta);//执行sql
				//2.修改商品库存
				Product p2=product.findProductById(car.getProductId());
				int PCS=p2.getPCS();
				product.updategetProductCountById(car.getProductId(),(PCS-car.getProductCount()));
				//3.删除购物车
				buyCarDao.deleteByBuyCarId(car.getId());
			}
			order.setTotal(sum);//订单总金额
			//4.添加订单
			orderDao.addOrderByUserId(order);//执行sql
			connection.commit();
			i=1;
		} catch (SQLException e) {
			i=-1;
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				connection.setAutoCommit(true);
				GetConnection.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	/**
	 * 根据订单Id删除订单
	 * 
	 */
	 public int deleteOrderBuyOrderId(String orderId){
		 int i=-1;
		 try {
			connection=GetConnection.getConnection();
			connection.setAutoCommit(false);//关闭自动提交
			OrderDao orderDao=new OrderDaoImpl(connection);//订单表
			OrderDetailDao orderDetail=new OrderDetailDaoImpl(connection);//订单详表
			List<OrderDetail> detailList=orderDetail.findAllByOrderId(orderId);//查询该订单详单
			boolean flag=true;
			for(OrderDetail od:detailList){
				if("1".equals(od.getStatusId())){//未付款
					flag=false;
				}else {
					flag=true;
				}
			}
			if(flag){//删除订单
				int j=orderDetail.deleteByOrderDetailId(orderId);
				int k=orderDao.deleteOrderByOrderId(orderId);
				if(j+k>0){
					i=1;
				}else{
					i=0;
				}
			}else{
				i=-1;
			}
			connection.commit();//提交事务
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();//回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				connection.setAutoCommit(true);
				GetConnection.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 return i;
	 }

	 /**
	  * 
	  * 根据订单Id取消订单
	  */
	public int cancelOrderByOrderId(String orderId){
		int i=-1;
		try {
			connection=GetConnection.getConnection();
			connection.setAutoCommit(false);//关闭自动提交
			OrderDao orderDao=new OrderDaoImpl(connection);//订单表
			OrderDetailDao orderDetail=new OrderDetailDaoImpl(connection);//订单详表
			ProductDao productDao=new ProductDaoImpl(connection);
			List<OrderDetail> detailList=orderDetail.findAllByOrderId(orderId);//查询该订单详单
			boolean flag=false;
			for(OrderDetail od:detailList){//无此订单
				if(!"1".equals(od.getStatusId())){
					flag=true;
				}
			}
			if(flag){
				int j=orderDao.deleteOrderByOrderId(orderId);//删除订单
				if(j>0){//判断订单是否正确
				for(OrderDetail od:detailList){//循环修改库存
					Product p=productDao.findProductById(od.getProductId());
					int PCS=p.getPCS()+od.getProductCount();
					productDao.updategetProductCountById(od.getProductId(),PCS);//归还数量
				}
				orderDetail.deleteByOrderDetailId(orderId);//删除详单
				i=1;
				}
			}else{
				i=-1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			GetConnection.close(connection);
		}
		return i;
		
	}


}
