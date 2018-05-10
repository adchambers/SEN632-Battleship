package main;

import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import systemoutgames.AIPlayer;
import systemoutgames.CurrentGameController;
import systemoutgames.Player;

public class ApplicationController {

    @FXML
    private TextField playerName;

    @FXML
    void switchToMain(ActionEvent event) {

        try {

            URL paneOneUrl = getClass().getResource("SceneMainMenu.fxml");
            AnchorPane paneOne = FXMLLoader.load( paneOneUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneOne);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToCredits(ActionEvent event) {

        try {

            URL paneTwoUrl = getClass().getResource("SceneCredits.fxml");
            AnchorPane paneTwo = FXMLLoader.load( paneTwoUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToUsername(ActionEvent event) {

        try {

            URL paneThreeUrl = getClass().getResource("SceneUsername.fxml");
            FXMLLoader loader = new FXMLLoader(paneThreeUrl);
            AnchorPane paneThree = loader.load();

            BorderPane border = Main.getRoot();
            border.setCenter(paneThree);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void submitPlayerName(ActionEvent event) {
        URL shipSelection = getClass().getResource("SceneShipSelection.fxml");
        FXMLLoader loader = new FXMLLoader(shipSelection);

        loader.setController(new CurrentGameController(new Player(playerName.getText()), new AIPlayer("Captain Ahab")));


        AnchorPane paneThree = null;
        try {
            paneThree = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane border = Main.getRoot();
        border.setCenter(paneThree);

    }

    @FXML
    void switchToOptions(ActionEvent event) {

        try {

            URL paneFourUrl = getClass().getResource("SceneOptions.fxml");
            AnchorPane paneFour = FXMLLoader.load( paneFourUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneFour);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToGameplay(ActionEvent event) {

        try {

            URL paneFiveUrl = getClass().getResource("SceneGameplay.fxml");
            AnchorPane paneFive = FXMLLoader.load( paneFiveUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneFive);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToSplashScreen(ActionEvent event) {

        try {

            URL paneSixUrl = getClass().getResource("SceneSplashScreen.fxml");
            AnchorPane paneSix = FXMLLoader.load( paneSixUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneSix);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void switchToAbout(ActionEvent event) {

        try {

            URL paneSevenUrl = getClass().getResource("SceneAbout.fxml");
            AnchorPane paneSeven = FXMLLoader.load( paneSevenUrl );

            BorderPane border = Main.getRoot();
            border.setCenter(paneSeven);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void exitGame(ActionEvent event) {

        Platform.exit();
    }
}