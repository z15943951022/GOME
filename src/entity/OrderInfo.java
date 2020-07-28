package entity;

public class OrderInfo {

	private String picPath;
	private String title;
	private String productAttr;
	private double orderSum;
	private String statusName;
	private String productId;
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProductAttr() {
		return productAttr;
	}
	public void setProductAttr(String productAttr) {
		this.productAttr = productAttr;
	}
	public double getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(double orderSum) {
		this.orderSum = orderSum;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
