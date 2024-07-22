package com.example.GeoSpatial1.DTO;

import java.util.List;

public class ShapeWithKeyValuesDTO {
    private int shapeId;
    private String type;
    private String largeString;
    private List<KeyValueDTO> keyValues;

    // getters and setters
    public int getShapeId() {
		return shapeId;
	}
	public void setShapeId(int shapeId) {
		this.shapeId = shapeId;
	}
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLargeString() {
		return largeString;
	}
	public void setLargeString(String largeString) {
		this.largeString = largeString;
	}
	public List<KeyValueDTO> getKeyValues(){
		return keyValues;
	}
	public void setKeyValues(List<KeyValueDTO> keyValues){
		this.keyValues = keyValues;
	}
	
	
    public static class KeyValueDTO {
        
		private int id;
        private String infokey;
        private String value;

        // getters and setters
        public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getInfokey() {
			return infokey;
		}
		public void setInfokey(String infokey) {
			this.infokey = infokey;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
    }
}

