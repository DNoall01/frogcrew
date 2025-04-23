package edu.tcu.cs.frogcrew.availability.dto;

import jakarta.validation.constraints.NotEmpty;

public record AvailabilityDto(
      @NotEmpty(message = "User id is required") Integer userId,
      @NotEmpty(message = "Game id is required") Integer gameId,
      @NotEmpty(message = "Availability is required") boolean availability,
      String comment) {
}
