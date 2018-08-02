package ru.geographer29.gis.config;

import javafx.collections.FXCollections;
import javafx.stage.FileChooser;

import java.util.List;

public class FileExtension {
    public final static List<FileChooser.ExtensionFilter> filters = FXCollections.observableArrayList(
            new FileChooser.ExtensionFilter("SHP", "*shp"),
            new FileChooser.ExtensionFilter("TIFF", "*tif","*tiff")
    );
}
