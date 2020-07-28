package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;

import entity.Product;
import service.ProductService;
import service.ProductTypeService;
import service.impl.ProductServiceImpl;
import service.impl.ProductTypeServiceImpl;
import util.PageSurpport;

public class ProductDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProductDetailServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		PrintWriter out = response.getWriter();
		
		//获取操作数据
		String opt=request.getParameter("opt");
		if("getProducts".equals(opt)){
			getProducts(request, response);
			return;
		}
		if("goProductDetail".equals(opt)){
			goProductDetail(request, response);
			return;
		}
		if("addProduct".equals(opt)){
			addProduct(request, response);
			return;
		}
		if("getProductsPaging".equals(opt)){
			getProductsPaging(request, response);
			return;
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	private void getProductsPaging(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		ProductService ps=new ProductServiceImpl();
		long productId=-1;
		if(request.getParameter("productId")!=null&&!"".equals(request.getParameter("productId"))){
			productId=Long.parseLong(request.getParameter("productId"));
		}
		String title=request.getParameter("title");
		PageSurpport<Product> pageSurpport=new PageSurpport<Product>();
		int pageIndex=1;
		int pageSize=4;
		int totalCount=ps.findProductsCount(productId, title);
		pageSurpport.setPageIndex(pageIndex);
		pageSurpport.setPageSize(pageSize);
		pageSurpport.setTotalCount(totalCount);
		//获取当前页
		if(request.getParameter("curPage")!=null && !"".equals(request.getParameter("curPage"))){
		pageIndex=Integer.parseInt(request.getParameter("curPage"));
		}
		if(pageIndex<1){
			pageIndex=1;
		}
		if(pageIndex>pageSurpport.getPageCount()){
			pageIndex=1;
		}
		pageSurpport.setPageIndex(pageIndex);
		//分页数据
		List<Product> productsList=new ArrayList<Product>();
		productsList=ps.findAllProductsPaging(pageSurpport.getPageIndex(), pageSurpport.getPageSize(), productId, title);
		//分页数据保存到分页工具类
		pageSurpport.setDataList(productsList);
		String jsonStr=JSON.toJSONString(pageSurpport);
		out.print(jsonStr);
		out.flush();
		out.close();
		
		
		
	}
	private void getProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ProductService ps=new ProductServiceImpl();
		List<Product>productList=ps.findAllProducts();
		String jsonStr=JSON.toJSONString(productList);
		out.print(jsonStr);
		out.flush();
		out.close();
	}
	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String msg="moren";
		//1.检查类型，是否是文件上传:
		ServletFileUpload.isMultipartContent(request);//返回true|false
	    //2.创建文件上传对象
		//a.创建工厂
  		FileItemFactory factory=new DiskFileItemFactory();
  		//b.通过工厂创建文件上传对象
  		ServletFileUpload upload=new ServletFileUpload(factory);
		//3.解析上传的数据	
    	try {
			List<FileItem>  fileItemList=  upload.parseRequest(request);
			//4.处理数据.普通数据，取出，封装成实体,文件数据进行上传操作
			Product product=new Product();
			String picPath="default.jpg"; //如果不上传默认的文件
			//遍历表单数据
			for(FileItem item:fileItemList){
				//普通表单数据
	  			if(item.isFormField()){
	  				String fieldName=item.getFieldName();//获取表单名称
	  				if("checkedId".equals(fieldName)){
	  					product.setProductTypeId(Integer.parseInt(item.getString()));
	  				}else if("title".equals(fieldName)){
	  					product.setTitle(item.getString("utf-8"));
	  				}else if("productDetail".equals(fieldName)){
	  					product.setProductDetail(item.getString("utf-8"));
	  				}else if("price".equals(fieldName)){
	  					product.setPrice(Double.parseDouble(item.getString()));
	  				}else if("sellingPrice".equals(fieldName)){
	  					product.setSellingPrice(Double.parseDouble(item.getString()));
	  				}else if("productAttr".equals(fieldName)){
	  					product.setProductAttr(item.getString("utf-8"));
	  				}else if("pCS".equals(fieldName)){
	  					product.setPCS(Integer.parseInt(item.getString()));
	  				}
	  			}else{
	  				//上传文件
	  				String fieldsName=item.getFieldName();//获取表单名称
	  				if("productDetail".equals(fieldsName)){
	  				//商品详情的图片
	  					if(item.getSize()>0&&item.getSize()<1024*500){
			  				//上传文件数据
			  				//1.获取系统时间，精确毫秒，随机数据+“上传文件的扩展名”
			  				Date date=new Date();
			  				SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
			  				String now=format.format(date);
			  				Random random=new Random();
			  				int ran=random.nextInt(1000);
			  				//2.通过扩展名判断用户上传的是否是图片：gif,png,jpeg.jpg
			  				String fileName=item.getName();//上传的文件名
			  				String lastName=fileName.substring(fileName.lastIndexOf("."));
			  				if(".gif".equals(lastName)||".png".equals(lastName)||".jpeg".equals(lastName)||".jpg".equals(lastName)){
			  					//是图片
			  					String newFilename=now+"_"+ran+lastName;//新文件名
				  				
				  				File fullFile=new File(newFilename);//创建文件对象
				  				//获取服务器端的路径
				  		        //获取“upload”包目录所在的物理全路径
				  		        String uploadPath=this.getServletContext().getRealPath("upload/");
				  		        System.out.println(uploadPath+fullFile.getName());
				  				File uploadFile=new File(uploadPath+"/"+fullFile.getName());
				  				//5.上传文件
								item.write(uploadFile);
								picPath=fullFile.getName();//保存新文件名
								product.setProductDetail(picPath);
			  				}else{
			  					//不是图片
			  					msg="添加失败！您商品详情上传的图片格式不正确";
			  					out.print("<script>alert('"+msg+"');self.location=document.referrer;</script>");
			  					out.flush();
			  					out.close();
			  					return;
			  					//request.setAttribute("delUpMsg", "添加失败！您上传的图片格式不正确");
			  					//request.getRequestDispatcher("NewsDetailServlet?opt=getNewsPaging").forward(request, response);
			  					//return;
			  				}
		  				}
		  				if(item.getSize()>=1024*500){
		  					msg="添加失败！您商品详情上传的图片太大，请保持500KB以内！";
		  					out.print("<script>alert('"+msg+"');self.location=document.referrer;</script>");
		  					out.flush();
		  					out.close();
		  					//request.setAttribute("delUpMsg", "添加失败！您上传的图片太大，请保持100KB以内！");
		  					//request.getRequestDispatcher("NewsDetailServlet?opt=getNewsPaging").forward(request, response);
		  					return;
		  				}
	  				}else{
	  				//picPath的文件
	  					if(item.getSize()>0&&item.getSize()<1024*500){
			  				//上传文件数据
			  				//1.获取系统时间，精确毫秒，随机数据+“上传文件的扩展名”
			  				Date date=new Date();
			  				SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmssSSS");
			  				String now=format.format(date);
			  				Random random=new Random();
			  				int ran=random.nextInt(1000);
			  				//2.通过扩展名判断用户上传的是否是图片：gif,png,jpeg.jpg
			  				String fileName=item.getName();//上传的文件名
			  				String lastName=fileName.substring(fileName.lastIndexOf("."));
			  				if(".gif".equals(lastName)||".png".equals(lastName)||".jpeg".equals(lastName)||".jpg".equals(lastName)){
			  					//是图片
			  					String newFilename=now+"_"+ran+lastName;//新文件名
				  				
				  				File fullFile=new File(newFilename);//创建文件对象
				  				//获取服务器端的路径
				  		        //获取“upload”包目录所在的物理全路径
				  		        String uploadPath=this.getServletContext().getRealPath("upload/");
				  		        System.out.println(uploadPath+fullFile.getName());
				  				File uploadFile=new File(uploadPath+"/"+fullFile.getName());
				  				//5.上传文件
								item.write(uploadFile);
								picPath=fullFile.getName();//保存新文件名
								product.setPicPath(picPath);
			  				}else{
			  					//不是图片
			  					msg="添加失败！您商品标题主图片上传的图片格式不正确";
			  					out.print("<script>alert('"+msg+"');self.location=document.referrer;</script>");
			  					out.flush();
			  					out.close();
			  					//request.setAttribute("delUpMsg", "添加失败！您上传的图片格式不正确");
			  					//request.getRequestDispatcher("NewsDetailServlet?opt=getNewsPaging").forward(request, response);
			  					return ;
			  				}
		  				}
		  				if(item.getSize()>=1024*500){
		  					msg="添加失败！您商品标题主图片上传的图片太大，请保持500KB以内！";
		  					out.print("<script>alert('"+msg+"');self.location=document.referrer;</script>");
		  					out.flush();
		  					out.close();
		  					//request.setAttribute("delUpMsg", "添加失败！您上传的图片太大，请保持100KB以内！");
		  					//request.getRequestDispatcher("NewsDetailServlet?opt=getNewsPaging").forward(request, response);
		  					return ;
		  				}
	  					
	  					
	  				}
	  			}
			}
			//添加到数据库
			ProductService productService=new ProductServiceImpl();
			int rel=productService.addProduct(product);
			if(rel>0){
				//添加成功
				msg="添加成功！";
			}else{
				//添加失败
				msg="添加失败！";
			}
			out.print("<script>alert('"+msg+"');self.location=document.referrer;</script>");
			out.flush();
			out.close();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void goProductDetail (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int productId=Integer.parseInt(request.getParameter("productId")) ;
		ProductService ps=new ProductServiceImpl();
		//商品类型
		int productTypeId=ps.findProductById(productId).getProductTypeId();
		ProductTypeService pts=new ProductTypeServiceImpl();
		request.setAttribute("typeList", pts.findParentsNameById(productTypeId));
		request.setAttribute("product", ps.findProductById(productId));
		request.getRequestDispatcher("productDetail.jsp").forward(request, response);
	}
}
