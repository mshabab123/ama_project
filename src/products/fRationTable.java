package products;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fRationTable {
	static String[][] fRatioTable= new String[18000][2];;

	fRationTable(){

	String fileName05 ="M:/googledrive/workEclipse/ratingPred/fRatioTable05.txt";
	String fileName10 ="M:/googledrive/workEclipse/ratingPred/fRatioTable10.txt";
			
	
	sortDatatoArray(fileName05,0);
	sortDatatoArray(fileName10,1);
	
	}
	static void sortDatatoArray(String fileName, int index ) {
		String line = null;
		int i = 0;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				fRatioTable[i][index] = line;
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