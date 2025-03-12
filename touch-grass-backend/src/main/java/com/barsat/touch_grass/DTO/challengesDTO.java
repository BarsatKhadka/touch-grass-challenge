package com.barsat.touch_grass.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class challengesDTO {

    private Long challengesId;

    private String challengeName;

    private String description;


    private LocalDateTime createdAt;


    private LocalDateTime deadline;

    private List<String> participants;

}