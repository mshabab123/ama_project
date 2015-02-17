

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fRationT {
	static String[][] fRatioTable= new String[18000][2];;

		static float fRationT(int df){

	String fileName05 ="M:/googledrive/workEclipse/ratingPred/fRatioTable05.txt";
			
	sortDatatoArray(fileName05,0);
	float xx=0;
	
	xx= Float.parseFloat(fRatioTable[df][0]);
	return xx;
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