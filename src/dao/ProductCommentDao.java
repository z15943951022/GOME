package dao;

import java.sql.SQLException;

import entity.BuyCar;
import entity.ProductComment;

/**
 * ��Ʒ���۽ӿ���
 * @author ������
 *
 */
public interface ProductCommentDao {
	/**
	 * �����Ʒid�������
	 * @throws SQLException 
	 * 
	 */
	int addByProductId(ProductComment productComment) throws SQLException;
	/**
	 * �����Ʒid��ѯ����
	 * 
	 */
	ProductComment selectByProductId(int ProductId);
}
