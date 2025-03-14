package com.barsat.touch_grass.Repository;

import com.barsat.touch_grass.Entity.TheUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<TheUser, Integer> {

    TheUser findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
