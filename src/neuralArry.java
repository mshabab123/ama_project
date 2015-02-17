import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class neuralArry {

	private static String[][] neuralalldata = new String[4863503][4];
	private static String[][] nTable = new String[19755][58];
	private static String[][] nPresentageTable = new String[19755][30];

	static float[] finalresult = new float[29];

	public static void main(String[] args) throws IOException {

		String filenameProdcut = "neuraldata";
		int productNumber = numberofline(filenameProdcut);
		System.out.println(neuralalldata.length + "\t");
		if (productNumber != neuralalldata.length) {
			System.out.println("make sure about the size of array products");
			// System.exit(0);
		}
		loadDatatoArrayProduct(filenameProdcut);
		int neralSize = neuralalldata.length;
		String Pid1 = null, Pid = null;
		int k1 = 0;
		int j = 0;
		for (int i = 0; i < neralSize; i++) {

			Pid = neuralalldata[i][0];
			if (!(Pid.equals(Pid1)))

			{
				nTable[j][0] = Pid;
				nTable[j][57] = neuralalldata[i][3];
				Pid1 = Pid;

				for (int k = 1; k < 57; k++)
					nTable[j][k] = "0";

				j++;

				k1 = i;
				catog_switch(neuralalldata[i][2], j - 1, k1);

			} else {
				k1 = i;

				catog_switch(neuralalldata[i][2], j - 1, k1);

			}
		}
		int k = 1;
		for (int i = 0; i < nTable.length; i++) {
			for (int ii = 1; ii < 57; ii++) {
				k = 1 + ii / 2;

				nPresentageTable[i][0] = nTable[i][0];
				nPresentageTable[i][29] = nTable[i][57];

				if ((nTable[i][ii + 1])==null |Integer.valueOf(nTable[i][ii + 1]) == 0  ) {
					nPresentageTable[i][k] = "0";
				} else {
					nPresentageTable[i][k] = String.valueOf(Float
							.valueOf(nTable[i][ii])
							/ (Float.valueOf(nTable[i][ii + 1])));
				}
				ii++;
			}
		}

		 WriteToFile();

		System.out.println("don and you have in your new array " + j
				+ " called neuralldata and the data you " + "exmpime is "
				+ neuralalldata.length);

		

	}

	static int numberofline(String name) throws IOException {

		LineNumberReader lnr = new LineNumberReader(new FileReader(new File(
				name)));
		lnr.skip(Long.MAX_VALUE);
		System.out.println(1 + lnr.getLineNumber());

		// Finally, the LineNumberReader object should be closed to prevent
		// resource leak
		lnr.close();

		return 1 + lnr.getLineNumber();

	}

	static void loadDatatoArrayProduct(String fileName) {
		int i = 0;
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				if (!(line.trim().isEmpty())) {
					String[] information = line.split("\t");
					neuralalldata[i][0] = information[0];
					neuralalldata[i][1] = information[1];
					neuralalldata[i][2] = information[3];
					neuralalldata[i][3] = information[4];

					i++;
				}
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

	public static void catog_switch(String catog, int i, int k1) {

		int store = 0;
		int countN = 0;
		int indPlus = 0;
		switch (catog) {

		case "amazon_instant_video":
			indPlus = 1;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "arts":
			indPlus = 3;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "automotive":

			indPlus = 5;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "baby":
			indPlus = 7;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "beauty":
			indPlus = 9;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "books":
			indPlus = 11;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "cell_phones_accessories":
			indPlus = 13;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "clothing_accessories":
			indPlus = 15;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "electronics":
			indPlus = 17;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "gourmet_foods":
			indPlus = 19;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "health":
			indPlus = 21;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[k1][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "home_kitchen":
			indPlus = 23;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "industrial_scientific":
			indPlus = 25;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "jewelry":
			indPlus = 27;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "kindle_store":
			indPlus = 29;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "movies_tv":
			indPlus = 31;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "music":
			indPlus = 33;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "musical_instruments":
			indPlus = 35;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "office_products":
			indPlus = 37;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "patio":
			indPlus = 39;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "pet_supplies":
			indPlus = 41;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "shoes":
			indPlus = 43;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "software":
			indPlus = 45;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "sports_outdoors":
			indPlus = 47;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "tools_home_improvement":
			indPlus = 49;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "toys_games":
			indPlus = 51;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "video_games":
			indPlus = 53;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;
		case "watches":
			indPlus = 55;
			store = Integer.valueOf(nTable[i][indPlus]);
			store += Integer.valueOf(neuralalldata[i][1]);
			nTable[i][indPlus] = String.valueOf(store);
			countN = Integer.valueOf(nTable[i][indPlus + 1]);
			nTable[i][indPlus + 1] = String.valueOf(countN + 1);

			break;

		}

	}

	static void WriteToFile() throws IOException {

		File file = new File("result_neuralarry");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < nPresentageTable.length; i++) {
			for (int ii = 0; ii < 30; ii++) {
				bw.write(nPresentageTable[i][ii] + "\t");
			}
			bw.write("\n");
		}
		bw.close();

		System.out.println("Done");

	}
}