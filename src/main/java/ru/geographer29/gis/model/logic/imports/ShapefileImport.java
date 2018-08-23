package ru.geographer29.gis.model.logic.imports;

import com.esri.arcgisruntime.data.ShapefileFeatureTable;
import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.layers.Layer;
import ru.geographer29.gis.model.logic.LayerEntry;
import ru.geographer29.gis.util.getter.Getters;

import java.io.File;

public class ShapefileImport implements Importable {

    @Override
    public void importFile(File file) {
        Layer layer = new FeatureLayer(new ShapefileFeatureTable(file.getAbsolutePath()));
        LayerEntry layerEntry = new LayerEntry(file);
        layerEntry.setLayer(layer);
        Getters.getTableView().getItems().add(layerEntry);
        Getters.getMapView().getMap().getOperationalLayers().add(layer);
    }

}
