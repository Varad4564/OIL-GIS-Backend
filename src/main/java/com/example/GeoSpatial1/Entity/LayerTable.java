package com.example.GeoSpatial1.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LayerTable {
	@Id
	@GeneratedValue
	private int id;
	private String layerName;
	@OneToMany(mappedBy = "layerTable", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ShapeWktEntity> shapeWktEntities;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLayerName() {
		return layerName;
	}
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}
	public List<ShapeWktEntity> getShapeWktEntities() {
		return shapeWktEntities;
	}
	public void setShapeWktEntities(List<ShapeWktEntity> shapeWktEntities) {
		this.shapeWktEntities = shapeWktEntities;
	}
	public LayerTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LayerTable(int id, String layerName, List<ShapeWktEntity> shapeWktEntities) {
		super();
		this.id = id;
		this.layerName = layerName;
		this.shapeWktEntities = shapeWktEntities;
	}
	public LayerTable(int id, String layerName) {
		super();
		this.id = id;
		this.layerName = layerName;
	}
	public LayerTable(String layerName, List<ShapeWktEntity> shapeWktEntities) {
		super();
		this.layerName = layerName;
		this.shapeWktEntities = shapeWktEntities;
	}
	public LayerTable(String layerName) {
		super();
		this.layerName = layerName;
	}
	@Override
	public String toString() {
		return "LayerTable [id=" + id + ", layerName=" + layerName + ", shapeWktEntities=" + shapeWktEntities + "]";
	}
}
