package cells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UserListCell {
    public String userName;
    public SimpleStringProperty lastMessage;
    public SimpleStringProperty time;
    public SimpleStringProperty notificationsNumber;
    public Image avatarImage;
//    public ObservableList<MessageViewModel> messagesList;

    public UserListCell(String userName, String lastMessage, String time) {
        this.userName = userName;
        this.lastMessage = new SimpleStringProperty(lastMessage);
        this.time = new SimpleStringProperty(time);
//        this.notificationsNumber = new SimpleStringProperty(notificationsNumber);
        this.avatarImage = new Image("./resources/img/icons8-user-90.png");
//        messagesList = FXCollections.observableArrayList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastMessage() {
        return lastMessage.get();
    }

    public SimpleStringProperty lastMessageProperty() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage.set(lastMessage);
    }

    public SimpleStringProperty timeProperty() {
        return time;
    }

    public String getNotificationsNumber() {
        return notificationsNumber.get();
    }

    public SimpleStringProperty notificationsNumberProperty() {
        return notificationsNumber;
    }

    public void setNotificationsNumber(String notificationsNumber) {
        this.notificationsNumber.set(notificationsNumber);
    }

    public Image getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(Image avatarImage) {
        this.avatarImage = avatarImage;
    }

}