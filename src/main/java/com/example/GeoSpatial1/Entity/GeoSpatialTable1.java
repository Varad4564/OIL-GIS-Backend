package com.example.GeoSpatial1.Entity;

import org.locationtech.jts.geom.Polygon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GeoSpatialTable1 {

	@Id
	@GeneratedValue
	private int id;
	private Polygon polygon;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Polygon getPolygon() {
		return polygon;
	}
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}
	public GeoSpatialTable1(int id, Polygon polygon) {
		super();
		this.id = id;
		this.polygon = polygon;
	}
	public GeoSpatialTable1(Polygon polygon) {
		super();
		this.polygon = polygon;
	}
	public GeoSpatialTable1(int id) {
		super();
		this.id = id;
	}
	public GeoSpatialTable1() {
		super();
	}
}
