import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Homecontroller implements Initializable {

    @FXML
    private JFXButton logout_btn;

    @FXML
    private AnchorPane home_id;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        logout_btn.setOnAction(e -> {
            AnchorPane pane;
            try {
                pane = FXMLLoader.load(getClass().getResource("login.fxml"));
                home_id.getChildren().setAll(pane);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
    }

}
