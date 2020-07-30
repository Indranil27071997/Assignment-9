package Assignment9;

import java.sql.SQLException;
import java.util.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Product_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		String pCode;
		String pName;
		String pPrice;
		String pCat;
		ArrayList<Product_0> product = new ArrayList<>();

		while (true) {
			System.out.println("Press any key to input values, -1 to exit");

			input = sc.nextLine();

			if (input.equals("-1")) {
				break;
			} else {
				System.out.println("Enter Product Code");
				pCode = sc.next();
				sc.nextLine();
				System.out.println("Enter Product Name");
				pName = sc.next();
				sc.nextLine();
				System.out.println("Enter Product Price");
				pPrice = sc.next();
				sc.nextLine();
				System.out.println("Enter Product Category");
				pCat = sc.next();
				sc.nextLine();
				product.add(new Product_0(pCode, pName, pPrice, pCat));

			}
		}

		try {
			JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("DXC");
			rs.setPassword("123");
			rs.setCommand("select PRODUCT_CODE,PRODUCT_NAME,PRODUCT_PRICE,PRODUCT_CATG from PRODUCTS");
			rs.execute();
			// Update

			for (int i = 0; i < product.size(); i++) {
				Product_0 data = product.get(i);

				String pCode1 = data.getpCode();
				String pName1 = data.getpName();
				String pPrice1 = data.getpPrice();
				String pCat1 = data.getpCat();
				rs.afterLast();
				rs.moveToInsertRow();
				rs.updateString("PRODUCT_CODE", pCode1);
				rs.updateString("PRODUCT_NAME", pName1);
				rs.updateString("PRODUCT_PRICE", pPrice1);
				rs.updateString("PRODUCT_CATG", pCat1);
				rs.insertRow();
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