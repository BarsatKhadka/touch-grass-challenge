package com.barsat.touch_grass.Repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barsat.touch_grass.Entity.challengesEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface challengesRepo extends JpaRepository<challengesEntity,Long> {
    
}
