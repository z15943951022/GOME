package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Product;
import service.ProductService;
import util.GetConnection;

public class ProductServiceImpl implements ProductService {
	Connection connection=null;
	@Override
	public int addProduct(Product product) {
		int rel=-1;
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			rel=proImpl.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return rel;
	}

	@Override
	public int deleteProductById(long productId) {
		int rel=-1;
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			rel=proImpl.deleteProductById(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		
		return rel;
	}

	@Override
	public int updateProductById(Product product) {
		int rel=-1;
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			rel=proImpl.updateProductById(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return rel;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> proList=new ArrayList<Product>();
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			proList=proImpl.findAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return proList;
	}

	@Override
	public List<Product> findProductsByProductTypeId(long productTypeId) {
		List<Product> proList=new ArrayList<Product>();
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			proList=proImpl.findProductsByProductTypeId(productTypeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return proList;
	}

	@Override
	public Product findProductById(long productId) {
		Product product=null;
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			product=proImpl.findProductById(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return product;
	}

	@Override
	public List<Product> findAllProductsPaging(int pageIndex, int pageSize,
			long productId, String title) {
		List<Product> proList=new ArrayList<Product>();
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			proList=proImpl.findAllProductsPaging(pageIndex, pageSize, productId, title);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return proList;
	}

	@Override
	public int findProductsCount(long productId, String title) {
		int rel=-1;
		try {
			connection=GetConnection.getConnection();
			ProductDao proImpl=new ProductDaoImpl(connection);
			rel=proImpl.findProductsCount(productId, title);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		
		return rel;
	}

}
