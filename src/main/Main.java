package main;

import java.io.IOException;
import java.net.URL;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    //pause for splash screen animation
    PauseTransition delay = new PauseTransition(Duration.seconds(22.67));

    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot() {

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //load menu bar
        URL menuBarUrl = getClass().getResource("SceneMenuBar.fxml");
        MenuBar bar = FXMLLoader.load( menuBarUrl );

        //load scene for splash screen
        URL paneOneUrl = getClass().getResource("SceneSplashScreen.fxml");
        AnchorPane paneOne = FXMLLoader.load( paneOneUrl );

        //load scene for main menu
        URL paneTwoUrl = getClass().getResource("SceneMainMenu.fxml");
        AnchorPane paneTwo = FXMLLoader.load( paneTwoUrl );

        //set menu bar to top border pane position
        root.setTop(bar);

        //set splash screen oto center/lower border pane position (at startup)
        root.setCenter(paneOne);

        //change scene from splash screen to main menu after 22.67 seconds
        delay.setOnFinished( event -> root.setCenter(paneTwo) );
        delay.play();

        //set stage size to 800 x 625 (width x height) and load cascading style sheet styles...add 25 px to height to include top menu bar
        Scene scene = new Scene(root, 800, 625);
        scene
                .getStylesheets()
                .add(getClass()
                        .getResource("ApplicationSceneStyles.css")
                        .toExternalForm());

        //set stage title
        primaryStage.setTitle("System.out.gaming Presents: BATTLESHIP");

        //load scene
        primaryStage.setScene(scene);

        //show stage on startup
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}