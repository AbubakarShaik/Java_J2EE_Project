package com.testprojectDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xerces.internal.util.Status;
import com.testbean.Employee;

public class DAOoperations {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public DAOoperations(){
	
	conn=DataBaseConnection.getInstance().Connection;
	}
	
	public int InsertData(Employee emp){
		
		int result=0;
		
		String query="insert into employe values(?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getMailId());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getConformPassword());
			ps.setInt(5, emp.getMobileNumber());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		}
	
	public  boolean login(String Mail_Id,String password){
		
		boolean result=false;
		
		String query=("select * from employe where Mail_Id=?,password=?");
		Employee empbean=new Employee();
		
		try {
			ps.setString(1, empbean.getMailId());
			ps.setString(2, empbean.getPassword());
			
			 rs=ps.executeQuery();
			 result=rs.next();
			 
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				if(ps!=null){
					
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					if(rs!=null){
						
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}						
					}
				}				
			}
		}
		return result;		
	}
}
