import java.util.Scanner;
public class Pro4_150118504 {

	public static void main(String[] args) {
		//Create Scan
		Scanner scan = new Scanner(System.in);
		
		//Variables
		int type, b;
		int exit = 0;
		String choice, str, subStr, subStr2;
		char ch;
		
		
		//do while loops
		do {
			//Codes
			System.out.println("Welcome to our String Analyzer Program.\n"
					+ "     1. Count number of chars\n"
					+ "     2. Print the words in a sentence\n"
					+ "     3. Delete substring\n"
					+ "     4. Replace substring\n"
					+ "     5. Sort characters\n"
					+ "     6. Hash code of a string");
			System.out.print("Please enter your menu choice: ");
			choice = scan.nextLine();
			
			//if statement for choice 1.
			if(choice.equals("1")) {
				System.out.print("Enter an input string: ");
				str = scan.nextLine();
				System.out.print("Enter an input char: ");
				ch = scan.nextLine().charAt(0);
				System.out.println("The number of " + ch + " in " + str + " is " + numOfChars(str,ch) + ".");
			}
			//if statement for choice 2
			else if(choice.equals("2")) {
				System.out.print("Enter an input string: ");
				str = scan.nextLine();
				System.out.println("The output is:" );
				printWords(str);
				System.out.println();
			}
			//if statement for choice 3
			else if(choice.equals("3")) {
				System.out.print("Enter an input string: ");
				str = scan.nextLine();
				System.out.print("Enter a substring: ");
				subStr = scan.nextLine();
				System.out.print("Enter a type: ");
				type = scan.nextInt();
				scan.nextLine();
				System.out.println(delete(str, subStr, type));
				
			}
			//if statement for choice 4
			else if(choice.equals("4")) {
				System.out.print("Enter an input string: ");
				str = scan.nextLine();
				System.out.print("Enter the first substring: ");
				subStr = scan.nextLine();
				System.out.print("Enter the second substring: ");
				subStr2 = scan.nextLine();
				System.out.println(replace(str, subStr, subStr2));
			}
			//if statement for choice 5
			else if(choice.equals("5")) {
				System.out.print("Enter an input string: ");
				str = scan.nextLine();
				System.out.print("Enter a type: ");
				type = scan.nextInt();
				scan.nextLine();
				System.out.println(sortChars(str, type));
			}
			//if statement for choice 6
			else if(choice.equals("6")) {
				System.out.print("Enter an input string: ");
				str = scan.nextLine();
				System.out.print("Enter a value for b: ");
				b = scan.nextInt();
				scan.nextLine();
				System.out.println("The hash code for " + str + " is " + hashCode(str, b) + ".");
			}
			else if(choice.equals("exit") || choice.equals("quit")){
				System.out.println("Programs ends. Bye :)");
				exit = 1;
			}
			else;
		}while(exit == 0);
		

	}
	//This 1.method use to count given input
	public static int numOfChars(String str, char ch) {
		int count = 0; 
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch)
				count += 1;
				
		}
		return count;
	}
	//This 2.method use for printing a words
	public static void printWords(String str) {
		for(int i = 0; i < str.length(); i++) {
			
			if(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
				System.out.print(str.charAt(i));
				if(i != str.length() - 1 && !Character.isLetter(str.charAt(i+1)) && !Character.isDigit(str.charAt(i+1)))
					System.out.println();
			}
		}
	}
	//This 3.method us for deleting given input in the sentence or word
	public static String delete(String str, String subStr, int type) {
		if(type == 0) {
			for(int i = 0; i < str.length() - subStr.length(); i++) {
				if(str.substring(i, i + subStr.length()).equals(subStr)) {
					return str.substring(0, i) + str.substring(i + subStr.length());
				}
			}
		}
		else if(type == 1) {
			
			for(int i = 0; i < str.length() - subStr.length() + 1; i++) {
				String strNew = str;
				if(str.substring(i, i + subStr.length()).equals(subStr)) {
					for(int j = 0; j < str.length() - subStr.length(); j++) {
						strNew = str.substring(0, i) + str.substring(i + subStr.length());
					}
				}
				str = strNew;
			}
		}
		return str;
		
	}
	//this 4.method add the given input in sentence
public static String replace(String str, String subStr1, String subStr2) {
		
		for(int i = 0; i < str.length() - subStr1.length(); i++) {
			String strNew = str;
			if(str.substring(i, i + subStr1.length()).equals(subStr1)) {
				for(int j = 0; j < str.length() - subStr1.length(); j++) {
					strNew = str.substring(0, i) + subStr2 + str.substring(i + subStr1.length());
				}
			}
			str = strNew;
		}
		return str;
	}
//this 5.method arrange the chars lower than to bigger
public static String sortChars(String str, int type) {
	
	String nums = "";
	String lowerCase = "";
	String upCase = "";
	String others = "";
	int ctr = 0;
	String newStr = "";
	int min;
	int k = 0;
	if(type == 0) {
		for( int i = 0; i < str.length(); i++) {
			min = 128;
			for( int j = 0; j < str.length(); j++) {
				if( str.charAt(j) >= ctr ) {
					min = Math.min( min, (int)str.charAt(j) );
					if( min == (int)str.charAt(j)) {
						k = j;
					}
				}
				
			}

			str = str.substring(0, k) + (char)127 + str.substring(k+1);
			ctr = min;
			newStr += (char)ctr;
			
		}
	}
	
	else if(type == 1) {
		for(int i = 0; i < str.length(); i++) {
			
			if('0' <= str.charAt(i) && str.charAt(i) <= '9')
				nums += str.charAt(i);
			else if('a' <= str.charAt(i) && str.charAt(i) <= 'z')
				lowerCase += str.charAt(i);
			else if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
				upCase += str.charAt(i);
			else
				others += str.charAt(i);
			
			}
		newStr = lowerCase + upCase + nums + others;
		}
	return newStr;
	
	}
//This 6.method is heshCode 
public static int hashCode(String str, int b) {
	int result = 0;
	for(int i = 0; i < str.length(); i++) {
		result += (str.charAt(i)) * (int)Math.pow(b, str.length() - (1+i));
		}
	return result;
	}

}

