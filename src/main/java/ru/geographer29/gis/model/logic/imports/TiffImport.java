package ru.geographer29.gis.model.logic.imports;

import com.esri.arcgisruntime.layers.Layer;
import com.esri.arcgisruntime.layers.RasterLayer;
import com.esri.arcgisruntime.raster.ImageServiceRaster;
import ru.geographer29.gis.model.logic.LayerEntry;
import ru.geographer29.gis.util.getter.Getters;

import java.io.File;

public class TiffImport implements Importable {

    @Override
    public void importFile(File file) {
        Layer layer = new RasterLayer(new ImageServiceRaster(file.getAbsolutePath()));
        LayerEntry layerEntry = new LayerEntry(file);
        layerEntry.setLayer(layer);
        Getters.getTableView().getItems().add(layerEntry);
        Getters.getMapView().getMap().getOperationalLayers().add(layer);
    }

}
