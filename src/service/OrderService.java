package service;

import java.util.List;

import entity.BuyCar;
import entity.Order;
import entity.OrderDetail;

public interface OrderService {

	 /**
     * 根据用户id查询全部订单
     */
    public List<Order> findOrderByUserId(long userId);
    
    /**
     * 增加一条订单信息
     * 
     */
    public int addOrder(List<BuyCar> carList,long addressId,String orderId,long userId);
    
    /**
     * 删除一条订单
     */
    public int deleteOrderBuyOrderId(String orderId);
    
    /**
     * 取消订单
     */
    public int cancelOrderByOrderId(String orderId);
}
