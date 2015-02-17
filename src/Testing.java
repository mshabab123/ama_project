import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import user.catogCompare;

public class Testing {

	public static void main(String[] args) {

		
		String[][] usersIdArray1 = new String[5][3];

		String line ="mshaba fd	abludahl	saad	5";
		
		String[] sentences = new String[3];
		int i=0;
		
		for (int h=0; h<3;h++)
		{
		sentences = line.split("\\t");
		usersIdArray1[i][h] = sentences[h];
	

	}
		System.out.println(usersIdArray1[0][0]);
		System.out.println(usersIdArray1[0][1]);
		System.out.println(usersIdArray1[0][2]);

		
		
	}

}
