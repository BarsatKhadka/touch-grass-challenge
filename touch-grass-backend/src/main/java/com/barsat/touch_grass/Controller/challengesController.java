package com.barsat.touch_grass.Controller;

import com.barsat.touch_grass.DTO.challengesDTO;
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
    public ResponseEntity<List<challengesDTO>> getAllChallenges() {
        return ResponseEntity.ok(service.getAllChallenges());
    }

    @PostMapping
    public ResponseEntity<challengesDTO> createChallenge(@RequestBody challengesDTO challenge) {
        return ResponseEntity.ok(service.createChallenge(challenge));
    }

    @PutMapping("/{id}")
    public ResponseEntity<challengesDTO> updateChallenge(@PathVariable Long id,
                                                            @RequestBody challengesDTO challenge) {
        return ResponseEntity.ok(service.updateChallenge(id, challenge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable Long id) {
        service.deleteChallenge(id);
        return ResponseEntity.noContent().build();
    }
}