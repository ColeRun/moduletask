package edu.guilford;

//import arraylsit
import java.util.ArrayList;
import java.util.Random;

import edu.guilford.Deck.Card;

/*
 * This is the class that will control the AI of the bot in poker
 * The code runs properly in this class though it is not implemented in the game, because of the issues
 * present in the Hand class
 * 
 */
public class BotAI {
    // attributes for the AI of the bot in poker

    private ArrayList<Card> hand;
    Random rand = new Random();

    // constructor for the AI of the bot in poker that requires a hand
    public BotAI(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /*
     * THis method is my attempt at making the bot make a decision based on the hand
     * it has
     * Decided to go with a bot that has a higher chance of calling rather than
     * folding
     * running as intended
     */
    public String aidecision() {
        int choiceaffect = rand.nextInt(50) + (Hand.checkhand(hand) + 10);

        if (choiceaffect < 30) {
            return "fold";
        }
        return "call";
    }

}
