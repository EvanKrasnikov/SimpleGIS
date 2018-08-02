package ru.geographer29.gis.controllers;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.LayerList;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import ru.geographer29.gis.app.App;
import ru.geographer29.gis.model.logic.Import;
import ru.geographer29.gis.model.logic.Layer;

import java.net.URL;
import java.util.ResourceBundle;

import static ru.geographer29.gis.config.DefaultConfig.setupMap;
import static ru.geographer29.gis.model.logic.LayerTable.setupTable;

public class MainController extends App implements Initializable{

    @FXML private MapView mapView = new MapView();
    @FXML private BorderPane borderPane;
    @FXML private TableView<Layer> table = new TableView<>();
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

    private ArcGISMap map = setupMap();
    private LayerList layersMap;
    private ObservableList<Layer> layersTable = table.getItems();

    protected TableView<Layer> getTable() {
        return table;
    }

    protected ObservableList<Layer> getLayersTable() {
        return layersTable;
    }

    @Override
    public void stop() throws Exception {
        map.getOperationalLayers().clear();
        mapView.dispose();
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.setMap(map);
        setupTable(table,layersNameColumn,isActiveColumn);
        System.out.println("Initialize!");
    }

    @FXML
    private void performClose() throws Exception{
        stop();
    }

    @FXML
    private void performImport() {
        new Import().importFiles(mapView);
    }

    @FXML
    private void performDelete(){
        //todo
    }

    @FXML
    private void performSupervisedClassification(){
        //todo
    }

    @FXML
    private void performAbout(){
        //todo
    }

}

