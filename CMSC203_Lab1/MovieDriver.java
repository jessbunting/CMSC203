import java.util.Scanner;  // Needed for the Scanner

public class MovieDriver {

	public static void main(String[] args) {
		String movieTitle;	// To hold a movie name the user enters
		String movieRating;	// To hold the movie's rating
		int numTicketsSold; // To hold integer tickets sold
		String enterAnother; // To hold user answer for if they want to repeat
		
		// Create a new object of type Scanner that reads from the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		// Create a new movie object
		Movie someMovie = new Movie();
		
		do {
			// Prompt the user to enter the title of a movie 
			System.out.println("Enter the title of a movie: ");
		
			// Read in the line that the user types
			movieTitle = keyboard.nextLine();
		
			// Set the title in the movie object
			someMovie.setTitle(movieTitle);
		
			// Prompt the user to enter the movie’s rating
			System.out.println("Enter the rating of the movie: ");
		
			// Read in the line that the user types
			movieRating = keyboard.nextLine();
		
			// Set the rating in the movie object
			someMovie.setRating(movieRating);
		
			// Prompt the user to enter the number of tickets sold at a (unnamed) theater
			System.out.println("Enter the number of tickets sold for this movie: ");
		
			// Read in the integer that the user types
			numTicketsSold = keyboard.nextInt();
			
			// Consume the remaining newline character
			keyboard.nextLine();
		
			// Set the number of tickets sold in the movie object
			someMovie.setSoldTickets(numTicketsSold);
		
			// Print out the information using the movie’s toString method
			System.out.println(someMovie);
			
			System.out.println("Do you want to enter another? (y or n)");
			enterAnother = keyboard.nextLine();
		}
		
		while (enterAnother.equalsIgnoreCase("y"));
		
		keyboard.close();
		
		System.out.println();
		System.out.println("Goodbye");
		System.out.println("Student: Jessica Bunting");
	}
}
