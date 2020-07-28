package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDetailDao;
import dao.impl.OrderDetailDaoImpl;
import entity.Order;
import entity.OrderDetail;
import service.OrderDetailService;
import util.GetConnection;

public class OrderDetailServiceImpl  implements OrderDetailService{
	OrderDetailDao orderDao=null;
	Connection connection=null;
	
	/**
	 * 查询所有订单分页
	 */
	public List<OrderDetail> findAllByOrderId(String orderId) {
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		try {
			connection=GetConnection.getConnection();
			orderDao=new OrderDetailDaoImpl(connection);
			list=orderDao.findAllByOrderId(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		
		return list;
	}

	public int deleteByOrderDetailId(OrderDetail orderDetailId) {
		return 0;
	}

	public int addByOrderId() {
		return 0;
	}

	public int updateByOrderId(Order orderId) {
		return 0;
	}

}
