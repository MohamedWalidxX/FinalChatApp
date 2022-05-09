package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Random;

public class MessageCustomCellController  extends ListCell<Message>{

    @FXML
    private GridPane root;
    @FXML
    private Label messageTime=new Label("10:15");
    @FXML
    private Label messageText=new Label("السلام عليكم");

    @Override
    protected void updateItem(Message item, boolean empty) {
        super.updateItem(item, empty);
        FXMLLoader fxmlLoader;
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        }
        else
        {

            if (item.isOut()==false)
            {
                    fxmlLoader = new FXMLLoader(getClass().getResource("../UI/OutMessage.fxml"));
                }
             else
             {
                 fxmlLoader = new FXMLLoader(getClass().getResource("../UI/InMessage.fxml"));
             }
            fxmlLoader.setController(this);
            try
            {
                fxmlLoader.load();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            messageTime.setText(item.getTime());
            messageText.setText(item.getMessageText());
            setGraphic(root);
        }
    }

}
