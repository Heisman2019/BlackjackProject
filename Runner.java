package BlackjackProject;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        int bankroll = 0;
        int minWager = 0;
        int seatPosition = 0;
        int timePlayed = 0;
        Scanner newScanner = new Scanner(System.in);


        //Specify and make sure bankroll is valid
        System.out.print("What is your total Bankroll? (Must be at least $100): ");
        try{
            bankroll = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( bankroll < 100 ){

                System.out.print("The amount of money you entered is not enough. Please enter a dollar amount more than $100: ");
                bankroll = Integer.parseInt( newScanner.nextLine() );
                System.out.println();
            
            }
        }
        catch(NumberFormatException ex){
            System.out.println("You given an input that cannot be converted into an int, please enter another input to satisfy bankroll requirements. (Must be at least $100: ");
            bankroll = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( bankroll < 100 ){

                System.out.print("The amount of money you entered is not enough. Please enter a dollar amount more than $100: ");
                bankroll = Integer.parseInt( newScanner.nextLine() );
                System.out.println();
            
            }
        }
        

        //Specify and make sure minWager is valid
        System.out.print("What is the minimum bet? (Must be at least $10): ");
        try{
            minWager = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( minWager < 10 ){

                System.out.print("The minimum wager produces an unrealistic simulation. Please enter a minimum wager more than $15: ");
                minWager = Integer.parseInt( newScanner.nextLine() );
                System.out.println();

            }
        }
        catch(NumberFormatException ex){
            System.out.println("The minimum wager you entered does not follow the format reqirements of a typical integer. Please enter a valid minimum bet. (Must be at least $10): ");
            minWager = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( minWager < 10 ){

                System.out.print("The minimum wager produces an unrealistic simulation. Please enter a minimum wager more than $15: ");
                minWager = Integer.parseInt( newScanner.nextLine() );
                System.out.println();

            }
        }
        

        //Specify and make sure seatPosition is valid
        System.out.println("What seat would you like to take at the table? (Must be in the range of 1-7): ");
        try{
            seatPosition = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( seatPosition < 1 || seatPosition > 7 ){

                System.out.print("There are only 7 total seats at a blackjack table. Please enter a number from 1-7 indicating what seat you would like to take: ");
                seatPosition = Integer.parseInt( newScanner.nextLine() );
                System.out.println();
            
            }
        }
        catch(NumberFormatException ex){
            System.out.println("The seat you have entered does not follow the format requirements of a typical int. Please enter what seat you would like to take. (Must be in the range of 1-7): ");
            seatPosition = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( seatPosition < 1 || seatPosition > 7 ){

                System.out.print("There are only 7 total seats at a blackjack table. Please enter a number from 1-7 indicating what seat you would like to take: ");
                seatPosition = Integer.parseInt( newScanner.nextLine() );
                System.out.println();
            
            }
        }
        

        //Specify and make sure timePlayed is valid
        System.out.println("How long would you like to play? (Enter a number of whole minutes): ");
        try{
            timePlayed = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( timePlayed < 1 ){

                System.out.print("You have entered an unrealistic amount of time to play blackjack. Please enter an amount of at least 1 minute: ");
                timePlayed = Integer.parseInt( newScanner.nextLine() );
                System.out.println();
            
            }
        }
        catch(NumberFormatException ex){
            System.out.println("The time that you entered does not follow the required format for integers. Please enter how long you would like to play. (Must be a whole number of minutes): ");
            timePlayed = Integer.parseInt( newScanner.nextLine() );
            System.out.println();
            while( timePlayed < 1 ){

                System.out.print("You have entered an unrealistic amount of time to play blackjack. Please enter an amount of at least 1 minute: ");
                timePlayed = Integer.parseInt( newScanner.nextLine() );
                System.out.println();
            
            }
        }
        

        //Create and run the game
        System.out.println("You have specified you want to play blackjack with a minimum wager of $"+minWager+", a total bankroll of $"+bankroll+", in seat position "+seatPosition+", for "+timePlayed+" minutes." );
        BlackjackGame newGame = new BlackjackGame( bankroll, minWager, seatPosition, timePlayed );

        newGame.blackjackGame();

    }
    
}

/*
CHANGES:
added the try catch for each of the inputs to ensure that they are all of the right type when entered.
*/