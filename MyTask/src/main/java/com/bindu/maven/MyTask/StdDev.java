package com.bindu.maven.MyTask;


import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement; 

public class StdDev {

	 static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:test";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
	  
	   public static void main(String[] args) throws ClassNotFoundException { 
	     //Connection conn = null; 
	      Statement stmt = null; 
	      Class.forName("org.h2.Driver");
	      try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test","sa",""); 
	              Statement stat = conn.createStatement()) {
	    	 // if(conn!=null) conn.close(); 
	          //stat.execute("create table test(id int primary key, name varchar(255))");
	          //stat.execute("insert into test values(1, 'Hello')");
	          try (ResultSet rs = stat.executeQuery("select stddev(SAMPLE) std_dev from MYTASK where ID between 1 and 1000;")) {
	              while (rs.next()) {
	                  System.out.println(rs.getString("std_dev"));
	              }
	          }
	          if(conn!=null) conn.close(); 
	      } catch (Exception e) {
	          e.printStackTrace();
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
//         try { 
//            if(conn!=null) conn.close(); 
//         } catch(SQLException se){ 
//            se.printStackTrace(); 
//	         } //end finally try 
	      } //end try 
	      //System.out.println("Goodbye!");
	   } 

}
