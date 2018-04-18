package practice.basics;

public class ArrayUnderstandings {

	public static void main(String[] args) {
		
/*---------------------------------------------------- 
 *		//Creating Array
 *		dataType arrayName []; 
 *
 *		//Define Size 
 *		arrayName = new dataType[size];
 *
 *		//Assign value
 *		arrayName[0]=value;
 *		arrayName[1]=value;
 *		arrayName[2]=value; 
 */
		int a [];
		a = new int[3];
		a[0]=10; a[1]=20; a[2]=30;
		TitleSection("Print the 1st Method of Array using numbers");
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);

		String[] b;
		b = new String[4];
		TitleSection("Print the 1st Method of Array using string");
		b[0]="FirstName"; b[1]="LastName";b[2]="Gender";b[3]="Location";
		for(int i=0;i<b.length;i++)
			System.out.println(b[i]);

/*------------------------------------------------  
 * 		2nd Method
 * 
 * 		//Declare Array with length
 * 		dataType [] arrayName= new dataType[length]; 
 * 
 * 		//Assign value
 * 		arrayName[index] = value; 
 * ------------------------------------------------ 
 */

		int [] abc = new int [4];
		abc[0]=1989;
		TitleSection("Print the 2nd Method of Array");
		System.out.println(abc[0]);
		
/*----------------------------------------------------
 * 		3rd Method (Declare Array and Assign values)
 *		dataType [] arrayName = {value1, value2, value3}
 *---------------------------------------------------
 */

		int [] xyz = {11, 22, 33, 44};
		TitleSection("Print the 3rd Method of Array");
		for(int i=0; i<xyz.length;i++)
			System.out.println(xyz[i]);

 
// Declaring different types of Arrays 
		TitleSection("Print the Different Declaration types");
		char [] abcd = {'A', 'B', 'Z'}; //Array of Characters
		int [] wxyz = {10, 20, 30, 40}; //Array of Integers
		String [] ab = {"UFT", "Selenium", "RFT"}; //Array of Strings
		boolean [] bc ={true, false, false, true}; //Array of Boolean values
		System.out.println(abcd[1]);//B
		System.out.println(wxyz[3]);//40
		System.out.println(ab[1]);//Selenium
		System.out.println(bc[2]);//false
		
/*------------------------------------------------  
 * c) Copy Values from one to another
 * ------------------------------------------------
 */

		int [] array1 = {1, 2, 3, 4, 5};
		int array2 [] = array1;
		TitleSection("Print the copied values of the array");
		for (int i=0; i < array2.length; i++){
			System.out.println(array2[i]);
		}
/*------------------------------------------------  
 * d) Types of Arrays
 * 
 * Two types of Arrays 
 * 1) Single dimensional Array
 * 2) Multi dimensional Array
 * ------------------------------------------------
 */
		int [] array11 = {1, 2, 3, 4, 5};//Single dimensional Array
		int [] [] array22 = {{1, 3, 5, 7}, {2, 4, 6, 8}};// Multi dimensional Array
		TitleSection("Print the Single Dimensional Array Now");
		for(int i=0;i<array11.length;i++)
			System.out.println("Value of i is "+(i+1)+" and its array value is "+array11[i]);
		TitleSection("Print the Multi Dimensional Array Now");
		for(int i=0;i<array22.length;i++)
			for(int j=0;j<4;j++)
				System.out.println("Value of i,j is "+(i+1)+","+(j+1)+" and its array value is "+array22[i][j]);
	}
	
	
	public static void TitleSection(String title) {
		System.out.println("-----------------------------------------------------");
		System.out.println("       "+title);
		System.out.println("-----------------------------------------------------");
	}
}
