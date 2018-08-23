package ru.geographer29.gis.util.getter;

import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import ru.geographer29.gis.controllers.MainController;
import ru.geographer29.gis.model.logic.Layer;

public class Getters {

    public static MapView getMapView(){
        return new GenericGetter<MapView>()
                .get(MainController.class,"mapView");
    }

    public static TableView<Layer> getTableView(){
        return new GenericGetter<TableView<Layer>>()
                .get(MainController.class,"tableView");
    }

    public static ObservableList<Layer> getLayersTable(){
        return new GenericGetter<ObservableList<Layer>>()
                .get(ObservableList.class,"layersTable");
    }

}
