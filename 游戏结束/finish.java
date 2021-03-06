
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

import javafx.animation.*;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class finish extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    AnchorPane stackPane=new AnchorPane();
       Image imageFinish = new Image("finishBackground.jpg");
        ImageView imageViewFinish = new ImageView();
       imageViewFinish.setImage(imageFinish);

        Image imageGameOver=new Image("gameOver.png");
        ImageView imageView=new ImageView();
        imageView.setImage(imageGameOver);

        TranslateTransition translateTransition=new TranslateTransition();
        translateTransition.setFromY(imageView.getLayoutY());
        translateTransition.setByY(10);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
        //translateTransition.setNode(imageView);

        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.5);
        fadeTransition.setAutoReverse(true);

        ScaleTransition scaleTransition=new ScaleTransition();
        scaleTransition.setToX(1.5);
        scaleTransition.setToY(1.5);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition=new ParallelTransition();
        parallelTransition.getChildren().addAll(fadeTransition,translateTransition,scaleTransition);
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.setNode(imageView);
        parallelTransition.setAutoReverse(true);
        parallelTransition.play();

        //translateTransition.play();


        primaryStage.setTitle("游戏结束");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Button btn = new Button("重新开始");
        Button button=new Button("回放游戏");
        Button buttonExit=new Button("退出游戏");

        HBox hbBtn = new HBox(10);
        HBox hBox=new HBox(10);
        HBox hBoxExit=new HBox(10);

        DropShadow shadow = new DropShadow();
        button.setEffect(shadow);
        btn.setEffect(shadow);
        buttonExit.setEffect(shadow);


        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                btn.setEffect(shadow);
                Path path = new Path();// 创建一个路径对象
                double x = btn.getLayoutX() -80;
                double y = btn.getLayoutY();
                path.getElements().add(new MoveTo(x, y + 18));// 从哪个位置开始动画，一般来说给组件的默认位置就行
                path.getElements().add(new LineTo(x - 20, y + 18));// 添加一个向左移动的路径
                path.getElements().add(new LineTo(x + 20, y + 18));// 添加一个向右移动的路径 这样就完成第一遍摇头
                path.getElements().add(new LineTo(x - 20, y + 18));// 添加一个向左移动的路径 第二遍
                path.getElements().add(new LineTo(x + 20, y + 18));// 添加一个向右移动的路径 这样就完成第二遍摇头
                path.getElements().add(new LineTo(x, y + 18));// 最后移动到原来的位置

                PathTransition pathTransition = new PathTransition();// 创建一个动画对象
                pathTransition.setDuration(Duration.seconds(0.5));// 动画持续时间 0.5秒
                pathTransition.setPath(path);// 把我们设置好的动画路径放入里面
                pathTransition.setNode(btn);// 给动画添加组件，让某个组件来完成这个动画
                pathTransition.setCycleCount(1);// 执行1遍
                pathTransition.play();// 执行动画

            }
        });

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO
                Sing();
            }
        });

        button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setEffect(shadow);
                Path path = new Path();// 创建一个路径对象
                double x = button.getLayoutX()-80;
                double y = button.getLayoutY();
                path.getElements().add(new MoveTo(x, y + 18));// 从哪个位置开始动画，一般来说给组件的默认位置就行
                path.getElements().add(new LineTo(x - 20, y + 18));// 添加一个向左移动的路径
                path.getElements().add(new LineTo(x + 20, y + 18));// 添加一个向右移动的路径 这样就完成第一遍摇头
                path.getElements().add(new LineTo(x - 20, y + 18));// 添加一个向左移动的路径 第二遍
                path.getElements().add(new LineTo(x + 20, y + 18));// 添加一个向右移动的路径 这样就完成第二遍摇头
                path.getElements().add(new LineTo(x, y + 18));// 最后移动到原来的位置
                PathTransition pathTransition = new PathTransition();// 创建一个动画对象
                pathTransition.setDuration(Duration.seconds(0.5));// 动画持续时间 0.5秒
                pathTransition.setPath(path);// 把我们设置好的动画路径放入里面
                pathTransition.setNode(button);// 给动画添加组件，让某个组件来完成这个动画
                pathTransition.setCycleCount(1);// 执行1遍
                pathTransition.play();// 执行动画
            }
        });


        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO
                Sing();
            }
        });

        buttonExit.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonExit.setEffect(shadow);
                Path path = new Path();// 创建一个路径对象
                double x =  buttonExit.getLayoutX()-80;
                double y = buttonExit.getLayoutY();
                path.getElements().add(new MoveTo(x, y + 18));// 从哪个位置开始动画，一般来说给组件的默认位置就行
                path.getElements().add(new LineTo(x - 20, y + 18));// 添加一个向左移动的路径
                path.getElements().add(new LineTo(x + 20, y + 18));// 添加一个向右移动的路径 这样就完成第一遍摇头
                path.getElements().add(new LineTo(x - 20, y + 18));// 添加一个向左移动的路径 第二遍
                path.getElements().add(new LineTo(x + 20, y + 18));// 添加一个向右移动的路径 这样就完成第二遍摇头
                path.getElements().add(new LineTo(x, y + 18));// 最后移动到原来的位置
                PathTransition pathTransition = new PathTransition();// 创建一个动画对象
                pathTransition.setDuration(Duration.seconds(0.5));// 动画持续时间 0.5秒
                pathTransition.setPath(path);// 把我们设置好的动画路径放入里面
                pathTransition.setNode( buttonExit);// 给动画添加组件，让某个组件来完成这个动画
                pathTransition.setCycleCount(1);// 执行1遍
                pathTransition.play();// 执行动画
            }
        });

        buttonExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO
                Sing();
            }
        });

        btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                btn.setEffect(null);
            }
        });
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("RESATART GAME");
                Sing();
            }
        });


        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().addAll(btn);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(button);
        hBoxExit.setAlignment(Pos.CENTER);
        hBoxExit.getChildren().addAll(buttonExit);

        grid.setOpacity(1);
        grid.add(imageView,1,0);
        grid.add(hbBtn, 1, 17);
        grid.add(hBox,1,15);
        grid.add(hBoxExit,1,19);

        Random random=new Random();
        ArrayList<ImageView> imageList=new ArrayList<ImageView>();
        for(int i=0;i<50;i++)
        {
            ImageView im=new ImageView("hulu1.png");
            im.setPreserveRatio(true);
            int x=random.nextInt(1200);
            int y=10;
            im.setTranslateX(x);
            im.setTranslateY(y);
            im.setTranslateZ(10);
            imageList.add(im);
        }
        stackPane.getChildren().addAll(imageList);
        imageList.forEach(new Consumer<ImageView>() {
            @Override
            public void accept(ImageView imageView) {
                double time=random.nextInt(10);
                TranslateTransition t1=new TranslateTransition(Duration.seconds(time));
                t1.setFromX(imageView.getTranslateX());
                t1.setFromY(imageView.getTranslateY());
                t1.setByX(400);
                t1.setByY(700);


                FadeTransition fadeTransition=new FadeTransition(Duration.seconds(time/2));
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);

                FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(time/2));
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);

                SequentialTransition sequentialTransition=new SequentialTransition();
                sequentialTransition.getChildren().addAll(fadeTransition,fadeTransition1);

                RotateTransition rotateTransition=new RotateTransition(Duration.seconds(time));
                rotateTransition.setFromAngle(0);
                rotateTransition.setToAngle(360);


                ParallelTransition parallelTransition=new ParallelTransition();
                parallelTransition.setNode(imageView);
                parallelTransition.getChildren().addAll(t1,sequentialTransition,rotateTransition);
                parallelTransition.setCycleCount(Animation.INDEFINITE);
                parallelTransition.play();
               // System.out.println("1111");

            }
        });


       //stackPane.getChildren().add(hulu);
        //stackPane.getChildren().add(imageViewFinish);
        stackPane.getChildren().addAll(grid);

        AnchorPane.setTopAnchor(grid,50.0);
        AnchorPane.setLeftAnchor(grid,400.0);
        Scene scene = new Scene(stackPane, 1280, 700);
        primaryStage.setScene(scene);
        scene.setCursor(Cursor.CLOSED_HAND);
       scene.getStylesheets().add(Login.class.getResource("finishCss.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }

    void Sing() {
        Media media;
        MediaPlayer mediaPlayer;

        String s1 = Paths.get("music2.mp3").toUri().toString();
        media = new Media(s1);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        System.out.println("we are playing");
    }


    public Node HULU(int number, int weight, int height, int depth)
    {
        Random random=new Random();
        ArrayList<ImageView> imageList=new ArrayList<ImageView>();
        AnchorPane ap=new AnchorPane();
        for(int i=0;i<number;i++)
        {
            ImageView im=new ImageView("hulu1.png");
            im.setPreserveRatio(true);
            int x=random.nextInt(1200);
            int y=10;
            im.setTranslateX(x);
            im.setTranslateY(y);
            im.setTranslateZ(10);
            imageList.add(im);
        }
        ap.getChildren().addAll(imageList);
        imageList.forEach(new Consumer<ImageView>() {
            @Override
            public void accept(ImageView imageView) {
                double time=random.nextInt(10);
                TranslateTransition t1=new TranslateTransition(Duration.seconds(time));
                t1.setFromX(imageView.getTranslateX());
                t1.setFromY(imageView.getTranslateY());
                t1.setByX(400);
                t1.setByY(500);


                FadeTransition fadeTransition=new FadeTransition(Duration.seconds(time/2));
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);

                FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(time/2));
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);

                SequentialTransition sequentialTransition=new SequentialTransition();
                sequentialTransition.getChildren().addAll(fadeTransition,fadeTransition1);

                RotateTransition rotateTransition=new RotateTransition(Duration.seconds(time));
                rotateTransition.setFromAngle(0);
                rotateTransition.setToAngle(360);


                ParallelTransition parallelTransition=new ParallelTransition();
                parallelTransition.setNode(imageView);
                parallelTransition.getChildren().addAll(t1,sequentialTransition,rotateTransition);
                parallelTransition.setCycleCount(Animation.INDEFINITE);
                parallelTransition.play();
                System.out.println("1111");

            }
        });

        SubScene subScene=new SubScene(ap,weight,height,true, SceneAntialiasing.BALANCED);
        PerspectiveCamera camera=new PerspectiveCamera();
        subScene.setCamera(camera);
        subScene.setOpacity(0);
        return subScene;

    }

}

//  -fx-background-image: url("finishBackground.jpg");