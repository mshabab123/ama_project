package calculace;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;

import copeTables.exportData;

public class slopAndVariance {
	static String nameoffile = "home_kitchen";
	public static String nameoffile1 = "aaa_product";
	static String sql1;
	static String sql2;

	private static PreparedStatement stat;
	private static PreparedStatement stat2;
	private static Connection conn = null;
	private static ResultSet result;

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		Q3();
		sqlquery(sql1, sql2);
		exportData exdata= new exportData();

	}

	/**************************** ( 3 ) *********************************/

	public static void Q3() {
		sql1 = "select * from " + nameoffile + " ;";
		sql2 = "INSERT INTO abbbb (Pid,rating,FirstDate,LastDate, TimeP) VALUES(?,?,?,?,?);";

	}

	public static void sqlquery(String sqlinput, String sqloutput)
			throws SQLException {
		System.out.println("-------- you have in your table  ------------\n");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon", "root", "123456");
			// stat = conn.createStatement();
			stat = conn.prepareStatement(sqlinput);
			result = stat.executeQuery(sqlinput);
			stat2 = conn.prepareStatement(sqloutput);

			String pid1, pid2 = null;
			float rate1, rate2 = 0;
			int rankoutput = 1;
			int mm = 0;
			int sumOfInstance = 1;
			double avge = 0;
			double time1 = 0, time2 = 0, time1Squer = 1, time2Squer2 = 1;
			double xy1, xy2 = 0;
			double slope, slope2 = 0;
			float xySafe1, xySafe2, y = 1;
			float sumOfy = 1;
			float sumOfySquer = 1;
			double var1 = 0, var2 = 0;
			float x[];
			int firstime1, firstime = 0, lifetime;
			int lastime1 = 0, lastime = 0;

			result.first();
			pid1 = result.getString("Pid");
			rate1 = result.getInt("rate");
			time1 = result.getLong("timeP");
			firstime = (int) time1;
			lastime = (int) time1;

			time1Squer = time1 * time1;
			xy1 = time1 * rate1;
			xySafe1 = y * rate1;

			ArrayList<Integer> variList = new ArrayList<Integer>();
			variList.add((int) rate1);

			while (result.next()) {
				mm++;
				pid2 = result.getString("Pid");
				rate2 = result.getInt("rate");
				time2 = result.getLong("timeP");
				xy2 = time2 * rate2;
				time2Squer2 = time2 * time2;
				firstime1 = (int) time2;
				lastime1 = (int) time2;
				if (pid1.equalsIgnoreCase(pid2)) {
					variList.add((int) rate2);
					sumOfInstance++;
					sumOfy = sumOfy + sumOfInstance;
					xy1 = xy1 + xy2;
					xySafe2 = sumOfInstance * rate2;

					xySafe1 = xySafe1 + xySafe2;
					time1 = time1 + time2;
					rate1 = rate1 + rate2;
					time1Squer = time2Squer2 + time1Squer;
					sumOfySquer = sumOfySquer + sumOfInstance * sumOfInstance;
					lastime = (int) time2;

				} else {
					avge = rate1 / sumOfInstance;
					// calculate the slop by the tiem
					slope = (((sumOfInstance * xy1) - (time1 * rate1)) / ((sumOfInstance * time1Squer) - (time1 * time1)));
					// calcualte the slope accuring the arraival rating
					slope2 = (((sumOfInstance * xySafe1) - (sumOfy * rate1)) / ((sumOfInstance * sumOfySquer) - (sumOfy * sumOfy)));

					for (int i = 0; i < variList.size(); i++) {
						var2 = Math.pow((variList.get(i)), 2);
						var1 = var1 + var2;

					}
					var2 = (var1 / sumOfInstance) - (avge * avge);
					variList.clear();
					if (Double.isNaN(slope)) {
						slope = 0;
					}
					;
					if (Double.isNaN(slope2)) {
						slope2 = 0;
					}
					;
					System.out.println(mm + ";\t" + pid1 + ";\t "
							+ sumOfInstance + ";\t" + slope2 + ";\t" + slope
							+ ";\t" + ";\t" + var2 + ";\t" + firstime + ";\t"
							+ lastime);

                    lifetime= lastime-firstime;
                    
                    stat2.executeUpdate("UPDATE `amazon`.`aaa_product` SET `slop`="+
                    slope2+", `slopBytheTime`="+ slope +
                                        ", `variance`=" + var2 +", `numberOfrating`="+ sumOfInstance+", `lifeTime`="+ lifetime+", `start`="+firstime+", `last`="+lastime+" WHERE `Pid`= '"+pid1+"' and`catog`='"+nameoffile+"';\n");

                    
                    

					pid1 = pid2;
					firstime = firstime1;
					lastime = lastime1;
					rate1 = rate2;
					time1 = time2;
					sumOfy = 1;
					sumOfySquer = 1;
					var1 = 0;
					var2 = 0;
					time1Squer = time1 * time1;
					xy1 = xy2;
					xySafe1 = rate2;
					variList.add((int) rate2);

					rankoutput++;
					sumOfInstance = 1;
					firstime = firstime1;

				}

			}
			System.out.print("\n");
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
