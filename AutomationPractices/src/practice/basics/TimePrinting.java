package practice.basics;
import java.sql.Time;
import java.util.Date;

public class TimePrinting {
	   @SuppressWarnings("deprecation")
	public static void main(String args[]) {
	      Date date = new Date();
	      System.out.println(date.toString());
	      String array[]= date.toLocaleString().split(" ");
	      System.out.println(date.getDate()+""+array[0]+"---"+array[1]);
	      String AdminEmailID1="admin."+date.getDate()+array[0]+date.getHours()+date.getMinutes()+date.getSeconds()+"@digisight.nett";
	      System.out.println(AdminEmailID1);
	      Time time = new Time(date.getHours(),date.getMinutes(),date.getSeconds());
	      System.out.println(time.getTime());
	      }
	   }