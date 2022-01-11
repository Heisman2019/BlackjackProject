package BlackjackProject;
import java.util.ArrayList;



public class BlackjackGame {
    private ArrayList<PlayerHand> playingHands = new ArrayList<>();
    private DealerHand dealer;
    private Deck gameDeck;
    private int totalBlackjacks;
    private int bankroll;
    private int minWager;
    private int seatPosition;
    private int totalHandsPlayed;
    
    //NEW NOTE: assume each round takes 1 minute
    //so when i store all of the hands in a list of hands together it doesnt allow me to access them as player or dealer hands
    //whe i use get method it only allows me to use them as hands
    //so i will be changing the list of hands to a list of player hands and just store the dealer hand in its own separate variable
    public BlackjackGame(int bankroll, int minWager, int seatPosition, int timePlayed){
        for(int i = 0; i < 7; i++){

            PlayerHand newPlayer = new PlayerHand();
            if(seatPosition-1 == i){
                newPlayer.togglePlayerStatus();
            }
            playingHands.add( newPlayer );
            
            
        }
        //System.out.println(playingHands.get(seatPosition-1).getIsPlayerHand());

        dealer = new DealerHand();
        gameDeck = new Deck();
        totalBlackjacks = 0;
        
        this.bankroll = bankroll;
        this.minWager = minWager;
        this.seatPosition = seatPosition;
        this.totalHandsPlayed = timePlayed;

    }

    public int aceMove( PlayerHand hand, DealerHand dHand ){ //returns 0 to stay, 1 to hit, and 2 to double
        if( hand.handCount == 20 ){
            
            return 0;
        
        }
        else if( hand.handCount == 19 && dHand.getTopCard() == 6 ){//if you have an ace and an eight and the dealer has a six
            
            return 2;
        
        }
        else if( hand.handCount == 18 ){ //if you have an ace and a 7
            
            if( dHand.getTopCard()>8 ){ //if the dealer is showing 9 10 or 11

                return 1;
            
            }
            else if( dHand.getTopCard() < 7 ){ // if the dealer is showing a 2 3 4 5 or 6
                
                return 2;
            
            }
            else{
                
                return 0;
            
            }

        }
        else if( hand.handCount == 17 ){
            
            if( dHand.getTopCard() < 3 && dHand.getTopCard() > 6 ){
                
                return 1;
            
            }
            else{
            
                return 2; 
           
            }

        }
        else if( hand.handCount == 16 || hand.handCount == 15 ){
            
            if( dHand.getTopCard() < 4 && dHand.getTopCard() > 6 ){
                
                return 1;
            
            }
            else{
            
                return 2; 
            
            }

        }
        else if( hand.handCount == 14 || hand.handCount == 13 ){
            
            if( dHand.getTopCard() < 5 && dHand.getTopCard() > 6 ){
            
                return 1;
            
            }
            else{
            
                return 2;
            
            }
        
        }
        else{
            
            return 0;
       
        }
    
    }


    public boolean shouldSplit( PlayerHand hand, DealerHand dHand ){
        int cardOne = hand.hand.get( 0 );
        // MAY NOT NEED THIS LINE int cardTwo = hand.hand.get(1);

        if( hand.getCanSplit() ){
            
            if( cardOne<4 ){//if you have double twos or threes
            
                if( dHand.getTopCard() < 8 ){
            
                    return true;
            
                }
            
            }
            else if( cardOne == 4 ){ //if you have double fours
                
                if( 4 < dHand.getTopCard() && dHand.getTopCard() < 7 ){
                
                    return true;
                
                }
            
            }
            else if( cardOne == 6 ){//if you have double sixes
                
                if( dHand.getTopCard() < 7 ){
                
                    return true;
                
                }
            
            }
            else if( cardOne == 7 ){//if you have double sevens
                
                if( dHand.getTopCard() < 8 ){
                
                    return true;
                
                }
            
            }
            else if( cardOne == 8 ){//if you have double eights
                
                return true;
            
            }
            else if( cardOne == 9 ){//if you have double nines
                
                if( dHand.getTopCard() != 7 && dHand.getTopCard() < 10 ){
                    
                    return true;
                
                }
            
            }
            else if( cardOne == 11 ){//if you have double aces
                
                return true;
            
            }
        
        }
        return false;

    }
    
