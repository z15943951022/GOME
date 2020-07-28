package entity;
/**
 * 订单详情实体类
 * @author Administrator
 *
 */
public class OrderDetail {
          private long orderDetailId ;  
          private String orderId;
          private int statusId;
          private String picPath;
          public String getPicPath() {
			return picPath;
		}
		public void setPicPath(String picPath) {
			this.picPath = picPath;
		}
		private String name;
          private long productId;
          private String title;
          private double price;
          private double sellingPrice;
          private String productAttr;
          private int productCount;
          private double orderSum;
          public String getName() {
			return name;
          }
          public void setName(String name) {
			this.name = name;
          }
          public long getOrderDetailId() {
                    return orderDetailId;
          }
          public void setOrderDetailId(long orderDetailId) {
                    this.orderDetailId = orderDetailId;
          }
          public String getOrderId() {
                    return orderId;
          }
          public void setOrderId(String orderId) {
                    this.orderId = orderId;
          }
          public int getStatusId() {
                    return statusId;
          }
          public void setStatusId(int statusId) {
                    this.statusId = statusId;
          }
          public long getProductId() {
                    return productId;
          }
          public void setProductId(long productId) {
                    this.productId = productId;
          }
          public String getTitle() {
                    return title;
          }
          public void setTitle(String title) {
                    this.title = title;
          }
          public double getPrice() {
                    return price;
          }
          public void setPrice(double price) {
                    this.price = price;
          }
          public double getSellingPrice() {
                    return sellingPrice;
          }
          public void setSellingPrice(double sellingPrice) {
                    this.sellingPrice = sellingPrice;
          }
          public String getProductAttr() {
                    return productAttr;
          }
          public void setProductAttr(String productAttr) {
                    this.productAttr = productAttr;
          }
          public int getProductCount() {
                    return productCount;
          }
          public void setProductCount(int productCount) {
                    this.productCount = productCount;
          }
          public double getOrderSum() {
                    return orderSum;
          }
          public void setOrderSum(double orderSum) {
                    this.orderSum = orderSum;
          }
          
          
         
          
   
          
}


