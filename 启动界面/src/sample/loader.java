package sample;


import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class loader extends Preloader {


    private Stage preloaderStage;
    private Scene scene;
    public static int num=0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        preloaderStage=primaryStage;
        primaryStage.setScene(scene);
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
        scene=new Scene(root,1280,700);

    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
        super.handleApplicationNotification(info);
        if(info instanceof ProgressNotification)
        {
            //System.out.println(((ProgressNotification)info).getProgress());
            Controller.lable.setText("Loading"+(((ProgressNotification)info).getProgress())*100+"%");
            Controller.progress.setProgress( ((ProgressNotification) info).getProgress());
            num++;
            if(num==6)
                num=1;
            String name=String.valueOf(num);
            name="/sample/"+name+".png";
           // System.out.println(name);
            Image image=new Image(name,true);
            Controller.imageView.setImage(image);
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        super.handleStateChangeNotification(info);
        StateChangeNotification.Type type=info.getType();
        switch (type){
            case BEFORE_START:
                System.out.println("before");
                preloaderStage.hide();
                break;
        }
    }
}
