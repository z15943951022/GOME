package entity;

public class UserAddress {
	private long addressId;//地址ID
	private long userId;//用户ID
	private String consignee;//收货人
	private String addressDetail;//详细地址
	private String phone;//电话
	private int defaultBoolean; //是否默认地址
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
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
	public int getDefaultBoolean() {
		return defaultBoolean;
	}
	public void setDefaultBoolean(int defaultBoolean) {
		this.defaultBoolean = defaultBoolean;
	}
	
	

}
