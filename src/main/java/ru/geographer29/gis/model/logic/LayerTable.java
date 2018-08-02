package ru.geographer29.gis.model.logic;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;

public class LayerTable {
    public static void setupTable(TableView<Layer> table, TableColumn<Layer,String> layersNameColumn, TableColumn<Layer,Boolean> isActiveColumn) {

        layersNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Layer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Layer, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });

        isActiveColumn.setCellFactory(new Callback<TableColumn<Layer, Boolean>, TableCell<Layer, Boolean>>() {
            @Override
            public TableCell<Layer, Boolean> call(TableColumn<Layer, Boolean> p) {
                CheckBoxTableCell<Layer, Boolean> cell = new CheckBoxTableCell<Layer, Boolean>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });

        //table.setItems(getLayerList());
        //System.out.println(getLayerList());
    }
        /*
    private static ObservableList<Layer> getLayerList(){
        Layer l1 = new Layer(new File("C/111/"));
        Layer l2 = new Layer(new File("C/222/"));
        return FXCollections.observableArrayList(l1 , l2);
    }*/
}
