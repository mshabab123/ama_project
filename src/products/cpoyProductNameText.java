package products;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;


public class cpoyProductNameText {
	static String sql1;
	static String sql2;

	private static PreparedStatement stat;
	private static Connection conn = null;
	private static ResultSet result;

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		//long startTime = System.nanoTime();

		
		sql1 = "SELECT distinct Pid FROM alldata limit 1000  ;";
		sqlquery(sql1);

		// to count the time of this opration 
		//code
	//	long endTime = System.nanoTime();
	//	System.out.println("Took "+(endTime - startTime) + " ns"); 
			
		
		
	}



	public static void sqlquery(String sqlinput)
			throws SQLException, IOException {
		

		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/amazon?connectTimeout=0&socketTimeout=0&autoReconnect=true" , "root", "123456");
			
			stat = conn.prepareStatement(sqlinput);
			result = stat.executeQuery(sqlinput);
			result.first();
			String pid1 = result.getString("Pid");
			
	String fileName1 = "M:/workEclipse/ratingPred/productsName.txt";
	    FileWriter fileWriter = new FileWriter(fileName1);
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			
			
			
			
			
			

// copy all the element in three arraylist and then copy them in one array 

			ArrayList<String> products_name = new ArrayList<String>();
			products_name.add(pid1);

			
			bufferedWriter.write(pid1);
			bufferedWriter.newLine();
		    System.out.println(pid1);
	            			

// get and print the lest of rows
			while (result.next()) {
			
				pid1 = result.getString("Pid");

				products_name.add(pid1);
				
				
					
			 	bufferedWriter.write(pid1);
			 	bufferedWriter.newLine();
			    System.out.println(pid1);
		            			
				
			
			}

			bufferedWriter.close();
			 System.out.println(products_name.size());
			
		
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Hi mshabab, your drive not found");
			return;
		} catch (SQLException ef) {
			System.out.println(ef);
			System.err
					.println("There is problem in the sql query and reslut set");
			return;
		} finally

		{
			for (SQLWarning w = stat.getWarnings(); w != null; w = w
					.getNextWarning())
				System.err.println("WARNING: " + w.getMessage());
			result.close();
			stat.close();
			conn.close();
			
			System.out.println("we get all the products' names  **********************");
		}
	}

}
