package edu.tcu.cs.frogcrew.creweduser;

import edu.tcu.cs.frogcrew.game.Game;
import edu.tcu.cs.frogcrew.position.Position;
import edu.tcu.cs.frogcrew.user.FrogCrewUser;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class CrewedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer crewedUserId;

    private String arrivalTime;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private FrogCrewUser user;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    public Integer getCrewedUserId() {
        return crewedUserId;
    }

    public void setCrewedUserId(Integer crewedUserId) {
        this.crewedUserId = crewedUserId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FrogCrewUser getUser() {
        return user;
    }

    public void setUser(FrogCrewUser user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

