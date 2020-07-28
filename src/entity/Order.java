package entity;

import java.util.Date;

/**
 * 订单实体类
 * @author Administrator
 *
 */
public class Order {
          private String orderId; 
          private long userId;
          private double total;//总计
          private String consignee;//收货人
          private String addressDetail;//收获地址
          private String phone;//手机号
          private Date creatDate;//创建时间
          
          public String getOrderId() {
                    return orderId;
          }
          public void setOrderId(String orderId) {
                    this.orderId = orderId;
          }
          public long getUserId() {
                    return userId;
          }
          public void setUserId(long userId) {
                    this.userId = userId;
          }
          public double getTotal() {
                    return total;
          }
          public void setTotal(double total) {
                    this.total = total;
          }
          public String getConsignee() {
                    return consignee;
          }
          public void setConsignee(String consignee) {
                    this.consignee = consignee;
          }
          public String getAddressDetail() {
                    return addressDetail;
          }
          public void setAddressDetail(String addressDetail) {
                    this.addressDetail = addressDetail;
          }
          public String getPhone() {
                    return phone;
          }
          public void setPhone(String phone) {
                    this.phone = phone;
          }
          public Date getCreatDate() {
                    return creatDate;
          }
          public void setCreatDate(Date creatDate) {
                    this.creatDate = creatDate;
          }
          
          
}

