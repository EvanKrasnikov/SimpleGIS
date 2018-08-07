package ru.geographer29.gis.controllers;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.LayerList;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import ru.geographer29.gis.app.App;
import ru.geographer29.gis.config.DefaultConfig;
import ru.geographer29.gis.model.logic.Import;
import ru.geographer29.gis.model.logic.Layer;
import ru.geographer29.gis.model.logic.LayerTable;
import ru.geographer29.gis.util.FxmlLoader;

public class MainController extends App {
    @FXML private MapView mapView;
    @FXML private BorderPane borderPane;
    @FXML private TableView<Layer> tableView;
    @FXML private TableColumn<Layer, String> layersNameColumn;
    @FXML private TableColumn<Layer, Boolean> isActiveColumn;
    @FXML private MenuBar menuBar;
    @FXML private Menu menuFile;
    @FXML private Menu menuEdit;
    @FXML private Menu menuTools;
    @FXML private Menu menuHelp;
    @FXML private MenuItem menuItemImport;
    @FXML private MenuItem menuItemClose;
    @FXML private MenuItem menuItemDelete;
    @FXML private MenuItem menuItemSupervisedClassification;
    @FXML private MenuItem menuItemAbout;

    private ArcGISMap map;
    private LayerList layersMap;
    private ObservableList<Layer> layersTable;

    public MainController(){
        FxmlLoader.loadFxml(this,FxmlLoader.MAIN);
        map = DefaultConfig.setupMap();
        mapView.setMap(map);
        layersTable = tableView.getItems();
        LayerTable.setupTable(tableView);
    }

    @Override
    public void stop() {
        map.getOperationalLayers().clear();
        mapView.dispose();
        Platform.exit();
    }

    @FXML
    private void performClose() {
        stop();
    }

    @FXML
    private void performImport() {
        new Import().importFiles(mapView);
    }

    @FXML
    private void performDelete() {
        //todo
    }

    @FXML
    private void performSupervisedClassification() {
        //todo
    }

    @FXML
    private void performAbout() {
        //todo
    }

}

