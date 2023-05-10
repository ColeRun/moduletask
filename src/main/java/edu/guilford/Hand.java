package edu.guilford;

import java.util.ArrayList;

import edu.guilford.Deck.Card;

public class Hand {
    // attributes for checking a hand of poker for any winning combinations
    private int[] hand;
    private int[] handValue;
    private int[] handSuit;


//method that takes an array list of cards and checks for winning
//constrcutor that takes a deck and makes a hand, subtracting the cards from the deck

public ArrayList handgen( ArrayList<Card> deck, int cardnum){
    ArrayList<Card> hand = new ArrayList<Card>(cardnum);
    for (int i = 0; i < cardnum; i++) {
        hand.add(deck.get(i));
        deck.remove(i);
    }
    return hand;

}
public void checkhand(){

}

private void checkpair(){

}


}