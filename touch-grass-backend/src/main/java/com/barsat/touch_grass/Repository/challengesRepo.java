package com.barsat.touch_grass.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barsat.touch_grass.Entity.challengesEntity;

public interface challengesRepo extends JpaRepository<Long, challengesEntity> {
    
}
