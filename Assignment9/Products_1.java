package Assignment9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class Products_1 {
	 public static void main(String a[]) 
	    { 
	        //Creating the connection 
	        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	        String user = "DXC"; 
	        String pass = "123"; 
	  
	       
	  
	        
	        Connection con=null; 
	        String command="select * from PRODUCTS";
	        try
	        { 
	            DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
	  
	           
	            con = DriverManager.getConnection(url,user,pass); 
	  
	            Statement st = con.createStatement(); 
	            ResultSet result=st.executeQuery(command);
	            
	          while(result.next()) {
	        	  System.out.println(result.getString("PRODUCT_CODE") +":"+result.getString("PRODUCT_NAME")+":"+result.getString("PRODUCT_PRICE")+":"+result.getString("PRODUCT_CATG"));
	          }
	        	  
	           
	        } 
	        catch(Exception ex) 
	        { 
	            System.err.println(ex); 
	        } 
	        finally {
	        	 
	        	try{
	        		con.close(); 
	        	}
	        	catch(SQLException e) {
	        		System.out.println(e);
	        	}
			}
	    } 
	} 