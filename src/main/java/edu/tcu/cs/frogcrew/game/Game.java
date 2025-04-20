package edu.tcu.cs.frogcrew.game;

import edu.tcu.cs.frogcrew.schedule.Schedule;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    private String sport;

    private LocalDate gameDate;

    private String venue;

    private String opponent;

    private boolean isFinalized = false;

    @ElementCollection
    private List<String> openPositions;


    //@OneToMany
    //private List<CrewMember> crewMembers;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public List<String> getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(List<String> openPositions) {
        this.openPositions = openPositions;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean finalized) {
        isFinalized = finalized;
    }
}
