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
 * This is the main class that will run the poker game
 * //Cals to GamePane that sets most of the FX up
 * This is running as intended
 */
public class GameDisplay extends Application {

    private static Scene scene;

    @Override

    public void start(Stage stage) throws IOException {
        // make a pane with GamePane class
        Pane pane = new GamePane();

        scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}