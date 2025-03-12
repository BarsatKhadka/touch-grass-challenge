package com.barsat.touch_grass.Service;

import com.barsat.touch_grass.Entity.challengesEntity;
import com.barsat.touch_grass.Repository.challengesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class challengesService {

    private final challengesRepo repository;

    public challengesService(challengesRepo repository) {
        this.repository = repository;
    }

    public List<challengesEntity> getAllChallenges() {
        return repository.findAll();
    }

    public challengesEntity createChallenge(challengesEntity challenge) {
        return repository.save(challenge);
    }

    public challengesEntity updateChallenge(Long id, challengesEntity challenge) {
        challenge.setChallengesId(id);
        return repository.save(challenge);
    }

    public void deleteChallenge(Long id) {
        repository.deleteById(id);
    }
}