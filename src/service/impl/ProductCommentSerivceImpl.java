package service.impl;

import java.sql.Connection;
import java.sql.SQLException;




import service.ProductCommentService;
import util.GetConnection;
import dao.ProductCommentDao;
import dao.impl.ProductCommentImpl;
import entity.ProductComment;



public class ProductCommentSerivceImpl implements ProductCommentService{
	Connection connection=null;
	ProductCommentDao productCommentdao=null;
	

	public int addByProductId(ProductComment productComment) {
	 	int rel=-1;
	 	try {
			connection=GetConnection.getConnection();
			productCommentdao = new ProductCommentImpl(connection);
			rel=productCommentdao.addByProductId(productComment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rel;
}

	
	public ProductComment selectByProductId(int ProductId) {
			ProductComment productComment=null;
			try {
				connection=GetConnection.getConnection();
				productCommentdao = new ProductCommentImpl(connection);
				productComment=productCommentdao.selectByProductId(ProductId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return productComment;
	}
}
