package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Order;
import entity.OrderDetail;
import service.OrderDetailService;
import service.OrderService;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiceImpl;
import util.LimitUitl;
import util.OrderyUtil;
/**
 * 订单操作类
 * @author 86159
 *
 */
public class OrderServlet extends HttpServlet {

	OrderDetailService service =new OrderDetailServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public OrderServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ii=request.getParameter("i");
		int i=-1;
		if(null!=ii){
			i=Integer.parseInt(ii);
		}
		switch(i){
		case 1://查询所有订单
			findAllOrderByUserId(request, response);
			break;
		case 3://取消订单
			cancelOrderByOrderId(request, response);
			break;
		}
		
		
	}
	
	/**
	 * 分页过滤查询该用户所有订单
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void findAllOrderByUserId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userid=request.getParameter("userId");
		PrintWriter out=response.getWriter();
		long userId=-1;
		if(null!=userid){
			userId=Long.parseLong(userid);
		}
		OrderyUtil<OrderDetail> orderUtil=null;//订单储存工具
		OrderService orderService=new OrderServiceImpl();//订单主表
		List<Order> order=orderService.findOrderByUserId(userId);//查询所有订单
		List<OrderyUtil<OrderDetail>> allOrder=new ArrayList<OrderyUtil<OrderDetail>>();//所有订单
		for(Order o:order){
			orderUtil=new OrderyUtil<OrderDetail>();//一条订单
			orderUtil.setOrderId(o.getOrderId());
			orderUtil.setTotal(o.getTotal());
			orderUtil.setConsignee(o.getConsignee());
			orderUtil.setAddressDetail(o.getAddressDetail());
			orderUtil.setCreatDate(o.getCreatDate());
			List<OrderDetail> DetailList=service.findAllByOrderId(o.getOrderId());
			orderUtil.setList(DetailList);
			allOrder.add(orderUtil);
		}
		String str=JSON.toJSONStringWithDateFormat(allOrder,"yyyy-MM-dd");
		out.print(str);
		out.flush();
		out.close();
		
	}
	
	/**
	 * 取消订单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void cancelOrderByOrderId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String orderId=request.getParameter("orderId");
		if(null!=orderId){
			OrderService orederService=new OrderServiceImpl();
			int i=orederService.cancelOrderByOrderId(orderId);
			out.print(i);
			out.flush();
			out.close();
		}
	}

	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}


}
