package ru.geographer29.gis.util;

import javafx.fxml.FXMLLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.geographer29.gis.exception.FxmlLoadException;

import java.io.IOException;
import java.net.URL;

public class FxmlLoader {
    private static final Logger logger = LogManager.getLogger();
    public final static String MAIN = "MainWindow.fxml";
    public final static String MENU = "";

    private static URL getUrl(String fxml) {

        class Loader {
            private URL loadUrl(){
                return getClass().getResource(fxml);
            }
        }

        return new Loader().loadUrl();
    }

    public static void loadFxml(Object controller, String fxml) {
        FXMLLoader loader = new FXMLLoader(getUrl(fxml));
        loader.setRoot(controller);
        loader.setController(controller);

        try {
            loader.load();
        } catch (IOException e) {
            throw new FxmlLoadException(e.getMessage());
            logger.fatal("FXML has not loaded!");
        }
    }
}
