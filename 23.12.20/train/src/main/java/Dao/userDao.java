package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import entity.*;


public class userDao {
	public void add(user u) {
		String uid=u.getUid();
		String uname=u.getUname();
		String upw=u.getUpw();
		String id=u.getId();
		int tel = u.getTel();
		String sql="insert into user values('"+uid+"','"+uname+"','"+upw+"','"+id+"','"+tel+"')";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	public void remove(String uid) {
		
		String sql="delete from user where uid = '"+uid+"'";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	public void modify(user u) {
		String uid=u.getUid();
		String uname=u.getUname();
		String upw=u.getUpw();
		String id=u.getId();
		int tel = u.getTel();
		String sql="update user set uname = '"+uname+"', upw = '"+upw+"', id = '"
					+id+"', tel = '"+tel+"' where uid = '"+uid+"'";
		DBUtils du=new DBUtils();
		du.executeUpdate(sql);
		du.close();
	}
	//查询，返回一个
	public user getbyUid(String uid) {
		DBUtils du=new DBUtils();
		String sql = "select * from user where uid = '"+ uid +"'";
		ResultSet rs = du.executeQuery(sql);
		String uname = null;
		String upw=null;
    	String id = null;
    	int tel = 0;
		try
		{
		    if(rs.next())
		    {
		    	uname = rs.getString(2);
		        upw = rs.getString(3);
		        id = rs.getString(4);
		    	tel = rs.getInt(5);
		    }
			du.close();
		    return new user(uid,uname,upw,id,tel);

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	
	}
	// 查询，返回多个
	public List<user> getusers (String sql){
		DBUtils du=new DBUtils();
		ResultSet rs = du.executeQuery(sql);
		List<user> userList = new ArrayList<>();
		String uid=null;
		String uname=null;
		String upw=null;
		String id = null;
    	int tel = 0;
		try
		{
		    while(rs.next())
		    {
		    	uid = rs.getString(1);
		    	uname = rs.getString(2);
		    	upw = rs.getString(3);
		    	id = rs.getString(4);
		    	tel = rs.getInt(5);
                userList.add (new user(uid,uname,upw,id,tel));
		    	
		    	
		    }
			du.close();
		    return userList;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		
	
	}

}
