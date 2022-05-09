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

public class LoginController
{

@FXML
private TextField userName;
@FXML
private PasswordField password;

private Alert alert;
public Stage stage;
public Scene scene;
public Parent root;
public App app;
public static User uLogin=null;
public Utilities utilities = new Utilities();

public void switchToHome(ActionEvent actionEvent) throws SQLException, IOException {
    stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    app = new App();
    String userNameDB = userName.getText();
    String passwordDB = password.getText();
    uLogin = new User(-1, userNameDB, passwordDB);
    int loginAlert = app.loginValidation(uLogin);// 0 -> Alert  ,1 -> home
    if (loginAlert==1)
    {
        uLogin = new User(-1,userNameDB,passwordDB);
        utilities.gotoHere("../UI/home_view.fxml",actionEvent);
        HomeController homeController = new HomeController();
        homeController.showUsersList();
    }
     else if(loginAlert==0)
    {
        alert = new Alert("Data leak","Enter user name -password correctly",stage);
        alert.openDialog();
    }
     else if(loginAlert==2)
    {
        alert = new Alert("User Not Found","Enter user name-password correctly / sign up",stage);
        alert.openDialog();
    }
}

 public void switchToSignup(ActionEvent actionEvent) throws IOException {
     utilities.gotoHere("../UI/SignUp.fxml",actionEvent);
 }

}