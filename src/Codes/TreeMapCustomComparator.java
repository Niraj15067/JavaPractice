package Codes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapCustomComparator {

	public static void main(String[] args) {

		TreeMap<List<Integer>, Integer> map = new TreeMap<>((a,b)->{
			int result = a.get(1)-b.get(1);
			if(result == 0) {
				return a.get(0)-b.get(0);
			}
			return result;
		});
		map.put(Arrays.asList(0,0), 1);
		map.put(Arrays.asList(1,-1), 2);
		map.put(Arrays.asList(1,0), 1);
		map.put(Arrays.asList(2,2), 1);
		
		for(Entry<List<Integer>,Integer> entry:map.entrySet()) {
			System.out.println(entry);
		}
	}
}
