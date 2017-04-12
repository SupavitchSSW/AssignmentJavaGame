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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        Pane pane2 = new Pane();
        Scene scene = new Scene(pane, 1260, 700);
        Scene scene2 = new Scene(pane2, 1260, 700);


        primaryStage.setResizable(false);
        primaryStage.setTitle("get high, SLOTH");
        primaryStage.setScene(scene);
        primaryStage.show();
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 800;
        config.width = 1600;
        config.resizable = true;
        new LwjglApplication(new CuttieBattle(), config);
        Thread.sleep(1000);
        config.width = 10;


    }


    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        launch(args);
    }
}