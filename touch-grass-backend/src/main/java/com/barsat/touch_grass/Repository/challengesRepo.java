package com.barsat.touch_grass.Repository;

import com.barsat.touch_grass.Entity.TheUser;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barsat.touch_grass.Entity.challengesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface challengesRepo extends JpaRepository<challengesEntity,Long> {
    List<challengesEntity> findAllByTheUser(TheUser theUser);
    
}
