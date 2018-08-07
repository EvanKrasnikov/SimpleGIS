package ru.geographer29.gis.util;

import javafx.fxml.FXMLLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URL;

public class FxmlLoader {
    private static final Logger logger = LogManager.getLogger();
    public final static String MAIN = "MainWindow.fxml";
    public final static String MENU = "";

    private interface Loadable{
        URL loadUrl();
    }

    private static URL getUrl(String fxml) {

        class LoadableImpl implements Loadable {
            @Override
            public URL loadUrl() {
                return getClass().getResource(fxml);
            }
        }

        return new LoadableImpl().loadUrl();
    }

    public static void loadFxml(Object controller, String fxml) {
        FXMLLoader loader = new FXMLLoader(getUrl(fxml));
        loader.setRoot(controller);
        loader.setController(controller);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            logger.fatal("FXML has not loaded!");
        }
    }
}
