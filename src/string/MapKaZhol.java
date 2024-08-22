package string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.stream.Collectors;

public class MapKaZhol {

	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<>();
		map1.put("Lucy", "H");
		map1.put("Erza", "G");
		map1.put("MiraJane", "I");
		map1.put("Fubuki", "I");
		map1.put("Kitagawa", "G");

		// create synchronized map.
//		Map<String, String> syncMap = Collections.synchronizedMap(map1);

		for (Entry<String, String> entry : map1.entrySet()) {
			if (entry.getValue().equals("H")) {
				map1.put(entry.getKey(), "J");
			}
		}
		System.out.println(map1);

		Map<String, String> map = new HashMap<>();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");

		for (String key : map.keySet()) {
			if (key.equals("B")) {
				map.remove(key); // Concurrent modification while iterating
			}
		}
		
		//Concurrent hash map does not throw any concurrent modification exception.

		List<Waifu> girls = new ArrayList<>();
		girls.add(new Waifu("Lucy", "H"));
		girls.add(new Waifu("Erza", "G"));
		girls.add(new Waifu("MiraJane", "I"));
		girls.add(new Waifu("Fubuki", "I"));
		girls.add(new Waifu("Kitagawa", "G"));
		
		for(Waifu w : girls) {
			if(w.getName().equals("Lucy")) {
				girls.remove(w);
			}
		}

		Map<String, List<Waifu>> byCup = girls.stream().collect(Collectors.groupingBy(w -> w.getCup()));
		System.out.println(byCup);
		
		List<Integer> list = new Stack<>();
	}
}

class Waifu {
	String name;
	String cup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public Waifu(String name, String cup) {
		super();
		this.name = name;
		this.cup = cup;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", cup=" + cup + "]";
	}

}
