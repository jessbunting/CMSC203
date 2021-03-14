import java.util.ArrayList;

public class GradeBook
{
   private double[] scores;	// Array to hold scores
   private int scoresSize;	// How many scores currently held in array

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];	// Array to hold scores
      scoresSize = 0;	// How many scores currently held in array
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   /**
    * Gets the number of scores in the array
    * @return scoresSize the number of scores currently held in the scores array
    */
   public int getScoreSize()
   {
	   return scoresSize;
   }
   
   /**
    * Prints each score separated by a space
    * @return scoresPrintList a string with each score in scores separated by a space
    */
   @Override
   public String toString()
   {
	   String scoresPrintList = "";	// Initialized to empty String
	   for (int i = 0; i < scoresSize; i++)
	   {
		   scoresPrintList += scores[i] + " ";
	   }
	   return scoresPrintList;
   }
}
