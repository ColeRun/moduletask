package edu.guilford;
//import arraylist
import java.util.ArrayList;
public class Deck {
    //this class will make a deck of cards, and then shuffle them
    //attributes
    //method that returns an ArrayList of 52 cards
    //toString method that returns a string of the deck
    
    public ArrayList<Card> deckgen() {
        //make 52 cards and put them in an arraylist, with no duplicates
        ArrayList<Card> deck = new ArrayList<Card>(52);
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] numbers = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                            "Jack", "Queen", "King"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(suits[i], numbers[j]));
            }

        }
        return deck;
        //method that shuffles the deck
        
    }
    //toString method that will print out deckgen deck
    public String toString(){
        return deckgen().toString();
    }

    public void shuffle(){
        //shuffle the deck
        
    }

    //constructor

    public class Card{
        //attributes
        private String suit;
        private String number;
        //constructor
        //method that creates a card object with a suit and a number
         
        public Card(String suit, String number){
            this.suit = suit;
            this.number = number;
        }
        //method that returns a string of the card
        public String toString(){
            return number + " of " + suit;
        }

        //getters
        public String getSuit(){
            return suit;
        }
        public String getNumber(){
            return number;
        }
        //setters
       
    }
}
