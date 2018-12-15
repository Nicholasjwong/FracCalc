package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	boolean done = false;
			while (!done) {
			// TODO: Read the input from the user and call produceAnswer with an equation
			Scanner console = new Scanner(System.in);
			System.out.println("Expression:  ");
			String fraction = console.nextLine();
			System.out.println(produceAnswer(fraction));
			System.out.println();
			System.out.println("Do you want to continue? Type quit to end, or press any key to continue");	
			String quit = console.next();
			if (quit.equals("quit")) {
				done = true;
			} else {
				done = false;
			}
		}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
    	String [] array = input.split(" ");
		String frac1 = array[0];
		String operator = array[1];
		String frac2 = array[2];
		int wholeOf1 = 0;
		int wholeOf2 = 0;
		int numerOf1 = 0;
		int numerOf2 = 0;
		int denomOf1 = 1;
		int denomOf2 = 1;
		if (frac1.contains("_")) {
    		wholeOf1 = Integer.parseInt(frac1.substring(0,frac1.indexOf("_")));
    		numerOf1 = Integer.parseInt(frac1.substring(frac1.indexOf("_")+1,frac1.indexOf("/"))); 
    		denomOf1 = Integer.parseInt(frac1.substring(frac1.indexOf("/")+1));
		} else if (frac1.contains("/")) {
			numerOf1=Integer.parseInt(frac1.substring(0,frac1.indexOf("/")));
		    denomOf1=Integer.parseInt(frac1.substring(frac1.indexOf("/")+1));
		} else {
			wholeOf1 = Integer.parseInt(frac1);
		}	
    	if (frac2.contains("_")) {
    		wholeOf2 = Integer.parseInt(frac2.substring(0,frac2.indexOf("_")));
    		numerOf2 = Integer.parseInt(frac2.substring(frac2.indexOf("_")+1,frac2.indexOf("/"))); 
    		denomOf2 = Integer.parseInt(frac2.substring(frac2.indexOf("/")+1));
		} else if (frac2.contains("/")) {
			numerOf2 = Integer.parseInt(frac2.substring(0,frac2.indexOf("/")));
		    denomOf2 = Integer.parseInt(frac2.substring(frac2.indexOf("/")+1));
		} else {
			wholeOf2 = Integer.parseInt(frac2);
		}
    	System.out.println(wholeOf1 + " " + wholeOf2 + " " + numerOf1 + " " + numerOf2 + " " + denomOf1 + " " + denomOf2);
    	int n1 = (absValue(wholeOf1 * denomOf1) + numerOf1);
    	int n2 = (absValue(wholeOf2 * denomOf2) + numerOf2);
    	int d1 = denomOf1;
    	int d2 = denomOf2;
    	if (wholeOf1 < 0) {
    		n1 = n1 * -1;
    	} if (wholeOf2 < 0) {
    		n2 = n2 * -1;
    	}
    	//System.out.println(n1 + " " + n2 + " " + d1 + " " + d2);
    	String answer = mathEquations(n1, n2, d1, d2, operator);
    	return answer;
	}
    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String mathEquations (int n1, int n2, int d1, int d2, String operator) {
    	if (operator.equals("+")) {
    		String answer = add(n1, n2, d1, d2);
    		return answer;
    	} else if (operator.equals("-")) {
    		String answer = subtract(n1, n2, d1, d2);
    		return answer;
    	} else if (operator.equals("*")) {
    		String answer = multiply(n1, n2, d1, d2);
    		return answer;
    	} else if (operator.equals("/")) {
    		String answer = divide(n1, n2, d1, d2);
    		return answer;
    	}
    	return "";
    }
    public static String add (int n1, int n2, int d1, int d2) {
    	String result = (n1 * d2) + (n2 * d1) + "/" + (d1 * d2);
    	return result;
    }
    public static String subtract (int n1, int n2, int d1, int d2) {
    	String result = (n1 * d2) - (n2 * d1) + "/" + (d1 * d2);
    	return result;
    }
    public static String multiply (int n1, int n2, int d1, int d2) {
    	String result = (n1 * n2) + "/" + (d1 * d2);
    	return result;
    }
    public static String divide (int n1, int n2, int d1, int d2) {
    	String result = (n1 * d2) + "/" + (d1 * n2);
    	return result;
    }
    public static int absValue (int num1) {
		if (num1 < 0) {                
			return -1 * num1;
		} else {
			return num1;
		}
	}
}


    
