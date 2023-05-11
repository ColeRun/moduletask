package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import edu.guilford.Hand;
import edu.guilford.Deck.Card;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;

public class GamePane extends Pane {
    // making a pane for a poker game with 4 players, one of which is the player,
    // and 3 AI
    Label player = new Label("Player");
    Label bot1title = new Label("Bot 1");
    Label bot2title = new Label("Bot 2");
    Label bot3title = new Label("Bot 3");
    Button deal = new Button("Deal");
    Button fold = new Button("Fold");
    Button call = new Button("Call");

    /*
     * This is the constructor for the GamePane class
     * All components are located here, as well as the code that runs the Hand class
     * to find
     * value and calculate teh winner
     */
    public GamePane() {

        Deck deck = new Deck();
        getChildren().addAll(player, bot1title, bot2title, bot3title, deal, fold, call);

        ArrayList<Card> playdeck = deck.deckgen();
        Collections.shuffle(playdeck);
        Collections.shuffle(playdeck);

        // ArrayList had1 = Hand.handgen(deck, 5);
        // print the deck
        System.out.println(playdeck);
        ArrayList<Card> playerhand = deck.handgen(playdeck, 5);
        ArrayList<Card> bot1hand = deck.handgen(playdeck, 5);
        ArrayList<Card> bot2hand = deck.handgen(playdeck, 5);
        ArrayList<Card> bot3hand = deck.handgen(playdeck, 5);
        BotAI bot1 = new BotAI(bot1hand);
        BotAI bot2 = new BotAI(bot2hand);
        BotAI bot3 = new BotAI(bot3hand);
        System.out.println(bot1hand);
        System.out.println(bot2hand);
        System.out.println(bot3hand);
        /*
         * This is where I realized something was wrong
         * the trial runs always came up with 3 or 0, rather than the many other options
         * I fixed the issue of always getting two pairs
         * Though I realized the royals were not working
         */
        int playerhandvalue = Hand.checkhand(playerhand);
        int bot1handvalue = Hand.checkhand(bot1hand);
        int bot2handvalue = Hand.checkhand(bot2hand);
        int bot3handvalue = Hand.checkhand(bot3hand);
        // print the values of the hands
        System.out.println(playerhandvalue);
        System.out.println(bot1handvalue);
        System.out.println(bot2handvalue);
        System.out.println(bot3handvalue);

        Label playerhandlabel = new Label(playerhand.toString());
        Label bot1handlabel = new Label(bot1hand.toString());
        Label bot2handlabel = new Label(bot2hand.toString());
        Label bot3handlabel = new Label(bot3hand.toString());

        getChildren().addAll(playerhandlabel, bot1handlabel, bot2handlabel, bot3handlabel);
        // setting the location of the labels
        playerhandlabel.setLayoutX(400);
        playerhandlabel.setLayoutY(500);
        bot1handlabel.setLayoutX(100);
        bot1handlabel.setLayoutY(300);
        bot2handlabel.setLayoutX(400);
        bot2handlabel.setLayoutY(100);
        bot3handlabel.setLayoutX(700);
        bot3handlabel.setLayoutY(300);

        setStyle("-fx-background-color: green;");

        player.setLayoutX(400);
        player.setLayoutY(500);
        bot1title.setLayoutX(100);
        bot1title.setLayoutY(300);
        bot2title.setLayoutX(400);
        bot2title.setLayoutY(100);
        bot3title.setLayoutX(700);
        bot3title.setLayoutY(300);
        deal.setLayoutX(550);
        deal.setLayoutY(400);
        fold.setLayoutX(550);
        fold.setLayoutY(450);
        call.setLayoutX(550);
        call.setLayoutY(500);

    }

}
