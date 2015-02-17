package archive;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;


public class opreationsArch {
	static String sql1;
	static String sql2;

	private static PreparedStatement stat;
	private static Connection conn = null;
	private static ResultSet result;

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		
	//	String[] poductNameArray1 = new String[1000];
		//poductNameArray

		Q3();
		sqlquery(sql1);

	}

	/**************************** ( 3 ) *********************************/

	public static void Q3() {
		sql1 = "select * from alldata where Pid = '﻿0002PD5Z3E'";
		//sql2 = "INSERT INTO abbbb (Pid,rating,FirstDate,LastDate, TimeP) VALUES(?,?,?,?,?);";

	}

	public static void sqlquery(String sqlinput)
			throws SQLException {
		System.out.println("-------- you have in your table  ------------\n");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon", "root", "123456");
			stat = conn.prepareStatement(sqlinput);
			result = stat.executeQuery(sqlinput);
			result.first();
			String pid1 = result.getString("Pid");
			int rate1 = result.getInt("rate");
			long time1 = result.getLong("timeP");
			int days1 = result.getInt("days");
			
			int firstime = (int) time1;
			int lastime = (int) time1;

// copy all the element in three arraylist and then copy them in one array 

			ArrayList<Integer> rate_list = new ArrayList<Integer>();
			rate_list.add((int) rate1);
			ArrayList<Integer> time_list = new ArrayList<Integer>();
			time_list.add((int) time1);
			ArrayList<Integer> days_list = new ArrayList<Integer>();
			days_list.add((int) days1);
			System.out.print(pid1 +"\t"+ rate1+"\t" + firstime+"\t" + lastime+"\n");
// get and print the lest of rows
			while (result.next()) {
			
				int rate11 = result.getInt("rate");
				int time11 = (int) result.getLong("timeP");
				int days11 = result.getInt("days");

				int firstime1 = (int) time11;
				int lastime1 = (int) time11;
				
				
			
				rate_list.add((int) rate11);
				days_list.add((int) days11);
				time_list.add((int) time11);

				System.out.print( rate11+"\t"  + firstime1+"\t"  + lastime1+"\n");
			}
			
			int array_size=rate_list.size();
			int[][] dsf = new int[array_size][3];
			
		    for (int i = 0; i < array_size; i++)
		    {
		        dsf[i][0] = rate_list.get(i) ;
		        dsf[i][1] = time_list.get(i) ;
		     	dsf[i][2] = days_list.get(i) ;
		    }
			
			
			
			 for (int i = 0; i < array_size; i++)
			    {
			        System.out.println(dsf[i][0] +"\t"+ dsf[i][1] +"\t"+ dsf[i][2] ) ;
			    }
			
					
			  System.out.println(rate_list.size()+"\t"+time_list.size() +"\t"+days_list.size() ) ;
			
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
			System.out.println("done   **********************");
		}
	}

}
