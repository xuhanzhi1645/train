package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import entity.*;

public class ticketDao {

	public void add(ticket t) {
		String tid=t.getTid();
		LocalDateTime tdate=t.getTdate();
		String tstart=t.getTstart();
		String tend=t.getTend();
		int tprice = t.getTprice();
		int tsurplus = t.getTsurplus();
		String tnumber = t.getTnumber();
		String sql="insert into ticket('"+tid+"','"+tdate+"','"+tstart+"','"+tend+"','"
										+tprice+"','"+tsurplus+"''"+tnumber+"')";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	public void remove(String tid) {
		
		String sql="delete from ticket where tid = '"+tid+"'";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	public void modify(ticket t) {
		String tid=t.getTid();
		LocalDateTime tdate=t.getTdate();
		String tstart=t.getTstart();
		String tend=t.getTend();
		int tprice = t.getTprice();
		int tsurplus = t.getTsurplus();
		String tnumber = t.getTnumber();
		String sql="update ticket set tdate = '"+tdate+"', tstart = '"+tstart+"', tend = '"+tend+"', tprice = '"
												+tprice+"', tsurplus = '"+tsurplus+"', tnumber = '"
												+tnumber+"' where tid = '"+tid+"'";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	//查询，返回一个
	public ticket getbyTid(String tid) {
		DBUtils du=new DBUtils();
		String sql = "select * from ticket where tid = '"+ tid +"'";
		ResultSet rs = du.executeQuery(sql);
		LocalDateTime tdate=null;
		String tstart=null;
		String tend=null;
		int tprice =0;
		int tsurplus =0;
		String tnumber =null;
		try
		{
		    if(rs.next())
		    {
		    	tdate = rs.getTimestamp(2).toLocalDateTime();
		    	tstart = rs.getString(3);
		    	tend = rs.getString(4);
		    	tprice = rs.getInt(5);
		    	tsurplus = rs.getInt(6);
		    	tnumber = rs.getString(7);
		    }
			du.close();
		    return new ticket(tid,tdate,tstart,tend,tprice,tsurplus,tnumber);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	
	}
	// 查询，返回多个
	public List<ticket> gettickets (String sql){
		DBUtils du=new DBUtils();
		ResultSet rs = du.executeQuery(sql);
		List<ticket> ticketList = new ArrayList<>();
		String tid=null;
		LocalDateTime tdate=null;
		String tstart=null;
		String tend=null;
		int tprice =0;
		int tsurplus =0;
		String tnumber =null;
		try
		{
		    while(rs.next())
		    {
		    	tid = rs.getString(1);
		    	tdate = rs.getTimestamp(2).toLocalDateTime();
		    	tstart = rs.getString(3);
		    	tend = rs.getString(4);
		    	tprice = rs.getInt(5);
		    	tsurplus = rs.getInt(6);
		    	tnumber = rs.getString(7);
                ticketList.add (new ticket(tid,tdate,tstart,tend,tprice,tsurplus,tnumber));
		    	
		    	
		    }
			du.close();
		    return ticketList;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	
	}
}
