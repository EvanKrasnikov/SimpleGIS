package ru.geographer29.gis.util.getter;

import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.scene.control.TableView;
import ru.geographer29.gis.controllers.MainController;

public class Getters {

    public static MapView getMapView(){
        return new GenericGetter<MapView>()
                .get(MainController.class,"mapView");
    }

    public static <T> TableView<T> getTableView(){
        return new GenericGetter<TableView<T>>()
                .get(MainController.class,"tableView");
    }

}
