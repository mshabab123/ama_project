package user;

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
import java.util.Date;

public class mainUserClass {
	static String sql1;
	static String sql2;
	private static PreparedStatement stat;
	private static PreparedStatement stateupdate;
	public static int numberOfInstance = 6654514; // this must be equal or more
	public static int lastnumber = 0; // than the number of the
	// instance in the text file
	private static Connection conn = null;
	private static ResultSet result2;
	private static String fileName = null;
	private static String[] usersIdArray1 = new String[numberOfInstance];
	private static String sqlinput, sqloutput = null;

	public static void main(String[] args) throws SQLException {

		// number of imtems you want to test
		fileName = "M:/googledrive/workEclipse/ratingPred/users.txt";
		numberOfInstance = numberOfLineINTextFile();
		numberOfLineINTextFile();
		loadDatatoArray();
		int y=4522432;
		
	if (sqlquery(y+0))
		if (sqlquery(y+(250000*1)))	
			if (sqlquery(y+(250000*2)))	
				if (sqlquery(y+(250000*3)))	
					if (sqlquery(y+(250000*4)))	
						if (sqlquery(y+(250000*5)))	
							if (sqlquery(y+(250000*6)))	
								if (sqlquery(y+(250000*7)))	
									if (sqlquery(y+(250000*8)))	
										if (sqlquery(y+(250000*9)))	
											if (sqlquery(y+(250000*10)))	

											
		
		
		
		
		
		;

	}

	/**************************** ( 3 ) *********************************/

	@SuppressWarnings("finally")
	public static boolean sqlquery(int numberofinstance) throws SQLException {

		System.out.println("-------- you statrt the operation  ------------\n");
		   Date date = new Date();
	       System.out.println(date.toString());
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon", "root", "123456");

			for (int ii = numberofinstance; ii < (numberofinstance + 250000); ii++) {

				sqlinput = "select  helpN, helpD,rate,timeP,catog from alldata_users where Uid=  '"
						+ usersIdArray1[ii] + "'";

				stat = conn.prepareStatement(sqlinput);

				result2 = stat.executeQuery(sqlinput);
				result2.first();
				String rate1 = result2.getString("rate");
				String helpN = result2.getString("helpN");
				String time1 = result2.getString("timeP");
				String helpD = result2.getString("helpD");
				String catog = result2.getString("catog");
				// copy all the element in three arraylist and then copy them in
				// one array
				;

				ArrayList<String> rate_list = new ArrayList<String>();
				rate_list.add(rate1);
				ArrayList<String> time_list = new ArrayList<String>();
				time_list.add(time1);
				ArrayList<String> helpN_list = new ArrayList<String>();
				helpN_list.add(helpN);
				ArrayList<String> helpD_list = new ArrayList<String>();
				helpD_list.add(helpD);
				ArrayList<String> catog_list = new ArrayList<String>();
				catog_list.add(catog);
				// rateMpa_list.add(theMPA.calculateTheMPA(Pid,
				// usersIdArray1[ii] )); // get and print the lest of rows
				while (result2.next()) {

					rate1 = result2.getString("rate");
					helpN = result2.getString("helpN");
					time1 = result2.getString("timeP");
					helpD = result2.getString("helpD");
					catog = result2.getString("catog");
					// rateMpa_list.add(theMPA.calculateTheMPA(Pid,
					// usersIdArray1[ii] ));
					rate_list.add(rate1);
					helpN_list.add(helpN);
					time_list.add(time1);
					helpD_list.add(helpD);
					catog_list.add(catog);

				}
				result2.close();

				int array_size = rate_list.size();
				String[][] arrayUserProfile = new String[array_size][6];

				for (int j = 0; j < array_size; j++) {

					arrayUserProfile[j][0] = catog_list.get(j);
					arrayUserProfile[j][1] = helpN_list.get(j);
					arrayUserProfile[j][2] = helpD_list.get(j);
					arrayUserProfile[j][3] = rate_list.get(j);
					arrayUserProfile[j][4] = time_list.get(j);
					// // arrayUserProfile[j][5] = rateMpa_list.get(j);

				}

				// calculate ...
				String result[] = calculation_users
						.calculate_att(arrayUserProfile);

				// this is to insert the result into the database

				sqloutput = "INSERT INTO aa_users (Uid,"
						+ "numberOfratings , numberOfdays , mean ,"
						+ "var,	helpful_pers,	helpful_good,	"
						+ "helpful_bad,	MPE,	catog1,	catogCount1	,"
						+ "catog2	,catogCount2	,catog3	,	catogCount3) "
						+ "VALUES ('"
						+ usersIdArray1[ii]
						+ "', '"
						+ result[0]
						+ "', '"
						+ result[1]
						+ "','"
						+ result[2]
						+ "', '"
						+ result[3]
						+ "', '"
						+ result[4]
						+ "', '"
						+ result[5]
						+ "','"
						+ result[6]
						+ "', '"
						+ result[7]
						+ "', '"
						+ result[8]
						+ "', '"
						+ result[9]
						+ "','"
						+ result[10]
						+ "', '"
						+ result[11]
						+ "', '"
						+ result[12]
						+ "', '"
						+ result[13] + "');";

				stateupdate = conn.prepareStatement(sqloutput);
				stateupdate.executeUpdate(sqloutput);

				lastnumber = ii;
				if (ii%5000==0) System.out.println(ii);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Hi mshabab, your drive not found");
			System.out.println(lastnumber);
			return false;
		} catch (SQLException ef) {
			System.out.println(ef);
			System.err
					.println("There is problem in the sql query and reslut set");
			System.out.println(lastnumber);
			System.exit(0);
			return false;
		} finally

		{
			for (SQLWarning w = stat.getWarnings(); w != null; w = w
					.getNextWarning())
					System.err.println("WARNING: " + w.getMessage());

			System.out.println(lastnumber);

			System.out.println("done   **********************");
			return true;
		}
	}

	// number of line in the text file

	static int numberOfLineINTextFile() {
		@SuppressWarnings("unused")
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

	static void loadDatatoArray() {
		String line = null;
		int i = 0;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				usersIdArray1[i] = line;
				i++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

}
