import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class SignUpController implements Initializable {

    @FXML
    private TextField email_TF;

    @FXML
    private JFXRadioButton female_RB;

    @FXML
    private TextField fname_TF;

    @FXML
    private TextField lname_TF;

    @FXML
    private JFXButton login_btn;

    @FXML
    private JFXRadioButton male_RB;

    @FXML
    private TextField mname_TF;

    @FXML
    private TextField pass1_TF;

    @FXML
    private TextField pass_TF;

    @FXML
    private TextField pnumber_TF;

    @FXML
    private JFXButton signUp_btn;

    @FXML
    private AnchorPane signup_id;

    UserQueries db = new UserQueries();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ToggleGroup toggleGroup = new ToggleGroup();
        male_RB.setToggleGroup(toggleGroup);
        female_RB.setToggleGroup(toggleGroup);
        signUp_btn.setOnAction(e -> {
            if (email_TF.getText().trim().isEmpty()
                    || fname_TF.getText().trim().isEmpty()
                    || mname_TF.getText().trim().isEmpty()
                    || lname_TF.getText().trim().isEmpty()
                    || pass_TF.getText().trim().isEmpty()
                    || pnumber_TF.getText().trim().isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING, "Fill All Information please!");
                alert.show();

            } else {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                try {
                    db.addUser(fname_TF.getText(),
                            mname_TF.getText(),
                            lname_TF.getText(),
                            toggleName,
                            pnumber_TF.getText(),
                            email_TF.getText(),
                            pass_TF.getText());
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                Alert alert = new Alert(AlertType.INFORMATION, "successful registred!");
                alert.show();
                fname_TF.clear();
                mname_TF.clear();
                lname_TF.clear();
                pnumber_TF.clear();
                email_TF.clear();
                pass_TF.clear();
                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    signup_id.getChildren().setAll(pane);
                } catch (IOException e1) {

                    e1.printStackTrace();
                }
            }

        });
        login_btn.setOnAction(e -> {
            AnchorPane pane;
            try {
                pane = FXMLLoader.load(getClass().getResource("login.fxml"));
                signup_id.getChildren().setAll(pane);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });

    }
}
