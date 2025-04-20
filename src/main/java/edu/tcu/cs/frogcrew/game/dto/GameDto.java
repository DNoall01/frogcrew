package edu.tcu.cs.frogcrew.game.dto;

import java.time.LocalDate;

public record GameDto(Integer gameId,
                      Integer scheduleId,
                      LocalDate gameDate,
                      String venue,
                      String opponent,
                      boolean isFinalized) {
}
