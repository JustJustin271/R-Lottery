import java.util.Scanner;


/**
 * The Lottery Program class which is supposed to simulate a guessing game for a 
 * 3-digit number to a randomly generated 3-digit number
 * Prizes are based on a complete match, swapped match, or a correct digit placement
 * 
 * @author Justin
 * @version JavaSE-21
 * Created on Wednesday, October 21st, 2026
 * Last Edited: Wednesday, October 21st, 2026
 * 
 */

public class LotteryProgram {

	/**
	 * 
	 * Begins the execution of the lottery game here
	 * Gives the user a prompt to enter a 3 digit number
	 * Then, compared the digits in the number to the random digits,
	 * Prints out custom winning statements depending on the comparison to the random digits
	 * 
	 * @param args Standard command-line configuration arguments (not utilized)
	 * 
	 */
	
	public static void main(String[] args) {

		// Generate a lottery as a three-digit string

		 String lottery = "" + (int)(Math.random() * 10) + (int)(Math.random() * 10) + (int)(Math.random() * 10);

		// Prompt the user to enter a guess
		// Side note: input was changed to scan, simply personal preference
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your lottery pick (three digits): ");

		String guess = scan.nextLine();

		// Get digits from lottery

		int lotteryDigit1 = lottery.charAt(0);

		int lotteryDigit2 = lottery.charAt(1);

		int lotteryDigit3 = lottery.charAt(2);

		
		// Get digits from guess

		int guessDigit1 = guess.charAt(0);

		int guessDigit2 = guess.charAt(1);

		int guessDigit3 = guess.charAt(2);
		
		
		//Assuming the match case is: [123]. What are all the possible permutations?
		
		boolean firstMatchCheck = (guessDigit1 == lotteryDigit1) && (guessDigit2 == lotteryDigit3) && (guessDigit3 == lotteryDigit2); //[132]
		boolean secondMatchCheck = (guessDigit1 == lotteryDigit2) && (guessDigit2 == lotteryDigit1) && (guessDigit3 == lotteryDigit3); //[213]
		boolean thirdMatchCheck = (guessDigit1 == lotteryDigit2) && (guessDigit2 == lotteryDigit3) && (guessDigit3 == lotteryDigit1); //[231]
		boolean fourthMatchCheck = (guessDigit1 == lotteryDigit3) && (guessDigit2 == lotteryDigit1) && (guessDigit3 == lotteryDigit2); //[312]
		boolean fifthMatchCheck = (guessDigit1 == lotteryDigit3) && (guessDigit2 == lotteryDigit2) && (guessDigit3 == lotteryDigit1); //[321]
		
		boolean matchCheckAllSwapped = firstMatchCheck || secondMatchCheck || thirdMatchCheck || fourthMatchCheck || fifthMatchCheck;
				

		System.out.println("The lottery number is " + lottery);

		// Check the guessed digits:

		if (guess.equals(lottery)) { //If it is a complete match

			System.out.println("Exact match: you win $10,000");

		} else if (matchCheckAllSwapped) { //If it is a swapped match with all 5 permutations

			System.out.println("Match all digits: you win $3,000");

		} else if (guessDigit1 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit3 == lotteryDigit3) { //If any of the digits are placed correctly

			System.out.println("Match one digit: you win $1,000");

		} else { //If it doesn't match with those above (Complete, Swapped, Placement)

			System.out.println("Sorry, no match");

		}

		// Correctly closes the scanner
		scan.close();

	}

}
