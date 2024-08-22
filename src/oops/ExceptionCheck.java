package oops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

public class ExceptionCheck {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(11);
		list.add(12);
		list.add(112);
		list.add(111);
		list.add(145);

//		ListIterator<Integer> it = list.listIterator();
//		while(it.hasNext()) {
//			int val = it.next();
//			if(val>100) {
//				it.remove();
//			}
//		}
//		System.out.println(list);
//
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) > 100) {
//				list.remove(i);
//			}
//		}
//
//		System.out.println();
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//			if (entry.getKey() > 1) {
//				map.remove(entry.getKey());
//			}
//		}
		Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			if (entry.getKey().equals(1)) {
				iterator.remove();
			}
		}
		System.out.println(map);
	}
}
