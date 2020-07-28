package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;
import entity.User;

public class RegisterServlet extends HttpServlet {

		UserService regUser = new UserServiceImpl();

          /**
           * Constructor of the object.
           */
          public RegisterServlet() {
                    super();
          }

          public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
                   String ii=request.getParameter("i");
                   int i=-1;
                   if(null!=ii){
                	   i=Integer.parseInt(ii);
                   }
                   switch(i){
                   case 1://注册
                	   doRegister(request, response);
                	   break;
                   case 2://验证用户名
                	   testName(request, response);
                	   break;
                   case 3://验证密码
                	   testPhone(request, response);
                	   break;
                   }
          }
          
          
          public void doRegister(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        	  PrintWriter out = response.getWriter();
              String phone = request.getParameter("phone");
              String userName = request.getParameter("userName");
              String passWord = request.getParameter("userPassword");
              User user = new User();
              user.setUserName(userName);
              user.setPassword(passWord);
              user.setPhone(phone);
              int rel = regUser.addUser(user);
              if(rel>0){
              		request.setAttribute("info", "恭喜您:注册成功！");
              		request.getRequestDispatcher("register.jsp").forward(request, response);
              }else{
              	request.setAttribute("err", "注册失败！");
              	request.getRequestDispatcher("register.jsp").forward(request, response);
              }
          }
          
          
          /**
           * 异步验证用户名
           * @param request
           * @param response
           * @throws IOException
           * @throws ServletException
           */
          public void testName(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        	  PrintWriter out = response.getWriter();
        	  String userName = request.getParameter("userName");
        	  regUser = new UserServiceImpl();
        	  User user=regUser.findUserByName(userName);
        	  if(null!=user){
        		  	out.print(1);
        		  	out.flush();
        		  	out.close();
        	  }else{
        		  	out.print(-1);
      		  		out.flush();
      		  		out.close();
        	  }
          }
          /**
           * 异步验证手机号
           * @param request
           * @param response
           * @throws IOException
           * @throws ServletException
           */
          public void testPhone(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        	  PrintWriter out = response.getWriter();
        	  String phone = request.getParameter("phone");
        	  regUser = new UserServiceImpl();
        	  User user=regUser.findUserByPhone(phone);
        	  if(null!=user){
        		  	out.print(1);
        		  	out.flush();
        		  	out.close();
        	  }else{
        		  	out.print(-1);
      		  		out.flush();
      		  		out.close();
        	  }
          }
          
         

          public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
                    doGet(request, response);
          }
          
          
  

}
