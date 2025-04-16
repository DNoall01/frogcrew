package edu.tcu.cs.frogcrew.availability;

import edu.tcu.cs.frogcrew.game.Game;
import edu.tcu.cs.frogcrew.user.User;
import jakarta.persistence.*;

@Entity
public class Availability {

    @EmbeddedId
    private AvailabilityId id;

    @ManyToOne
    @MapsId("userId") // maps to userId in embeddedId
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("gameId") // maps to gameId in embeddedId
    @JoinColumn(name = "game_id")
    private Game game;

    private boolean available;

    private String comment;

    public void submitAvailability() {
    }

    public void editAvailability() {}

    public AvailabilityId getId() {
        return id;
    }

    public void setId(AvailabilityId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
