package copeTables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;

import calculace.slopAndVariance;

public class exportData {
	static String nameoffile = "aaa_product";
	static String nameofcatog = slopAndVariance.nameoffile1;
	static String sql1;

	private static PreparedStatement stat;
	private static PreparedStatement stat2;
	private static Connection conn = null;
	private static ResultSet result;

	// public static void main(String[] args) throws SQLException,
	// ClassNotFoundException, FileNotFoundException,
	// IOException {
	public exportData() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		Q3();
		sqlquery(sql1);

	}

	/**************************** ( 3 ) *********************************/

	public static void Q3() {
		sql1 = "select slop , slopBytheTime ,numberOfrating, variance from aaa_product where catog = '"
				+ nameofcatog + "' and slop>0 and numberOfrating>3;";

	}

	public static void sqlquery(String sqlinput) throws SQLException,
			ClassNotFoundException, FileNotFoundException, IOException {
		System.out.println("-------- you have in your table  ------------\n");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon", "root", "123456");
			// stat = conn.createStatement();
			stat = conn.prepareStatement(sqlinput);
			result = stat.executeQuery(sqlinput);

			String slop11, numbeOfrating, slop22;
			String var;
			String line;

			String fileName1 = "C:/Users/Mshabab/Desktop/analysis/"
					+ nameofcatog + "_analysis.txt";
			File fileOut = new File(fileName1);
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream(fileName1, true), "UTF-8");
			BufferedWriter fbw = new BufferedWriter(writer);

			FileOutputStream streamOut = new FileOutputStream(fileOut);

			while (result.next()) {

				numbeOfrating = result.getString("numberOfrating");

				slop11 = result.getString("slop");
				slop22 = result.getString("slopBytheTime");
				var = result.getString("variance");
				line = numbeOfrating + "\t" + slop11 + "\t" + slop22 + "\t"
						+ var;
				fbw.write(line);
				fbw.newLine();
			}
			streamOut.close();
			fbw.close();

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
