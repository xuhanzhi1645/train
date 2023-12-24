package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ticketDao;
import entity.ticket;

/**
 * Servlet implementation class addticket
 */
@WebServlet("/addticket")
public class addticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addticket() {
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
		if(from.equals("addticket"))
		{
			
			String tid = request.getParameter("tid");
			String tdateStr = request.getParameter("tdate");  // 假设前端传递的日期时间字符串是 "yyyy-MM-dd HH:mm:ss"
			// 将日期时间字符串解析为 LocalDateTime 对象
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime tdate = LocalDateTime.parse(tdateStr, formatter);
			String tstart = request.getParameter("tstart");
			String tend = request.getParameter("tend");
			int tprice = Integer.parseInt(request.getParameter("tprice"));
			int tsurplus = Integer.parseInt(request.getParameter("tsurplus"));
			String tnumber = request.getParameter("tnumber");
			ticketDao dao = new ticketDao();
			ticketDao dao2 = new ticketDao();
			List<ticket> ticketList = dao2.gettickets("select * from ticket");
			String id2;
			int flag=0;
			for(int i = 0;i<ticketList.size();i++)
			{
				
				id2=ticketList.get(i).getTid();
				if(id2.equals(tid))
				{
					flag=1;
				}
			}
			if(flag==0)
			{
				dao.add(new ticket(tid,tdate,tstart,tend,tprice,tsurplus,tnumber));
				//response.sendRedirect("ticket.jsp");
			}
			else if(flag==1)
			{
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script language='javascript'>alert('添加失败，车票id重复！');window.location.href='ticket.jsp';</script>");
			}
		}
		else if (from.equals("modifyticket"))
		{
			String tid = request.getParameter("tid");
			String tdateStr = request.getParameter("tdate");  // 假设前端传递的日期时间字符串是 "yyyy-MM-dd HH:mm:ss"
			// 将日期时间字符串解析为 LocalDateTime 对象
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime tdate = LocalDateTime.parse(tdateStr, formatter);
			String tstart = request.getParameter("tstart");
			String tend = request.getParameter("tend");
			int tprice = Integer.parseInt(request.getParameter("tprice"));
			int tsurplus = Integer.parseInt(request.getParameter("tsurplus"));
			String tnumber = request.getParameter("tnumber");
			ticketDao dao = new ticketDao();
			dao.modify(new ticket(tid,tdate,tstart,tend,tprice,tsurplus,tnumber));
			response.sendRedirect("ticket.jsp");
		}
		else if (from.equals("removeticket"))
		{
			String tid = request.getParameter("tid");
			ticketDao dao = new ticketDao();
			dao.remove(tid);
			response.sendRedirect("ticket.jsp");
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

