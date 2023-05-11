package edu.guilford;

import java.util.ArrayList;

import edu.guilford.Deck.Card;

/*
 * This is the incredibly important class that ran the backend of the game and checked for winning hands
 * THis is also the class that ended my development of the game, because of the issues I had with it
 * 
 */

public class Hand {
    // attributes for checking a hand of poker for any winning combinations

    static boolean pair = false;
    static boolean twopair = false;
    static boolean threekind = false;
    static boolean fourkind = false;
    static boolean straight = false;
    static boolean flush = false;
    static boolean fullhouse = false;
    static boolean straightflush = false;
    static boolean royalflush = false;
    private int handvalue;

    // method that takes an array list of cards and checks for winning
    // constrcutor that takes a deck and makes a hand, subtracting the cards from
    // the deck

    public static int checkhand(ArrayList<Card> hand) {
        // check hand with each method
        pair(hand);
        straight(hand);
        flush(hand);
        fullhouse(hand);
        straightflush(hand);
        royalflush(hand);
        // check value with each method
        int handvalue = checkvalue();
        return handvalue;

    }

    // getter for handvalue
    public int getHandvalue() {
        return handvalue;
    }

    public static int checkvalue() {
        // if statements returning the value of the hand depending on what checkhand
        // finds
        if (royalflush == true) {
            return 10;
        }
        if (straightflush == true) {
            return 9;
        }
        if (fourkind == true) {
            return 8;
        }
        if (fullhouse == true) {
            return 7;
        }

        if (flush == true) {
            return 6;
        }
        if (straight == true) {
            return 5;
        }
        /*
         * Essentially the method acts as a step for step guide to checking the hand
         * It checks for the highest value hand first, returning immediately on the
         * highest possible combination
         * that the hand has
         */
        if (threekind == true) {
            return 4;
        }
        if (twopair == true) {
            return 3;
        }
        if (pair == true) {
            return 2;
        } else {
            return 0;
        }

    }

    /*
     * Method that takes a Arraylist of cards
     * Checks for pairs, two pairs,
     */
    public static void pair(ArrayList<Card> hand) {
        int paircheck = 100;

        int paircount = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).getNumber() == hand.get(j).getNumber() && i != j && j != paircheck) {
                    paircount++;
                    paircheck = i; // this was a fix to a bug that caused the method to count the same pair twice
                    for (int k = 0; k < hand.size(); k++) {
                        if (hand.get(i).getNumber() == hand.get(j).getNumber()
                                && hand.get(i).getNumber() == hand.get(k).getNumber() && i != j && i != k && j != k) {
                            threekind = true;
                            for (int l = 0; l < hand.size(); l++) {
                                if (hand.get(i).getNumber() == hand.get(j).getNumber()
                                        && hand.get(i).getNumber() == hand.get(k).getNumber()
                                        && hand.get(i).getNumber() == hand.get(l).getNumber() && i != j && i != k
                                        && i != l && j != k && j != l && k != l) {
                                    fourkind = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (paircount == 1) {
            pair = true;

        }
        if (paircount == 2) {
            twopair = true;

        }

    }

    /*
     * Method that checks for a straight
     * Param of Arraylist of cards
     */
    public static boolean straight(ArrayList<Card> hand) {
        boolean straight = false;
        int straightcount = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).getNumber() == hand.get(j).getNumber() + 1 && i != j) {
                    straightcount++;
                }
            }
        }
        if (straightcount == 4) {
            straight = true;
        }
        return straight;
    }

    /*
     * method that checks for a flush
     * param of Arraylist of cards
     */
    public static void flush(ArrayList<Card> hand) {
        flush = false;
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

    }

    /*
     * method that checks for a full house
     * param of Arraylist of cards
     */
    public static void fullhouse(ArrayList<Card> hand) {
        int paircount = 0;
        int threekindcount = 0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).getNumber() == hand.get(j).getNumber() && i != j) {
                    paircount++;
                    for (int k = 0; k < hand.size(); k++) {
                        if (hand.get(i).getNumber() == hand.get(j).getNumber()
                                && hand.get(i).getNumber() == hand.get(k).getNumber() && i != j && i != k && j != k) {
                            threekindcount++;
                        }
                    }
                }
            }
        }
        if (paircount == 1 && threekindcount == 1) {
            fullhouse = true;
        }

    }

    /*
     * These methods are where the main issue of the program appeared
     * The suits do not have a numerical value, so straights are impossible for them
     */

    /*
     * method that checks for a straight flush
     * param of Arraylist of cards
     */
    public static void straightflush(ArrayList<Card> hand) {
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

    }

    /*
     * method that checks for a royal flush
     * param of Arraylist of cards
     */
    public static void royalflush(ArrayList<Card> hand) {
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
            if (hand.get(i).getNumber() == "10" || hand.get(i).getNumber() == "Jack"
                    || hand.get(i).getNumber() == "Queen" || hand.get(i).getNumber() == "King"
                    || hand.get(i).getNumber() == "Ace") {
                royalcount++;
            }
        }
        if (straightcount == 5 && flushcount == 5 && royalcount == 5) {
            royalflush = true;
        }

    }

}