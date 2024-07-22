package com.example.GeoSpatial1.Controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GeoSpatial1.DTO.GeoSpatialDTO1;
import com.example.GeoSpatial1.DTO.OuterGeoSpatialDTO;
import com.example.GeoSpatial1.DTO.ShapeWithKeyValuesDTO;
import com.example.GeoSpatial1.Entity.KeyValueEntity;
import com.example.GeoSpatial1.Entity.LayerTable;
//import com.example.GeoSpatial1.Entity.Map;
//import com.example.GeoSpatial1.Entity.ShapeWithKeyValuesDTO;
import com.example.GeoSpatial1.Entity.ShapeWktEntity;
import com.example.GeoSpatial1.Repository.KeyValueEntityRepo;
import com.example.GeoSpatial1.Repository.LayerTableRepo;
import com.example.GeoSpatial1.Repository.ShapeWktEntityRepo;

@CrossOrigin(origins="*")
@RestController
public class GeoSpatialController1 {

	private int layerId = 1;
	
	@Autowired
	private LayerTableRepo layerTableRepo;
	@Autowired
	private ShapeWktEntityRepo shapeWktEntityRepo;
	@Autowired
	private KeyValueEntityRepo keyValueEntityRepo; 
		
	public Geometry wktToGeometry(String wellKnownText) throws ParseException {
		System.out.println(wellKnownText);	 
		return new WKTReader().read(wellKnownText);
	}
	
	@PostMapping("/addLayer")
//	public String addPolygon(@RequestBody List<GeoSpatialDTO1> geoSpatialDTO1List) throws ParseException {
	public String addLayer(@RequestBody OuterGeoSpatialDTO outerGeoSpatialDTO) throws ParseException {

//		System.out.println(polygonString);
//		Geometry polygon = wktToGeometry(polygonString);
//		System.out.println(polygon);
		
		LayerTable layer = new LayerTable(outerGeoSpatialDTO.getLayerName());
		List<ShapeWktEntity> tempShapeWktArray = new ArrayList<ShapeWktEntity>();
		System.out.println("Layer Name = "+layer.getLayerName());
		System.out.println();
		for(GeoSpatialDTO1 geoSpatialDTO1: outerGeoSpatialDTO.getGeoSpatialDTO1List()) {
			System.out.println("Type = "+geoSpatialDTO1.getType());
			System.out.println("WKT String = "+geoSpatialDTO1.getWktString());
			
			ShapeWktEntity tempShapeWktEntity = new ShapeWktEntity(geoSpatialDTO1.getType(),geoSpatialDTO1.getWktString());
			List<KeyValueEntity> tempKeyValArray = new ArrayList<KeyValueEntity>();
			
			for(String[] stringArr:geoSpatialDTO1.getKeyValueArrayList()) {
				KeyValueEntity tempKeyValueEntity = new KeyValueEntity(stringArr[0],stringArr[1]);
				tempKeyValueEntity.setShapeWktEntity(tempShapeWktEntity);
				tempKeyValArray.add(tempKeyValueEntity);
		
				System.out.println("["+stringArr[0]+", "+stringArr[1]+"]");
			}
			tempShapeWktEntity.setKeyValueEntities(tempKeyValArray);
			tempShapeWktEntity.setLayerTable(layer);
			tempShapeWktArray.add(tempShapeWktEntity);
			System.out.println();
		}
		
		layer.setShapeWktEntities(tempShapeWktArray);
		System.out.println(layer);
//		layerTableRepo.save(layer);
		return null;
	}
	
	@GetMapping("/getLayerNames")
	public List<LayerTable> getLayerNames(){
		List<LayerTable> layerTableEntries = layerTableRepo.findAll();
		List<LayerTable> layerTableEntries2 = new ArrayList<>();
		for(LayerTable layerTable : layerTableEntries) {
			layerTableEntries2.add(new LayerTable(layerTable.getId(), layerTable.getLayerName()));
		}
		return layerTableEntries2;
	}

	@GetMapping("/getLayerById/{id}")
	public LayerTable getLayerById(@PathVariable int id) {
		LayerTable layerTable = layerTableRepo.findById(id).get();
		return layerTable;
	}

	@GetMapping("/getLayerByIdUsingCustomQuery/{id}")
	public List<ShapeWithKeyValuesDTO> getShapesAndKeyValuesByLayerTableId(@PathVariable int id) {
        List<Object[]> results = shapeWktEntityRepo.findShapesAndKeyValuesByLayerTableId(id);

        Map<Integer, ShapeWithKeyValuesDTO> shapeMap = results.stream().collect(Collectors.toMap(
            row -> (Integer) row[0], // shapeId
            row -> {
                ShapeWithKeyValuesDTO shapeDTO = new ShapeWithKeyValuesDTO();
                shapeDTO.setShapeId((Integer) row[0]);
                shapeDTO.setType((String) row[1]);
                shapeDTO.setLargeString((String) row[2]);
                shapeDTO.setKeyValues(new ArrayList<>());
                return shapeDTO;
            },
            (existing, replacement) -> existing // handle duplicates if any
        ));

        results.forEach(row -> {
            int shapeId = (Integer) row[0];
            if (row[3] != null) { // check if keyValueId is not null
                ShapeWithKeyValuesDTO.KeyValueDTO keyValueDTO = new ShapeWithKeyValuesDTO.KeyValueDTO();
                keyValueDTO.setId((Integer) row[3]);
                keyValueDTO.setInfokey((String) row[4]);
                keyValueDTO.setValue((String) row[5]);
                shapeMap.get(shapeId).getKeyValues().add(keyValueDTO);
            }
        });

        return new ArrayList<>(shapeMap.values());
    }
	
}

// select * from layer_table;
// select * from shape_wkt_entity;
// select * from key_value_entity;


