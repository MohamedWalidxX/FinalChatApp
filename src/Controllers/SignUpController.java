package Controllers;

import chatPack.App;
import chatPack.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController
{
    // make Your app scene resizable property false.
    @FXML
    private TextField phoneID;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;

    public Stage stage;
    public Scene scene;
    public Parent root;
    public Utilities utilities = new Utilities();
    public App app;
    public static User uSignup=null;
    private Alert alert;
    static setProfile  profile;
    public void switchToLogin(ActionEvent actionEvent) throws IOException {
        utilities.gotoHere("../UI/Login.fxml",actionEvent);
    }
    @FXML
    public void SetProfile(ActionEvent actionEvent) throws IOException, SQLException {
        if(dataValidation(actionEvent))
        {
//            profile = new setProfile();
//            profile.currentUser = u;
            utilities.gotoHere("../UI/SetProfilePhoto.fxml",actionEvent);
        }
    }
    public boolean dataValidation(ActionEvent actionEvent) throws SQLException {
        app = new App();
        uSignup = new User(1, userName.getText(), password.getText(), phoneID.getText());
       int choice= app.userDataValidation(uSignup);
       if(choice==0)
       {
            return true;
       }
       else if(choice==1)
       {
           alert = new Alert("Data Leak","Username exists",stage);
          // alert.openDialog();
       }
       else if(choice==2)
       {
           alert = new Alert("Data Leak","phone nom exists",stage);
          // alert.openDialog();
       }
       else if(choice==-1)
       {
           alert = new Alert("Data Leak","Empty field",stage);
          // alert.openDialog();
       }
        return false;
    }

}
