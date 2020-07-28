package dao.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.GetConnection;
import dao.BaseDao;
import dao.ProductDao;
import entity.Product;
/**
 * 商品表实现类
 * @author Administrator
 *
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public synchronized int addProduct(Product product) throws SQLException {
		int rel=-1;
		String sql="insert into product(productTypeId,title,productDetail,price,sellingPrice,picPath,productAttr,PCS) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		Object obj[]={product.getProductTypeId(),product.getTitle(),product.getProductDetail(),
				product.getPrice(),product.getSellingPrice(),product.getPicPath(),
				product.getProductAttr(),product.getPCS()};
		rel=this.executeUpdate(sql, obj);
		
		return rel;
	}

	@Override
	public synchronized int deleteProductById(long productId) throws SQLException {
		int rel=-1;
		String sql="DELETE FROM product where productId = ? ";
		Object obj[]={productId};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}

	@Override
	public synchronized int updateProductById(Product product) throws SQLException {
		int rel=-1;
		String sql="UPDATE product set productTypeId=?,title=?,productDetail=?,"
				+ "price=?,sellingPrice=?,picPath=?,productAttr=?,PCS=? "
				+ "where productId=?";
		Object obj[]={product.getProductTypeId(),product.getTitle(),product.getProductDetail(),
				product.getPrice(),product.getSellingPrice(),product.getPicPath(),
				product.getProductAttr(),product.getPCS(),product.getProductId()};
		rel=this.executeUpdate(sql, obj);
		return rel;
	}

	@Override
	public  List<Product> findAllProducts() {
		List<Product> proList=new ArrayList<Product>();
		String sql="SELECT productId,productTypeId,title,productDetail,price,"
				+ "sellingPrice,picPath,productAttr,PCS FROM product";
		try {
			rs=this.executeQuery(sql, null);
			Product product=null;
			while(rs.next()){
				product=new Product();
				product.setProductId(rs.getLong("productId"));
				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setTitle(rs.getString("title"));
				product.setProductDetail(rs.getString("productDetail"));
				product.setPrice(rs.getDouble("price"));
				product.setSellingPrice(rs.getDouble("sellingPrice"));
				product.setPicPath(rs.getString("picPath"));
				product.setProductAttr(rs.getString("productAttr"));
				product.setPCS(rs.getInt("PCS"));
				proList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return proList;
	}

	@Override
	public  List<Product> findProductsByProductTypeId(long productTypeId) {
		List<Product> proList=new ArrayList<Product>();
		String sql="SELECT productId,productTypeId,title,productDetail,price,"
				+ "sellingPrice,picPath,productAttr,PCS FROM product "
				+ "where productTypeId =?";
		Object obj[]={productTypeId};
		try {
			rs=this.executeQuery(sql, obj);
			Product product=null;
			while(rs.next()){
				product=new Product();
				product.setProductId(rs.getLong("productId"));
				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setTitle(rs.getString("title"));
				product.setProductDetail(rs.getString("productDetail"));
				product.setPrice(rs.getDouble("price"));
				product.setSellingPrice(rs.getDouble("sellingPrice"));
				product.setPicPath(rs.getString("picPath"));
				product.setProductAttr(rs.getString("productAttr"));
				product.setPCS(rs.getInt("PCS"));
				proList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return proList;
	}
	public ProductDaoImpl(Connection connection){
		super(connection);
	}

	@Override
	public Product findProductById(long productId) {
		Product product=null;
		String sql="SELECT productId,productTypeId,title,productDetail,price,sellingPrice,picPath,"
				+ "productAttr,PCS FROM product where productId=?";
		Object obj[]={productId};
		try {
			rs=this.executeQuery(sql, obj);
			if(rs.next()){
				product=new Product();
				product.setProductId(rs.getLong("productId"));
				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setTitle(rs.getString("title"));
				product.setProductDetail(rs.getString("productDetail"));
				product.setPrice(rs.getDouble("price"));
				product.setSellingPrice(rs.getDouble("sellingPrice"));
				product.setPicPath(rs.getString("picPath"));
				product.setProductAttr(rs.getString("productAttr"));
				product.setPCS(rs.getInt("PCS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		return product;
	}

	public List<Product> findAllProductsPaging(int pageIndex, int pageSize,
			long productId, String title) {
		List<Product> proList=new ArrayList<Product>();
		String sql="SELECT productId,productTypeId,title,productDetail,price,sellingPrice,picPath,productAttr,PCS FROM product where 1=1 ";
		//选择了类别
		if(productId>-1){
			sql+=" and productId="+productId;
		}
		if(title!=null&&!title.equals("")){
			sql+=" and title like '%"+title+"%'";
		}
		sql+= "  limit ?,?";
		Object obj[]={(pageIndex-1)*pageSize,pageSize};
		try {
			rs=this.executeQuery(sql, obj);
			Product product=null;
			while(rs.next()){
				product=new Product();
				product.setProductId(rs.getLong("productId"));
				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setTitle(rs.getString("title"));
				product.setProductDetail(rs.getString("productDetail"));
				product.setPrice(rs.getDouble("price"));
				product.setSellingPrice(rs.getDouble("sellingPrice"));
				product.setPicPath(rs.getString("picPath"));
				product.setProductAttr(rs.getString("productAttr"));
				product.setPCS(rs.getInt("PCS"));
				proList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		
		
		return proList;
	}

	@Override
	public int findProductsCount(long productId, String title) {
		int rel=-1;
		String sql="select COUNT(0) from product where 1=1 ";
		//选择了类别
		if(productId>-1){
			sql+="and categoryId="+productId;
		}
		if(title!=null&&!title.equals("")){
			sql+="and title like '%"+title+"%'";
		}
		try {
			rs=this.executeQuery(sql, null);
			if(rs.next()){
				rel=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			GetConnection.close(rs);
		}
		
		return rel;
	}

	public synchronized int updategetProductCountById(long productId, int PCS) throws SQLException {
		int i=-1;
		String sql="update product set PCS=? where productId=?";
		Object[]obj={PCS,productId};
		i=executeUpdate(sql, obj);
		return i;
	}
}
