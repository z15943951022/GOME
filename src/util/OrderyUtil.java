package util;

import java.util.Date;
import java.util.List;

public class OrderyUtil<T> {
	public String orderId;
	public  double total;
	public String setAddressDetail;
	public String consignee;
	public Date creatDate;
	public List<T> list;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAddressDetail() {
		return setAddressDetail;
	}
	public void setAddressDetail(String setAddressDetail) {
		this.setAddressDetail = setAddressDetail;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
