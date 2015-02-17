import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Date;

public class allinonearray {

	private static String fileName = null;
	private static int numberOfInstance;

	private static String[][] usersIdArray1 = new String[15431560][4];

	public static void main(String[] args) throws IOException {

		fileName = "alldata.txt";

		numberOfInstance = numberofline();

		loadDatatoArray();

		Date date = new Date();
		System.out.println(date.toString());

		// plain old for loop for searching elements in Java array
		String Uid = "c";

		for (int i = 0; i < 15431559; i++) {
			if (usersIdArray1[i][0].equals(Uid)) {
				System.out
						.println("Found elements in Java array using for loop"+  usersIdArray1[i][0]+"\t"+usersIdArray1[i][1]+"\t"+usersIdArray1[i][2]);

			}
		}
		
		Uid = "A24TA8P9PR25BT";
		for (int i = 0; i < 15431559; i++) {
			if (usersIdArray1[i][0].equals(Uid)) {
				System.out
						.println("Found elements in Java array using for loop"+  usersIdArray1[i][0]+"\t"+usersIdArray1[i][1]+"\t"+usersIdArray1[i][2]);

			}
		}
		
		
		
		
		Uid = "AM9CAM6XHYU35";
		for (int i = 0; i < 15431559; i++) {
			if (usersIdArray1[i][0].equals(Uid)) {
				System.out
						.println("Found elements in Java array using for loop"+  usersIdArray1[i][0]+"\t"+usersIdArray1[i][1]+"\t"+usersIdArray1[i][2]);

			}
		}
		
		
		

		Date date1 = new Date();
		System.out.println(date1.toString());

	}

	static int numberofline() throws IOException {

		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(
				fileName)));
		lnr.skip(Long.MAX_VALUE);
		System.out.println(1 + lnr.getLineNumber());

		// Finally, the LineNumberReader object should be closed to prevent
		// resource leak
		lnr.close();

		return 1 + lnr.getLineNumber();

	}

	static void loadDatatoArray() {
		int i = 0;
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				String[] information = line.split("\t");
				usersIdArray1[i][0] = information[1];
				usersIdArray1[i][1] = information[4];
				usersIdArray1[i][2] = information[7];

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
