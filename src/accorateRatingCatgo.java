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

public class accorateRatingCatgo {

	private static String[][] products = new String[536906][4];
	private static String[][] alldata = new String[15431485][4];
	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {

		String filenameProdcut ="podructWhithmean";
		String filenameAlldata= "alldataCatog";
		
		
		
		int productNumber = numberofline(filenameProdcut);
		int alldataNumver = numberofline(filenameAlldata);

		System.out.println(products.length + "\t" + alldata.length);

		if (productNumber != products.length) {
			System.out.println("make sure about the size of array products");
			System.exit(0);
		}
		if (alldataNumver != alldata.length) {
			System.out.println("make sure about the size of array alldata");
			System.exit(0);
		}

		loadDatatoArrayProduct(filenameProdcut);
		loadDatatoArrayAlldata(filenameAlldata);
		initialMap();

		int lldatazie = alldata.length;
		int productsize= products.length;
		for (int i = 0; i < lldatazie; i++) {
			String Pid = alldata[i][0];
			String rate = alldata[i][1];

			for (int i1 = 0; i1 < productsize-1; i1++) {

				if (products[i1][0].equals(Pid)) {

					if (products[i1][1].equals(rate)) {

						System.out.println("\t" + rate + "\t" + products[i1][1]);

						catog_switch(alldata[i][2]);
					}
				}
			}
		}

		Arrays.toString(map.entrySet().toArray());

		System.out.println(map);
		WriteToFile(map.toString());
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

				String[] information = line.split("\t");
				products[i][0] = information[0];
				products[i][1] = information[1];
				products[i][2] = information[3];
				i++;
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

	static void loadDatatoArrayAlldata(String fileName) {
		int i = 0;
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				String[] information = line.split("\t");
				alldata[i][0] = information[2];
				alldata[i][1] = information[4];
				alldata[i][2] = information[5];
				i++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}

	}

	public static void catog_switch(String catog) {

		switch (catog) {

		case "amazon_instant_video":
			map.put("amazon_instant_video", map.get("amazon_instant_video") + 1);
			break;
		case "arts":
			map.put("arts", map.get("arts") + 1);
			break;
		case "automotive":
			map.put("automotive", map.get("automotive") + 1);
			break;
		case "baby":
			map.put("baby", map.get("baby") + 1);
			break;
		case "beauty":
			map.put("beauty", map.get("beauty") + 1);
			break;
		case "books":
			map.put("books", map.get("books") + 1);
			break;
		case "cell_phones_accessories":
			map.put("cell_phones_accessories",
					map.get("cell_phones_accessories") + 1);
			break;
		case "clothing_accessories":
			map.put("clothing_accessories", map.get("clothing_accessories") + 1);
			break;
		case "electronics":
			map.put("electronics", map.get("electronics") + 1);
			break;
		case "gourmet_foods":
			map.put("gourmet_foods", map.get("gourmet_foods") + 1);
			break;
		case "health":
			map.put("health", map.get("health") + 1);
			break;
		case "home_kitchen":
			map.put("home_kitchen", map.get("home_kitchen") + 1);
			break;
		case "industrial_scientific":
			map.put("industrial_scientific",
					map.get("industrial_scientific") + 1);
			break;
		case "jewelry":
			map.put("jewelry", map.get("jewelry") + 1);
			break;
		case "kindle_store":
			map.put("kindle_store", map.get("kindle_store") + 1);
			break;
		case "movies_tv":
			map.put("movies_tv", map.get("movies_tv") + 1);
			break;
		case "music":
			map.put("music", map.get("music") + 1);
			break;
		case "musical_instruments":
			map.put("musical_instruments", map.get("musical_instruments") + 1);
			break;
		case "office_products":
			map.put("office_products", map.get("office_products") + 1);
			break;
		case "patio":
			map.put("patio", map.get("patio") + 1);
			break;
		case "pet_supplies":
			map.put("pet_supplies", map.get("pet_supplies") + 1);
			break;
		case "shoes":
			map.put("shoes", map.get("shoes") + 1);
			break;
		case "software":
			map.put("software", map.get("software") + 1);
			break;
		case "sports_outdoors":
			map.put("sports_outdoors", map.get("sports_outdoors") + 1);
			break;
		case "tools_home_improvement":
			map.put("tools_home_improvement",
					map.get("tools_home_improvement") + 1);
			break;
		case "toys_games":
			map.put("toys_games", map.get("toys_games") + 1);
			break;
		case "video_games":
			map.put("video_games", map.get("video_games") + 1);
			break;
		case "watches":
			map.put("watches", map.get("watches") + 1);
			break;

		}

	}

	static void initialMap() {
		map.put("amazon_instant_video", 0);
		map.put("arts", 0);
		map.put("automotive", 0);
		map.put("baby", 0);
		map.put("beauty", 0);
		map.put("books", 0);
		map.put("cell_phones_accessories", 0);
		map.put("clothing_accessories", 0);
		map.put("electronics", 0);
		map.put("gourmet_foods", 0);
		map.put("health", 0);
		map.put("home_kitchen", 0);
		map.put("industrial_scientific", 0);
		map.put("jewelry", 0);
		map.put("kindle_store", 0);
		map.put("movies_tv", 0);
		map.put("music", 0);
		map.put("musical_instruments", 0);
		map.put("office_products", 0);
		map.put("patio", 0);
		map.put("pet_supplies", 0);
		map.put("shoes", 0);
		map.put("software", 0);
		map.put("sports_outdoors", 0);
		map.put("tools_home_improvement", 0);
		map.put("toys_games", 0);
		map.put("video_games", 0);
		map.put("watches", 0);

	}

	static void WriteToFile(String result) throws IOException {


		File file = new File("result");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(result);
		bw.close();

		System.out.println("Done");

	}

}