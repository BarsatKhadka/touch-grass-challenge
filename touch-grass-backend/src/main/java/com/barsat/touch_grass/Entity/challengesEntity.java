package com.barsat.touch_grass.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class challengesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long challengesId;

    private String challengeName;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime deadline;

    @ElementCollection
    private List<String> participants;

    @Enumerated(EnumType.STRING)
    private ChallengeStatus status;

    @ManyToOne
    private TheUser theUser;


}

@Getter
enum ChallengeStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}