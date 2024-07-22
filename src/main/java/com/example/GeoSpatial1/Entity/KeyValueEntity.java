package com.example.GeoSpatial1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class KeyValueEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String infokey;
	private String value;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonBackReference
	private ShapeWktEntity shapeWktEntity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return infokey;
	}
	public void setKey(String infokey) {
		this.infokey = infokey;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ShapeWktEntity getShapeWktEntity() {
		return shapeWktEntity;
	}
	public void setShapeWktEntity(ShapeWktEntity shapeWktEntity) {
		this.shapeWktEntity = shapeWktEntity;
	}
	public KeyValueEntity(int id, String infokey, String value) {
		super();
		this.id = id;
		this.infokey = infokey;
		this.value = value;
	}
	public KeyValueEntity(String infokey, String value) {
		super();
		this.infokey = infokey;
		this.value = value;
	}
	
	public KeyValueEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KeyValueEntity [id=" + id + ", infokey=" + infokey + ", value=" + value + "]";
	}
}