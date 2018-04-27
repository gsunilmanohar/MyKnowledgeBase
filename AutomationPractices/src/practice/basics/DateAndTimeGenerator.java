package practice.basics;
import java.util.Date;

public class DateAndTimeGenerator {

	public static void main(String[] args) {
		for(int counter=0;counter<10;counter++)
			DateAndTimeNow();
	}
	
	@SuppressWarnings("deprecation")
	public static void DateAndTimeNow() {
		try {
			Date date = new Date();
			String[] dateValues = date.toLocaleString().split(" ");
			String monthName = dateValues[0];
			String dateAndTime = "dateAndTime" + date.getDate() + monthName + date.getHours() + date.getMinutes() + date.getSeconds();
			Thread.sleep(2000);
			System.out.println(dateAndTime); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
