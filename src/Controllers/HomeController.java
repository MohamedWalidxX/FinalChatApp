package Controllers;

import cells.UserListCell;
import chatPack.App;
import chatPack.ChatRoom;
import chatPack.User;
import com.jfoenix.controls.JFXListView;
import com.sun.javafx.scene.control.LabeledText;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class HomeController implements Initializable{
    public Stage stage;
    public Scene scene;
    public Parent root;
    public User HomeUser;
    public App app;
    public HomeController()
    {
        if(LoginController.uLogin !=null)
            HomeUser=LoginController.uLogin;
        else if(SignUpController.uSignup!=null)
            HomeUser=SignUpController.uSignup;
    }

    @FXML
    public ListView<UserListCell> usersListView;

    @FXML
    public ListView<Message>messagesListView;

    @FXML
    public ObservableList<UserListCell> usersList = FXCollections.observableArrayList();

    @FXML
    public ObservableList<Message> messageList = FXCollections.observableArrayList();

    Image userImage = new Image("/resources/img/ico.png");

    public void sendMessage(ActionEvent actionEvent) {

    }

    public void gotoStoryPage(MouseEvent mouseEvent) {

    }

    public void gotoOptions(MouseEvent mouseEvent) {

    }

    public void showUsersList() throws SQLException {
        app = new App();
        int userId = app.getUserIdFromUsername(HomeUser.getUsername());
        ArrayList<ChatRoom> chatRooms = app.expandConnectionChats(userId);
        for (int i=0;i<chatRooms.size();++i)
        {
            ChatRoom tempChatRoom=chatRooms.get(i);
            UserListCell userListCell=new UserListCell(tempChatRoom.getName(),"Hello"/*tempChatRoom.getLastMessageSent().getMessageText()
                    ,tempChatRoom.getLastMessageSent().getTime()*/,"10:15");
            usersList.add(userListCell);
        }
        usersListView.setItems(usersList);
    }
//
//        //////////////////////////////////////
//
//
//    public void gotoOptions(MouseEvent mouseEvent) throws IOException {
//        String path="../UI/Options _change_Profile_Description_Scene.fxml";
//        gotoHere(path ,mouseEvent);
//    }
//
//    public void sendMessage(ActionEvent actionEvent) {
//
//    }
//
//    public void gotoStoryPage(MouseEvent mouseEvent) throws IOException {
//        String path="../UI/story_page.fxml";
//        gotoHere(path ,mouseEvent);
//
//    }
//
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
/*        String name = "مودي";
        usersList.add(new UserListCell(name, "message ", "10:15"));
            usersList.addAll(new UserListCell("Oliver", "Hello", "10:15")
                    , new UserListCell("Harry", "Did you receive my call?", "10:15")
                    , new UserListCell("George", "How are you?", "10:15")
                    , new UserListCell("Noah", "Yeah", "10:15")
                    , new UserListCell("Jack", "No way!", "10:15"),new UserListCell("Jack", "No way!", "10:15"));*/
        try {
            app = new App();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int userId = 0;
        try {
            userId = app.getUserIdFromUsername(HomeUser.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<ChatRoom> chatRooms = null;
        try {
            chatRooms = app.expandConnectionChats(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i=0;i<chatRooms.size();++i)
        {
            ChatRoom tempChatRoom=chatRooms.get(i);
            UserListCell userListCell=new UserListCell(tempChatRoom.getName(),"Hello"
                    ,"10:15");
            usersList.add(userListCell);
        }
        usersListView.setItems(usersList);
//        messagesListView.setItems(messageList);
        usersListView.setCellFactory(lv -> new UserCustomCellController() {
            {
                prefWidthProperty().bind(usersListView.widthProperty().subtract(0));
            }
        });
/*        messagesListView.setCellFactory(lv -> new MessageCustomCellController() {
            {
                prefWidthProperty().bind(messagesListView.widthProperty().subtract(0)); // 1
                lv.setOnMouseClicked(mouseEvent -> {
                    if (mouseEvent.getClickCount() == 2) {
                        Message message=lv.getSelectionModel().getSelectedItem();
                        if(!message.isOut())
                        {
                            System.out.println("Doneeeeeeeeeeeeee");
                            MessageStatus messageStatus = new MessageStatus("Message Status","Seen at 10:15");
                            try {
//                                Stage stage2 = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
                                 messageStatus.openDialog();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });
            }
        });*/

    }

//
//
//
//    //////////////////////////////////////
//
//
//    //////////////////////////////////////
//
//
//
//
//
//
//
//
//    public static String "10:15"() {
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
//        Date date = new Date();
//        return dateFormat.format(date);
//    }

//    public void dowork(MouseEvent mouseEvent) {
//                 if (mouseEvent.getClickCount() == 2) {
//            System.out.println("Double click Done");
//
//        }
//
//    }
}
