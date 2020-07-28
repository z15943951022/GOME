package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.OrderDetailDao;
import entity.Order;
import entity.OrderDetail;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {
          public OrderDetailDaoImpl(Connection connection) {
                    super(connection);
          }
          
                  
          @Override
          public List<OrderDetail> findAllByOrderId(String orderId) {
                    List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
                    StringBuilder sql=new StringBuilder();
                    sql.append("SELECT picpath,title,d.productAttr,d.orderSum,d.productCount,s.`NAME`,d.productId FROM orderdetail d JOIN orderstatus s ON d.statusId=s.statusId  WHERE orderId=? ");
                    Object []obj = {orderId};
                    try {
                              rs = this.executeQuery(sql.toString(), obj);
                              OrderDetail orderDetail = null;
                              while(rs.next()){
                                        orderDetail  = new OrderDetail(); 
                                        orderDetail.setPicPath(rs.getString(1));
                                        orderDetail.setTitle(rs.getString(2));
                                        orderDetail.setProductAttr(rs.getString(3));
                                        orderDetail.setOrderSum(rs.getDouble(4));
                                        orderDetail.setProductCount(rs.getInt(5));
                                        orderDetail.setName(rs.getString(6));
                                        orderDetail.setProductId(rs.getLong(7));
                                        listOrderDetail.add(orderDetail);
                              }
                    } catch (Exception e) {
                              e.printStackTrace();
                    }finally{
                              GetConnection.close(rs,ps);
                    }
                    return listOrderDetail;
          }

          
          @Override
          public int deleteByOrderDetailId(String orderId) throws SQLException {
                    int rel = -1;
                    String sql = "DELETE FROM orderDetail WHERE orderId = ?";
                    Object []obj = {orderId};
                    rel = this.executeUpdate(sql, obj);
                    return rel;
          }

          
          @Override
          public int addByOrderId(OrderDetail detail) throws SQLException {
                    int rel = -1;
                    String sql = "INSERT INTO orderDetail(orderId,statusId,productId,picPath,title,price,sellingPrice,productAttr,productCount,orderSum)VALUES(?,?,?,?,?,?,?,?,?,?)";
                    Object []obj = {detail.getOrderId(),detail.getStatusId(),detail.getProductId(),detail.getPicPath(),detail.getTitle(),detail.getPrice(),detail.getSellingPrice(),detail.getProductAttr(),detail.getProductCount(),detail.getOrderSum()};
                    rel = this.executeUpdate(sql, obj);
                    return rel;
          }

          @Override
          public int updateByOrderId(Order orderId) throws SQLException {
                    int rel = -1;
                    String sql = "UPDATE orderDetail SET statusId=?,productDetail=?,orderSum=? where orderId = ?";
                    Object []obj = {orderId.getOrderId()};
                    rel = this.executeUpdate(sql, obj);
                    return rel;
          }

}
