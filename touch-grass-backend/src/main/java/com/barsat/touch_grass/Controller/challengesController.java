package com.barsat.touch_grass.Controller;

import com.barsat.touch_grass.Entity.challengesEntity;
import com.barsat.touch_grass.Service.challengesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
public class challengesController {

    private final challengesService service;

    @GetMapping
    public ResponseEntity<List<challengesEntity>> getAllChallenges() {
        return ResponseEntity.ok(service.getAllChallenges());
    }

    @PostMapping
    public ResponseEntity<challengesEntity> createChallenge(@RequestBody challengesEntity challenge) {
        return ResponseEntity.ok(service.createChallenge(challenge));
    }

    @PutMapping("/{id}")
    public ResponseEntity<challengesEntity> updateChallenge(@PathVariable Long id,
                                                            @RequestBody challengesEntity challenge) {
        return ResponseEntity.ok(service.updateChallenge(id, challenge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable Long id) {
        service.deleteChallenge(id);
        return ResponseEntity.noContent().build();
    }
}