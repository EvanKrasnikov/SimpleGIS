package ru.geographer29.gis.model.logic.imports;

import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.loadable.LoadStatus;
import com.esri.arcgisruntime.mapping.view.MapView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.geographer29.gis.config.DefaultConfig;
import ru.geographer29.gis.config.FileExtension;

import java.io.File;
import java.util.List;

public class Import{
    private MapView mapView;
    private static final Logger logger = LogManager.getLogger();

    public void importFiles(MapView map){
        mapView = map;
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import files");
        chooser.getExtensionFilters().addAll(FileExtension.filters);
        chooser.setInitialDirectory(DefaultConfig.INITIAL_FOLDER);
        List<File> files = chooser.showOpenMultipleDialog((Stage)mapView.getScene().getWindow());

        if (files != null){
            for (File file: files ){
                ImportHandler importHandler = new ImportHandler(file);

                switch (getFileExtension(file)){
                    case "shp" : importHandler.importWith(new ShapefileImport());
                    case "tiff" : importHandler.importWith(new TiffImport());
                    case "tif" : importHandler.importWith(new TiffImport());
                    default : {
                        throw new RuntimeException("Incorrect file extension...");
                        logger.error("Incorrect file extension...");
                    }
                }
            }
        }
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
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

}
