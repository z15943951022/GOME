package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.ProductTypeDao;
import dao.impl.ProductTypeDaoImpl;
import entity.ProductType;
import service.ProductTypeService;
import util.GetConnection;

public class ProductTypeServiceImpl implements ProductTypeService {

	@Override
	public String findNameById(int productTypeId) {
		String name=null;
		Connection connection=null;
		try {
			connection =GetConnection.getConnection();
			ProductTypeDao proType=new ProductTypeDaoImpl(connection);
			name=proType.findNameById(productTypeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return name;
	}

	@Override
	public int findParentIdById(int productTypeId) {
		Connection connection=null;
		int id=-1;
		try {
			connection =GetConnection.getConnection();
			ProductTypeDao proType=new ProductTypeDaoImpl(connection);
			id=proType.findParentIdById(productTypeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return id;
	}

	@Override
	public int addProductType(ProductType productType) {
		Connection connection=null;
		int rel=-1;
		try {
			connection =GetConnection.getConnection();
			ProductTypeDao proType=new ProductTypeDaoImpl(connection);
			rel=proType.addProductType(productType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return rel;
	}

	@Override
	public List<ProductType> findParentsNameById(int productTypeId) {
		List<ProductType> nameList=new LinkedList<ProductType>();
		Connection connection=null;
		ProductType productType=null;
		try {
			connection =GetConnection.getConnection();
			ProductTypeDao proType=new ProductTypeDaoImpl(connection);
			if(!"".equals(proType.findNameById(productTypeId))&&proType.findNameById(productTypeId)!=null){
				
				productType=new ProductType();
				productType.setProductTypeId(productTypeId);
				productType.setTypeName(proType.findNameById(productTypeId));
				nameList.add(0,productType);
				int parentId=-1;
				while(true){
					parentId=proType.findParentIdById(productTypeId);
					if(parentId==0){
						break;
					}
					productType=new ProductType();
					productType.setProductTypeId(parentId);
					productType.setTypeName(proType.findNameById(parentId));
					nameList.add(0,productType);
					productTypeId=parentId;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return nameList;
	}

	@Override
	public List<ProductType> findProductTypeByParentId(int parentId) {
		List<ProductType> typeList=new LinkedList<ProductType>();
		Connection connection=null;
		try {
			connection =GetConnection.getConnection();
			ProductTypeDao proType=new ProductTypeDaoImpl(connection);
			typeList=proType.findProductTypeByParentId(parentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(connection);
		}
		return typeList;
	}
	
}
