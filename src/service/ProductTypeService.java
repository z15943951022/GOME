package service;

import java.util.List;

import entity.ProductType;

public interface ProductTypeService {
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
	 */
	int addProductType(ProductType productType);
	/**
	 * 根据商品父类id得到商品类型对象集合
	 */
	List<ProductType> findProductTypeByParentId(int parentId);
	/**
	 * 根据类型id获得类型名及所有父类的类型名，由上向下排列
	 */
	List<ProductType> findParentsNameById(int productTypeId);
}
