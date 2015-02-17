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

public class userMPAproducer {
	static String sql1, varMPA = null;
	static String sql2;
	private static PreparedStatement stat22;
	private static PreparedStatement stateupdate;

	private static String fileName = null;
	public static int numberOfInstance = 6654514; // this must be equal or more
	private static String[] usersIdArray1 = new String[numberOfInstance];

	private static Connection conn = null;
	private static ResultSet result, resultPid;
	private static String sqlinputGetTheRate, sqlinputGetTheRatePid;

	public static void main(String[] args) throws SQLException {

		fileName = "M:/googledrive/workEclipse/ratingPred/users.txt";
		numberOfInstance = numberOfLineINTextFile();
		numberOfLineINTextFile();
		loadDatatoArray();

		calculateTheMPA(6013948);
		calculateTheMPA(6213948);
		calculateTheMPA(6413948);
		calculateTheMPA(6613948);

	}

	public static void calculateTheMPA(int numberofinstance)
			throws SQLException {
		String rate_user = "0";
		float PidAvrage = 0;
		float userTruth = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon", "root", "123456");
			// 1) select all the products that a user rated in
			for (int ii = numberofinstance; ii < (numberofinstance + 200000); ii++) {
				sqlinputGetTheRate = "select Pid, rate from alldata_users where Uid= '"
						+ usersIdArray1[ii] + "'";
				stat22 = conn.prepareStatement(sqlinputGetTheRate);
				result = stat22.executeQuery(sqlinputGetTheRate);

				result.first();
				String rate1 = result.getString("rate");
				String Pid = result.getString("Pid");

				ArrayList<String> rate_list = new ArrayList<String>();
				rate_list.add(rate1);
				ArrayList<String> Pid_list = new ArrayList<String>();
				Pid_list.add(Pid);

				while (result.next()) {
					rate1 = result.getString("rate");
					Pid = result.getString("Pid");
					rate_list.add(rate1);
					Pid_list.add(Pid);
				}
				// 2) for each one of those product find his rating and find by
				// suing 'PidAvrage' the avarge of
				// all ratings for each products.
				for (int j = 0; j < rate_list.size(); j++) {

					sqlinputGetTheRatePid = "select rate, Uid from alldata where Pid= '"
							+ Pid_list.get(j) + "'";

					resultPid = stat22.executeQuery(sqlinputGetTheRatePid);
					resultPid.first();
					String ratePid = resultPid.getString("rate");
					String Uid = resultPid.getString("Uid");

					PidAvrage = Float.parseFloat(ratePid);
					int intPid = 1;
					if (Uid.equals(usersIdArray1[ii]))
						rate_user = ratePid;

					while (resultPid.next()) {
						ratePid = resultPid.getString("rate");
						PidAvrage += Float.parseFloat(ratePid);
						Uid = resultPid.getString("Uid");
						if (Uid.equals(usersIdArray1[ii]))
							rate_user = ratePid;
						intPid++;
					}
					resultPid.close();
					// 3) this will accumulate the user frank : in general it
					// find the square of difference  between the user score
					// and the mean of the product, then multiply by the number
					// of users inputed in this
					// product
					PidAvrage = (float) Math.pow(
							(PidAvrage / intPid) - Float.parseFloat(rate_user),
							2);

					userTruth += PidAvrage * intPid / rate_list.size();

				}

				System.out.println(usersIdArray1[ii] + "\t" + ii);

				// String sqloutput =
				// "UPDATE `amazon`.`aaa_users` SET `MPE`='"+userTruth+"' WHERE `Uid`='"+usersIdArray1[ii]+"';";

				String sqloutput = "INSERT INTO aaa_mpa_users (Uid,numberOfratings, MPE) VALUES ('"
						+ usersIdArray1[ii]
						+ "', '"
						+ rate_list.size()
						+ "', '" + userTruth + "');";

				stateupdate = conn.prepareStatement(sqloutput);
				stateupdate.executeUpdate(sqloutput);

				userTruth = 0;

			}

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

			conn.close();

		}
	}

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