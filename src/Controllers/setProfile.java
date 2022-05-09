package Controllers;

import chatPack.App;
import chatPack.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class setProfile
{
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    public GridPane pane;
    @FXML
    private TextField userDesc;
    @FXML
    private ImageView userImage;
    @FXML
    public User currentUser = SignUpController.uSignup;
    App app;
    String imageLink ="./resources/img/icons8-user-90.png";
    Utilities utilities =new Utilities();

   @FXML
   public void chooseImage(ActionEvent actionEvent) throws SQLException, FileNotFoundException {
       currentUser.setUserImageLink(imageLink);
       FileChooser fileChooser = new FileChooser ();
       fileChooser.setTitle("Upload Image");
       Stage stage = (Stage) pane.getScene().getWindow();
       File selectedFile = fileChooser.showOpenDialog(stage);
       if (selectedFile == null)
           return;
       imageLink = selectedFile.getAbsolutePath();
       currentUser.setUserImageLink(imageLink);
       userImage.setImage(new Image(imageLink));
//       System.out.println("Not cancelled");
   }

    public void switchToHome(ActionEvent actionEvent) throws SQLException, IOException {
        app = new App();
        String userDes=userDesc.getText();
        if(!userDes.equals(""))
        {
            currentUser.setProfileDesc(userDes);
        }
        app.registerForUser(currentUser);
        utilities.gotoHere("../UI/home_view.fxml",actionEvent);
    }
}

