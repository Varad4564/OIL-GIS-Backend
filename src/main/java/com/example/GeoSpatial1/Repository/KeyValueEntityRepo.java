package com.example.GeoSpatial1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.GeoSpatial1.Entity.KeyValueEntity;

public interface KeyValueEntityRepo extends JpaRepository<KeyValueEntity, Integer>{

}
