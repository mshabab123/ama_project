package archive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

import products.fRationTable;

public class prations_prediotn_validiate {

	public static void main(String[] args) throws IOException {
/*
		String filenameProdcut = "stream_one_instance";
		int productNumber = numberofline(filenameProdcut);
		String[][] streamRanting = new String[productNumber][5];
		float[][] finalresult = new float[productNumber][7];

		loadDatatoArrayProduct(streamRanting, filenameProdcut);

		double algorhtmArryAll[] = weights.algorhtmArryAll;

		double algorhtmArryPart[] = weights.algorhtmArryPart;

		float[] sumofCteg = new float[29];
		int[] numberofCteg = new int[29];
		double prdicedrate = 0;
		double prd_neaul = 0;
		double prd_svm_part = 0;
		int Catog = 0;
		int rate = 0;
		float usmofrate = 0;

		/***** t test vaible **********
		float mean_svm = 0;
		float mean_neural = 0;
		double mean_svm_part = 0;
		float mean_avarge = 0;

		/***** regression varilbe ******
		float y = 0;
		int x = 0, x_2 = 0, sum_x_2 = 0;
		float xy = 0;
		float sum_xy = 0;
		float sum_x = 0;
		float sum_y = 0;
		float b = 0, a = 0;
		float regression = 0;
		/*******************************

		for (int i = 0; i < streamRanting.length; i++) {
			prdicedrate = 0;
			prd_neaul = 0;
			prd_svm_part = 0;
			Catog = Integer.valueOf(streamRanting[i][3]);
			rate = Integer.valueOf(streamRanting[i][4]);

			numberofCteg[Catog] += 1;
			// this will take the new value and add it with the previous value n
			// the same category and calculate the mean of this category
			sumofCteg[Catog] = ((sumofCteg[Catog] * (numberofCteg[Catog] - 1)) + rate)
					/ numberofCteg[Catog];

			double[] nerual = new double[28];
			// starting to calculate the sum of each category * weight
			for (int ii = 0; ii < 29; ii++) {
				prdicedrate += sumofCteg[ii] * algorhtmArryAll[ii];
				prd_svm_part += sumofCteg[ii] * algorhtmArryPart[ii];
			}
			// add the baise
			for (int ii = 0; ii < 28; ii++) {
				nerual[ii] = sumofCteg[ii + 1];
			}
			// System.out.println();

			prd_neaul = neuralClass.getNeural(nerual);

			prdicedrate += algorhtmArryAll[29];
			prd_svm_part += algorhtmArryPart[29];

			finalresult[i][0] = Catog;
			finalresult[i][1] = rate;
			usmofrate += rate;
			finalresult[i][2] = usmofrate / (i + 1);
			finalresult[i][3] = (float) prdicedrate;
			finalresult[i][4] = (float) prd_neaul;
			finalresult[i][5] = (float) prd_svm_part;

			/**************** regression basline ***************************

			x++;
			sum_x += x;
			x_2 = x * x;
			sum_x_2 += x_2;

			y = Float.parseFloat(streamRanting[i][4]);
			sum_y += y;
			sum_xy += x * y;
			b = (((x * sum_xy) - sum_x * sum_y))
					/ ((x * sum_x_2) - (sum_x * sum_x));
			a = (sum_y - b * sum_x) / x;

			// baseline regression
			finalresult[i][6] = a + (b * x);

			/****** clculate teh t test ***************************************
			mean_avarge += finalresult[i][2];
			mean_svm += prdicedrate;
			mean_neural += prd_neaul;
			mean_svm_part += prd_svm_part;

			/*
			 * System.out.printf("%d \t", i); System.out.printf("%.0f \t",
			 * finalresult[i][0]); System.out.printf("%.2f \t",
			 * finalresult[i][1]); System.out.printf("%.2f \t",
			 * finalresult[i][2]); System.out.printf("%.2f \t",
			 * finalresult[i][3]); System.out.printf("%.2f \t",
			 * finalresult[i][4]); System.out.printf("%.2f \t",
			 * finalresult[i][5]); System.out.printf("%.2f \t",
			 * finalresult[i][6]);
			 *

		}

		mean_svm = mean_svm / productNumber;
		mean_neural = mean_neural / productNumber;
		mean_svm_part = mean_svm_part / productNumber;
		mean_avarge = mean_avarge / productNumber;

		float RSS = 0, RSSC = 0;
		for (int jj = 0; jj < productNumber; jj++)
			RSS += (float) Math.pow((finalresult[jj][3] - mean_svm), 2);

		float RSSA = 0;
		for (int jj = 0; jj < productNumber; jj++)
			RSSA += (float) Math.pow((finalresult[jj][2] - mean_avarge), 2);

		float f_disterubution = calcualatefRatio05(productNumber - 1);

		System.out.println("the all predchu mean : " + mean_svm + " \tneaul :"
				+ mean_neural + "\tpart" + mean_svm_part +"\t"+f_disterubution);

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

	static void loadDatatoArrayProduct(String streamRanting[][], String fileName) {
		int i = 0;
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				if (!(line.trim().isEmpty())) {
					String[] information = line.split("\t");
					streamRanting[i][0] = information[0];
					streamRanting[i][1] = information[1];
					streamRanting[i][2] = information[2];
					streamRanting[i][3] = information[3];
					streamRanting[i][4] = information[4];

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

	static void WriteToFile(String finalresult[][]) throws IOException {

		File file = new File("resull_all_categeries");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < 29; i++) {
			for (int ii = 0; ii < 29 + 28; ii++) {
				bw.write(finalresult[i][ii] + "\t");
			}
			bw.write("\n");

		}

		bw.close();

		System.out.println("Done");

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

	static float calcualatefRatio05(int df) {
		float ddf = fRationT.fRationT(df);
		return ddf;
	}*/
}
}
