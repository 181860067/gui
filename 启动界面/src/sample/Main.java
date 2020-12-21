package sample;

import com.sun.javafx.application.LauncherImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Main extends Application {
    @Override
    public void init() throws Exception {
        super.init();
        for(int i=1;i<=10;i++)
        {
            double progress=i/10.0;
            LauncherImpl.notifyPreloader(this,new Preloader.ProgressNotification(progress));
            Thread.sleep(700);
        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.show();
        Controller.lable.setText("加载完毕！");
        Controller.textFild.setText("");
        Controller.progress.setProgress(1);
        String words="欢迎来到葫芦娃大战妖精游戏，祝您玩的愉快。";
        final IntegerProperty i=new SimpleIntegerProperty(0);
        Timeline timeline=new Timeline();
        KeyFrame keyFrame=new KeyFrame(
                Duration.seconds(0.3),event -> {
            if(i.get()>words.length())
            {
                timeline.stop();
            }
            else
            {
                Controller.textFild.setText(words.substring(0,i.get()));
                Sing();
                //System.out.println("11111");
                i.set(i.get()+1);
//                        System.out.println(words.substring(0,i.get()));
            }
        }
        );
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.setCycleCount(22);
        timeline.play();
    }


    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class,loader.class,args);
        //launch(args);
    }
    void Sing() {
        Media media;
        MediaPlayer mediaPlayer;

        String s1 = Paths.get("src/sample/typeSong.mp3").toUri().toString();
        media = new Media(s1);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        //System.out.println("we are playing");
    }

}
