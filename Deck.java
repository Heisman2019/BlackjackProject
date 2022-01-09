package BlackjackProject;
import java.util.Stack;
import java.util.Collections;
import java.util.Random;


//CHANGING LIST TO A STACK:
/*
instantiate the stack
put cards in it using push with same amount of cards going in
to shuffle the stack:
    first just try to use what you have to shuffle (maybe try and figure out why we have to pass a new random in shuffle)
    if that doesnt work try using Collections.shuffle(<name of stack>);
then start a counter that counts how many times the stack is popped and compare that to the cut card position

*/
public class Deck {
    public Stack<Integer> deck = new Stack<>();
    public int cutCardPosition;
    public int topOfDeck;
    
    public Deck(){
        topOfDeck = 0;
        for(int i = 2; i < 10; i++){
            for(int c = 0; c < 24; c++){
                deck.push(i);
            }
        }
        for(int i = 0; i < 96; i++){
            deck.push(10);
        }
        for(int i = 0; i < 24; i++){
            deck.push(11);
        }
        //cut card is randomly placed within the first deck and a half and last deck and a half
        cutCardPosition = (int) Math.floor(Math.random()*(234-79)+78);
        String checkdeck = deck.toString();
        //System.out.println("Unshuffled deck: "+ checkdeck);
        //System.out.println("Now the Deck will be shuffled...");
        Collections.shuffle(deck, new Random());
        checkdeck = deck.toString();
        //System.out.println("Shuffled deck: "+ checkdeck);
        //System.out.println("The cutcard position is "+cutCardPosition);

    }

    public int dealCard(){
        int ret = deck.pop();
        //System.out.println("before the card is drawn the top of the deck is "+topOfDeck);
        topOfDeck++;
        //System.out.println("after card is drawn the top of the deck is "+topOfDeck);
        return ret;
    }

    /*
    Changes made to this:
        instead of having the same code twice I will try to just run the 
        constructor again to reshuffle the deck
        ^^appearantly this isnt possible
    */
    public void reshuffleDeck(){
        deck.clear();
        topOfDeck = 0;
        for(int i = 2; i < 10; i++){
            for(int c = 0; c < 24; c++){
                deck.push(i);
            }
        }
        for(int i = 0; i < 96; i++){
            deck.push(10);
        }
        for(int i = 0; i < 24; i++){
            deck.push(11);
        }
        //cut card is randomly placed within the first deck and a half and last deck and a half
        cutCardPosition = (int) Math.floor(Math.random()*(234-79)+78);
        String checkdeck = deck.toString();
        //System.out.println("Unshuffled deck: "+ checkdeck);
        //System.out.println("Now the Deck will be shuffled...");
        Collections.shuffle(deck, new Random());
        checkdeck = deck.toString();
        //System.out.println("Shuffled deck: "+ checkdeck);
        //System.out.println("The cutcard position is "+cutCardPosition);
    }
}
