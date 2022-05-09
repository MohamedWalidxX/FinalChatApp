package Controllers;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utilities {
    public Stage stage;
    public Scene scene;
    public Parent root;

    public  void gotoHere(String link, Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(link));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1540 ,790);
        stage.setScene(scene);
        stage.show();
    }

}
