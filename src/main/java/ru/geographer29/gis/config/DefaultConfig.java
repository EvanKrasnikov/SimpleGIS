package ru.geographer29.gis.config;

import com.esri.arcgisruntime.data.ServiceFeatureTable;
import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.loadable.LoadStatus;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

import java.io.File;

public class DefaultConfig {
    public static final File INITIAL_FOLDER = new File("C:\\Users\\i.krasnikov\\Downloads\\arcgis-runtime-sdk-java-sample-viewer-100.2.1\\arcgis-runtime-sdk-java-sample-viewer\\samples-data\\shapefiles");

    public static ArcGISMap setupMap(){
        Basemap.Type besemapType = Basemap.Type.OPEN_STREET_MAP;
        double lat = 34.05293;
        double lon = -118.24368;
        int levelOfDetails = 11;
        return new ArcGISMap(besemapType, lat, lon, levelOfDetails);
    }

    public static void loadDefaultData(MapView mapView){
        if (mapView != null ){
            String url = "https://services3.arcgis.com/GVgbJbqm8hXASVYi/arcgis/rest/services/Trailheads/FeatureServer/0";
            ServiceFeatureTable serviceFeatureTable = new ServiceFeatureTable(url);

            FeatureLayer featureLayer = new FeatureLayer(serviceFeatureTable);
            ArcGISMap map = mapView.getMap();
            map.getOperationalLayers().add(featureLayer);

            featureLayer.addDoneLoadingListener(new Runnable() {
                @Override
                public void run() {
                    if (featureLayer.getLoadStatus() == LoadStatus.LOADED){
                        mapView.setViewpointGeometryAsync(featureLayer.getFullExtent());
                    } else {
                        featureLayer.getLoadError().getCause().printStackTrace();
                    }
                }
            });
        }
    }
}
