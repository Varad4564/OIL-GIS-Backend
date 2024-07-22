package com.example.GeoSpatial1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.GeoSpatial1.Entity.ShapeWktEntity;

public interface ShapeWktEntityRepo extends JpaRepository<ShapeWktEntity, Integer>{

	@Query(value = "SELECT s.id, s.type, s.large_string, k.id, k.infokey, k.value " +
            "FROM shape_wkt_entity s " +
//            "JOIN LayerTable l ON l.id = s.layerTable_id " +
            "LEFT JOIN key_value_entity k ON k.shape_wkt_entity_id = s.id " +
            "WHERE s.layer_table_id = :layerTableId", nativeQuery = true)
	List<Object[]> findShapesAndKeyValuesByLayerTableId(@Param("layerTableId") int layerTableId);
}
