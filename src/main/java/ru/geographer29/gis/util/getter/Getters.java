package ru.geographer29.gis.util.getter;

import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import ru.geographer29.gis.controllers.MainController;
import ru.geographer29.gis.model.logic.LayerEntry;

public class Getters {

    public static MapView getMapView(){
        return new GenericGetter<MapView>()
                .get(MainController.class,"mapView");
    }

    public static TableView<LayerEntry> getTableView(){
        return new GenericGetter<TableView<LayerEntry>>()
                .get(MainController.class,"tableView");
    }

    public static ObservableList<LayerEntry> getLayersTable(){
        return new GenericGetter<ObservableList<LayerEntry>>()
                .get(ObservableList.class,"layersTable");
    }

}
