package edu.tcu.cs.frogcrew.game.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record GameDto(Integer gameId,
                      Integer scheduleId,
                      @NotNull(message = "Game date is required")LocalDateTime gameDate,
                      @NotEmpty(message = "Venue is required")String venue,
                      @NotEmpty(message = "Opponent is required")String opponent,
                      @NotNull(message = "Is finalized is required")boolean finalized) {
}
