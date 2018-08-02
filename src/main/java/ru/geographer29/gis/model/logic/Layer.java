package ru.geographer29.gis.model.logic;

import com.esri.arcgisruntime.data.ShapefileFeatureTable;
import com.esri.arcgisruntime.layers.FeatureLayer;

import java.io.File;

public class Layer {
    private File file;
    private boolean isActive;
    private String name;
    private FeatureLayer featureLayer;

    public Layer(File file) {
        this.file = file;
        isActive = false;
        name = file.getName();

        ShapefileFeatureTable shapefileFeatureTable = new ShapefileFeatureTable(file.getAbsolutePath());
        featureLayer = new FeatureLayer(shapefileFeatureTable);
    }

    public File getFile() {
        return file;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureLayer getFeatureLayer() {
        return featureLayer;
    }

    @Override
    public String toString() {
        return name + "   " + isActive;
    }
}
