package edu.tcu.cs.frogcrew.availability.dto;

import jakarta.validation.constraints.NotEmpty;

public record AvailabilityScheduleDto(@NotEmpty(message = "User id is required") Integer userId,
                                      @NotEmpty(message = "Schedule id is required") Integer scheduleId,
                                      @NotEmpty(message = "Availability is required") boolean availability,
                                      String comment) {
}
