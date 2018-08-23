package ru.geographer29.gis.controllers;

import com.esri.arcgisruntime.layers.RasterLayer;
import com.esri.arcgisruntime.raster.Raster;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import ru.geographer29.gis.model.logic.Layer;
import ru.geographer29.gis.util.FxmlLoader;
import ru.geographer29.gis.util.getter.Getters;

public class ClassificationController {
    @FXML private Button startClassificationButton;
    @FXML private ComboBox<Layer> rasterComboBox;
    @FXML private ComboBox<Layer> vectorComboBox;
    @FXML private ProgressBar progressBar;

    public ClassificationController(){
        FxmlLoader.loadFxml(this, FxmlLoader.CLASSIFICATION);
    }

    @FXML
    private void filterRasters(){
        ObservableList<Layer> obslist = Getters
                .getTableView()
                .getItems()
                .filtered((Layer layer) -> {
                    if (layer.TYPE == RASTER)
                        return true;
                    return false;
                });
        rasterComboBox.setItems(obslist);
    }

    @FXML
    private void filterVectors(){
        ObservableList<Layer> obslist = Getters
                .getTableView()
                .getItems()
                .filtered((Layer layer) -> {
                    if (layer.TYPE == VECTOR)
                        return true;
                    return false;
                });
        vectorComboBox.setItems(obslist);
    }

    @FXML
    private void startClassification(){
        Layer raster = rasterComboBox.getSelectionModel().getSelectedItem().getFile().getAbsolutePath();
        Layer vector = vectorComboBox.getSelectionModel().getSelectedItem();
        Raster y;
        RasterLayer rasterLayer = new RasterLayer(
                new Raster(rasterComboBox
                        .getSelectionModel()
                        .getSelectedItem()
                        .getFile()
                        .getAbsolutePath())
        );

    }
}
