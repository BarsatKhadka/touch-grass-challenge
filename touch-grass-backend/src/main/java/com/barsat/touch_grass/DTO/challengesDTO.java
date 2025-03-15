package com.barsat.touch_grass.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class challengesDTO {

    private Long challengesId;

    private String challengeName;

    private String description;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

    private List<String> participants;
    
    private String status;
    
    public challengesDTO(Long challengesId, String challengeName, String description, 
                         LocalDateTime createdAt, LocalDateTime deadline, List<String> participants) {
        this.challengesId = challengesId;
        this.challengeName = challengeName;
        this.description = description;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.participants = participants;
    }
    
    public challengesDTO(Long challengesId, String challengeName, String description, 
                         LocalDateTime createdAt, LocalDateTime deadline, List<String> participants, String status) {
        this.challengesId = challengesId;
        this.challengeName = challengeName;
        this.description = description;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.participants = participants;
        this.status = status;
    }
}