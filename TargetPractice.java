
/**
 * Write a description of class TargetPractice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Random;

public class TargetPractice
{
    public static void main(String[] args) {
    System.out.print("\u000C");
    
    TargetPracticeObject theTargetBoard = new TargetPracticeObject();   // Create a new object to hold the solution grid
    
    Random rand = new Random();
    int upperBound = 4;
    // Generate random numbers for x and y coordinates
    int x = rand.nextInt(upperBound);
    int y = rand.nextInt(upperBound);
    theTargetBoard.setTargetAtPosition(x,y,9); // Set a target at position x,y   
    
    // For testing print out random coordinates
    // System.out.println("x=" + x + ", y=" + y);
    
    TargetPracticeObject theUserGrid = new TargetPracticeObject();   // Create a new object to hold the user grid
                
    Scanner myScanner = new Scanner(System.in);
    
    boolean gameOver = false;
    int targetTracker1 = 0;
    int targetTracker2 = 0;

    do 
        {        
            theUserGrid.printGrid();
            System.out.println("Player 1: Enter Row space Column starting at upper left corner as 0,0.");
            int row = myScanner.nextInt();
            int column = myScanner.nextInt();
            int value = theTargetBoard.getTargetAtPosition(row,column);
            theUserGrid.setTargetAtPosition(row,column,value);
            if (theUserGrid.hitATarget(row,column))
            {
                System.out.println("Congradulations Player 1! You won! \uD83D\uDE42 ");
                gameOver = true;
            }
            else
            {
                theUserGrid.setTargetAtPosition(row,column,1);
                System.out.println("You missed! \u2639 ");
            }
            theUserGrid.printGrid();
            
            if (gameOver == false)
            {
                System.out.println("Player 2: Enter Row space Column starting at upper left corner as 0,0.");
                row = myScanner.nextInt();
                column = myScanner.nextInt();
                value = theTargetBoard.getTargetAtPosition(row,column);
                theUserGrid.setTargetAtPosition(row,column,value);
                 if (theUserGrid.hitATarget(row,column))
                {
                    System.out.println("Congradulations Player 2! You won! \uD83D\uDE42 ");
                    gameOver = true;
                }
                else
                {
                    theUserGrid.setTargetAtPosition(row,column,1);
                    System.out.println("You missed! \u2639 ");
                }
               theUserGrid.printGrid();                
            }        
        }
        while (gameOver == false);
   }
}
