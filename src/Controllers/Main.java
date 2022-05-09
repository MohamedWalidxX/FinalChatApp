package Controllers;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import chatPack.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage)  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../UI/Login.fxml"));
            Scene scene = new Scene(root,1540 ,790);
           /* String css = this.getClass().getResource("textfield.css").toExternalForm();
            scene.getStylesheets().add(css);*/
            stage.getIcons().add(new Image("/resources/img/ico.png"));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }
    public static void main(String args[]) throws Exception{
       launch(args);
    }

}
