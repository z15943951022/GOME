package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import dao.ProductTypeDao;
import entity.Product;
import entity.ProductType;
import service.ProductTypeService;
import service.impl.ProductTypeServiceImpl;
import util.GetConnection;

public class A {

	@Test
	public void ad(){
		Connection cn=null;
		try {
			cn=GetConnection.getConnection();
			ProductDaoImpl pi=new ProductDaoImpl(cn);
			//Product product=new Product(1, "飘柔-4", "飘柔-4", 36, 30, null, "200ml", 10);
			//System.out.println(pi.addProduct(product));
			//System.out.println(pi.deleteProductById(5));
			//product.setProductId(4);
			//System.out.println(pi.updateProductById(product));
			//System.out.println(pi.findAllProducts().size());
			//System.out.println(pi.findProductById(1).getTitle());
			//ProductType productType=new ProductType();
			//productType.setTypeName("手机");
			//ProductTypeDao ti=new ProductTypeDaoImpl(cn);
			ProductTypeService psi=new ProductTypeServiceImpl();
			if(psi.findParentsNameById(4)!=null){
				System.out.println(psi.findParentsNameById(4).toString());
			}
			System.out.println(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(cn);
		}
		
		
	}
}
