package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BuyCarService;
import service.OrderService;
import service.impl.BuyCarSerivceImpl;
import service.impl.OrderServiceImpl;
import util.OrderUID;
import entity.BuyCar;

public class AddOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddOrderServlet() {
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
		PrintWriter out=response.getWriter();
		String userId = request.getParameter("userId");// 用户ID
		String addressId = request.getParameter("addressId");// 收获人
		String[] buyCarId = request.getParameterValues("buyCarId");// 购物车ID
		BuyCarService buyCarService = new BuyCarSerivceImpl();
		OrderService addOrder = new OrderServiceImpl();
		if (buyCarId.length > 0 && null != userId&&null!=addressId) {
			List<BuyCar> carList = new ArrayList<BuyCar>();
			for (String buycar : buyCarId) {
				if (null != buycar) {
					BuyCar car = buyCarService.findBuyCarById(Long
							.parseLong(buycar));
					carList.add(car);
				}
			}
			String orderUid = OrderUID.getUID();
			int i = addOrder.addOrder(carList, Long.parseLong(addressId), orderUid,
					Long.parseLong(userId));
			if(i>0){
				request.setAttribute("orderUid", orderUid);
				request.getRequestDispatcher("pay.jsp").forward(request, response);
			}else{
				out.print(i);
				out.flush();
				out.close();
			}
		} else{
			out.print("错误");
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
