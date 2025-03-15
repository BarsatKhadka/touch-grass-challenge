package com.barsat.touch_grass.Service;

import com.barsat.touch_grass.DTO.challengesDTO;
import com.barsat.touch_grass.DTO.challengesMapper;
import com.barsat.touch_grass.Entity.TheUser;
import com.barsat.touch_grass.Entity.challengesEntity;
import com.barsat.touch_grass.Repository.UserRepo;
import com.barsat.touch_grass.Repository.challengesRepo;
import com.barsat.touch_grass.Utility.GetAuthenticatedUserName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class challengesService {

    private final challengesRepo repository;
    private final challengesMapper mapper;
    private final UserRepo userRepo;
    private final GetAuthenticatedUserName getAuthenticatedUserName;

    public List<challengesDTO> getAllChallenges() {
        String username = getAuthenticatedUserName.getUsername();
        TheUser theUser = userRepo.findByUsername(username);

        return repository.findAllByTheUser(theUser).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public challengesDTO createChallenge(challengesDTO dto) {
        String username = getAuthenticatedUserName.getUsername();
        TheUser theUser = userRepo.findByUsername(username);


        challengesEntity entity = mapper.toEntity(dto);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setTheUser(theUser);
        challengesEntity savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    public challengesDTO updateChallenge(Long id, challengesDTO dto) {

        dto.setChallengesId(id);

        challengesEntity existingEntity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Challenge not found with id: " + id));

        
        challengesEntity entity = mapper.toEntity(dto);
        entity.setCreatedAt(existingEntity.getCreatedAt());
        entity.setTheUser(existingEntity.getTheUser());
        challengesEntity updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
    }

    public void deleteChallenge(Long id) {
        repository.deleteById(id);
    }
}