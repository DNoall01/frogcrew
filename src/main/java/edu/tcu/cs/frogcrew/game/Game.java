package edu.tcu.cs.frogcrew.game;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String sport;

    private LocalDateTime gameStart;

    private String venue;

    @ElementCollection
    private List<String> openPositions;

    @OneToMany
    private List<CrewMembers> crewMembers;

}
