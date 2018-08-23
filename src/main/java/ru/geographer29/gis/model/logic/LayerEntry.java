package ru.geographer29.gis.model.logic;

import com.esri.arcgisruntime.layers.Layer;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.File;

public class LayerEntry {
    private File file;
    private SimpleStringProperty name;
    private SimpleBooleanProperty visible;
    private Layer layer;

    public enum TYPE{
        RASTER,
        VECTOR
    }

    public LayerEntry(File file) {
        this.file = file;
        name = new SimpleStringProperty(file.getName());
        visible = new SimpleBooleanProperty(false);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleBooleanProperty visibleProperty() {
        return visible;
    }

    public boolean getVisible() {
        return visible.get();
    }

    public void setVisible(boolean visible) {
        this.visible.set(visible);
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    @Override
    public String toString() {
        return name + "   " + visible;
    }
}
