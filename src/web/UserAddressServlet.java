package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.UserAddress;
import service.UserAddressService;
import service.impl.UserAddressServiceImpl;

public class UserAddressServlet extends HttpServlet {

	UserAddressService service=new UserAddressServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public UserAddressServlet() {
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
		case 1://添加
			addAddress(request, response);
			break;
		case 2://查询
			findAllAddressByUserId(request, response);
			break;
		case 3://删除
			deleteAddressById(request, response);
			break;
		case 4://查询地址
			findAddressByAddressId(request, response);
			break;
		case 5://修改地址
			updateAddressById(request, response);
			break;
		}
	}
	
	/**
	 * 添加地址
	 * @throws IOException 
	 */
	public void addAddress(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		//接收请求
		String uId=request.getParameter("userId");
		String consignee=request.getParameter("consignee");
		String addressDetail=request.getParameter("addressDetail");
		String phone=request.getParameter("phone");
		String defaultB=request.getParameter("defaultBoolean");
		Long userId=0L;
		if(null!=uId){
			userId=Long.parseLong(uId);
		}
		int defaultBoolean=0;
		if(null!=defaultB){
			defaultBoolean=Integer.parseInt(defaultB);
		}
		UserAddress userAdd=new UserAddress();
		userAdd.setUserId(userId);
		userAdd.setConsignee(consignee);
		userAdd.setAddressDetail(addressDetail);
		userAdd.setPhone(phone);
		userAdd.setDefaultBoolean(defaultBoolean);
		int i=service.addAddress(userAdd);
		out.print(i);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据地址id删除一条地址
	 * @throws IOException 
	 */
	public void deleteAddressById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String addrId=request.getParameter("addressId");
		long addressId = 0;
		if(null!=addrId){
			addressId=Long.parseLong(addrId);
		}
		int i=service.deleteById(addressId);
		out.print(i);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 根据用户ID查询所有地址
	 * @throws IOException 
	 */
	public void findAllAddressByUserId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String uId=request.getParameter("userId");
		Long userId=0L;
		if(null!=uId){
			userId=Long.parseLong(uId);
		}
		List<UserAddress> addressList=service.findByUserId(userId);
		String rel=JSON.toJSONString(addressList);
		out.print(rel);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据地址ID查询地址信息
	 * @throws IOException 
	 */
	public void findAddressByAddressId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String addrId=request.getParameter("addressId");
		long addressId = 0;
		if(null!=addrId){
			addressId=Long.parseLong(addrId);
		}
		UserAddress userAddress=new UserAddress();
		userAddress=service.findAddressById(addressId);
		String str=JSON.toJSONString(userAddress);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据地址Id修改地址
	 * @throws IOException 
	 */
	public void updateAddressById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String addrId=request.getParameter("addressId");
		String uId=request.getParameter("userId");
		String consignee=request.getParameter("consignee");
		String addressDetail=request.getParameter("addressDetail");
		String phone=request.getParameter("phone");
		String defaultB=request.getParameter("defaultBoolean");
		long addressId = 0;
		if(null!=addrId){
			addressId=Long.parseLong(addrId);
		}
		long userId=0L;
		if(null!=uId){
			userId=Long.parseLong(uId);
		}
		int defaultBoolean=0;
		if(null!=defaultB){
			defaultBoolean=Integer.parseInt(defaultB);
		}
		UserAddress userAddress=new UserAddress();
		userAddress.setAddressId(addressId);
		userAddress.setUserId(userId);
		userAddress.setConsignee(consignee);
		userAddress.setAddressDetail(addressDetail);
		userAddress.setPhone(phone);
		userAddress.setDefaultBoolean(defaultBoolean);
		int i=service.updateAddressById(userAddress);
		out.print(i);
		out.flush();
		out.close();
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
