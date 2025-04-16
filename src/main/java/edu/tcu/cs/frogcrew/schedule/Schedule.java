package edu.tcu.cs.frogcrew.schedule;

import edu.tcu.cs.frogcrew.game.Game;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String sport;

    private Date season;

    @OneToMany
    private List<Game> games;

    public void createSchedule() {}

    public void viewSchedule() {}

    public void publishSchedule() {}

}
