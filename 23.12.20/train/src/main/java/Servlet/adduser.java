package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.userDao;
import entity.user;

/**
 * Servlet implementation class adduser
 */
@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String from = request.getParameter("from");
		if(from.equals("adduser"))//添加用户，要用的话可以在前端加一个键
		{
			
			String uid = request.getParameter("uid");
			String uname = request.getParameter("uname");
			String upw = request.getParameter("upw");
			String id = request.getParameter("id");
			int tel = Integer.parseInt(request.getParameter("tel"));
			userDao dao = new userDao();
			userDao dao2 = new userDao();
			List<user> userList = dao2.getusers("select * from user");
			String id2;
			int flag=0;
			for(int i = 0;i<userList.size();i++)
			{
				
				id2=userList.get(i).getId();
				if(id2.equals(id))
				{
					flag=1;
				}
			}
			if(flag==0)
			{
				dao.add(new user(uid,uname,upw,id,tel));
				response.sendRedirect("user.jsp");
			}
			else if(flag==1)
			{
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script language='javascript'>alert('添加失败，用户id已在数据库中存在！');window.location.href='employee.jsp';</script>");
			}
		}
		else if (from.equals("modifyuser"))//修改用户信息
		{
			
			String uid = request.getParameter("uid");
			String uname = request.getParameter("uname");
			String upw = request.getParameter("upw");
			String id = request.getParameter("id");
			int tel = Integer.parseInt(request.getParameter("tel"));
			userDao dao = new userDao();
			dao.modify(new user(uid,uname,upw,id,tel));
			response.sendRedirect("user.jsp");
		}
		else if (from.equals("removeuser"))//注销用户
		{
			String uid = request.getParameter("uid");
			userDao dao = new userDao();
			dao.remove(uid);
			response.sendRedirect("user.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
