package Assignment9;

import java.sql.*; 
import java.util.*;
public class Product_2 {
	 public static void main(String a[]) 
	    { 
		 	Scanner scan=new Scanner(System.in);
	        //Creating the connection 
	        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	        String user = "DXC"; 
	        String pass = "123"; 
	        System.out.println("Enter the product code");
	        int pCode=scan.nextInt();
	        Connection con=null; 
	        String sql="select * from PRODUCTS where PRODUCT_CODE="+pCode;
	        try
	        { 
	            DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
	  
	           
	            con = DriverManager.getConnection(url,user,pass); 
	  
	            Statement st = con.createStatement(); 
	            ResultSet result=st.executeQuery(sql);
	            
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
	        scan.close();
	    } 
	} 