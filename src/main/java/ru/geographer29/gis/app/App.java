package ru.geographer29.gis.app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static ru.geographer29.gis.util.FxmlLoader.MAIN;
import static ru.geographer29.gis.util.FxmlLoader.loadFXMLwS;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //loadFXML(primaryStage.getClass(), MAIN);
        loadFXMLwS(primaryStage,MAIN);

        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Simple GIS");

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

