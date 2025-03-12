package com.barsat.touch_grass.Service;

import com.barsat.touch_grass.DTO.challengesDTO;
import com.barsat.touch_grass.DTO.challengesMapper;
import com.barsat.touch_grass.Entity.challengesEntity;
import com.barsat.touch_grass.Repository.challengesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class challengesService {

    private final challengesRepo repository;
    private final challengesMapper mapper;

    public List<challengesDTO> getAllChallenges() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public challengesDTO createChallenge(challengesDTO dto) {
        challengesEntity entity = mapper.toEntity(dto);
        challengesEntity savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    public challengesDTO updateChallenge(Long id, challengesDTO dto) {
        dto.setChallengesId(id);
        challengesEntity entity = mapper.toEntity(dto);
        challengesEntity updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
    }

    public void deleteChallenge(Long id) {
        repository.deleteById(id);
    }
}