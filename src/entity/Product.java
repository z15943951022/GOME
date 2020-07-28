package entity;
/**
 * 商品详表实体类
 * @author Administrator
 *
 */
public class Product {
	/**
	 * 商品编号
	 */
	private long productId;
	/**
	 * 商品类型id
	 */
	private int productTypeId;
	/**
	 * 商品标题
	 */
	private String title;
	/**
	 * 商品详情
	 */
	private String productDetail;
	/**
	 * 商品原价
	 */
	private double price;
	/**
	 * 商品卖价
	 */
	private double sellingPrice;
	/**
	 * 商品图像路径
	 */
	private String picPath;
	/**
	 * 商品属性
	 */
	private String productAttr;
	/**
	 * 库存数量
	 */
	private int PCS;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
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
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getProductAttr() {
		return productAttr;
	}
	public void setProductAttr(String productAttr) {
		this.productAttr = productAttr;
	}
	public int getPCS() {
		return PCS;
	}
	public void setPCS(int pCS) {
		PCS = pCS;
	}
	public Product( int productTypeId, String title,
			String productDetail, double price, double sellingPrice,
			String picPath, String productAttr, int pCS) {
		super();
		this.productTypeId = productTypeId;
		this.title = title;
		this.productDetail = productDetail;
		this.price = price;
		this.sellingPrice = sellingPrice;
		this.picPath = picPath;
		this.productAttr = productAttr;
		PCS = pCS;
	}
	public Product() {
		super();
	}
	
}
