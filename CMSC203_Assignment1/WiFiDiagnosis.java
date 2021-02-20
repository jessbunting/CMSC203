package assignments.assignment1;
import java.util.Scanner;    // Needed for the Scanner class

/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: A program that suggests possible steps to take to restore wi-fi connectivity.
 * Due: 2/20/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/


public class WiFiDiagnosis {
	public static void main(String[] args) {
		
		// Print application header
		System.out.println();
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
		System.out.println();
		
		// Create a new object of type Scanner that reads input from the keyboard
		Scanner keyboard = new Scanner(System.in);

		// Display Step 1, then ask if it worked
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		
		// Get user input yes or no
		String stepOne = keyboard.nextLine();
		
		if (stepOne.equalsIgnoreCase("yes") || stepOne.equalsIgnoreCase("y")) {
			System.out.println("Rebooting your computer seemed to work");
		}
		else {
			// Display Step 2, then ask if it worked
			System.out.println("Second step: reboot your router");
			System.out.println("Now are you able to connect with the internet? (yes or no)");
			
			// Get user input yes or no
			String stepTwo = keyboard.nextLine();
			
			if (stepTwo.equalsIgnoreCase("yes") || stepTwo.equalsIgnoreCase("y")) {
				System.out.println("Rebooting your router seemed to work");
			}
			else {
				// Display Step 3, then ask if it worked
				System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
				System.out.println("Now are you able to connect with the internet? (yes or no)");
				
				// Get user input yes or no
				String stepThree = keyboard.nextLine();
				
				if (stepThree.equalsIgnoreCase("yes") || stepThree.equalsIgnoreCase("y")) {
					System.out.println("Checking the router's cables seemed to work");
				}
				else {
					// Display step 4, then ask if it worked
					System.out.println("Fourth step: move your computer closer to your router");
					System.out.println("Now are you able to connect with the internet? (yes or no)");
					
					// Get user input yes or no
					String stepFour = keyboard.nextLine();
					
					if (stepFour.equalsIgnoreCase("yes") || stepFour.equalsIgnoreCase("y")) {
						System.out.println("Moving your computer closer to your router seemed to work");
					}
					else {
						// Display Step 5 if Step 4 did not work
						System.out.println("Fifth step: contact your ISP");
						System.out.println("Make sure your ISP is hooked up to your router.");
					}
				}
    		}
    	}
		// Close the Scanner keyboard
		keyboard.close();
		System.out.println();
		System.out.println("Done.");
		System.out.println("Programmer Name: Jessica Bunting");
	}
}




