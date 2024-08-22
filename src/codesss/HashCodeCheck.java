package codesss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashCodeCheck {

	public static void main(String[] args) {
		Map<Object, Integer> noOfLotByLotSize = new HashMap<>(); 
		Order order1 = new Order(200, 100);
		Order order2 = new Order(200, 120);
		Order order3 = new Order(100, 220);
		Order order4 = new Order(200, 50);
		Order order5 = new Order(200, 70);
		String s = "323";
		int n = 123;
		System.out.println(s.compareTo(Integer.toString(n)));
		List<Order> list = new ArrayList<>();
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);
		
		for(Order order : list) {
			double lots[] = getLots(order.getQty(), 50);
			if(lots[0]>0) {
				LotModel lotKey = new LotModel(50, order.getPrice());
				if(noOfLotByLotSize.containsKey(lotKey)) {
					noOfLotByLotSize.put(lotKey,noOfLotByLotSize.get(lotKey)+(int)lots[0]);
				}else {
					noOfLotByLotSize.put(lotKey,(int)lots[0]);
				}
			}
			
			if(lots[1]>0) {
				LotModel lotKey = new LotModel(lots[1], order.getPrice());
				if(noOfLotByLotSize.containsKey(lotKey)) {
					noOfLotByLotSize.put(lotKey,noOfLotByLotSize.get(lotKey)+1);
				}else {
					noOfLotByLotSize.put(lotKey,1);
				}
			}
		}
		for(Entry<Object, Integer> entry : noOfLotByLotSize.entrySet()) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
	}
	
	private static double[] getLots(double quantity,double unitSize) {
		double[] lots = new double[2];
	    double remainder = quantity%unitSize;
	    double fixed =(int) quantity/unitSize;
	    double terminal = 0;
	    
	    if(remainder>0) {
		    fixed-=1;
		    terminal=remainder+unitSize;
		}
	    lots[0]=fixed;
	    lots[1]=terminal;
	    return lots;
	}
}