    //what kind of hand is it
    //if player:
    //is the hand a blackjack
        //if so add to the total blackjacks and end the turn
    //can the hand be split
        //do something
    //does the hand contain an ace
        //do something
    //does the hand require a double down
    //otherwise do what top of card says for the turn
    //if dealer:
    //if dealer has blackjack
        //end the turn*********************this should be done somewhere outside of turn method
    //if the hand is less than 17 or equal to a soft 17
        //hit
    //go about business as usual and end turn when it needs to be ended
    public void turn( PlayerHand hand ){//*********************** i think we should have two versions of this method one where you pass a player hand and the other where you pass a dealer hand */
        int aMove = 0;
        
        if( hand.getIsBlackjack() ){ //if the player has a blackjack
        
            //System.out.println( "this should never print" );//consider deleting this whole if statement
            return;
        
        }
        if( shouldSplit( hand, dealer ) ){ //can the player split the hand
            //System.out.println("SPLIT");
            PlayerHand splittedHand = hand.split(); //split the hand and store the new hand in htis variable
            if( hand.getIsPlayerHand() ){
                splittedHand.togglePlayerStatus();
            }
            hand.hit( gameDeck.dealCard() ); //hit and add a card to the hand we are on currently so it has two cards like normal
            splittedHand.hit( gameDeck.dealCard() ); //add a card to the splitted card so it has two cards like normal
            playingHands.add( playingHands.indexOf(hand)+1, splittedHand ); //add the splitted hand to the next index after the current hand of the list of hands playing in the game
            //System.out.println("SPLIT");

        }
        if( hand.hand.contains(11) ){ //what to do if one of the cards are an ace
            aMove = aceMove( hand, dealer );
            if( aMove == 0 ){}
            if( aMove == 1 ){
                
                hand.hit( gameDeck.dealCard() );
            
            }
            else{
                
                hand.hit(gameDeck.dealCard());
                hand.doubleDown();
            
            }
        }
        if( !hand.getDD() ){
            
            while( hand.handCount < 17 ){
            
                hand.hit( gameDeck.dealCard() );//ENDED HERE JUST GO BAKC THROUGH AND MAKE SURE YOU SET UP THE TURNS RIGHT AND THEN YOU CAN START ON THE ROUND METHOD
            
            }
        
        }
    }

    public void turn( DealerHand hand  ){
        while( hand.handCount < 17 ){
            
            hand.dealerHit( gameDeck.dealCard() );
        
        }
        if( hand.handCount == 17 && hand.hand.contains( 11 ) ){
            
            hand.dealerHit( gameDeck.dealCard() );
            
            while( hand.handCount < 17 ){
            
                hand.dealerHit( gameDeck.dealCard() );
            
            }
        
        }
    
    }
    /*CHANGES THAT NEED TO BE MADE:

    */
    public void blackjackGame(){
        
        for(int i = 0; i<totalHandsPlayed; i++ ){
            int sp = seatPosition - 1;
            if( !( gameDeck.topOfDeck < gameDeck.cutCardPosition ) ){//correction!!!!!! if the top of the deck is not less than the cut card position then shuffle--- no else statment because
                //the only thing you are checking here is if it needs to be shuffled and regardless if it does the other things still need to happen    
               
                gameDeck.reshuffleDeck();

            }
           
            for( int d = 0; d < playingHands.size(); d++ ){
                
                for( int h = 0; h < 2; h++ ){
                    
                    playingHands.get(d).hit(gameDeck.dealCard());
                
                }
                //took out the code here that incremented total hands played
            
            }
            
            dealer.dealerHit( gameDeck.dealCard() );
            dealer.dealerHit( gameDeck.dealCard() );
            
            if( dealer.getIsBlackjack() ){
                //INSERT CODE HERE THAT SHOWS WHAT TO DO IF DEALER WINS
                //player loses bet and bankroll is updated
                if( playingHands.get( seatPosition-1 ).getIsBlackjack() ){

                }
                else{
                    bankroll -= minWager;
                }
            }
            else{
                
                for( int t = 0; t < playingHands.size(); t++ ){
                    
                    //System.out.println(playingHands.get(t).hand.get(0)+" "+playingHands.get(t).hand.get(1));
                    if( playingHands.get(t).getIsBlackjack() && playingHands.get(t).getIsPlayerHand()){
                        
                        System.out.println("BLACKJACK");
                        bankroll += (minWager*1.5);
                    
                    }
                    else{
                        
                        turn(playingHands.get(t));
                    
                    }
                
                }
                turn(dealer);
                System.out.println(sp);
                System.out.println(playingHands.get( sp ).getIsPlayerHand());
                while(playingHands.get( sp ).getIsPlayerHand()){
                    System.out.println(sp);
                    if( playingHands.get( sp ).handCount > dealer.handCount ){
                        if(playingHands.get( sp ).getDD()){
                            bankroll += 2 * minWager;
                        }
                        else{
                            bankroll += minWager;
                        }
                        
                    }
                    else if( playingHands.get( sp ).handCount < dealer.handCount ){
                        if(playingHands.get( sp ).getDD()){
                            bankroll -= 2 * minWager;
                        }
                        else{
                            bankroll -= minWager;
                        }
                        //STOPPED HERE CHECK IF TIHS WORKS ESPECIALLY THE MANAGEMENT OF DOUBLEING DOWN BETS AND REWARDS
                    }
                    sp++;
                }


                sp = seatPosition - 1;
            }
            dealer.resetHand();
            for( int r = 0; r < playingHands.size(); r++ ){
                
                playingHands.get(r).resetHand();
                if(playingHands.get(r).getIsPlayerHand()){
                    playingHands.get(r).togglePlayerStatus();
                }
            
            }
            while( playingHands.size() > 7 ){
                
                playingHands.remove(playingHands.size()-1);
            
            }
            playingHands.get(seatPosition-1).togglePlayerStatus();////ALL YOU NEED TO DO IS TAKE IT FROM THE TOP, UNDERSTAND THE CODE AND FIGURE OUT WHY THERE IS ONE FALSE EVERY ONCE AND A WHILE AND IF THE CODE IS WORKING CORRECTLY
            
        }

        System.out.println("Bankroll after playing " + totalHandsPlayed + " hands: $"+bankroll);
    
    }

    public int getTotalBlackjacks(){
        
        return totalBlackjacks;
    
    }
}
