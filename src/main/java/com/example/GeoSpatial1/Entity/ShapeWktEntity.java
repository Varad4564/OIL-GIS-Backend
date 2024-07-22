package com.example.GeoSpatial1.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class ShapeWktEntity {

    @Id
    @GeneratedValue
    private int id;
    private String type;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String largeString;

    @OneToMany(mappedBy = "shapeWktEntity", cascade = CascadeType.ALL)
//    @JsonManagedReference
    private List<KeyValueEntity> keyValueEntities;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private LayerTable layerTable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLargeString() {
		return largeString;
	}

	public void setLargeString(String largeString) {
		this.largeString = largeString;
	}

	public List<KeyValueEntity> getKeyValueEntities() {
		return keyValueEntities;
	}

	public void setKeyValueEntities(List<KeyValueEntity> keyValueEntities) {
		this.keyValueEntities = keyValueEntities;
	}

	public LayerTable getLayerTable() {
		return layerTable;
	}

	public void setLayerTable(LayerTable layerTable) {
		this.layerTable = layerTable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ShapeWktEntity [id=" + id + ", type=" + type + ", largeString=" + largeString + ", keyValueEntities="
				+ keyValueEntities + "]";
	}

	public ShapeWktEntity(int id, String type, String largeString, List<KeyValueEntity> keyValueEntities,
			LayerTable layerTable) {
		super();
		this.id = id;
		this.type = type;
		this.largeString = largeString;
		this.keyValueEntities = keyValueEntities;
		this.layerTable = layerTable;
	}

	public ShapeWktEntity(String type, String largeString, List<KeyValueEntity> keyValueEntities,
			LayerTable layerTable) {
		super();
		this.type = type;
		this.largeString = largeString;
		this.keyValueEntities = keyValueEntities;
		this.layerTable = layerTable;
	}

	public ShapeWktEntity(String type, String largeString) {
		super();
		this.type = type;
		this.largeString = largeString;
	}
	
	public ShapeWktEntity() {
		super();
	}
    
}
