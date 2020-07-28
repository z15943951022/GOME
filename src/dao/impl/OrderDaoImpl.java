package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.OrderDao;
import entity.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao{
          public OrderDaoImpl(Connection connection) {
                    super(connection);
          }
          
      	
	@Override
	public List<Order> findAllByUesrId(long userId) {
		List<Order> listOrder = new ArrayList<Order>();
		String sql = "SELECT orderId,userId,total,consignee,addressDetail,phone,creatDate FROM `order` where userId = ?";
		Object[] obj = { userId };
		Order order = null;
		try {
			rs = this.executeQuery(sql, obj);
			while (rs.next()) {
				order = new Order();
				order.setOrderId(rs.getString("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setTotal(rs.getDouble("total"));
				order.setConsignee(rs.getString("consignee"));
				order.setAddressDetail(rs.getString("addressDetail"));
				order.setPhone(rs.getString("phone"));
				order.setCreatDate(rs.getTimestamp("creatDate"));
				listOrder.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GetConnection.close(rs, ps);
		}
		return listOrder;
	}

      @Override
      public int addOrderByUserId(Order order) throws SQLException {
            int rel = -1;
            String sql = "INSERT INTO `order`(orderId,userId,total,consignee,addressDetail,phone,creatDate)VALUES(?,?,?,?,?,?,now())";
            Object []obj = {order.getOrderId(),order.getUserId(),order.getTotal(),order.getConsignee(),order.getAddressDetail(),order.getPhone()};
            rel =  this.executeUpdate(sql, obj);
            return rel;
      }

      public int deleteOrderByOrderId(String orderId) throws SQLException {
			int i=-1;
			String sql="DELETE FROM `order` WHERE orderId=?";
			Object[]obj={orderId};
			i=executeUpdate(sql, obj);
			return i;
		}

 
}
