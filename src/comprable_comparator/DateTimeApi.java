package comprable_comparator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeApi {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		
		System.out.println(localDate);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("day of week: "+localDateTime.getDayOfWeek());
		System.out.println("day of month: "+localDateTime.getDayOfMonth());
		System.out.println("day of year: "+localDateTime.getDayOfYear());
		System.out.println("seconds: "+localDateTime.getSecond());
		System.out.println(localDateTime);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-YY HH:mm:ss");
		String format2 = localDateTime.format(format);
		System.out.println(format2);
		
		/*while(true) {
			try {
				System.out.println(LocalTime.now());
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}*/
	}
}
