package products;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;

public class opreations {
	static String sql1;
	static String sql2;
	static int numberofGarbugeCollectionTigger = 0;
	private static PreparedStatement stat;
	private static PreparedStatement stateupdate;
	public static int numberOfInstance = 2354514; // this must be equal or more
													// than the number of the
													// instance in the text file
	private static Connection conn = null;
	private static ResultSet result;
	private static String fileName = null;
	private static String[] poductNameArray1 = new String[numberOfInstance];
	private static String sqlinput, sqloutput = null;

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, FileNotFoundException, IOException {

		fRationTable rationTable = new fRationTable();

		// numberOfInstatnce = 400; // this must be change according to the
		// number of
		// imtems you want to test
		fileName = "M:/googledrive/workEclipse/ratingPred/productsName.txt";
		numberOfInstance = numberOfLineINTextFile();
		numberOfLineINTextFile();
		sortDatatoArray();
		sqlquery(1499995);

		// / use this method after testing it
		// System.exit(0);// use it in the sql thresd 
		// do the thread and store it in file text

	}

	/**************************** ( 3 ) *********************************/

	public static void sqlquery(int numberoofinstance) throws SQLException {
		System.out.println("-------- you have in your table  ------------\n");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon", "root", "123456");
			System.out
					.println("row number \t\tslope\t r \t\t mean\t\t vair\t\t heter05\t\thetro10");

			for (int ii = numberoofinstance; ii < (numberoofinstance + 500000); ii++) {

				sqlinput = "select * from alldata where Pid= '"
						+ poductNameArray1[ii] + "'";

				stat = conn.prepareStatement(sqlinput);
				result = stat.executeQuery(sqlinput);
				result.first();
				String pid1 = result.getString("Pid");
				int rate1 = result.getInt("rate");
				int days1 = result.getInt("days");
				int time1 = result.getInt("timeP");
				String catog = result.getString("catog");

				// copy all the element in three arraylist and then copy them in
				// one array

				ArrayList<Integer> rate_list = new ArrayList<Integer>();
				rate_list.add((int) rate1);
				ArrayList<Integer> days_list = new ArrayList<Integer>();
				days_list.add((int) days1);
				ArrayList<Integer> time_list = new ArrayList<Integer>();
				time_list.add((int) time1);

				// get and print the lest of rows
				while (result.next()) {

					rate1 = result.getInt("rate");
					days1 = result.getInt("days");
					time1 = result.getInt("timeP");

					rate_list.add((int) rate1);
					days_list.add((int) days1);
					time_list.add((int) time1);

				}
				if (rate_list.size() > 3) { // condition about the number of
											// rating must be more than 3
					int array_size = rate_list.size();
					int[][] dsf = new int[array_size][3];

					for (int j = 0; j < array_size; j++) {
						dsf[j][0] = rate_list.get(j);
						dsf[j][1] = days_list.get(j);
						dsf[j][2] = time_list.get(j);
					}

					// calculate the slope
					float result[] = calculateClass.calculate_slope(dsf);
					System.out.println(poductNameArray1[ii] + "\t\t" + ii);
					// this is to insert the result into the database

					sqloutput = "INSERT INTO aa_product (Pid,  catog ,slop,r_square,mean,var,hetro05,htero10,slope_time,r_square_time,frist_time,last_time,numberofday,n) VALUES ('"
							+ poductNameArray1[ii]
							+ "', '"
							+ catog
							+ "','"
							+ result[0]
							+ "', '"
							+ result[1]
							+ "', '"
							+ result[2]
							+ "','"
							+ result[3]
							+ "', '"
							+ result[4]
							+ "', '"
							+ result[5]
							+ "', '"
							+ result[6]
							+ "','"
							+ result[7]
							+ "', '"
							+ result[8]
							+ "', '"
							+ result[9]
							+ "','"
							+ result[10] + "', '" + result[11] + "');";

					stateupdate = conn.prepareStatement(sqloutput);
					stateupdate.executeUpdate(sqloutput);

				}// end of if condition about the number of rating must be more
					// than 3

			}

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

	// number of line in the text file

	static int numberOfLineINTextFile() {
		String line = null;

		int numberOfline = 0;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				numberOfline++;

			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
		return numberOfline;
	}

	static void sortDatatoArray() {
		String line = null;
		int i = 0;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				poductNameArray1[i] = line;
				i++;
			}
			bufferedReader.close();
			System.out.print(numberOfInstance + "\t" + poductNameArray1.length);
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

}
