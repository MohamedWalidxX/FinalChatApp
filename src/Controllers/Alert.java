package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Alert extends Stage
{


    public Alert(String header, String content,Stage curStage)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../UI/Alert.fxml"));
            Scene scene = new Scene(root,300,170);
            setScene(scene);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }
    @FXML
    void openDialog()
    {
        show();
    }
    @FXML
    void closeDialog()
    {
        close();
    }

}



