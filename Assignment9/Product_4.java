package Assignment9;

import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
public class Product_4 {

	public static void main(String[] args) {
		double price;
		try {
			JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("DXC");
			rs.setPassword("123");
			rs.setCommand("select PRODUCT_CODE,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CATG from PRODUCTS");
			rs.execute();
			// Update
			rs.beforeFirst();
			while (rs.next()) {
				price=Double.parseDouble(rs.getString("PRODUCT_PRICE"));
				if(price<1000&&rs.getString("PRODUCT_CATG").equals("Electronics"))
				{
					price=(price/10)+price;
					rs.updateString("PRODUCT_PRICE",Double.toString(price));
					rs.updateRow();
				}
				if(price>1000&&rs.getString("PRODUCT_CATG").equals("Clothing"))
				{
					price=price-(price/10);
					rs.updateString("PRODUCT_PRICE",Double.toString(price));
					rs.updateRow();
				}
			}
			
			

			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString("PRODUCT_CODE") + ":" + rs.getString("PRODUCT_NAME") + ":"
						+ rs.getString("PRODUCT_PRICE") + ":" + rs.getString("PRODUCT_CATG"));
				
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
