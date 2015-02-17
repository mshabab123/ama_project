package user;
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

public class catogCompare {
	public static  Object[][] catogery = new Object[28][2];

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public catogCompare(HashMap<String, Integer> map) {

		
		
		//HashMap<String, Integer> map = new HashMap<String, Integer>();



		
	
		
		
		//System.out.println("Before Sorting:");
		Set<?> set = map.entrySet();
		Iterator<?> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			//System.out.print(me.getKey() + ": ");
			//System.out.println(me.getValue());
		}
		Map<String, Integer> map1 = sortByValues(map);
		//System.out.println("After Sorting:");
		Set<Entry<String, Integer>> set2 = map1.entrySet();
		Iterator iterator2 = set2.iterator();
		int p=0;
		while (iterator2.hasNext()) {
			p++;
			Map.Entry me2 = (Map.Entry) iterator2.next();
			//System.out.print(me2.getKey() + ": ");
			catogery[p-1][0]= me2.getKey();
			catogery[p-1][1]= me2.getValue();
		//	System.out.println(me2.getValue());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
	

}
