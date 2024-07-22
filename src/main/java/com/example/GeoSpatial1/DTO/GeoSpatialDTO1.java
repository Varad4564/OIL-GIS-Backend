package com.example.GeoSpatial1.DTO;

import java.util.List;

public class GeoSpatialDTO1 {
	
	private String type;
	private String wktString;
	private List<String[]> keyValueArrayList;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWktString() {
		return wktString;
	}
	public void setWktString(String wktString) {
		this.wktString = wktString;
	}
	public List<String[]> getKeyValueArrayList() {
		return keyValueArrayList;
	}
	public void setKeyValueArrayList(List<String[]> keyValueArrayList) {
		this.keyValueArrayList = keyValueArrayList;
	}
	@Override
	public String toString() {
		return "GeoSpatialDTO1 [type=" + type + ", wktString=" + wktString + ", keyValueArrayList=" + keyValueArrayList
				+ "]";
	}
	public GeoSpatialDTO1(String type, String wktString, List<String[]> keyValueArrayList) {
		super();
		this.type = type;
		this.wktString = wktString;
		this.keyValueArrayList = keyValueArrayList;
	}
	public GeoSpatialDTO1() {
		super();
	}
}
