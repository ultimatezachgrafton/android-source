package com.bloc.loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loops extends Object {

	public static void main(String [] args) {
		boolean[] someBools = {true, false, true, true, false, true, false, false};
		boolean temp = false;

		//********** Starts Here ************************/

		int i = 0;
		while (i < someBools.length) {
		    System.out.println(someBools[i]);
		    i++;
		}		

		
		//********** Ends Here **************************/
		

		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Replace the operations above with a `while` loop
		/************************************************/

		if (testBools(someBools)) {
			System.out.print("Your booleans are in proper order!\n");
		} else {
			System.out.print("Something in the while loop…\n");
			System.exit(0);
		}

		int[] numArray = new int[someBools.length];

		/************************************************
	 	 *	TIP:
	 	 *	This is known as an in-line conditional.
		 * 	Learn more here: http://www.cafeaulait.org/course/week2/43.html
		/************************************************/

		//********** Starts Here ************************/

		for (int i = 0; i < numArray.length; i++) {
		    System.out.println(numArray[i]);
		}
		
		
		//********** Ends Here **************************/


		/************************************************
	 	 *	ASSIGNMENT:
	 	 *	Replace the operations above with a for loop
		/************************************************/

		if (testInts(numArray)) {
			System.out.print("And you nailed the number array!\n");
		} else {
			System.out.print("Issue with the numbers…\n");
		}
	}


	/************************************************
	 *	DO NOT MODIFY BELOW THIS BLOCK
	/************************************************/

	
	static final boolean testBools(boolean[] bools) {
		if (bools == null || bools.length != 8) {
			return false;
		}
		return bools[0] == false &&
			   bools[1] == false &&
			   bools[2] == true &&
			   bools[3] == false &&
			   bools[4] == true &&
			   bools[5] == true &&
			   bools[6] == false &&
			   bools[7] == true;
	}

	static final boolean testInts(int[] ints) {
		if (ints == null || ints.length != 8) {
			return false;
		}
		return ints[0] == 1 &&
			   ints[1] == 1 &&
			   ints[2] == 0 &&
			   ints[3] == 1 &&
			   ints[4] == 0 &&
			   ints[5] == 0 &&
			   ints[6] == 1 &&
			   ints[7] == 0;
	}
}
