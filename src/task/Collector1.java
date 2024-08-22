package task;

import java.util.ArrayList;
import java.util.List;

public class Collector1 {

	public static void main(String[] args) {
		Cheque c1 = new Cheque(100);
		Cheque c2 = new Cheque(200);
		Cheque c3 = new Cheque(300);
		Cheque c4 = new Cheque(400);
		Cheque c5 = new Cheque(500);
		Cheque c6 = new Cheque(600);
		Cheque c7 = new Cheque(70);
		
		List<Cheque> cheques = new ArrayList<>();
		cheques.add(c1);
		cheques.add(c2);
		cheques.add(c3);
		cheques.add(c4);
		cheques.add(c5);
		cheques.add(c6);
		cheques.add(c7);
		
		Double collect = cheques.stream().collect(new CollectorImplement());
		System.out.println(collect);
	}

}
