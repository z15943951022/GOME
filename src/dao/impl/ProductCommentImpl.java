package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import util.GetConnection;
import dao.BaseDao;
import dao.ProductCommentDao;
import entity.ProductComment;

public class ProductCommentImpl extends BaseDao implements ProductCommentDao{
	public ProductCommentImpl() {
		
	}
	public ProductCommentImpl(Connection connection) {
		super(connection);
	}
	

	//��
	public int addByProductId(ProductComment productComment) throws SQLException {
		int rel=-1;
		String sql="INSERT INTO productcomment(productid,userid,score,content,creatDate)VALUES(?,?,?,?,now())";
		Object[] obj={productComment.getProductId(),productComment.getUserId(),productComment.getScore(),productComment.getContent()};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}

	//��
	public ProductComment selectByProductId(int ProductId) {
		ProductComment productComment=null;
		Object[] obj={ProductId};
		String sql="SELECT * FROM productcomment WHERE productcommentid=?";
		try {
		rs=this.executeQuery(sql, obj);
		
			while(rs.next()){
				productComment=new ProductComment();
				productComment.setProductCommentId(rs.getInt("ProductCommentId"));
				productComment.setProductId(rs.getInt("productId"));
				productComment.setUserId(rs.getInt("userId"));
				productComment.setContent(rs.getString("content"));
				productComment.setCreatDate(rs.getTimestamp("creatDate"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs,ps);
		}
		
		return productComment;
	}
	
}
