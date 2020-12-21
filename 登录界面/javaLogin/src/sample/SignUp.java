package sample;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignUp implements Initializable {


        @FXML
        private ImageView leftImage;

        @FXML
        private Text Title;

        @FXML
        private Button RegisterButton;

        @FXML
        private Button ExitButton;

        @FXML
        private ImageView rightImage;

        @FXML
        private AnchorPane anchoepane;

        @FXML
        private ImageView lockImage;

        @FXML
        private Text LoginMessage;

        @FXML
        private Button LoginButton;

        @FXML
        private PasswordField password;

        @FXML
        private Label PassWordLable;

        @FXML
        private TextField userName;

        @FXML
        private Label userNameLable;

        @FXML
        void ExitButtonAction(ActionEvent event) {
            System.out.println("exist");
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            Sing();
            stage.close();
        }

        @FXML
        void LockFade(MouseEvent event) {

        }
    @FXML
    void SignIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Node node= (Node) event.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
        @FXML
        void LoginMessage(ActionEvent event) {
            Sing();
            System.out.println("loginMessage");
            Database database=new Database();
            String user=userName.getText();
            String pass=password.getText();
            Connection connection=database.getDbconnection();
            String insertStatement="insert into user_password(name,password) values('"+user+"','"+pass+"')";
            System.out.println(insertStatement);
            try {
                System.out.println("ragister db");
                Statement statement=connection.createStatement();
                int status=statement.executeUpdate(insertStatement);
                if(status>0)
                    System.out.println("successed.");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }

        @FXML
        void RegisterButtonClicked(MouseEvent event)  {
            Database database=new Database();
            String user=userName.getText();
            String pass=password.getText();
            Connection connection=database.getDbconnection();
            try {
                System.out.println("ragister db");
                Statement statement=connection.createStatement();
                int status=statement.executeUpdate("insert into user_password(id,name,password) values('"+user+"','"+pass+"')");
                if(status>0)
                    System.out.println("successed.");
            }
            catch (SQLException e)
            {

            }


        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File leftPic = new File("images/leftImage.png");
        Image image = new Image(leftPic.toURI().toString());
        leftImage.setImage(image);

        File rightPic = new File("images/rightImage.png");
        Image image1 = new Image(rightPic.toURI().toString());
        rightImage.setImage(image1);

        File lockPic=new File("lock.png");
        Image image2=new Image(lockPic.toURI().toString());
        lockImage.setImage(image2);

    }
    void Sing() {
        Media media;
        MediaPlayer mediaPlayer;

        String s1 = Paths.get("images/sound.mp3").toUri().toString();
        media = new Media(s1);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        System.out.println("we are playing");
    }
}
