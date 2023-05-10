package edu.guilford;
//import button, label, imageview
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
 
import javafx.scene.layout.Pane;

public class GamePane extends Pane {
    //making a pane for a poker game with 4 players
    Label player = new Label("Player");
    Label bot1 = new Label("Bot 1");
    Label bot2 = new Label("Bot 2");
    Label bot3 = new Label("Bot 3");
    Button deal = new Button("Deal");
    Button fold = new Button("Fold");
    Button call = new Button("Call");
    
    //constructor
    public GamePane(){
        //add the labels and buttons to the pane
        getChildren().addAll(player, bot1, bot2, bot3, deal, fold, call);
        //set the location of the labels and buttons
        //make the background a light green
        //make border a dark brown
        setStyle("-fx-background-color: green; -fx-border-color: darkbrown");
    
        player.setLayoutX(400);
        player.setLayoutY(500);
        bot1.setLayoutX(100);
        bot1.setLayoutY(300);
        bot2.setLayoutX(400);
        bot2.setLayoutY(100);
        bot3.setLayoutX(700);
        bot3.setLayoutY(300);
        deal.setLayoutX(550);
        deal.setLayoutY(400);
        fold.setLayoutX(550);
        fold.setLayoutY(450);
        call.setLayoutX(550);
        call.setLayoutY(500);
    }



    
    
    
}
