package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.ProductTypeDao;
import entity.ProductType;
/**
 * 商品类型表实现类
 * @author Administrator
 *
 */
public class ProductTypeDaoImpl extends BaseDao implements ProductTypeDao{

	public ProductTypeDaoImpl(Connection connection){
		super(connection);
	}
	@Override
	public String findNameById(int productTypeId) {
		String name=null;
		String sql="select typeName from producttype where productTypeId=?";
		Object obj[]={productTypeId};
		try {
			rs=this.executeQuery(sql, obj);
			if(rs.next()){
				name=rs.getString("typeName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return name;
	}

	@Override
	public int findParentIdById(int productTypeId) {
		int rel=-1;
		String sql="select parentId from producttype where productTypeId=?";
		Object obj[]={productTypeId};
		try {
			rs=this.executeQuery(sql, obj);
			if(rs.next()){
				rel=rs.getInt("parentId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return rel;
	}

	@Override
	public int addProductType(ProductType productType) throws SQLException {
		int rel=-1;
		String sql="INSERT into producttype(typeName,parentId) VALUES(?,?)";
		Object obj[]={productType.getTypeName(),productType.getParentId()};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}
	@Override
	public List<ProductType> findProductTypeByParentId(int parentId) {
		List<ProductType> typeList=new ArrayList<ProductType>();
		String sql="SELECT productTypeId,typeName,parentId from producttype where parentId=?";
		Object obj[]={parentId};
		try {
			rs=this.executeQuery(sql, obj);
			ProductType productType=null;
			while(rs.next()){
				productType=new ProductType();
				productType.setProductTypeId(rs.getInt("productTypeId"));
				productType.setTypeName(rs.getString("typeName"));
				productType.setParentId(parentId);
				typeList.add(productType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return typeList;
	}

}
