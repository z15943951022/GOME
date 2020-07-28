package dao;

import java.sql.SQLException;
import java.util.List;



import entity.Product;
/**
 * 商品表的接口
 * @author Administrator
 *
 */
public interface ProductDao {
	/**
	 * 添加一条商品信息
	 * @throws SQLException 
	 */
	int addProduct(Product product) throws SQLException;
	/**
	 * 根据商品id删除商品信息
	 * @throws SQLException 
	 */
	int deleteProductById(long productId) throws SQLException;
	/**
	 * 修改一条商品信息
	 * @throws SQLException 
	 */
	int updateProductById(Product product) throws SQLException;
	/**
	 * 遍历所有的商品信息
	 */
	List<Product> findAllProducts();
	/**
	 * 根据商品类型id获得商品集合
	 */
	List<Product> findProductsByProductTypeId(long productTypeId );
	/**
	 * 根据商品id获得商品对象
	 */
	Product findProductById(long productId);
	/**
	 * 查询产品带分页，带条件过滤
	 * @param pageIndex
	 * @param pageSize
	 * @param categoryId
	 * @param title
	 * @return
	 */
	List<Product> findAllProductsPaging(int pageIndex,int pageSize,long productId,String title);
	/**
	 * 获取产品总记录数，带过滤条件
	 * @return
	 */
	int findProductsCount(long productId,String title);
	/**
	 * 根据商品id修改商品库存
	 * @throws SQLException 
	 */
	int updategetProductCountById(long productId,int PCS) throws SQLException;
}
