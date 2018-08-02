package ru.geographer29.gis.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class FxmlLoader {
    public static final String MAIN = "/fxml/MainWindow.fxml";

    interface Loader{
        URL getURL();
    }

    private static Parent getParent(String fxmlPath){
        Parent root;

        class LoaderImpl implements Loader{
            @Override
            public URL getURL() {
                return getClass().getResource(fxmlPath);
            }
        }

        URL url = new LoaderImpl().getURL();

        //проверка загрузки FXML
        try {
            root = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error on FXML loading!");
        }

        if (root != null){
            System.out.println("!!!! Success !!!!");
        }

        return root;
    }

    public static void loadFXML(Class <? extends Stage> stageGen, String fxmlPath){
        Parent root = getParent(fxmlPath);

        if (stageGen.isInstance(Stage.class)){
            try {
                Constructor sceneConstructor = Scene.class.getDeclaredConstructor(Parent.class);
                Scene scene = (Scene)sceneConstructor.newInstance(root);
                scene.setRoot(root);

                Stage stage = stageGen.newInstance();
                stage.setScene(scene);
                stage.show();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException  | InstantiationException e) {
                e.printStackTrace();
            }

        }

        if (stageGen.isInstance(Node.class)){
            try {
                Method method = stageGen.getMethod("getScene");
                Scene scene = (Scene)method.invoke(stageGen);
                scene.setRoot(root);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadFXMLwS(Stage stage, String fxmlPath){
        Parent root = getParent(fxmlPath);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
