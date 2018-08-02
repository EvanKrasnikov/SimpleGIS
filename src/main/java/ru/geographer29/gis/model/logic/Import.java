package ru.geographer29.gis.model.logic;

import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.loadable.LoadStatus;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.*;
import ru.geographer29.gis.config.DefaultConfig;
import ru.geographer29.gis.config.FileExtension;
import ru.geographer29.gis.controllers.MainController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Import extends MainController {
    private MapView mapView;

    public void importFiles(MapView map){
        mapView = map;
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import files");
        chooser.getExtensionFilters().addAll(FileExtension.filters);
        chooser.setInitialDirectory(DefaultConfig.INITIAL_FOLDER);
        List<File> files = chooser.showOpenMultipleDialog((Stage)mapView.getScene().getWindow());
        if (files != null) addLayers(files);
    }

    private void addLayers(List<File> list){
        ObservableList<Layer> obsList  = getLayersTable();
        for (File file: list ){
            Layer layer = new Layer(file);
            getExtent(layer.getFeatureLayer());
            mapView.getMap().getOperationalLayers().add(layer.getFeatureLayer());
            obsList.add(layer);
        }
        System.out.println(obsList + "  obs list");
        getTable().setItems(obsList);
    }

    private void getExtent(FeatureLayer layer){
        layer.addDoneLoadingListener(new Runnable() {
            @Override
            public void run() {
                if (layer.getLoadStatus() == LoadStatus.LOADED) {
                    mapView.setViewpointGeometryAsync(layer.getFullExtent());
                } else {
                    layer.getLoadError().getCause().printStackTrace();
                }
            }
        });
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

}
