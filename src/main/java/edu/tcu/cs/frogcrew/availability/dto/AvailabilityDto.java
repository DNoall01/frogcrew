package edu.tcu.cs.frogcrew.availability.dto;

public record AvailabilityDto(
      Integer userId,
      Integer gameId,
      boolean availability,
      String comment) {
}
