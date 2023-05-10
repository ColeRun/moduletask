package edu.guilford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
//import collections
import java.util.Collections;

import edu.guilford.Deck.Card;
//import pane
import javafx.scene.layout.Pane;
import java.io.IOException;

/**
 * JavaFX App
 */
public class GameDisplay extends Application {

    private static Scene scene;
    Deck deck = new Deck();
    
    
    @Override
    public void start(Stage stage) throws IOException {
        //make a pane with GamePane class
        Pane pane = new GamePane();


        
        //make a deck
        ArrayList<Card> playdeck = deck.deckgen();
        //shuffle the deck
        Collections.shuffle(playdeck);
        //make a hand for the player with 5 cards
        //ArrayList<Card> playerhand = deck.handgen(deck, 5);

        //ArrayList had1 = Hand.handgen(deck, 5);
        //print the deck
        System.out.println(playdeck); 
        scene = new Scene(pane , 800, 600);
        stage.setScene(scene);
        stage.show();
      
    }

   


    public static void main(String[] args) {
        launch();
    }

}