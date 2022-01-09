package BlackjackProject;

public class DealerHand extends Hand{
    //dealer hits on soft 17
    //show the card that is in the first index
    private int topCard;
    //initially i had it where you would pass two cards to the dealer
    //when the object was initiallized, however i think it will be better if 
    //i dont initallize the hand here and make a dealer hit method similar to the
    // hand hit method that adds cards to the dealers hand
    //NEW PROBLEM: need to create a new way to store the showing card
    public DealerHand(){
        //topCard = cardOne;
        super();
    }

    
    public void dealerHit(int card){
        hand.add(card);
        handCount+=card;
        if(getHandSize()<2){
            topCard = card;
        }
        if(handCount>=21){
            if(hand.contains(11)){
                int aceIndex = hand.lastIndexOf(11);
                hand.set(aceIndex, 1);
            }
            else{
                bust = true;
            }
        }
        else if(handCount == 21 && hand.size()<3){
            isBlackjack = true;
        } 
    }

    public int getTopCard(){
        return topCard;
    }
}
