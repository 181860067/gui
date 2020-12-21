package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Text Title;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button ExitButton;

    @FXML
    private AnchorPane anchoepane;

    @FXML
    private Button LoginButton;

    @FXML
    private Text LoginMessage;

    @FXML
    private Label userNameLable;

    @FXML
    private TextField userName;

    @FXML
    private Label PassWordLable;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView leftImage;

    @FXML
    private ImageView rightImage;

    @FXML
    private ImageView lockImage;

    @FXML
    void SignUp(ActionEvent event) throws IOException {
        Sing();
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Node node= (Node) event.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public void ExitButtonAction(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    public void RegisterAction(ActionEvent event)
    {
        //Parent root= FXMLLoader.load(getClass().getResourceAsStream("test.fxml"));
    }


    public void LoginMessage() {
        Sing();
        if (userName.getText().isEmpty()==false&&password.getText().isEmpty()==false)
        {
            LoginMessage.setText("You are trying to Login.");

        InvalidLogin();}
        else
        {
            LoginMessage.setText("Please enter your information.");
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
        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(3));
        scaleTransition.setNode(Title);
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();


    }

    public void LockFade() {
        System.out.println("hello here");
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(3.0));
        fadeTransition.setCycleCount(2);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.setAutoReverse(true);

        RotateTransition rotateTransition=new RotateTransition();
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        ParallelTransition parallelTransition=new ParallelTransition();
        parallelTransition.setNode(lockImage);
        parallelTransition.getChildren().addAll(rotateTransition,fadeTransition);
        parallelTransition.play();

        //fadeTransition.play();
    }
    public  void InvalidLogin()
    {
        System.out.println("hello ha ");
        Database connection=new Database();
        Connection connection1=connection.getDbconnection();
        System.out.println("hello haa ");
        String InputCheck="select count(1) from user_password where name =\""+userName.getText()+
             "\"and password=\""+password.getText() +"\""  ;
        System.out.println(InputCheck);
        try {
            Statement statement=connection1.createStatement();
            ResultSet resultSet=statement.executeQuery(InputCheck);
            while (resultSet.next())
            {
                if(resultSet.getInt(1)==1)
                {
                    LoginMessage.setText("Congratulations.");
                }
                else
                {
                    LoginMessage.setText("Sorry.");
                }
            }

        }catch (Exception E)
        {
            E.getCause();
            E.printStackTrace();
        }
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
