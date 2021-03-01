import java.util.Scanner;	// Needed for the Scanner class
/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: A program that receives a number guess from the user, reports
 * if the guess is the random number that was generated, then narrows down the 
 * choices and prompts the user to guess until user guesses correctly.
 * Due: 2/28/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/

public class RandomNumberGuesser {
	public static void main(String[] args) {
		
		// Print application header
		System.out.println();
		System.out.println("Random Number Guesser");
		
		int randNum;	// To hold the random number
		int nextGuess;	// To hold the current guess
		int lowGuess;	// To hold the lower guess limit
		int highGuess;	// To hold the upper guess limit
		String tryAgain = "";	// To hold user answer for if they want to repeat
		
		// Create a new object of type Scanner that reads input from the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.println();	// For output formatting
			lowGuess = 0;	// Low limit initialized to 0 before first guess
			highGuess = 100;	// High limit initialized to 100 before first guess
			RNG.resetCount();	// Reset guess count to zero
			randNum = RNG.rand();	// Generate random number
			
			// For internal testing
//			System.out.println("Random Number: " + randNum);
//			System.out.println("Current count: " + RNG.getCount());

			do {
				// Call getNextGuess
				nextGuess = getNextGuess(lowGuess, highGuess, keyboard);

//				while (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
//				nextGuess = keyboard.nextInt();
//				keyboard.nextLine();	// Consume remaining newline
//				}
				
				if (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
					nextGuess = keyboard.nextInt();
					keyboard.nextLine();	// Consume remaining newline
				}
				
				System.out.println("Number of guesses is " + RNG.getCount());
			
				if (nextGuess < randNum) {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				else if (nextGuess > randNum) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				}
				else {
					System.out.println("Congratulations, you guessed correctly");
					continue;	// Break out of current loop
				}
			} while (nextGuess != randNum);
			
			System.out.println("Try again? (yes or no)");
			tryAgain = keyboard.nextLine();
			
		}
		while (tryAgain.equalsIgnoreCase("yes"));
		
		System.out.println("Thanks for playing...");
		System.out.println("Programmer Name: Jessica Bunting");
		keyboard.close();
	}
	/**
	 * The getNextGuess method prompts the user to enter a guess for the unknown random number and returns that guess.
	 * If it is not the user's first guess, the prompt includes the current lower and upper guess limits.
	 * It only except integer input.
	 * @param lowGuess The lower guess limit
	 * @param highGuess The upper guess limit
	 * @param keyboard A Scanner object reference
	 * @return nextGuess The user's current guess for the random number 
	 */
	public static int getNextGuess(int lowGuess, int highGuess, Scanner keyboard) {
		int nextGuess;
		if (RNG.getCount() == 0) {
			System.out.println("Enter your first guess");
		}
		else {
			System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
		}
		// To validate that input is an integer using Scanner hasNextInt method
		while (!keyboard.hasNextInt()) {
			System.out.println("Input is not an integer. Try again.");
			keyboard.next();
		}
		nextGuess = keyboard.nextInt();
		keyboard.nextLine();	// Consume remaining newline
		return nextGuess;
	}	
}
