package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;

public class theMPA {
	static String sql1, varMPA= null;
	static String sql2;
	private static PreparedStatement stat22;

	private static Connection conn1 = null;
	private static ResultSet result;
	private static String sqlinputGetTheRate;

	public static void main(String[] args) throws SQLException {

		String mshaab =calculateTheMPA("B003INBOEM","A0017882XAS5VJGSZF5R");
		System.out.println(mshaab);

	}

	@SuppressWarnings("finally")
	public static String calculateTheMPA(String Pid, String Uid) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/amazon",
							"root", "123456");
			float sumOfrates = 0;
			int i = 1;
			sqlinputGetTheRate = "select Uid, rate from alldata where Pid= '" + Pid
					+ "'";

			stat22 = conn1.prepareStatement(sqlinputGetTheRate);
				String rate_user = "0";
			result = stat22.executeQuery();
			result.first();
			String rate1 = result.getString("rate");
			String Uid1 = result.getString("Uid");
			sumOfrates = sumOfrates + Integer.parseInt(rate1);
			if(Uid.equals(Uid1)) rate_user= rate1; 
			// get and print the lest of rows
			while (result.next()) {
				rate1 = result.getString("rate");
				Uid1 = result.getString("Uid");
				sumOfrates = sumOfrates + Integer.parseInt(rate1);
				if(Uid1.equals(Uid)) rate_user= rate1; 
				i++;
			}
			result.close();

			sumOfrates = sumOfrates / i;
			
			varMPA = String.valueOf((float) Math.pow(sumOfrates- ( Integer.parseInt(rate_user)),2)*i);
		
	
			
		} catch (ClassNotFoundException e) {
			System.out.println("Hi mshabab, your drive not found");
		
		} catch (SQLException ef) {
			System.out.println(ef);
			System.err
					.println("There is problem in the sql query and reslut set");
	
		} finally

		{
			for (SQLWarning w = stat22.getWarnings(); w != null; w = w
					.getNextWarning())
				System.err.println("WARNING: " + w.getMessage());
			stat22.close();
			conn1.close();
			return varMPA;


		}
	}
}
