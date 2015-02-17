package archive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Date;

public class loaddatafrombynaryfile {

	private static String fileName = null;
	private static int numberOfInstance;

	private static String[] usersIdArray1 = new String[6605322];
	private static String[] numboerOfratings = new String[6605322];
	private static String[] catog = new String[6605322];


	public static void main(String[] args) throws IOException {
		   Date date = new Date();
	       System.out.println(date.toString());
		fileName = "M:/googledrive/workEclipse/ratingPred/data/aa_users";

		numberOfInstance= numberofline();



			loadDatatoArray();
			
		
			System.out.println(usersIdArray1[100]+"\t"+numboerOfratings[100]+"\t"+catog[100]);
			
			
			
			
			
	}

	static int numberofline() throws IOException {

		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(
				fileName)));
		lnr.skip(Long.MAX_VALUE);
		System.out.println(1+lnr.getLineNumber());
		
		// Finally, the LineNumberReader object should be closed to prevent
		// resource leak
		lnr.close();
		
		return 1+lnr.getLineNumber();

		
		

				
				

	}

	static void loadDatatoArray() {
		int i = 0;
		String line = null;
		

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				 String[] information = line.split("\t");
				System.arraycopy(information, 0, usersIdArray1, i, 1);
				System.arraycopy(information, 1, numboerOfratings, i, 1);
				System.arraycopy(information, 9, catog, i, 1);


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
