package edu.tcu.cs.frogcrew.availability;

import java.io.Serializable;
import java.util.Objects;

public class AvailabilityId implements Serializable {

    private Integer userId;
    private Integer gameId;

    public AvailabilityId() {}

    public AvailabilityId(Integer userId, Integer gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gameId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AvailabilityId other)) return false;
        return Objects.equals(userId, other.userId) && Objects.equals(gameId, other.gameId);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
