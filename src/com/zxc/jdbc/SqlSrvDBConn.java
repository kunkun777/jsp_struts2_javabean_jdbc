package com.zxc.jdbc;
import java.sql.*;

public class SqlSrvDBConn {
	private Statement stmt;
    private Connection conn;
    ResultSet rs;

    public SqlSrvDBConn(){
    	stmt=null;
    	try{
            Class.forName("com.mysql.jdbc.Driver");
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT&useUnicode=true&characterEncoding=utf8","root","330124");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	rs=null;
    }

    public ResultSet executeQuery(String sql)
    {
        try
        {
        	stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	rs=stmt.executeQuery(sql);
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;
    }

    public void closeStmt()
    {
        try
        {
            stmt.close();
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
    public void closeConn()
    {
        try
        {
            conn.close();
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
}
