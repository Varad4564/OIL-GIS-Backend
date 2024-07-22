package com.example.GeoSpatial1.DTO;

import java.util.List;

public class OuterGeoSpatialDTO {
	
	private String layerName;
	private List<GeoSpatialDTO1> geoSpatialDTO1List;
	
	public String getLayerName() {
		return layerName;
	}
	
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}
	
	public List<GeoSpatialDTO1> getGeoSpatialDTO1List() {
		return geoSpatialDTO1List;
	}
	
	public void setGeoSpatialDTO1List(List<GeoSpatialDTO1> geoSpatialDTO1List) {
		this.geoSpatialDTO1List = geoSpatialDTO1List;
	}
	
	public OuterGeoSpatialDTO(String layerName, List<GeoSpatialDTO1> geoSpatialDTO1List) {
		super();
		this.layerName = layerName;
		this.geoSpatialDTO1List = geoSpatialDTO1List;
	} 
	
	public OuterGeoSpatialDTO() {
		super();
	}

}
