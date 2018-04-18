package practice.basics;

public class StringUnderstandings {

	public static void main(String[] args) {
		// Concatenation
		String str1 = "Word1 ", str2 = "AnotherWord";
		System.out.println(str1+str2);
		System.out.println("Check"+1+1+1+1+1);
		System.out.println(1+1+1+1+1+1+"Now"+1+1+1+1+1);
		
		// String Array
		String [] myCollection = {"One", "Two" ,"Three", "Four", "Five"};
		for(String x:myCollection)
			System.out.println(x);
		
		// String + String = Concatenation
		// String + Integer = Concatenation
		// Integer + Integer = Addition
		
		// String Comparison
		String str11 = "selenium";
		String str22 = "SELENIUM";
		String str33 = "SELENIUM";
		String str44 = "zselenium";
		//String Comparison using == Operator
		System.out.println(str11 == str22);//false
		System.out.println(str22 == str33);//true
		  
		//String Comparison using equals() method
		System.out.println(str11.equals(str22));//false
		System.out.println(str22.equals(str33));//true
		  
		//String Comparison using compareTo() method
		System.out.println(str11.compareTo(str22));//Greater than 0
		System.out.println(str22.compareTo(str33));//0
		System.out.println(str11.compareTo(str44));//Less than 0
	}
}
