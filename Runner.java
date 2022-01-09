package BlackjackProject;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        int bankroll = 0;
        int minWager = 0;
        int seatPosition = 0;
        int timePlayed = 0;
        Scanner newScanner = new Scanner(System.in);

        System.out.println("What is your total Bankroll? (Must be at least $100): ");
        bankroll = Integer.parseInt( newScanner.nextLine() );

        System.out.println("What is the minimum bet? (Must be at least $10): ");
        minWager = Integer.parseInt( newScanner.nextLine() );

        System.out.println("What seat would you like to take at the table? (Must be in the range of 1-7): ");
        seatPosition = Integer.parseInt( newScanner.nextLine() );

        System.out.println("How long would you like to play? (Enter a number of whole minutes): ");
        seatPosition = Integer.parseInt( newScanner.nextLine() );



    }
    
}
