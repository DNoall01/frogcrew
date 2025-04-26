package edu.tcu.cs.frogcrew.game;

import edu.tcu.cs.frogcrew.creweduser.CrewedUser;
import edu.tcu.cs.frogcrew.schedule.Schedule;
import jakarta.persistence.*;

import java.time.LocalDateTime;
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

    private LocalDateTime gameDate;

    private String venue;

    private String opponent;

    private boolean finalized = false;

    @ElementCollection
    private List<String> openPositions;


    @OneToMany
    private List<CrewedUser> crewMembers;

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

    public LocalDateTime getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDateTime gameDate) {
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
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }

    public List<CrewedUser> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<CrewedUser> crewMembers) {
        this.crewMembers = crewMembers;
    }
}
