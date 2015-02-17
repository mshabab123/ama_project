package user;

import java.awt.geom.Arc2D.Float;
import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class calculation_users {

	static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public static String[] calculate_att(String[][] a) {

		float variance = 0, cat1 = 0, cat2 = 0, cat3 = 0, cat4 = 0, cat5 = 0, cat6 = 0, cat7 = 0, cat8 = 0, helpful_pesen = 0, helpful_good = 0, helpful_bad = 0,

		mean = 0, r = 0, x = 0, y = 0, xy = 0, sum_x = 0, sum_y = 0, sum_xy = 0, denominatorR1 = 0, denominatorR2 = 0, numeratorR = 0, square_x = 0, square_y = 0, sum_square_x = 0, sum_square_y = 0, RSS = 0, fRatio = 0, slope_time = 0, r_time = 0;

		String[] result = new String[16];
		int numberOfdays = 0;

		int n = a.length;
		float MPE = 0; // Percentage Error

		int firstDay = Integer.parseInt(a[0][4]);
		int lastday = Integer.parseInt(a[n - 1][4]);

		// calculate the time for the user rating from to
		if (firstDay != lastday) {
			numberOfdays = ((((lastday - firstDay) / 60) / 60) / 24);
		} else {
			numberOfdays = 1;
		}

		// calculate the variance
		for (int j = 0; j < n; j++) {
			x = j + 1; // we add 1 because the index starts by 0 and the last
						// one dosn't counted.
			y = Integer.parseInt(a[j][3]);
			square_x = (float) Math.pow(x, 2);
			square_y = (float) Math.pow(y, 2);
			sum_square_x += square_x;
			sum_square_y += square_y;

			xy = x * y;
			sum_x = sum_x + x;
			sum_y = sum_y + y;
			sum_xy += xy;
		////////	MPE += (Double.parseDouble(a[j][5]));

		}
	///////////////	MPE=MPE/n;
		mean = sum_y / n;
		// calculate RSS
		for (int jj = 0; jj < n; jj++)
			RSS += Math.pow((Integer.parseInt(a[jj][3]) - mean), 2);
		variance = RSS / n;

		// initial map
		initialMap();

		// calculate the helpful
		for (int j = 0; j < n; j++) {
			catog_switch(a[j][0]);
			helpful_good += Integer.parseInt(a[j][1]);
			helpful_bad += Integer.parseInt(a[j][2]);
		}

		if (helpful_bad != 0) {
			helpful_pesen = helpful_good * 100 / helpful_bad;
			helpful_bad = helpful_bad - helpful_good;
		}

		// compaer and return the sorted array of the catogery
		catogCompare catogcopare = new catogCompare(map);
		Object[][] catogery1 = catogCompare.catogery;

		
		
		
		result[0] = String.valueOf(n);
		result[1] = Integer.toString(numberOfdays);
		result[2] = String.valueOf(mean);
		result[3] = String.valueOf(variance);
		result[4] = String.valueOf(helpful_pesen);
		result[5] = String.valueOf(helpful_good);
		result[6] = String.valueOf(helpful_bad);
		result[7] =	"000";// String.valueOf(MPE);
		result[8] = (String) catogery1[27][0];// the name of highest catoery ;
		result[9] = String.valueOf(catogery1[27][1]);
		result[10] = (String) catogery1[26][0];
		result[11] = String.valueOf(catogery1[26][1]);
		result[12] = (String) catogery1[25][0];
		result[13] = String.valueOf(catogery1[25][1]);
		
		
		
	
		return result;
	}

	
	float calcualte_bais() {
		return 0;
	}

	float calcualte_r() {
		return 0;
	}

	float calcualte_hetero() {
		return 0;
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

}
