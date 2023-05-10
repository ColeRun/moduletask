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

//method that checks for a pair


//method that checks for two pair
public boolean pair(ArrayList<Card> hand){
    boolean twopair = false;
    int paircount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() && i != j) {
                paircount++;
            }
        }
    }
    if (paircount == 2) {
        twopair = true;
    }
    return twopair;
}


//method that checks for three of a kind
public boolean threeofakind(ArrayList<Card> hand){
    boolean threeofakind = false;
    int paircount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() && i != j) {
                paircount++;
            }
        }
    }
    if (paircount == 3) {
        threeofakind = true;
    }
    return threeofakind;
}

//method that checks for a straight
public boolean straight(ArrayList<Card> hand){
    boolean straight = false;
    int straightcount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() + 1 && i != j) {
                straightcount++;
            }
        }
    }
    if (straightcount == 5) {
        straight = true;
    }
    return straight;
}

//method that checks for a flush
public boolean flush(ArrayList<Card> hand){
    boolean flush = false;
    int flushcount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getSuit() == hand.get(j).getSuit() && i != j) {
                flushcount++;
            }
        }
    }
    if (flushcount == 5) {
        flush = true;
    }
    return flush;
}

//method that checks for a full house
public boolean fullhouse(ArrayList<Card> hand){
    boolean fullhouse = false;
    int paircount = 0;
    int threeofakindcount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() && i != j) {
                paircount++;
            }
        }
    }
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() && i != j) {
                threeofakindcount++;
            }
        } 
    }
    if (paircount == 2 && threeofakindcount == 3) {
        fullhouse = true;
    }
    return fullhouse;
}




//method that checks for a straight flush
public boolean straightflush(ArrayList<Card> hand){
    boolean straightflush = false;
    int straightcount = 0;
    int flushcount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() + 1 && i != j) {
                straightcount++;
            }
        }
    }
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getSuit() == hand.get(j).getSuit() && i != j) {
                flushcount++;
            }
        }
    }
    if (straightcount == 5 && flushcount == 5) {
        straightflush = true;
    }
    return straightflush;
}


//method that checks for a royal flush
public boolean royalflush(ArrayList<Card> hand){
    boolean royalflush = false;
    int straightcount = 0;
    int flushcount = 0;
    int royalcount = 0;
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getNumber() == hand.get(j).getNumber() + 1 && i != j) {
                straightcount++;
            }
        }
    }
    for (int i = 0; i < hand.size(); i++) {
        for (int j = 0; j < hand.size(); j++) {
            if (hand.get(i).getSuit() == hand.get(j).getSuit() && i != j) {
                flushcount++;
            }
        }
    }
    for (int i = 0; i < hand.size(); i++) {
        if (hand.get(i).getNumber() == "10" || hand.get(i).getNumber() == "Jack" || hand.get(i).getNumber() == "Queen" || hand.get(i).getNumber() == "King" || hand.get(i).getNumber() == "Ace") {
            royalcount++;
        }
    }
    if (straightcount == 5 && flushcount == 5 && royalcount == 5) {
        royalflush = true;
    }
    return royalflush;
}




}