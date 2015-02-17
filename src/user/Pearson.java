package user;

import java.util.Vector;


public class Pearson {

	
	public static void main(String[] args) {
		
		
		
		Double[] x={	 100.0,	4.11111000000000,	2.654321000000000 };
		Double[] y={	-0.2185,    0.7850  , -0.5664};
		Double[] z={	 -0.6754 ,   0.0610  ,  0.6144};
		Double[] f={		0.3447 ,   0.4543 ,  -0.7990};
		Double[] w={		 0.7514 ,  -0.1843 ,  -0.5671};

		double ss = GetCorrelation(x, y);
		System.out.println("y "+ss);
		double ss1 = GetCorrelation(x, z);
		System.out.println("z "+ss1);
		double ss2 = GetCorrelation(x, f);
		System.out.println("f "+ss2);
		double ss3 = GetCorrelation(x, w);
		System.out.println("w "+ss3);
		
	}

  public static double GetCorrelation(Double[] x, Double[] y) {
    double meanX = 0.0, meanY = 0.0;
    for(int i = 0; i < x.length; i++)
    {
        meanX += x.length;
        meanY += y.length;
    }

    meanX /= x.length;
    meanY /= y.length;

    double sumXY = 0.0, sumX2 = 0.0, sumY2 = 0.0;
    for(int i = 0; i < x.length; i++)
    {
      sumXY += ((x[i] - meanX) * (y[i] - meanY));
      sumX2 += Math.pow(x[i] - meanX, 2.0);
      sumY2 += Math.pow(y[i] - meanY, 2.0);
    }

    return (sumXY / (Math.sqrt(sumX2) * Math.sqrt(sumY2)));
  }//end: GetCorrelation(X,Y)
}