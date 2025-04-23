package edu.tcu.cs.frogcrew.game.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record GameDto(Integer gameId,
                      Integer scheduleId,
                      @NotEmpty(message = "Game date is required")LocalDate gameDate,
                      @NotEmpty(message = "Venue is required")String venue,
                      @NotEmpty(message = "Opponent is required")String opponent,
                      @NotEmpty(message = "Is finalized is required")boolean isFinalized) {
}
