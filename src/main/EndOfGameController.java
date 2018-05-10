package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import systemoutgames.AIPlayer;
import systemoutgames.CurrentGameController;
import systemoutgames.Player;
import systemoutgames.SoundPlayer;

import java.io.IOException;
import java.net.URL;

public class EndOfGameController {

    private Player playerOne;
    private Player playerTwo;
    private Player winner;

    @FXML
    private Label endOfGameText;

    @FXML
    private Button playAgain;

    @FXML
    private  Button goToMain;

    public EndOfGameController(Player playerOne, Player playerTwo, Player winner) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winner = winner;
    }

    public void initialize() {

        goToMain.setDisable(true);
        playAgain.setDisable(true);

        if(playerOne == winner) {
            endOfGameText.setText("Congratulations " + playerOne.getName() + " You Win!!!");
            new Thread(() -> {
                SoundPlayer.PlaySound("Win.wav");
                Platform.runLater(() -> {
                    goToMain.setDisable(false);
                    playAgain.setDisable(false);
                });
            }).start();

        } else {
            endOfGameText.setText("Sorry " + playerOne.getName() + " You Lose!!!");
            new Thread(() -> {
                SoundPlayer.PlaySound("Lose.wav");
                Platform.runLater(() -> {
                    goToMain.setDisable(false);
                    playAgain.setDisable(false);
                });
            }).start();
        }
    }

    @FXML
    public void playAgain(ActionEvent ev) {
        URL shipSelection = getClass().getResource("SceneShipSelection.fxml");
        FXMLLoader loader = new FXMLLoader(shipSelection);

        loader.setController(new CurrentGameController(new Player(playerOne.getName()), new AIPlayer("Captain Ahab")));


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
    public  void goToMainMenu(ActionEvent ev) {
        try {

            URL paneThreeUrl = getClass().getResource("SceneMainMenu.fxml");
            FXMLLoader loader = new FXMLLoader(paneThreeUrl);
            AnchorPane paneThree = loader.load();

            BorderPane border = Main.getRoot();
            border.setCenter(paneThree);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
