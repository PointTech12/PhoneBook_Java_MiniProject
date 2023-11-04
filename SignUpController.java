package employeemanagementsystem;
        
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    
     
    @FXML
    private Button SignUpBtn;

    @FXML
    private Button close;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    
    private double x = 0;
    private double y = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Enter New Username
    }    

    @FXML
public void SignUpAdmin() {

        String sql = "INSERT INTO admin "
                + "(username, password) "
                + "VALUES(?,?)";

        connect = database.connectDb();

        try {
            Alert alert;
            if (username.getText().isEmpty()
                    || password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                String check = "SELECT username FROM admin WHERE username = '"
                        + username.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(check);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Employee ID: " + username.getText() + " was already exist!");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, username.getText());
                    prepare.setString(2, password.getText());
                    prepare.executeUpdate();

                    String insertInfo = "INSERT INTO admin "
                            + "(username, password) "
                            + "VALUES(?,?)";

                    prepare = connect.prepareStatement(insertInfo);
                    prepare.setString(1, username.getText());
                    prepare.setString(2, password.getText());
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    
                    SignUpBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);
                    stage.show();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    
}

    @FXML
    void SignUpAdmin(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

}
