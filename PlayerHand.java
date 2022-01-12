package BlackjackProject;

public class PlayerHand extends Hand {
    private boolean canSplit;
    private boolean hasDoubledDown;
    private boolean isPlayerHand;
    public PlayerHand(){
        super();
        canSplit = true;
        hasDoubledDown = false;
        isPlayerHand = false;
    }
    
    public void hit(int card){

        hand.add(card);
        handCount+=card;
        if(hand.size() == 2 && hand.get(0) == hand.get(1)){
            canSplit = true;
        }
        else{
           canSplit = false;
        }
        if(handCount>21){
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
    public PlayerHand split(){
        PlayerHand splitHand = new PlayerHand();
        if(hand.get(1)==1){
            splitHand.hit(11);
            handCount = handCount - hand.get(1);
            hand.remove(1);
        }
        else{
            splitHand.hit(hand.get(1));
            handCount = handCount - hand.get(1);
            hand.remove(1);
        }
        if(isPlayerHand == true){
            splitHand.togglePlayerStatus();
        }
        return splitHand;
    }

    public void doubleDown(){
        hasDoubledDown = true;
    }

    public boolean getDD(){
        return hasDoubledDown;
    }
    
    public boolean getCanSplit(){
        return canSplit;
    }

    public void togglePlayerStatus(){
        if(isPlayerHand == true){
            isPlayerHand = false;
        }
        else{
            isPlayerHand = true;
        }
    }

    public boolean getIsPlayerHand(){
        return isPlayerHand;
    }
}
