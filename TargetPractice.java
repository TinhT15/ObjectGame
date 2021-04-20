
/**
 * Write a description of class TargetPractice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class TargetPractice
{
    public static void main(String[] args) {
    System.out.print("\u000C");
    
    TargetPracticeObject theTargetBoard = new TargetPracticeObject();   // Create a new object to hold the solution grid
    theTargetBoard.setTargetAtPosition(0,3,9); // Set a target at position 0,3        
    theTargetBoard.setTargetAtPosition(1,2,9); // Set a target at position 1,2    
    theTargetBoard.setTargetAtPosition(2,4,9); // Set a target at position 2,4  
    theTargetBoard.setTargetAtPosition(3,1,9); // Set a target at position 3,1   
    theTargetBoard.setTargetAtPosition(4,0,9); // Set a target at position 4,0
    
    TargetPracticeObject theUserGrid = new TargetPracticeObject();   // Create a new object to hold the user grid
    
    TargetPracticeObject theTestGrid = new TargetPracticeObject();   // Create a new object to hold the test grid
            
    Scanner myScanner = new Scanner(System.in);
    
    boolean gameOver = false;
    int targetTracker1 = 0;
    int targetTracker2 = 0;

    do 
        {        
            System.out.println("Player 1: Enter Row space Column starting at upper left corner as 0,0.");
            int row = myScanner.nextInt();
            int column = myScanner.nextInt();
            int value = theTargetBoard.getTargetAtPosition(row,column);
            theUserGrid.setTargetAtPosition(row,column,value);
            if (theUserGrid.hitATarget(row,column))
            {
                theUserGrid.printGrid();
                targetTracker1++;
                if (targetTracker1 == 3)
                {
                    System.out.println("Player 1, you hit three targets! You won!\uD83D\uDE42");
                    gameOver = true;
                }
                else if (theTestGrid.areAllTargetsMissed())
                {
                     System.out.println("Sorry Player 1! You just filled the entire board without hitting a target! \u2639");
                     theTargetBoard.printGrid();
                     gameOver = true;
                }
            }
            else
            {
                int numberOfMines = theTargetBoard.getNumberOfTargetsNearPosition(row,column);
                theUserGrid.setTargetAtPosition(row,column,numberOfMines);
                theUserGrid.printGrid();
            }
            
            if (gameOver == false)
            {
                System.out.println("Player 2: Enter Row space Column starting at upper left corner as 0,0.");
                row = myScanner.nextInt();
                column = myScanner.nextInt();
                value = theTargetBoard.getTargetAtPosition(row,column);
                theUserGrid.setTargetAtPosition(row,column,value);
                if (theUserGrid.hitATarget(row,column))
                {
                    targetTracker2 = targetTracker2 + 2;
                    theUserGrid.printGrid();
                    if (targetTracker2 == 3)
                    {
                        System.out.println("Player 2, you hit three targets! You won!\uD83D\uDE42");
                        gameOver = true;
                    }
                    else if (theTestGrid.areAllTargetsMissed())
                    {
                        System.out.println("Sorry Player 2! You just filled the entire board without hitting a target! \u2639");
                        theTargetBoard.printGrid();
                        gameOver = true;
                    }
                }
                else
                {
                    int numberOfMines = theTargetBoard.getNumberOfTargetsNearPosition(row,column);
                    theUserGrid.setTargetAtPosition(row,column,numberOfMines);
                    theUserGrid.printGrid();
                }
            }        
        }
        while (gameOver == false);
   }
}
