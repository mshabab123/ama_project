package products;

public class calculateClass {

	public static float[] calculate_slope(int[][] a) {

		float mean = 0, variance = 0, r = 0, r_square = 0, slope, x = 0, y = 0, xy = 0, sum_x = 0, sum_y = 0, sum_xy = 0, denominatorR1 = 0, denominatorR2 = 0, numeratorR = 0, square_x = 0, square_y = 0, sum_square_x = 0, sum_square_y = 0, RSS = 0, fRatio = 0, slope_time = 0, r_time = 0;

		float[] result = new float[12];
		int hetro05 = 0;
		int hetro10 = 0;
		int numberOfdays = 0;

		int n = a.length;
		for (int j = 0; j < n; j++) {
			x = j + 1; // we add 1 because the index starts by 0 and the last
						// one dosn't counted.
			y = a[j][0];
			square_x = (float) Math.pow(x, 2);
			square_y = (float) Math.pow(y, 2);
			sum_square_x += square_x;
			sum_square_y += square_y;

			xy = x * y;
			sum_x = sum_x + x;
			sum_y = sum_y + y;
			sum_xy += xy;
		}
		mean = sum_y / n;
		// calculate RSS
		for (int jj = 0; jj < n; jj++)
			RSS += Math.pow((a[jj][0] - mean), 2);
		// calculate the variance
		variance = RSS / n;
		numeratorR = ((n * sum_xy) - (sum_x * sum_y));
		denominatorR1 = ((n * sum_square_x) - (sum_x * sum_x));
		denominatorR2 = ((n * sum_square_y) - (sum_y * sum_y));

		slope = numeratorR / denominatorR1;
		r = (float) (numeratorR / Math.sqrt(denominatorR1 * denominatorR2));
		r_square = r * r;
		if (denominatorR2 == 0)
			r_square = 0;

		
		
		
		/* calculate the time slope and r */
		square_x = square_y = sum_square_x= sum_square_y = xy = x = y = sum_y = sum_y = sum_xy=sum_x = 0; // initial
						
		for (int j = 0; j < n; j++) {
			x = j + 1; // we add 1 because the index starts by 0 and the last
						// one dosn't counted.
			y = a[j][1];
			square_x = (float) Math.pow(x, 2);
			square_y = (float) Math.pow(y, 2);
			sum_square_x += square_x;
			sum_square_y += square_y;
			xy = x * y;
			sum_x = sum_x + x;
			sum_y = sum_y + y;
			sum_xy += xy;

		}
		

		float mean_tiem = sum_y / n;


		// calculate RSS and the count of days
		float RSS_time = 0;
		for (int jj = 0; jj < n; jj++) {
			RSS_time += Math.pow((a[jj][1] - mean_tiem), 2);
			numberOfdays += a[jj][1];

		}

		// calculate the variance

		numeratorR = ((n * sum_xy) - (sum_x * sum_y));
		denominatorR1 = ((n * sum_square_x) - (sum_x * sum_x));
		denominatorR2 = ((n * sum_square_y) - (sum_y * sum_y));

		slope_time = numeratorR / denominatorR1;
		r_time = (float) (numeratorR / Math.sqrt(denominatorR1 * denominatorR2));
		float r_square_time = r_time * r_time;
		if (denominatorR2 == 0)
			r_square_time = 0;

		// determine the hetro by making the false 1 if it is hetro otherwise 0
		// divide the array to two array equally size
		int sizeOfsmallArry = a.length / 2;
		float[] b = new float[sizeOfsmallArry];
		float[] c = new float[sizeOfsmallArry];
		float meanB = 0, meanC = 0;
		for (int i = 0; i < sizeOfsmallArry; i++) {
			b[i] = a[i][0];
			c[i] = a[i + sizeOfsmallArry][0];
			meanB += b[i];
			meanC += c[i];
		}
		;
		meanB = meanB / b.length;
		meanC = meanC / c.length;
		float RSSB = 0, RSSC = 0;
		for (int jj = 0; jj < sizeOfsmallArry; jj++)
			RSSB += (float) Math.pow((b[jj] - meanB), 2);
		for (int jj = 0; jj < sizeOfsmallArry; jj++)
			RSSC += (float) Math.pow((c[jj] - meanC), 2);
		int numberOfFreedom = n - 1;
		{
			float f_disterubution = calcualatefRatio05(b.length - 1); //  subrougp-1
			fRatio = RSSB / RSSC;
			if (f_disterubution < fRatio)
				hetro05 = 1;
			f_disterubution = calcualatefRatio10(b.length - 1); // ther freedom
																// in this case
																// is number of
																// subrougp-1
			if (f_disterubution < fRatio)
				hetro10 = 1;

		}
		result[0] = slope;
		result[1] = r_square;
		result[2] = mean;
		result[3] = variance;
		result[4] = hetro05;
		result[5] = hetro10;
		result[6] = slope_time;
		result[7] = r_square_time;
		result[8] = a[0][2];
		result[9] = a[n - 1][2];
		result[10] = numberOfdays;
		result[11] = n;
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

	static float calcualatefRatio05(int df) {
			float ddf = Float.parseFloat(fRationTable.fRatioTable[df][0]);
		return ddf;
	}

	static float calcualatefRatio10(int df) {
		
		 float ddf = Float.parseFloat(fRationTable.fRatioTable[df][1]);
		return ddf;
	}

}
