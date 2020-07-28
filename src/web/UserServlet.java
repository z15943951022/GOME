package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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

import entity.User;
import service.UserAddressService;
import service.UserService;
import service.impl.UserAddressServiceImpl;
import service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	String code;
	UserService Userservice=new UserServiceImpl();

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		code=this.getServletContext().getInitParameter("charCode");
		String ii=request.getParameter("i");
		int i=0;
		if(null!=ii){
			i=Integer.parseInt(ii);
		}
		switch(i){
		case 1://用户登陆
			findUserByUser(request, response);
			break;
		case 2://修改用户信息
			updateUserById(request, response);
			break;
		case 3:
			findUserByUserFilter(request, response);
			break;
		
		}
	}
	/**
	 * 查询用户，验证登陆
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void findUserByUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		User user=new User();
		user.setUserName(userName);
		user.setPassword(passWord);
		int i=Userservice.isExistByName(user);
		if(i==-1){//用户名错误
			out.print("<script>alert('密码错误');self.location=document.referrer;</script>");
			out.flush();
			out.close();
		}else if(i==0){//密码错误
			out.print("<script>alert('用户名错误');self.location=document.referrer;</script>");
			out.flush();
			out.close();
		}else if(i>0){//正确
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @throws NumberFormatException 
	 * @throws IOException 
	 * 
	 */
	public void updateUserById(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, IOException{
			PrintWriter out = response.getWriter();
			String fieldName="";
			String defaultPic="default.png";
			User user=new User();//将修改的user
			if(ServletFileUpload.isMultipartContent(request)){
				FileItemFactory factory=new DiskFileItemFactory();
				ServletFileUpload upload=new ServletFileUpload(factory);
				List<FileItem> FileitemLsit = null;
				try {
					FileitemLsit = upload.parseRequest(request);
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				for(FileItem item:FileitemLsit){
					if(item.isFormField()){//普通表单
						fieldName=item.getFieldName();
						if (fieldName.equals("userId")) {
							user.setUserId(Integer.parseInt(item.getString(code)));
						}
						if (fieldName.equals("money")) {
							user.setMoney(Double.parseDouble(item.getString(code)));
						}
						if (fieldName.equals("userPetName")) {
							user.setUserPetName(item.getString(code));
						}
						if (fieldName.equals("passWord")) {
							user.setPassword(item.getString(code));
						}
						if (fieldName.equals("type")) {
							user.setType(item.getString(code));
						}
						if (fieldName.equals("sex")) {
							user.setSex(Integer.parseInt(item.getString(code)));
						}
						if (fieldName.equals("phone")) {
							user.setPhone(item.getString(code));
						}
						if (fieldName.equals("email")) {
							user.setEmail(item.getString(code));
						} 
						if (fieldName.equals("picPath")) {
							user.setPicPath(item.getString(code));
						} 
					}else{//文件域
						String fileName=item.getName();
						if(item.getSize()>0){
							if(item.getSize()<1024*2000){
							//判断是否是图片：gif,png,jpeg,jpg
							if(fileName.endsWith(".gif")|fileName.endsWith(".png")|fileName.endsWith(".jpeg")
									|fileName.endsWith(".jpg")){
								//获取系统时间，精确毫秒,随机数+"扩展名"
								String suffix=fileName.substring(fileName.lastIndexOf("."));
								//查询所有图片名字，如果不重复进行下一步
									String date=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(new Date());
									Random random=new Random();
									int rd=random.nextInt(99999);
									File fullFile=new File(fileName);
									File newfullFile=new File(date+rd+suffix);
									fullFile.renameTo(newfullFile);
									//获取服务器物理uoload/全路径
									String uploadPath=this.getServletContext().getRealPath("upload/");
									File ServeruploadPath=new File(uploadPath);
									if(!ServeruploadPath.exists()){
										ServeruploadPath.mkdirs();
									}
									File uploadFile=new File(uploadPath+"/"+newfullFile.getName());
									
									try {
										item.write(uploadFile);
									} catch (Exception e) {
										e.printStackTrace();
									}
									user.setPicPath(newfullFile.getName());
							}else{
								out.print("<script>alert('文件格式不正确！'); location.href='NewsDetailServlet?i=3'</script>");
								out.flush();
								out.close();
								return;
							}
							
						}else{
							out.print("<script>alert('文件太大了！'); location.href='NewsDetailServlet?i=3'</script>");
							out.flush();
							out.close();
							return;
						}
						}
					}
				}
			}
			int i = Userservice.updateUserById(user);
			if(i!=-1&&i!=0){
				request.getSession().setAttribute("user", user);
				out.print("<script>alert('添加成功！'); self.location=document.referrer;</script>");
				out.flush();
				out.close();
			}else{
				out.print("<script>alert('添加失败！'); self.location=document.referrer;</script>");
				out.flush();
				out.close();
			}
	}
	
	/**
	 * 查询用户，验证登陆
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void findUserByUserFilter(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		User user=new User();
		user.setUserName(userName);
		user.setPassword(passWord);
		int i=Userservice.isExistByName(user);
		if(i==-1){//用户名错误
			out.print("<script>alert('密码错误');self.location=document.referrer;</script>");
			out.flush();
			out.close();
		}else if(i==0){//密码错误
			out.print("<script>alert('用户名错误');self.location=document.referrer;</script>");
			out.flush();
			out.close();
		}else if(i>0){//正确
			request.getSession().setAttribute("user", user);
			out.print("<script>self.location=document.referrer;</script>");
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
		
	}

}
