package BlackjackProject;

import java.util.ArrayList;

public class Hand {
    public ArrayList<Integer> hand = new ArrayList<>();
    public int handCount;
    public boolean isBlackjack;
    public boolean bust;
    public Hand(){
        bust = false;
        isBlackjack = false;
        handCount = 0;
    }

    
    

    

    public void resetHand(){
        handCount = 0;
        isBlackjack = false;
        bust = false;
        hand.clear();
    }

    public boolean getIsBlackjack(){
        return isBlackjack;
    }

    public boolean getBust(){
        return bust;
    }

    public int getHandSize(){
        return hand.size();
    }

    public int getHandCount(){
        return handCount;
    }

    public int getSpecificCard(int index){
        return hand.get(index);
    }
}
