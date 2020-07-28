package dao;

import java.sql.SQLException;
import java.util.List;

import entity.ProductType;

/**
 * 商品类型表的接口
 * @author Administrator
 *
 */
public interface ProductTypeDao {
	/**
	 * 根据商品类型id得到类型名字
	 */
	String findNameById(int productTypeId);
	/**
	 * 根据商品类型id得到父类id
	 */
	int findParentIdById(int productTypeId);
	/**
	 * 添加一个商品类型
	 * @throws SQLException 
	 */
	int addProductType(ProductType productType) throws SQLException;
	/**
	 * 根据商品父类id得到商品类型对象集合
	 */
	List<ProductType> findProductTypeByParentId(int parentId);
}
