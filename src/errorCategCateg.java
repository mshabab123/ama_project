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

public class errorCategCateg {

	private static String[][] alldataCatogCatog = new String[989][4];
	static float[][] finalresult= new float[29][29+28];


	public static void main(String[] args) throws IOException {

		
		String filenameProdcut = "new";
		int productNumber = numberofline(filenameProdcut);

		System.out.println(alldataCatogCatog.length + "\t"
				);

		if (productNumber != alldataCatogCatog.length) {
			System.out.println("make sure about the size of array products");
			System.exit(0);
		}

		loadDatatoArrayProduct(filenameProdcut);

		int CatogCatogSize = alldataCatogCatog.length;
		int indCatog, intColumnCat ;
		for (int i = 0; i < CatogCatogSize; i++) {

			float rate = Float.parseFloat(alldataCatogCatog[i][0]);
			float mean = Float.parseFloat(alldataCatogCatog[i][2]);
			indCatog = catog_switch(alldataCatogCatog[i][1]); 
			intColumnCat = catog_switch(alldataCatogCatog[i][3]); 

			finalresult[indCatog][0]= (float) (finalresult[indCatog][0]+ Math.pow( (rate-mean), 2));
			finalresult[indCatog][intColumnCat]= (float) (finalresult[indCatog][intColumnCat]+ Math.pow( (rate-mean), 2));

			finalresult[indCatog][intColumnCat+28]= (float) (finalresult[indCatog][intColumnCat+28]+1);

			
			

		}


		WriteToFile();
		
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

				
				if (!(line.trim().isEmpty())){ 
				String[] information = line.split("\t");
				alldataCatogCatog[i][0] = information[3];
				alldataCatogCatog[i][1] = information[4];
				alldataCatogCatog[i][2] = information[5];
				alldataCatogCatog[i][3] = information[6];

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

	

	public static int catog_switch(String catog) {

		int intc = 0;
		switch (catog) {

		case "amazon_instant_video":
			intc = 1;
			break;
		case "arts":
			intc = 2;
			break;
		case "automotive":
			intc = 3;
			break;
		case "baby":
			intc = 4;
			break;
		case "beauty":
			intc = 5;
			break;
		case "books":
			intc = 6;
			break;
		case "cell_phones_accessories":
			intc = 7;
			break;
		case "clothing_accessories":
			intc = 8;
			break;
		case "electronics":
			intc = 9;
			break;
		case "gourmet_foods":
			intc = 10;
			break;
		case "health":
			intc = 11;
			break;
		case "home_kitchen":
			intc = 12;
			break;
		case "industrial_scientific":
			intc = 13;
			break;
		case "jewelry":
			intc = 14;
			break;
		case "kindle_store":
			intc = 15;
			break;
		case "movies_tv":
			intc = 16;
			break;
		case "music":
			intc = 17;
			break;
		case "musical_instruments":
			intc = 18;
			break;
		case "office_products":
			intc = 19;
			break;
		case "patio":
			intc = 20;
			break;
		case "pet_supplies":
			intc = 21;
			break;
		case "shoes":
			intc = 22;
			break;
		case "software":
			intc = 23;
			break;
		case "sports_outdoors":
			intc = 24;
			break;
		case "tools_home_improvement":
			intc = 25;
			break;
		case "toys_games":
			intc = 26;
			break;
		case "video_games":
			intc = 27;
			break;
		case "watches":
			intc = 28;
			break;

		}
		return intc;

	}


	static void WriteToFile() throws IOException {

		File file = new File("resull_all_categeries");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for ( int i = 0; i<29; i ++){
			for (int ii=0; ii<29+28;ii++){
			bw.write( finalresult[i][ii]+"\t");
			}
			bw.write("\n");

		}
		
		bw.close();

		System.out.println("Done");

	}

}