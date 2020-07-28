package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BuyCarService;
import service.impl.BuyCarSerivceImpl;
import util.BuyCarUtil;

import com.alibaba.fastjson.JSON;

import dao.BuyCarDao;
import dao.impl.BuyCarImpl;
import entity.BuyCar;
import entity.User;


public class BuyCarServlet extends HttpServlet {
	BuyCarService buycarService=new BuyCarSerivceImpl();
	/**
	 * Constructor of the object.
	 */
	public BuyCarServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//HttpSession session= request.getSession();
		//获取操作字符
		String opt=request.getParameter("opt");
		BuyCarDao newsDao=new BuyCarImpl();		
		//实例化业务逻辑层对象
		
		
		if("delNews".equals(opt))//删除
		{
			long buycarid=Long.parseLong(request.getParameter("buycarid")) ;
			
			int rel=buycarService.deleteByBuyCarId(buycarid);
			
		}else if("find".equals(opt)){
			long userid=Long.parseLong(request.getParameter("userid"));
			List<BuyCar> buyList=buycarService.selectByUserId(userid);
			double total=buycarService.getTotalByUserId(userid);
			BuyCarUtil buyCarUtil=new BuyCarUtil();
			buyCarUtil.setTotal(total);
			buyCarUtil.setBuyCar(buyList);
			String str=JSON.toJSONString(buyCarUtil);
			out.print(str);
			out.flush();
			out.close();
		}else if("addProduct".equals(opt)){
			addProduct(request, response);
		}else if("getTotal".equals(opt)){
			getTotal(request, response);
		}else if("addCount".equals(opt)){
			addCount(request, response);
		}else if("minusCount".equals(opt)){
			minusCount(request, response);
		}
		
		
	}
	private void minusCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long buyCarId=Long.parseLong(request.getParameter("buyCarId"));
		
		int count=buycarService.findBuyCarById(buyCarId).getProductCount()-1;
		BuyCar buyCar=new BuyCar();
		buyCar.setId(buyCarId);
		buyCar.setProductCount(count);
		if(buycarService.UpdateByBuyCarId(buyCar)>0){
			//修改成功
			out.print("true");
		}else{
			//修改失败
			out.print("false");
		}
		out.flush();
		out.close();
	}
	private void addCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long buyCarId=Long.parseLong(request.getParameter("buyCarId"));
		
		int count=buycarService.findBuyCarById(buyCarId).getProductCount()+1;
		BuyCar buyCar=new BuyCar();
		buyCar.setId(buyCarId);
		buyCar.setProductCount(count);
		
		if(buycarService.UpdateByBuyCarId(buyCar)>0){
			//修改成功
			out.print("true");
		}else{
			//不能修改，库存不够
			out.print("false");
		}
		out.flush();
		out.close();
	}
	private void getTotal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buyCarIdArray[]=request.getParameterValues("buyCarId");
		PrintWriter out = response.getWriter();
		double total=0;
		int count=0;
		if(buyCarIdArray!=null){
			for(int i=0;i<buyCarIdArray.length;i++){
				total+=buycarService.findBuyCarById(Long.parseLong(buyCarIdArray[i])).getBuyCarSum();
				count+=buycarService.findBuyCarById(Long.parseLong(buyCarIdArray[i])).getProductCount();
			}
		}
		Object boj[]={count,total};
		String json=JSON.toJSONString(boj);
		out.print(json);
		out.flush();
		out.close();
		
	}
	private void addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		User user=(User)request.getSession().getAttribute("user");
		if(user==null){
			out.print("<script>alert('添加失败！请先登录');self.location=document.referrer;</script>");
		}else{
			long userId=user.getUserId();
			long productId=Long.parseLong(request.getParameter("productId"));
			double sellingPrice=Double.parseDouble(request.getParameter("sellingPrice"));
			int productCount=Integer.parseInt(request.getParameter("productCount"));
			BuyCar buyCar=new BuyCar();
			buyCar.setProductId(productId);
			buyCar.setProductCount(productCount);
			buyCar.setUserId(userId);
			buyCar.setSellingPrice(sellingPrice);
			buyCar.setBuyCarSum(sellingPrice*productCount);
			int rel=-1;
			if(null!=buycarService.equals(buyCar)){
				//修改购物车
				buyCar.setId(buycarService.equals(buyCar).getId());
				buyCar.setProductCount(buycarService.equals(buyCar).getProductCount()+buyCar.getProductCount());
				buyCar.setBuyCarSum(sellingPrice*buyCar.getProductCount());
				rel=buycarService.UpdateByBuyCarId(buyCar);
			}else{
				//添加
				rel=buycarService.addByUserId(buyCar);
			}
			if(rel>0){
				//添加成功
				out.print("添加成功！");
			}else{
				//添加失败
				out.print("添加失败！");
			}
		}
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	

}
