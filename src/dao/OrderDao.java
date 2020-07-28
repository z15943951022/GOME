package dao;
/**
 * 订单表
 * @author Administrator
 *
 */
import java.sql.SQLException;
import java.util.List;

import entity.Order;

public interface OrderDao {
          /**
           * 根据用户id查询全部订单
           */
		public List<Order> findAllByUesrId(long userId);
          
          /**
           * 增加一条订单信息
         * @throws SQLException 
           * 
           */
        public int addOrderByUserId(Order order) throws SQLException;
        /**
         * 根据订单Id删除订单
         */
        public int deleteOrderByOrderId(String orderId) throws SQLException;
        /**
         * 根据订单Id修改订单状态
         */
}
