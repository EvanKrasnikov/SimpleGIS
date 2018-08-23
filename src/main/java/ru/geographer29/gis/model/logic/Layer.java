package ru.geographer29.gis.model.logic;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.File;

public class Layer {
    private File file;
    private SimpleStringProperty name;
    private SimpleBooleanProperty visible;

    public enum TYPE{
        RASTER,
        VECTOR
    }

    public Layer(File file) {
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

    @Override
    public String toString() {
        return name + "   " + visible;
    }
}
