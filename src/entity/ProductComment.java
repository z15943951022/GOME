package entity;

import java.util.Date;



public class ProductComment {
	private int productCommentId;
	private int productId;
	private int userId;
	private int score;
	private String content;
	private Date creatDate;
	
	
	public int getProductCommentId() {
		return productCommentId;
	}
	public void setProductCommentId(int productCommentId) {
		this.productCommentId = productCommentId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

}
