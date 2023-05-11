package edu.guilford;

//import arraylist
import java.util.ArrayList;

public class Deck {
    /*
     * This is the deck class that will make a deck of cards
     * This is running as intended
     * The class is the core of the game, as it makes the deck, and the hands
     * The cards are Strings, with a number and a suit
     * the numbers are what lead to the hand being evaluated incorrectly
     *
     */

    public ArrayList<Card> deckgen() {
        // make 52 cards and put them in an arraylist, with no duplicates
        ArrayList<Card> deck = new ArrayList<Card>(52);
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] numbers = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King" };
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(suits[i], numbers[j]));
            }

        }
        return deck;

    }

    // toString method that will print out deckgen deck
    public String toString() {
        return deckgen().toString();
    }

    // method for making a hand, and subtracting it from the deck
    public ArrayList<Card> handgen(ArrayList<Card> deck, int cardnum) {
        ArrayList<Card> hand = new ArrayList<Card>(cardnum);
        for (int i = 0; i < cardnum; i++) {
            int card = (int) ((Math.random() * deck.size()));
            hand.add(deck.get(card));
            deck.remove(card);
        }
        return hand;
    }

    // constructor

    public class Card {
        // attributes
        private String suit;
        private String number;
        // constructor
        // method that creates a card object with a suit and a number

        public Card(String suit, String number) {
            this.suit = suit;
            this.number = number;
        }

        // method that returns a string of the card
        public String toString() {
            return number + " of " + suit;
        }

        // getters
        public String getSuit() {
            return suit;
        }

        public String getNumber() {

            return number;
        }
        // setters

    }
}
