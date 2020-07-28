package service;

import java.util.List;

import entity.Order;
import entity.OrderDetail;

public interface OrderDetailService {

	  /**
     * 根据订单号查询全部订单
     */  
    public List<OrderDetail> findAllByOrderId(String orderId);
    
    /**
     * 根据详单id删除详单
     */ 
    public int deleteByOrderDetailId(OrderDetail orderDetailId);
    
    /**
     * 增加一条订单详单
     */
    public int addByOrderId();
  
    /**
     * 根据订单id修改订单状态、数量、小计;
     */
    public int updateByOrderId(Order orderId);
}
