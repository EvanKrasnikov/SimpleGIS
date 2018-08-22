package ru.geographer29.gis.app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.geographer29.gis.controllers.MainController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Simple GIS");

        new MainController();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

