import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class logincontroller implements Initializable {

    @FXML
    private JFXButton btn_login;

    @FXML
    private JFXButton btn_signup;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    @FXML
    private AnchorPane login_id;

    private UserQueries us = new UserQueries();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btn_login.setOnAction(e -> {
            int confirm = us.config(tf_username
                    .getText(), tf_password.getText());
            if (confirm == 1) {

                try {
                    AnchorPane root = FXMLLoader.load(getClass().getResource("home.fxml"));
                    Stage stage = (Stage) tf_username.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }
            } else {
                Alert alert = new Alert(AlertType.WARNING, "Fill All Information please!");
                alert.show();
                tf_username.clear();
                tf_password.clear();
            }

        });
        btn_signup.setOnAction((ActionEvent e) -> {
            try {
                AnchorPane gridPane = FXMLLoader.load(getClass().getResource("signup.fxml"));
                login_id.getChildren().setAll(gridPane);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
    }

}
