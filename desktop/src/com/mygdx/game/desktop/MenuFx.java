package com.mygdx.game.desktop;

/**
 * Created by root on 11/4/2560.
 */
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.CuttieBattle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;

import static javafx.scene.media.AudioClip.INDEFINITE;

public class MenuFx extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        Pane pane2 = new Pane();
        Scene scene = new Scene(pane, 1600, 700);
        Scene scene2 = new Scene(pane2, 1600, 700);
        final Clip clip = AudioSystem.getClip();
        final Task task = new Task() {

            @Override
            protected Object call() throws Exception {
                int s = INDEFINITE;
                String ssound = "assets/Main.wav";

                File soundFile = new File( ssound);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( soundFile );



                clip.open(audioInputStream);
                clip.start();//This plays the audio
                clip.loop(INDEFINITE);
//                Media sound = new Media(new File(ssound).toURI().toString());
//                MediaPlayer mediaPlayer = new MediaPlayer(sound);
//                mediaPlayer.setCycleCount(200);
//                mediaPlayer.play();
                return null;
            }
        };
        final Thread thread = new Thread(task);
        thread.start();
        final Image[] bg = new Image[4];
        bg[0] = new Image("file:assets/home1.png");
        bg[1] = new Image("file:assets/home2.png");
        bg[2] = new Image("file:assets/home3.png");
        bg[3] = new Image("file:assets/home4.png");
        final ImageView image = new ImageView();
        image.setFitHeight(720);
        image.setFitWidth(1600);

        image.setImage(bg[0]);

        pane.getChildren().add(image);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Cuttie Battle");
        primaryStage.setScene(scene);
        primaryStage.show();
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 800;
        config.width = 1600;
        config.resizable = true;

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ("SPACE".equals(event.getCode().toString())) {
                    new LwjglApplication(new CuttieBattle(), config);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    config.width = 10;
                    clip.close();
                    primaryStage.close();
                }

            }
        });



    }


    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        launch(args);
    }
}