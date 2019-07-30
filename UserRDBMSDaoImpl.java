package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nucleus.connection.ConnectionClass;
import com.nucleus.model.User;

public class UserRDBMSDaoImpl implements IUserDao {

	ConnectionClass con1=new ConnectionClass();
	Connection con=con1.getDbConnection();
	
	@Override
	public void insertDetails(User user)
	{
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into user00 values(?,?,?,?)");
		pstmt.setString(1,user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getUserName());
		pstmt.setString(4, user.getGender());
		pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean checkValidUser(User user) {
		int flag=-1;
		try {
			PreparedStatement pstmt=con.prepareStatement("select uid from user00 where uid=?");
			pstmt.setString(1, user.getUserId());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				flag=1;
				break;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if(flag==1)
			return false;
		else
			return true;
		
		
	}

	@Override
	public boolean checkValidLogin(User user) {
		String a=null,b=null;
		try {
			PreparedStatement pstmt=con.prepareStatement("select uid,pwd from user00 where uid=?");
			pstmt.setString(1, user.getUserId());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				a=rs.getString(1);
				b=rs.getString(2);
			}
			
			
		} catch (SQLException e) {
		   
			e.printStackTrace();
			  return false;
		}
		if(user.getUserId().equals(a) && user.getPassword().equals(b))
			return true;
			else
				return false;
		
	}

}
