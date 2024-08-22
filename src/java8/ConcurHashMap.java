package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ConcurHashMap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("a", "a");
		map.put("b", "a");
		map.put("c", "a");
		map.put("d", "a");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		map.remove("a");
		while (it.hasNext()) {
			it.remove();
		}
		System.out.println(map);
	}
}
