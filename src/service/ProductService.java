package service;

import java.util.List;

import entity.Product;

/**
 * 商品的业务逻辑层
 * @author Administrator
 *
 */
public interface ProductService {
	/**
	 * 添加一条商品信息
	 */
	int addProduct(Product product);
	/**
	 * 根据商品id删除商品信息
	 */
	int deleteProductById(long productId);
	/**
	 * 修改一条商品信息
	 */
	int updateProductById(Product product);
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
}
