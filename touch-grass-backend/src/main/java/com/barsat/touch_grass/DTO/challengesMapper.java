package com.barsat.touch_grass.DTO;

import com.barsat.touch_grass.Entity.challengesEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

//A helper class to convert between DTO and Entity.
@Component
public class challengesMapper {

    public challengesDTO toDTO(challengesEntity entity) {
        if (entity == null) return null;

        return new challengesDTO(
            entity.getChallengesId(),
            entity.getChallengeName(),
            entity.getDescription(),
            entity.getCreatedAt(),
            entity.getDeadline(),
            entity.getParticipants() != null ? new ArrayList<>(entity.getParticipants()) : new ArrayList<>()
        );
    }

    public challengesEntity toEntity(challengesDTO dto) {
        if (dto == null) return null;

        challengesEntity entity = new challengesEntity();
        entity.setChallengesId(dto.getChallengesId());
        entity.setChallengeName(dto.getChallengeName());
        entity.setDescription(dto.getDescription());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setDeadline(dto.getDeadline());
        entity.setParticipants(dto.getParticipants() != null ? new ArrayList<>(dto.getParticipants()) : new ArrayList<>());

        return entity;
    }
}