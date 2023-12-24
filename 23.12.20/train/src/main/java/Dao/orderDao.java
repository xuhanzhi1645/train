package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import entity.*;

public class orderDao {
	
	public void add(order o) {
		String oid=o.getOid();
		String uid=o.getUid();
		String tid=o.getTid();
		String ostatus=o.getOstatus();
		String sql="insert into order('"+oid+"','"+uid+"','"+tid+"','"+ostatus+"')";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	public void remove(String oid) {
		String sql="delete from order where oid = '"+oid+"'";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	public void modify(order o) {
		String oid=o.getOid();
		String uid=o.getUid();
		String tid=o.getTid();
		String ostatus=o.getOstatus();
		String sql="update order set uid = '"+uid+"', tid = '"+tid+"', ostatus = '"+ostatus+"' where oid = '"+oid+"'";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}//查询，返回一个
	public order getbyOid(String oid) {
		DBUtils du=new DBUtils();
		String sql = "select * from order where oid = '"+ oid +"'";
		ResultSet rs = du.executeQuery(sql);
		String uid = null;
		String tid = null;
    	String ostatus = null;
		try
		{
		    if(rs.next())
		    {
		    	uid = rs.getString(2);
		        tid = rs.getString(3);
		        ostatus = rs.getString(4);
		    }
			du.close();
		    return new order(oid,uid,tid,ostatus);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	
	}
	// 查询，返回多个
	public List<order> getorders (String sql){
		DBUtils du=new DBUtils();
		ResultSet rs = du.executeQuery(sql);
		List<order> orderList = new ArrayList<>();
		String oid=null;
		String uid=null;
		String tid=null;
		String ostatus = null;
		try
		{
		    while(rs.next())
		    {
		    	oid = rs.getString(1);
		    	uid = rs.getString(2);
		    	tid = rs.getString(3);
		    	ostatus = rs.getString(4);
                orderList.add (new order(oid,uid,tid,ostatus));
		    	
		    	
		    }
			du.close();
		    return orderList;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	
	}

}
