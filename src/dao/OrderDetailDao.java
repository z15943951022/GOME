package dao;
/**
 * 订单详情表
 * @author Administrator
 *
 */
import java.sql.SQLException;
import java.util.List;

import entity.Order;
import entity.OrderDetail;

public interface OrderDetailDao {
          
          /**
           * 根据订单号查询全部订单
           */  
          public List<OrderDetail> findAllByOrderId(String orderId);
          
          /**
           * 根据详单id删除详单
           * @throws SQLException 
           */ 
          public int deleteByOrderDetailId(String orederId) throws SQLException;
          
          /**
           * 增加一条订单详单
           * @throws SQLException 
           */
          public int addByOrderId(OrderDetail detail) throws SQLException;
        
          /**
           * 根据订单id修改订单状态、数量、小计;
           * @throws SQLException 
           */
          public int updateByOrderId(Order orderId) throws SQLException;
}
